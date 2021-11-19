package main.java;

import javax.swing.*;
import java.awt.*;

public class ProductTimer extends JPanel{
    JLabel jLabel = new JLabel();
    public ProductTimer(){
        this.jLabel.setText("clock");
        jLabel.setFont(new Font("Serif", Font.PLAIN, 24));
        jLabel.setForeground(Color.RED);
        // jLabel.setBackground(Color.black);
        // this.jLabel.setBounds(300, 300, 100, 20);

    }
    public void update(String s){
        this.jLabel.setText(s);
    }
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

//       g2d.drawImage(this.bufferedImage, this.x1, this.y1, null);
//        g2d.drawImage(this.shape2, this.x2, this.y2, null);
    }
}
