/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import beans.Customer;
import beans.SimulationISF;
import client.views.FormSingleton;
import client.views.MDIForm;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Mouna
 */
public class Client extends Thread {

    public static int port;
    public static String host;

    protected boolean running;
    protected Socket socket;
    protected BufferedReader in;
    protected PrintWriter out;

    protected MDIForm form;
    
    protected Customer[] customers;

    public Client(int port, String host, MDIForm form) {
        this.port = port;
        this.host = host;
        this.form = form;
    }

    @Override
    public synchronized void start() {
        try {
            this.socket = new Socket(host, port);
            this.out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
            this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.running = true;
        } catch (Exception e) {
            e.printStackTrace();
            this.running = false;
        }
        super.start();
    }

    public boolean sendMessage(String message) {
        try {
            this.out.println(message);
            System.out.println("[S] : " + message);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String readLine() {
        try {
            System.out.println("Attente message");
            String message = this.in.readLine();
            System.out.println("[R] : " + message);
            return message;
        } catch (IOException ex) {
            return null;
        }
    }

    @Override
    public void run() {
        String message = null;
        while ((message = this.readLine()) != null && running) {
            switch (message) {
                case "authentificationAuthorized":
                    FormSingleton.disposeLoginForm();
                    JOptionPane.showMessageDialog(null, "Vous etes connecté");
                    this.form.setMenuConsulor();
                    break;

                case "authentificationRefused":
                    JOptionPane.showMessageDialog(null, "Une ou plusieurs informations ne sont pas correctes");
                    break;

                case "responseAllClients":
                    String jsonAllCustomer = readLine();
                    ObjectMapper mapper = new ObjectMapper();
                    try {
                        this.customers = mapper.readValue(jsonAllCustomer, Customer[].class);
                    } catch (IOException ex) {
                        Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    break;

                default:
                    break;
            }
        }
    }

    public Customer[] getCustomers() {
        return customers;
    }

    public MDIForm getForm() {
        return form;
    }
    
    

    public void askForClients() {
        sendMessage("askForClients");
    }

    public void sendSimulationISF(SimulationISF simulationISF) throws JsonProcessingException {
        sendMessage("sendISFSimulation");
        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibilityChecker(mapper.getSerializationConfig().getDefaultVisibilityChecker()
                .withFieldVisibility(JsonAutoDetect.Visibility.ANY)
                .withGetterVisibility(JsonAutoDetect.Visibility.NONE)
                .withSetterVisibility(JsonAutoDetect.Visibility.NONE)
                .withVisibility(PropertyAccessor.CREATOR, JsonAutoDetect.Visibility.NONE)
                .withCreatorVisibility(JsonAutoDetect.Visibility.NONE));
        
        sendMessage(mapper.writeValueAsString(simulationISF));
    }

}
