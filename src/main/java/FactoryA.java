package main.java;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FactoryA {
    BufferedImage shape = null;
    private int x_axis = 10;
    private int y_axis = 10;
    private double direction = Math.PI/5;
    boolean found = true;

    File pathName = new File("src/main/resources/target.png");

    public FactoryA(){

        try {
            shape = ImageIO.read(pathName);
        }
        catch (IOException e) {
            found = false;
            System.out.println("Image for FactoryA not found");
        }

        System.out.println("Image created in Factory A");
    }

    public void setX_axis(int x_axis){
        this.x_axis = x_axis;
    }

    public void setY_axis(int y_axis){
        this.y_axis = y_axis;
    }

    public void setDirection(double direction){
        this.direction = direction;
    }

    public int getX_axis(){
        return this.x_axis;
    }

    public int getY_axis(){
        return this.y_axis;
    }

    public double getDirection(){
        return this.direction;
    }

    public BufferedImage getShape(){
        return this.shape;
    }
}
