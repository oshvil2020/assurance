package org.example;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class LectureJsonTest {
    @Rule
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void testLectureFichierExistant() {
        LectureJson lecture = new LectureJson("inputTests/input.json");
        Assert.assertEquals("Un fichier existant ne retourne rien à la console",
                outputStreamCaptor.toString().trim(), "");
    }
    @Test
    public void testLectureFichierNonExistant() {
        LectureJson lecture = new LectureJson("inp.json");
        Assert.assertEquals("", outputStreamCaptor.toString().trim(),
                "Ce fichier n'existe pas." );
    }
    @Test
    public void testErreurLecture() {
        LectureJson lecture = new LectureJson("inputTests/inputErreur.json");
        Assert.assertEquals("Un fichier avec une erreur de parsing devrait retourner une erreur dans la console.",
                outputStreamCaptor.toString().trim(),
                "Erreur lors de la lecture du fichier");
    }
}
