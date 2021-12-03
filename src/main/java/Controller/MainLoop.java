package main.java.Controller;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/**
 * @author Edward
 * @version 3
 * @since December 2, 2021
 *
 * This class is where the game starts. It contains only main().
 */
public class MainLoop {


    /**
     * Creates class GameState and updates it at an interval of sleepTime.
     * <p>
     * The loop runs as long as gameIsOver is not true.
     * The value of gameIsOver can be changed when GameState enters state = 9,
     * which indicates that the user hit the button NEXT.
     * The loop does nothing for the period specified by sleepTime.
     * It then calls on GameState to update itself and falls asleep for
     * the period of sleep time.
     *
     * @param args      unused standard parameters of main()
     */
    public static void main(String[] args) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        long sleepTime = 18; // update every 18 milliseconds
        boolean gameIsOver = false; // will stop the loop
        // create a new game
        GameState gameState = new GameState();
        long awakeTime = System.currentTimeMillis(); // time to move on with the game
        while(!gameIsOver){
            while(System.currentTimeMillis() < awakeTime) {
                // idle time
            }
            gameState.update(); // prompt class GameState to update itself
            awakeTime += sleepTime; // time for next action
            if (gameState.getGameState() == 9){ // user wants to exit
                gameState.closeMainFrame();
                gameIsOver = true;
            }
        }
        System.out.println("Game finished");
    }
}