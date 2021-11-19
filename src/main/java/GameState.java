package main.java;

import java.awt.*;
import java.util.Iterator;
import javax.swing.*;

public class GameState extends JFrame {
    Console console;
    Canvas canvas;
    GameLogic gameLogic = new GameLogic();
    Iterator<JPanel> iterator;
    public static final int CANVAS_WIDTH = 700;
    public static final int CANVAS_HEIGHT = 600;
    private final JFrame mainFrame;
    private int keyPressed;
    private int gameState; // 0 - start, 1 - exit continue, 9 - exit


    public GameState(){
        mainFrame = new JFrame("Missile Mayhem");
        mainFrame.setSize(CANVAS_WIDTH,CANVAS_HEIGHT);
        mainFrame.setVisible(true);
        gameState = 0;
        this.console = new Console(this.mainFrame);
        this.canvas = new Canvas(this.mainFrame);
        gameLogic = new GameLogic();
        iterator = gameLogic.iterator();
    }

    public void update(){
        this.setKeyPressed(console.getKeyPressed());
        this.canvas.paint(this.iterator);
        if (gameState != 1) {
            canvas.update(this.iterator, this.keyPressed);
        }
    }
    public void setKeyPressed(int keyPressed) {
        if (this.gameState == 0) {
            if (keyPressed == 27){ // ESC
                this.gameState = 1;
            }
            else if (keyPressed >= 37 && keyPressed <= 40) {
                this.keyPressed = keyPressed;
            }
            else {
                this.keyPressed = keyPressed;
            }
        }
        else if (this.gameState == 1) {
            if (keyPressed == 27){ // ESC
                this.gameState = 9; // Will exit
            }
            else if (keyPressed != 0){
                this.gameState = 0; // Will continue
            }
        }

        if (keyPressed != 0) {
            System.out.println("key = " + keyPressed + " state = " + this.gameState);
        }
    }

    public int getKeyPressed(){
        return keyPressed;
    }

    public void closeMainFrame(){
        mainFrame.dispose();
    }

    public JFrame getMainFrame(){
        return mainFrame;
    }

    public int getGameState() {return this.gameState;}
}
