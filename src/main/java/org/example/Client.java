package org.example;

/**
 * Classe qui modélise un client
 */

public class Client {
    private final String dossier;
    private final String dateReclamation;

    public Client(String dossier, String dateReclamation) {
        this.dossier = dossier;
        this.dateReclamation = dateReclamation;
    }

    public String getDossier() {
        return dossier;
    }
    public String getDateReclamation() {
        return dateReclamation;
    }


}
