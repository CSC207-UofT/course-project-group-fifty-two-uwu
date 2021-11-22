package main.java;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ProductContinueExit extends JPanel{
    //This class is of type JPanel so that they can be added to JFrame
    //and displayed. This is the JPanel for the pause menu. This product class uses JButton and JLabel.
    final private String START = "start";
    final private String INFO = "info";
    final private String EXIT = "exit";
    String event = "";
    JButton bStart =new JButton("Start");
    JButton bInfo =new JButton("Info");
    JButton bExit =new JButton("Exit");
    private JLabel welcome = new JLabel("");
    JLabel welcome2 = new JLabel("");
    File pathNameStart = new File("src/main/resources/iconStart.png");
    File pathNameInfo = new File("src/main/resources/iconInfo.png");
    ImageIcon imageIconStart;
    ImageIcon imageIconInfo;
    ImageIcon imageIconExit;
    BufferedImage bufferedImage;
    boolean found = true;
    int x1 = 100;
    int x2 = 250;
    int y1 = 200;
    int y2 = 200;

    public ProductContinueExit(){
        imageIconStart = new ImageIcon();
        try {
            bufferedImage = ImageIO.read(pathNameStart);
            bStart.setIcon(new ImageIcon(bufferedImage));
        }
        catch (IOException e) {
            found = false;
            System.out.println("Image for ProductContinueExit Start not found");
        }
        imageIconInfo = new ImageIcon();
        try {
            bufferedImage = ImageIO.read(pathNameInfo);
            bInfo.setIcon(new ImageIcon(bufferedImage));
        }
        catch (IOException e) {
            found = false;
            System.out.println("Image for ProductContinueExit Info not found");
        }
        bStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // System.out.println("bStart e = " + e.toString());
                event = START;
            }
        });
        bInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // System.out.println("bStart e = " + e.toString());
                event = INFO;
            }
        });
        bExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // System.out.println("bStart e = " + e.toString());
                event = EXIT;
            }
        });
        this.add(bStart);
        this.add(bInfo);
        this.add(bExit);
        this.add(welcome);
    }

    public String getEvent(){
        String temp = event;
        event = "";
        return temp;
    }

    public void setWelcome(String welcome){
        this.welcome.setText("Hello " + welcome + "!");
    }

    public JLabel getWelcome(){
        return welcome;
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
//       g2d.drawImage(this.bufferedImage, this.x1, this.y1, null);
//        g2d.drawImage(this.shape2, this.x2, this.y2, null);
    }
}

