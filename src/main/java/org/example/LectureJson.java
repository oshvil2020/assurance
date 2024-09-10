package org.example;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.*;

/**
 * Classe qui lit le fichier Json
 */

public class LectureJson {
    protected JSONObject objetJson;
    public LectureJson(String nomFichierEntrant) {
        try {
            Object obj = new JSONParser().parse(new FileReader(nomFichierEntrant));
            this.objetJson = (JSONObject) obj;
        } catch (IOException e) {
            System.out.println("Ce fichier n'existe pas.");
        } catch (ParseException e) {
            System.out.println("Erreur lors de la lecture du fichier");
        }
    }
    public JSONObject getObjetJson() {
        return objetJson;
    }
}
