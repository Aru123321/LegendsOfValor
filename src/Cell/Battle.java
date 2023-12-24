package Cell;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import InputAndReader.InputValidator;

import Character.Hero;
import Character.Monster;
import Character.MonsterFactory;

import Item.Spell;

import Item.Potions;

import Item.Item;

import Party.Party;


public class Battle { // this is battle class, the main method is start event
    private boolean battleEnd = false;
    private String Weaponstitle = String.format("  %-20s  %-20s %-10s %-10s %-10s %-10s\n",
            "Type", "Name", "cost", "required level", "damage", "required hands");
    private String Armorstitle = String.format("  %-20s  %-20s %-10s %-10s %-10s\n",
            "Type", "Name", "cost", "required level", "damage reduction");
    private String Potionstitle = String.format("  %-20s  %-20s %-10s %-10s %-10s %-10s\n",
            "Type", "Name", "cost", "required level", "attribute increase", "attribute affected");
    private String Spellstitle = String.format("   %-20s %-20s %-10s %-10s %-10s %-10s\n",
            "Type", "Name", "cost", "required level", "damage", "mana cost");
    InputValidator inputValidator = new InputValidator();
    private Party party = new Party();
    private Party fullParty = new Party();
    private ArrayList<Hero> faintedHero = new ArrayList<Hero>();
    private ArrayList<Monster> monsterGroup = new ArrayList<Monster>();
    private ArrayList<Monster> fullMonsterGroup = new ArrayList<Monster>();

    private List<Monster> allMonsters = new ArrayList<Monster>();
    private MonsterFactory mf = new MonsterFactory();

    private void generateMonstergroup() {


        int maxLevel = party.getMaxLevel();
        for (Monster m : allMonsters) {
            if (m.getLevel() == maxLevel || m.getLevel() == maxLevel + 1 || m.getLevel() == maxLevel - 1) {
                monsterGroup.add(m);
            }
        }

        Collections.shuffle(monsterGroup);

        if (party.size() < monsterGroup.size()) {
            monsterGroup.subList(party.size(), monsterGroup.size()).clear();
        }
        fullMonsterGroup = new ArrayList<>(Collections.nCopies(monsterGroup.size(), null));
        Collections.copy(fullMonsterGroup, monsterGroup);


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


    private void printBattleStart() {
        System.out.println("******************************");
        System.out.println("        Battle Start");
        System.out.println("Party: ");
        party.printPartySituation();
        System.out.println("Monster Group: ");
        printMonsterSituation();
        System.out.println();

    }

    private void printMonsterSituation() {

        String title = String.format("   %-20s %-10s %-10s %-10s %-10s %-10s\n",
                "Name", "HP", "level", "damage", "defense", "dodge chance");
        System.out.println(title);

        int number = 1;
        for (Monster mon : monsterGroup) {

            System.out.println(number + ". " + mon.printMonster());
            number++;
        }
        System.out.println();


    }


    public int start(Party party) throws FileNotFoundException {
        this.party = party;
        allMonsters = mf.getAllMonsters();
        generateMonstergroup();
        printBattleStart();

        while (!battleEnd) {
            processTurn();
            int winner= -1;
            if (monsterGroup.isEmpty()) winner= 1; // Heroes win
            if (party.size() == 0) winner= 0; // Monsters win

            if (winner != -1) {
                announceWinner(winner);
                resetParty();
                return winner;
            }
        }
        return -1;
    }


    private void processTurn() {
        HeroTurn();
        MonsterTurn();
    }

    private void announceWinner(int winner) {
        if (winner == 1) {
            System.out.println("************* Hero Party wins *************");
        } else if (winner == 0) {
            System.out.println("************* Monsters win ************");
            System.out.println("************* Game Over ************");
            System.out.println("Quit...");
        }
        battleEnd = true;
    }

    private void resetParty() {

        System.out.println("Resetting party after battle -------------------------");
        System.out.println("Your party wins the game, so your experience, money, HP, Mana will increase! ");
        System.out.println("Survived Heroes get benefit: ");
        for(Monster mon : fullMonsterGroup){
            party.winBattleBenefit(mon.getLevel() ); //survived heroes gain more
            party.gainHPMANA();
        }

        party.printPartySituation(); //

        party.addDeadPool(faintedHero);

        System.out.println("All Heroes in the party get benefit: ");


        for(Monster mon : fullMonsterGroup){
            party.winBattleBenefit(mon.getLevel() );

        }
        party.levelUpHPMANA();
        party.printPartySituation(); //



    }


    private char askHeroAttack(Hero hero){
        while (true){
            System.out.println("**************** It's Hero -- "+hero.getName()+ "'s turn: ******************");
            System.out.println("[T] Attack    [S] Use Spells   [P] Use Potions");
            System.out.println("[A] Equip Armor  [W] Equip Weapon  [I] Hero Info  [M] Monster Info");
            System.out.print("Choose an action:");
            char input = inputValidator.checkBattleInput();

            if((input == 'T')||(input == 'S')||(input == 'P')||(input == 'A')||(input == 'W')){
                return input;
            } else if (input=='I') {
                party.printPartySituation();
            } else if (input=='M') {
                printMonsterSituation();
            } else System.out.println("Your enter is invalid, please enter again:");
        }


    }

    private int attackWhichMonster(){  // ask to attach which monster
        if(monsterGroup.size() == 0){
            System.out.println("No Monsters here!");
            return -1;
        }
        System.out.println(String.format("Here are the Monsters"));
        printMonsterSituation();
        System.out.println();

        System.out.println(String.format("Choose a monster to attack"));
        System.out.print("Please enter the number: ");
        int input = inputValidator.promptPositiveInteger();

        while(input > monsterGroup.size()){
            System.out.println("Please enter the ID number of the monster you wish to battle:");
            input = inputValidator.promptPositiveInteger();
        }
        return input;

    }

    public boolean HeroFight(Hero hero){

            char input = askHeroAttack(hero);
            if (input == 'T') { //attack monsters

                int index_string = attackWhichMonster();
                if(index_string!=-1) {
                    Monster monster = monsterGroup.get(index_string-1);
                    hero.attack(monster);
                    if(!monster.getAlive()){
                        monsterGroup.remove(monster);
                    }
                    return true;
                }
                return false;


            } else if (input == 'A') {  // equip armor
                ArrayList<Item> list = hero.getArmorInventory();

                int index_string = askItem(hero, list, Armorstitle, "Armor");

                if(index_string!=-2) {
                    hero.equip(list.get(index_string-1));
                    return false;
                }
                return false;

            } else if (input == 'W') {  //equip weapon
                ArrayList<Item> list = hero.getWeaponryInventory();
                int index_string = askItem(hero, list, Weaponstitle, "Weapon");
                //Ask the player that what items should this hero equip
                if(index_string !=-2) {//quit
                    hero.equip(list.get(index_string-1));
                    return false;
                }
                return false;

            } else if (input == 'S') { //use spell
                ArrayList<Item> list = hero.getSpellInventory();
                int index_string = askItem(hero, list, Spellstitle, "Spell");
                if(index_string !=-2) {
                    Spell spelluse = (Spell) list.get(index_string-1);
                    int manaNeed = spelluse.getManaCost();


                    if(manaNeed > hero.getMana()){
                        System.out.println(hero.getName()+"'s mana is not enough to use this spell. ");

                    }else if(spelluse.getRestUseTime() <= 0){
                        System.out.println(spelluse.getName()+" has run out. ");
                    }else{
                        int indexMonster = attackWhichMonster();
                        if(indexMonster==-1) {
                            return false;
                        }
                        spelluse.consume();
                        Monster monster = monsterGroup.get(indexMonster-1);
                        hero.useSpell(monster, index_string-1);
                        if(!monster.getAlive()){
                            monsterGroup.remove(monster);
                        }
                    }
                    return true;
                }
                return false;


            } else if (input == 'P') { //use potion
                ArrayList<Item> list = hero.getPotionsInventory();
                int index_string = askItem(hero, list, Potionstitle, "Potions");
                if(index_string !=-2) {
                    Potions Potionsuse = (Potions) list.get(index_string-1);
                    Potionsuse.consume();
                    Potionsuse.usePotion(hero);

                    hero.usePotion(index_string-1);
                    return false;
                }
                return false;

            }

        return false;

    }

    private int askItem(Hero hero, ArrayList<Item> Inventory, String title, String type) {
        if(Inventory.size() == 0){
            System.out.println(hero.getName()+" doesn't have any "+type+".");
            return -2;
        }else {
            System.out.println(hero.getName() + " has these "+type+":");
            printItemList(type, title, Inventory);
            int size = Inventory.size();
            System.out.println("Which item does " + hero.getName() + " want to equip/use? ");
            System.out.println("Enter [I] for hero info, [X] to change your mind if you don't want to equip, or select an option number: ");

            int idnum = inputValidator.marketChecker("X");
            if (idnum == -1) {
                System.out.println(hero.printSingleHero());
                idnum = size + 1;
            }
            while (idnum > size) {
                System.out.println("Enter [I] for hero info, [X] to change your mind if you don't want to equip, or select an option number: ");
                idnum = inputValidator.marketChecker("X");
                if (idnum == -1) {
                    System.out.println(hero.printSingleHero());
                    idnum = size + 1;
                }
            }
            return idnum;
        }

    }

    public void HeroTurn(){

        for(int i = 0; i < party.size(); i++){
            boolean action = false;
            while(!action){
                Hero next_hero = party.getHero(i);
                action = HeroFight(next_hero);
                if(checkWin()) return;
            }

        }

    }

    public void MonsterTurn(){

        for(int i = 0; i < monsterGroup.size(); i++){
            System.out.println("*****************It's Monster's Turn: *********************");
            Monster monster = monsterGroup.get(i);
            Random random = new Random();
            int index = random.nextInt(party.size());
            Hero be_attacked = party.getHero(index);
            // choose a hero randomly
            monster.attack(be_attacked);
            if (!be_attacked.isAlive()){
                party.remove(index);
                faintedHero.add(be_attacked);
            }
        }

    }


    public boolean checkWin(){
        if(party.size()==0 || monsterGroup.size()==0 ){
            return true;
        }else{
            return false;
        }

    }


}

