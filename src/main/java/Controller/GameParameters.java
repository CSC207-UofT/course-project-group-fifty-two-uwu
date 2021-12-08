package main.java.Controller;

/**
 * Serves as an exchange board or interface between GameState and JPanels
 *
 * @author Yan Nowaczek yan.nowaczek@mail.utoronto.ca
 * @version C
 * @since 1.0, November 25, 2021
 */
public class GameParameters {
    private long startTime; // the start of the game in milliseconds
    private long collisionResumeTime = System.currentTimeMillis(); // time when the collision no longer exists
    private long pauseTime = 0; // to update the startTime
    private boolean collisionDetected = false;
    private boolean collisionPaused = false;
    private boolean gameStarted = false; // game resumed after pause
    private boolean boomOn = false; // show the explosion image
    private int hits = 0; // score or lives lost
    private String event = ""; // collected from stationary JPanels (screens)
    private String topFive = ""; // collected from GameState for the GameOver screen
    private String username = "";

    /**
     * Sets the time when the game started in milliseconds
     * @param startTime long for start time
     */
    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    /**
     * Notifies of the collision
     * Sets boomOn and collisionDetected to true
     * Sets the time when the collision period ends
     * @param collisionDetected boolean
     */
    public void setCollisionDetected(boolean collisionDetected) {
        this.collisionDetected = collisionDetected;
        this.boomOn = collisionDetected;
        if (collisionDetected){
            // only one collision allowed within this time
            long immunity = 300;
            collisionResumeTime = System.currentTimeMillis() + immunity;
        }
    }

    /**
     * Notifies that the collision is in progress
     * @param collisionPaused boolean
     */
    public void setCollisionPaused(boolean collisionPaused) {
        this.collisionPaused = collisionPaused;
    }

    /**
     * Informs if collision has been detected and sets
     * the collisionDetected to false in order to prevent the program
     * from playing the explosion audio clips repeatedly
     * @return boolean
     */
    public boolean isCollisionDetected(){
        if (System.currentTimeMillis() > collisionResumeTime) {
            boolean outcome = this.collisionDetected;
            setCollisionDetected(false);
            return outcome;
        }
        else {
            return false;
        }
    }

    /**
     * Informs that the explosion happened. It does so only once to
     * prevent the system from playing video clips of setting the explosion
     * to visible repeatedly
     * @return boolean
     */
    public boolean isBoomOn(){
        if (System.currentTimeMillis() > this.collisionResumeTime) {
            this.boomOn = false;
            return false;
        }
        else {
            return this.boomOn;
        }
    }

    /**
     * Informs that the collision period is in progress
     * @return boolean
     */
    public boolean isCollisionPaused(){
        return collisionPaused;
    }

    /**
     * Returns the number of seconds passed since the start of the game
     * @return String value of seconds
     */
    public String getScore(){
        long secondsPassed = (System.currentTimeMillis() - this.startTime)/1000;
        return String.valueOf(secondsPassed);
    }

    /**
     * Sets parameters to default value, preventing GameState from detecting
     * same event repeatedly
     */
    public void clear(){
        this.hits = 0;
        this.event = "";
        this.gameStarted = false;
    }

    /**
     * Adjusts the start time and the pause time after the game resumes
     */
    public void resumeGame(){
        if (this.gameStarted) {
            this.startTime = this.startTime + (System.currentTimeMillis() - this.pauseTime);
            this.pauseTime = 0;
        }
    }

    /**
     * These methods update and get parameters of the game
     */
    public void pauseGame(){this.pauseTime = System.currentTimeMillis();}
    public void startGame(){this.gameStarted = true;}
    public void setUsername(String username){this.username = username;}
    public void setTopFive(String str){this.topFive = str;}
    public void setEvent(String event){this.event = event;}
    public void setHits(){this.hits++;}
    public String getUsername(){return this.username;}
    public long getGameTime(){return System.currentTimeMillis() - this.startTime;}
    public boolean isGameStarted(){return this.gameStarted;}
    public String getEvent(){return this.event;}
    public int getHits(){return this.hits;}
    public String getTopFive(){return this.topFive;}
}