package Item;

public class Armor implements Item, Consumable{
    private String name;
    private int level;
    private int cost;
    private int damage_reduction;
    private String Type;
    Armor(String type, String n, int c, int l, int d){

        name = n;
        cost =c;
        level = l;
        damage_reduction = d;
        Type = type;
    }
    public String getName() {
        return name;
    }
    public void setCost(int c) {
        cost = c;
    }

    public int getCost() {
        return cost;
    }
    public int getLevel() {
        return level;
    }

    public int getDefense() {
        return damage_reduction;
    }

    @Override
    public String toString() {
        return String.format("%-20s %-20s %-10s %-10s %-10s \n", Type, name, cost, level, damage_reduction);
    }


    @Override
    public void consume() {
        // Weaponry do not have consume requirement
    }
}
