package main.java.Entities;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

/**
 * This class is of type JPanel so that it can be added and displayed on JFrame.
 * It represents the character/person that the user will be controlling.
 * It is used by both FactoryPilot and FactoryPilotDark
 *
 * @author Yan Nowaczek yan.nowaczek@mail.utoronto.ca
 * @author Edward
 * @version C   last updated December 4, 2021
 * @since 1.0   created on November 10, 2021
 */

/**
 * This class is of type JPanel so that they can be added to JFrame and displayed on the user screen.
 * This is the JPanel for the character/person that the user will be controlling.
 **/
public class Pilot extends JPanel {
    private int x; // x coordinate
    private int y; // y coordinate
    private double v = 0.0; // direction vector
    private final BufferedImage shapePilot; // image for the pilot
    private final BufferedImage shapeBoom; // image for explosion
    private boolean boomOn = false; // when true the explosion is displayed

    /**
     * This JPanel gets coordinates from a calling class but
     * BufferedImages are created at the factory
     *
     * @param x integer for x coordinate
     * @param y integer for y coordinate
     * @param shapePilot BufferedImage for the pilot
     * @param shapeBoom BufferedImage for the explosion
     */
    public Pilot(int x, int y, BufferedImage shapePilot, BufferedImage shapeBoom){
        this.x = x;
        this.y = y;
        this.shapePilot = shapePilot;
        this.shapeBoom = shapeBoom;
    }

    /**
     *
     * @param g
     */
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        int midX = this.shapePilot.getWidth() / 2;
        int midY = this.shapePilot.getHeight() / 2;
        AffineTransform tx = AffineTransform.getRotateInstance(this.v, midX, midY);
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
        g2d.drawImage(op.filter(this.shapePilot, null), this.x, this.y,null);
        if (boomOn) {
            g2d.drawImage(this.shapeBoom, this.x - 5, this.y - 5, null);
        }
    }

    /**
     * Changes the coordinates in response to key pressed.
     * Calculates the direction of the movement.
     * Makes sure the pilot stays within the JFrame.
     *
     * @param key   integer value of the key pressed
     */
    public void update(int key){
        int speed = 10;
        double previousX = this.x;
        double previousY = this.x;
        // calculate the new position and direction
        if (key == 37){ // Left Key
            this.x = this.x - speed;
            this.v = - Math.PI/2;
        }
        if (key == 38){ // Down Key
            this.y = this.y - speed;
            this.v = 0;
        }
        if (key == 39){ // Right Key
            this.x = this.x + speed;
            this.v = Math.PI/2;
        }
        if (key == 40){ // Up Key
            this.y = this.y + speed;
            this.v = - Math.PI;
        }
        // make sure the pilot does not get outside the JFrame
        if (this.x < 2){ this.x = 2;}
        if (this.x > 330){ this.x = 330;}
        if (this.y < 2){ this.y = 2;}
        if (this.y > 270){ this.y = 270;}
    }

    /**
     * Informs the class when to display the explosion
     * @param boonOn    boolean indicating that the explosion image should be displayed
     */
    public void setBoomOn(boolean boonOn){this.boomOn = boonOn;}

    /**
     * Returns the x coordinate
     * @return  integer value of the x coordinate
     */
    public int getX(){return this.x;}

    /**
     * Returns the y coordinate
     * @return  integer value of the y coordinate
     */
    public int getY(){return this.y;}
}
