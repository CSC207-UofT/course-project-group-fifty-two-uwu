package main.java.UI;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/**
 * This class plays sound effects in response to changing
 * game states in GameState.
 *
 * @author  Terry
 * @version 1.0
 * @since December 3, 2021
 */
public class SoundEffect {

    /**
     * Plays once the sound effect associated with a specific gameState
     * @param gameState     intger genarated by GameState
     */
    public void playSoundEffect(int gameState) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        AudioInputStream audioInputStream;
        int stateInProgress = 0; // Game is in progress
        int stateGameStart = 5; // Contains MainMenu and Start button
        int stateGamePause = 6; // Pause screen
        int stateUserName = 7; // Username input Screen
        int stateGameOver = 8; // GameOver screen
        int stateExit = 9; // Program is terminate
        String pathInProgress = "src/main/resources/SoundCollision.wav";
        String pathGameStart = "src/main/resources/SoundBegin.wav";
        String pathGamePause = "src/main/resources/SoundPause.wav";
        String pathGameName = "src/main/resources/SoundInput.wav";
        String pathGameOver = "src/main/resources/SoundGameOver.wav";
        String pathGameExit = "src/main/resources/SoundGameOver.wav";
        if (gameState == stateInProgress){
            audioInputStream = AudioSystem.getAudioInputStream(new File(pathInProgress));
            // audio clips
            Clip clipInProgress = AudioSystem.getClip();
            clipInProgress.open(audioInputStream);
            clipInProgress.loop(0);
        }
        else if (gameState == stateGameStart){
            audioInputStream = AudioSystem.getAudioInputStream(new File(pathGameStart));
            Clip clipGameStart = AudioSystem.getClip();
            clipGameStart.open(audioInputStream);
            clipGameStart.loop(0);
        }
        else if (gameState == stateGamePause){
            audioInputStream = AudioSystem.getAudioInputStream(new File(pathGamePause));
            Clip clipGamePause = AudioSystem.getClip();
            clipGamePause.open(audioInputStream);
            clipGamePause.loop(0);
        }
        else if (gameState == stateUserName){
            audioInputStream = AudioSystem.getAudioInputStream(new File(pathGameName));
            Clip clipGameName = AudioSystem.getClip();
            clipGameName.open(audioInputStream);
            clipGameName.loop(0);
        }
        else if (gameState == stateGameOver){
            audioInputStream = AudioSystem.getAudioInputStream(new File(pathGameOver));
            Clip clipGameOver = AudioSystem.getClip();
            clipGameOver.open(audioInputStream);
            clipGameOver.loop(0);
        }
        else if (gameState == stateExit){
            audioInputStream = AudioSystem.getAudioInputStream(new File(pathGameExit));
            Clip clipGameExit = AudioSystem.getClip();
            clipGameExit.open(audioInputStream);
            clipGameExit.loop(0);
        }
    }
}