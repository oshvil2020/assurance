package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SoinTest {

    TypeA a = new TypeA();
    TypeB b = new TypeB();
    TypeC c = new TypeC();
    TypeD d = new TypeD();
    TypeE e = new TypeE();

    @Test
    @DisplayName("La méthode getSoin devrait retourner le bon numéro de soin")
    public void testGetSoin() {
        Soin unSoin = new Soin(400, "2022-03-01", "100.0", "A", a, b, c, d, e);
        assertEquals(400, unSoin.getSoin());
    }

    @Test
    public void testTypeInvalide() {
        Soin unSoin = new Soin(400, "2022-03-01", "100.0", "Données invalides", a, b, c, d, e);
        assertEquals("Données invalides", unSoin.getMontant(), "Si le type est invalide, " +
                "le montant est égal à Données invalides.");
    }

    @Test
    public void testSoinInvalide() {
        Soin unSoin = new Soin(-1, "2022-03-01", "100.0", "A", a, b, c, d, e);
        assertEquals("Données invalides", unSoin.getMontant(), "Si le paramètre Soin est" +
                " à -1, le montant est Données invalides.");
    }

    @Test
    public void testMontantInvalide() {
        Soin unSoin = new Soin(400, "2022-03-01", "Données invalides", "A", a, b, c, d, e);
        assertEquals("Données invalides", unSoin.getMontant(), "Si le paramètre montant est" +
                " à Données invalides, le montant est également à Données invalides");
    }
}