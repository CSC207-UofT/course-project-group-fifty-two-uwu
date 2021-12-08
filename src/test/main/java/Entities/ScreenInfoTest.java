package main.java.Entities;

import junit.framework.TestCase;

public class ScreenInfoTest extends TestCase {

    public void testGetJLabel() {
        ScreenInfo screenInfo = new ScreenInfo();
        assertTrue(screenInfo.getJLabel().getText().contains("\u0020\u79fb\u52a8\u0020"));
    }
}