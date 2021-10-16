/* This is the class representing a character of the game.
 */
import java.util.ArrayList;

abstract class Player{
    private final String name;
    private ArrayList<Stat> stats;

    /**
     * Construct a Player, giving its name and Stat.
     * A new player has the default empty inventory with the capacity of 20.
     *
     * @param name  Player's name that will be using throughout the game
     * @param stats The ArrayList of Stat to be assigned to this Player
     */
    public Player(String name, ArrayList<Stat> stats) {
        this.name = name;
        this.stats = stats;
    }

    /*
     * The getter helper methods, returning the corresponding data.
     */
    public String getName() {
        return name;
    }

    public ArrayList<Stat> getStats() {
        return stats;
    }

    /*
     * Returning the list of all the names of this.stats.
     */
    public ArrayList<String> printStats() {
        ArrayList<String> stat_names = new ArrayList<>();
        for (Stat stat : stats) {
            stat_names.add(stat.getName());
        }
        return stat_names;
    }

    /*
     * Returning the value of the Stat, given the name of the desired Stat.
     * If the given name is not found, return -1.
     *
     * @param name The String name of this Stat
     */
    public int value(String name) {
        for (Stat stat : stats) {
            if (stat.getName().equals(name)) {
                return stat.getNumber();
            }
        }
        return -1;
    }

    /*
     * Change the value of the Stat, given the name of the desired Stat.
     * If the given name is not found, the new value will not be assigned to any existing Stat.
     *
     * @param name The String name of this Stat
     * @param new_value The new_value to be applied to this Stat
     */
    public void change(String name, int new_value) {
        for (Stat stat : this.stats) {
            if (stat.getName().equals(name)) {
                stat.change(new_value);
            }
        }
    }

    public boolean addItem(Item item) {
        return false;
    }
}

