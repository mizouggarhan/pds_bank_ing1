/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import beans.Customer;
import beans.User;
import java.util.List;

/**
 *
 * @author Mouna
 */
public abstract class AuthorizationState {
    
    protected HandleClient context; 

    public AuthorizationState(HandleClient context) {
        this.context = context;
    }
    
    
    public abstract User login(String login, String password);
    public abstract List<User> getAllUsers();
    public abstract List<Customer> getAllClients();
    
}
