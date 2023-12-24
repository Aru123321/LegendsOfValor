package Cell;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import InputAndReader.InputValidator;

import Character.Hero;
import Item.Armor;
import Item.Spell;

import Item.Potions;

import Item.Item;
import Item.itemFactory;
import Item.Weaponry;


import Party.Party;



public class Market extends itemFactory{
    InputValidator inputValidator = new InputValidator();
    boolean continueShopping = true;



    private ArrayList<Weaponry> WeaponsList;
    private ArrayList<Armor> ArmorList ;
    private ArrayList<Potions> PotionsList;
    private ArrayList<Spell> SpellsList;
    private String Weapontitle = String.format("  %-20s  %-20s %-10s %-10s %-10s %-10s\n",
            "Type","Name", "cost","required level","damage", "required hands");
    private String Armortitle = String.format("  %-20s  %-20s %-10s %-10s %-10s\n",
            "Type","Name", "cost","required level","damage reduction");

    private String Potionstitle = String.format("  %-20s  %-20s %-10s %-10s %-10s %-10s\n",
            "Type","Name", "cost","required level","attribute increase","attribute affected");

    private String Spelltitle = String.format("   %-20s %-20s %-10s %-10s %-10s %-10s\n",
            "Type","Name", "cost","required level","damage","mana cost");
    private String Weapontype = "Weapons:";

    private String Armortype = "Armor:";

    private String Potionstype = "Potions:";

    private String Spelltype = "Spell:";

    private ArrayList<Weaponry> itemWeaponsList;
    private ArrayList<Armor> itemArmorList ;
    private ArrayList<Potions> itemPotionsList;
    private ArrayList<Spell> itemSpellsList;
    boolean firstEnter = true;
    int WeaponsSize;
    int SpellSize;
    int ArmorsSize;
    int PotionSize;
    private itemFactory ifactory;

    Market() throws FileNotFoundException {
        ifactory = new itemFactory();
        ifactory.initialList();
        WeaponsList = ifactory.getWeaponry();
        ArmorList = ifactory.getArmor();
        PotionsList = ifactory.getPotions();
        SpellsList = ifactory.getSpell();

    }



    public void setUniqueItems() {

        WeaponsSize = WeaponsList.size() / 2;
        SpellSize = SpellsList.size() / 2;
        ArmorsSize = ArmorList.size() / 2;
        PotionSize = PotionsList.size() / 2;

        Collections.shuffle(WeaponsList); // Randomize the order
        for (int i = 0; i < WeaponsSize; i++) {
            WeaponsList.remove(WeaponsList.size() - 1); // Remove from the end to avoid shifting elements
        }
        Collections.shuffle(SpellsList); // Randomize the order
        for (int i = 0; i < SpellSize; i++) {
            SpellsList.remove(SpellsList.size() - 1); // Remove from the end to avoid shifting elements
        }
        Collections.shuffle(ArmorList); // Randomize the order
        for (int i = 0; i < ArmorsSize; i++) {
            ArmorList.remove(ArmorList.size() - 1); // Remove from the end to avoid shifting elements
        }
        Collections.shuffle(PotionsList); // Randomize the order
        for (int i = 0; i < PotionSize; i++) {
            PotionsList.remove(PotionsList.size() - 1); // Remove from the end to avoid shifting elements
        }

    }



    public void EnterMarket(Party p) {
        if(firstEnter){
            setUniqueItems();
            firstEnter= false;
        }

        continueShopping = true;

        while(continueShopping) {
            p.printPartySituation();
            System.out.println("Please enter the ID number of the hero you want who to enter the market: ");
            int idNum = inputValidator.promptPositiveInteger();
            while (idNum > p.size()) {
                System.out.println("Your enter is invalid. Please enter hero number: ");
                idNum = inputValidator.promptPositiveInteger();
            }
            Hero h = p.getHero(idNum - 1);
            actionMarket(h);
            System.out.println("Do you want to continue shopping: ");
            continueShopping = inputValidator.checkYesNoInput();
        }

    }
    public void actionMarket(Hero hero) {



        System.out.println(hero.getName()+" is in the market, she/he can buy:  ");
        System.out.println("        1. Weapons");
        System.out.println("        2. Armors");
        System.out.println("        3. Potions");
        System.out.println("        4. Spells");
        System.out.println("She/he can sell:  ");
        System.out.println("        5. Weapons");
        System.out.println("        6. Armors");
        System.out.println("        7. Potions");
        System.out.println("        8. Spells");

        System.out.println("Enter [I] for hero info, [L] to leave the market, or choose an option from 1-8: ");
        int action = inputValidator.marketChecker("L");
        if (action == -1){
            System.out.println(hero.printSingleHero());
            action =9;
        }
        else if(action == -2){
            continueShopping = false;
        }

        while(action > 8){
            System.out.println("Enter [I] for hero info, [L] to leave the market, or choose an option from 1-8: ");
            action = inputValidator.marketChecker("L");
            if (action == -1){
                System.out.println(hero.printSingleHero());
                action =9;
            }
            else if(action == -2){
                continueShopping = false;
            }
        }
        if(action == 1){

            buyItem(Weapontitle,hero,WeaponsList, Weapontype);
        }else if (action == 2){
            buyItem(Armortitle,hero,ArmorList, Armortype);
        }else if (action == 3){
            buyItem(Potionstitle,hero,PotionsList, Potionstype);
        }else if (action == 4){
            buyItem(Spelltitle,hero,SpellsList, Spelltype);
        }
        else if(action == 5){
            sellWeapons(hero);
        }else if (action == 6){
            sellArmors(hero);
        }else if (action == 7){
            sellPotions(hero);
        }else if (action == 8){
            sellSpells(hero);
        }


    }

    public void sellArmors(Hero hero){
        String type = "Armors";
        if(canSell(hero,type)){
            Item item = hero.sell(type);
            ArmorList.add((Armor)item);
        }

    }
    public void sellPotions(Hero hero){
        String type = "Potions";
        if(canSell(hero,type)){
            Item item = hero.sell(type);
            PotionsList.add((Potions)item);
        }

    }
    public void sellWeapons(Hero hero){
        String type = "Weapons";
        if(canSell(hero,type)){
            Item item = hero.sell(type);
            WeaponsList.add((Weaponry)item);
        }

    }
    public void sellSpells(Hero hero){
        String type = "Spells";
        if(canSell(hero,type)){
            Item item = hero.sell(type);
            SpellsList.add((Spell)item);
        }

    }

    public boolean canSell(Hero hero, String type){
        if(type.equals("Weapons")){
            List<Item> lp = hero.getWeaponryInventory();
            return lp.size() > 0;
        }else if(type.equals("Armors")){
            List<Item> lp = hero.getArmorInventory();
            return lp.size() > 0;
        }else if(type.equals("Potions")){
            List<Item> lp = hero.getPotionsInventory();
            return lp.size() > 0;
        }else if(type.equals("Spells")){
            List<Item> lp = hero.getSpellInventory();
            return lp.size() > 0;
        }
        System.out.println("You do not have any "+type+" to sell.");
        return false;
    }



    public void buyItem(String title,Hero hero, ArrayList<? extends Item> list, String type){


        printItemList(type, title, list);
        int size = list.size();
        System.out.println("Enter [I] for hero info, [X] to change your mind if you don't want to buy anything, or select an option number: ");
        int idnum = inputValidator.marketChecker("X");
        if (idnum == -1){
            System.out.println(hero.printSingleHero());
            idnum =9;
        }

        while(idnum > size){
            System.out.println("Enter [I] for hero info, [X] to change your mind if you don't want to buy anything, or select an option  number: ");
            idnum = inputValidator.marketChecker("X");
            if (idnum == -1){
                System.out.println(hero.printSingleHero());
                idnum =9;
            }
        }
        if(idnum != -2){
            Item item = list.get(idnum-1);
            if(canBuy(hero,item)){
                hero.buy(item.getCost(),item);
                list.remove(idnum-1);
            }
        }

    }

    public boolean canBuy(Hero hero, Item item){
        int itemCost = item.getCost();
        int itemLevel = item.getLevel();
        if( hero.getMoney()>= itemCost && hero.getLevel() >= itemLevel){
            return true;
        }
        System.out.println("You cannot purchase this item because your level is too low or you do not have enough money.");
        return false;
    }

    public void heroEnterMarket(Hero h) {

        continueShopping = true;


        while(continueShopping) {
            String title = String.format("   %-20s %-10s %-10s %-10s %-10s %-10s %-10s %-13s %-13s\n",
                    "Name", "HP", "Level", "Mana", "Strength", "Agility", "Dexterity", "Money", "Experience");
            System.out.println(title);
            System.out.println(h.toString());
            System.out.println("Please enter the ID number of the hero you want who to enter the market: ");

            actionMarket(h);
            System.out.println("Do you want to continue shopping [Y/N]: ");
            continueShopping = inputValidator.checkYesNoInput();
        }

    }
}
