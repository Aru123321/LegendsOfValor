package Item;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import InputAndReader.txtReader;

public class itemFactory implements itemFactoryCreator{
    private txtReader txt = new txtReader();


    private ArrayList<Weaponry> WeaponsList = new ArrayList<Weaponry>();
    private ArrayList<Armor> ArmorList = new ArrayList<Armor>();
    private ArrayList<Potions> PotionsList = new ArrayList<Potions>();
    private ArrayList<Spell> SpellsList = new ArrayList<Spell>();
    private ArrayList<String> threeSpellList = new ArrayList<>(Arrays.asList("FireSpells", "IceSpells", "LightningSpells"));

    public itemFactory(){
        WeaponsList = new ArrayList<Weaponry>();
        ArmorList = new ArrayList<Armor>();
        PotionsList = new ArrayList<Potions>();
        SpellsList = new ArrayList<Spell>();
    }

    public ArrayList<Weaponry> getWeaponry(){

        return WeaponsList;
    }

    public ArrayList<Armor> getArmor(){
        return ArmorList;
    }
    public ArrayList<Potions> getPotions(){
        return PotionsList;
    }
    public ArrayList<Spell> getSpell(){
        return SpellsList;
    }
    public Item createItem(String Line, String Type){

        String ItemStat[] = Line.split("\\s+");
        String name = ItemStat[0];


        if(Type.equals("Weaponry")){
            int cost = Integer.parseInt(ItemStat[1]);
            int required_level = Integer.parseInt(ItemStat[2]);
            int damage = Integer.parseInt(ItemStat[3]);
            int required_hands = Integer.parseInt(ItemStat[4]);
            return new Weaponry(Type,name, cost,required_level,damage, required_hands);
        }
        else if(Type.equals("Armory")){
            int cost = Integer.parseInt(ItemStat[1]);
            int required_level = Integer.parseInt(ItemStat[2]);
            int damage_reduction = Integer.parseInt(ItemStat[3]);

            return new Armor(Type,name,cost,required_level, damage_reduction);
        }
        else if(Type.equals("Potions")){
            int cost = Integer.parseInt(ItemStat[1]);
            int required_level = Integer.parseInt(ItemStat[2]);
            int attribute_increase = Integer.parseInt(ItemStat[3]);

            ArrayList<String> attribute_affected = new ArrayList<String>(Arrays.asList(ItemStat[4].split("/")));
            return new Potions(Type,name, cost,required_level,attribute_increase,attribute_affected);
        }
        else if(threeSpellList.contains(Type)){
            int cost = Integer.parseInt(ItemStat[1]);
            int required_level = Integer.parseInt(ItemStat[2]);
            int damage = Integer.parseInt(ItemStat[3]);
            int mana_cost = Integer.parseInt(ItemStat[4]);

            if(Type.equals("FireSpells")){
                return new FireSpell(Type, name,cost,required_level,damage,mana_cost);
            }
            else if(Type.equals("IceSpells")){
                return new IceSpell(Type, name,cost,required_level,damage,mana_cost);
            }
            else if(Type.equals("LightningSpells")){
                return new LightningSpell(Type, name,cost,required_level,damage,mana_cost);
            }

        }
        return null;
    }
    public Item getItem(Scanner sc, String type) {
        if (sc.hasNext()) {
            String Line = sc.nextLine();
            return createItem(Line, type);
        } else {
            return null;
        }
    }
    public void initialList() throws FileNotFoundException {
        ArrayList<String> threeTypes = new ArrayList<>(Arrays.asList("Weaponry", "Armory", "Potions","FireSpells","IceSpells","LightningSpells"));
        txtReader reader = new txtReader();

        for (int i = 0; i < threeTypes.size(); i++) {
            String type = threeTypes.get(i);
            Scanner sc = reader.openFile(type + ".txt");
            while (sc.hasNext()) {
                Item item = getItem(sc, type);
                if(item == null) {
                    break;
                }
                if(i == 0){
                    WeaponsList.add((Weaponry)item);
                }
                if(i == 1){
                    ArmorList.add((Armor)item);
                }
                if(i == 2){
                    PotionsList.add((Potions)item);
                }
                if(i == 3){
                    SpellsList.add((Spell)item);
                }
                if(i == 4){
                    SpellsList.add((Spell)item);
                }
                if(i == 5){
                    SpellsList.add((Spell)item);
                }
            }
            sc.close();
        }

    }
    public void showWeaponsList() throws FileNotFoundException {
        initialList();

        // Title format string used by all hero types


        System.out.println("List of Items:\n");
        String title = String.format("  %-20s  %-20s %-10s %-10s %-10s %-10s\n",
                "Type","Name", "cost","required level","damage", "required hands");
        printItemList("Weapons:", title, WeaponsList);
        title = String.format("  %-20s  %-20s %-10s %-10s %-10s\n",
                "Type","Name", "cost","required level","damage reduction");
        printItemList("Armor:", title, ArmorList);
        title = String.format("  %-20s  %-20s %-10s %-10s %-10s %-10s\n",
                "Type","Name", "cost","required level","attribute increase","attribute affected");
        printItemList("Potions:", title, PotionsList);
        title = String.format("   %-20s %-20s %-10s %-10s %-10s %-10s\n",
                "Type","Name", "cost","required level","damage","mana cost");
        printItemList("Spells:", title, SpellsList);
    }
    public void printItemList(String TypeName, String title, ArrayList<? extends Item> List) {
        System.out.println(TypeName);
        System.out.println(title);
        int number = 1;
        for (Item item : List) {
            System.out.println(number + ". " + item.toString());
            number++;
        }
        System.out.println();
    }



}
