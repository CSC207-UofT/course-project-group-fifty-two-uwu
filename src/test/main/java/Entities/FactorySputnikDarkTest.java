package main.java.Entities;

import junit.framework.TestCase;

public class FactorySputnikDarkTest extends TestCase {

    public void testGetProduct() {
        FactorySputnikDark factorySputnikDark = new FactorySputnikDark();
        Sputnik sputnik = factorySputnikDark.getProduct(10, 100, 1, "pathFall");
        assertEquals(10, sputnik.getX());
        assertEquals(100, sputnik.getY());
    }
}