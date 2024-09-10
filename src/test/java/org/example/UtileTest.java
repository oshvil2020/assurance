package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class UtileTest {

    Utile utile = new Utile();

    @Test
    void validerSiNombre() {
        boolean resultatAttendu = true;
        boolean resultatObtenu = Utile.validerSiNombre("11");
        assertEquals(resultatAttendu, resultatObtenu, "Le résultat doit être un nombre");
    }

    @Test
    void validerLongueur() {
        assertTrue(utile.validerLongueur("contrat", 7),
                "La longueur doit être égale à 7.");
    }

    @Test
    void verifierLongueur() {
        boolean resultatAttendu = true;
        boolean resultatObtenu = utile.verifierLongueur("1234567", 7);
        assertEquals(resultatAttendu, resultatObtenu);
    }

    @Test
    void verifierContrat() {
        assertTrue(utile.verifierContrat("E"),
                "Le type de contrat doit commencer par 'A', 'B', 'C', 'D' ou 'E'.");
    }

    @Test
    void verifierSiNombre() {
        boolean resultatAttendu = true;
        boolean resultatObtenu = utile.verifierSiNombre("1239897098098");
        assertEquals(resultatAttendu, resultatObtenu);
    }

    @Test
    void verifierDossier() {
        assertTrue(utile.verifierDossier("A123456", 7));
    }

    @Test
    void verifierDossierNumeroInvalide() {
        assertFalse(utile.verifierDossier("123456", 7),
                "Le numéro de dossier doit commencer par la lettre du type de contrat");
    }

    @Test
    void verifierDossierNonNombre() {
        assertFalse(utile.verifierDossier("abc12", 7),
                "Le numéro de dossier doit être des chiffres");
    }

    @Test
    void verifierDossierFormatInvalid() {
        assertFalse(utile.verifierDossier("1234", 7),
                "Le format du numéro de contrat est invalide");
    }

    @Test
    void validerNumeroSoin() {
        String numeroSoin = "100";
        assertTrue(utile.validerNumeroSoin(numeroSoin), "Le numero de soin est invalide");
    }

    @Test
    void getMois() {
        String moisAttendu = "03";
        String moisObtenu = utile.getMois("2022-03-15");
        assertEquals(moisAttendu, moisObtenu);
    }

    @Test
    void getAnnee() {
        String anneeAttendu = "2023";
        String anneeObtenu = utile.getAnnee("2023-03-04");
        assertEquals(anneeAttendu, anneeObtenu, "Le format de l'année est invalide");
    }

    @Test
    void comparerDateSoinEtReclamation() {
        String dateSoin = "2023-10-03";
        String dateReclamation = "2023-10-03";
        assertEquals(dateSoin, dateReclamation, "La date de soin est différente de la date de réclamation");
    }

    @Test
    void validerDateReclamation() {
        String dateValide = "2022-12";
        assertTrue(utile.validerDateReclamation(dateValide), "Le format de la date est invalide");
    }

    @Test
    void validerDateSoin() {
        assertTrue(utile.validerDateSoin("2022-05-01"));
    }

    @Test
    void validerDateSoinFormatInvalide() {
        assertFalse(utile.validerDateSoin("20230312"), "Le format de la date doit être 'yyyy-MM-dd'");
    }

    @Test
    void validerDateSoinJourFevrierInvalide() {
        assertFalse(utile.validerDateSoin("2023-02-30"), "Le jour est invalide pour le mois de février)");
    }

    @Test
    void validerDateSoinMoisInvalide() {
        assertFalse(utile.validerDateSoin("2022-16-12"), "Le nombre de mois ou de jour est invalide");
    }

    @Test
    void retirerDernierCaractere() {
        String resultatAttendu = "23,4";
        String resultatObtenu = utile.retirerDernierCaractere("23,45");
        assertEquals(resultatAttendu, resultatObtenu);
    }

    @Test
    void validerSigneDollards() {
        assertTrue(utile.validerSigneDollards("23$"));
    }

    @Test
    void estDoubleAvecPoint() {
        assertTrue(utile.estDouble("122.55"));
    }

    @Test
    void estDoubleAvecVirgule() {
        assertTrue(utile.estDouble("122,55"));
    }
}