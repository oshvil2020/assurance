package org.example;
/**
 * Classe qui modélise différents types de contrats de soins de santé en définissant
 * des méthodes pour les pourcentages, les plafonds et les mises à jour de plafonds.
 */

abstract class Type {
    public int getPourcentage(int numeroSoin) {
        return 0;
    }
    public double getPlafond(int numeroSoin, double montantInitial) {
        return 0;
    }
    public void setPlafond(int numeroSoin, double montantRestant) {
    }
}
