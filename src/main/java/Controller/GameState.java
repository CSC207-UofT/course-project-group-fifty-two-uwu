package main.java.Controller;

import main.java.Entities.ProductName;
import main.java.Entities.ProductMainMenu;
import main.java.UI.Canvas;
import main.java.Entities.ProductInfo;
import main.java.UI.Console;
import main.java.UseCases.GameLogic;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
    final private String START = "start";
    final private String INFO = "info";
    final private String EXIT = "exit";
    final private String CONTINUE = "continue";
    final private String RETRY = "retry";
    final private String NEW_USER_NAME = "newUsername";
    private final int STATE_IN_PROGRESS = 0;
    private final int STATE_GAME_START = 5;
    private final int STATE_GAME_PAUSE = 6;
    private final int STATE_USER_NAME = 7;
    private final int STATE_GAME_OVER = 8;
    private final int STATE_EXIT = 9;

    Console console;
    Canvas canvas;
    GameLogic gameLogic;
    GameParameters gameParameters;
    Iterator<JPanel> iterator;
    public static final int CANVAS_WIDTH = 700;
    public static final int CANVAS_HEIGHT = 600;
    private final JFrame mainFrame;
    private int keyPressed;
    private int gameState; // 0 - start, 1 - exit continue, 9 - exit
    private final long startTime;
    private boolean paintIsAllowed = true;
    private boolean doSomething = true;
    private String username = "";
    private JTextField jTextField = new JTextField("Welcome in GameState.");
    ProductName productName = new ProductName();
    ProductMainMenu productMainMenu = new ProductMainMenu();
    ProductInfo productInfo = new ProductInfo();
    JLabel jLabel;
    JButton bStart;
    JButton bInfo;
    JButton bExit;

    public GameState(){
        mainFrame = new JFrame("Missile Mayhem");
        mainFrame.getContentPane();
        mainFrame.setSize(CANVAS_WIDTH,CANVAS_HEIGHT);
        mainFrame.setVisible(true);
        this.getUserName();
        if (this.username.equals("")) {
            gameState = STATE_USER_NAME;
        }
        else {
            gameState = STATE_GAME_START;
        }
        this.gameLogic = new GameLogic();
        this.gameLogic.setUserName(this.username);
        this.iterator = gameLogic.iterator();
        this.console = new Console(this.mainFrame);
        this.gameParameters = new GameParameters();
        this.canvas = new Canvas(mainFrame, gameParameters);
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
            System.out.println("GameState user name = " + text);
        } catch (FileNotFoundException e) {
            System.out.println("Reading error occurred.");
            e.printStackTrace();
        }
    }

    public void update(){
        JPanel jPanel;
        String jButtonEvent;
        if (this.gameState == STATE_IN_PROGRESS) {
            if (gameParameters.isCollisionDetected()){
                //System.out.println("BOOM");
                gameParameters.setHits();
                if (gameParameters.getHits() > 10){
                    this.gameState = STATE_GAME_OVER;
                }
            }
        }
        else if (this.gameState == STATE_GAME_START) {
            paintIsAllowed = false;
            if (doSomething) {
//                System.out.println("GameState >>> gameState = " + gameState);
                doSomething = false;
                this.mainFrame.getContentPane().removeAll();
                this.mainFrame.getContentPane().revalidate();
//                System.out.println("GameState >>> check 1");
                this.mainFrame.getContentPane().add(productMainMenu);
//                System.out.println("GameState >>> check 2");
                this.mainFrame.revalidate();
//                System.out.println("GameState >>> check 3");
                // productMainMenu. getJLabel().setText(productMainMenu.getJLabel().getText() + " " + this.username);
                productMainMenu.setUsername(this.username);
//                System.out.println("GameState >>> check 4");
                productMainMenu.setEvent("");
//                System.out.println("GameState >>> check 5");
                this.mainFrame.repaint();
//                System.out.println("GameState >>> check 6");
            }
            if (productMainMenu.getEvent().length() > 0) {
//                System.out.println("GameState >>> gameState = 7 event = " + productMainMenu.getEvent().length());
                if (productMainMenu.getEvent().equals(START)) {
                    gameParameters.setStartTime(System.currentTimeMillis());
                    gameParameters.startGame();
                    gameState = STATE_IN_PROGRESS;
                }
                else if (productMainMenu.getEvent().equals(INFO)) {
                    gameState = STATE_GAME_PAUSE;
                }
                else if (productMainMenu.getEvent().equals(NEW_USER_NAME)) {
                    System.out.println("GameState >>> gameState get new username");
                    gameState = STATE_USER_NAME;
                }
                else if (productMainMenu.getEvent().equals(NEW_USER_NAME)) {
                    System.out.println("GameState >>> gameState get new username");
                    gameState = 7;
                }
                else if (productMainMenu.getEvent().equals(EXIT)) {
                    gameState = STATE_EXIT;
                }
                productMainMenu.getJLabel().setText("");
                this.mainFrame.getContentPane().removeAll();
                this.mainFrame.getContentPane().revalidate();
                paintIsAllowed = true;
                doSomething = true;
            }
        }
        else if (this.gameState == STATE_GAME_PAUSE) {
            paintIsAllowed = false;
            if (doSomething) {
                // System.out.println("GameState >>> gameState = " + gameState);
                doSomething = false;
                this.gameParameters.pauseGame();
                this.mainFrame.getContentPane().removeAll();
                this.mainFrame.getContentPane().revalidate();
                this.mainFrame.getContentPane().add(productInfo);
                this.mainFrame.revalidate();
                this.mainFrame.repaint();
            }
            // System.out.println("GameState state = 6 event = " + productInfo.getEvent());
            if (this.productInfo.getEvent().length() > 0) {
                if (this.productInfo.getEvent().equals(CONTINUE)) {
                    if (this.gameParameters.isGameStarted()){
                        System.out.println("GameState code = " + CONTINUE + " 6 --> 0");
                        this.gameParameters.resumeGame();
                        this.gameState = STATE_IN_PROGRESS;
                    }
                    else {
                        this.gameState = STATE_GAME_START;
                    }
                }
                else if (productInfo.getEvent().equals(EXIT)){
                    System.out.println("GameState code = " + EXIT + " 6 --> 9");
                    gameState = STATE_EXIT;
                }
                productInfo.setEvent("");
                this.mainFrame.getContentPane().removeAll();
                this.mainFrame.getContentPane().revalidate();
                paintIsAllowed = true;
                doSomething = true;
            }
        }
        else if (this.gameState == STATE_USER_NAME) {
            paintIsAllowed = false;
            if (doSomething) {
//                System.out.println("GameState gameState = 7 do something username = " + productName.getUsername());
                doSomething = false;
                this.mainFrame.getContentPane().removeAll();
                this.mainFrame.getContentPane().revalidate();
                this.mainFrame.getContentPane().add(productName);
                this.mainFrame.revalidate();
                this.mainFrame.repaint();
                // JTextField gets focus
                // it does not work though
                this.mainFrame.addWindowListener( new WindowAdapter() {
                    public void windowOpened( WindowEvent e ){
                        productName.getTextField().requestFocus();
                    }
                });
            }
           // System.out.println("GameState gameState = 7 username = " + productName.getUsername());
            if (productName.getUsername().length() > 1) {
//                System.out.println("GameState gameState = 7 B");
                setUsername(productName.getUsername());
                writeToFile(productName.getUsername());
                productName.setUsername("");
                this.mainFrame.getContentPane().removeAll();
                this.mainFrame.getContentPane().revalidate();
                paintIsAllowed = true;
                doSomething = true;
                this.gameState = STATE_GAME_START;
            }
        }
        else if (this.gameState == STATE_GAME_OVER){
            paintIsAllowed = false;
            if (doSomething) {
//                System.out.println("GameState A gameState = " + STATE_GAME_OVER);
                doSomething = false;
                gameLogic.update(this.gameState);
                this.canvas.update(this.iterator, keyPressed, getTimeElapsed());
                this.canvas.paint();
//                this.mainFrame.getContentPane().removeAll();
//                this.mainFrame.getContentPane().revalidate();
//                this.mainFrame.getContentPane().add(productName);
//                this.mainFrame.revalidate();
//                this.mainFrame.repaint();
            }
            //System.out.println("GameState B gameState = " + STATE_GAME_OVER);
            if (this.gameParameters.getEvent().length() > 1) {
                if (this.gameParameters.getEvent().equals(EXIT)){
                    this.gameState = STATE_EXIT;
                }
                else if (this.gameParameters.getEvent().equals(RETRY)){
                    this.gameState = STATE_GAME_START;
                }
                this.gameParameters.clear();
                paintIsAllowed = true;
                doSomething = true;
            }
        }
        if (paintIsAllowed) {
            gameLogic.update(this.gameState);
            this.setKeyPressed(console.getKeyPressed());
            this.canvas.update(this.iterator, keyPressed, getTimeElapsed());
            this.canvas.paint();
        }
    }

    public void setKeyPressed(int keyPressed) {
        if (this.gameState == STATE_IN_PROGRESS) {
            if (!mainFrame.hasFocus()){
                mainFrame.requestFocus();
            }
            if (keyPressed == 27){ // ESC
                this.gameState = STATE_GAME_PAUSE;
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
                this.gameState = STATE_EXIT; // Will exit
            }
            else if (keyPressed != 0){
                this.gameState = STATE_IN_PROGRESS; // Will continue
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

    public void setUsername(String s){
        this.username = s;
    }

    public void closeMainFrame(){
        mainFrame.dispose();
    }

    public int getGameState() {return this.gameState;}

    public String getTimeElapsed(){
        return String.valueOf((System.currentTimeMillis() - this.startTime)/1000);
    }
}