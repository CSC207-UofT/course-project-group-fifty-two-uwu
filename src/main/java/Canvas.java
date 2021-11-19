package main.java;

import javax.swing.*;
import java.util.Iterator;

public class Canvas {
    JFrame jframe;
    JTextArea clock = new JTextArea();
    int targetX = 200;
    int targetY = 200;

    public Canvas(JFrame jframe){
        this.jframe = jframe;
        // this.jframe.setLayout(null);
        //this.clock.setLocation(480, 390);
        //this.clock.setText("clock");
    }

    public void update(Iterator iterator, int key, String timeElapsed){
        JPanel item;
        ProductA productA;
        ProductB productB;
        ProductP productP;
        ProductContinueExit productContinueExit;
        ProductTimer productTimer;
        // this.jframe.getContentPane().removeAll();
        // jframe.setLayout(null);
        while(iterator.hasNext()){
            item = (JPanel) iterator.next();
            switch (item.getClass().getName()) {
                case "main.java.ProductP":
                    if (key >= 37 && key <= 40) {
                        productP = (ProductP) item;
                        productP.update(key);
//                        ((ProductP) item).update(key);
                        targetX = productP.getX();
                        targetY = productP.getY();
//                        ((ProductA) item).getX();
//                        ((ProductA) item).getY();
                        System.out.println("CanvasA target x = " + targetX + " y = " + targetY);
                    }
                    break;
                case "main.java.ProductA":
                    // productA = (ProductA) item;
                    // productA.update();
                    ((ProductA) item).update();
                    break;
                case "main.java.ProductB":
                    productB = (ProductB) item;
                    //System.out.println("CanvasB target x = " + targetX + " y = " + targetY);
                    productB.update(targetX, targetY);
                    break;
                case "main.java.ProductTimer":
                    productTimer = (ProductTimer) item;
                    productTimer.update(timeElapsed);
                    break;
                case "main.java.ProductContinueExit":
                    productContinueExit = (ProductContinueExit) item;
                    break;
            }
        }
    }

    public void paint(Iterator iterator){
        JPanel jPanel;
        ProductContinueExit productContinueExit;
        ProductTimer productTimer;
        this.jframe.getContentPane().removeAll();
//        this.jframe.getContentPane().add(new JLabel("Hello World"));
//        this.jframe.revalidate();
        while(iterator.hasNext()){
            this.jframe.revalidate();
            jPanel = (JPanel) iterator.next();
            switch (jPanel.getClass().getName()) {
                case "main.java.ProductContinueExit":
                    productContinueExit = (ProductContinueExit) jPanel;
                    productContinueExit.setLayout(null);
                    productContinueExit.bStart.setBounds((this.jframe.getWidth()/2)-70, 150, 140, 50);
                    productContinueExit.bInfo.setBounds((this.jframe.getWidth()/2)-70, 220, 140, 50);
                    productContinueExit.bExit.setBounds((this.jframe.getWidth()/2)-70, 290, 140, 50);
                    this.jframe.getContentPane().add((JPanel) jPanel);
                    break;
                case "main.java.ProductTimer":
                    productTimer = (ProductTimer) jPanel;
                    // productTimer.update("new timer");
                    // System.out.println("painting Timer" + productTimer.getName());
                    productTimer.jLabel.setBounds(25, 525, 60, 20);
                    // System.out.println("painting Timer " + productTimer.jLabel.getText());
                    productTimer.setLayout(null);
                    this.jframe.getContentPane().add(productTimer.jLabel);
                    // this.jframe.revalidate();
                    this.jframe.getContentPane().add(new JLabel(""));
                    break;
                default:
                    this.jframe.getContentPane().add((JPanel) jPanel);
            }
        }
        this.jframe.repaint();
        this.jframe.setVisible(true);
    }
}
