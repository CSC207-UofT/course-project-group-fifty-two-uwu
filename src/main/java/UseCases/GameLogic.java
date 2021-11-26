package main.java.UseCases;

import main.java.Entities.FactoryB;
import main.java.Entities.ProductP;
import main.java.Entities.ProductTimer;
import main.java.Entities.ProductMainMenu;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;

public class GameLogic implements Iterable<JPanel>{
    //This is where the user cases are implemented. It creates a list
    //of JPanels for painting and a list of the same size with boolean values. The
    //second list indicates which components are to be painted for a given game
    //stage. It implements the Iterator Design Pattern and its iterator can
    //be used elsewhere in code to easy scan all components that can be painted
    private String event = "";
    private final ArrayList<JPanel> jPanels = new ArrayList<>();
    private final ArrayList<Boolean> booleans = new ArrayList<>();
    private JFrame jFrame;
    private String username = "";
    private boolean gamePaused = false;

    public GameLogic(JFrame jFrame){
        this.jFrame = jFrame;
//        ProductTestB productTestB = new ProductTestB();
        jPanels.add(new ProductMainMenu());
        jPanels.add(new ProductTimer());
        jPanels.add(new ProductP());
//        jPanels.add(new ProductA());
        FactoryB factoryB = new FactoryB();
        jPanels.add(factoryB.getProduct(200, 100, Math.PI/5));
        jPanels.add(factoryB.getProduct(-1000, 1000, Math.PI/5));
        jPanels.add(factoryB.getProduct(1000, -1000, Math.PI/5));
        for (int i = 0; i < jPanels.size(); i++){
            booleans.add(true);
        }
    }

    public void update(int gameState){
        // System.out.println("GameLogic gameState = " + gameState);
        if (gameState == 0){
            setAllTrue();
            setItemFalse(0);
        }
        else if (gameState == 5){
            setAllFalse();
            setItemTrue(0);
        }
        else if (gameState == 6){
            setAllFalse();
            setItemTrue(0);
        }
    }

    public void setUserName(String s){this.username = s;}

    // Helper to activate all products
    private void setAllTrue(){
        for (int i = 0; i < this.booleans.size(); i++){
            this.booleans.set(i, true);
        }
    }

    // Helper to deactivate all products
    private void setAllFalse(){
        for (int i = 0; i < this.booleans.size(); i++){
            this.booleans.set(i, false);
        }
    }

    // Helper make a product active
    private void setItemTrue(int idx){
        // System.out.println("setItemTrue for " + idx);
        this.booleans.set(idx, true);
    }

    // Helper make a product active
    private void setItemFalse(int idx){
        this.booleans.set(idx, false);
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
        JFrame jFrame = new JFrame();
        GameLogic gl = new GameLogic(jFrame);
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