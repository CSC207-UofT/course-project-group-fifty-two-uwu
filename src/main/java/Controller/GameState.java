package main.java.Controller;

import main.java.UI.Canvas;
import main.java.UI.Console;
import main.java.UI.ScoreBoard;
import main.java.UseCases.GameLogic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
import javax.sound.sampled.*;
import javax.swing.*;

/**
 * GameState keeps track of the game stage, the position of the image that the user
 * can control (target/pilot), and the clock. It calls on class Console to get user
 * input and decides on the stage of the game, e.g., 0 - in progress, 9 - exit.
 * It passes target coordinates and the clock value to class Canvas and calls on
 * class Canvas to paint the screen.
 *
 * @author Yan Nowaczek yan.nowaczek@mail.utoronto.ca
 * @author Terry
 * @author Edward
 * @version G
 * @since 1.0 November 7, 2021
 */
public class GameState extends JFrame {
    /**
     * These are Strings to capture events
     */
    final private String START = "start";
    final private String INFO = "info";
    final private String EXIT = "exit";
    final private String CONTINUE = "continue";
    final private String RETRY = "retry";
    final private String NEW_USER_NAME = "newUsername";
    /**
     * GameStates are stored as integers
     */
    private final int STATE_IN_PROGRESS = 0; // Game is in progress
    private final int STATE_GAME_START = 5; // Contains MainMenu and Start button
    private final int STATE_GAME_PAUSE = 6; // Pause screen and pauses the clock
    private final int STATE_USER_NAME = 7; // Username input Screen
    private final int STATE_GAME_OVER = 8; // GameOver screen
    private final int STATE_EXIT = 9; // This state terminates the program, the variable is passed to MainLoop

    /**
     * All 5 classes are created
     */
    private final Console console; // Key input
    private final Canvas canvas; // Displays JPanels
    private final GameLogic gameLogic; // Assembles JPanels into an array
    private final GameParameters gameParameters; // A board to exchange game state values
    private final ScoreBoard scoreBoard; // A reader and a writer
    private final Iterator<JPanel> iterator; // An array of active JPanels

    private final JFrame mainFrame;

    /**
     * This class communicates with UseCase classes using
     * only Strings, integers, and booleans.
     */
    private int keyPressed;
    private int gameState;
    private final long startTime; // This is when the game starts in milliseconds
    private boolean paintIsAllowed = true; // Repeated painting disabled for stationary JPanels
    private boolean doSomethingOnce = true; // A sequence needs to be executed only once
    private String username = "";

    /**
     * At start, the following happens:
     * -    JFrame is created and resized
     * -    Username is imported from an external file
     * -    If the user doesn't exist, then the input screen is displayed
     * -    Otherwise, the user is directed to the MainMenu
     * -    Initializes: GameLogic, Iterator, GameParameters, Console, Canvas, and Scoreboard
     */
    public GameState(){
        this.mainFrame = new JFrame("Missile Mayhem");
        this.mainFrame.getContentPane();
        /**
         * JFrame window size
         */
        int CANVAS_WIDTH = 700;
        int CANVAS_HEIGHT = 600;
        this.mainFrame.setSize(CANVAS_WIDTH, CANVAS_HEIGHT);
        this.mainFrame.setVisible(true);
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
        this.canvas = new Canvas(this.mainFrame, gameParameters);
        this.scoreBoard = new ScoreBoard();
        this.startTime = System.currentTimeMillis();
    }

    /**
     * Reads the username stored in stats.txt, if there is none,
     * it updates the username with empty string.
     * The user will be directed to input screen if
     * no name is in stats.txt
     */
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
            System.out.println("Error occured while reading stats.txt.");
            e.printStackTrace();
        }
    }

    /**
     * Performs various actions depending on the state of the game.
     * If the state involves a stationary JPanel, then it waits for event.
     * Depending on the event, it switched to a different state.
     * It continuously updates GameLogic and Canvas when the game is in progress.
     */
    public void update() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        /**
         * When the game is in progress, the number of hits indicates
         * when to switch to the GameOver state. The max number of hits is 11.
         */
        if (this.gameState == STATE_IN_PROGRESS) {
            if (gameParameters.isCollisionDetected()){
                gameParameters.setHits();
                if (gameParameters.getHits() > 10){
                    this.gameState = STATE_GAME_OVER;
                }
            }
        }
        /**
         * This is the state where it will display the MainMenu.
         * The first part is executed once.
         * -    username can be new and GameParameters must be updated
         * -    GameLogic is invoked only once to
         *      turn on the MainMenu panel.
         * -    Canvas is invoked only once to update and display the JPanel.
         * The second part waits for an input from the user.
         * -    Depending on the value of the event, a new gameState is selected.
         * -    The no-paint and do-it-once variables are set to true.
         */
        else if (this.gameState == STATE_GAME_START) {
            paintIsAllowed = false;
            if (doSomethingOnce) {
                this.doSomethingOnce = false;
                this.gameParameters.setUsername(this.username);
                this.gameLogic.update(this.gameState);
                this.canvas.update(this.iterator, keyPressed, getTimeElapsed());
                this.canvas.paint();


                // to store current position
                Long currentFrame;
                Clip clip;
                // current status of clip
                String status;
                AudioInputStream audioInputStream;
                String filePath;
                audioInputStream = AudioSystem.getAudioInputStream(new File("src/main/resources/SoundBegin.wav"));
                // create clip reference
                clip = AudioSystem.getClip();
                // open audioInputStream to the clip
                clip.open(audioInputStream);
                // clip.loop(Clip.LOOP_CONTINUOUSLY);
                clip.loop(0);


            }
            if (this.gameParameters.getEvent().length() > 0){
                if (this.gameParameters.getEvent().equals(START)) {
                    gameParameters.setStartTime(System.currentTimeMillis());
                    gameParameters.startGame();
                    gameState = STATE_IN_PROGRESS;
                }
                else if (this.gameParameters.getEvent().equals(NEW_USER_NAME)) {
                    System.out.println("GameState >>> gameState get new username");
                    gameState = STATE_USER_NAME;
                }
                else if (this.gameParameters.getEvent().equals(INFO)) {
                    System.out.println("GameState >>> gameState get new username");
                    gameState = STATE_GAME_PAUSE;
                }
                else if (this.gameParameters.getEvent().equals(EXIT)) {
                    gameState = STATE_EXIT;
                }
                this.gameParameters.setEvent("");
                paintIsAllowed = true;
                doSomethingOnce = true;
            }
        }
        /**
         * When the game is paused, the appropriate panel is
         * displayed and there are no repeated calls for
         * displaying the JPanels. The program waits for the input.
         * If the event is CONTINUE and the game already started,
         * GameParameters are notified to adjust the game time.
         * If the event is EXIT, then the game terminates.
         */
        else if (this.gameState == STATE_GAME_PAUSE) {
            paintIsAllowed = false;
            if (doSomethingOnce) {
                this.doSomethingOnce = false;
                this.gameParameters.pauseGame();
                this.gameLogic.update(this.gameState);
                this.canvas.update(this.iterator, keyPressed, getTimeElapsed());
                this.canvas.paint();

                // to store current position
                Long currentFrame;
                Clip clip;
                // current status of clip
                String status;
                AudioInputStream audioInputStream;
                String filePath;
                audioInputStream = AudioSystem.getAudioInputStream(new File("src/main/resources/SoundPause.wav"));
                // create clip reference
                clip = AudioSystem.getClip();
                // open audioInputStream to the clip
                clip.open(audioInputStream);
                // clip.loop(Clip.LOOP_CONTINUOUSLY);
                clip.loop(0);


            }
            if (this.gameParameters.getEvent().length() > 1) {
                if (this.gameParameters.getEvent().equals(CONTINUE)) {
                    if (this.gameParameters.isGameStarted()){
                        System.out.println("GameState code = " + CONTINUE + " 6 --> 0");
                        this.gameParameters.resumeGame();
                        this.gameState = STATE_IN_PROGRESS;
                    }
                    else {
                        System.out.println("GameState code = " + CONTINUE + " 6 --> 5");
                        this.gameState = STATE_GAME_START;
                    }
                }
                else if (this.gameParameters.getEvent().equals(EXIT)){
                    System.out.println("GameState code = " + EXIT + " 6 --> 9");
                    gameState = STATE_EXIT;
                }
                paintIsAllowed = true;
                doSomethingOnce = true;
            }
            this.gameParameters.setEvent("");
        }
        /**
         * The user is asked to input a username.
         * The continuous repainting of JPanels
         * is stopped, waiting for the input.
         * The input must be at least 2 characters.
         * After that, the game is changed to MainMenu.
         */
        else if (this.gameState == STATE_USER_NAME) {
            paintIsAllowed = false;
            if (doSomethingOnce) {
                doSomethingOnce = false;
                this.gameLogic.update(this.gameState);
                this.canvas.update(this.iterator, keyPressed, getTimeElapsed());
                this.canvas.paint();
            }
            if (this.gameParameters.getEvent().length() > 1) {
                setUsername(this.gameParameters.getEvent());
                writeToFile(this.gameParameters.getEvent());
                paintIsAllowed = true;
                doSomethingOnce = true;
                this.gameState = STATE_GAME_START;
                this.gameParameters.setEvent("");
            }
        }
        /**
         * In this state, the GameOver screen is displayed
         * once, and the program awaits for the input.
         * If the input is RETRY, then GameParameters are
         * set to default values and the user is directed
         * to the MainMenu. The GameOver screen displays
         * the score of the current user and the TopFive
         * high scores, fetched from an external file.
         */
        else if (this.gameState == STATE_GAME_OVER){
            paintIsAllowed = false;
            if (doSomethingOnce) {
                doSomethingOnce = false;
                gameLogic.update(this.gameState);
                scoreBoard.addScore(this.username, Integer.valueOf(gameParameters.getScore()));
                gameParameters.setTopFive(scoreBoard.topFive());
                this.canvas.update(this.iterator, keyPressed, getTimeElapsed());
                this.canvas.paint();


                // to store current position
                Long currentFrame;
                Clip clip;
                // current status of clip
                String status;
                AudioInputStream audioInputStream;
                String filePath;
                audioInputStream = AudioSystem.getAudioInputStream(new File("src/main/resources/SoundGameOver.wav"));
                // create clip reference
                clip = AudioSystem.getClip();
                // open audioInputStream to the clip
                clip.open(audioInputStream);
                // clip.loop(Clip.LOOP_CONTINUOUSLY);
                clip.loop(0);

            }
            if (this.gameParameters.getEvent().length() > 1) {
                if (this.gameParameters.getEvent().equals(EXIT)){
                    this.gameState = STATE_EXIT;
                }
                else if (this.gameParameters.getEvent().equals(RETRY)){
                    this.gameState = STATE_GAME_START;
                }
                this.gameParameters.clear();
                paintIsAllowed = true;
                doSomethingOnce = true;
            }
        }
        /**
         * This sequence is executed when there is no stationary
         * panel displayed.
         */
        if (paintIsAllowed) {
            gameLogic.update(this.gameState);
            this.setKeyPressed(console.getKeyPressed());
            this.canvas.update(this.iterator, keyPressed, getTimeElapsed());
            this.canvas.paint();
        }
    }

    /**
     * This method handles the keys entered while
     * the game is in progress.
     * If the user enters ESC, the game state changes
     * to 6, which is pause.
     * If the user enters any of the arrow keys, the pilot will move.
     *
     * @param keyPressed    The integer value of the key
     */
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
    }

    /**
     * Writes the username into an external file, stats.txt.
     *
     * @param username   String for username
     */
    public void writeToFile(String username) {
        try {
            FileWriter fileWriter = new FileWriter("stats.txt");
            fileWriter.write(username);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Writing error occurred when writing to stats.txt.");
            e.printStackTrace();
        }
    }

    /**
     * Returns a String with the number of seconds
     * from the start of the game.
     *
     * @return  A String of elapsed seconds
     */
    public String getTimeElapsed(){
        return String.valueOf((System.currentTimeMillis() - this.startTime)/1000);
    }
    public void setUsername(String s){this.username = s;}
    public void closeMainFrame(){mainFrame.dispose();}
    public int getGameState() {return this.gameState;}

}