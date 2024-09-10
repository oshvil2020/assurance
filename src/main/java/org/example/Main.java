package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ValidationJson test = new ValidationJson();
        validerArguments(args, test);
        validerCheminFichier(args[0], test);
        LectureJson lectureFichier = new LectureJson(args[0]);
        ValidationDonnees validation = new ValidationDonnees(lectureFichier.getObjetJson());
        Formatage formatage = new Formatage(validation.getDossier(), validation.getDateReclamation(),validation.getTableauSoin());
        EcritureJson ecriture = new EcritureJson(args[1], formatage.getClient(), formatage.getTableauSoins(), validation.getEstValide(), validation.getErreurValidation(), formatage.getTotalSoins());
        demarrerStatistique(args, validation);
    }
    public static void demarrerStatistique(String[] args, ValidationDonnees val) {
        for (String arg : args) {
            if (arg.equals("-S")) {
                Statistique s = new Statistique(val.getEstValide(), val.getNumerosSoins(), false, "statistique.json", "Statistique.json");
                imprimerStatistique();
            }
            else if((arg.equals("-SR"))){
                Statistique s = new Statistique(val.getEstValide(), val.getNumerosSoins(), true, "statistique.json","Statistique.json");
                imprimerStatistique();
            }
        }
    }
    public static void imprimerStatistique() {
        File file = new File("statistique.json");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void validerArguments(String[] args, ValidationJson test) {
        if (args.length < 1 || args.length > 3 || !test.verifierExtentionJson(args[0]) || !test.verifierExtentionJson(args[1])) {
            System.out.println("Arguments invalides");
        }

    }
    public static void validerCheminFichier(String fichierJson, ValidationJson test) {
        if (!test.verifierChemin(fichierJson)) {
            System.out.println("Ce fichier n'existe pas.");
            System.exit(1);
        }
    }
}