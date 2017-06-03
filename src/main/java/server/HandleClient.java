/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import beans.Customer;
import beans.SimulationISF;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import server.database.Database;

/**
 *
 * @author Mouna
 */
public class HandleClient extends Thread {

    protected AuthorizationState authorizationState;
    protected Connection connection;
    protected boolean running;
    protected Socket socket;
    protected BufferedReader in;
    protected PrintWriter out;

    

    public HandleClient(Socket socket) {
        this.socket = socket;
    }

    @Override
    public synchronized void start() {
        try {
            this.out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
            this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.authorizationState = new AuthorizationUnknown(this);

            this.running = true;
        } catch (Exception e) {
            this.running = false;
        }
        super.start();
    }

    @Override
    public void run() {
        try {
            this.connection = Database.pullConnection();
            String message = null;
            ObjectMapper mapper = new ObjectMapper();
            while ((message = this.readLine()) != null && running) {
                try {
                    System.out.println("askAuthentification : " + message);
                    switch (message) {
                        case "askAuthentification":
                            String login = this.readLine();
                            String password = this.readLine();
                            this.authorizationState.login(login, password);
                            break;

                        case "askListClients":
                            System.out.println("askAuthentification");
                            this.authorizationState.getAllUsers();
                            break;

                        case "askForClients":
                            
                            List<Customer> customers = this.authorizationState.getAllClients();
                            sendMessage("responseAllClients");
                            sendMessage(mapper.writeValueAsString(customers));
                            break;

                        case "sendISFSimulation":
                            String IFSSim = this.readLine();
                            mapper = new ObjectMapper();
                            SimulationISF simulationISF = mapper.readValue(IFSSim, SimulationISF.class);
                            PreparedStatement ps = this.connection.prepareStatement("INSERT INTO SIMULATION_IDS (valeur_rp, valeur_apb, valeur_dettes, valeur_pme, valeur_don, valeur_assurance, valeur_credit) VALUES (?, ?, ?, ?, ?, ?, ?)");
                            ps.setDouble(1, simulationISF.getValeur_rp());
                            ps.setDouble(2, simulationISF.getValeur_apb());
                            ps.setDouble(3, simulationISF.getValeur_dettes());
                            ps.setDouble(4, simulationISF.getValeur_pme());
                            ps.setDouble(5, simulationISF.getValeur_don());
                            ps.setDouble(6, simulationISF.getValeur_assurance());
                            ps.setDouble(7, simulationISF.getValeur_credit());
                            
                     
                            ps.execute();
                            break;
                            
                        default:
                            this.sendMessage("unknownMessage");
                            break;
                    }

                } catch (Exception e) {
                    this.running = false;
                    e.printStackTrace();
                }
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(HandleClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean sendMessage(String message) {
        try {
            this.out.println(message);
            System.out.println("[S] : " + message);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
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
            ex.printStackTrace();
            return null;
        }
    }

    public void setAuthorizationState(AuthorizationState authorizationState) {
        this.authorizationState = authorizationState;
    }
}
