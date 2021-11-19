package main.java;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;

public class GameLogic implements Iterable{
    private ArrayList<JPanel> jPanels = new ArrayList<>();
    private ArrayList<Boolean> booleans = new ArrayList<>();

    public GameLogic(){
        jPanels.add(new ProductContinueExit());
        booleans.add(true);
        jPanels.add(new ProductTimer());
        booleans.add(true);
        jPanels.add(new ProductP());
        booleans.add(true);
        jPanels.add(new ProductA());
        booleans.add(true);
        jPanels.add(new ProductB(-20, -20));
        booleans.add(true);
        jPanels.add(new ProductB(-200, -300));
        booleans.add(true);
    }

    public void update(int gameState){
        if (gameState == 5){
            setAllFalse();
            setItemTrue(0);
        }
        else if (gameState == 0){
            setAllFalse();
            setItemTrue(1);
            setItemTrue(2);
            setItemTrue(3);
            setItemTrue(4);
            setItemTrue(5);
            // System.out.println("GameLogic gameState = " + gameState);
        }
        else if (gameState == 1){

        }
        else if (gameState == 9){
        }
//        ProductTimer productTimer;
//        productTimer = (ProductTimer) getJPanel(1);
//        productTimer.update("ghjjhgghkhgghjk");
        // this.mainFrame.hasFocus();
    }
    // Helper deactivate all products
    private void setAllFalse(){
        for (int i = 0; i < this.booleans.size(); i++){
            this.booleans.set(i, false);
        }
    }

    // Helper make a product active
    private void setItemTrue(int idx){
        this.booleans.set(idx, true);
    }

    // return the first true index for a given index
    private int getTrueNext(int idx){
        if (!this.booleans.isEmpty()) {
            for (int i = idx + 1; i < this.booleans.size(); i++) {
                if (this.booleans.get(i)) {
                    return i;
                }
            }
        }
        return -1;
    }

    private JPanel getJPanel(int idx){
        return this.jPanels.get(idx);
    }


    @Override
    public Iterator<JPanel> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<JPanel>{
        private int current = -1;

        @Override
        public boolean hasNext() {
            current = getTrueNext(current);
            return current >= 0;
        }

        @Override
        public JPanel next() {
            return getJPanel(current);
        }
    }

    public static void main(String[] args) {
        GameLogic gl = new GameLogic();
        Iterator<JPanel> it = gl.iterator();
        JPanel item;

        System.out.print("[");
        while (it.hasNext()){
            item = it.next();
            System.out.print(" x ");
        }
        System.out.println("]");

        System.out.print("[");
        while (it.hasNext()){
            item = it.next();
            System.out.print(" y ");
        }
        System.out.println("]");

        System.out.print("[");
        while (it.hasNext()){
            item = it.next();
            System.out.print(" z ");
        }
        System.out.println("]");

    }
}