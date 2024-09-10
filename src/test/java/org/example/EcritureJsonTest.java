package org.example;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class EcritureJsonTest {

    Client cl = new Client("A100323", "2022-01");
    TypeA a = new TypeA();
    TypeB b = new TypeB();
    TypeC c = new TypeC();
    TypeD d = new TypeD();
    TypeE e = new TypeE();


    public ArrayList<Soin> getTableauSoins(){
        String erreur = "";
        ArrayList<Soin> soins = new ArrayList<Soin>();
        Soin s1 = new Soin(0, "2022-01-11", "130.00$", "A",a,b,c,d,e);
        Soin s2 = new Soin(200, "2022-01-14", "100.00$", "A",a,b,c,d,e);
        soins.add(s1);
        soins.add(s2);
        return soins;
    }
    @Test
    public void testJsonSortieFonctionnel() throws IOException {
        String erreur = "";
        EcritureJson e = new EcritureJson("outputTests/outputTestValide.json", cl, getTableauSoins(), true, erreur, "57.00$");
        File expectedFile = new File("outputTests/outputValide.json");
        File actualFile = new File("outputTests/outputTestValide.json");
        ObjectMapper objectMapper = new ObjectMapper();
        Object expectedObject = objectMapper.readValue(expectedFile, Object.class);
        Object actualObject = objectMapper.readValue(actualFile, Object.class);
        assertEquals(expectedObject, actualObject,"Le fichier de sortie devrait avoir le bon format");
    }

    @Test
    public void testJsonSortieInvalide() throws IOException {
        String erreur = "Le message d'erreur";
        EcritureJson e = new EcritureJson("outputTests/outputTestInvalide.json", cl, getTableauSoins(), false, erreur, "57.00$");
        File expectedFile = new File("outputTests/outputInvalide.json");
        File actualFile = new File("outputTests/outputTestInvalide.json");
        ObjectMapper objectMapper = new ObjectMapper();
        Object expectedObject = objectMapper.readValue(expectedFile, Object.class);
        Object actualObject = objectMapper.readValue(actualFile, Object.class);
        assertEquals(expectedObject, actualObject,"Le fichier de sortie invalide ne devrait contenir que Message : suivant du message d'erreur");
    }

}