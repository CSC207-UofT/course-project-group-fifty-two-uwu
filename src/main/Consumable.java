/* This is the class representing the consumable items of the game.
 */
import java.util.HashMap;

public class Consumable extends Item{

    /**
     * Construct a Consumable, giving its name and description.
     * A new Consumable has the default quantity of 1.
     *
     * @param name Consumable's name that will be using throughout the game
     * @param description The ArrayList of Stat to be assigned to this Consumable
     */
    public Consumable(String name, String description){
        super(name, description);
    }

    /**
     * Construct a Consumable, giving its name and description and its quantity.
     *
     * @param name Consumable's name that will be using throughout the game
     * @param description The ArrayList of Stat to be assigned to this Consumable
     * @param quantity The quantity of this Consumable
     */
    public Consumable(String name, String description, int quantity){
        super(name, description, quantity);
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
