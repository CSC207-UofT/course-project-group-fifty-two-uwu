import java.util.HashMap;

public interface Item {

    String getName();
    String getDescription();
    int getQuantity();
    HashMap<String, Integer> use();
    void changeQuantity(int number);

}
