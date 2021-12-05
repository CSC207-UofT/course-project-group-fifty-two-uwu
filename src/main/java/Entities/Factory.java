package main.java.Entities;

import javax.swing.*;

/**
 * The abstract factory class that every factory class extends.
 */
public abstract class Factory {

    Factory(){}
    public abstract JPanel getProduct(int x, int y, double v, String s);
}
