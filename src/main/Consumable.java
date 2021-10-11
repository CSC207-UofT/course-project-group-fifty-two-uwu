/* This is the class representing a category of Item that will be consumed upon using.
 * Consumable will have effects on Stat.
 */
import java.util.HashMap;

public class Consumable implements Item{
    private final String name;
    private final String description;
    private int quantity = 1;

    /**
     * Construct a Consumable, giving its name and description.
     * A new Consumable has the default quantity of 1.
     *
     * @param name Consumable's name that will be using throughout the game
     * @param description The ArrayList of Stat to be assigned to this Consumable
     */
    public Consumable(String name, String description){
        this.name = name;
        this.description = description;
    }

    /**
     * Construct a Consumable, giving its name and description and its quantity.
     *
     * @param name Consumable's name that will be using throughout the game
     * @param description The ArrayList of Stat to be assigned to this Consumable
     * @param quantity The quantity of this Consumable
     */
    public Consumable(String name, String description, int quantity){
        this.name = name;
        this.description = description;
        this.quantity = quantity;
    }

    /*
     * The getter helper methods, returning the corresponding data.
     */
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    /*
     * Change this.quantity of this Consumable.
     * Consumable's quantity can't go below to 0 and will be rounded to 0 if it does.
     */
    public void changeQuantity(int number){
        quantity += number;
        if (quantity < 0){
            quantity = 0;
        }
    }

    /*
     * Use this Consumable.
     * Return a HashMap of its effect.(general Consumable has no effect)
     */
    @Override
    public HashMap<String, Integer> use() {
        HashMap<String, Integer> result = new HashMap<>();
        result.put("", 0);
        return result;
    }
}
