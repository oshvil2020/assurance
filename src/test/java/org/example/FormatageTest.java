package org.example;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


public class FormatageTest{
    Client c = new Client("A100323", "2022-01");

    public JSONArray tableauSoins() {
        JSONObject soins1 = new JSONObject();
        JSONObject soins2 = new JSONObject();
        soins1.put("soin", "175");
        soins1.put("date", "2022-01-14");
        soins1.put("montant", "300$");

        soins2.put("soin", "175");
        soins2.put("date", "2022-01-14");
        soins2.put("montant", "300$");

        JSONArray tableauSoins = new JSONArray();
        tableauSoins.add(soins1);
        tableauSoins.add(soins2);
        return tableauSoins;
    }
    @Test
    public void testObtenirTotalSoins() {
        Formatage f = new Formatage(c.getDossier(), c.getDateReclamation(),tableauSoins());
        String attendu = "200.00$";
        String actuel = f.getTotalSoins();
        Assertions.assertEquals(attendu, actuel, "Le montant des soins devrait retourner l'addition en String avec un $ à la fin de tous les montants remboursés");
    }



}