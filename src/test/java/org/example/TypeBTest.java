package org.example;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class TypeBTest {
    TypeB typeB = new TypeB();

    @Test
    void getPourcentage() {
        int numeroSoin = 175;
        int expected = 75;
        int actual = typeB.getPourcentage(numeroSoin);
        assertEquals(expected, actual, "Le pourcentage renvoyé pour le numéro de soin " + numeroSoin + " est incorrect. Valeur attendue : " + expected + ". Valeur actuelle : " + actual + ".");
    }
    @Test
    void getPourcentage300Et399() {
        int numeroSoin = 350;
        int expected = 50;
        int actual = typeB.getPourcentage(numeroSoin);
        assertEquals(expected, actual, "Le pourcentage retourné pour le numéro de soin " + numeroSoin + "devrait être:" + expected);
    }
    @Test
    void testGetPlafond() {
        int numeroSoin = 380;
        double montantInitial = 100;
        int expectedPlafond = 100;
        double actualPlafond = typeB.getPlafond(numeroSoin, montantInitial);
        assertEquals(expectedPlafond, actualPlafond, "Le plafond de remboursement pour le numéro de soin " + numeroSoin + " et un montant initial de " + montantInitial + " devrait être de " + expectedPlafond + ".");
    }

    @Test
    void setPlafond() {
        int numeroSoin = 700;
        double montantInitial = 100;
        int expected = 100;
        typeB.setPlafond(numeroSoin, montantInitial);
        double actual = typeB.getPlafond(numeroSoin, montantInitial);
        assertEquals(expected, actual, "Le plafond pour le numéro de soin " +
                numeroSoin + " et le montant initial " + montantInitial + " devrait être " + expected +
                ", mais la méthode setPlafond() a renvoyé " + actual + ".");
    }
}