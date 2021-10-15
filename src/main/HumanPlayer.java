/* This is the class representing the actual player of the game.
 * The actual player have its inventory to store items and its capacity to track the limit of inventory.
 */
import java.util.ArrayList;
import java.util.HashMap;

public class HumanPlayer extends Player {
    private ArrayList<Item> inventory = new ArrayList<>();
    private int capacity = 20;

    /**
     * Construct a Player, giving its name and Stat.
     * A new player has the default empty inventory with the capacity of 20.
     *
     * @param name  Player's name that will be using throughout the game
     * @param stats The ArrayList of Stat to be assigned to this Player
     */
    public HumanPlayer(String name, ArrayList<Stat> stats) {
        super(name, stats);
    }

    /**
     * Construct a Player, giving its name, Stat and the capacity.
     * A new player has the default empty inventory.
     *
     * @param name     Player's name that will be using throughout the game
     * @param stats    The ArrayList of Stat to be assigned to this Player
     * @param capacity The size in this Player's inventory ArrayList that is still available to add more Item
     */
    public HumanPlayer(String name, ArrayList<Stat> stats, int capacity) {
        super(name, stats);
        this.inventory = new ArrayList<>();
        this.capacity = capacity;
    }

    /*
     * The getter helper methods, returning the corresponding data.
     */

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public int getCapacity() {
        return capacity;
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

