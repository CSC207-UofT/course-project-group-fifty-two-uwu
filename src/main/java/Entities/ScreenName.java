package main.java.Entities;

import main.java.Controller.GameParameters;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * @author Terry
 * @version 2
 * @since December 7, 2021
 *
 * This is the class that creates the name screen for the game.
 */
public class ScreenName extends JPanel{
    private TextField textField = new TextField();
    private JLabel jLabel = new JLabel();
    private JLabel jLabelInfo = new JLabel();
    private String username = "";
    private GameParameters gameParameters;

    /**
     * The main method, creates the gameover screen using jLabel and jButton.
     * It will try to read some images, and if it fails, it will tell the user that the image is not found.
     * If the player's username character count is <2 or >16,
     * and an error will appear below the input box.
     */
    public ScreenName(){
        final String NAME_RESTRICTION = "<html>At least 2 and at most 16 characters required<br>\u81f3\u5c11" + "" +
                "\u0020\u0032\u0020\u4e2a\uff0c\u6700\u591a\u0020\u0031\u0036\u0020\u4e2a\u5b57\u7b26</html>";
        final String NAME_ENTER = "Enter your name | \u4f60\u7684\u540d\u5b57";
        this.textField.setFont(new Font("SansSerif", Font.BOLD, 18));
        this.textField.setText("");
        this.textField.setBounds(200, 200, 240, 28);
        this.textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                if (event.getActionCommand().length() > 1 && event.getActionCommand().length() < 17){
                    gameParameters.setEvent(event.getActionCommand());
                    setJLabelInfoVisible(false);
                }
                else {
                    setJLabelInfoVisible(true);
                }
            }
        });
        this.jLabel.setFont(new Font("MS Song", Font.BOLD, 14));
        this.jLabel.setText(NAME_ENTER + this.username);
        this.jLabel.setBounds(202, 170, 240, 28);
        this.jLabelInfo.setFont(new Font("MS Song", Font.BOLD, 12));
        this.jLabelInfo.setForeground(Color.RED);
        this.jLabelInfo.setText(NAME_RESTRICTION);
        this.jLabelInfo.setBounds(202, 270, 320, 28);
        this.jLabelInfo.setVisible(false);
        setLayout(null);
        add(this.textField);
        add(this.jLabel);
        add(this.jLabelInfo);
    }

    private void setJLabelInfoVisible(boolean isVisible){
        this.jLabelInfo.setVisible(isVisible);
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
