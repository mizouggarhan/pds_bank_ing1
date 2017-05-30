/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import beans.Customer;
import beans.User;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Mouna
 */
public class AuthorizationUnknown extends AuthorizationState {

    public AuthorizationUnknown(HandleClient context) {
        super(context);
        System.out.println("Concidered As Unknown");
    }

    @Override
    public User login(String login, String password) {
        // access à la BD
        // user exist in database
        if(login.trim().equalsIgnoreCase("mouna") && password.trim().equalsIgnoreCase("123456")){
            this.context.sendMessage("authentificationAuthorized");
            this.context.setAuthorizationState(new AuthorizationConsellor(context));
            return new User();
            
        }else{
            this.context.sendMessage("authentificationRefused");
            return null;
        }
    }

    
    
    @Override
    public List<User> getAllUsers() {
        this.context.sendMessage("permissionDenied");
        return null;
    }

    @Override
    public List<Customer> getAllClients() {
        this.context.sendMessage("permissionDenied");
        return null;
    }
    
}
