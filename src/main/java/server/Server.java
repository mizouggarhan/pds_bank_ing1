/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mouna
 */
public class Server extends Thread {

    
    private ServerSocket serverSocket;
    private List<HandleClient> handlers;
    private static int PORT = 8890;
    private BufferedReader read;
    private PrintWriter write;
    private boolean running;

    public Server() {
        this.handlers = new ArrayList<>();
    }

    
    
    @Override
    public synchronized void start() {
        try {
            this.serverSocket = new ServerSocket(PORT);
            this.running = true;
        } catch (IOException ex) {
            this.running = false;
            ex.printStackTrace();
        }
        super.start();
    }

    @Override
    public void run() {
        while (running == true) {
            try {
                System.out.println("En attente d'un nouveau client");
                Socket socket = serverSocket.accept();
                HandleClient handleClient = new HandleClient(socket);
                this.handlers.add(handleClient);
                handleClient.start();
                
            } catch (IOException ex) {
                System.out.println("il y a une erreur");
            }

        }
    }

    
    
    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }
}
