package org.example;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.example.ValidationJson.verifierExtentionJson;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidationJsonTest {
    @Rule
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    ValidationJson validation = new ValidationJson();
    @Test
    void testValiderJsonNonExistant() {
        validation.validerJson("fichierNonExistant");
        Assert.assertEquals("Si le fichier n'est pas existant, le message Ce fichier n'est pas valide devrait afficher à la console.",
                outputStreamCaptor.toString().trim(),
                "Ce fichier n'est pas valide.");
    }

    @Test
    void testChampDossierManquant() {
        validation.validerJson("inputTests/inputDossierManquant.json");
        Assert.assertEquals("Le message Erreur: le champ dossier est absent du fichier doit s'afficher à la console si le dossier est absent",
                outputStreamCaptor.toString().trim(),
                "Erreur: le champ dossier est absent du fichier.");
    }

    @Test
    void testChampDateManquant() {
        validation.validerJson("inputTests/inputDateManquante.json");
        Assert.assertEquals("Le message Erreur: le champ date est absent du fichier doit s'afficher à la console si la date est absente.",
                outputStreamCaptor.toString().trim(),
                "Erreur: le champ mois est absent du fichier.");
    }
    @Test
    void testSoinInvalide() {
        validation.validerJson("inputTests/inputTableauSoinIncomplet.json");
        Assert.assertEquals("Le message Erreur: le tableau de soin est invalide doit s'afficher s'il manque des informations dans un soin.",
                outputStreamCaptor.toString().trim(),
                "Erreur: le tableau de soin est invalide.");
    }


    @Test
    void TestVerifierCheminExistant() {
        assertTrue(validation.verifierChemin("input.json"),
                " Si le fichier existe, la verifierCheminExistant() retoune True");
    }

    @Test
    void TestVerifierCheminNonExistant() {
        assertFalse(validation.verifierChemin("fichierNonExistant.json"),
                "Si le fichier n'existe pas la fonction  verifierCheminExistant() retourne false.");
    }

    @Test
    void TestVerifierMauvaiseExtension() {
        assertFalse(validation.verifierChemin("input.txt"),
                "Si l'extension n'est pas json, verifierExtentionJson() retourne False.");
    }
    @Test
    void TestVerifierExtensionJson() {
        assertTrue(verifierExtentionJson("test.json"),
                "Si l'extention du fichier est bonne verifierExtentionJson() retourne true.");
    }
    @Test
    void TestVerifierMauvaiseExtensionTxt() {
        assertFalse(verifierExtentionJson(".txt"),
                "Si l'extention est autre que json, verifierExtentionJson() retourne False");
    }
    @Test
    void TestVerifierAucuneExtention() {
        assertFalse(verifierExtentionJson(""),
                "Si aucune extension de fichier, verifierExtentionJson() retourne false.");
    }

    @Test
    void TestVerifierFauteDansExtension() {
        assertFalse(verifierExtentionJson("test.jsn"),
                "S'il y a une erreur dans l'extention verifierExtentionJson() retourne false.");
    }
}