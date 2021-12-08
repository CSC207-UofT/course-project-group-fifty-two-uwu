package main.java.Entities;

import junit.framework.TestCase;

public class ScreenMainMenuTest extends TestCase {

    public void testSetUsername() {
        ScreenMainMenu screenMainMenu = new ScreenMainMenu();
        screenMainMenu.setUsername("Butt");
        assertEquals("Butt", screenMainMenu.getUsername());
    }

    public void testGetJLabel() {
        ScreenMainMenu screenMainMenu = new ScreenMainMenu();
        assertTrue(screenMainMenu.getJLabel().getText().contains("Welcome"));
    }

    public void testGetUsername() {
        ScreenMainMenu screenMainMenu = new ScreenMainMenu();
        screenMainMenu.setUsername("Butt");
        assertEquals("Butt", screenMainMenu.getUsername());
    }
}