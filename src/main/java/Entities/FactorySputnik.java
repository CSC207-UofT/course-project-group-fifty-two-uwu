package main.java.Entities;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Manufactures JPanels of type Sputnik
 * @author Terry
 * @author Yan Nowaczek yan.nowaczek@mail.utoronto.ca
 * @version 3 last updated December 4, 2021
 * @since 1.0 November 23, 2021
 */
public class FactorySputnik extends Factory {
    private BufferedImage shape; // image for Sputnik

    /**
     * Downloads images for the Sputnik
     */
    public FactorySputnik(){
        try {
            File pathName = new File("src/main/resources/missileSputnik.png");
            shape = ImageIO.read(pathName);
        }
        catch (IOException e) {
            System.out.println("FactorySputnikDark did not find image missileSputnikDark.png");
        }
    }
    /**
     * Returns JPanel subclass Sputnik with given coordinates and a direction vector.
     * The trajectory that the missile will follow is not known to this class. It is
     * specified by the caller
     *
     * @param x     integer for x coordinate
     * @param y     integer for y coordinate
     * @param v     double for direction vector
     * @param route string for the name of specific trajectory for this missile
     * @return      class Sputnik which is a subclass of JPanel for displaying in JFrame
     */
    public Sputnik getProduct(int x, int y, double v, String route){
        return new Sputnik(x, y, v, shape, route);
    }
}