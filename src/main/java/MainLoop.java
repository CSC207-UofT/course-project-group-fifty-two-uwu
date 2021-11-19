/*
 *
 */

package main.java;

/* This class contains main(), where all the action begins
 * main() will first create GameState whose constructor will create the canvas
 */
public class MainLoop {

    public static void main(String[] args) {
        boolean gameIsOver = false;
        boolean gameIsPaused = false;
        GameState gameState = new GameState();
        int counter = 0;
        long sleepTime = 10;
        long awakeTime = System.currentTimeMillis();
        while(!gameIsOver){
            while(System.currentTimeMillis() < awakeTime) {
                counter++;
            }
            // System.out.println("gameState.getGameState() = " + gameState.getGameState() + " console.getKeyPressed() = " + console.getKeyPressed());
            gameState.update();

            awakeTime += sleepTime;

            if (gameState.getGameState() == 1){
                gameIsPaused = true;
            }
            else {
                gameIsPaused = false;
            }
            if (gameState.getGameState() == 9){
                gameState.closeMainFrame();
                gameIsOver = true;
            }

        }
        //gameState.closeMainFrame();
        System.out.println("finished");
    }
}
