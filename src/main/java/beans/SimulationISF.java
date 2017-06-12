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
public class SimulationISF {

    private double valeur_rp, valeur_apb, valeur_dettes, valeur_pme, valeur_don, valeur_assurance, valeur_credit;


    public SimulationISF() {
    }

    public SimulationISF(double valeur_rp, double valeur_apb, double valeur_dettes, double valeur_pme, double valeur_don, double valeur_assurance, double valeur_credit) {
        this.valeur_rp = valeur_rp;
        this.valeur_apb = valeur_apb;
        this.valeur_dettes = valeur_dettes;
        this.valeur_pme = valeur_pme;
        this.valeur_don = valeur_don;
        this.valeur_assurance = valeur_assurance;
        this.valeur_credit = valeur_credit;
       
        
        
        
    }

    

    public double calculatePatrimoineTaxable() {
        return this.valeur_rp * 0.7 + this.valeur_apb + this.valeur_assurance - this.valeur_dettes - this.valeur_credit - (this.valeur_don*0.5) - (this.valeur_pme*0.5);
    }

    public double getMtTotal() {
        return this.calculatePatrimoineTaxable() - (this.valeur_pme*0.5) - (this.valeur_don*0.5);
    }

    public boolean shouldBeImposable() {
        return this.calculatePatrimoineTaxable() < 1300000;
    }

    public double getISF() {
        double futurin7 = calculatePatrimoineTaxable();
        
          if (futurin7 >= 1300000 && futurin7 < 2570000) {
            return (futurin7 * 0.7 / 100) - 6600 ;

        } else if (futurin7 >= 2570000 && futurin7 < 5000000) {
            return (futurin7 * 0.01) - 14310 ;

        } else if (futurin7 >= 5000000 && futurin7 < 10000000) {
            return (futurin7 * 0.0125) - 26810 ;

        } else {
            return (futurin7 * 0.015) - 51810 ;
        }
    }

    public double getTauxTaxable() {
        double futurin7 = calculatePatrimoineTaxable();
        if (futurin7 >= 1300000 && futurin7 < 2570000) {
            return 0.7;

        } else if (futurin7 >= 2570000 && futurin7 < 5000000) {
            return 1;

        } else if (futurin7 >= 5000000 && futurin7 < 10000000) {
            return 1.25;

        } else {
            return 1.5;
        }
    }

    public double getMtDeductible() {
        double futurin7 = calculatePatrimoineTaxable();
        if (futurin7 >= 1300000 && futurin7 < 2570000) {
            return 6600;

        } else if (futurin7 >= 2570000 && futurin7 < 5000000) {
            return 14310;

        } else if (futurin7 >= 5000000 && futurin7 < 10000000) {
            return 26810;

        } else {
            return 51810;
        }
    }
    
    public double getValeur_rp() {
        return valeur_rp;
    }

    public void setValeur_rp(double valeur_rp) {
        this.valeur_rp = valeur_rp;
    }

    public double getValeur_apb() {
        return valeur_apb;
    }

    public void setValeur_apb(double valeur_apb) {
        this.valeur_apb = valeur_apb;
    }

    public double getValeur_dettes() {
        return valeur_dettes;
    }

    public void setValeur_dettes(double valeur_dettes) {
        this.valeur_dettes = valeur_dettes;
    }

    public double getValeur_pme() {
        return valeur_pme;
    }

    public void setValeur_pme(double valeur_pme) {
        this.valeur_pme = valeur_pme;
    }

    public double getValeur_don() {
        return valeur_don;
    }

    public void setValeur_don(double valeur_don) {
        this.valeur_don = valeur_don;
    }
 public double getValeur_assurance() {
        return valeur_assurance;
    }

    public void setValeur_assurance(double valeur_assurance) {
        this.valeur_assurance = valeur_assurance;
    }
     public double getValeur_credit() {
        return valeur_credit;
    }

    public void setValeur_credit(double valeur_credit) {
        this.valeur_credit = valeur_credit;
    }
    
}

