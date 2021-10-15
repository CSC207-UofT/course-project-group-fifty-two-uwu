/* An example Consumable item.
 * Reduces [Madness] upon its use.
 */
import java.util.HashMap;

public class Reminiscence extends Consumable{
    public Reminiscence() {
        super("Reminiscence", "Scraps of knowledge in time...Reduces the progression of Madness");
    }

    @Override
    public HashMap<String, Integer> use(){
        HashMap<String, Integer> result = new HashMap<>();
        super.changeQuantity(-1);
        result.put("Madness", -25);
        return result;
    }
}
