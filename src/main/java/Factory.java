package main.java;

import javax.swing.*;

public abstract class Factory {
    Factory(){}
    public abstract JPanel getProduct(int x, int y, double v);
}
