package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TypeDTest {
    TypeD typeD = new TypeD();

    @Test
    void testGetPourcentage() {
        int numeroSoin = 175;
        int expected = 95;
        int actual = typeD.getPourcentage(numeroSoin);
        assertEquals(expected, actual, "Le pourcentage renvoyé pour le numéro de soin " + numeroSoin
                + " est incorrect. Valeur attendue : " + expected + ". Valeur actuelle : " + actual + ".");
    }
    @Test
    void testGetPourcentage300Et399() {
        int numeroSoin = 356;
        int expected = 90;
        int actual = typeD.getPourcentage(numeroSoin);
        assertEquals(expected, actual, "Le pourcentage retourné pour le numéro de soin " + numeroSoin
                + "devrait être:" + expected);
    }
    @Test
    void testGetPlafond() {
        int numeroSoin = 0;
        double montantnitial = 100;
        double expected = 85;
        double actuel = (int) typeD.getPlafond(numeroSoin,montantnitial);
        assertEquals(expected, actuel );
    }

    @Test
    void testSetPlafond() {
        int numeroSoin = 300;
        double montantnitial = 100;
        double expected = 100;
        typeD.setPlafond(numeroSoin,montantnitial);
        assertEquals(expected, typeD.getPlafond(numeroSoin,montantnitial) );
    }
}