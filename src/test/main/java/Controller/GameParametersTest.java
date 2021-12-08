package main.java.Controller;

import junit.framework.TestCase;

public class GameParametersTest extends TestCase {


    public void testSetStartTime() {
        GameParameters gameParameters = new GameParameters();
        gameParameters.setStartTime(10000);
        assertTrue(gameParameters.getGameTime() > 10000);
    }

    public void testSetCollisionPaused() {
        GameParameters gameParameters = new GameParameters();
        gameParameters.setCollisionPaused(true);
        assertTrue(gameParameters.isCollisionPaused());
    }

    public void testIsCollisionDetected() {
        GameParameters gameParameters = new GameParameters();
        gameParameters.setCollisionDetected(false);
        assertFalse(gameParameters.isCollisionPaused());
    }

    public void testIsBoomOn() {
        GameParameters gameParameters = new GameParameters();
        gameParameters.setCollisionDetected(true);
        assertTrue(gameParameters.isBoomOn());
    }

    public void testIsCollisionPaused() {
        GameParameters gameParameters = new GameParameters();
        gameParameters.setCollisionPaused(true);
        assertTrue(gameParameters.isCollisionPaused());
    }

    public void testGetScore() {
        GameParameters gameParameters = new GameParameters();
        assertEquals("0", gameParameters.getScore());
    }

    public void testClear() {
        GameParameters gameParameters = new GameParameters();
        gameParameters.clear();
        assertEquals("", gameParameters.getEvent());
    }

    public void testResumeGame() {
        GameParameters gameParameters = new GameParameters();
        gameParameters.pauseGame();
        gameParameters.resumeGame();
        assertTrue(gameParameters.isGameStarted());
    }

    public void testPauseGame() {
        GameParameters gameParameters = new GameParameters();
        gameParameters.pauseGame();
        assertTrue(gameParameters.isCollisionPaused());
    }

    public void testStartGame() {
        GameParameters gameParameters = new GameParameters();
        gameParameters.startGame();
        assertFalse(gameParameters.isBoomOn());
    }

    public void testSetUsername() {
        GameParameters gameParameters = new GameParameters();
        gameParameters.setUsername("New Name");
        assertEquals("NewName", gameParameters.getUsername());
    }
}