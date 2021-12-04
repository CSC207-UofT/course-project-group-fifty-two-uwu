package main.java.Entities;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
/**
 * @author Edward
 * @version 1
 * @since December 2, 2021
 */
public class Pilot extends JPanel {
    /**
     * This class is of type JPanel so that they can be added to JFrame and displayed on the user screen.
     * This is the JPanel for the character/person that the user will be controlling.
     * */
    //
    private int x;
    private int y;
    private BufferedImage shapePilot;
    private BufferedImage shapeBoom;
    private int speed;
    private boolean boomOn = false;

    /**
     *The main method, creates a FactoryPilot class and take the data from there to assign values to the class
     * objects
     */
    public Pilot(){
        FactoryPilot factoryPilot =  new FactoryPilot();
        this.x = factoryPilot.getX_axis();
        this.y = factoryPilot.getY_axis();
        this.shapePilot = factoryPilot.getShapePilot();
        this.shapeBoom = factoryPilot.getShapeBoom();
        this.speed = 10;
    }

    /**
     * This method draws a Graphics class object, g, and put it at a certain coordinate
     *
     * @param g the graphics that will be drawn as the pilot
     */
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(this.shapePilot, this.x, this.y, null);
        if (boomOn) {
            g2d.drawImage(this.shapeBoom, this.x - 5, this.y - 5, null);
        }
    }

    /**
     * This method updates the placement of the pilot according to the key pressed in int by its speed.
     * It also checks if the pilot is going out of the boundary of the game for its next placement.
     * If so, the placement will be set to the limit instead of going beyond the limit.
     *
     * @param key the key pressed in int
     */
    public void update(int key){
        if (key == 37){this.x = this.x - this.speed;} // Left Key
        if (key == 38){this.y = this.y - this.speed;} // Down Key
        if (key == 39){this.x = this.x + this.speed;} // Right Key
        if (key == 40){this.y = this.y + this.speed;} // Up Key
        if (this.x < 2){ this.x = 2;}
        if (this.x > 330){ this.x = 330;}
        if (this.y < 2){ this.y = 2;}
        if (this.y > 270){ this.y = 270;}
        System.out.println(this.x + " " + this.y);
    }

    /** Set this.boomOn to True or False according to the parameter boomOn
     *
     * @param boomOn a boolean, either True or False
     */
    public void setBoomOn(boolean boomOn){this.boomOn = boomOn;}

    /** check if boomOn is true
     *
     * @return boolean from boomOn
     */
    public boolean isBoomOn(){return boomOn;}

    /** getter functions for this.x
     *
     * @return value for this.x
     */
    public int getX(){return this.x;}

    /** getter functions for this.x
     *
     * @return value for this.y
     */
    public int getY(){return this.y;}
}
