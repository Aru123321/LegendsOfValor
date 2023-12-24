package Game;

import InputAndReader.InputValidator;

import Item.Item;
import Map.LegendsOfValorMap;
import Party.Party;
import Party.monsterGroup;
import Character.Hero;
import Character.Monster;
import Cell.Cell;
import Cell.HeroNexusCell;
import Cell.MonsterNexusCell;
import Cell.ObstacleCell;
import Cell.inaccessibleCell;
import Item.Potions;
import Item.Spell;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LegendsOfValorGame extends roundGame implements GameEventListener {
    InputValidator inputValidator = new InputValidator();
    private Party party;
    private List<GameEventListener> listeners ;
    private String Weaponstitle = String.format("  %-20s  %-20s %-10s %-10s %-10s %-10s\n",
            "Type", "Name", "cost", "required level", "damage", "required hands");
    private String Armorstitle = String.format("  %-20s  %-20s %-10s %-10s %-10s\n",
            "Type", "Name", "cost", "required level", "damage reduction");
    private String Potionstitle = String.format("  %-20s  %-20s %-10s %-10s %-10s %-10s\n",
            "Type", "Name", "cost", "required level", "attribute increase", "attribute affected");
    private String Spellstitle = String.format("   %-20s %-20s %-10s %-10s %-10s %-10s\n",
            "Type", "Name", "cost", "required level", "damage", "mana cost");

    private final int levelGoldFactor = 500;
    private final int levelExpFactor = 2;
    private LegendsOfValorMap map;
    private boolean gameEnd = false;
    private ArrayList<Monster> monsterAllGroups;
    private int newMonsterRounds = 8;
    private int monsterIndex = 0;
    private int herodead = 0;
    public LegendsOfValorGame() throws FileNotFoundException {
        monsterAllGroups= new ArrayList<Monster>();
        listeners = new ArrayList<>();
        map = new LegendsOfValorMap();
        party = new Party();

    }

    @Override
    public void startGame() throws FileNotFoundException {

        welcomeText();
        party.createValorParty();
        monsterGroup monsterGroup = new monsterGroup(party);
        monsterGroup.createGroup(monsterIndex);
        map.randomMap();

        ArrayList<Hero> HeroInParty = party.getHeroList();
        for(Hero h: HeroInParty){
            Cell heroCell = map.getHeroCell(h);
            heroCell.setHero(h);
            h.addGameEventListener(this);
        }
        ArrayList<Monster> monsterInParty = monsterGroup.getMonsterList();
        for(Monster m: monsterInParty){
            Cell monsterCell = map.getMonsterCell(m);
            monsterCell.setMonster(m);
        }

        monsterAllGroups = new ArrayList<>(monsterInParty);
        for(Monster m: monsterAllGroups){
            m.addGameEventListener(this);
        }

        System.out.println("Your game map: ");
        System.out.println(map.toString());


        //game start
        //round
        System.out.println();
        System.out.println("Reminder you can quit the game if you enter [Q] at any time. ");
        System.out.println("Reminder hero can attack more if he or she hold the weapon by two hands. ");
        System.out.println();
        System.out.println("************************************");
        System.out.println("Game Start! ");
        int round = 0;


        while(!gameEnd){
            round++;

            if(newMonsterRounds == 0){
                addNewMonsters();
                newMonsterRounds = 9;
                for(Monster m: monsterAllGroups){
                    m.addGameEventListener(this);
                }
            }

            heroTurn();

            for(Monster monster: monsterAllGroups){
                boolean aliveBefore = monster.MonAlive();
                boolean isAlive = monster.isAlive();
                if(aliveBefore!=isAlive){
                    monster.setMonDie();
                    System.out.println("*************************************************");
                    System.out.println("In this round: ");
                    System.out.println("Monster "+monster.getName()+" dead.");
                    int x = monster.getPositionRow();
                    int y = monster.getPositionCol();
                    Cell[][] cellBoard = map.getMap();
                    cellBoard[x][y].monsterLeave();

                    System.out.println("A monster is dead in this round. All heroes can get $"+ levelGoldFactor * monster.getLevel()+" money and "+ levelExpFactor * monster.getLevel()+ " experience!");
                    for(Hero h:HeroInParty){
                        h.heroAddMoney(monster.getLevel()*500);
                        h.heroAddExp(monster.getLevel()*2);
                    }

                }

            }
            //before monster turn, check the alive status of all monsters
            monsterTurn();

            System.out.println("***********************************************");
            newMonsterRounds--;

            System.out.println("The round is over:  ");
            System.out.println("Reminder you can quit the game if you enter [Q] at any time. ");
            System.out.println("All alive heroes get 10% HP and 10% mana!");
            for(Hero hero: HeroInParty){
                boolean isAlive = hero.isAlive();
                if(!isAlive){
                    herodead++;
                    System.out.println("All dead heroes has respawn with the full HP and mana. ");
                    int x = hero.getPositionRow();
                    int y = hero.getPositionCol();
                    hero.setStartPosition(hero.getHeroNum()-1);
                    hero.heroAddHP(hero.getLevel()*100);
                    hero.setMana((hero.getMana()));

                    int nx = hero.getPositionRow();
                    int ny = hero.getPositionCol();
                    Cell[][] cellBoard = map.getMap();
                    cellBoard[x][y].heroLeave();
                    cellBoard[nx][ny].setHero(hero);
                }else{

                    hero.heroAddHP((int)(hero.getHP()*0.1));
                    hero.heroAddMana((int)(hero.getMana()*0.1));
                }

            }

            //check experience to level up heroes
            party.levelUpHPMANA();


        }

        int monsterKilled = 0;
        for(Monster monster: monsterAllGroups) {
            boolean isAlive = monster.isAlive();
            if (!isAlive) {
                monsterKilled++;
            }
        }
        System.out.println("******************************************");
        System.out.println("Game statistic: ");
        System.out.println("Game over in "+round+ " rounds.");
        System.out.println("There are "+ monsterAllGroups.size() + " monsters spawned on the map.");
        System.out.println("Your party killed "+ monsterKilled + " monsters.");
        System.out.println("Your party respawned "+ herodead + " heroes.");
        System.out.println("Your party's max level is "+ party.getMaxLevel() + ".");

        System.out.println("Game End...");
        System.out.println("Quit...");


        //need rewrite for legends of valor Game:
        //In the new loop, every few rounds, three new monsters will spawn in the monsters’ Nexus



    }

    @Override
    public void onHeroReachedNexus(Hero hero) {
        System.out.println("******************************************");
        System.out.println("Congratulations! Your party of Heroes wins!");
        endGame();
    }

    @Override
    public void onMonsterReachedNexus(Monster monster) {
        System.out.println("******************************************");
        System.out.println("A Monster is in Hero Nexus...");
        System.out.println("Monster Group wins...");
        endGame();
    }

    private void endGame() {
        gameEnd = true;
    }

    private void addNewMonsters() throws FileNotFoundException {
        monsterIndex = monsterIndex+3;
        monsterGroup newMonsterGroup = new monsterGroup(party);
        newMonsterGroup.createGroup(monsterIndex);

        ArrayList<Monster> newMonsterInParty = newMonsterGroup.getMonsterList();
        for(Monster m: newMonsterInParty){
            Cell monsterCell = map.getMonsterCell(m);
            monsterCell.setMonster(m);
        }
        for(Monster m: newMonsterInParty){
            m.addGameEventListener(this);
        }
        monsterAllGroups.addAll(newMonsterInParty);
    }

//    private boolean checkWin() { // win if one hero reaches monster's nexus
//
//        for(int i = 0; i < party.size(); i++){
//            Hero h = party.getHero(i);
//            Cell heroCell = map.getHeroCell(h);
//            if (heroCell instanceof MonsterNexusCell){
//                System.out.println("******************************************");
//                System.out.println("Congratulations! Your party of Heroes wins!");
//                return true;
//            }
//
//        }
//        // lose if one hero reaches monster's nexus
//        for(int i = 0; i < monsterAllGroups.size(); i++){
//            Monster m = monsterAllGroups.get(i);
//            Cell mCell = map.getMonsterCell(m);
//            if (mCell instanceof HeroNexusCell){
//                System.out.println("******************************************");
//                System.out.println("A Monster is in Hero Nexus...");
//                System.out.println("Monster Group wins...");
//                return true;
//            }
//
//        }
//        return false;
//    }

    private void gameStartMaket() {
        for(int i = 0; i < party.size(); i++){
            Hero h = party.getHero(i);
            Cell heroCell = map.getHeroCell(h);
            if (heroCell instanceof HeroNexusCell){
                ((HeroNexusCell) heroCell).eventHereHero(h);
            }

        }
    }

    private void monsterTurn() {
        for(int i = 0; i < monsterAllGroups.size(); i++){
            if(gameEnd){
                return;
            }
            Monster monster = monsterAllGroups.get(i);
            if(monster.MonAlive()){
                System.out.println("*****************It's Monster "+monster.getMonsterNum()+" -- "+monster.getName()+" Turn: *********************");
                int r = monster.getPositionRow();
                int c = monster.getPositionCol();
                //check if there is hero in the same row with the monster

                Cell mCell = map.getMonsterCell(monster);
                boolean hInmCell = mCell.getHeroInCell() != null;
                boolean hInmCellLeft = false;
                Cell mCellLeft = map.getPositionCell(r,c);
                if(c != 0){
                    mCellLeft = map.getPositionCell(r,c-1);
                    hInmCellLeft = mCellLeft.getHeroInCell() != null;
                }

                boolean hInmCellRight = false;
                Cell mCellRight = map.getPositionCell(r,c);
                if(c != 7){
                    mCellRight = map.getPositionCell(r,c+1);
                    hInmCellRight = mCellRight.getHeroInCell() != null;
                }

                // If hero is in the same lane the same row, attack
                // monster cannot move behind the hero:
                if(hInmCell){
                    System.out.println("The monster attacks!");

                    monster.attack(mCell.getHeroInCell());
                }else if(hInmCellLeft){
                    System.out.println("The monster attacks!");
                    monster.attack(mCellLeft.getHeroInCell());
                }else if(hInmCellRight){
                    System.out.println("The monster attacks!");
                    monster.attack(mCellRight.getHeroInCell());
                }
                // go forward
                else{
                    Cell nextCell = map.getPositionCell(r+1,c);
                    monster.setPositionRow(r+1);

                    //There's an obstacle ahead
                    if (nextCell instanceof ObstacleCell){
                        nextCell = map.getPositionCell(r,c);
                        monster.setPositionRow(r);
                        System.out.println("The monster meets an obstacle!");


                        if(c != 7 ){
                            Cell RightCell = map.getPositionCell(r,c+1);
                            if(!(RightCell instanceof ObstacleCell) && !(RightCell instanceof inaccessibleCell)){
                                nextCell = map.getPositionCell(r,c+1);
                                monster.setPositionCol(c+1);


                                System.out.println("The monster goes right");
                            }

                        }
                        if(c != 0) {
                            Cell LeftCell = map.getPositionCell(r,c-1);
                            if(!(LeftCell instanceof ObstacleCell) && !(LeftCell instanceof inaccessibleCell)){
                                nextCell = map.getPositionCell(r, c - 1);
                                monster.setPositionCol(c-1);

                                System.out.println("The monster goes left");
                            }

                        }

                    }else if(nextCell.getMonsterInCell()!=null){ // There's another monster ahead
                        System.out.println("There's another monster ahead");
                        monster.setPositionRow(r);
                        nextCell = map.getPositionCell(r, c );
                    }else if (nextCell instanceof HeroNexusCell) {

                        monster.notifyMonsterReachedNexus(monster);
                    }

                    else{
                        System.out.println("The monster goes forward!");
                    }
                    mCell.monsterLeave();
                    nextCell.setMonster(monster);
                }
                System.out.println("Your game map: ");
                System.out.println(map.toString());


            }



        }
    }


    public void addGameEventListener(GameEventListener listener) {
        listeners.add(listener);
    }
    private char askHeroAttack(Hero hero){
        while (true){
            System.out.println("**************** It's Hero "+hero.getHeroNum()+"-- "+hero.getName()+ "'s turn: ******************");
            System.out.println("[T] Attack    [S] Use Spells   [P] Use Potions");
            System.out.println("[A] Equip Armor  [W] Equip Weapon  [V] Move [O]Teleport [R] Recall [I] Hero Info [M] Monster Info");
            // add monster info
            System.out.print("Choose an action:");
            char input = inputValidator.checkActionInput();



            if((input == 'T')||(input == 'S')||(input == 'P')||(input == 'A')||(input == 'W')||(input == 'O')||(input == 'V')||(input == 'R')){
                return input;
            } else if (input=='I') {
                party.printPartySituation();
            } else if (input=='M') {
                printMonsterSituation();
            }
            else System.out.println("Your enter is invalid, please enter again:");
        }


    }

    public void printMonsterSituation() {

        String title = String.format("   %-20s %-10s %-10s %-10s %-10s %-10s\n",
                "Name", "HP", "level", "damage", "defense", "dodge chance");
        System.out.println(title);

        int number = 1;
        for (Monster mon : monsterAllGroups) {

            System.out.println(number + ". " + mon.printMonster());
            number++;
        }
        System.out.println();
    }


    private void heroTurn() {

        for(int i = 0; i < party.size(); i++){
            if(gameEnd){
                return;
            }
            Hero hero = party.getHero(i);
            
            int r = hero.getPositionRow();
            int c = hero.getPositionCol();

            Cell mCell = map.getHeroCell(hero);

            //check if there is a monster in the same row with the hero - cannot move behind the monster
            ////check if there is a monster in the attack range of the hero
            boolean hInmCellLeft = false;
            Cell mCellLeft = map.getPositionCell(r,c);
            boolean hInmCellUpLeft = false;
            Cell mCellUpLeft = map.getPositionCell(r,c);
            boolean hInmCellDownLeft = false;
            Cell mCellDownLeft = map.getPositionCell(r,c);
            if(c != 0 && r != 0 && r!=7){
                mCellLeft = map.getPositionCell(r,c-1);
                hInmCellLeft = mCellLeft.getMonsterInCell() != null;

                mCellUpLeft = map.getPositionCell(r-1,c-1);
                hInmCellUpLeft = mCellUpLeft.getMonsterInCell() != null;

                mCellDownLeft = map.getPositionCell(r+1,c-1);
                hInmCellDownLeft = mCellDownLeft.getMonsterInCell() != null;
            }

            boolean hInmCellRight = false;
            Cell mCellRight = map.getPositionCell(r,c);
            boolean hInmCellUpRight = false;
            Cell mCellUpRight = map.getPositionCell(r,c);
            boolean hInmCellDownRight = false;
            Cell mCellDownRight = map.getPositionCell(r,c);
            if(c != 7 && r != 0 && r!=7){
                mCellRight = map.getPositionCell(r,c+1);
                hInmCellRight = mCellRight.getMonsterInCell() != null;

                mCellUpRight = map.getPositionCell(r-1,c+1);
                hInmCellUpRight = mCellUpRight.getMonsterInCell() != null;

                mCellDownRight = map.getPositionCell(r+1,c+1);
                hInmCellDownRight = mCellDownRight.getMonsterInCell() != null;
            }



            boolean hInmCell = mCell.getMonsterInCell() != null;

            boolean actSucessfully = false;


            Cell mCellDown = map.getPositionCell(r, c);
            boolean hInmCellDown = false;
            Cell mCellUp = map.getPositionCell(r, c);
            boolean hInmCellUp = false;


            if(r != 0 && r!=7) {
                mCellDown = map.getPositionCell(r + 1, c);
                hInmCellDown = mCellDown.getMonsterInCell() != null;

                mCellUp = map.getPositionCell(r - 1, c);
                hInmCellUp = mCellUp.getMonsterInCell() != null;
            }

            while(!actSucessfully){
                // check : hero is in the nexus, if yes, enter market first
                if(mCellLeft instanceof HeroNexusCell){
                    ((HeroNexusCell)mCellLeft).eventHereHero(hero);
                }
                char input = askHeroAttack(hero);
                if (input == 'V'){

                        System.out.println("Please enter your movement direction [W/A/S/D]:");
                        char d = inputValidator.checkMovementInput();
                        boolean canMove = hero.moveHero(map,""+d);


                        while(!canMove){
                            System.out.println("Please enter your movement direction again [W/A/S/D]:");
                            d = inputValidator.checkMovementInput();
                            canMove = hero.moveHero(map,""+d);
                        }
                        if(canMove) {

                            actSucessfully = true;
                        }

                }else if(input =='R'){
                    hero.setSpawnPosition(i,map);
                    mCell.heroLeave();
                    actSucessfully = true;

                }else if (input == 'A') {  // equip armor
                    ArrayList<Item> list = hero.getArmorInventory();
                    int index_string = askItem(hero, list, Armorstitle, "Armor");

                    if(index_string!=-2) {
                        hero.equip(list.get(index_string-1));
                        actSucessfully = true;

                    }else{
                        actSucessfully = false;
                    }
                }else if (input == 'W') {  // equip weapon
                    ArrayList<Item> list = hero.getWeaponryInventory();
                    int index_string = askItem(hero, list, Weaponstitle, "Weapon");

                    if(index_string!=-2) {
                        hero.equip(list.get(index_string-1));
                        actSucessfully = true;

                    }else{
                        actSucessfully = false;
                    }
                }else if (input == 'P') {  // use a potion
                    ArrayList<Item> list = hero.getPotionsInventory();
                    int index_string = askItem(hero, list, Potionstitle, "Potions");

                    if(index_string!=-2) {
                        Potions Potionsuse = (Potions) list.get(index_string-1);
                        Potionsuse.consume();
                        Potionsuse.usePotion(hero);
                        hero.usePotion(index_string-1);
                        actSucessfully = true;

                    }else{
                        actSucessfully = false;
                    }
                }else if (input == 'T') { // attack

                    if(hInmCell){

                        hero.attack(mCell.getMonsterInCell());
                        actSucessfully = true;
                    }else if(hInmCellLeft){
                        hero.attack(mCellLeft.getMonsterInCell());
                        actSucessfully = true;
                    }else if(hInmCellRight){
                        hero.attack(mCellRight.getMonsterInCell());
                        actSucessfully = true;
                    }else if(hInmCellUp){
                        hero.attack(mCellUp.getMonsterInCell());
                        actSucessfully = true;
                    }else if(hInmCellUpRight){
                        hero.attack(mCellUpRight.getMonsterInCell());
                        actSucessfully = true;
                    }else if(hInmCellUpLeft){
                        hero.attack(mCellUpLeft.getMonsterInCell());
                        actSucessfully = true;
                    }else if(hInmCellDown){
                        hero.attack(mCellDown.getMonsterInCell());
                        actSucessfully = true;
                    }else if(hInmCellDownLeft){
                        hero.attack(mCellDownLeft.getMonsterInCell());
                        actSucessfully = true;
                    }else if(hInmCellDownRight){
                        hero.attack(mCellDownRight.getMonsterInCell());
                        actSucessfully = true;
                    }


                    else{
                        System.out.println("No monster is in your attack range. ");
                        actSucessfully = false;
                    }



                }else if (input == 'S') { // use a spell
                    ArrayList<Item> list = hero.getSpellInventory();
                    int index_string = askItem(hero, list, Spellstitle, "Spell");
                    if(index_string !=-2) {
                        Spell spelluse = (Spell) list.get(index_string-1);
                        int manaNeed = spelluse.getManaCost();

                        if(manaNeed > hero.getMana()){
                            System.out.println(hero.getName()+"'s mana is not enough to use this spell. ");
                            actSucessfully = false;
                        }else if(spelluse.getRestUseTime() <= 0){
                            System.out.println(spelluse.getName()+" has run out. ");
                            actSucessfully = false;
                        }else{
                            if(hInmCell){
                                hero.useSpell(mCell.getMonsterInCell(),index_string-1);
                                spelluse.consume();

                                actSucessfully = true;
                            }else if(hInmCellLeft){
                                hero.useSpell(mCellLeft.getMonsterInCell(),index_string-1);
                                spelluse.consume();

                                actSucessfully = true;
                            }else if(hInmCellRight){
                                hero.useSpell(mCellRight.getMonsterInCell(),index_string-1);
                                spelluse.consume();

                                actSucessfully = true;
                            }else if(hInmCellUp){
                                hero.useSpell(mCellUp.getMonsterInCell(),index_string-1);
                                spelluse.consume();

                                actSucessfully = true;
                            }else if(hInmCellUpRight){
                                hero.useSpell(mCellUpRight.getMonsterInCell(),index_string-1);
                                spelluse.consume();

                                actSucessfully = true;
                            }else if(hInmCellUpLeft){
                                hero.useSpell(mCellUpLeft.getMonsterInCell(),index_string-1);
                                spelluse.consume();

                                actSucessfully = true;
                            }else if(hInmCellDown){
                                hero.useSpell(mCellDown.getMonsterInCell(),index_string-1);
                                spelluse.consume();

                                actSucessfully = true;
                            }else if(hInmCellDownLeft){
                                hero.useSpell(mCellDownLeft.getMonsterInCell(),index_string-1);
                                spelluse.consume();

                                actSucessfully = true;
                            }else if(hInmCellDownRight){
                                hero.useSpell(mCellDownRight.getMonsterInCell(),index_string-1);
                                spelluse.consume();

                                actSucessfully = true;
                            }
                            else{
                                actSucessfully = false;
                                System.out.println("No monster is in your spell attack range. ");
                            }

                        }

                    }else{
                        actSucessfully = false;
                    }

                
                }else if(input == 'O'){  // teleport
                    boolean tele = handleTeleportation(hero);
                    actSucessfully = tele;


                if (actSucessfully == false){
                    System.out.println("Your action is inValid or you changed your mind, please choose a new action: ");
                }



            }
                System.out.println("Your game map: ");
                System.out.println(map.toString());
        }
    }


        



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

    private boolean handleTeleportation(Hero hero) {
        System.out.println("Select a target hero number for teleportation:");
        for (int j = 0; j < party.size(); j++) {
            Hero potentialTarget = party.getHero(j);
            System.out.println(j + ": " + potentialTarget.getName());
        }

        int targetIndex = inputValidator.promptInteger();

        if (targetIndex >= 0 && targetIndex < party.size() && targetIndex != party.indexOf(hero)-1) {
            Hero targetHero = party.getHero(targetIndex);
            boolean success = hero.teleport(map, targetHero);
            if (success) {
                System.out.println(hero.getName() + " has teleported to a position near " + targetHero.getName());
                return true;
            } else {
                System.out.println("Teleportation failed.");
                return false;
            }
        } else {
            System.out.println("Invalid selection. Teleportation cancelled.");
            return false;
        }
    }

    private void welcomeText(){
        System.out.println("*************************************************");
        System.out.println("     Welcome to Legends: Legends of Valor ");
        System.out.println("*************************************************");

        System.out.println("Legends of Valor is a MOBA (multiplayer online battle arena)-like game. The monsters and \n" +
                "heroes live in a fictional world. They do not get along and therefore fight each other.\n" +
                "Every time the heroes win, they gain experience and money. Heroes use the money to buy a variety of\n" +
                "items to aid them in their battles with the monsters. When they accumulate enough experience, they\n" +
                "level up, which improves their skills. You will control a team of 3 heroes who will attempt to fight \n" +
                "their way through to the monsters’ Nexus. The heroes win if any of them reach the monsters’ Nexus.\n" +
                "The heroes lose if any monster reaches the heroes’ Nexus.");


    }


}
