/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.sql.Timestamp;

/**
 *
 * @author Mouna
 */
public class User {
  
    private int idUser;
    
    private String nomDuCompte, password, questionSecrete, reponseSecrete, role;
    
    private Timestamp dateCreation;

    public User() {
    }

    public User(int idUser, String nomDuCompte, String password, String questionSecrete, String reponseSecrete, String role, Timestamp dateCreation) {
        this.idUser = idUser;
        this.nomDuCompte = nomDuCompte;
        this.password = password;
        this.questionSecrete = questionSecrete;
        this.reponseSecrete = reponseSecrete;
        this.role = role;
        this.dateCreation = dateCreation;
    }

    
    
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNomDuCompte() {
        return nomDuCompte;
    }

    public void setNomDuCompte(String nomDuCompte) {
        this.nomDuCompte = nomDuCompte;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getQuestionSecrete() {
        return questionSecrete;
    }

    public void setQuestionSecrete(String questionSecrete) {
        this.questionSecrete = questionSecrete;
    }

    public String getReponseSecrete() {
        return reponseSecrete;
    }

    public void setReponseSecrete(String reponseSecrete) {
        this.reponseSecrete = reponseSecrete;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Timestamp getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Timestamp dateCreation) {
        this.dateCreation = dateCreation;
    }

    @Override
    public String toString() {
        return "User{" + "idUser=" + idUser + ", nomDuCompte=" + nomDuCompte + ", password=" + password + ", questionSecrete=" + questionSecrete + ", reponseSecrete=" + reponseSecrete + ", role=" + role + ", dateCreation=" + dateCreation + '}';
    }
    

    
    
    
}
