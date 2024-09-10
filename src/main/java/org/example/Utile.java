package org.example;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;


/**
 * Cette classe contient des methodes qui permettent de faire des vérifications sur les données d'entrées.
 */

class Utile {
    public static boolean validerSiNombre(String chaine) {
        try {
            Double.parseDouble(chaine);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public boolean validerLongueur(String entree, int longueur) {
        return entree.length() == longueur;
    }

    public boolean verifierLongueur(String dossier, int longueur) {
        return dossier != null && dossier.length() == longueur;
    }
    public boolean verifierContrat(String dossier) {
        char contrat = dossier.charAt(0);
        return contrat == 'A' || contrat == 'B' || contrat == 'C'
                || contrat == 'D' || contrat == 'E';
    }
    public boolean verifierSiNombre(String dossier) {
        try {
            Double.parseDouble(dossier.substring(1, 7));
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
    public boolean verifierDossier(String dossier, int longueur) {
        try {
            return verifierLongueur(dossier, longueur) &&
                    verifierContrat(dossier) && verifierSiNombre(dossier);
        } catch (Exception e) {
            return false;
        }
    }
    public boolean validerNumeroSoin(String numeroSoin) {
        int numeroSoinInt = Integer.parseInt(numeroSoin);
        return numeroSoinInt == 0 || numeroSoinInt == 100 || numeroSoinInt == 175 ||numeroSoinInt == 200
                || numeroSoinInt == 400 || numeroSoinInt == 500 || numeroSoinInt == 600
                || numeroSoinInt == 700 || (numeroSoinInt >= 300 && numeroSoinInt <= 399);
    }

    public String getMois(String date) {
        String mois = date.substring(5, 7);
        return mois;
    }
    public double convertirStringADouble(String chaine) {
        String strNombre = chaine;
        double nombre = 0.0;
        try {
            nombre = Double.parseDouble(strNombre);
        } catch (NumberFormatException e) {
            System.out.println("La chaîne de caractères n'est pas un nombre valide.");
        }
        return nombre;
    }
    public String getAnnee(String date) {
        String annee = date.substring(0, 4);
        return annee;
    }

    public boolean comparerDateSoinEtReclamation(String dateSoin, String dateReclamation) {
        return getMois(dateSoin).equals(getMois(dateReclamation)) && getAnnee(dateSoin)
                .equals(getAnnee(dateReclamation));
    }

    public boolean validerDateReclamation(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(date);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean validerDateSoin(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(date);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String retirerDernierCaractere(String chaine) {
        return chaine.substring(0, chaine.length() - 1);
    }
    public boolean validerSigneDollards(String montantSoin) {
        return montantSoin.substring(montantSoin.length() - 1).equals("$");
    }
    public static boolean estDouble(String s) {
        try {
            Double.parseDouble(s.replace(',', '.'));
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

