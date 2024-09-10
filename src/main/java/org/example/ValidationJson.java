package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

/**
 * Cette classe contient des methodes qui permettent de faire des vérifications sur le fichier Json.
 */
public class ValidationJson {
    private final static String[] nomChamps = {"dossier", "mois", "reclamations"};
    private final static ObjectMapper mapper = new ObjectMapper();
    public boolean verifierChemin(String cheminFichier) {
        File file = new File(cheminFichier);
        return file.exists();
    }
    public void validerJson(String nomFichierEntrant) {
        try {
            JsonNode root = mapper.readTree(new File(nomFichierEntrant));
            validerLesChamps(root);
            validerLesSoins(root);
        } catch (IOException e) {
            System.out.println("Ce fichier n'est pas valide.");
        }
    }
    public static void validerLesChamps(JsonNode racine) {
        for (String unChamp : nomChamps) {
            verifierChampExistant(racine.path(unChamp), unChamp);
        }
    }
    public static void verifierChampExistant(JsonNode champ, String nomChamp){
        if (champ.isMissingNode()) {
            System.out.println("Erreur: le champ " + nomChamp + " est absent du fichier.");
        }
    }

    public static void validerLesSoins(JsonNode racine) {
        JsonNode reclamationsNode = racine.path("reclamations");
        for (JsonNode remboursement : reclamationsNode) {
            verifierChampsTableauSoinExistant(remboursement, "soin");
            verifierChampsTableauSoinExistant(remboursement, "date");
        }
    }
    public static void verifierChampsTableauSoinExistant(JsonNode remboursement, String nomChamp){
        if (remboursement.path(nomChamp).isMissingNode()) {
            System.out.println("Erreur: le tableau de soin est invalide.");

        }
    }
    public static boolean verifierExtentionJson(String fileName) {
        return fileName.endsWith(".json");
    }

}

