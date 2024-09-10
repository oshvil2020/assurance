package org.example;

import java.text.DecimalFormat;

/**
 * Classe qui modélise un soin
 */
public class Soin {
    private final int soin;
    private String date;
    private String montant;


    public Soin(int soin, String date, String montant, String typeContrat,
                TypeA a, TypeB b, TypeC c, TypeD d, TypeE e) {
        this.date = date;
        this.soin = soin;

        if (montant.equals("Données invalides") || typeContrat.equals("Données invalides") || soin == -1) {
            this.montant = "Données invalides";
        } else {

            CalculRemboursement calc = new CalculRemboursement(typeContrat, soin,montant, a,b,c,d,e);
            DecimalFormat df = new DecimalFormat("0.00");
            String formatte = df.format(calc.getRemboursement());
            this.montant = formatte + "$";

        }
    }

    public int getSoin() {
        return soin;
    }

    public String getMontant() {
        return this.montant;
    }

}