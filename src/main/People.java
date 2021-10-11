import java.util.ArrayList;

public interface People {
    String getName();
    ArrayList<Stat> getStats();
    ArrayList<String> printStats();
    int value(String name);
    void change(String name, int new_value);
}
