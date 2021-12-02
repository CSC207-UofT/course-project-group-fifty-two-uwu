package main.java.Entities;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FactoryMissile extends Factory {
    //The factory that 'produces' ProductB
    private BufferedImage shape;
    private boolean found = true;
    private File pathName = new File("src/main/resources/missileSuper.png");

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

    public Missile getProduct(int x, int y, double v, String route){
        return new Missile(x, y, v, shape, route);
    }
}