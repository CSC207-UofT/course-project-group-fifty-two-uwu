package main.java.Entities;

public class TrajectoryB {
    //The Trajectory class for the missiles
    private int x;
    private int y;
    private double v; // direction vector in gradients

    public void update(int x, int y, double v, int cx, int cy){
        boolean isLeft = true;
        this.x = x;
        this.y = y;
        // is the target on the left side of missile?
        // using doubles for greater precision
        // - use a cross product of the vector and
        //   the vector pointing to the target.
        // - the cross product is positive if target on left
        // - the tale of the product vector is at ax, ay
        // - the arrow head of the product vector is at bx, by
        // - the target is at cx, cy
        double ax = this.x;
        double ay = this.y;
        double bx = ax + 100 * Math.cos(this.v); //second point for vector ab
        double by = ay + 100 * Math.sin(this.v);
        isLeft = ((bx-ax)*(cy-ay) - (by-ay)*(cx-ax)) < 0;
        // is the missile moving in the direction of the target?
        // is the angle smaller than Math.PI/80 = 2.25 degrees?
        boolean isOnTarget = true;;
        double temp;
        //calculate the angle between ab and ac using the cosine law
        // c^2 = a^2 + b^2 -2ab*cos zeta
        // zeta = cos-1 (a^2 + b^2 - c^2)/(-2ab)
        double ab = Math.sqrt((bx - ax)*(bx - ax) + (by - ay)*(by - ay));
        double ac = Math.sqrt((cx - ax)*(cx - ax) + (cy - ay)*(cy - ay));
        double bc = Math.sqrt((cx - bx)*(cx - bx) + (cy - by)*(cy - by));
        temp = Math.acos((ab*ab + ac*ac - bc*bc)/((1)*(2*ab*ac)));
        // standard Math.PI/80 = 2.25 degrees
        double ANGLE = Math.PI / 110;
        isOnTarget = Math.abs(temp) < ANGLE;
        // calculate the new value for direction vector
        if(!isOnTarget){
            if(isLeft){
                this.v -= ANGLE;
            }
            else {
                this.v += ANGLE;
            }
        }
        // standard speed = 3
        int DELTA = 4;
        this.x += DELTA * Math.cos(this.v);
        this.y += DELTA * Math.sin(this.v);
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public double getV(){
        return this.v;
    }
}
