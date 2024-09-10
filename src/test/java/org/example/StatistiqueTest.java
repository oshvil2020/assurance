package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import static org.example.Statistique.*;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StatistiqueTest {


    @Test
    public void testFichierStatistiqueReinitialise() throws IOException {
        ArrayList<String> numSoins = new ArrayList<String>();
        Statistique s = new Statistique(true, numSoins, true,"statistique.json", "outputTests/statistiqueResetTest.json");
        File expectedFile = new File("outputTests/statistiquesReset.json");
        File actualFile = new File("outputTests/statistiqueResetTest.json");
        ObjectMapper objectMapper = new ObjectMapper();
        Object expectedObject = objectMapper.readValue(expectedFile, Object.class);
        Object actualObject = objectMapper.readValue(actualFile, Object.class);
        Assertions.assertEquals(expectedObject, actualObject,"Le fichier statistique réinitialisé devrait être remise à zéro correctement.");
    }

    @Test
    public void testAdditionSoins() throws IOException {
        ArrayList<String> numSoins = new ArrayList<String>();
        numSoins.add("0");
        numSoins.add("200");
        numSoins.add("300");
        Statistique s = new Statistique(true, numSoins, false,"inputTests/statistiqueAZero.json", "outputTests/statistiqueTestAddition.json");
        File expectedFile = new File("outputTests/statistiqueTestAddition.json");
        File actualFile = new File("inputTests/statistiqueTestAdditionResultatAttendu.json");
        ObjectMapper objectMapper = new ObjectMapper();
        Object expectedObject = objectMapper.readValue(expectedFile, Object.class);
        Object actualObject = objectMapper.readValue(actualFile, Object.class);
        Assertions.assertEquals(expectedObject, actualObject,"Le ficher de sorti avec une entrée de soin devrait être additionné correctement");
    }



}