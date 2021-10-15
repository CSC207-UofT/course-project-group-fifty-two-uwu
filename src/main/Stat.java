/* This is a class representing the different attributes of the characters.
 * Stat is used primarily to perform checks.
 */
public class Stat {
    private final String name;
    private final String description;
    private int number = 0;
    private int lower_limit = 0;
    private int upper_limit = 100;

    /*
     * Construct a Stat, giving all its required parameters.
     * Stat's value could not exceed its limit.
     *
     * @param name Stat's name that will be using throughout the game
     * @param description Stat's description
     * @param number The value of this Stat
     * @param lower_limit The lower limit of this Stat's value
     * @param upper_limit The upper limit of this Stat's value
     */
    public Stat(String name, String description, int number, int lower_limit, int upper_limit){
        this.name = name;
        this.description = description;
        this.number = number;
        this.lower_limit = lower_limit;
        this.upper_limit = upper_limit;
        this.round();
    }

    /*
     * Construct a Stat, but only using its name, its description and its value.
     * Both the limits will use the defaults.
     * Stat's value could not exceed its limit.
     *
     * @param name Stat's name that will be using throughout the game
     * @param description Stat's description
     * @param number The value of this Stat
     */
    public Stat(String name, String description, int number){
        this.name = name;
        this.description = description;
        this.number = number;
        this.round();
    }


    /*
     * The getter helper methods, returning the corresponding data.
     */
    public int getNumber() {
        return number;
    }

    public String getDescription() {
        return description;
    }

    public String getName() { return name; }

    public int getLower_limit(){ return lower_limit; }

    public int getUpper_limit(){ return upper_limit; }

    /*
     * Examine Stat's value and round it to its limit if the value exceeds any of the limits.
     */
    public void round(){
        if (lower_limit < number){
            if (number > upper_limit){
                number = upper_limit;
            }
        }
        else if (number < upper_limit){
            if (number < lower_limit){
                number = lower_limit;
            }
        }
    }

    /*
     * Assign a new value for this.number.
     */
    public void assign(int new_value){
        number = new_value;
        this.round();
    }

    /*
     * Change the value of this.number.
     * If the result exceeds any of the limits, it will be rounded to the limit.
     *
     * @param changed The value to be applied to this.number.
     */
    public void change(int changed){
        int value = this.getNumber();
        this.assign(value + changed);
    }

    /*
     * Printing the details of this Stat.
     */
    @Override
    public String toString() {
        return "The current " + this.getName() + "is " + this.getNumber();
    }


}

