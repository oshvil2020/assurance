package org.example;

import java.util.HashMap;
import java.util.Map;

/**
 * Catégories de soin:
 * 0 Massothérapie
 * 100 Ostéopathie
 * 150 Kinésithérapie
 * 175 Médecin généraliste privé
 * 200 Psychologie individuelle
 * [300..399] Soins dentaires
 * 400 Naturopathie, acuponcture
 * 500 Chiropratie
 * 600 Physiothérapie
 * 700 Orthophonie, ergothérapie
 */

public class TypeE extends Type {
    protected HashMap<Integer, Double> plafond;
    protected HashMap<Integer, Integer> pourcentage;

    public TypeE() {
        this.plafond = new HashMap<>(Map.of(0, -1.00, 100, 250.00,150, -1.00, 175, 200.00, 200, 250.00,
                400, 15.00, 500, 150.00, 600, 300.00, 700, -1.00));
        this.pourcentage = new HashMap<>(Map.of(0, 15, 100, 25, 150, 15, 175, 25, 200, 12,
                400, 25, 500, 30, 600, 15, 700, 22));
    }

    @Override
    public int getPourcentage(int numeroSoin) {
        if (numeroSoin >= 300 && numeroSoin < 400) {
            return 60;
        } else {
            return pourcentage.get(numeroSoin);
        }
    }

    @Override
    public double getPlafond(int numeroSoin, double montantInitial) {
        if (numeroSoin >= 300 && numeroSoin < 400) {
            return montantInitial;
        } else {
            return plafond.get(numeroSoin);
        }
    }
    @Override
    public void setPlafond(int numeroSoin, double montantRestant) {
        this.plafond.replace(numeroSoin, montantRestant);
    }
}