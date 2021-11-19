package main.java;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ProductContinueExit extends JPanel{
    File pathName1 = new File("src/main/resources/exit.png");
    File pathName2 = new File("src/main/resources/continue.png");
    BufferedImage shape1;
    BufferedImage shape2;
    boolean found = true;
    int x1 = 100;
    int x2 = 250;
    int y1 = 200;
    int y2 = 200;

    public ProductContinueExit(){
        try {
            shape1 = ImageIO.read(pathName1);
        }
        catch (IOException e) {
            found = false;
            System.out.println("Image for ProductContinueExit not found");
        }
        try {
            shape2 = ImageIO.read(pathName2);
        }
        catch (IOException e) {
            found = false;
            System.out.println("Image for ProductContinueExit not found");
        }
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(this.shape1, this.x1, this.y1, null);
        g2d.drawImage(this.shape2, this.x2, this.y2, null);
    }
}

