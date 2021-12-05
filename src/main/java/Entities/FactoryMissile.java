package main.java.Entities;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author Yan Nowaczek
 * @version 2
 * @since November 23, 2021
 *
 * FactoryMissile is the class used to create missile objects.
 */
public class FactoryMissile extends Factory {
    private BufferedImage shape;
    private boolean found = true;
    private File pathName = new File("src/main/resources/missileSuper.png");

    /**
     * Main method, checks if the image file can be read. If it cannot be read, it will catch an error and tell
     * the user that the image is not found.
     */
    public FactoryMissile(){
        try {
            shape = ImageIO.read(pathName);
        }
        catch (IOException e) {
            found = false;
            System.out.println("Image for FactoryB not found");
        }
        System.out.println("Image created in Factory B");
    }

    /**
     * Creates a missile object and returns it.
     *
     * @param x the x-coordinate of the missile
     * @param y the y-coordinate of the missile
     * @param v the vector of the misile
     * @param route the string representation of the route of the missile
     * @return the newly created missile object created using the parameters
     */
    public Missile getProduct(int x, int y, double v, String route){
        return new Missile(x, y, v, shape, route);
    }
}