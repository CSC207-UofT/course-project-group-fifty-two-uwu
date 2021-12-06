package main.java.UseCases;

import main.java.Controller.GameParameters;
import main.java.Entities.*;

import javax.swing.*;
import java.util.Iterator;

public class Inspector {
    private final GameParameters gameParameters;
    private int targetX = 150;
    private int targetY = 150;

    public Inspector(JFrame jFrame, GameParameters gameParameters) {
        this.gameParameters = gameParameters;
    }

    public void update(Iterator<JPanel> iterator, int key, String timeElapsed) {
        JPanel jPanel;
        while (iterator.hasNext()) {
            jPanel = iterator.next();
            if (jPanel.getClass().getName().contains("MissileDark")) {
                ((Missile) jPanel).update(this.targetX, this.targetY);
                if (((Missile) jPanel).isCollisionDetected()) {
                    this.gameParameters.setCollisionDetected(true);
                    this.gameParameters.setCollisionDetected(true);
                }
            } else if (jPanel.getClass().getName().contains("Missile")) {
                ((Missile) jPanel).update(this.targetX, this.targetY);
                if (((Missile) jPanel).isCollisionDetected()) {
                    this.gameParameters.setCollisionDetected(true);
                    this.gameParameters.setCollisionDetected(true);
                }
            } else if (jPanel.getClass().getName().contains("Sputnik")) {
                ((Sputnik) jPanel).update(this.targetX, this.targetY);
                if (((Sputnik) jPanel).isCollisionDetected()) {
                    this.gameParameters.setCollisionDetected(true);
                    this.gameParameters.setCollisionDetected(true);
                }
            } else if (jPanel.getClass().getName().contains("HitCounter")) {
                ((HitCounter) jPanel).update(this.gameParameters.getHits());
            } else if (jPanel.getClass().getName().contains("ScreenInfo")) {
                ((ScreenInfo) jPanel).injectGameParameters(this.gameParameters);
            } else if (jPanel.getClass().getName().contains("ScreenMainMenuDark")) {
                ((ScreenMainMenuDark) jPanel).injectGameParameters(this.gameParameters);
                ((ScreenMainMenuDark) jPanel).setUsername(this.gameParameters.getUsername());
            } else if (jPanel.getClass().getName().contains("ScreenMainMenu")) {
                ((ScreenMainMenu) jPanel).injectGameParameters(this.gameParameters);
                ((ScreenMainMenu) jPanel).setUsername(this.gameParameters.getUsername());
            } else if (jPanel.getClass().getName().contains("ScreenName")) {
                ((ScreenName) jPanel).injectGameParameters(this.gameParameters);
            } else if (jPanel.getClass().getName().contains("ScreenGameOver")) {
                String info = "<html><div style='text-align: center;'>Game Over! <br>Score ";
                info = info + this.gameParameters.getScore() + " seconds</div></html>";
                ((ScreenGameOver) jPanel).getJLabel().setText(info);
                ((ScreenGameOver) jPanel).getJLabelTopScores().setText(this.gameParameters.getTopFive());
                ((ScreenGameOver) jPanel).injectGameParameters(this.gameParameters);
            } else if (jPanel.getClass().getName().contains("Pilot")) {
                if (key >= 37 && key <= 40) {
                    ((Pilot) jPanel).update(key);
                    this.targetX = jPanel.getX();
                    this.targetY = jPanel.getY();
                }
                if (this.gameParameters.isBoomOn()) {
                    ((Pilot) jPanel).setBoomOn(true);
                } else {
                    ((Pilot) jPanel).setBoomOn(false);
                }
            } else if (jPanel.getClass().getName().contains("Clock")) {
                ((Clock) jPanel).updateClock(gameParameters.getGameTime());
            }
        }
    }
}
