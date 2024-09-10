package org.example;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class TypeETest {
    TypeE typeE = new TypeE();


    @Test
    void testGetPourcentage300Et399() {
        TypeE typeE = new TypeE();
        int numeroSoin = 378;
        int expected = 60;
        int actual = typeE.getPourcentage(numeroSoin);
        assertEquals(expected, actual, "Le pourcentage retourné pour le numéro de soin " + numeroSoin + "devrait être:" + expected);
    }
    @Test
    void testGetPourcentage() {
        TypeE typeE = new TypeE();
        HashMap<Integer, Integer> pourcentageActuel = new HashMap<>(Map.of(600, 15));
        int numeroSoin = 600;
        int expected = 15;
        int actual = typeE.getPourcentage(numeroSoin);
        assertEquals(expected, actual, "Le pourcentage renvoyé pour le numéro de soin " + numeroSoin + " est incorrect. Valeur attendue : " + expected + ". Valeur actuelle : " + actual + ".");
    }

    @Test
    void testGetPlafond() {
        int numeroSoin = 300;
        double montantnitial = 100;
        double expected = 100;
        double actuel = typeE.getPlafond(numeroSoin,montantnitial);
        assertEquals(expected, actuel );
    }

    @Test
    void testSetPlafond() {
        int numeroSoin = 300;
        double montantnitial = 100;
        double expected = 100;
        typeE.setPlafond(numeroSoin,montantnitial);
        assertEquals(expected, typeE.getPlafond(numeroSoin,montantnitial) );
    }
}