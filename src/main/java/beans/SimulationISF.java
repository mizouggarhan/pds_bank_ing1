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

    private double valeur_rp, valeur_apb, valeur_dettes, valeur_pme, valeur_don;


    public SimulationISF() {
    }

    public SimulationISF(double valeur_rp, double valeur_apb, double valeur_dettes, double valeur_pme, double valeur_don) {
        this.valeur_rp = valeur_rp;
        this.valeur_apb = valeur_apb;
        this.valeur_dettes = valeur_dettes;
        this.valeur_pme = valeur_pme;
        this.valeur_don = valeur_don;
    }

    

    public double calculatePatrimoineTaxable() {
        return this.valeur_rp * 0.7 + this.valeur_apb - this.valeur_dettes;
    }

    public double getMtTotal() {
        return this.calculatePatrimoineTaxable() - this.valeur_pme - this.valeur_don;
    }

    public boolean shouldBeImposable() {
        return this.calculatePatrimoineTaxable() < 1300000;
    }

    public double getISF() {
        double futurin4 = calculatePatrimoineTaxable();
        if (futurin4 >= 1300000 && futurin4 < 2570000) {
            return futurin4 * 0.7 / 100 - 6600 - this.valeur_pme - this.valeur_don;

        } else if (futurin4 >= 2570000 && futurin4 < 5000000) {
            return futurin4 * 0.01 - 14310 - this.valeur_pme - this.valeur_don;

        } else if (futurin4 >= 5000000 && futurin4 < 10000000) {
            return futurin4 * 0.0125 - 26810 - this.valeur_pme - this.valeur_don;

        } else {
            return futurin4 * 0.015 - 51810 - this.valeur_pme - this.valeur_don;
        }
    }

    public double getTauxTaxable() {
        double futurin4 = calculatePatrimoineTaxable();
        if (futurin4 >= 1300000 && futurin4 < 2570000) {
            return 0.7;

        } else if (futurin4 >= 2570000 && futurin4 < 5000000) {
            return 1;

        } else if (futurin4 >= 5000000 && futurin4 < 10000000) {
            return 1.25;

        } else {
            return 1.5;
        }
    }

    public double getMtDeductible() {
        double futurin4 = calculatePatrimoineTaxable();
        if (futurin4 >= 1300000 && futurin4 < 2570000) {
            return 6600;

        } else if (futurin4 >= 2570000 && futurin4 < 5000000) {
            return 14310;

        } else if (futurin4 >= 5000000 && futurin4 < 10000000) {
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

    
}

