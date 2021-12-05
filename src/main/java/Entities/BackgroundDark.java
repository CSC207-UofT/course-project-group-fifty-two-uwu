package main.java.Entities;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Creates a background for the dark theme.
 * It is important that this JPanel be added as the last
 * component to the JFrame because JFrame.repaint() paints
 * the last added component first, and the background should
 * be painted first.
 *
 * @author Yan Nowaczek yan.nowaczek@mail.utoronto.ca
 * @author Edward
 * @version A
 * @since 1.0   December 3, 2021
 */
public class BackgroundDark extends JPanel{
    private BufferedImage bufferedImage;

    /**
     * Imports the image for the dark background
     */
    public BackgroundDark(){
        try {
            File pathNameBackground = new File("src/main/resources/backgroundInGameDark.png");
            bufferedImage = ImageIO.read(pathNameBackground);
        }
        catch (IOException e) {
            System.out.println("Background >>> image backgroundInGameDark.png not found");
        }
        setLayout(null);
        setOpaque(false);
    }

    /**
     * Draws this image at the time when JFrame.repaint() is
     * executed provided it is one of the components.
     *
     * @param g  abstract base class for all graphics contexts
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bufferedImage, 0, 0, null);
    }
}