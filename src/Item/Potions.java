package Item;
import java.util.ArrayList;


import Character.Hero;


public class Potions implements Item, Consumable{
    private String name;
    private int level;
    private int cost;
    private int attributeIncrease;
    private ArrayList<String> attributeAffected;
    private String spellType;
    private boolean isUsed;
    Potions(String type, String n, int c, int l, int i, ArrayList<String> a){
        isUsed = false;
        name = n;
        cost =c;
        level = l;
        attributeIncrease = i;
        attributeAffected = a;
        spellType = type;
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
    public ArrayList<String> getAttributeAffected() {
        return attributeAffected;
    }
    public int getAttributeIncrease() {
        return attributeIncrease;
    }


    @Override
    public String toString() {
        return String.format("%-20s %-20s %-10s %-10s %-10s %-10s\n", spellType, name, cost, level, attributeIncrease, attributeAffected);
    }




    public void usePotion(Hero h) {
        System.out.println(h.getName()+ " used a potion"+ getName());
        for(String attribute : attributeAffected){
            if(attribute.equals("Health")){
                h.heroAddHP(attributeIncrease);
            }
            else if(attribute.equals("Mana")){
                h.heroAddMana(attributeIncrease);
            }
            else if(attribute.equals("Strength")){
                h.heroAddStrength(attributeIncrease);
            }
            else if(attribute.equals("Dexterity")){
                h.heroAddDexterity(attributeIncrease);
            }
            else if(attribute.equals("Agility")){
                h.heroAddAgility(attributeIncrease);
            }
            else if(attribute.equals("Defense")){
                h.heroAddDefense(attributeIncrease);
            }
        }

        consume();



    }

    @Override
    public void consume() {
        isUsed=true;
    }


}
