/*
 * [class still under development]
 */

import java.util.ArrayList;

public class StatManager {
    private ArrayList<Stat> customize_stat = new ArrayList<>();
    private ArrayList<Stat> default_stat = new ArrayList<>();
    private int skill_points;


    public StatManager(int skill_points){
        this.skill_points = skill_points;
    }

    public int getSkill_points() {
        return skill_points;
    }

    public ArrayList<Stat> getCustomize_stat() {
        return customize_stat;
    }

    public ArrayList<Stat> getDefault_stat() {
        return default_stat;
    }

    public void addCustomStat(String name, String description, int number, int lower_limit, int upper_limit) {
        int points = Math.min(number, skill_points);
        Stat new_stat = new Stat(name, description, points, lower_limit, upper_limit);
        skill_points -= points;
        customize_stat.add(new_stat);
    }

    public void addDefaultStat(String name, String description, int number){
        Stat new_stat = new Stat(name, description, number);
        default_stat.add(new_stat);
    }

    public int searchStat(String name){
        if (customize_stat.isEmpty()){
            return -1;
        }
        int value = -1;
        for (Stat stat : customize_stat){
            if (stat.getName().equals(name)){
                value = stat.getNumber();
            }
        }
        return value;
    }

    public ArrayList<Stat> merge(){
        ArrayList<Stat> merging = new ArrayList<>(customize_stat);
        merging.addAll(default_stat);
        return merging;

    }

}

