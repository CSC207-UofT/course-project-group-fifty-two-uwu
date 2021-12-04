package main.java.Entities;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * FactoryPilot is used to generate JPanel for the pilot, i.e.,
 * the image that the user controls. The second image simulates
 * a hit and is displayed when a collision between the pilot
 * and a flying object is detected.
 *
 * @author Yan Nowaczek
 * @author Edward
 * @version 2.0
 * @since 1.0
 *
 */
public class FactoryPilot {
    private BufferedImage shapePilot = null; // image for pilot
    private BufferedImage shapeBoom = null; // image for explosion
    private int x_axis = 200; // default or starting x position
    private int y_axis = 200; // default y position
    private File pathNamePilot = new File("src/main/resources/pilot.png");
    private File pathNameBoom = new File("src/main/resources/explosion.png");

    /**
     * Downloads images for the pilot and the explosion.
     */
    public FactoryPilot(){
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

    /**
     * These four methods allow other parts of the program to access
     * coordinates and the images.
     *
     * @return  coordinates and buffered images
     */
    public int getX_axis(){return this.x_axis;}
    public int getY_axis(){return this.y_axis;}
    public BufferedImage getShapePilot(){return this.shapePilot;}
    public BufferedImage getShapeBoom(){return this.shapeBoom;}
}