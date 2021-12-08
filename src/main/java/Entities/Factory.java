package main.java.Entities;

import javax.swing.*;

/**
 * The abstract factory class that every factory class extends.
 *
 * @author Yan Nowaczek yan.nowaczek@mail.utoronto.ca
 * @author Edward
 * @version A   never modified
 * @since 1.0   November 10, 2021
 */
public abstract class Factory {
  
  /** Other Factories are subclasses of this class and all
   * implement the method getProduct(), which is a JPanel
   * with x and y coordinates, a direction vector and
   * a strategy or trajectory that this object will follow.
   */
    Factory(){}
    public abstract JPanel getProduct(int x, int y, double v, String s);
}
