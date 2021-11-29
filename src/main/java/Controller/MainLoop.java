/*
 *
 */

package main.java.Controller;

import java.io.File;
import java.io.IOException;

/* This class contains main(), where all the action begins
 * main() will first create GameState whose constructor will create the canvas
 */
public class MainLoop {
    //contains only main() that repeatedly calls
    //on class GameStatus to update itself and asks if it is time to exit the loop

    public void createFile(){
        File file = new File("stats.txt");
        try {
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                    System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("File access error occurred.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        boolean gameIsOver = false;
        GameState gameState = new GameState();
//        GameState.setUserName(readFromFile());
        long sleepTime = 18;
        long awakeTime = System.currentTimeMillis();
        while(!gameIsOver){
            while(System.currentTimeMillis() < awakeTime) {
                // do nothing
            }
            gameState.update();
            awakeTime += sleepTime;
            if (gameState.getGameState() == 9){
                gameState.closeMainFrame();
                gameIsOver = true;
            }
        }
        System.out.println("finished");
    }
}
