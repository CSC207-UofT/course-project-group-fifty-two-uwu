package main.java.Entities;

/**
 * @author Terry
 * @version 1
 * @since November 30, 2021
 */
public interface Steerable {
    void update(int positionX, int positionY, double direction, int targetX, int targetY);

    int getX();

    int getY();

    double getV();
}
