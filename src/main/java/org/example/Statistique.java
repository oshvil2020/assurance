package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.JSONObject;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import static java.lang.Integer.parseInt;
public class Statistique {

    private static int validationsValides;
    private final int validationsNonValides;
    private static boolean valide = false;
    private String nomFichier;
    private static final ArrayList<String> lesNumerosSoins = new ArrayList<>();
    private static final HashMap<Integer, Integer> soins = new HashMap<>();

    public Statistique(boolean reclamationValide, ArrayList<String> numerosSoins, boolean reset, String fichierEntrant, String nomFichierSortie) {
        LectureJson lecture = new LectureJson(fichierEntrant);
        JSONObject obj = lecture.getObjetJson();
        this.nomFichier = nomFichierSortie;
        valide = reclamationValide;
        lesNumerosSoins.addAll( numerosSoins );
        validationsValides = (int) (long) obj.get("Le nombre de réclamations valides traitées");
        validationsNonValides = (int) (long) obj.get("Le nombre de réclamations rejetées");
        if(reset){
            System.out.println("Le fichier statistique a été réinitialisé.");
            reset();
        }
        else{
            if (valide) {
                associerSoins(obj);
            }
            compterReclamationsValide();
            ecrireJsonStatistique();
        }
    }
    //static
    public static void associerSoins(JSONObject obj) {
        soins.put(0 ,  (int) (long) obj.get("Le nombre de soin 0"));
        soins.put(100, (int) (long) obj.get("Le nombre de soin 100"));
        soins.put(175, (int) (long) obj.get("Le nombre de soin 175"));
        soins.put(200, (int) (long) obj.get("Le nombre de soin 200"));
        soins.put(300, (int) (long) obj.get("Le nombre de soin [300...399]"));
        soins.put(400, (int) (long) obj.get("Le nombre de soin 400"));
        soins.put(500, (int) (long) obj.get("Le nombre de soin 500"));
        soins.put(600, (int) (long) obj.get("Le nombre de soin 600"));
        soins.put(700, (int) (long) obj.get("Le nombre de soin 700"));
    }

    public static void compterReclamationsValide() {
        validationsValides++;
        if (valide) {
            compterSoins();
        }
    }

    public static void compterSoins() {
        for (int i = 0; i < lesNumerosSoins.size(); i++) {
            int soinEnCours = parseInt(lesNumerosSoins.get(i));
            if (soinEnCours >= 300 && soinEnCours < 400) {
                soins.put(300, soins.get(300) + 1);
            } else {
                soins.put(soinEnCours, soins.get(soinEnCours) + 1);
            }
        }
    }

    public void ecrireJsonStatistique() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            FileWriter fileWriter = new FileWriter(this.nomFichier);
            gson.toJson(mettreEnFormeJson(), fileWriter);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Impossible d'écrire ce fichier");
        }
    }

    public LinkedHashMap<String, Integer> mettreEnFormeJson() {
        LinkedHashMap<String, Integer> listeJson = new LinkedHashMap<>();
        listeJson.put("Le nombre de réclamations valides traitées", this.validationsValides);
        listeJson.put("Le nombre de réclamations rejetées", this.validationsNonValides);
        listeJson.put("Le nombre de soin 0", this.soins.get(0));
        listeJson.put("Le nombre de soin 100", this.soins.get(100));
        listeJson.put("Le nombre de soin 175", this.soins.get(175));
        listeJson.put("Le nombre de soin 200", this.soins.get(200));
        listeJson.put("Le nombre de soin [300...399]", this.soins.get(300));
        listeJson.put("Le nombre de soin 400", this.soins.get(400));
        listeJson.put("Le nombre de soin 500", this.soins.get(500));
        listeJson.put("Le nombre de soin 600", this.soins.get(600));
        listeJson.put("Le nombre de soin 700", this.soins.get(700));
        return listeJson;
    }

    public void reset(){

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            FileWriter fileWriter = new FileWriter(this.nomFichier);
            gson.toJson(mettreEnFormeJsonReset(), fileWriter);
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public LinkedHashMap<String, Integer> mettreEnFormeJsonReset() {
        LinkedHashMap<String, Integer> listeJson = new LinkedHashMap<>();
        listeJson.put("Le nombre de réclamations valides traitées", 0);
        listeJson.put("Le nombre de réclamations rejetées", 0);
        listeJson.put("Le nombre de soin 0", 0);
        listeJson.put("Le nombre de soin 100", 0);
        listeJson.put("Le nombre de soin 175", 0);
        listeJson.put("Le nombre de soin 200", 0);
        listeJson.put("Le nombre de soin [300...399]", 0);
        listeJson.put("Le nombre de soin 400", 0);
        listeJson.put("Le nombre de soin 500", 0);
        listeJson.put("Le nombre de soin 600", 0);
        listeJson.put("Le nombre de soin 700", 0);
        return listeJson;
    }
    public int getSoinsSize(){
        return soins.size();
    }

}