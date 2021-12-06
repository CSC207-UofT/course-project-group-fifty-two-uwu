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
 * @author Edward
 * @version 1
 * @since December 2, 2021
 *
 * This is the class that creates the gameover screen for the game.
 */

public class ScreenGameOver extends JPanel{
    final private String RETRY = "retry";
    final private String EXIT = "exit";
    private String event = "";
    private JButton bRetry =new JButton("Retry");
    private JButton bExit =new JButton("Exit");
    private JLabel jLabel = new JLabel();
    private JLabel jLabelTopScores = new JLabel();
    private File pathNameRetry = new File("src/main/resources/iconRetry.png");
    private File pathNameExit = new File("src/main/resources/iconExit.png");
    private File pathBackground = new File("src/main/resources/backgroundMainMenu.png");
//    private ImageIcon imageIconContinue;
    private ImageIcon imageIconExit;
    private Image background;
    private BufferedImage bufferedImage;
    private GameParameters gameParameters;

    /**
     * The main method, creates the gameover screen using jLabel and jButton.
     * It will try to read some images, and if it fails, it will tell the user that the image is not found.
     */
    public ScreenGameOver(){
        jLabel.setFont(new Font("MS Song", Font.BOLD, 32));
        jLabel.setText("");
        jLabel.setBounds(210, 150, 300, 100);
        jLabelTopScores.setFont(new Font("MS Song", Font.BOLD, 16));
        jLabelTopScores.setBounds(270, 420, 300, 110);
        String text = "<html>14 sec ... Terry1Alpha<br>8 sec ...... \u6536\u503a\u6d41\u6c13<br>" +
                "7 sec ...... \u9ebb\u8fa3\u9999\u9505<br>2 sec ...... apple8ball<br>2 sec ...... Yanrexx</html>";
//        String text = "<html>1. Terry1Alpha 24<br>2. \u6536\u503a\u6d41\u6c13 8<br>" +
//                "3. \u9ebb\u8fa3\u9999\u9505 7<br>4. apple8ball 2<br>5. Yanrexx 2</html>";
//        String text = "<html><ul>" +
//                "<li>24 - Terry1Alpha</li><li>8 - \u6536\u503a\u6d41\u6c13</li>" +
//                "<li>7 - \u9ebb\u8fa3\u9999\u9505</li><li>D</li>" +
//                "<li>E</li></ul></html>";
        jLabelTopScores.setText(text);
        try {
            bufferedImage = ImageIO.read(pathNameRetry);
            bRetry.setIcon(new ImageIcon(bufferedImage));
        }
        catch (IOException e) {
            System.out.println("Image for ProductInfo Exit not found");
        }
        try {
            bufferedImage = ImageIO.read(pathNameExit);
            bExit.setIcon(new ImageIcon(bufferedImage));
        }
        catch (IOException e) {
            System.out.println("Image for ProductInfo Exit not found");
        }
        try {
            bufferedImage = ImageIO.read(pathBackground);
            background = bufferedImage;
        }
        catch (IOException e) {
            System.out.println("Image for ProductInfo Exit not found");
        }
        bRetry.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // System.out.println("bRetry e = " + e.toString());
                setEvent(RETRY);
                gameParameters.setEvent(RETRY);
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
        bRetry.setBounds(200, 340, 140, 50);
        bExit.setBounds(360, 340, 140, 50);
        setLayout(null);
        add(bRetry);
        add(bExit);
        add(jLabel);
        add(jLabelTopScores);
    }

    /**
     * Draw the Graphics object g and put it at (0, 0).
     *
     * @param g the graphics that will be drawn
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, null);
    }

    public void injectGameParameters(GameParameters gameParameters){this.gameParameters = gameParameters;}

    /**
     * Setter function for this.event.
     *
     * @param s the string representation of the event you want to set for this.event
     */
    public void setEvent(String s){this.event = s;}

    /**
     * Getter function for this.event.
     *
     * @return string stored in this.event
     */
    public String getEvent(){return this.event;}

    /**
     * Getter function for this.bRetry
     *
     * @return the JButton stored in this.bRetry (the retry button)
     */
    public JButton getBRetry(){return this.bRetry;}

    /**
     * Getter function for this.bExit.
     *
     * @return the JButton stored in this.bExit (the exit button)
     */
    public JButton getBExit(){return this.bExit;}

    /**
     * Getter function for this.jLabel.
     *
     * @return the JLabel stored in this.jLabel
     */
    public JLabel getJLabel(){return this.jLabel;}

    /**
     * Getter function for this.jLabelTopScores.
     *
     * @return the JLabel stored in this.jLabelTopScores
     */
    public JLabel getJLabelTopScores(){return this.jLabelTopScores;}
}