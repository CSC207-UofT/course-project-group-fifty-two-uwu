package main.java.Entities;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ProductHitCounter extends JPanel{
    //This class is of type JPanel so that they can be added to JFrame
    //and displayed. This is the JPanel for the timer. This product class uses JLabel.
    private final JLabel jLabel = new JLabel();

    public ProductHitCounter(){
        this.jLabel.setText("score");
        this.jLabel.setFont(new Font("SansSerif", Font.PLAIN, 36));
        this.jLabel.setOpaque(true);
        this.jLabel.setBorder(new EmptyBorder(4, 20, 4, 4));
        // this.jLabel.setBackground(Color.BLACK);
        this.jLabel.setForeground(Color.BLACK);
        this.jLabel.setLayout(null);
        this.jLabel.setBounds(605, 510, 120, 36);
        setLayout(null);
        add(jLabel);
    }

    public JLabel getComponent(){
        return this.jLabel;
    }

    public void update(int hits){
        this.jLabel.setText(Integer.toString(hits));
    }

    public void paintComponent(Graphics g) {
    }
}