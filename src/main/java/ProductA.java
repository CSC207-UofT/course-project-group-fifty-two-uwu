package main.java;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ProductA extends JPanel{
    //This class is of type JPanel so that they can be added to JFrame
    //and displayed. This is the JPanel of the crosshair.
    int x;
    int y;
    double vector;
    int width = 20;
    int height = 20;
    BufferedImage shape;
    public ProductA(){
        FactoryA factoryA =  new FactoryA();
        this.x = factoryA.getX_axis();
        this.y = factoryA.getY_axis();
        this.vector = factoryA.getDirection();
        this.shape = factoryA.getShape();
    }
    public void paintComponent(Graphics g) {
        // System.out.println("Product paintComponent");
        Graphics2D g2d = (Graphics2D) g;
        //super.paintComponent(g);
        // g.drawImage(this.shape, this.x, this.y, null);
        g2d.drawImage(this.shape, this.x, this.y, null);
    }
    public void update(){
        // System.out.println("Product update x = " + x);
//        this.x += 1;
//        this.y += 1;
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public double getV(){
        return this.vector;
    }
    public BufferedImage getImage(){
        return this.shape;
    }
}

