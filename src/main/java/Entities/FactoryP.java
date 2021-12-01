package main.java.Entities;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FactoryP {
    //The factory that 'produces' ProductP
    private BufferedImage shapePilot = null;
    private BufferedImage shapeBoom = null;
    private int x_axis = 200;
    private int y_axis = 200;
    private File pathNamePilot = new File("src/main/resources/pilot.png");
    private File pathNameBoom = new File("src/main/resources/explosion.png");

    public FactoryP(){
        try {
            shapePilot = ImageIO.read(pathNamePilot);
        }
        catch (IOException e) {
            System.out.println("Image for pilot.png not found");
        }
        System.out.println("Image pilot.png created in Factory P");
        try {
            shapeBoom = ImageIO.read(pathNameBoom);
        }
        catch (IOException e) {
            System.out.println("Image for explosion.png not found");
        }
        System.out.println("Image explosion.png created in Factory P");
    }

    public int getX_axis(){
        return this.x_axis;
    }
    public int getY_axis(){
        return this.y_axis;
    }
    public BufferedImage getShapePilot(){
        return this.shapePilot;
    }
    public BufferedImage getShapeBoom(){
        return this.shapeBoom;
    }
}

