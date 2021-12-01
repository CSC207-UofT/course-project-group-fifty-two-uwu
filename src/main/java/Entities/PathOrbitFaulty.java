package main.java.Entities;

/**
 * @author Terry
 * @version 1
 * @since November 30, 2021
 */
public class PathOrbitFaulty implements steerable {
    private int x; // x coordinate
    private int y; // y coordinate
    private double v; // direction vector in gradients
    private final int DELTA = 3; // increment per single update
    private final double ANGLE = Math.PI / 90; // Math.PI /80 = 2.25 degrees
    /**
     * BUG_FREQUENCY is the maximum number of flicks that
     * the steerable will attempt to reach the target
     * with swapped coordinates. Must be greater than 1.
     */
    private final int BUG_FREQUENCY = 60;
    /**
     * the number of flicks that this steerable will chase
     * a target with swapped coordinates. this number
     * decreases with every call to update();
     */
    private int bug = 0;

    /**
     * Updates coordinates and direction of this steerable
     * <p>
     * The method determines if the target isLeft;
     * determines if the steerable moves towards to target;
     * if not isOnTarget then adjusts the direction by ANGLE; and
     * calculates new coordinates based on DELTA.
     *
     * The method also generates a random integer with range
     * 0 to BUG_FREQUENCY*4 - 1;
     * if the random number is the maximum, then assigns
     * the random number to bug;
     * variable bug is decreased by one at each update();
     * if bug is greater than zero the coordinates of the target
     * are swapped and the steerable chases the target at a wrong
     * position, which simulates a faulty navigation system of
     * the steerable.
     *
     * @param x     x coordinate of the steerable
     * @param y     y coordinate of the steerable
     * @param v     direction of the steerable
     * @param targetX    x coordinate of the target
     * @param targetY    y coordinate of the target
     */
    public void update(int x, int y, double v, int targetX, int targetY){
        this.x = x;
        this.y = y;
        int swap = 0; // a temporary variable for swapping target coordinates
        boolean isLeft = true;


        if (0 >= bug) { // time to set fault on
            if (BUG_FREQUENCY*2 - 1 == (int)(Math.random() * (BUG_FREQUENCY*2 - 1)) + 1) {
                bug = BUG_FREQUENCY;
            }
        }
        else { // swap target coordinates
            bug--;
            swap = targetX;
            targetX = targetY;
            targetY = swap;
        }
        /**
         * Is the target on the left side of this steerable?
         * For greater precision doubles are used
         * decreases with every call to update().
         * Use a cross product of the vector and
         * the vector pointing to the target.
         * The cross product is positive if target on left.
         * The root of the vector of this steerable is at ax, ay
         * The arrow head of the vector of this steerable is at bx, by
         */
        double ax = this.x;
        double ay = this.y;
        double bx = ax + 100 * Math.cos(this.v); //second point for vector ab
        double by = ay + 100 * Math.sin(this.v);
        isLeft = ((bx-ax)*(targetY-ay) - (by-ay)*(targetX-ax)) < 0;
        boolean isOnTarget = true;;
        double temp;
        /**
         * Calculate the angle between ab and ac using the cosine law.
         * Since c^2 = a^2 + b^2 -2ab*cos angle
         * Therefore angle = cos-1 (a^2 + b^2 - c^2)/(-2ab)
         */
        double ab = Math.sqrt((bx - ax)*(bx - ax) + (by - ay)*(by - ay));
        double ac = Math.sqrt((targetX - ax)*(targetX - ax) + (targetY - ay)*(targetY - ay));
        double bc = Math.sqrt((targetX - bx)*(targetX - bx) + (targetY - by)*(targetY - by));
        temp = Math.acos((ab*ab + ac*ac - bc*bc)/((1)*(2*ab*ac)));
        /**
         * Is there a need to adjust the direction?
         * Note that Math.PI/80 = 2.25 degrees
         */
        isOnTarget = Math.abs(temp) < ANGLE;
        /**
         * Calculate the new value for direction vector
         */
        if(!isOnTarget){
            if(isLeft){
                this.v -= ANGLE;
            }
            else {
                this.v += ANGLE;
            }
        }
        /**
         * variable delta indicates the increment and will affect the speed
         */
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
