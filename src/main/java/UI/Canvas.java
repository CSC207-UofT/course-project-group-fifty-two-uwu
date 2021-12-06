package main.java.UI;

import main.java.Controller.GameParameters;
import main.java.Entities.*;
import main.java.Entities.ScreenGameOver;

import javax.swing.*;
import java.util.Iterator;

public class Canvas {
    //paints images (products) according to the stage of the game.
    //Initially, this class creates a set of products which during the game, can be
    //added to or remove from the canvas. This class also calls on products to
    private final JFrame jFrame;
    private final GameParameters gameParameters;
    private int targetX = 150;
    private int targetY = 150;

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
            if (jPanel.getClass().getName().contains("MissileDark")) {
                ((Missile) jPanel).update(this.targetX, this.targetY);
                if (((Missile) jPanel).isCollisionDetected()){
                    this.gameParameters.setCollisionDetected(true);
                    this.gameParameters.setCollisionDetected(true);
                }
            }
            else if (jPanel.getClass().getName().contains("Missile")) {
                ((Missile) jPanel).update(this.targetX, this.targetY);
                if (((Missile) jPanel).isCollisionDetected()){
                    this.gameParameters.setCollisionDetected(true);
                    this.gameParameters.setCollisionDetected(true);
                }
            }
            else if (jPanel.getClass().getName().contains("Sputnik")) {
                ((Sputnik) jPanel).update(this.targetX, this.targetY);
                if (((Sputnik) jPanel).isCollisionDetected()){
                    this.gameParameters.setCollisionDetected(true);
                    this.gameParameters.setCollisionDetected(true);
                }
            }
            else if (jPanel.getClass().getName().contains("HitCounter")) {
                ((HitCounter) jPanel).update(this.gameParameters.getHits());
            }
            else if (jPanel.getClass().getName().contains("ScreenInfo")) {
                ((ScreenInfo) jPanel).injectGameParameters(this.gameParameters);
            }
            else if (jPanel.getClass().getName().contains("ScreenMainMenuDark")) {
                ((ScreenMainMenuDark) jPanel).injectGameParameters(this.gameParameters);
                ((ScreenMainMenuDark) jPanel).setUsername(this.gameParameters.getUsername());
            }
            else if (jPanel.getClass().getName().contains("ScreenMainMenu")) {
                ((ScreenMainMenu) jPanel).injectGameParameters(this.gameParameters);
                ((ScreenMainMenu) jPanel).setUsername(this.gameParameters.getUsername());
            }
            else if (jPanel.getClass().getName().contains("ScreenName")) {
                ((ScreenName) jPanel).injectGameParameters(this.gameParameters);
            }
            else if (jPanel.getClass().getName().contains("ScreenGameOver")) {
                String info = "<html><div style='text-align: center;'>Game Over! <br>Score ";
                info = info + this.gameParameters.getScore() + " seconds</div></html>";
                ((ScreenGameOver) jPanel).getJLabel().setText(info);
                ((ScreenGameOver) jPanel).getJLabelTopScores().setText(this.gameParameters.getTopFive());
                ((ScreenGameOver) jPanel).injectGameParameters(this.gameParameters);
            }
            else if (jPanel.getClass().getName().contains("Pilot")) {
                if (key >= 37 && key <= 40) {
                    ((Pilot) jPanel).update(key);
                    this.targetX = jPanel.getX();
                    this.targetY = jPanel.getY();
                }
                if (this.gameParameters.isBoomOn()){
                    ((Pilot) jPanel).setBoomOn(true);
                }
                else {
                    ((Pilot) jPanel).setBoomOn(false);
                }
            }
            else if (jPanel.getClass().getName().contains("Clock")) {
                ((Clock) jPanel).updateClock(gameParameters.getGameTime());
            }
            this.jFrame.getContentPane().add(jPanel);
            this.jFrame.revalidate();
        }
    }

    public void paint(){
        this.jFrame.repaint();
    }
}