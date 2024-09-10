package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * Classe qui écrit un fichier JSON
 */

public class EcritureJson {
    private final String nomFichierSortie;
    private final Client leClient;
    private final ArrayList tableauSoins;
    private boolean donneesValides;
    private final String messageErreur;
    private final String montantTotalSoin;

    public EcritureJson(String nomFichierSortie, Client leClient, ArrayList<Soin> tableauSoins,
                        boolean donneesValides, String messagesErreurs, String totalSoin) {
        this.nomFichierSortie = nomFichierSortie;
        this.leClient = leClient;
        this.tableauSoins = tableauSoins;
        this.donneesValides = donneesValides;
        this.messageErreur = messagesErreurs;
        this.montantTotalSoin = totalSoin;
        ecrireJson();
    }

    public void ecrireJson() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            FileWriter fileWriter = new FileWriter(this.nomFichierSortie);
            gson.toJson(choisirJson(), fileWriter);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Impossible d'écrire le fichier.");
        }
    }
    public LinkedHashMap<String, Object> choisirJson() {
        if (this.donneesValides) {
            return mettreEnFormeJson(this.leClient, this.tableauSoins, this.montantTotalSoin);
        } else {
            return mettreEnFormeJsonInvalide(this.messageErreur);
        }
    }
    public LinkedHashMap<String, Object> mettreEnFormeJsonInvalide(String erreurs) {
        LinkedHashMap<String, Object> listeJson = new LinkedHashMap<>();
        listeJson.put("message: ", erreurs);
        return listeJson;
    }
    public LinkedHashMap<String, Object> mettreEnFormeJson(Client leClient, ArrayList<Soin> tableauSoins,
                                                           String totalSoins) {LinkedHashMap<String, Object> listeJson = new LinkedHashMap<>();
        listeJson.put("dossier", leClient.getDossier());
        listeJson.put("mois", leClient.getDateReclamation());
        listeJson.put("remboursements", tableauSoins);
        listeJson.put("total", totalSoins);
        return listeJson;
    }
}
