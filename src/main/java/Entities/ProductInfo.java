package main.java.Entities;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ProductInfo extends JPanel{
    final private String CONTINUE = "continue";
    final private String EXIT = "exit";
    private String event = "";
    private JButton bContinue =new JButton("Continue");
    private JButton bExit =new JButton("Exit");
    private JLabel jLabel = new JLabel();
    private File pathNameContinue = new File("src/main/resources/iconContinue.png");
    private File pathNameExit = new File("src/main/resources/iconExit.png");
    private File pathBackground = new File("src/main/resources/backgroundMainMenu.png");
    private ImageIcon imageIconContinue;
    private ImageIcon imageIconExit;
    private Image background;
    private BufferedImage bufferedImage;

    public ProductInfo(){
        jLabel.setFont(new Font("MS Song", Font.BOLD, 24));
        jLabel.setText("<html>Pause - ESC <br>Arrow Keys - Movement</html>");
        jLabel.setBounds(210, 150, 300, 100);

        imageIconContinue = new ImageIcon();
        try {
            bufferedImage = ImageIO.read(pathNameContinue);
            bContinue.setIcon(new ImageIcon(bufferedImage));
        }
        catch (IOException e) {
            System.out.println("Image for ProductInfo Continue not found");
        }
        try {
            bufferedImage = ImageIO.read(pathNameExit);
            bExit.setIcon(new ImageIcon(bufferedImage));
        }
        catch (IOException e) {
            System.out.println("Image for ProductInfo Exit not found");
        }
        try {
            bufferedImage = ImageIO.read(pathBackground);
            background = bufferedImage;
        }
        catch (IOException e) {
            System.out.println("Image for ProductInfo Exit not found");
        }
        bContinue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // System.out.println("bStart e = " + e.toString());
                setEvent(CONTINUE);
            }
        });
        bExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // System.out.println("bStart e = " + e.toString());
                setEvent(EXIT);
            }
        });
        bContinue.setBounds(200, 340, 140, 50);
        bExit.setBounds(360, 340, 140, 50);
        setLayout(null);
        add(bContinue);
        add(bExit);
        add(jLabel);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, null);
    }

    public void setEvent(String s){
        this.event = s;
    }
    public String getEvent(){
        return this.event;
    }
    public JButton getBContinue(){return this.bContinue;}
    public JButton getBExit(){return this.bExit;}
    public JLabel getJLabel(){
        return this.jLabel;
    }
}