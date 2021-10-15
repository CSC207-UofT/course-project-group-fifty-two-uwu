import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class HumanPlayerTest {
    Stat hp = new Stat("HP", "Health Points", 100, 0, 100);
    Stat madness = new Stat("Madness", "The diversion of logics", 50);
    Stat mana = new Stat("Magic Power", "Magic Points", 33);
    Stat suspicion = new Stat("Suspicion", "The attention of others",
            200, 0, 300);
    ArrayList<Stat> StatList = new ArrayList<>(Arrays.asList(hp, madness, mana, suspicion));
    HumanPlayer booboo = new HumanPlayer("Booboo the Fool", StatList, 2);
    Item reminiscence = new Reminiscence();
    Item consolation = new Consumable("Consolation", "Offers a fleeting moment of joy...", 2);

    @Test(timeout = 50)
    public void testConstrutor() {
        assertEquals(StatList, booboo.getStats());
        assertEquals("Booboo the Fool", booboo.getName());
    }

    @Test(timeout = 50)
    public void testPrintStats() {
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("HP", "Madness", "Magic Power", "Suspicion"));
        assertEquals(expected, booboo.printStats());
    }

    @Test(timeout = 50)
    public void testValue() {
        int hp = booboo.value("HP");
        int suspicion = booboo.value("Sus");
        assertEquals(100, hp);
        assertEquals(-1, suspicion);
    }

    @Test(timeout = 50)
    public void testChange() {
        booboo.change("Madness", 25);
        booboo.change("Magic Power", -50);
        assertEquals(75, booboo.value("Madness"));
        assertEquals(0, booboo.value("Magic Power"));
    }

    @Test(timeout = 50)
    public void testAdd() {
        assertTrue(booboo.addItem(reminiscence));
        assertEquals(1, booboo.getCapacity());
        assertFalse(booboo.addItem(consolation));
    }

    @Test(timeout = 50)
    public void testPrintInventory() {
        booboo.addItem(reminiscence);
        ArrayList<String> names = new ArrayList<>();
        names.add(reminiscence.getName());
        assertEquals(names, booboo.printInventory());
    }

    @Test(timeout = 50)
    public void testRemove() {
        assertFalse(booboo.removeItem("Reminiscence"));
        booboo.addItem(reminiscence);
        booboo.removeItem("Reminiscence");
        assertEquals(2, booboo.getCapacity());
        assertTrue(booboo.getInventory().isEmpty());
        booboo.addItem(consolation);
        assertTrue(booboo.removeItem("Consolation"));
        assertEquals(1, booboo.getCapacity());
        assertFalse(booboo.getInventory().isEmpty());
        ArrayList<String> names = new ArrayList<>();
        names.add("Consolation");
        assertEquals(names, booboo.printInventory());
    }

    @Test(timeout = 50)
    public void testUse() {
        booboo.addItem(reminiscence);
        booboo.use("Reminiscence");
        assertEquals(25, booboo.value("Madness"));
        assertEquals(2, booboo.getCapacity());
        booboo.addItem(consolation);
        booboo.use("Consolation");
        assertEquals(1, booboo.getCapacity());
        ArrayList<String> names = new ArrayList<>();
        names.add("Consolation");
        assertEquals(names, booboo.printInventory());
    }
}