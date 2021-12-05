package main.java.Entities;

/**
 * @author Terry
 * @version 1
 * @since November 30, 2021
 */
public class PathFall implements Steerable {
    private int x; // x coordinate
    private int y; // y coordinate
    private double v; // direction vector in gradients
    private final int DELTA = 3; // increment per single update
    private final double ANGLE = Math.PI / 90; // Math.PI /80 = 2.25 degrees

    /**
     * Updates coordinates and direction of this steerable
     * <p>
     * The method calculates the new position with constant direction;
     * If the x coordinate is outside [0, 700] or
     * the y coordinate is outside [0, 600] then a new x coordinate
     * is generated at random and the steerable is placed on a line
     * y < 0. The new direction is towards the current target and will
     * not change. This simulates a falling object.
     *
     * @param x     x coordinate of the steerable
     * @param y     y coordinate of the steerable
     * @param v     direction of the steerable
     * @param targetX    x coordinate of the target
     * @param targetY    y coordinate of the target
     */
    public void update(int x, int y, double v, int targetX, int targetY) {
        this.x = x;
        this.y = y;
        this.v = v;
        if (!(this.x > -20 && this.x < 720 && this.y > -20 && this.y < 620)) {
            // System.out.println("Sputnik x = " + this.x + " y = " + this.y);
            this.x = -20 + (int) (Math.random() * ((740) + 1));
            this.y = -20;
            //
            //     (x, y)
            //     *
            //     * *
            //     *  *
            //     *   *
            //     ******
            //            (targetX, targetY)
            //
            double hypotenuse = (this.y - targetY) * (this.y - targetY);
            hypotenuse = hypotenuse + ((this.x - targetX) * (this.x - targetX));
            hypotenuse = Math.sqrt(hypotenuse);
            this.v = Math.abs(this.y - targetY) / hypotenuse;
            // this.vector = 2* Math.PI - Math.asin(this.vector);
            if (this.x < targetX) {
                this.v = Math.asin(this.v);
            } else {
                this.v = Math.asin(this.v) + Math.PI / 2;
            }
            this.x += DELTA * Math.cos(this.v);
            this.y += DELTA * Math.sin(this.v);
            // System.out.println("Sputnik x = " + this.x + " y = " + this.y + " v = " + this.vector);
        } else {
            this.x += DELTA * Math.cos(this.v);
            this.y += DELTA * Math.sin(this.v);
        }
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
