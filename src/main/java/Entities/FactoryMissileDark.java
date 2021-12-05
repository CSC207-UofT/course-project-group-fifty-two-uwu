package main.java.Entities;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Manufactures products of type missileSupper Dark - suitable for the Dark theme
 *
 * @author Yan Nowaczek yan.nowaczek@mail.utoronto.ca
 * @author Edward
 * @version A
 * @since 1.0 December 3, 2021
 */
public class FactoryMissileDark extends Factory {
    private BufferedImage shape; // the image of the missile
    private File pathName = new File("src/main/resources/missileSuperDark.png");

    public FactoryMissileDark(){
        try {
            shape = ImageIO.read(pathName);
        }
        catch (IOException e) {
            System.out.println("Image missileSupper.png for FactoryMissile not found");
        }
    }

    /**
     * Returns JPanel subclass Missile with given coordinates and direction vector.
     * The trajectory that the missile will follow is not known to this class.
     *
     * @param x     integer for x coordinate
     * @param y     integer for y coordinate
     * @param v     double for direction vector
     * @param route string for the name of specific trajectory for this missile
     * @return      class Missile which is a subclass of JPanel for displaying in JFrame
     */
    public Missile getProduct(int x, int y, double v, String route){
        return new Missile(x, y, v, shape, route);
    }
}