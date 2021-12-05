package main.java.Entities;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * @author Terry
 * @version 4
 * @since November 10, 2021
 */

public class HitCounter extends JPanel{
    /**
     * This class is of type JPanel so that they can be added to JFrame
     * and displayed. This is the JPanel for the timer. This product class uses JLabel.
     */
    private final JLabel jLabel = new JLabel();

    /**
     * The main method of the class,
     */
    public HitCounter(){
        this.jLabel.setText("score");
        this.jLabel.setFont(new Font("SansSerif", Font.PLAIN, 36));
        this.jLabel.setOpaque(false);
        this.jLabel.setBorder(new EmptyBorder(4, 20, 4, 4));
        this.jLabel.setForeground(Color.CYAN);
        this.jLabel.setLayout(null);
        this.jLabel.setBounds(605, 510, 120, 36);
        setLayout(null);
        add(jLabel);
    }

    /**
     * The getter function for4 this.jLabel.
     *
     * @return a JLabel object
     */
    public JLabel getComponent(){
        return this.jLabel;
    }

    public void update(int hits){
        this.jLabel.setText(Integer.toString(hits));
    }

    public void paintComponent(Graphics g) {
    }
}
