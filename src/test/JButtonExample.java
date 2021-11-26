import javax.swing.*;

public class JButtonExample {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Button Example");

        JButton bStart =new JButton("Start");
        JButton bInfo =new JButton("Info");
        JButton bExit =new JButton("Exit");

        bStart.setBounds(50,100,95,30);
        jFrame.add(bStart);
        jFrame.setSize(400,400);
        jFrame.setLayout(null);
        jFrame.setVisible(true);
    }
}
