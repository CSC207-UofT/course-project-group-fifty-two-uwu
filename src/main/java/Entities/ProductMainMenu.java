package main.java.Entities;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ProductMainMenu extends JPanel{
    final private String START = "start";
    final private String INFO = "info";
    final private String EXIT = "exit";
    private BufferedImage bufferedImage;
    private JButton bStart =new JButton("Start");
    private JButton bInfo =new JButton("Info");
    private JButton bExit =new JButton("Exit");
    private File pathNameStart = new File("src/main/resources/iconStart.png");
    private File pathNameInfo = new File("src/main/resources/iconInfo.png");
    private File pathNameExit = new File("src/main/resources/iconExit.png");
    private JLabel jLabel = new JLabel();
    private String username = "";
    private String event = "";

    public ProductMainMenu() {
        jLabel.setFont(new Font("MS Song", Font.BOLD, 24));
        jLabel.setText("Welcome \u4f60\u597d" + this.username);
        jLabel.setBounds(210, 150, 300, 28);
        try {
            bufferedImage = ImageIO.read(pathNameStart);
            bStart.setIcon(new ImageIcon(bufferedImage));
        }
        catch (IOException e) {
            System.out.println("Image for ProductContinueExit Info not found");
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
                // System.out.println("bStart e = " + e.toString());
                setEvent(START);
            }
        });
        bInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // System.out.println("bInfo e = " + e.toString());
                setEvent(INFO);
            }
        });
        bExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // System.out.println("bExit e = " + e.toString());
                setEvent(EXIT);
            }
        });
        bStart.setBounds(270, 200, 140, 50);
        bInfo.setBounds(270, 270, 140, 50);
        bExit.setBounds(270, 340, 140, 50);
        setLayout(null);
        add(bStart);
        add(bInfo);
        add(bExit);
        add(jLabel);
    }

    public void setEvent(String s){
        this.event = s;
    }
    public String getEvent(){
        return this.event;
    }
    public JButton getBStart(){
        return this.bStart;
    }
    public JButton getBInfo() {return this.bInfo;}
    public JButton getBExit(){
        return this.bExit;
    }
    public JLabel getJLabel(){
        return this.jLabel;
    }
}

