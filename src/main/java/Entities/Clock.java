package main.java.Entities;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
/**
 * @author Yan Nowaczek
 * @version 2
 * @since November 23, 2021
 *
 * This class is of type JPanel so that they can be added to JFrame
 * and displayed. This is the JPanel for the timer. This product class uses JLabel.
 **/

public class Clock extends JPanel{


    private final JLabel jLabel = new JLabel();
//    private final Timer timer;

    public Clock(){
//        timer = new Timer(47, e -> {
//            updateClockDisplay();
//            repaint();
//        });
//        timer.start();
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

//    public void restartTimer(){
//        this.timer.restart();
//    }

//    public void stopTimer() {
//        this.timer.stop();
//    }

    /**
     * Returns the component of the clock
     *
     * @return the jLabel components
     */
    public JLabel getComponent(){
        return this.jLabel;
    }

    /**
     * Updates the clock
     *
     * @param t a long object that represents the time
     */
    public void updateClock(long t){
        // long t = System.currentTimeMillis();
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
     * @param s the string that you want to set the text in this.jLabel to
     */
    public void update(String s){
        this.jLabel.setText(s);
    }

    public void paintComponent(Graphics g) {
    }
}
