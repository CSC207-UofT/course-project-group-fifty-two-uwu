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
 * <p>
 * A similar FactoryPilotDark has been created on December 3, 2021
 *
 * @author Yan Nowaczek yan.nowaczek@mail.utoronto.ca
 * @author Edward
 * @version 2.2     December 3, 2021
 * @since 1.0
 */
public class FactoryPilot {
    private BufferedImage shapePilot = null; // image for pilot
    private BufferedImage shapeBoom = null; // image for explosion

    /**
     * Downloads images for the pilot and the explosion.
     */
    public FactoryPilot() {
        try {
            File pathNamePilot = new File("src/main/resources/pilot.png");
            shapePilot = ImageIO.read(pathNamePilot);
        } catch (IOException e) {
            System.out.println("FactoryPilot: Image for pilot.png not found");
        }
        try {
            File pathNameBoom = new File("src/main/resources/explosion.png");
            shapeBoom = ImageIO.read(pathNameBoom);
        } catch (IOException e) {
            System.out.println("FactoryPilot: Image for explosion.png not found");
        }
    }

    /**
     * These four methods allow other parts of the program to access
     * coordinates and the images.
     *
     * @return coordinates and buffered images
     */
    public BufferedImage getShapePilot() {
        return this.shapePilot;
    }

    public BufferedImage getShapeBoom() {
        return this.shapeBoom;
    }

    public Pilot getProduct(int x, int y) {
        return new Pilot(x, y, this.shapePilot, this.shapeBoom);
    }
}