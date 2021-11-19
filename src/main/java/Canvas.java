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

    public void update(Iterator iterator, int key){
        JPanel item;
        ProductA productA;
        ProductB productB;
        ProductP productP;
        // this.jframe.getContentPane().removeAll();
        while(iterator.hasNext()){
            item = (JPanel) iterator.next();
            switch (item.getClass().getName()) {
                case "main.java.ProductP":
                    if (key >= 37 && key <= 40) {
                        productP = (ProductP) item;
                        productP.update(key);
                        targetX = productP.getX();
                        targetY = productP.getY();
                        //System.out.println("CanvasA target x = " + targetX + " y = " + targetY);
                    }
                    break;
                case "main.java.ProductA":
                    productA = (ProductA) item;
                    productA.update();
                    break;
                case "main.java.ProductB":
                    productB = (ProductB) item;
                    //System.out.println("CanvasB target x = " + targetX + " y = " + targetY);
                    productB.update(targetX, targetY);
                    break;
            }
        }
    }

    public void paint(Iterator iterator){
        this.jframe.getContentPane().removeAll();
        while(iterator.hasNext()){
            this.jframe.revalidate();
            this.jframe.getContentPane().add((JPanel) iterator.next());
        }
        this.jframe.repaint();
        this.jframe.setVisible(true);
    }
}
