package main.java.Entities;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * FactoryPilotDark is used to generate JPanel for the pilot, i.e.,
 * the image that the user controls for the Dark theme. The second
 * image simulates a hit and is displayed when a collision between the pilot
 * and a flying object is detected.
 * <p>
 * This is variation of FactoryPilot.
 *
 * @author Yan Nowaczek yan.nowaczek@mail.utoronto.ca
 * @author Edward
 * @version A
 * @since 1.0   December 3, 2021
 */
public class FactoryPilotDark {
    private BufferedImage shapePilot = null; // image for pilot
    private BufferedImage shapeBoom = null; // image for explosion

    /**
     * Downloads images for the pilot and the explosion.
     */
    public FactoryPilotDark() {
        try {
            File pathNamePilot = new File("src/main/resources/pilotDark.png");
            shapePilot = ImageIO.read(pathNamePilot);
        } catch (IOException e) {
            System.out.println("FactoryPilotDark: Image for pilot.png not found");
        }
        try {
            File pathNameBoom = new File("src/main/resources/explosion.png");
            shapeBoom = ImageIO.read(pathNameBoom);
        } catch (IOException e) {
            System.out.println("FactoryPilotDark: Image for explosion.png not found");
        }
    }

    /**
     * This method is what makes this class a factory. It gets coordinates from the
     * caller and returns JPanel Pilot with appropriate images.
     *
     * @return JPanel Pilot, which the user will be able to control
     */
    public Pilot getProduct(int x, int y) {
        return new Pilot(x, y, this.shapePilot, this.shapeBoom);
    }
}