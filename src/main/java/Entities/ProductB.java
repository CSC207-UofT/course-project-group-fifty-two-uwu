package main.java.Entities;

import main.java.Entities.TrajectoryB;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

public class ProductB extends JPanel {
    //This class is of type JPanel so that they can be added to JFrame
    //and displayed. This is the JPanel of the missile.
    private int x;
    private int y;
    private double vector;
    private final BufferedImage shape;
    private final TrajectoryB trajectoryB = new TrajectoryB();

    public ProductB(int x, int y, double v, BufferedImage img){
        this.x = x;
        this.y = y;
        this.vector = v;
        this.shape = img;
    }
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        int midX = this.shape.getWidth() / 2;
        int midY = this.shape.getHeight() / 2;
        AffineTransform tx = AffineTransform.getRotateInstance(this.vector, midX, midY);
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
        g2d.drawImage(op.filter(this.shape, null), this.x, this.y,null);
    }

    public void update(int targetX, int targetY){
        trajectoryB.update(this.x, this.y, this.vector, targetX, targetY);
        this.x = trajectoryB.getX();
        this.y = trajectoryB.getY();
        this.vector = trajectoryB.getV();
        // repaint(); // not necessary if repaint is done somewhere else
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }
}