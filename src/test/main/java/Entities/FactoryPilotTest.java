package main.java.Entities;

import junit.framework.TestCase;

/**
 *
 */
public class FactoryPilotTest extends TestCase {


    public void testGetShapePilot() {
        FactoryPilot p = new FactoryPilot();
        assertEquals(19, p.getShapePilot().getHeight());
    }

    public void testGetShapeBoom() {
        FactoryPilot p = new FactoryPilot();
        assertEquals(40, p.getShapeBoom().getHeight());
    }
}