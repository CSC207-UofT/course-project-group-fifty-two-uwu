package main.java.Entities;

import main.java.Controller.GameParameters;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
/**
 * @author Yan Nowaczek
 * @version 1
 * @since December 2, 2021
 *
 * This is the class that creates the main menu screen for the game.
 */
public class ScreenMainMenu extends JPanel{
    final private String START = "start";
    final private String INFO = "info";
    final private String EXIT = "exit";
    final private String NEW_USER_NAME = "newUsername";
    final private String CHANGE_THEME = "changeTheme";
    final private String WELCOME = "Welcome \u4f60\u597d ";
    private BufferedImage bufferedImage;
    private JButton bStart =new JButton("Start");
    private JButton bInfo =new JButton("Info");
    private JButton bExit =new JButton("Exit");
    private JButton bNewUsername =new JButton("New User");
    private JButton bChangeTheme =new JButton("Change Theme");
    private File pathNameStart = new File("src/main/resources/iconStart.png");
    private File pathNameInfo = new File("src/main/resources/iconInfo.png");
    private File pathNameExit = new File("src/main/resources/iconExit.png");
    private File pathNameNewUsename = new File("src/main/resources/iconNewUsername.png");
    private File pathNameChangeTheme = new File("src/main/resources/iconChangeTheme.png");
    private File pathNameBackground = new File("src/main/resources/backgroundInGame.png");
    private JLabel jLabel = new JLabel();
    private String username = "";
    private String event = "";
    private GameParameters gameParameters;
    private BufferedImage background;

    /**
     * The main method, creates the gameover screen using jLabel and jButton.
     * It will try to read some images, and if it fails, it will tell the user that the image is not found.
     */
    public ScreenMainMenu() {
        jLabel.setFont(new Font("MS Song", Font.BOLD, 24));
        jLabel.setText(WELCOME + this.username);
        jLabel.setBounds(210, 150, 300, 28);
        try {
            bufferedImage = ImageIO.read(pathNameStart);
            bStart.setIcon(new ImageIcon(bufferedImage));
        }
        catch (IOException e) {
            System.out.println("Image for iconStart not found");
        }
        try {
            bufferedImage = ImageIO.read(pathNameInfo);
            bInfo.setIcon(new ImageIcon(bufferedImage));
        }
        catch (IOException e) {
            System.out.println("Image for iconInfo not found");
        }
        try {
            bufferedImage = ImageIO.read(pathNameExit);
            bExit.setIcon(new ImageIcon(bufferedImage));
        }
        catch (IOException e) {
            System.out.println("Image for iconExit not found");
        }
        try {
            bufferedImage = ImageIO.read(pathNameNewUsename);
            bNewUsername.setIcon(new ImageIcon(bufferedImage));
        }
        catch (IOException e) {
            System.out.println("Image for iconNewUser not found");
        }
        try {
            bufferedImage = ImageIO.read(pathNameChangeTheme);
            bChangeTheme.setIcon(new ImageIcon(bufferedImage));
        }
        catch (IOException e) {
            System.out.println("Image for iconChangeTheme not found");
        }
        try {
            background = ImageIO.read(pathNameBackground);
            // bChangeTheme.setIcon(new ImageIcon(bufferedImage));
        }
        catch (IOException e) {
            System.out.println("Image for backgroundInGame not found");
        }
        bStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // System.out.println("bStart e = " + e.toString());
                setEvent(START);
                gameParameters.setEvent(START);
            }
        });
        bInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // System.out.println("bInfo e = " + e.toString());
                setEvent(INFO);
                gameParameters.setEvent(INFO);
            }
        });
        bExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // System.out.println("bExit e = " + e.toString());
                setEvent(EXIT);
                gameParameters.setEvent(EXIT);
            }
        });
        bNewUsername.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // System.out.println("bExit e = " + e.toString());
                setEvent(NEW_USER_NAME);
                gameParameters.setEvent(NEW_USER_NAME);
            }
        });
        bChangeTheme.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // System.out.println("bExit e = " + e.toString());
                setEvent(CHANGE_THEME);
                gameParameters.setEvent(CHANGE_THEME);
            }
        });
        bStart.setBounds(270, 200, 140, 50);
        bInfo.setBounds(270, 270, 140, 50);
        bNewUsername.setBounds(270, 340, 140, 50);
        bChangeTheme.setBounds(270, 410, 140, 50);
        bExit.setBounds(270, 480, 140, 50);
        setLayout(null);
        add(bStart);
        add(bInfo);
        add(bChangeTheme);
        add(bExit);
        add(bNewUsername);
        add(jLabel);
    }

    /*
     * A setter function for this.event.
     *
     * @param s the string that this.event will store.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, null);
    }

    public void setEvent(String s){
        this.event = s;
    }

    /*
     * A setter function for this.username.
     *
     * @param s the string that this.username wll store.
     */
    public void setUsername(String s){
        this.username = s;
        jLabel.setText(WELCOME + s);
    }
  
    /*
     * initializes and set this.gameParameters to the parameter given for the method.
     *
     * @param gameParameters the GamesParameters object that this.gameParameters will store.
     */
    public void injectGameParameters(GameParameters gameParameters){this.gameParameters = gameParameters;}

    /*
     * A getter function for this.event.
     *
     * @return string stored in this.event.
     */
    public String getEvent(){
        return this.event;
    }

    /*
     * A getter function for this.bStart.
     *
     * @return a JButton that is the button for start
     */
    public JButton getBStart(){
        return this.bStart;
    }

    /*
     * A getter function for this.bInfo.
     *
     * @return a JButton that is the button for info
     */
    public JButton getBInfo() {return this.bInfo;}

    /*
     * A getter function for this.bExit.
     *
     * @return a JButton that is the button for exit
     */
    public JButton getBExit(){
        return this.bExit;
    }
  
    /*
     * A getter function for this.jLabel.
     *
     * @return the jLabel object stored in this.jLabel
     */
    public JLabel getJLabel(){
        return this.jLabel;
    }
  
    /*
     * A getter function for username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }
}