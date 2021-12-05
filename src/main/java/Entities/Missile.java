package main.java.Entities;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

public class Missile extends JPanel {
    //This class is of type JPanel so that they can be added to JFrame
    //and displayed. This is the JPanel of the missile.
    private int x;
    private int y;
    private double vector;
    private final BufferedImage shape;
    private final Steerable flightPath;
    private double distance;
    private final String PATH_REGULAR = "regular";
    private final String PATH_FAULTY = "faulty";

    public Missile(int x, int y, double v, BufferedImage img, String route){
        this.x = x;
        this.y = y;
        this.vector = v;
        this.shape = img;
        if (route.equals(PATH_FAULTY)){
            flightPath = new PathOrbitFaulty();
        }
        else {
            flightPath = new PathOrbit();
        }
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
        flightPath.update(this.x, this.y, this.vector, targetX, targetY);
        this.x = flightPath.getX();
        this.y = flightPath.getY();
        this.vector = flightPath.getV();
        this.distance = Math.sqrt( ((this.x - targetX)*(this.x - targetX)) +
                ((this.y - targetY)*(this.y - targetY)));
    }

    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public boolean isCollisionDetected(){
        return distance < 4;
    }
}