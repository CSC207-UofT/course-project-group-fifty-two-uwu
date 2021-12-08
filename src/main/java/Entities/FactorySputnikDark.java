package main.java.Entities;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Manufactures JPanels of type Sputnik for the dark theme
 *
 * @author Yan Nowaczek yan.nowaczek@mail.utoronto.ca
 * @author Edward
 * @version A never updated
 * @since 1.0 December 4, 2021
 */
public class FactorySputnikDark extends Factory {
    private BufferedImage shape; // image for Sputnik

    /**
     * Downloads image for Sputnik
     */
    public FactorySputnikDark() {
        try {
            File pathName = new File("src/main/resources/missileSputnikDark.png");
            shape = ImageIO.read(pathName);
        } catch (IOException e) {
            System.out.println("FactorySputnik did not find image missileSputnik");
        }
    }

    /**
     * Returns JPanel subclass Sputnik with given coordinates and direction vector.
     * The trajectory that the missile will follow is not known to this class.
     *
     * @param x     integer for x coordinate
     * @param y     integer for y coordinate
     * @param v     double for direction vector
     * @param route string for the name of specific trajectory for this missile
     * @return class Sputnik which is a subclass of JPanel for displaying in JFrame
     */
    public Sputnik getProduct(int x, int y, double v, String route) {
        return new Sputnik(x, y, v, shape, route);
    }
}