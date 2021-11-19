package main.java;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ProductP extends JPanel {
    int x;
    int y;
    BufferedImage shape;
    int speed;

    public ProductP(){
        FactoryP factoryP =  new FactoryP();
        this.x = factoryP.getX_axis();
        this.y = factoryP.getY_axis();
        this.shape = factoryP.getShape();
        this.speed = 10;
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(this.shape, this.x, this.y, null);
    }

    public void update(int key){
        if (key == 37){this.x = this.x - this.speed;} // Left Key

        if (key == 38){this.y = this.y - this.speed;} // Down Key

        if (key == 39){this.x = this.x + this.speed;} // Right Key

        if (key == 40){this.y = this.y + this.speed;} // Up Key
    }

    public int getX(){return this.x;}

    public int getY(){return this.y;}
}
