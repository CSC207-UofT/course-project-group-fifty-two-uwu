package main.java.Entities;

import main.java.Controller.GameParameters;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author Edward
 * @version 2
 * @since Dec 2, 2021
 * This class is used to load and display the background of the game
 */
public class Background extends JPanel{
    private File pathNameBackground = new File("src/main/resources/backgroundInGame.png");
    private BufferedImage bufferedImage;

    public Background(){
        try {
            bufferedImage = ImageIO.read(pathNameBackground);
        }
        catch (IOException e) {
            System.out.println("Background >>> image backgroundInGame.png not found");
        }
        setLayout(null);
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bufferedImage, 0, 0, null);
    }
}