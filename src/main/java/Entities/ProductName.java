package main.java.Entities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductName extends JPanel{
    private TextField textField = new TextField();
    private JLabel jLabel = new JLabel();
    private String username = "";

    public ProductName(){
        this.textField.setFont(new Font("SansSerif", Font.BOLD, 18));
        this.textField.setText("");
        this.textField.setBounds(200, 200, 240, 28);
        this.textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                        System.out.println("The entered text is: " + event.getActionCommand());
                        setUsername(event.getActionCommand());
                    }
                });
        jLabel.setFont(new Font("MS Song", Font.BOLD, 14));
        jLabel.setText("Enter your name | \u4f60\u7684\u540d\u5b57 " + this.username);
        jLabel.setBounds(202, 170, 240, 28);
        setLayout(null);
        add(textField);
        add(jLabel);
    }

    public void setUsername(String s){
        System.out.println("Product setUsername = " + s);
        this.username = s;
    }

    public String getUsername(){
        // System.out.println("Product getUsername = " + this.username);
        return this.username;
    }

    public JLabel getJLabel(){
        return this.jLabel;
    }

    public TextField getTextField(){
        return textField;
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
    }
}