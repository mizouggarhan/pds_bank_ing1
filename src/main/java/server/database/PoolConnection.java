/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.database;

import java.sql.Connection;

/**
 *
 * @author Mouna
 */
public class PoolConnection {
    
    
    
    public static void main(String[] args) throws InterruptedException {
        
        int i =1;
        
        Database.pullConnection();
        System.out.println(i);
        i++;
        
        Database.pullConnection();
        System.out.println(i);
        i++;
        
        Database.pullConnection();
        System.out.println(i);
        i++;
        
        Database.pullConnection();
        System.out.println(i);
        i++;
        
        Database.pullConnection();
        System.out.println(i);
        i++;
        
        Database.pullConnection();
        System.out.println(i);
        i++;
        
        Database.pullConnection();
        System.out.println(i);
        i++;
        
        Database.pullConnection();
        System.out.println(i);
        i++;
        
        Database.pullConnection();
        System.out.println(i);
        i++;
        
        Connection c = Database.pullConnection();
        System.out.println(i);
        i++;
        
        Database.putConnection(c);
        
        Database.pullConnection();
        System.out.println(i);
        i++;
        
    }
    
}

