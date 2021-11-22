package main.java;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FactoryB extends Factory{
    //The factory that 'produces' ProductB
    BufferedImage shape;
    boolean found = true;
    File pathName = new File("src/main/resources/missileSuper.png");

    public FactoryB(){
        try {
            shape = ImageIO.read(pathName);
        }
        catch (IOException e) {
            found = false;
            System.out.println("Image for FactoryB not found");
        }
        System.out.println("Image created in Factory B");
    }

    @Override
    public ProductB getProduct(int x, int y, double v){
        return new ProductB(x, y, v, shape);
    }
}