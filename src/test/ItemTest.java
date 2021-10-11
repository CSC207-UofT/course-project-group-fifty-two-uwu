import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class ItemTest {
    Item reminiscence = new Reminiscence();

    @Test(timeout = 50)
    public void testGetter() {
        String name = reminiscence.getName();
        String description = reminiscence.getDescription();
        assertEquals("Reminiscence", name);
        assertEquals("Scraps of knowledge in time...Reduces the progression of Madness", description);
    }

    @Test(timeout = 50)
    public void testUse() {
        Object effect = reminiscence.use();
        HashMap<String, Integer> expected = new HashMap<>();
        expected.put("Madness", -25);
        assertEquals(expected, effect);
        assertEquals(0, reminiscence.getQuantity());
    }
}
