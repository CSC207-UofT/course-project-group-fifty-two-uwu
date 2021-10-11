import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StatTest {
    Stat hp = new Stat("HP", "Health Points", 100,0, 100);
    Stat madness = new Stat("Madness", "The diversion of logics",50);
    Stat mana = new Stat("Magic Power", "Magic Points", -1);
    Stat suspicion = new Stat("Suspicion", "The attention of others",
            999, 0, 300);

    @Test(timeout = 50)
    public void testRound(){
        hp.assign(-20);
        madness.assign(999);
        assertEquals(0, hp.getNumber());
        assertEquals(100, madness.getNumber());
    }

    @Test(timeout = 50)
    public void testOverInput(){
        assertEquals(0, mana.getNumber());
        assertEquals(300, suspicion.getNumber());
    }

    @Test(timeout = 50)
    public void testChange(){
        hp.change(-50);
        madness.change(27);
        assertEquals(50, hp.getNumber());
        assertEquals(77, madness.getNumber());
    }
}
