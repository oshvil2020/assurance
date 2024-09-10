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
public class TypeD extends Type {
    protected HashMap<Integer, Double> plafond;
    protected HashMap<Integer, Integer> pourcentage;

    public TypeD() {
        this.plafond = new HashMap<>(Map.of(0, 85.00, 100, 250.00, 150, 150.00, 175,200.00, 200, 250.00,
                400, 65.00, 500, 150.00, 600, 300.00, 700, 90.00));
        this.pourcentage = new HashMap<>(Map.of(0, 100, 100, 100, 150, 100, 175, 95,
                200, 100, 400, 100, 500, 100, 600, 100, 700, 100));
    }

    @Override
    public int getPourcentage(int numeroSoin) {
        if (numeroSoin >= 300 && numeroSoin < 400) {
            return 90;
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