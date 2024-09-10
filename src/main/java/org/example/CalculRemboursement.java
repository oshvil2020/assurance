/**
 * Cette classe calcul les remboursements de differents types de contrat
 * selon le plafond et le pourcentage reçu.
 */
package org.example;



public class CalculRemboursement {

    private final Monnaie mon = new Monnaie();
    private double remboursement;
    public CalculRemboursement(String typeContrat, int numSoin, String montant,
                               TypeA a, TypeB b, TypeC c, TypeD d, TypeE e) {
        String montantSansSigne = montant.substring(0, montant.length()-1);
        Utile u = new Utile();
        double montantConverti = u.convertirStringADouble(montantSansSigne);
        switch (typeContrat) {
            case "A" -> obtenirRemboursementA(numSoin, montantConverti, a);
            case "B" -> obtenirRemboursementB(numSoin, montantConverti, b);
            case "C" -> obtenirRemboursementC(numSoin, montantConverti, c);
            case "D" -> obtenirRemboursementD(numSoin, montantConverti, d);
            case "E" -> obtenirRemboursementE(numSoin, montantConverti, e);
        }
    }
    public void obtenirRemboursementA(int numSoin, Double montant, Type a) {
        this.remboursement = mon.calculerRemboursement(montant, a.getPourcentage(numSoin), a.getPlafond(numSoin, montant));
        double nouvPlafond = mon.calculerNouveauPlafond(a.getPlafond(numSoin, montant), remboursement);
        a.setPlafond(numSoin, nouvPlafond);
    }
    public void obtenirRemboursementB(int numSoin, Double montant,Type b) {
        this.remboursement = mon.calculerRemboursement(montant, b.getPourcentage(numSoin), b.getPlafond(numSoin, montant));
        double nouvPlafond = mon.calculerNouveauPlafond(b.getPlafond(numSoin, montant), remboursement);
        b.setPlafond(numSoin, nouvPlafond);
    }
    public void obtenirRemboursementC(int numSoin, Double montant,Type c) {
        this.remboursement = mon.calculerRemboursement(montant, c.getPourcentage(numSoin), c.getPlafond(numSoin, montant));
        double nouvPlafond = mon.calculerNouveauPlafond(c.getPlafond(numSoin, montant), remboursement);
        c.setPlafond(numSoin, nouvPlafond);
    }
    public void obtenirRemboursementD(int numSoin, Double montant,Type d) {
        this.remboursement = mon.calculerRemboursement(montant, d.getPourcentage(numSoin), d.getPlafond(numSoin, montant));
        double nouvPlafond = mon.calculerNouveauPlafond(d.getPlafond(numSoin, montant), remboursement);
        d.setPlafond(numSoin, nouvPlafond);
    }
    public void obtenirRemboursementE(int numSoin, Double montant,Type e) {
        this.remboursement = mon.calculerRemboursement(montant, e.getPourcentage(numSoin), e.getPlafond(numSoin, montant));
        double nouvPlafond = mon.calculerNouveauPlafond(e.getPlafond(numSoin, montant), remboursement);
        e.setPlafond(numSoin, nouvPlafond);
    }
    public double getRemboursement() {
        return remboursement;
    }
}

