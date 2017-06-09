/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author Mouna
 */
public class Credit {
    
   private int idCredit;
   private double mensualite, mtrestant, mttotal;
   
   
    public Credit() {
    }

    public Credit(int idCredit, double mensualite, double mtrestant, double mttotal) {
        this.idCredit = idCredit;
        this.mensualite = mensualite;
        this.mtrestant = mtrestant;
        this.mttotal = mttotal;
    }

    public int getIdCredit() {
        return idCredit;
    }

    public void setIdCredit(int idCredit) {
        this.idCredit = idCredit;
    }

    public double getMensualite() {
        return mensualite;
    }

    public void setMensualite(double mensualite) {
        this.mensualite = mensualite;
    }

    public double getMtrestant() {
        return mtrestant;
    }

    public void setMtrestant(double mtrestant) {
        this.mtrestant = mtrestant;
    }

    public double getMttotal() {
        return mttotal;
    }

    public void setMttotal(double mttotal) {
        this.mttotal = mttotal;
    }

    @Override
    public String toString() {
        return "Credit{" + "idCredit=" + idCredit + ", mensualite=" + mensualite + ", mtrestant=" + mtrestant + ", mttotal=" + mttotal + '}';
    }
   
   
           
        
}
