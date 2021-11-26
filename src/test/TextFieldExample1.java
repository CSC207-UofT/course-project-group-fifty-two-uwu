import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TextFieldExample1 {
    // main method
    public static void main(String args[]) {
        // creating a frame
        Frame jFrame = new Frame("TextField Example");
        final String START = "start";
        final String INFO = "info";
        final String EXIT = "exit";
        String event = "";

        BufferedImage bufferedImage;
        JButton bStart =new JButton("Start");
        JButton bInfo =new JButton("Info");
        JButton bExit =new JButton("Exit");
        File pathNameStart = new File("src/main/resources/iconStart.png");
        File pathNameInfo = new File("src/main/resources/iconInfo.png");
        File pathNameExit = new File("src/main/resources/iconExit.png");
        try {
            bufferedImage = ImageIO.read(pathNameStart);
            bStart.setIcon(new ImageIcon(bufferedImage));
        }
        catch (IOException e) {
            System.out.println("Image for ProductContinueExit Start not found");
        }
        try {
            bufferedImage = ImageIO.read(pathNameInfo);
            bInfo.setIcon(new ImageIcon(bufferedImage));
        }
        catch (IOException e) {
            System.out.println("Image for ProductContinueExit Info not found");
        }
        try {
            bufferedImage = ImageIO.read(pathNameExit);
            bExit.setIcon(new ImageIcon(bufferedImage));
        }
        catch (IOException e) {
            System.out.println("Image for ProductContinueExit Exit not found");
        }
        bStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("bStart e = " + e.toString());
                //
            }
        });
        bInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("bStart e = " + e.toString());
                // setEvent(INFO);
            }
        });
        bExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("bStart e = " + e.toString());
                // setEvent(EXIT);
            }
        });
        bStart.setVisible(true);
        jFrame.add(bStart);
        jFrame.setLayout(null);
        jFrame.add(bInfo);
        jFrame.setLayout(null);
        jFrame.add(bExit);
        jFrame.setLayout(null);
        jFrame.revalidate();
        jFrame.repaint();
        jFrame.isVisible();
        jFrame.setSize(400, 400);
        JPanel p = new JPanel();
        jFrame.add(p);
        p.add(bStart);
        jFrame.setLayout(null);
        jFrame.setVisible(true);




//        // creating objects of textfield
//        TextField t1, t2;
//        // instantiating the textfield objects
//        // setting the location of those objects in the frame
//        t1 = new TextField("Welcome to Javatpoint.");
//        t1.setBounds(50, 100, 200, 30);
//        t2 = new TextField("AWT Tutorial");
//        t2.setBounds(50, 150, 200, 30);
//        // adding the components to frame
//        f.add(t1);
//        f.add(t2);
//        // setting size, layout and visibility of frame
//        f.setSize(400, 400);
//        f.setLayout(null);
//        f.setVisible(true);
    }
}