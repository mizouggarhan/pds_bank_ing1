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
public class Customer {
    
    private int idClient, codePostale, salaire;
    
    private String nom, prenom, adresse, sexe;
            
    private Timestamp dateNaissance;

    private Assurance assurance;
    private Credit credit;
    
    
    public Customer() {
    }

    
    public Customer(int idClient, int codePostale, int salaire, String nom, String prenom, String adresse, String sexe, Timestamp dateNaissance) {
        this.idClient = idClient;
        this.codePostale = codePostale;
        this.salaire = salaire;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.sexe = sexe;
        this.dateNaissance = dateNaissance;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getCodePostale() {
        return codePostale;
    }

    public void setCodePostale(int codePostale) {
        this.codePostale = codePostale;
    }

    public int getSalaire() {
        return salaire;
    }

    public void setSalaire(int salaire) {
        this.salaire = salaire;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public Timestamp getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Timestamp dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Assurance getAssurance() {
        return assurance;
    }

    public void setAssurance(Assurance assurance) {
        this.assurance = assurance;
    }

    public Credit getCredit() {
        return credit;
    }

    public void setCredit(Credit credit) {
        this.credit = credit;
    }

    
    
    
    
    @Override
    public String toString() {
        return "Customer{" + "idClient=" + idClient + ", codePostale=" + codePostale + ", salaire=" + salaire + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", sexe=" + sexe + ", dateNaissance=" + dateNaissance + '}';
    }
    
    
    
}

