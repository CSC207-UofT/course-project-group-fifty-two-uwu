package main.java;

import javax.swing.*;

public class Canvas {
    JFrame jframe;
    ProductA productA = new ProductA();
    ProductB productB = new ProductB();
    ProductP productP = new ProductP();
    ProductContinueExit productContinueExit = new ProductContinueExit();
    JTextArea clock = new JTextArea();

    public Canvas(JFrame jframe){
        this.jframe = jframe;
        // this.jframe.setLayout(null);
        this.clock.setLocation(480, 390);
        this.clock.setText("clock");
    }

    public void update(int key){
        this.productA.update();
        this.productB.update();
        if (key >= 37 && key <= 40) {
            this.productP.update(key);
        }
    }

    public void paint(int gameState){
        if (gameState == 0) {
            this.jframe.getContentPane().removeAll();
            this.jframe.getContentPane().add(this.productP);
            this.jframe.revalidate();
            this.jframe.getContentPane().add(this.productA);
            this.jframe.revalidate();
            this.jframe.getContentPane().add(this.productB);
            this.jframe.revalidate();
            this.jframe.getContentPane().add(this.clock);
            this.jframe.revalidate();
        }
        else if (gameState == 1) {
            this.jframe.getContentPane().removeAll();
            this.jframe.getContentPane().add(this.productContinueExit);
        }

        this.jframe.repaint();
        this.jframe.setVisible(true);
    }
}
