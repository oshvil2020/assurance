package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class ValidationDonneesTest {

    LectureJson lecture = new LectureJson("inputTests/input.json");
    ValidationDonnees validation = new ValidationDonnees(lecture.getObjetJson());

    @Test
    public void testValiderDossierValide() {
        assertNotEquals("Données invalides", validation.validerDossier("A123456"),
                "Si le dossier a le bon format, la fonction ne devrait pas retourner Données invalides");
    }

    @Test
    public void testValiderDossierSeulementLettre() {
        assertEquals("Données invalides", validation.validerDossier("ABC"),
                "Un numéro de dossier devrait être composé de 1 lettre et 6 chiffres.");
    }

    @Test
    public void testValiderDossierSeulementChiffres() {
        assertEquals("Données invalides", validation.validerDossier("1234"),
                "Un numéro de dossier devrait être composé de 1 lettre et 6 chiffres.");
    }

    @Test
    public void testValiderDossierVide() {
        assertEquals("Données invalides", validation.validerDossier(" "),
                "Un numéro de dossier devrait être composé de 1 lettre et 6 chiffres.");
    }

    @Test
    public void testValiderDateReclamationValide() {
        assertNotEquals("La date de réclamation fournie est invalide. Veuillez entrer une date valide.",
                validation.validerDateReclamation("2023-01"),
                "Une date de réclamation valide ne devrait pas retourner de message d'erreur.");
    }

    @Test
    public void testValiderDateReclamationAvecJours() {
        assertEquals("La date de réclamation fournie est invalide. Veuillez entrer une date valide",
                validation.validerDateReclamation("2022-10-01"),
                "La date de réclamation devrait être dans le format 0000-00");
    }

    @Test
    public void testValiderDateReclamationInversion() {
        assertEquals("La date de réclamation fournie est invalide. Veuillez entrer une date valide",
                validation.validerDateReclamation("02-2022"),
                "La date de réclamation devrait être dans le format 0000-00");
    }

    @Test
    public void testValiderDateReclamationAnneeNonExistante() {
        assertEquals("La date de réclamation fournie est invalide. Veuillez entrer une date valide",
                validation.validerDateReclamation("2022-15"),
                "La date de réclamation devrait être dans le format 0000-00 et être existante.");
    }

    @Test
    public void testValiderDateReclamationVide() {
        assertEquals("La date de réclamation fournie est invalide. Veuillez entrer une date valide",
                validation.validerDateReclamation(" "),
                "La date de réclamation ne doit pas être vide");
    }

    @Test
    public void testValidernumeroSoinExistant() {
        assertNotEquals("-1", validation.validerNumeroSoin("400"),
                "Si le soin existe est possible, la méthode ne doit pas retourner -1.");
    }

    @Test
    public void testValidernumeroSoinNonExistant() {
        assertEquals("-1", validation.validerNumeroSoin("1"),
                "Le numero de soin doit être 0, 100, 200, entre 300 et 399, 400, 500, 600 ou 700. " +
                        "Rien d'autre");
    }

    @Test
    public void testValidernumeroSoinVide() {
        assertEquals("-1", validation.validerNumeroSoin(" "),
                "Le numero de soin doit être 0, 100, 200, entre 300 et 399, 400, 500, 600 ou 700. " +
                        "Rien d'autre");
    }

    @Test
    public void testValidernumeroSoinNégatif() {
        assertEquals("-1", validation.validerNumeroSoin("-400"),
                "Le numero de soin doit être 0, 100, 200, entre 300 et 399, 400, 500, 600 ou 700. " +
                        "Rien d'autre");
    }

    @Test
    public void testDateSoinPossible() {
        assertNotEquals("La date du soin n'est pas valide.", validation.validerDateSoin("2022-01-01"),
                "Si la date de soin fonctionne, on ne devrait pas avoir de message d'erreur.");
    }

    @Test
    public void testDateSoinMoisDifférentDateReclamation() {
        assertEquals("Donnée invalide", validation.validerDateSoin("2022-02-01"),
                "Le mois et l'année de la date de soin doit être la même que la date de réclamation");
    }

    @Test
    public void testDateSoinNonExistante() {
        assertEquals("Donnée invalide", validation.validerDateSoin("2022-01-40"),
                "La date de soin doit être une date qui existe.");
    }

    @Test
    public void testDateSoinMauvaisFormat() {
        assertEquals("Donnée invalide", validation.validerDateSoin("2022-01"),
                "La date de soin doit être de format 0000-00-00");
    }

    @Test
    public void testValiderMontantSoinValideVirgule() {
        assertNotEquals("Le montant de soin est invalide.", validation.validerMontantSoin("2,00$"),
                "Un montant de soin peut contenir une virgule ou un point.");
    }

    @Test
    public void testValiderMontantSoinValidePoint() {
        assertNotEquals("Le montant de soin est invalide.", validation.validerMontantSoin("2.00$"),
                "Un montant de soin peut contenir une virgule ou un point.");
    }

    @Test
    public void testValiderMontantSoinSansSigneDollars() {
        assertEquals("Données invalides", validation.validerMontantSoin("0.0"),
                "Le montant soin doit avoir un $ à la fin.");
    }

    @Test
    public void testValiderMontantSoinValide() {
        assertNotEquals("Le montant de soin est invalide.", validation.validerMontantSoin("2.00$"),
                "Un montant de soin valide ne devrait pas retourner un message d'erreur.");
    }

    @Test
    public void testValiderGetEstValide() {
        assertEquals(true, validation.getEstValide(),
                "La méthode est valide devrait être à True s'il n'y a aucune erreur dans le json input.");
    }

    @Test
    public void testValiderGetErreurValidation() {
        assertEquals("", validation.getErreurValidation(),
                "La méthode getErreurValidation devrait obtenir les erreurs présentes " +
                        "dans le fichier JSON d'input.");
    }

    @Test
    public void testGetDossier() {
        assertEquals("A100323", validation.getDossier(), "La méthode getDossier " +
                "devrait obtenir le numéro de dossier présent dans le fichier JSON.");
    }

}