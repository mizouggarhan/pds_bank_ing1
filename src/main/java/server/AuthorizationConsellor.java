/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import beans.Customer;
import beans.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.Document;
import org.jdom2.Element;
import server.database.Database;

/**
 *
 * @author Mouna
 */
public class AuthorizationConsellor extends AuthorizationState {

    public AuthorizationConsellor(HandleClient context) {
        super(context);
        System.out.println("Concidered As Counsellor");
    }

    @Override
    public User login(String login, String password) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {

        try {
            // accès à la base
            Connection con = null;
            String query = "à specifier";
            PreparedStatement st = con.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            Element root = new Element("rootElement");
            while (rs.next()) {
                ResultSetMetaData columns = rs.getMetaData();
                for (int i = 1; i <= columns.getColumnCount(); i++) {
                    createChildElement(rs, columns.getColumnName(i), columns.getColumnName(i), root);
                }
            }
            this.context.sendMessage("sendAllClient");
            /*this.context.sendMessage(// ici tu dois envoyer le xml generer ... );*/

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Caint access to database");
        }

        // recuperer tous les clients
        // mettre tous les clients dans un XML/JSON
        // envoyer le json
        return null;
    }

    public void createChildElement(ResultSet rs, String rsNameValue, String nameAttribut, Element root) throws SQLException {
        Element element = new Element(nameAttribut);
        element.setText(rs.getString(rsNameValue));
        root.addContent(element);
    }

    @Override
    public List<Customer> getAllClients() {
        try {
            String query = "SELECT  * FROM CLIENT_BANK";
            ResultSet rs = this.context.connection.createStatement().executeQuery(query);
            List<Customer> customers = new ArrayList<>();
            while(rs.next()){
                Customer c = new Customer();
                c.setIdClient(rs.getInt("idclient"));
                c.setCodePostale(rs.getInt("codepostale"));
                c.setNom(rs.getString("nom"));
                c.setPrenom(rs.getString("prenom"));
                c.setDateNaissance(rs.getTimestamp("datenaissance"));
                c.setAdresse(rs.getString("adresse"));
                c.setSalaire(rs.getInt("salaire"));
                c.setSexe(rs.getString("sexe"));
                customers.add(c);
            }
            return customers;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}
