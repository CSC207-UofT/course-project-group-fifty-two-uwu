package main.java.Entities;

import junit.framework.TestCase;

public class FactoryMissileDarkTest extends TestCase {

    public void testGetProduct() {
        FactoryMissileDark factoryMissileDark = new FactoryMissileDark();
        Missile missile = factoryMissileDark.getProduct(10, 100, 1, "pathFall");
        assertEquals(10, missile.getX());
        assertEquals(100, missile.getY());
    }
}