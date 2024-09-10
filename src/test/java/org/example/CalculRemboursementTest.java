package org.example;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculRemboursementTest {
    private final TypeA a = new TypeA();
    private final TypeB b = new TypeB();
    private final TypeC c = new TypeC();
    private final TypeD d = new TypeD();
    private final TypeE e = new TypeE();

    private int numSoin;

    @Test
    public void testObtenirRemboursementA() {
        CalculRemboursement calc = new CalculRemboursement("A", 100,"1000$", a,b,c,d,e);
        double montantObtenu = calc.getRemboursement();
        double montantAttendu = 250.0;
        assertEquals(montantAttendu,montantObtenu, "Un calcul de remboursement avec le type A devrait obtenir le bon résultat.");
    }

    @Test
    public void testObtenirRemboursementB() {
        CalculRemboursement calc = new CalculRemboursement("B", 400,"100.00$", a,b,c,d,e);
        double montantObtenu = calc.getRemboursement();
        double montantAttendu = 0;
        assertEquals(montantAttendu,montantObtenu, "Un calcul de remboursement avec le type B devrait obtenir le bon résultat.");
    }

    @Test
    public void testObtenirRemboursementC() {
        CalculRemboursement calc = new CalculRemboursement("C", 0,"100.00$", a,b,c,d,e);
        double montantObtenu = calc.getRemboursement();
        double montantAttendu = 90.0;
        assertEquals(montantAttendu,montantObtenu, "Un calcul de remboursement avec le type C devrait obtenir le bon résultat.");
    }
    @Test
    public void testObtenirRemboursementD() {
        CalculRemboursement calc = new CalculRemboursement("D", 200,"250.00$", a,b,c,d,e);
        double montantObtenu = calc.getRemboursement();
        double montantAttendu = 250.0;
        assertEquals(montantAttendu,montantObtenu, "Un calcul de remboursement avec le type D devrait obtenir le bon résultat.");
    }
    @Test
    public void testObtenirRemboursementE() {
        CalculRemboursement calc = new CalculRemboursement("E", 600,"1000.00$", a,b,c,d,e);
        double montantObtenu = calc.getRemboursement();
        double montantAttendu = 150.0;
        assertEquals(montantAttendu,montantObtenu, "Un calcul de remboursement avec le type D devrait obtenir le bon résultat.");
    }
}


