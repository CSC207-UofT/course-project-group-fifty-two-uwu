package main.java;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

public class ProductB extends JPanel {
    int x;
    int y;
    double vector;
    int width = 20;
    int height = 20;
    BufferedImage shape;
    public ProductB(int x, int y){
        FactoryB factoryB =  new FactoryB();
//        this.x = factoryB.getX_axis();
//        this.y = factoryB.getY_axis();
        this.x = x;
        this.y = y;
        this.vector = factoryB.getDirection();
        this.shape = factoryB.getShape();
    }
    public void paintComponent(Graphics g) {
        // System.out.println("Product paintComponent");
        // System.out.println("ProductB x = " + x + " y = " + y);
        // super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int midX = this.shape.getWidth() / 2;
        int midY = this.shape.getHeight() / 2;
        AffineTransform tx = AffineTransform.getRotateInstance(this.vector, midX, midY);
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
        // g.drawImage(op.filter(this.shape, null), this.x, this.y,null);
        g2d.drawImage(op.filter(this.shape, null), this.x, this.y,null);
    }
    public void update(int x, int y){
        int delta = 3; // increment
        boolean isLeft = true;
        // is the target on the left side of missile?
        // using doubles for greater precision
        // - use a cross product of the product vector and
        //   the vector pointing to the target.
        // - the cross product is positive if target on left
        // - the tale of the product vector is at ax, ay
        // - the arrow head of the product vector is at bx, by
        // - the target is at cx, cy
        double ax = this.x;
        double ay = this.y;
        double bx = ax + 100 * Math.cos(this.vector); //second point for vector ab
        double by = ay + 100 * Math.sin(this.vector);
        double cx = x;
        double cy = y;
        isLeft = ((bx-ax)*(cy-ay) - (by-ay)*(cx-ax)) < 0;
        // is the missile moving in the direction of the target?
        // is the angle smaller than Math.PI/80 = 2.25 degrees?
        boolean isOnTarget = true;;
        double temp;
        //calculate the angle between ab and ac using the cosine law
        // c^2 = a^2 + b^2 -2ab*cos zeta
        // zeta = cos-1 (a^2 + b^2 - c^2)/(-2ab)
        double ab = Math.sqrt((bx - ax)*(bx - ax) + (by - ay)*(by - ay));
        double ac = Math.sqrt((cx - ax)*(cx - ax) + (cy - ay)*(cy - ay));
        double bc = Math.sqrt((cx - bx)*(cx - bx) + (cy - by)*(cy - by));
        temp = Math.acos((ab*ab + ac*ac - bc*bc)/((1)*(2*ab*ac)));
        isOnTarget = Math.abs(temp) < Math.PI/80;
        // calculate the new value for direction vector
        if(!isOnTarget){
            if(isLeft){
                this.vector -= Math.PI/80;
            }
            else {
                this.vector += Math.PI/80;
            }
        }
        this.x += delta * Math.cos(this.vector);
        this.y += delta * Math.sin(this.vector);
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
