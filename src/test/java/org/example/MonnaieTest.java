package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonnaieTest {
    Monnaie monnaie = new Monnaie();

    @Test
    void convertirDollarsACent() {
        double actuel = 100.89;
        int expect = 10089;
        assertEquals(expect, monnaie.convertirDollarsACent(actuel), 0.0001,
                "la conversion dollars à cent ne fonction pas!");
    }

    @Test
    void multiplication() {
        int nbr1 = 10;
        int nbr2 = 2;
        int expect = 20;
        assertEquals(expect, monnaie.multiplication(nbr1, nbr2),
                "Calcule multiplication n'est pas correct!");
    }

    @Test
    void multiplicationZero() {
        int nbr1 = 10;
        int nbr2 = 0;
        int expect = 0;
        assertEquals(expect, monnaie.multiplication(nbr1, nbr2),
                "multiplication de zero");
    }

    @Test
    void multiplicationNegative() {
        int nbr1 = 10;
        int nbr2 = -1;
        int expect = -10;
        assertEquals(expect, monnaie.multiplication(nbr1, nbr2),
                "multiplication des nombres negatives.");
    }

    @Test
    void divisionEntiere() {
        int nbr1 = 10;
        int nbr2 = 2;
        int expect = 5;
        assertEquals(expect, monnaie.divisionEntiere(nbr1, nbr2),
                "Division de deux entieres ne sont pas correct!");
    }

    @Test
    void obtenirCents() {
        int nbr = 1058;
        double expect = 58;
        assertEquals(expect, monnaie.obtenirCents(nbr),
                "calcule de cent par obtenirCent n'est pas correct!");
    }

    @Test
    void obtenirDollards() {
        int nbr = 1058;
        double expect = 10;
        assertEquals(expect, monnaie.obtenirDollards(nbr),
                "calcule de dollar par obtenirDollards n'est pas correct!");
    }

    @Test
    void additionMontant() {
        String nbr1 = "10.88";
        String nbr2 = "20.22";
        String expect = "31.10";
        assertEquals(expect, monnaie.additionMontant(nbr1, nbr2),
                "le calcule additionMontant n'est pas correct!.!");
    }

    @Test
    void calculerNouveauPlafond() {
        double plafond = 200.40;
        double montantRembourse = 100.40;
        double expect = 100.0;
        assertEquals(expect, monnaie.calculerNouveauPlafond(plafond, montantRembourse),
                "Nouveau plafond n'est pas bien calculé.");

    }

    @Test
    void calculerNouveauPlafondNegative() {
        double plafond = 200.40;
        double montantRembourse = 300.40;
        double expect = 0.0;
        assertEquals(expect, monnaie.calculerNouveauPlafond(plafond, montantRembourse),
                "le nouveau plafond est zero quand montent rembourssé est plus grand que planfond.");

    }

    @Test
    void calculerRemboursement() {
        double montant = 100.10;
        double plafond = 90.40;
        int pourcentage = 80;
        double expect = 80.08;
        assertEquals(expect, monnaie.calculerRemboursement(montant, pourcentage, plafond),
                "calcule remboursement n'est pas correct!");

    }

    @Test
    void calculerRemboursementPlusQuePlafond() {
        double montant = 100.10;
        double plafond = 50.40;
        int pourcentage = 80;
        double expect = 50.40;
        assertEquals(expect, monnaie.calculerRemboursement(montant, pourcentage, plafond),
                "calcule remboursement n'est pas correct quand le plafond est plus petit que montant remboursement !");
    }
}