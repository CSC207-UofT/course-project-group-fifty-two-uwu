import main.java.Entities.ProductB;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TestJPanelPaint {

    public static void main(String args[]) {
        JFrame f = new JFrame();
        JPanel p = new JPanel();
        f.setLayout(null);
        f.revalidate();
        f.repaint();
        f.isVisible();
        f.setSize(400, 400);

        BufferedImage shape;
        File pathName = new File("src/main/resources/missileSuper.png");
        try {
            shape = ImageIO.read(pathName);
            JPanel q = new ProductB(100, 100, 0.3, shape, "red");
            q.isVisible();
            f.add(q);
            q.setLayout(null);
            f.getContentPane().add((JPanel) q);
            //p.add(shape);
            f.add(p);
            f.setVisible(true);
            f.repaint();
        }
        catch (IOException e) {
            System.out.println("Image for FactoryB not found");
        }
        System.out.println("Image created in Factory B");}

}
