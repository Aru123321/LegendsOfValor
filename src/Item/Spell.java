package Item;
public class Spell implements Item, Consumable{
    private String name;
    private int level;
    private int cost;
    private int manaCost;
    private int damage;
    private String spellType;

    private int useTime;
    Spell(String type, String n, int c, int l, int d, int m){
        name = n;
        cost =c;
        level = l;
        damage = d;
        manaCost = m;
        spellType = type;
        useTime = 3;
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
    public int getManaCost() {
        return manaCost;
    }

    public int getRestUseTime() {
        return useTime;
    }
    @Override
    public String toString() {
        return String.format("%-20s %-20s %-10s %-10s %-10s %-10s\n", spellType, name, cost, level, damage, manaCost);
    }

    @Override
    public void consume() {
        useTime--;
    }


}
