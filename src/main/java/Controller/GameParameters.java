package main.java.Controller;

public class GameParameters {
    final long IMMUNITY = 300; // only one collision allowed within this time
    long startTime;
    long duration;
    long collisionResumeTime = System.currentTimeMillis();
    boolean collisionDetected = false;
    boolean collisionPaused = false;

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public void setCollisionDetected(boolean collisionDetected) {
        this.collisionDetected = collisionDetected;
        collisionResumeTime = System.currentTimeMillis() + IMMUNITY;
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

    public boolean isCollisionPaused(){
        return collisionPaused;
    }

    public long getGameTime(){
        return System.currentTimeMillis() - this.startTime;
    }
}