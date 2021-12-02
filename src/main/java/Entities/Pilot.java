package main.java.Entities;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Pilot extends JPanel {
    //This class is of type JPanel so that they can be added to JFrame
    //and displayed. This is the JPanel for the character/person that the user will be controlling.
    private int x;
    private int y;
    private BufferedImage shapePilot;
    private BufferedImage shapeBoom;
    private int speed;
    private boolean boomOn = false;

    public Pilot(){
        FactoryPilot factoryPilot =  new FactoryPilot();
        this.x = factoryPilot.getX_axis();
        this.y = factoryPilot.getY_axis();
        this.shapePilot = factoryPilot.getShapePilot();
        this.shapeBoom = factoryPilot.getShapeBoom();
        this.speed = 10;
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(this.shapePilot, this.x, this.y, null);
        if (boomOn) {
            g2d.drawImage(this.shapeBoom, this.x - 5, this.y - 5, null);
        }
    }

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
    public void setBoomOn(boolean boonOn){this.boomOn = boonOn;}
    public boolean isBoomOn(){return boomOn;}
    public int getX(){return this.x;}
    public int getY(){return this.y;}
}
