package org.example;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class TypeATest {
    TypeA typeA = new TypeA();
    @Test
    void testGetPourcentages() {
        int numeroSoin = 0;
        int expected = 25;
        int actual = typeA.getPourcentage(numeroSoin);
        assertEquals(expected, actual, "Le pourcentage renvoyé pour le numéro de soin " + numeroSoin + " est incorrect. Valeur attendue : " + expected + ". Valeur actuelle : " + actual + ".");
    }

    @Test
    void testGetPourcentage300Et399() {
        int numeroSoin = 300;
        int expected = 0;
        int actual = typeA.getPourcentage(numeroSoin);
        assertEquals(expected, actual, "Le pourcentage retourné pour le numéro de soin 300 devrait être zéro");
    }
    @Test
    void testGetPlafond() {
        int numeroSoin = 175;
        double montantInitial = 100;
        double expected = 200;
        double actuel = typeA.getPlafond(numeroSoin,montantInitial);
        assertEquals(expected, actuel, "Le plafond pour le numéro de soin "
                + numeroSoin +  " devrait être " + expected);
    }
    @Test
    void testGetPlafondS() {
        int numeroSoin = 350;
        int montantnitial = 100;
        int expected = 100;
        double actuel = typeA.getPlafond(numeroSoin,montantnitial);
        assertEquals(expected, actuel,"Le plafond pour le soin "
                + numeroSoin + " devrait être de " + expected);
    }
    @Test
    void setPlafond() {
        int numeroSoin = 100;
        double montantInitial = 100;
        int expected = 100;
        typeA.setPlafond(numeroSoin, montantInitial);
        double actual = typeA.getPlafond(numeroSoin, montantInitial);
        assertEquals(expected, actual, "Le plafond pour le numéro de soin " +
                numeroSoin + " et le montant initial " + montantInitial + " devrait être " + expected +
                ", mais la méthode setPlafond() a renvoyé " + actual + ".");
    }
}
