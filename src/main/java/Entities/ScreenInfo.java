package main.java.Entities;

import main.java.Controller.GameParameters;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author Edward
 * @version 1
 * @since December 2, 2021
 * <p>
 * This is the class that creates the info screen for the game.
 */
public class ScreenInfo extends JPanel {
    final private String CONTINUE = "continue";
    final private String EXIT = "exit";
    private final JButton bContinue = new JButton("Continue");
    private final JButton bExit = new JButton("Exit");
    private final JLabel jLabel = new JLabel();
    private String event = "";
    private ImageIcon imageIconExit;
    private Image background;
    private GameParameters gameParameters;

    /**
     * The main method, creates the info screen using jLabel and jButton.
     * It will try to read some images, and if it fails, it will tell the user that the image is not found.
     */
    public ScreenInfo() {
        jLabel.setFont(new Font("MS Song", Font.BOLD, 24));
        jLabel.setText("<html>Pause - ESC <br>Movement - Arrow Keys<br>" +
                "\u6682\u505c\u0020\u002d\u0020\u8f6c\u4e49\u952e\uff08\u0065\u0073\u0063\uff09<br>" +
                "\u0020\u79fb\u52a8\u0020\u002d\u0020\u65b9\u5411\u952e</html>");
        jLabel.setBounds(210, 120, 300, 200);

        ImageIcon imageIconContinue = new ImageIcon();
        BufferedImage bufferedImage;
        try {
            File pathNameContinue = new File("src/main/resources/iconContinue.png");
            bufferedImage = ImageIO.read(pathNameContinue);
            bContinue.setIcon(new ImageIcon(bufferedImage));
        } catch (IOException e) {
            System.out.println("Image for ProductInfo Continue not found");
        }
        try {
            File pathNameExit = new File("src/main/resources/iconExit.png");
            bufferedImage = ImageIO.read(pathNameExit);
            bExit.setIcon(new ImageIcon(bufferedImage));
        } catch (IOException e) {
            System.out.println("Image for ProductInfo Exit not found");
        }
        try {
            File pathBackground = new File("src/main/resources/backgroundMainMenu.png");
            bufferedImage = ImageIO.read(pathBackground);
            background = bufferedImage;
        } catch (IOException e) {
            System.out.println("Image for ProductInfo Exit not found");
        }
        bContinue.addActionListener(e -> {
            // System.out.println("ProductInfo bContinue e = " + e.toString());
            // setEvent(CONTINUE);
            gameParameters.setEvent(CONTINUE);
        });
        bExit.addActionListener(e -> {
            // System.out.println("ProductInfo bExit e = " + e.toString());
            // setEvent(EXIT);
            gameParameters.setEvent(EXIT);
        });
        bContinue.setBounds(200, 340, 140, 50);
        bExit.setBounds(360, 340, 140, 50);
        setLayout(null);
        add(bContinue);
        add(bExit);
        add(jLabel);
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

    /**
     * initialize and set this.gameParameters to the parameter given for the method.
     *
     * @param gameParameters A GameParameters object that will be setting for this.gameParameters.
     */
    public void injectGameParameters(GameParameters gameParameters) {
        this.gameParameters = gameParameters;
    }

    /**
     * A getter function for this.event.
     *
     * @return the value stored in this.event.
     */
    public String getEvent() {
        return this.event;
    }

    /**
     * A setter function to set this.event.
     *
     * @param s the string representation of an event.
     */
    public void setEvent(String s) {
        this.event = s;
    }

    /**
     * A getter function for this.bContinue.
     *
     * @return a JButton that is the button for continue.
     */
    public JButton getBContinue() {
        return this.bContinue;
    }

    /**
     * A getter function for this.bExit.
     *
     * @return a JButton that is the button for exit.
     */
    public JButton getBExit() {
        return this.bExit;
    }

    /**
     * A getter function for this.jLabel.
     *
     * @return the jLabel object stored in this.jLabel.
     */
    public JLabel getJLabel() {
        return this.jLabel;
    }
}