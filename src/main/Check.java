/* This is the class representing the check of the game.
 */
import java.util.Random;


public class Check {
    private final int requirement;
    private final String target;
    private int consequence = 0;
    private String result = "";
    private int dice;

    /**
     * Construct a Check, giving all its required inputs.
     *
     * @param requirement Check's requirement in order to pass a check
     * @param target The name of Stat to be checked against this check's requirement
     * @param consequence If the check fails, the amount of consequence will be applied to the stats
     * @param result The name of Stat that consequence will be applied
     * @param dice A random number (from 1 to dice) to be applied to fulfill the requirement
     */
    public Check(int requirement, String target, int consequence, String result, int dice){
        this.requirement = requirement;
        this.target = target;
        this.consequence = consequence;
        this.result = result;
        this.dice = dice;
    }

    /**
     * Construct a Check, and use the default inputs to construct a Check without any consequence.
     *
     * @param requirement Check's requirement in order to pass a check
     * @param target The name of Stat to be checked against this check's requirement
     * @param dice A random number (from 1 to dice) to be applied to fulfill the requirement
     */
    public Check(int requirement, String target, int dice){
        this.requirement = requirement;
        this.target = target;
        this.dice = dice;
    }

    /*
     * The getter helper methods, returning the corresponding data.
     */
    public int getDice(){
        return dice;
    }

    public int getRequirement(){
        return requirement;
    }

    /*
     * Check's main method to check a Player's Stat against Check's requirement.
     * Return true if the Stat is enough to pass this check abd false otherwise.
     *
     * @param character The target Player to be checked
     */
    public boolean check(Player character){
        Random random_dice = new Random();
        int roll = random_dice.nextInt(dice + 1);
        if (roll == 0){
            roll += 1;
        }
        int stat = character.value(target);
        int check_result = this.getRequirement() - (stat + roll);
        if (check_result < 0){
            return true;
        }
        this.resolve(character);
        return false;
    }

    /*
     * Resolve a check's consequence by applying changes on the desired Stat in Player.
     *
     * @param character The target Player to receive the change
     */
    public void resolve(Player character){
        character.change(result, consequence);
    }


}
