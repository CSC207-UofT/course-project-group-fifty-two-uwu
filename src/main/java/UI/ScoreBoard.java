package main.java.UI;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ScoreBoard {

    public void addScore(String name, int score) {
        try {
            FileWriter fileWriter = new FileWriter("scores.txt");
            fileWriter.write(name + " " + 10);
            fileWriter.close();
            System.out.println("Successfully updated scores.txt");
        } catch (IOException e) {
            System.out.println("Error occurred while writing to scores.txt");
            e.printStackTrace();
        }
    }

    public void getTopScores(){
        try {
            File file = new File("scores.txt");
            Scanner scanner = new Scanner(file);
            String text = "";
            while (scanner.hasNextLine()) {
                text = text + " " + scanner.nextLine();
            }
            scanner.close();
            System.out.println("ScoreBoard top scores = " + text);
        } catch (FileNotFoundException e) {
            System.out.println("Error occurred while reading scores.txt");
            e.printStackTrace();
        }
    }
}
