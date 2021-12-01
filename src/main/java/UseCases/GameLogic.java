package main.java.UseCases;

import main.java.Entities.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;

public class GameLogic implements Iterable<JPanel>{
    //This is where the user cases are implemented. It creates a list
    //of JPanels for painting and a list of the same size with boolean values. The
    //second list indicates which components are to be painted for a given game
    //stage. It implements the Iterator Design Pattern and its iterator can
    //be used elsewhere in code to easy scan all components that can be painted
    private final ArrayList<JPanel> jPanels = new ArrayList<>();
    private final ArrayList<Boolean> booleans = new ArrayList<>();
    private String username = "";
    private boolean gamePaused = false;
    private final int PANEL_GAME_OVER = 3;

    private final int STATE_IN_PROGRESS = 0;
    private final int STATE_GAME_START = 5;
    private final int STATE_GAME_PAUSE = 6;
    private final int STATE_USER_NAME = 7;
    private final int STATE_GAME_OVER = 8;
    private final int STATE_EXIT = 9;

    private final String PATH_REGULAR = "regular";
    private final String PATH_FAULTY = "faulty";

    public GameLogic(){
        jPanels.add(new ProductTimer());
        jPanels.add(new ProductHitCounter());
        jPanels.add(new ProductP());
        jPanels.add(new ProductGameOver());
        FactoryB factoryB = new FactoryB();
        FactorySputnik factorySputnik = new FactorySputnik();
        jPanels.add(factorySputnik.getProduct(10, 10, Math.PI/5, PATH_REGULAR));
        jPanels.add(factorySputnik.getProduct(-50, 800, Math.PI/5, PATH_REGULAR));
        jPanels.add(factoryB.getProduct(200, 100, Math.PI/5, PATH_FAULTY));
        jPanels.add(factoryB.getProduct(-1000, 1000, Math.PI/5, PATH_FAULTY));
        jPanels.add(factoryB.getProduct(1000, -1000, Math.PI/5, PATH_REGULAR));
        for (int i = 0; i < jPanels.size(); i++){
            booleans.add(true);
        }
    }

    public void update(int gameState){
        // System.out.println("GameLogic gameState = " + gameState);
        if (gameState == 0){
            setAllTrue();
            setItemFalse(PANEL_GAME_OVER);
        }
        else if (gameState == STATE_GAME_START){
            setAllFalse();
        }
        else if (gameState == STATE_USER_NAME){
            setAllFalse();
        }
        else if (gameState == STATE_GAME_OVER){
            System.out.println("GameLogic state = " + STATE_GAME_OVER);
            setAllFalse();
            setItemTrue(PANEL_GAME_OVER);
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