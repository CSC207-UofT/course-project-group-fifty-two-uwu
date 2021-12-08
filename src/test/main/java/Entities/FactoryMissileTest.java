package main.java.Entities;

import junit.framework.TestCase;

public class FactoryMissileTest extends TestCase {

    public void testGetProduct() {
        FactoryMissile factoryMissile = new FactoryMissile();
        Missile missile = factoryMissile.getProduct(10, 100, 1, "pathFall");
        assertEquals(10, missile.getX());
        assertEquals(100, missile.getY());
    }
}