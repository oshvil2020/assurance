package org.example;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


import java.util.ArrayList;

/**
 * Classe qui créer un objet Client et un tableau d'objet(s) Soin à partir des données valides reçues.
 */
public class Formatage {
    private final Client leClient;
    private final String dossier;
    private final ArrayList<Soin> tableauSoins;
    private final TypeA a = new TypeA();
    private final TypeB b = new TypeB();
    private final TypeC c = new TypeC();
    private final TypeD d = new TypeD();
    private final TypeE e = new TypeE();

    public Formatage(String dossier, String dateReclamation, JSONArray tableauSoinsValide) {
        this.dossier = dossier;
        this.leClient = new Client(dossier, dateReclamation);
        this.tableauSoins = creerTableauSoins(tableauSoinsValide, this.getTypeContrat());
    }

    public ArrayList<Soin> creerTableauSoins(JSONArray tableauSoinsValides, String typeContrat) {
        ArrayList<Soin> tableauSoins = new ArrayList<Soin>();
        for (Object unSoin : tableauSoinsValides) {
            JSONObject soin = (JSONObject) unSoin;
            tableauSoins.add(creerUnSoin(soin, typeContrat));
        }
        return tableauSoins;
    }

    public Soin creerUnSoin(JSONObject unSoin, String typeContrat) {
        String numSoin = String.valueOf(unSoin.get("soin"));
        int numSoinConverti = Integer.parseInt(numSoin);
        String date = String.valueOf(unSoin.get("date"));
        String montant = String.valueOf(unSoin.get("montant"));
        return new Soin(numSoinConverti, date, montant, typeContrat, this.a, this.b, this.c, this.d, this.e);
    }

    public Client getClient() {
        return leClient;
    }
    public ArrayList<Soin> getTableauSoins() {
        return tableauSoins;
    }
    public String getTypeContrat() {
        if (this.dossier.equals("Données invalides")) {
            return "Données invaildes";
        } else {
            return this.dossier.substring(0, 1);
        }
    }

    public String getTotalSoins() {
        Monnaie m = new Monnaie();
        String num = "0.0";
        for (Soin tableauSoin : this.tableauSoins) {
            String montant = tableauSoin.getMontant();
            String montantSansDollars = montant.substring(0, montant.length()-1);
            if (!montant.equals("Données invalides"))
                num = m.additionMontant(num, montantSansDollars);
        }
        return num + "$";
    }




}
