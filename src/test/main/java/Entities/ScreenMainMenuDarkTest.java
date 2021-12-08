package main.java.Entities;

import junit.framework.TestCase;

public class ScreenMainMenuDarkTest extends TestCase {

    public void testGetJLabel() {
        ScreenMainMenuDark screenMainMenuDark = new ScreenMainMenuDark();
        assertTrue(screenMainMenuDark.getJLabel().getText().contains("Welcome"));
    }

    public void testGetUsername() {
        ScreenMainMenuDark screenMainMenuDark = new ScreenMainMenuDark();
        screenMainMenuDark.setUsername("Butt");
        assertEquals("Butt", screenMainMenuDark.getUsername());
    }
}