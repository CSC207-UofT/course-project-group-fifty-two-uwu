package main.java.Entities;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/*
  Manufactures JPanels of type Sputnik
  @author Terry
 * @author Yan Nowaczek yan.nowaczek@mail.utoronto.ca
 * @version 3 last updated December 4, 2021
 * @since 1.0 November 23, 2021
 */

/**
 * FactorySputnik is the class used to create Sputniks
 */
public class FactorySputnik extends Factory {
    private BufferedImage shape; // image for Sputnik

    /*
     * Main method, checks if the image file can be read. If it cannot be read, it will catch an error and tell
     * the user that the image is not found.
     * Downloads images for the Sputnik
     */
    public FactorySputnik() {
        try {
            File pathName = new File("src/main/resources/missileSputnik.png");
            shape = ImageIO.read(pathName);
        } catch (IOException e) {
            System.out.println("FactorySputnikDark did not find image missileSputnikDark.png");
        }
    }

    /*
     * Creates a Sputnik object
     * @param x     integer for x coordinate
     * @param y     integer for y coordinate
     * @param v     double for direction vector
     * @param route string for the name of specific trajectory for this missile
     * @return      class Sputnik which is a subclass of JPanel for displaying in JFrame
     */
    public Sputnik getProduct(int x, int y, double v, String route) {
        return new Sputnik(x, y, v, shape, route);
    }
}