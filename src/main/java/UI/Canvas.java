package main.java.UI;

import main.java.Controller.GameParameters;
import main.java.Entities.ProductB;
import main.java.Entities.ProductP;
import main.java.Entities.ProductSputnik;
import main.java.Entities.ProductTimer;

import javax.swing.*;
import java.util.Iterator;

public class Canvas {
    //paints images (products) according to the stage of the game.
    //Initially, this class creates a set of products which during the game, can be
    //added to or remove from the canvas. This class also calls on products to
    private final JFrame jFrame;
    private final GameParameters gameParameters;
    private int targetX = 200;
    private int targetY = 200;

    public Canvas(JFrame jFrame, GameParameters gameParameters){
        this.jFrame = jFrame;
        this.jFrame.setVisible(true);
        this.gameParameters = gameParameters;
    }

    public void update(Iterator<JPanel> iterator, int key, String timeElapsed){
        JPanel jPanel;
        // long currentTime = System.currentTimeMillis();
        this.jFrame.getContentPane().removeAll();
        this.jFrame.getContentPane().revalidate();
        while (iterator.hasNext()){
            jPanel = iterator.next();
            if (jPanel.getClass().getName().contains("ProductB")) {
                ((ProductB) jPanel).update(this.targetX, this.targetY);
                if (((ProductB) jPanel).isCollisionDetected()){
                    this.gameParameters.setCollisionDetected(true);
                }
                // System.out.println("Canvas update added " + jPanel.getClass().getName());
            }
            else if (jPanel.getClass().getName().contains("ProductSputnik")) {
                ((ProductSputnik) jPanel).update(this.targetX, this.targetY);
                if (((ProductSputnik) jPanel).isCollisionDetected()){
                    this.gameParameters.setCollisionDetected(true);
                }
                // System.out.println("Canvas update added " + jPanel.getClass().getName());
            }
            else if (jPanel.getClass().getName().contains("ProductP")) {
                if (key >= 37 && key <= 40) {
                    ((ProductP) jPanel).update(key);
                    this.targetX = jPanel.getX();
                    this.targetY = jPanel.getY();
                }
                // System.out.println("Canvas update added " + jPanel.getClass().getName());
            }
            else if (jPanel.getClass().getName().contains("ProductTimer")) {
                ((ProductTimer) jPanel).updateClock(gameParameters.getGameTime());
                // System.out.println("Canvas update added " + jPanel.getClass().getName());
            }
            this.jFrame.getContentPane().add(jPanel);
            this.jFrame.revalidate();
        }
    }

    public void paint(){
        // System.out.println("Canvas paint " + this.jFrame.isVisible());
        this.jFrame.repaint();
    }
}