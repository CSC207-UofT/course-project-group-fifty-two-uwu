package main.java.Entities;

import junit.framework.TestCase;

public class PathFallTest extends TestCase {

    public void testUpdate() {
        PathFall p = new PathFall();
        p.update(100, 100, 1.0, 200, 200);
        String temp = "x = " + p.getX() + " y = " + p.getY() + " v = " + p.getV();
        assertEquals("x = 101 y = 102 v = 1.0", temp);

        p.update(101, 102, 1.0, 200, 200);
        p.update(102, 104, 1.0, 200, 200);
        p.update(103, 106, 1.0, 200, 200);
        temp = "x = " + p.getX() + " y = " + p.getY() + " v = " + p.getV();
        assertEquals("x = 104 y = 108 v = 1.0", temp);

//        p.update(103, 720, 1.0, 200, 200);
//        temp = "x = " + p.getX() + " y = " + p.getY() + " v = " + p.getV();
//        assertEquals("x = 460 y = -17 v = 2.26927710048873", temp);
//        System.out.println("x = " + p.getX() + " y = " + p.getY() + " v = " + p.getV());
    }

    public void testGetX() {
        PathFall p = new PathFall();
        p.update(100, 100, 1.0, 200, 200);
        assertEquals(101, p.getX());
    }

    public void testGetY() {
        PathFall p = new PathFall();
        p.update(100, 100, 1.0, 200, 200);
        assertEquals(102, p.getY());
    }

    public void testGetV() {
        PathFall p = new PathFall();
        p.update(100, 100, 1.0, 200, 200);
        assertEquals(1.0, p.getV());
    }
}