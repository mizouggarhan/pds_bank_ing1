

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.views;

import client.Client;

/**
 *
 * @author Mouna
 */
public class FormSingleton {
    
    
    private static LoginForm loginForm;
    private static FormListClients formListClients;
    private static Formulaire_ISF1 formulaire_ISF1;
    
    public static LoginForm getLoginForm(Client client){
        if(loginForm == null)
            loginForm = new LoginForm(client);
        return loginForm;
    }
    
    public static void disposeLoginForm(){
        if(loginForm != null){
            loginForm.dispose();
            loginForm = null;
        }
    }
    
    public static boolean ifInstanciedLoginForm(){
        return loginForm == null;
    }
    
    /**
     * 
     * 
     * 
     * 
     * 
     * 
     */
    
    public static FormListClients getListClientForm(Client client){
        if(formListClients == null)
            formListClients = new FormListClients(client);
        return formListClients;
    }
    
    public static void disposeListClientForm(){
        if(formListClients != null){
            formListClients.dispose();
            formListClients = null;
        }
    }
    
    public static boolean ifInstanciedListClientForm(){
        return formListClients == null;
    }
    
    /**
     * 
     * 
     * 
     * 
     * 
     * 
     */
    
    public static Formulaire_ISF1 getListISF1Form(Client client){
        if(formulaire_ISF1 == null)
            formulaire_ISF1 = new Formulaire_ISF1(client);
        return formulaire_ISF1;
    }
    
    public static void disposeListISF1Form(){
        if(formulaire_ISF1 != null){
            formulaire_ISF1.dispose();
            formulaire_ISF1 = null;
        }
    }
    
    public static boolean ifInstanciedListISF1Form(){
        return formulaire_ISF1 == null;
    }
    
    
}
