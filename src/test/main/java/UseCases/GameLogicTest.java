package main.java.UseCases;

import junit.framework.TestCase;

import javax.swing.*;
import java.util.Iterator;

public class GameLogicTest extends TestCase {

    public void testUpdate() {
    }

    public void testSetUserName() {
    }

    public void testIterator() {
        GameLogic gl = new GameLogic();
        Iterator<JPanel> it = gl.iterator();
        JPanel item;
        int count = 0;
        int nextCount = 0;

        while (it.hasNext()){
            item = it.next();
            count++;
        }

        while (it.hasNext()){
            item = it.next();
            nextCount++;
        }

        /**
         * The iterator should have the same number of items
         * independent of whether it is a first or next run.
         */
        assertEquals(count, nextCount);

    }

    public void testMain() {
    }
}