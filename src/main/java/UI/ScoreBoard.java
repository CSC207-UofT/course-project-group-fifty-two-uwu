package main.java.UI;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * @author Terry
 * @version 1
 * @since November 29, 2021
 */
public class ScoreBoard {

    /**
     * Stores this user's name and score in scores.txt
     * <p>
     * The method imports values from scores.txt into ArrayList of Tuples
     * using getTopScores().
     * It scans the list to check if this user already achieved a higher
     * score. If so, nothing remains to be done.
     * It adds the name and score and then sorts the array using
     * sortTupleList(t).
     * Finally, it overrides scores.txt with the new list.
     * Each tuple is stored in a single line as name:score.
     *
     * @param name a string generated by GameState
     * @param score an integer generated by GameState
     */
    public void addScore(String name, int score) {
        ArrayList<Tuple> tuples = new ArrayList<>();
        tuples = getTopScores();
        boolean isNotListed = true;

        for (int i = 0; i < tuples.size(); i++){
            if (tuples.get(i).getStr().equals(name)){
                if (tuples.get(i).getNum() > score){
                    return; // already has higher score
                }
                else {
                    tuples.get(i).setNum(score); // score updated
                    isNotListed = false;
                    break;
                }
            }
        }

        // test
        System.out.println("\ntuples A >>>>");
        for (int i = 0; i < tuples.size(); i++){
            System.out.println(tuples.get(i).getStr() + " " + tuples.get(i).getNum());
        }

        if (isNotListed) {
            tuples.add(new Tuple(name, score));
        }

        //test
        System.out.println("tuples B >>>>");
        for (int i = 0; i < tuples.size(); i++){
            System.out.println(tuples.get(i).getStr() + " " + tuples.get(i).getNum());
        }

        // sort
        tuples = sortTupleList(tuples);

        //test
        System.out.println("tuples C >>>>");
        for (int i = 0; i < tuples.size(); i++){
            System.out.println(tuples.get(i).getStr() + " " + tuples.get(i).getNum());
        }

        try {
            FileWriter fileWriter = new FileWriter("scores.txt", false);  //overrides file
            for (int i = 0; i < tuples.size(); i++){
                fileWriter.write(tuples.get(i).getStr() + ":" + tuples.get(i).getNum() + "\n");
            }
            fileWriter.close();
            // System.out.println("Successfully updated scores.txt");
        } catch (IOException e) {
            System.out.println("Error occurred while writing to scores.txt");
            e.printStackTrace();
        }
    }

    /**
     * Returns a list of tuples with names and scores from scores.txt.
     * <p>
     * It opens the text file and reads each line separately.
     * Each line is parsed based on the colon into an array of strings
     * A tuple is created and populated with the first string as the name
     * and the second string as an integer value.
     * Tuples are then added to the array and the array is returned.
     *
     * @return  an array list with tuples of names and scores.
     */
    public ArrayList<Tuple> getTopScores(){
        ArrayList<Tuple> tuples = new ArrayList<>();
        try {
            File file = new File("scores.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String[] tokens = scanner.nextLine().split(":");
                Tuple tuple = new Tuple(tokens[0], Integer.valueOf(tokens[1]));
                tuples.add(tuple);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error occurred while reading scores.txt");
            e.printStackTrace();
        }
        // System.out.println();
        return tuples;
    }

    public void addScoreOLD(String name, int score) {
        Map<String, Integer> map = new HashMap<>();
        map.put("Bob", 1);
        // this user already has a higher score
        if (map.containsKey(name) && map.get(name) >= score){
            return;
        }
        else {
            map.put(name, score);
            // sort the map by value
            System.out.println("before sort " + map);
            map = sortByValue(map);
            System.out.println("after sort  " + map);
        }
        try {
            FileWriter fileWriter = new FileWriter("scores.txt", false);  //overrides file
            for (String key : map.keySet()){
                fileWriter.write(key + ":" + map.get(key) + "\n");
            }
            fileWriter.close();
            // System.out.println("Successfully updated scores.txt");
        } catch (IOException e) {
            System.out.println("Error occurred while writing to scores.txt");
            e.printStackTrace();
        }
    }

    public Map<String, Integer> getTopScoresOLD(){
        Map<String, Integer> map = new HashMap<>();
        try {
            File file = new File("scores.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String[] tokens = scanner.nextLine().split(":");
                map.put(tokens[0], Integer.valueOf(tokens[1]));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error occurred while reading scores.txt");
            e.printStackTrace();
        }
        System.out.println(map);
        return map;
    }

    public  Map<String, Integer> sortByValue(Map<String, Integer> map){
        ArrayList<Tuple> tuples = new ArrayList<>();
        for (String key : map.keySet()) {
            System.out.println("for " + key);
            Tuple tuple = new Tuple(key, map.get(key));
            if (tuples.isEmpty()) {
                System.out.println("tuples are empty");
                tuples.add(tuple);
            }
            else {
                int idx = 0;
                for (int i = 0; i < tuples.size(); i++){
                    // System.out.println("i = " + i + "tuples.size() = " + tuples.size());
                    if (map.get(key) > tuples.get(i).getNum()){
                        tuples.add(i, tuple);
                        break;
                    }
                    else if (i == tuples.size()){
                        tuples.add(tuple);
                        break;
                    }
                }
            }
            System.out.println("tuples so far:");
            for (int i = 0; i < tuples.size(); i++){
                System.out.println("tuples[" + i + "] = " + tuples.get(i).getStr() + " " + tuples.get(i).getNum());
            }
        }
        map.clear();
        for (Tuple tuple : tuples) {
            map.put(tuple.getStr(), tuple.getNum());
        }
        return map;
    }

    /**
     * Returns an array list of tuples sorted by the second field
     * <p>
     * The input is a list of pairs, each pair consisting of a string
     * and an integer, representing a username and their top score.
     * Using double for loop and an empty array list called result,
     * it picks a tuple from the input array and inserts it into
     * the resulting array in front of the tuple with a lower score.
     * The resulting array is thus sorted from the highest to the lowest.
     * The algorithm adds the input tuple to the end of the resulting array
     * when a higher tuple cannot be found.
     *
     * @param tuples    an array list of tuples to be sorted by the second field
     * @return          an array list of tuples sorted in descending order
     */
    public ArrayList<Tuple> sortTupleList(ArrayList<Tuple> tuples){
        ArrayList<Tuple> result = new ArrayList<>();
        for (int i = 0; i < tuples.size(); i++){
            System.out.println("tuples i = " + i + " name = " + tuples.get(i).getStr() + " " + tuples.get(i).getNum());
            if (result.isEmpty()){
                result.add(tuples.get(i));
            }
            else {
                for (int j = 0; j < result.size(); j++){
                    System.out.println("result j = " + j + " name = " + result.get(j).getStr() + " " + result.get(j).getNum());
                    if (tuples.get(i).getNum() > result.get(j).getNum()){
                        System.out.println("greater");
                        result.add(j, tuples.get(i));
                        break;
                    }
                    else if (j == result.size() - 1){
                        System.out.println("at the tail");
                        result.add(tuples.get(i));
                        break;
                    }
                }
            }
            System.out.println("result so far: ");
            for (int k = 0; k < result.size(); k++){
                System.out.println("result[" + k + "] = " + result.get(k).getStr() + " " + result.get(k).getNum());
            }
        }
        return result;
    }

    /**
     * Creates an object with two elements: a string representing the name of
     * the user and an integer representing the user's score.
     */
    static class Tuple {
        String str;
        int num;
        public Tuple(String str, int num){
            this.str = str;
            this.num = num;
        }
        public String getStr(){return this.str;}
        public int getNum(){return this.num;}
        public void setStr(String str){this.str = str;}
        public void setNum(int num){this.num = num;}
    }

}
