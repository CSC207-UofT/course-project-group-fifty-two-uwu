package main.java.Entities;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * @author Yan Nowaczek
 * @author Yan Nowaczek yan.nowaczek@mail.utoronto.ca
 * @author Edward
 * @version B   December 3, 2021
 * @since November 23, 2021
 * <p>
 * This class is of type JPanel so that they can be added to JFrame
 * and displayed. This is the JPanel for the timer. This product class uses JLabel.
 * <p>
 * Displays the seconds and 1/10 of the second of the game duration
 * The seconds a user survives represents the score.
 * <p>
 * This class is of type JPanel. It can be added to JFrame and displayed.
 * @since 1.0   November 10, 2021
 */
public class Clock extends JPanel {
    private final JLabel jLabel = new JLabel(); // the clock is displayed as JLabel

    /**
     * Sets attributes to the clock and places it at the right bottom corner
     */
    public Clock() {
        this.jLabel.setText("clock");
        this.jLabel.setFont(new Font("SansSerif", Font.PLAIN, 20));
        this.jLabel.setOpaque(true);
        this.jLabel.setBorder(new EmptyBorder(4, 20, 4, 4));
        this.jLabel.setBackground(Color.BLACK);
        this.jLabel.setForeground(Color.CYAN);
        this.jLabel.setLayout(null);
        this.jLabel.setBounds(25, 525, 120, 26);
        setLayout(null);
        add(jLabel);
    }

    /**
     * Converts milliseconds to a string format
     *
     * @param t long for milliseconds
     */
    public void updateClock(long t) {
        t = t / 100;
        String milliseconds = String.valueOf(t % 10);
        t = t / 10;
        String seconds = String.valueOf(t % 60);
        t = t / 60;
        String minutes = String.valueOf(t % 60);
        if (seconds.length() < 2) {
            seconds = "0" + seconds;
        }
        if (minutes.length() < 2) {
            minutes = "0" + minutes;
        }
        update(minutes + ":" + seconds + "." + milliseconds);
    }

    /**
     * a setter function to set the text in this.jLabel
     *
     * @param gameTime string representation of the clock's milliseconds
     */
    public void update(String gameTime) {
        this.jLabel.setText(gameTime);
    }

    /**
     * A necessary method. Without it only the clock will be displayed.
     * The reason is unknown.
     *
     * @param g abstract class for all graphics contexts to enable a program to draw
     */
    public void paintComponent(Graphics g) {
    }
}
