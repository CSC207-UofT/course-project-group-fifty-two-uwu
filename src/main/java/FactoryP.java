package main.java;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FactoryP {
    BufferedImage shape = null;
    private int x_axis = 100;
    private int y_axis = 100;

    File pathName = new File("src/main/resources/pilot.png");

    public FactoryP(){
        try {
            shape = ImageIO.read(pathName);
        }
        catch (IOException e) {
            System.out.println("Image for FactoryA not found");
        }
        System.out.println("Created by FactoryP");
    }

    public void setX_axis(int x_axis){
        this.x_axis = x_axis;
    }

    public void setY_axis(int y_axis){
        this.y_axis = y_axis;
    }

    public int getX_axis(){
        return this.x_axis;
    }

    public int getY_axis(){
        return this.y_axis;
    }

    public BufferedImage getShape(){
        return this.shape;
    }
}

