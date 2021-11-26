import main.java.Entities.*;

import javax.swing.*;

public class CanvasTest {
    private JFrame jFrame;

    public CanvasTest(JFrame jframe){
        this.jFrame = jframe;
    }

    public void upload(JPanel jPanel){
        this.jFrame.getContentPane().add((JPanel) jPanel);
    }
    public void paint(){
        this.jFrame.repaint();
        //this.jFrame.setLayout(null);
        //this.jFrame.getContentPane().setLayout(null);
        // this.jFrame.pack();

//        this.jFrame.getContentPane().removeAll();
//        this.jFrame.getContentPane().add((JPanel) jPanel);

        //this.jFrame.getContentPane().revalidate();
        //this.jFrame.setVisible(true);
        //this.jFrame.getContentPane().setVisible(true);
        //this.jFrame.getContentPane().repaint();
    }

    public static void main(String[] args) {
        final int CANVAS_WIDTH = 700;
        final int CANVAS_HEIGHT = 600;

        FactoryB factoryB = new FactoryB();
        JPanel productB = factoryB.getProduct(50, 50, Math.PI/5);
        //JPanel productContinueExit = new ProductContinueExit();
//        {
//            @Override
//            public Dimension getPreferredSize() {
//                return new Dimension(300, 300);
//            };
//        };
//        productContinueExit.setLayout(new FlowLayout(FlowLayout.CENTER));

        JPanel productTest = new ProductName();
//        {
//            @Override
//            public Dimension getPreferredSize() {
//                return new Dimension(300, 300);
//            };
//        };

        JPanel productTestB = new ProductMainMenu();
        ProductTimer productTimer = new ProductTimer();

        JFrame f = new JFrame("Tester for JPanels");
        f.setSize(CANVAS_WIDTH, CANVAS_HEIGHT);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        CanvasTest canvasTest = new CanvasTest(f);
        canvasTest.paint();
        // canvasTest.paint(productContinueExit);
        // canvasTest.paint(productTest);
        // canvasTest.paint(productTestB);
        // canvasTest.paint(productTimer);
        // productTimer.updateClockDisplay();
        // canvasTest.paint(productTimer);

        // loop


        canvasTest.upload(productB);
        boolean gameIsOver = false;
        long sleepTime = 10;
        long awakeTime = System.currentTimeMillis();
        while(!gameIsOver){
            while(System.currentTimeMillis() < awakeTime) {
                // do nothing
            }
            ((ProductB) productB).update(200, 200);
            canvasTest.paint();
            System.out.println("In system Test");
            awakeTime += sleepTime;
        }

    }
}
