package main.java;

import javax.swing.*;
import java.awt.event.*;

public class Console implements KeyListener, ActionListener, MouseMotionListener {
    private int keyPressed;
    private JFrame jFrame;

    public Console(JFrame jFrame){
        this.jFrame = jFrame;
        jFrame.addKeyListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 27){   //this is the code for the escape key
            System.out.println("ESC pressed");
        }
        this.keyPressed = e.getKeyCode();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    public int getKeyPressed(){
        int temp = this.keyPressed;
        this.keyPressed = 0;
        return temp;
    }
}
