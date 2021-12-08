package main.java.UseCases;

import main.java.Controller.GameParameters;
import main.java.Entities.*;
import javax.swing.*;
import java.util.Iterator;

/**
 *  @author Yan
 *  @version 2
 *  @since December 5, 2021
 *
 * Scans the list of active JPanels and extracts events.
 * <p>
 * Informs Missiles of the current position of the target.
 * Extracts from Missiles collision detection and passes
 * this information to GameParameters.
 * Informs HitCounter of the current number of hits.
 * Injects reference to GameParameters into stationary
 * JPanels which enables them record user input directly
 * to GameParameters.
 * Passes key pressed events to Pilot, which enables the
 * Pilot to change position.
 * Informs Pilot about Explosion since images for Pilot and
 * Explosion are stored in the Pilot JPanel.
 * Passes the current play time from GameParameters to Clock.
 */
public class Inspector {
    private final GameParameters gameParameters; // a board to exchange events
    private int targetX = 150; // initial position of the target
    private int targetY = 150; // initial y coordinate of the target

    /**
     * @param gameParameters    class that stores game events
     */
    public Inspector(GameParameters gameParameters) {
        this.gameParameters = gameParameters;
    }

    /**
     * Updates Missiles with the current position of the target.
     * Updates Clock with current game time.
     * Updates HitCounter with the current number of hits.
     * Injects stationary screens with a reference to GameParameters,
     * which enables the listeners attached to these screens
     * to record their events directly in GameParameters.
     * Updates Pilot with the current keystrokes and the explosion
     * event to move Pilot and display the explosion.
     *
     * @param iterator      an array of JPanel that are currently active
     * @param key           integer for key pressed to navigate Pilot
     */
    public void update(Iterator<JPanel> iterator, int key) {
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
                ((Pilot) jPanel).setBoomOn(this.gameParameters.isBoomOn());
            } else if (jPanel.getClass().getName().contains("Clock")) {
                ((Clock) jPanel).updateClock(gameParameters.getGameTime());
            }
        }
    }
}
