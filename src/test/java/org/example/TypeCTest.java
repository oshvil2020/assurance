package org.example;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class TypeCTest {
    TypeC typeC = new TypeC();
    @Test
    void getPourcentage() {
        int numeroSoin = 400;
        int expected = 90;
        int actual = typeC.getPourcentage(numeroSoin);
        assertEquals(expected, actual, "Le pourcentage renvoyé pour le numéro de soin " + numeroSoin + " est incorrect. Valeur attendue : " + expected + ". Valeur actuelle : " + actual + ".");
    }

    @Test
    void getPourcentage300Et399() {
        int numeroSoin = 378;
        int expected = 90;
        int actual = typeC.getPourcentage(numeroSoin);
        assertEquals(expected, actual, "Le pourcentage retourné pour le numéro de soin " + numeroSoin + "devrait être:" + expected);
    }

    @Test
    void getPlafond() {
        int numeroSoin = 600;
        double montantInitial = 100;
        double plafondAttendu = 300;
        double plafondActuel = typeC.getPlafond(numeroSoin, montantInitial);
        assertEquals(plafondAttendu, plafondActuel, "Le plafond retourné pour le numéro de soin " +
                numeroSoin + " et le montant initial de " + montantInitial + " n'est pas égal à " + plafondAttendu + ".");
    }

    @Test
    void setPlafond() {
        int numeroSoin = 175;
        double montantnitial = 100;
        double expected = 100;
        typeC.setPlafond(numeroSoin,montantnitial);
        assertEquals(expected, typeC.getPlafond(numeroSoin,montantnitial) );
    }
}