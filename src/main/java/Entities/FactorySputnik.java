package main.java.Entities;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author Terry
 * @version 2
 * @since November 23, 2021
 */

/**
 * FactorySputnik is the class used to create Sputniks
 */
public class FactorySputnik extends Factory {


    private BufferedImage shape;
    private boolean found = true;
    private File pathName = new File("src/main/resources/missileSputnik.png");

    /**
     * Main method, checks if the image file can be read. If it cannot be read, it will catch an error and tell
     * the user that the image is not found.
     */
    public FactorySputnik(){
        try {
            shape = ImageIO.read(pathName);
        }
        catch (IOException e) {
            found = false;
            System.out.println("Image for missileSputnic not found");
        }
        System.out.println("Image missleSputnic created in FactorySputnic");
    }

    /**
     * Creates a Sputnik object
     *
     * @param x the x-coordinate of the sputnik
     * @param y the y-coordinate of the sputnik
     * @param v the vector of the Sputnik object
     * @param s spring representation of the route of the sputnik
     * @return A new sputnik object
     */
    public Sputnik getProduct(int x, int y, double v, String s){
        return new Sputnik(x, y, v, shape, s);
    }
}