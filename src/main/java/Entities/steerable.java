package main.java.Entities;

/**
 * @author Terry
 * @version 1
 * @since November 30, 2021
 */
public interface steerable {
    public void update(int positionX, int positionY, double direction, int targetX, int targetY);
    public int getX();
    public int getY();
    public double getV();
}
