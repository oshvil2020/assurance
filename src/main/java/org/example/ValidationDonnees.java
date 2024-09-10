package org.example;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;

/**
 * Cette classe valide chaque champs du JSON à l'aide des méthodes dans Utiles.
 */
public class ValidationDonnees {
    private final String dateReclamation;
    private final String dossier;
    private final JSONArray tableauSoin;
    private String erreursValidation;
    private final Utile test = new Utile();
    private ArrayList<String> montantsSoins;
    private ArrayList<String> numerosSoins;
    private boolean estValide = true;

    public ValidationDonnees(JSONObject fichierJson) {
        this.erreursValidation = "";
        this.numerosSoins = new ArrayList<String>();
        this.montantsSoins = new ArrayList<String>();
        this.dossier = validerDossier((String) fichierJson.get("dossier"));
        this.dateReclamation = validerDateReclamation((String) fichierJson.get("mois"));
        this.tableauSoin = creerTableauSoin((JSONArray) fichierJson.get("reclamations"));
    }

    public String validerDossier(String dossier) {
        if (!test.verifierDossier(dossier, 7)) {
            estValide = false;
            setErreurValidation("Le numéro de dossier est invalide.");
            return "Données invalides";
        } else {
            return dossier;
        }
    }

    public String validerDateReclamation(String dateReclamation) {
        if (!test.validerLongueur(dateReclamation, 7) || !test.validerDateReclamation(dateReclamation)) {
            estValide = false;
            setErreurValidation("La date fournie est invalide.");
            return "La date de réclamation fournie est invalide. Veuillez entrer une date valide";
        } else {
            return dateReclamation;
        }
    }

    public String validerNumeroSoin(String numeroSoin) {
        if (!test.validerSiNombre(numeroSoin) || !test.validerNumeroSoin(numeroSoin)) {
            estValide = false;
            setErreurValidation("Un ou plusieurs numéro de soin fourni nest pas valide.");
            return "-1";
        } else {
            numerosSoins.add(numeroSoin);
            return numeroSoin;
        }
    }

    public String validerDateSoin(String dateSoin) {
        if (!test.validerLongueur(dateSoin, 10)
                || !test.comparerDateSoinEtReclamation(dateSoin, this.getDateReclamation())
                || !test.validerDateSoin(dateSoin)) {
            estValide = false;
            setErreurValidation("La date de soin fournie est invalide ou ne correspond pas à la date de" +
                    " réclamation associée à cette réclamation.");
            return "Donnée invalide";
        } else {
            return dateSoin;
        }
    }

    public String validerMontantSoin(String montantSoin) {
        String montantSansSigneDollars = test.retirerDernierCaractere(montantSoin);
        if (!test.validerSigneDollards(montantSoin) || !test.estDouble(montantSansSigneDollars)) {
            estValide = false;
            setErreurValidation("Le montant de soin est invalide.");
            return "Données invalides";
        } else {
            montantsSoins.add(montantSansSigneDollars);

            return montantSoin;
        }
    }

    public JSONArray creerTableauSoin(JSONArray tableauSoins) {
        JSONArray tableauSoinsValides = new JSONArray();
        for (Object unSoin : tableauSoins) {
            JSONObject unSoinInitial = (JSONObject) unSoin;
            tableauSoinsValides.add(validerChaqueSoin(unSoinInitial));
        }
        return tableauSoinsValides;
    }

    public JSONObject validerChaqueSoin(JSONObject unSoin) {
        JSONObject soinValide = new JSONObject();
        String soin = validerNumeroSoin(String.valueOf(unSoin.get("soin")));
        String date = validerDateSoin(String.valueOf(unSoin.get("date")));
        String montant = validerMontantSoin(String.valueOf(unSoin.get("montant")));
        soinValide.put("soin", soin);
        soinValide.put("date", date);
        soinValide.put("montant", montant);
        return soinValide;
    }

    public JSONArray getTableauSoin() {
        return tableauSoin;
    }

    public void setErreurValidation(String erreur) {
        this.erreursValidation = erreur;
    }

    public String getErreurValidation() {
        return erreursValidation;
    }

    public String getDossier() {
        return dossier;
    }

    public String getDateReclamation() {
        return dateReclamation;
    }

    public ArrayList<String> getMontantsSoins() {
        return montantsSoins;
    }
    public ArrayList<String> getNumerosSoins() {
        return numerosSoins;
    }
    public boolean getEstValide() {
        return estValide;
    }

}
