/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Mouna
 */
public class UnknownHandler extends HandleClient {

    public UnknownHandler(Socket socket) throws IOException {
        super(socket);
    }

    @Override
    public void run() {
        String message = null;

        while (running) {
            switch( message  = this.readLine() ){
                
                case "askAuthentification" : 
                    
                    break;
                    
                default :
                    this.running = false;
                    break;
            }
        }
    }
    
    
    
    
    
}
