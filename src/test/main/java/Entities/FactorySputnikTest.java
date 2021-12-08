package main.java.Entities;

import junit.framework.TestCase;

public class FactorySputnikTest extends TestCase {

    public void testGetProduct() {
        FactorySputnik factorySputnik = new FactorySputnik();
        Sputnik sputnik = factorySputnik.getProduct(10, 100, 1, "pathFall");
        assertEquals(10, sputnik.getX());
        assertEquals(100, sputnik.getY());
    }
}