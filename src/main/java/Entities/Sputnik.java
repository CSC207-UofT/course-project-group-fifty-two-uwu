package main.java.Entities;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

/**
 * This class is of type JPanel so that they can be added to JFrame
 * and displayed. This is the JPanel of the missile.
 */
public class Sputnik extends JPanel {

    private final BufferedImage shape;
    private final Steerable flightPath;
    private final String PATH_FAULTY = "faulty";
    private int x;
    private int y;
    private double vector;
    private double distance;

    public Sputnik(int x, int y, double v, BufferedImage img, String route) {
        this.x = x;
        this.y = y;
        this.vector = v;
        this.shape = img;
        String PATH_REGULAR = "regular";
        if (route.equals(PATH_REGULAR)) {
            flightPath = new PathFall();
        } else {
            flightPath = new PathOrbitFaulty();
        }
    }

    /**
     * Paints a certain Graphics class object, g (in this case it paints a missile)
     *
     * @param g a graphics class object that is a missile
     */
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        int midX = this.shape.getWidth() / 2;
        int midY = this.shape.getHeight() / 2;
        AffineTransform tx = AffineTransform.getRotateInstance(this.vector, midX, midY);
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
        g2d.drawImage(op.filter(this.shape, null), this.x, this.y, null);
    }

    /**
     * This method updates the placement of the missile accordingly to the target location (which would be the pilot
     * for this game), targetX and targetY.
     *
     * @param targetX the x-coordinarte of the target
     * @param targetY the y-coordinate of the target
     */
    public void update(int targetX, int targetY) {
        flightPath.update(this.x, this.y, this.vector, targetX, targetY);
        this.x = flightPath.getX();
        this.y = flightPath.getY();
        this.vector = flightPath.getV();
        this.distance = Math.sqrt(((this.x - targetX) * (this.x - targetX)) +
                ((this.y - targetY) * (this.y - targetY)));
    }

    /**
     * Getter function for the x-coordinate of the missile
     *
     * @return the x-coordinate of the missile
     */
    public int getX() {
        return this.x;
    }

    /**
     * Getter function for the y-coordinate of the missile
     *
     * @return the y-coordinate of the missile
     */
    public int getY() {
        return this.y;
    }

    /**
     * Returns true if the distance is less than 10
     *
     * @return a boolean
     */
    public boolean isCollisionDetected() {
        return distance < 10;
    }
}