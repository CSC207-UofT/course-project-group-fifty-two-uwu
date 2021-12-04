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
    // audio clips
    private Clip clipInProgress;
    private Clip clipGameStart;
    private Clip clipGamePause;
    private Clip clipGameName;
    private Clip clipGameOver;
    private Clip clipGameExit;

    /**
     * Opens and stores in memory clips with the wav format from provided audio input stream.
     *
     * @throws UnsupportedAudioFileException
     * @throws IOException
     * @throws LineUnavailableException
     */
    public SoundEffect() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        AudioInputStream audioInputStream;
        String PATH_IN_PROGRESS = "src/main/resources/SoundBegin.wav";
        audioInputStream = AudioSystem.getAudioInputStream(new File(PATH_IN_PROGRESS));
        clipInProgress = AudioSystem.getClip();
        clipInProgress.open(audioInputStream);
        String PATH_GAME_START = "src/main/resources/SoundBegin.wav";
        audioInputStream = AudioSystem.getAudioInputStream(new File(PATH_GAME_START));
        clipGameStart = AudioSystem.getClip();
        clipGameStart.open(audioInputStream);
        String PATH_GAME_PAUSE = "src/main/resources/SoundPause.wav";
        audioInputStream = AudioSystem.getAudioInputStream(new File(PATH_GAME_PAUSE));
        clipGamePause = AudioSystem.getClip();
        clipGamePause.open(audioInputStream);
        String PATH_GAME_NAME = "src/main/resources/SoundInput.wav";
        audioInputStream = AudioSystem.getAudioInputStream(new File(PATH_GAME_NAME));
        clipGameName = AudioSystem.getClip();
        clipGameName.open(audioInputStream);
        String PATH_GAME_OVER = "src/main/resources/SoundGameOver.wav";
        audioInputStream = AudioSystem.getAudioInputStream(new File(PATH_GAME_OVER));
        clipGameOver = AudioSystem.getClip();
        clipGameOver.open(audioInputStream);
        String PATH_GAME_EXIT = "src/main/resources/SoundGameOver.wav";
        audioInputStream = AudioSystem.getAudioInputStream(new File(PATH_GAME_EXIT));
        clipGameExit = AudioSystem.getClip();
        clipGameExit.open(audioInputStream);
    }

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
        String pathInProgress = "src/main/resources/SoundBegin.wav";
        String pathGameStart = "src/main/resources/SoundBegin.wav";
        String pathGamePause = "src/main/resources/SoundPause.wav";
        String pathGameName = "src/main/resources/SoundInput.wav";
        String pathGameOver = "src/main/resources/SoundGameOver.wav";
        String pathGameExit = "src/main/resources/SoundGameOver.wav";
        if (gameState == stateInProgress){
            audioInputStream = AudioSystem.getAudioInputStream(new File(pathInProgress));
            clipInProgress = AudioSystem.getClip();
            clipInProgress.open(audioInputStream);
            clipInProgress.loop(0);
        }
        else if (gameState == stateGameStart){
            audioInputStream = AudioSystem.getAudioInputStream(new File(pathGameStart));
            clipGameStart = AudioSystem.getClip();
            clipGameStart.open(audioInputStream);
            clipGameStart.loop(0);
        }
        else if (gameState == stateGamePause){
            audioInputStream = AudioSystem.getAudioInputStream(new File(pathGamePause));
            clipGamePause = AudioSystem.getClip();
            clipGamePause.open(audioInputStream);
            clipGamePause.loop(0);
        }
        else if (gameState == stateUserName){
            audioInputStream = AudioSystem.getAudioInputStream(new File(pathGameName));
            clipGameName = AudioSystem.getClip();
            clipGameName.open(audioInputStream);
            clipGameName.loop(0);
        }
        else if (gameState == stateGameOver){
            audioInputStream = AudioSystem.getAudioInputStream(new File(pathGameOver));
            clipGameOver = AudioSystem.getClip();
            clipGameOver.open(audioInputStream);
            clipGameOver.loop(0);
        }
        else if (gameState == stateExit){
            audioInputStream = AudioSystem.getAudioInputStream(new File(pathGameExit));
            clipGameExit = AudioSystem.getClip();
            clipGameExit.open(audioInputStream);
            clipGameExit.loop(0);
        }
    }
}