package main.java;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;

public class Canvas {
    //paints images (products) according to the stage of the game.
    //Initially, this class creates a set of products which during the game, can be
    //added to or remove from the canvas. This class also calls on products to
    //update their positions if appropriate
    JFrame jFrame;
    JTextArea clock = new JTextArea();
    int targetX = 200;
    int targetY = 200;

    public Canvas(JFrame jframe){
        this.jFrame = jframe;
    }

    public void update(Iterator<JPanel> iterator, int key, String timeElapsed){
        JPanel item;
        ProductB productB;
        ProductP productP;
        ProductTimer productTimer;
        while(iterator.hasNext()){
            item = (JPanel) iterator.next();
            switch (item.getClass().getName()) {
                case "main.java.ProductP":
                    if (key >= 37 && key <= 40) {
                        productP = (ProductP) item;
                        productP.update(key);
                        targetX = productP.getX();
                        targetY = productP.getY();
                    }
                    break;
                case "main.java.ProductA":
                    ((ProductA) item).update();
                    break;
                case "main.java.ProductB":
                    productB = (ProductB) item;
                    productB.update(targetX, targetY);
                    break;
                case "main.java.ProductTimer":
                    productTimer = (ProductTimer) item;
                    productTimer.update(timeElapsed);
                    break;
                case "main.java.ProductContinueExit":
                    break;
            }
        }
    }

    public void paint(Iterator<JPanel> iterator){
        JPanel jPanel;
        JLabel jLabel;
        ProductContinueExit productContinueExit;
        ProductInfo productInfo;
        ProductGetUserName productGetUserName;
        ProductTimer productTimer;
        this.jFrame.getContentPane().removeAll();
        while(iterator.hasNext()){
            this.jFrame.revalidate();
            jPanel = (JPanel) iterator.next();
            switch (jPanel.getClass().getName()) {
                case "main.java.ProductGetUserName":
                    // System.out.println("Canvas in painter");
                    productGetUserName = (ProductGetUserName) jPanel;
                    productGetUserName.setLayout(null);
                    productGetUserName.setVisible(true);
                    productGetUserName.setAlignmentX(200);
                    productGetUserName.setAlignmentY(200);
                    ((ProductGetUserName) jPanel).jTextField.setBounds(100, 100, 100, 100);
                    this.jFrame.revalidate();
                    ((ProductGetUserName) jPanel).jTextField.setToolTipText("<html><b><font color=red>"
                            + "Please enter your name here" + "</font></b></html>");
                    this.jFrame.revalidate();
                    this.jFrame.getContentPane().add(((ProductGetUserName) jPanel).jTextField, BorderLayout.CENTER);
                    // this.jFrame.getContentPane().add(((ProductGetUserName) jPanel).jTextField, BorderLayout.CENTER);
                    this.jFrame.revalidate();
                    this.jFrame.getContentPane().add(new JTextField("Enter your name"));
                    this.jFrame.revalidate();
                    this.jFrame.getContentPane().add(new JLabel("hello"));
                    break;
                case "main.java.ProductContinueExit":
                    productContinueExit = (ProductContinueExit) jPanel;
                    productContinueExit.setLayout(null);
                    productContinueExit.bStart.setBounds((this.jFrame.getWidth()/2)-70, 150, 140, 50);
                    productContinueExit.bInfo.setBounds((this.jFrame.getWidth()/2)-70, 220, 140, 50);
                    productContinueExit.bExit.setBounds((this.jFrame.getWidth()/2)-70, 290, 140, 50);
                    jLabel = productContinueExit.getWelcome();
                    this.jFrame.getContentPane().add(jPanel);
                    this.jFrame.revalidate();
                    // System.out.println(jLabel.getText());
                    jLabel.setBounds(20, 20, 100, 100);
                    this.jFrame.getContentPane().add(jLabel);
                    this.jFrame.revalidate();
                    //this.jFrame.getContentPane().add(jPanel);
                    //this.jFrame.revalidate();
                    // this.jFrame.getContentPane().add(new JLabel(""));
                    break;
                case "main.java.ProductInfo":
                    productInfo = (ProductInfo) jPanel;
                    productInfo.setLayout(null);
                    productInfo.bContinue.setBounds((this.jFrame.getWidth()/2)+10, 400, 140, 50);
                    productInfo.bExit.setBounds((this.jFrame.getWidth()/2)-150, 400, 140, 50);
                    this.jFrame.getContentPane().add(jPanel);
                    this.jFrame.revalidate();
                    break;
                case "main.java.ProductTimer":
                    productTimer = (ProductTimer) jPanel;
                    productTimer.setLayout(null);
                    productTimer.jLabel.setBounds(25, 525, 60, 20);
                    this.jFrame.getContentPane().add(productTimer.jLabel);
                    this.jFrame.getContentPane().add(new JLabel(""));
                    break;
                default:
                    this.jFrame.getContentPane().add((JPanel) jPanel);
            }
        }
        this.jFrame.repaint();
        this.jFrame.setVisible(true);
    }
}
