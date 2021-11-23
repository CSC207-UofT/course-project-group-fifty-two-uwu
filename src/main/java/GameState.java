package main.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
import javax.swing.*;

public class GameState extends JFrame {
    //keeps track of the game stage, the position of the image that the user can control (target/pilot),
    //and the clock. It calls on class Console to get user input and decides on the stage of the game, e.g., 0 - in
    //progress, 9 - exit. It passes target coordinates and the clock value to class
    //Canvas and calls on class Canvas to paint the screen
    Console console;
    Canvas canvas;
    GameLogic gameLogic;
    Iterator<JPanel> iterator;
    public static final int CANVAS_WIDTH = 700;
    public static final int CANVAS_HEIGHT = 600;
    private final JFrame mainFrame;
    private int keyPressed;
    private int gameState; // 0 - start, 1 - exit continue, 9 - exit
    private final long startTime;
    private boolean paintIsAllowed = true;
    private String username = "";

    public GameState(){
        mainFrame = new JFrame("Missile Mayhem");
        // mainFrame.setLayout(null);
        mainFrame.getContentPane();
        mainFrame.setSize(CANVAS_WIDTH,CANVAS_HEIGHT);
        mainFrame.setVisible(true);
        this.getUserName();
        if (this.username.equals("")) {
            gameState = 7;
        }
        else {
            gameState = 5;
        }
        this.console = new Console(this.mainFrame);
        this.canvas = new Canvas(this.mainFrame);
        gameLogic = new GameLogic();
        gameLogic.updateProductContinueExit(username);
        iterator = gameLogic.iterator();
        startTime = System.currentTimeMillis();
    }

    public void getUserName(){
        try {
            File file = new File("stats.txt");
            Scanner scanner = new Scanner(file);
            String text = "";
            while (scanner.hasNextLine()) {
                text = text + " " + scanner.nextLine();
            }
            scanner.close();
            this.username = text;
        } catch (FileNotFoundException e) {
            System.out.println("Reading error occurred.");
            e.printStackTrace();
        }
    }

    public void update(){
        JPanel jPanel;
        String jButtonEvent;
        String jTextFieldEvent;
        // gameLogic.update(gameState);
        if (this.gameState == 5) {
            while (iterator.hasNext()){
                jPanel = iterator.next();
                if (jPanel.getClass().getName().equals("main.java.ProductContinueExit")) {
                    jButtonEvent = ((ProductContinueExit) jPanel).getEvent();
                    switch (jButtonEvent) {
                        case "start" -> {
                            this.gameState = 0;
                            System.out.println("From 5 to 0");
                        }
                        case "info" -> {
                            this.gameState = 6;
                            System.out.println("From 5 to 6");
                        }
                        case "exit" -> {
                            this.gameState = 9;
                            System.out.println("From 5 to 9");
                        }
                    }
                }
            }
        }
        else if (this.gameState == 6) {
            while (iterator.hasNext()){
                jPanel = iterator.next();
                if (jPanel.getClass().getName().equals("main.java.ProductInfo")) {
                    jButtonEvent = ((ProductInfo) jPanel).getEvent();
                    switch (jButtonEvent) {
                        case "continue" -> {
                            this.gameState = 0;
                            System.out.println("From 6 to 0");
                        }
                        case "exit" -> {
                            this.gameState = 9;
                            System.out.println("From 6 to 9");
                        }
                    }
                }
            }
        }
        else if (this.gameState == 7) {
            while (iterator.hasNext()){
                jPanel = iterator.next();
                if (jPanel.getClass().getName().equals("main.java.ProductGetUserName")) {
                    jTextFieldEvent = ((ProductGetUserName) jPanel).getEvent();
                    // System.out.println("In GameState event = " + jTextFieldEvent);
                    if (jTextFieldEvent.length() > 0) {
                        System.out.println("In GameState event2 = " + jTextFieldEvent);
                        writeToFile(jTextFieldEvent);
                        this.gameState = 5;
                        this.username = jTextFieldEvent;
                        gameLogic.updateProductContinueExit(this.username);
                        paintIsAllowed = true;
                        System.out.println("From 7 to 5");
                    }
                    else if (paintIsAllowed){
                        paintIsAllowed = false;
                        gameLogic.update(gameState);
                        this.canvas.update(this.iterator, keyPressed, getTimeElapsed());
                        this.canvas.paint(this.iterator);
                    }
                }
            }
        }
        if (paintIsAllowed) {
            gameLogic.update(gameState);
            this.setKeyPressed(console.getKeyPressed());
            this.canvas.update(this.iterator, keyPressed, getTimeElapsed());
            this.canvas.paint(this.iterator);
        }
    }
    public void setKeyPressed(int keyPressed) {
        if (this.gameState == 0) {
            if (!mainFrame.hasFocus()){
                mainFrame.requestFocus();
            }
            if (keyPressed == 27){ // ESC
                this.gameState = 6;
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

    public void writeToFile(String str) {
        try {
            FileWriter fileWriter = new FileWriter("stats.txt");
            fileWriter.write(str);
            fileWriter.close();
            System.out.println("Successfully wrote to the file");
        } catch (IOException e) {
            System.out.println("Writing error occurred.");
            e.printStackTrace();
        }
    }

    public void closeMainFrame(){
        mainFrame.dispose();
    }

    public int getGameState() {return this.gameState;}

    public String getTimeElapsed(){
        return String.valueOf((System.currentTimeMillis() - this.startTime)/1000);
    }
}
