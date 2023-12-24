package Item;
public class Weaponry implements Item, Consumable{
    private String name;
    private int level;
    private int cost;
    private int damage;
    private int requiredHands;
    private String Type;
    private boolean twoHandIncrease = false;
    Weaponry(String type, String n, int c, int l, int d, int r){
        name = n;
        cost =c;
        level = l;
        damage = d;
        requiredHands = r;
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


    public int getDamage() {
        return damage;
    }
    public int getRequiredHands() {
        return requiredHands;
    }

    @Override
    public String toString() {
        return String.format("%-20s %-20s %-10s %-10s %-10s %-10s\n", Type, name, cost, level, damage, requiredHands);
    }


    @Override
    public void consume() {
        // Weaponry do not have consume requirement
    }
}
