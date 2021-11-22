package main.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductGetUserName extends JPanel{
    //This class is of type JPanel so that they can be added to JFrame
    //and displayed. This is the JPanel for the screen asking for username. This product class uses JTextField.
    JTextField jTextField = new JTextField(20);
    String jTextFieldEvent = "";
    // File pathNameStart = new File("src/main/resources/iconStart.png");
    boolean found = true;

    public ProductGetUserName(){
        jTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.out.println("The entered text is: " + jTextField.getText());
                jTextFieldEvent = jTextField.getText();
            }
        });
        jTextField.setText("Enter your name");
    }

    public String getEvent(){
        return this.jTextFieldEvent;
    }
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
    }
}
