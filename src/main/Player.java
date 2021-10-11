/* This is the class representing the actual player of the game.
 */
import java.util.ArrayList;
import java.util.HashMap;

public class Player implements People {
    private final String name;
    private ArrayList<Stat> stats;
    private ArrayList<Item> inventory = new ArrayList<>();
    private int capacity = 20;

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

    /**
     * Construct a Player, giving its name, Stat and the capacity.
     * A new player has the default empty inventory.
     *
     * @param name     Player's name that will be using throughout the game
     * @param stats    The ArrayList of Stat to be assigned to this Player
     * @param capacity The size in this Player's inventory ArrayList that is still available to add more Item
     */
    public Player(String name, ArrayList<Stat> stats, int capacity) {
        this.name = name;
        this.stats = stats;
        this.inventory = new ArrayList<>();
        this.capacity = capacity;
    }

    /*
     * The getter helper methods, returning the corresponding data.
     */
    @Override
    public String getName() {
        return name;
    }

    @Override
    public ArrayList<Stat> getStats() {
        return stats;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public int getCapacity() {
        return capacity;
    }

    /*
     * Returning the list of all the names of this.stats.
     */
    @Override
    public ArrayList<String> printStats() {
        ArrayList<String> stat_names = new ArrayList<>();
        for (Stat stat : stats) {
            stat_names.add(stat.getName());
        }
        return stat_names;
    }

    /*
     * Returning the list of all the names of this.inventory.
     */
    public ArrayList<String> printInventory() {
        ArrayList<String> item_names = new ArrayList<>();
        for (Item item : inventory) {
            item_names.add(item.getName());
        }
        return item_names;
    }

    /*
     * Returning the value of the Stat, given the name of the desired Stat.
     * If the given name is not found, return -1.
     *
     * @param name The String name of this Stat
     */
    @Override
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
    @Override
    public void change(String name, int new_value) {
        for (Stat stat : this.stats) {
            if (stat.getName().equals(name)) {
                stat.change(new_value);
            }
        }
    }

    /*
     * Add an Item to this.inventory.
     * Return true if the Item has been added, and false if the inventory is already full.
     *
     * @param name The Item to be added
     */
    public boolean addItem(Item item) {
        int quantity = item.getQuantity();
        if (capacity < quantity) {
            return false;
        }
        inventory.add(item);
        capacity -= quantity;
        return true;
    }

    /*
     * Remove an Item from this.inventory.
     * Return true if the Item has been removed, and false if inventory has no such Item.
     * If the Item has a greater quantity than 1, only remove 1 copy of the Item.
     *
     * @param name The String name of this Item
     */
    public boolean removeItem(String name) {
        ArrayList<String> item_names = this.printInventory();
        if (!item_names.contains(name)) {
            return false;
        }
        Item removing = null;
        for (Item item : inventory) {
            if (item.getName().equals(name)) {
                item.changeQuantity(-1);
                removing = item;
            }
        }
        if (removing != null) {
            if (removing.getQuantity() == 0) {
                inventory.remove(removing);
            }
        }
        capacity += 1;
        return true;
    }

    /*
     * Use an Item from this.inventory.
     * Used Item will also use removeItem to remove itself.
     *
     * @param name The String name of this Item
     */
    public void use(String item_name) {
        if (inventory.isEmpty()) {
            return;
        }
        HashMap<String, Integer> using = null;
        Item removing = null;
        for (Item item : inventory) {
            if (item_name.equals(item.getName())) {
                using = item.use();
                removing = item;
                capacity += 1;
            }
        }
        if (using == null) {
            return;
        }
        if (removing.getQuantity() == 0) {
            inventory.remove(removing);
        }
        for (String stat : using.keySet()) {
            this.change(stat, using.get(stat));
        }
    }
}

