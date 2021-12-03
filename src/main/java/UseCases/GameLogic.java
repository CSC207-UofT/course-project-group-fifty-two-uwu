package main.java.UseCases;

import main.java.Entities.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Yan Nowaczek yan.nowaczek@mail.utoronto.ca
 * @version 12 lat update December 2, 2021
 * @since November 9, 2021
 */
public class GameLogic implements Iterable<JPanel>{
    /**
     * Creates a list of JPanels to be added to JFrame and displayed.
     * <p>
     * Creates two array lists: one for JPanels and one for Booleans.
     * The first list contains JPanels of three types:
     * 1 - objects that move on their own and cannot be controlled by user;
     * 2 - objects that the user can move around (to avoid missiles);
     * 3 - stationary objects to get input from the user.
     * The second list is of the same size and its boolean elements
     * indicate that the JPanel with the same index is active at a given
     * stage of the game.
     * Implements iterator that allows other parts of the program to
     * scan all active JPanels.
     */
    private final ArrayList<JPanel> jPanels = new ArrayList<>();
    private final ArrayList<Boolean> booleans = new ArrayList<>();
    private String username = ""; // username
    private boolean gamePaused = false;
    private final int STATE_GAME_PAUSE = 6;
    private final int STATE_EXIT = 9;

    /**
     * Adds JPanels to the array of JPanels.
     * Adds true to the array of Booleans (one for each JPanel).
     */
    public GameLogic(){
        jPanels.add(new Clock());
        jPanels.add(new HitCounter());
        jPanels.add(new Pilot());
        jPanels.add(new ScreenGameOver());
        jPanels.add(new ScreenInfo());
        jPanels.add(new ScreenName());
        jPanels.add(new ScreenMainMenu());

        FactoryMissile factoryMissile = new FactoryMissile();
        FactorySputnik factorySputnik = new FactorySputnik();
        // names of strategies or trajectories followed by moving objects
        String PATH_REGULAR = "regular";
        String PATH_FAULTY = "faulty";
        jPanels.add(factorySputnik.getProduct(10, 10, Math.PI/5, PATH_REGULAR));
        jPanels.add(factorySputnik.getProduct(-50, 800, Math.PI/5, PATH_REGULAR));
        jPanels.add(factoryMissile.getProduct(200, 100, Math.PI/5, PATH_FAULTY));
        jPanels.add(factoryMissile.getProduct(-1000, 1000, Math.PI/5, PATH_FAULTY));
        jPanels.add(factoryMissile.getProduct(1000, -1000, Math.PI/5, PATH_REGULAR));
        jPanels.add(new Background());
        for (int i = 0; i < jPanels.size(); i++){
            booleans.add(true);
        }
    }

    /**
     * Updates the array of Booleans to indicate which JPanels
     * are displayable in a given stage or state of the game.
     * @param gameState     integer indicating the state of the game
     */
    public void update(int gameState){
        int PANEL_GAME_OVER = 3;
        int PANEL_GAME_PAUSE = 4;
        int PANEL_GAME_NAME = 5;
        int PANEL_GAME_MENU = 6;
        // stages of the game
        int STATE_IN_PROGRESS = 0;
        int STATE_GAME_START = 5;
        int STATE_GAME_PAUSE = 6;
        int STATE_USER_NAME = 7;
        int STATE_GAME_OVER = 8;
        if (gameState == STATE_IN_PROGRESS){
            setAllTrue();
            setItemFalse(PANEL_GAME_PAUSE);
            setItemFalse(PANEL_GAME_OVER);
            setItemFalse(PANEL_GAME_NAME);
            setItemFalse(PANEL_GAME_MENU);
        }
        else if (gameState == STATE_GAME_START){
            setAllFalse();
            setItemTrue(PANEL_GAME_MENU);
        }
        else if (gameState == STATE_GAME_PAUSE){
            setAllFalse();
            setItemTrue(PANEL_GAME_PAUSE);
        }
        else if (gameState == STATE_USER_NAME){
            setAllFalse();
            setItemTrue(PANEL_GAME_NAME);
        }
        else if (gameState == STATE_GAME_OVER){
            setAllFalse();
            setItemTrue(PANEL_GAME_OVER);
        }
    }

    /**
     * Sets username
     * @param username  String username
     */
    public void setUserName(String username){this.username = username;}

    /**
     * This helper methods turns all JPanels on.
     */
    private void setAllTrue(){
        for (int i = 0; i < this.booleans.size(); i++){
            this.booleans.set(i, true);
        }
    }

    /**
     * This helper methods deactivates all JPanels
     */
    private void setAllFalse(){
        for (int i = 0; i < this.booleans.size(); i++){
            this.booleans.set(i, false);
        }
    }

    /**
     * Activates JPanel with given index
     * @param index     index in the array of Booleans
     */
    private void setItemTrue(int index){
        // System.out.println("setItemTrue for " + idx);
        this.booleans.set(index, true);
    }

    /**
     * Deactivates JPanel with the given index
     * @param index     index in the array of Booleans
     */
    private void setItemFalse(int index){
        this.booleans.set(index, false);
    }

    /**
     * Returns the index of the first item in the array of Booleans that
     * follows the item with the input index. If such item is not found
     * then it reuturns -1. If the array of Booleans is empty then returns -1.
     *
     * @param index     the input index
     * @return          the index of the next treu item
     */
    private int getTrueNext(int index){
        if (!this.booleans.isEmpty()) {
            for (int i = index + 1; i < this.booleans.size(); i++) {
                if (this.booleans.get(i)) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * Return the JPanel with given index from the array of JPanels.
     *
     * @param index     index of the JPanel to return
     * @return          JPanel of the given index
     */
    private JPanel getJPanel(int index){
        return this.jPanels.get(index);
    }


    /**
     * Return new object of type Iterator.
     * @return      Iterator<JPanel>
     */
    @Override
    public Iterator<JPanel> iterator() {
        return new Itr();
    }

    /**
     * This class implements Iterator.
     * Its two methods enable scanning of the list of JPanels
     * provided these JPanels are active.
     */
    private class Itr implements Iterator<JPanel>{
        /**
         * The value of current is always set to -1 at initialization
         * and when the last element has been return. It is set to -1
         * because the search for next starts at index current + 1 and
         * the first index in the array is 0.
         * It is important to set the current back to -1 when the last
         * element has been return because the interator may be used
         * more than once.
         */
        private int current = -1; // current is -1 at the start

        /**
         * Examines the index of the next item. If the next index is not -1
         * then that indicates that the next index exists.
         * @return      boolean that indicates that there is a next index
         */
        @Override
        public boolean hasNext() {
            current = getTrueNext(current);
            return current >= 0;
        }

        /**
         * Returns IPanel for the given index
         *
         * @return      JPanel from the array of JPanels
         */
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