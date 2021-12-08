package main.java.Entities;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/*
  @author Terry
 * @version 4
 * @since November 10, 2021
 */

/**
 * This class is of type JPanel so that they can be added to JFrame
 * and displayed. This is the JPanel for the timer. This product class uses JLabel.
 */
public class HitCounter extends JPanel {
    private final JLabel jLabel = new JLabel();

    /**
     * The main method of the class,
     */
    public HitCounter() {
        this.jLabel.setText("score");
        this.jLabel.setFont(new Font("SansSerif", Font.PLAIN, 36));
        this.jLabel.setOpaque(false);
        this.jLabel.setBorder(new EmptyBorder(4, 20, 4, 4));
        this.jLabel.setForeground(Color.RED);
        this.jLabel.setLayout(null);
        this.jLabel.setBounds(605, 510, 120, 36);
        setLayout(null);
        add(jLabel);
    }

    /**
     * Update the hit counter to the current number
     *
     * @param hits an integer, the hit counter
     */
    public void update(int hits) {
        this.jLabel.setText(Integer.toString(hits));
    }

    public void paintComponent(Graphics g) {
    }
}
