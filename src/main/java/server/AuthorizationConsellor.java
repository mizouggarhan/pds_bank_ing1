/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import beans.Assurance;
import beans.Credit;
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

    public AuthorizationConsellor(HandleClient context, User user) {
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
         

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Caint access to database");
        }

        
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
            String query = "SELECT  * FROM client_bank";
            ResultSet rs = this.context.connection.createStatement().executeQuery(query);
            
            PreparedStatement st =  this.context.connection.prepareStatement("SELECT * FROM assurance where idassurance = ?");
            PreparedStatement stC =  this.context.connection.prepareStatement("SELECT * FROM credit where idclient = ?");
            
            
            List<Customer> customers = new ArrayList<>();
            while(rs.next()){
                Credit credit = null;
                Assurance assurance = null;
                Customer c = new Customer();
                
                c.setIdClient(rs.getInt("idclient"));
                c.setCodePostale(rs.getInt("codepostale"));
                c.setNom(rs.getString("nom"));
                c.setPrenom(rs.getString("prenom"));
                c.setDateNaissance(rs.getTimestamp("datenaissance"));
                c.setAdresse(rs.getString("adresse"));
                c.setSalaire(rs.getInt("salaire"));
                c.setSexe(rs.getString("sexe"));
                int jointureAssurance = rs.getInt("id_assurance");
                st.setInt(1, jointureAssurance);
                ResultSet rsAs = st.executeQuery();
                if(rsAs.next()){
                    assurance = new Assurance();
                    assurance.setMontant(rsAs.getDouble("montant"));
                    assurance.setIdAssurance(rsAs.getInt("idassurance"));
                    assurance.setDateCreation(rsAs.getTimestamp("datecreation"));
                    assurance.setType(rsAs.getString("type"));
                    assurance.setLibelle(rsAs.getString("libelle"));
                }
                
                stC.setInt(1, c.getIdClient());
                ResultSet rsC = stC.executeQuery();
                if(rsC.next()){
                    credit = new Credit();
                    credit.setIdCredit(rsC.getInt("idcredit"));
                    credit.setMensualite(rsC.getDouble("mensualite"));
                    credit.setMtrestant(rsC.getDouble("mtrestant"));
                    credit.setMttotal(rsC.getDouble("mttotal"));
                }
                
                c.setCredit(credit);
                c.setAssurance(assurance);
                customers.add(c);
            }
            return customers;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}
