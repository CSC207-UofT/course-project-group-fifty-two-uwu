package main.java.Entities;

import main.java.Controller.GameParameters;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * @author Terry
 * @version 1
 * @since December 2, 2021
 *
 * This is the class that creates the name screen for the game.
 */
public class ScreenName extends JPanel{
    private TextField textField = new TextField();
    private JLabel jLabel = new JLabel();
    private String username = "";
    private GameParameters gameParameters;

    /**
     * The main method, creates the gameover screen using jLabel and jButton.
     * It will try to read some images, and if it fails, it will tell the user that the image is not found.
     */
    public ScreenName(){
        this.textField.setFont(new Font("SansSerif", Font.BOLD, 18));
        this.textField.setText("");
        this.textField.setBounds(200, 200, 240, 28);
        this.textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.out.println("The entered text is: " + event.getActionCommand());
                // setUsername(event.getActionCommand());
                gameParameters.setEvent(event.getActionCommand());
            }
        });
        jLabel.setFont(new Font("MS Song", Font.BOLD, 14));
        jLabel.setText("Enter your name | \u4f60\u7684\u540d\u5b57 " + this.username);
        jLabel.setBounds(202, 170, 240, 28);
        setLayout(null);
        add(textField);
        add(jLabel);
    }

    /**
     * A setter function for this.username.
     *
     * @param s the userame that this.username will store
     */
    public void setUsername(String s){
        System.out.println("Product setUsername = " + s);
        this.username = s;
    }

    /**
     * A getter function for this.username.
     *
     * @return the username that this.username will store
     */
    public String getUsername(){
        // System.out.println("Product getUsername = " + this.username);
        return this.username;
    }

    /**
     * initializes and set this.gameParameters to the parameter given for the method.
     *
     * @param gameParameters the GamesParameters object that this.gameParameters will store.
     */
    public void injectGameParameters(GameParameters gameParameters){this.gameParameters = gameParameters;}

    /**
     *A getter function for this.jLabel.
     *
     * @return the jLabel object stored in this.jLabel
     */
    public JLabel getJLabel(){
        return this.jLabel;
    }

    /**
     * A getter function for textField.
     *
     * @return a TextField object stored in textField.
     */
    public TextField getTextField(){
        return textField;
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
    }
}
