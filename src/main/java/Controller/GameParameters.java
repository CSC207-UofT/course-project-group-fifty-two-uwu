package main.java.Controller;

public class GameParameters {
    final long IMMUNITY = 300; // only one collision allowed within this time
    long startTime;
    long collisionResumeTime = System.currentTimeMillis();
    long pauseTime = 0;
    boolean collisionDetected = false;
    boolean collisionPaused = false;
    boolean gameStarted = false;
    boolean boomOn = false;
    int hits = 0;
    private String event = "";
    private String topFive = "";

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public void setCollisionDetected(boolean collisionDetected) {
        // System.out.println("GameParameters setCollisionDetected = " + collisionDetected);
        this.collisionDetected = collisionDetected;
        this.boomOn = collisionDetected;
        if (collisionDetected){
            collisionResumeTime = System.currentTimeMillis() + IMMUNITY;
        }
    }

    public void setCollisionPaused(boolean collisionPaused) {
        this.collisionPaused = collisionPaused;
    }

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

    public boolean isBoomOn(){
        // System.out.println("GameParameters System.currentTimeMillis() = " + System.currentTimeMillis() + " this.collisionResumeTime = " + this.collisionResumeTime);
        if (System.currentTimeMillis() > this.collisionResumeTime) {
            // System.out.println("GameParameters System.currentTimeMillis() = " + System.currentTimeMillis() + " this.collisionResumeTime = " + this.collisionResumeTime);
            // System.out.println("GameParameters isBoomOn NO");
            this.boomOn = false;
            return false;
        }
        else {
            // System.out.println("GameParameters isBoomOn YES");
            return this.boomOn;
        }
    }

    public boolean isCollisionPaused(){
        return collisionPaused;
    }



    public String getScore(){
        long secondsPassed = (System.currentTimeMillis() - this.startTime)/1000;
        return String.valueOf(secondsPassed);
    }
    public void clear(){
        this.hits = 0;
        this.event = "";
        this.gameStarted = false;
    }
    public void resumeGame(){
        if (this.gameStarted) {
            this.startTime = this.startTime + (System.currentTimeMillis() - this.pauseTime);
            this.pauseTime = 0;
            // this.gameStarted = true;
        }
    }
    public void pauseGame(){this.pauseTime = System.currentTimeMillis();}
    public void startGame(){this.gameStarted = true;}
    public void setTopFive(String str){this.topFive = str;}
    public void setEvent(String event){this.event = event;}
    public void setHits(){this.hits++;}
    public long getGameTime(){
        return System.currentTimeMillis() - this.startTime;
    }
    public boolean isGameStarted(){return this.gameStarted;}
    public String getEvent(){return this.event;}
    public int getHits(){return this.hits;}
    public String getTopFive(){return this.topFive;}
}