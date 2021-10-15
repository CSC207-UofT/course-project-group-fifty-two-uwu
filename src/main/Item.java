import java.util.HashMap;
/* This is the class representing a category of Item that will be consumed upon using.
 * Consumable will have effects on Stat.
 */

abstract class Item {
    private final String name;
    private final String description;
    private int quantity = 1;

    /**
     * Construct an Item, giving its name and description.
     * A new Item has the default quantity of 1.
     *
     * @param name        Item's name that will be used throughout the game
     * @param description The description of this Item
     */
    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * Construct an Item, giving its name and description and its quantity.
     *
     * @param name        Item's name that will be using throughout the game
     * @param description The description of this Item
     * @param quantity    The quantity of this Consumable
     */
    public Item(String name, String description, int quantity) {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
    }

    /*
     * The getter helper methods, returning the corresponding data.
     */
    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return description;
    }

    public int getQuantity() {
        return quantity;
    }

    /*
     * Change this.quantity of this Item.
     * Item's quantity can't go below to 0 and will be rounded to 0 if it does.
     */
    public void changeQuantity(int number) {
        quantity += number;
        if (quantity < 0) {
            quantity = 0;
        }
    }

    /*
     * Use this Consumable.
     * Return a HashMap of its effect.(general Consumable has no effect)
     */
    abstract HashMap<String, Integer> use();

}