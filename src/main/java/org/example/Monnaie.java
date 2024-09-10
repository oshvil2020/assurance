package org.example;
import java.text.DecimalFormat;

/**
 * Cette classe implémente un objet Monnaie pour faire des opération arithmétique seulement sur des types primitifs (int)
 * lorsqu'il est question de montant d'argent pour éviter la perte de précision.
 *  */

public class Monnaie {
    public int convertirDollarsACent(double dollars){
        double montant = dollars * 100;
        return (int) montant;
    }
    public int multiplication(int nombre1, int nombre2) {
        return (nombre1 * nombre2);
    }
    public int divisionEntiere(int nombre1, int nombre2) {
        return (nombre1 / nombre2);
    }
    public double  obtenirCents(int nombre) {
        return (nombre % 100);
    }
    public int obtenirDollards(int nombre) {
        return nombre / 100;
    }
    public String additionMontant(String montant1, String montant2){
        Utile u = new Utile();
        double nombre1 = u.convertirStringADouble(montant1);
        double nombre2 = u.convertirStringADouble(montant2);
        int additionEnCents = convertirDollarsACent(nombre1 ) + convertirDollarsACent(nombre2);
        DecimalFormat df = new DecimalFormat("0.00");
        double cents = obtenirCents(additionEnCents) / 100;
        String addition = df.format(obtenirDollards(additionEnCents) + cents);
        return addition;
    }

    public double calculerNouveauPlafond(double plafondInitial, double montantRembourse){
        int nouvPlafond = convertirDollarsACent(plafondInitial) - convertirDollarsACent(montantRembourse);
        double nouvPlafondConverti = obtenirDollards(nouvPlafond) + obtenirCents(nouvPlafond);
        if(nouvPlafondConverti < 0){
            nouvPlafondConverti = 0;
        }
        return nouvPlafondConverti;
    }
    public double calculerRemboursement(double montant, int pourcentage, double plafond){
        int remboursementEnCents = divisionEntiere(multiplication(convertirDollarsACent(montant), pourcentage), 100);
        double cents = obtenirCents(remboursementEnCents) / 100;
        double remboursement = obtenirDollards(remboursementEnCents) + cents;

        if(plafond != -1.0){
            if (remboursement > plafond) {
                remboursement = plafond ;
            }
        }
        return remboursement;
    }


}
