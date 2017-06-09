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
public class Assurance {
    
    private int idAssurance;
    private String libelle;
    private String type;
    private double montant;
    private Timestamp dateCreation;

    public Assurance(int idAssurance, String libelle, String type, double montant, Timestamp dateCreation) {
        this.idAssurance = idAssurance;
        this.libelle = libelle;
        this.type = type;
        this.montant = montant;
        this.dateCreation = dateCreation;
    }

    public Assurance() {
    }

    public Timestamp getDateCreation() {
        return dateCreation;
    }

    public int getIdAssurance() {
        return idAssurance;
    }

    public String getLibelle() {
        return libelle;
    }

    public double getMontant() {
        return montant;
    }

    public String getType() {
        return type;
    }

    public void setDateCreation(Timestamp dateCreation) {
        this.dateCreation = dateCreation;
    }

    public void setIdAssurance(int idAssurance) {
        this.idAssurance = idAssurance;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Assurance{" + "idAssurance=" + idAssurance + ", libelle=" + libelle + ", type=" + type + ", montant=" + montant + ", dateCreation=" + dateCreation + '}';
    }

    
    
    
    
}
