package main.java.Entities;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author Terry
 * @version 2
 * @since November 23, 2021
 */
public class FactorySputnik extends Factory {
    //The factory that 'produces' ProductSputnic
    private BufferedImage shape;
    private boolean found = true;
    private File pathName = new File("src/main/resources/missileSputnik.png");


    public FactorySputnik(){
        try {
            shape = ImageIO.read(pathName);
        }
        catch (IOException e) {
            found = false;
            System.out.println("Image for missileSputnic not found");
        }
        System.out.println("Image missleSputnic created in FactorySputnic");
    }

    public Sputnik getProduct(int x, int y, double v, String s){
        return new Sputnik(x, y, v, shape, s);
    }
}