import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class CheckTest {
    Stat hp = new Stat("HP", "Health Points", 25, 0, 100);
    Stat madness = new Stat("Madness", "The diversion of logics", 15);
    Stat mana = new Stat("Magic Power", "Magic Points", 10);
    Stat suspicion = new Stat("Suspicion", "The attention of others",
            200, 0, 300);
    ArrayList<Stat> StatList = new ArrayList<>(Arrays.asList(hp, madness, mana, suspicion));
    Player booboo = new Player("Booboo the Fool", StatList);

    Check manacheck_always_fail = new Check(99, "Magic Power",
            10, "Madness", 0);
    Check hpcheck_always_pass = new Check(1, "HP", 30);

    @Test(timeout = 50)
    public void testCheck() {
        assertFalse(manacheck_always_fail.check(booboo));
        assertTrue(hpcheck_always_pass.check(booboo));
        assertEquals(25, booboo.value("Madness"));
        assertEquals(25, booboo.value("HP"));
    }

    @Test(timeout = 50)
    public void testResolve() {
        manacheck_always_fail.resolve(booboo);
        hpcheck_always_pass.resolve(booboo);
        assertEquals(25, booboo.value("Madness"));
        assertEquals(25, booboo.value("HP"));
    }
}
