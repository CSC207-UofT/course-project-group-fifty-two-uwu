package main.java.UI;

import junit.framework.TestCase;

import java.io.IOException;

public class FileManagerTest extends TestCase {

    public void testReadTheme() throws IOException {
        FileManager fileManager = new FileManager();
        fileManager.writeTheme("light");
        assertEquals("light", fileManager.readTheme());
    }
}