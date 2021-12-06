package main.java.UI;

import main.java.Controller.GameParameters;
import main.java.Entities.*;
import main.java.Entities.ScreenGameOver;

import javax.swing.*;
import java.util.Iterator;

public class Canvas {
    private final JFrame jFrame;

    public Canvas(JFrame jFrame){
        this.jFrame = jFrame;
        this.jFrame.setVisible(true);
    }

    public void update(Iterator<JPanel> iterator){
        this.jFrame.getContentPane().removeAll();
        this.jFrame.getContentPane().revalidate();
        while (iterator.hasNext()){
            this.jFrame.getContentPane().add(iterator.next());
            this.jFrame.revalidate();
        }
        this.jFrame.repaint();
    }
}
