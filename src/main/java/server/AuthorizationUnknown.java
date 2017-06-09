/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import beans.Customer;
import beans.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        try {
            // access à la BD
            // user exist in database
            PreparedStatement ps = this.context.connection.prepareStatement("SELECT * FROM account where ndc=? and psw=?");
            ps.setString(1, login);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                User user = new User();
                this.context.sendMessage("authentificationAuthorized");
                this.context.setAuthorizationState(new AuthorizationConsellor(context, user));
                System.out.println("User found");
                return user;
            } else {
                throw new Exception("no user found");
            }
        } catch (Exception ex) {
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
