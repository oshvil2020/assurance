package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClientTest {
    Client leClient = new Client("un dossier", "une date");
    @Test
    public void testGetDossier() {
        assertEquals("un dossier", leClient.getDossier(),
                "Le numéro de dossier retourné par getDossier devrait être le bon.");
    }
    @Test
    public void testGetDateReclamations() {
        assertEquals("une date", leClient.getDateReclamation(),
                "La date de réclamation retournée par le getDateReclamation doit être la bonne." );
    }

}
