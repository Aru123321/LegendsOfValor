package Character;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Cell.Cell;
import Cell.HeroNexusCell;
import Cell.BushCell;
import Cell.CaveCell;
import Cell.KoulouCell;
import Cell.PlainCell;
import Cell.ObstacleCell;
import Cell.inaccessibleCell;
import Cell.MonsterNexusCell;
import InputAndReader.InputValidator;
import Game.GameEventListener;



import Item.Armor;
import Item.Spell;
import Item.Potions;

import Item.Item;
import Item.Weaponry;
import Map.LegendsOfValorMap;



public class Hero extends Character implements HeroCharacter{
    InputValidator inputValidator = new InputValidator();
    private List<GameEventListener> listeners = new ArrayList<>();

    protected SkillStrategy skillStrategy;

    private int positionCol;
    private int positionRow;

    protected int mana;
    protected int strength;
    protected int agility;
    protected int dexterity;
    protected int money;
    protected int experience;
    private int HeroIndex;
    protected int experienceLimit;
    private Weaponry weapon = null;
    private Armor Arm = null;

    protected int Defense;

    private final int levelFactor = 10;
    private final double levelSkillFactor = 1.05;
    private final int levelHPFactor = 100;
    private final double levelManaFactor = 1.1;
    private final double roundHPRegainFactor = 1.1;
    private final double roundMPRegainFactor = 1.1;

    private final int roundGoldfactor = 100;
    private final int roundExpfactor = 2;

    private final double heroattackFactor = 0.04;

    private final double mosnterattackFactor = 0.1;
    private final double dodgeChanceFactor = 0.0002; // agility * dodgeChanceFactor should smaller than 1
    private final int spellDamageFactor = 10000;

    private int spawnRow; // To store the spawn row position
    private int spawnCol;

    private double dodgeChance;

    private ArrayList<Item> PotionsInventory ;
    private ArrayList<Item> SpellInventory ;
    private ArrayList<Item> ArmorInventory ;
    private ArrayList<Item> WeaponryInventory;

    private String Weaponstitle = String.format("  %-20s  %-20s %-10s %-10s %-10s %-10s\n",
            "Type","Name", "cost","required level","damage", "required hands");
    private String Armorstitle = String.format("  %-20s  %-20s %-10s %-10s %-10s\n",
            "Type","Name", "cost","required level","damage reduction");
    private String Potionstitle = String.format("  %-20s  %-20s %-10s %-10s %-10s %-10s\n",
            "Type","Name", "cost","required level","attribute increase","attribute affected");
    private String Spellstitle = String.format("   %-20s %-20s %-10s %-10s %-10s %-10s\n",
            "Type","Name", "cost","required level","damage","mana cost");
    private String herotitle = String.format("   %-20s %-10s %-10s %-10s %-10s %-10s %-10s %-13s %-13s\n",
            "Name", "HP","Level","Mana", "Strength", "Agility", "Dexterity", "Money", "Experience");


    private String heroMark;
    Hero(String n, int m, int str, int a, int d, int gold, int exp){
        name = n;
        mana = m;
        strength = str;
        agility = a;
        dexterity = d;
        money = gold;
        experience = exp;
        level = 1;
        HP = level*levelHPFactor;
        dodgeChance = agility * dodgeChanceFactor;
        Defense = 0;
        PotionsInventory = new ArrayList<Item>();
        SpellInventory = new ArrayList<Item>();
        ArmorInventory = new ArrayList<Item>();
        WeaponryInventory = new ArrayList<Item>();
    }

    public ArrayList<Item> getPotionsInventory() {
        return PotionsInventory;
    }

    public ArrayList<Item> getSpellInventory() {
        return SpellInventory;
    }
    public ArrayList<Item> getArmorInventory() {
        return ArmorInventory;
    }
    public ArrayList<Item> getWeaponryInventory() {
        return WeaponryInventory;
    }


    // x is original positionRow, y is original positionCol,
    // nx is the new positionRow of movement, ny is the new positionCol of movement
    public void handleMovement(Cell[][] cellBoard,int x, int y, int nx,int ny){

        if(cellBoard[x][y] instanceof BushCell) {
            System.out.println("You left Bush Space， so the bonus in Bush Space is deducted. ");
            ((BushCell) cellBoard[x][y]).leaveSpace(this);
        }else if(cellBoard[x][y] instanceof CaveCell){
            System.out.println("You left Cave Space， so the bonus in Cave Space is deducted. ");
            ((CaveCell) cellBoard[x][y]).leaveSpace(this);
        }else if (cellBoard[x][y] instanceof KoulouCell){
            System.out.println("You left Koulou Space， so the bonus in Koulou Space is deducted. ");
            ((KoulouCell) cellBoard[x][y]).leaveSpace(this);
        }
        this.setPositionRow(nx);
        this.setPositionCol(ny);
        cellBoard[x][y].heroLeave();
        cellBoard[nx][ny].setHero(this);
    }
    public boolean moveHero(LegendsOfValorMap board, String direction) {
        int x = this.getPositionRow();
        int y = this.getPositionCol();
        Cell[][] cellBoard = board.getMap();

        switch (direction.toLowerCase()) {
            case "w":

                // Hero cannot move behind the monster:
                boolean hInmCellLeft = false;
                if(y != 0 && x != 0 && x!=7){
                    Cell mCellLeft = board.getPositionCell(x,y-1);
                    hInmCellLeft = mCellLeft.getMonsterInCell() != null;
                }
                boolean hInmCellRight = false;
                if(y != 7 && x != 0 && x!=7){
                    Cell mCellRight = board.getPositionCell(x,y+1);
                    hInmCellRight = mCellRight.getMonsterInCell() != null;
                }
                Cell mCell = board.getHeroCell(this);
                boolean hInmCell = mCell.getMonsterInCell() != null;

                if(hInmCell||hInmCellLeft||hInmCellRight){
                    System.out.println("You cannot move behind a monster without killing it. ");

                }else{
                    //no monster in the same row
                    if ((x - 1 >= 0) && (!(cellBoard[x - 1][y] instanceof inaccessibleCell)) && (cellBoard[x - 1][y].getHeroInCell()==null)) {
                        if(cellBoard[x - 1][y] instanceof BushCell){
                            handleMovement(cellBoard,x,y,x-1,y);
                            ((BushCell)cellBoard[x - 1][y]).eventHereHero(this);
                            return true;
                        }else if (cellBoard[x - 1][y] instanceof CaveCell){
                            handleMovement(cellBoard,x,y,x-1,y);
                            ((CaveCell)cellBoard[x - 1][y]).eventHereHero(this);
                            return true;
                        }else if (cellBoard[x - 1][y] instanceof KoulouCell){
                            handleMovement(cellBoard,x,y,x-1,y);
                            ((KoulouCell)cellBoard[x - 1][y]).eventHereHero(this);
                            return true;
                        }else if (cellBoard[x - 1][y] instanceof PlainCell){
                            handleMovement(cellBoard,x,y,x-1,y);
                            ((PlainCell)cellBoard[x - 1][y]).eventHereHero(this);
                            return true;
                        }else if (cellBoard[x - 1][y] instanceof HeroNexusCell){
                            handleMovement(cellBoard,x,y,x-1,y);
                            ((HeroNexusCell)cellBoard[x - 1][y]).eventHereHero(this);
                            return true;
                        }else if (cellBoard[x - 1][y] instanceof MonsterNexusCell){
                            handleMovement(cellBoard,x,y,x-1,y);
                            ((MonsterNexusCell)cellBoard[x - 1][y]).eventHereHero(this);
                            notifyHeroReachedNexus();
                            return true;
                        }else if (cellBoard[x - 1][y] instanceof ObstacleCell){
                            System.out.println("You meet an Obstacle. Do you want to use one turn to remove this obstacle [Y/N]: ");
                            boolean answer = inputValidator.checkYesNoInput();
                            if(answer){
                                cellBoard[x - 1][y] = new PlainCell();
                                return true;
                            }
                            return false;
                        }
                        return false;
                    }else if(cellBoard[x-1][y].getHeroInCell()!=null) {
                        System.out.println("Another hero is in this space, you cannot go there.");
                        return false;
                    }
                }


                break;
            case "a":


                if ((y - 1 >= 0) && (!(cellBoard[x][y - 1] instanceof inaccessibleCell) && (cellBoard[x][y-1].getHeroInCell()==null))) {

                    // Handle events based on the type of the cell
                    if (cellBoard[x][y - 1] instanceof BushCell) {
                        handleMovement(cellBoard,x,y,x,y-1);
                        ((BushCell) cellBoard[x][y - 1]).eventHereHero(this);
                        return true;

                    } else if (cellBoard[x][y - 1] instanceof CaveCell) {
                        handleMovement(cellBoard,x,y,x,y-1);
                        ((CaveCell) cellBoard[x][y - 1]).eventHereHero(this);
                        return true;
                    } else if (cellBoard[x][y - 1] instanceof KoulouCell) {
                        handleMovement(cellBoard,x,y,x,y-1);
                        ((KoulouCell) cellBoard[x][y - 1]).eventHereHero(this);
                        return true;
                    } else if (cellBoard[x][y - 1] instanceof PlainCell) {
                        handleMovement(cellBoard,x,y,x,y-1);
                        ((PlainCell) cellBoard[x][y - 1]).eventHereHero(this);
                        return true;
                    } else if (cellBoard[x][y - 1] instanceof HeroNexusCell) {
                        handleMovement(cellBoard,x,y,x,y-1);
                        ((HeroNexusCell) cellBoard[x][y - 1]).eventHereHero(this);
                        return true;
                    } else if (cellBoard[x][y - 1] instanceof MonsterNexusCell) {
                        handleMovement(cellBoard,x,y,x,y-1);
                        ((MonsterNexusCell) cellBoard[x][y - 1]).eventHereHero(this);
                        return true;
                    }else if (cellBoard[x][y - 1] instanceof ObstacleCell){
                        System.out.println("You meet an Obstacle. Do you want to use one turn to remove this obstacle [Y/N]: ");
                        boolean answer = inputValidator.checkYesNoInput();
                        if(answer){
                            cellBoard[x][y - 1] = new PlainCell();
                            return true;
                        }

                        return false;
                    }

                    return false;
                }else if(cellBoard[x][y-1].getHeroInCell()!=null){
                    System.out.println("Another hero is in this space, you cannot go there.");

                    return false;
                }

                break;
            case "s":
                if ((x + 1 < board.getRow()) && (!(cellBoard[x + 1][y] instanceof inaccessibleCell) && (cellBoard[x + 1][y].getHeroInCell()==null))) {
                    // Handle events based on the type of the cell
                    if (cellBoard[x + 1][y] instanceof BushCell) {
                        handleMovement(cellBoard,x,y,x+1,y);
                        ((BushCell) cellBoard[x + 1][y]).eventHereHero(this);
                        return true;
                    } else if (cellBoard[x + 1][y] instanceof CaveCell) {
                        handleMovement(cellBoard,x,y,x+1,y);
                        ((CaveCell) cellBoard[x + 1][y]).eventHereHero(this);
                        return true;
                    } else if (cellBoard[x + 1][y] instanceof KoulouCell) {
                        handleMovement(cellBoard,x,y,x+1,y);
                        ((KoulouCell) cellBoard[x + 1][y]).eventHereHero(this);
                        return true;
                    } else if (cellBoard[x + 1][y] instanceof PlainCell) {
                        handleMovement(cellBoard,x,y,x+1,y);
                        ((PlainCell) cellBoard[x + 1][y]).eventHereHero(this);
                        return true;
                    } else if (cellBoard[x + 1][y] instanceof HeroNexusCell) {
                        handleMovement(cellBoard,x,y,x+1,y);
                        ((HeroNexusCell) cellBoard[x + 1][y]).eventHereHero(this);
                        return true;
                    } else if (cellBoard[x + 1][y] instanceof MonsterNexusCell) {
                        handleMovement(cellBoard,x,y,x+1,y);
                        ((MonsterNexusCell) cellBoard[x + 1][y]).eventHereHero(this);
                        return true;
                    }else if (cellBoard[x + 1][y] instanceof ObstacleCell){
                        System.out.println("You meet an Obstacle. Do you want to use one turn to remove this obstacle [Y/N]: ");
                        boolean answer = inputValidator.checkYesNoInput();
                        if(answer){
                            cellBoard[x + 1][y] = new PlainCell();
                            return true;
                        }

                        return false;
                    }
                    return false;
                }else if(cellBoard[x+1][y].getHeroInCell()!=null){
                    System.out.println("Another hero is in this space, you cannot go there.");
                    return false;
                }
                break;
            case "d":
                if ((y + 1 < board.getCol()) && (!(cellBoard[x][y + 1] instanceof inaccessibleCell) && (cellBoard[x][y+1].getHeroInCell()==null))) {

                    // Handle events based on the type of the cell
                    if (cellBoard[x][y + 1] instanceof BushCell) {
                        handleMovement(cellBoard,x,y,x,y+1);
                        ((BushCell) cellBoard[x][y + 1]).eventHereHero(this);
                        return true;
                    } else if (cellBoard[x][y + 1] instanceof CaveCell) {
                        handleMovement(cellBoard,x,y,x,y+1);
                        ((CaveCell) cellBoard[x][y + 1]).eventHereHero(this);
                        return true;
                    } else if (cellBoard[x][y + 1] instanceof KoulouCell) {
                        handleMovement(cellBoard,x,y,x,y+1);
                        ((KoulouCell) cellBoard[x][y + 1]).eventHereHero(this);


                        return true;
                    } else if (cellBoard[x][y + 1] instanceof PlainCell) {
                        handleMovement(cellBoard,x,y,x,y+1);
                        ((PlainCell) cellBoard[x][y + 1]).eventHereHero(this);
                        return true;
                    } else if (cellBoard[x][y + 1] instanceof HeroNexusCell) {
                        handleMovement(cellBoard,x,y,x,y+1);
                        ((HeroNexusCell) cellBoard[x][y + 1]).eventHereHero(this);
                        return true;
                    } else if (cellBoard[x][y + 1] instanceof MonsterNexusCell) {
                        handleMovement(cellBoard,x,y,x,y+1);
                        ((MonsterNexusCell) cellBoard[x][y + 1]).eventHereHero(this);
                        return true;
                    }else if (cellBoard[x][y + 1] instanceof ObstacleCell){
                        System.out.println("You meet an Obstacle. Do you want to use one turn to remove this obstacle [Y/N]: ");
                        boolean answer = inputValidator.checkYesNoInput();
                        if(answer){
                            cellBoard[x][y + 1] = new PlainCell();
                            return true;
                        }
                        return false;
                    }
                    return false;
                }else if(cellBoard[x][y+1].getHeroInCell()!=null){
                    System.out.println("Another hero is in this space, you cannot go there.");
                    return false;
                }
                break;
            default:
                System.out.println("Invalid direction. Please use W, A, S, or D.");
                return false;
        }
        System.out.println("Your movement is invalid.");
        return false;
    }



    public void notifyHeroReachedNexus() {
        for (GameEventListener listener : listeners) {
            listener.onHeroReachedNexus(this);
        }
    }
    public void setSpawnPosition(int i, LegendsOfValorMap board) { //recall
        this.spawnRow = 7; // Assuming Nexus is always at row 7
        this.spawnCol = 1 + i * 3; // Assuming Nexus column based on hero index
        this.positionRow = this.spawnRow;
        this.positionCol = this.spawnCol;
        Cell[][] cellBoard = board.getMap();
        cellBoard[this.positionRow][this.positionCol].setHero(this);

    }

    // Method to recall the hero to their spawn position
    public void recall() {
        this.setPositionRow(this.spawnRow);
        this.setPositionCol(this.spawnCol);
        System.out.println("Hero has been recalled to the Nexus.");
    }

    public boolean teleport(LegendsOfValorMap board, Hero targetHero) {
        Cell[][] cellBoard = board.getMap();
        int x = this.getPositionRow();
        int y = this.getPositionCol();
        int myLane = getLane(this);
        int targetLane = targetHero.getLane(targetHero);

        if (myLane == targetLane) {
            System.out.println("Cannot teleport within the same lane.");
            return false;
        }

        int[] newPosition = board.getValidTeleportPosition(this, targetHero);


        if (newPosition == null) {
            System.out.println("No valid position for teleportation.");
            return false;
        }

        if (cellBoard[newPosition[0]][newPosition[1]] instanceof ObstacleCell){
            System.out.println("There is an Obstacle Space");
            return false;
        }
        this.setPositionRow(newPosition[0]);
        this.setPositionCol(newPosition[1]);
        cellBoard[x][y].heroLeave();

        cellBoard[newPosition[0]][newPosition[1]].setHero(this);


        return true;
    }

    private int getLane(Hero hero) {
        return positionCol/3;
    }


    public void attack(Monster monster) {
        int weaponDamage = 0;
        boolean answer = false;
        if(weapon != null){
            if(weapon.getRequiredHands() == 1){
                System.out.println(" Do you want to hold the weapon buy two hands: [N/Y]");
                answer = inputValidator.checkYesNoInput();

            }

            weaponDamage = weapon.getDamage();
            if (answer){
                weaponDamage = (int) (weaponDamage * 1.3); // two hand hold weapon ---stronger

            }
        }
        int damage = (int) (Math.round(strength + weaponDamage)*heroattackFactor);
        if(!monster.dodge()) {
            monster.takeDamage(damage , this );
        } else{
            System.out.println(name+ " attacks " + monster.getName());
            System.out.println(monster.getName() + " successfully dodges");
        }
    }


    public int getMoney() {
        return money;
    }

    public void buy(int cost,Item item) {

        money = money - cost;
        String type = null;
        System.out.println(name+" bought the item successfully!");
        if(item instanceof Potions){
            PotionsInventory.add((Potions)item);
            type = "Potions";
            printTradeResult(type,Potionstitle,PotionsInventory);
        }
        else if (item instanceof Spell) {
            SpellInventory.add((Spell) item);
            type = "Spells";
            printTradeResult(type,Spellstitle,SpellInventory);
        }else if (item instanceof Armor) {
            ArmorInventory.add((Armor)item);
            type = "Armors";
            printTradeResult(type,Armorstitle,ArmorInventory);
        }else if (item instanceof Weaponry) {
            WeaponryInventory.add((Weaponry)item);
            type = "Weapons";
            printTradeResult(type,Weaponstitle,WeaponryInventory);
        }


    }

    public Item sell(String type) {
        if(type.equals("Weapons")){

            printItemList(type,Weaponstitle,WeaponryInventory);
            return sellRemove(type,Weaponstitle,WeaponryInventory);
        }else if(type.equals("Armors")){

            printItemList(type,Armorstitle,ArmorInventory);
            return sellRemove(type,Armorstitle,ArmorInventory);
        }else if(type.equals("Potions")){

            printItemList(type,Potionstitle,PotionsInventory);
            return sellRemove(type,Potionstitle,PotionsInventory);
        }else if(type.equals("Spells")){

            printItemList(type,Spellstitle,SpellInventory);
            return sellRemove(type,Spellstitle,SpellInventory);
        }
        return null;
    }
    public void printTradeResult(String type,String title,ArrayList<Item> list){
        System.out.println("Your " + type + " inventory: ");
        printItemList(type,title,list);


        System.out.println(herotitle);
        System.out.println(toString());
    }


    public Item sellRemove(String type,String title,ArrayList<Item> list){
        int size = list.size();
        System.out.println("Enter [I] for hero info, [X] to change your mind if you don't want to sell anything, or select an option from 1-"+size+": ");
        int idnum = inputValidator.marketChecker("X");
        if (idnum == -1){
            System.out.println(printSingleHero());
            idnum =size+1;
        }

        while(idnum > size){
            System.out.println("Enter [I] for hero info, [X] to change your mind if you don't want to sell anything, or select an option from 1-"+size+": ");
            idnum = inputValidator.marketChecker("X");
            if (idnum == -1){
                System.out.println(printSingleHero());
                idnum = size+1;
            }
        }
        if(idnum != -2) {
            Item item = list.get(idnum - 1);
            list.remove(idnum - 1);
            heroAddMoney(item.getCost() / 2);
            System.out.println("You sold the item successfully!");
            System.out.println(getName() + " gained $" + item.getCost() / 2);

            printTradeResult(type, title, list);

            return item;
        }

        return null;

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

    public int getLevel() {
        return level;
    }


    public int getMana() {
        return mana;
    }


    public void setHP() {
        HP = level*levelHPFactor;
    }

    public void hasDamageWithArm(int damage) {

    }

    public void heroAddHP(int more){
        System.out.println(name+"'s HP increases "+more + "!");
        HP = HP + more;
        if(HP > getLevel()*100){
            HP = getLevel()*100;
            System.out.println("The hero has a HP limit which is "+ getLevel()*100 +", so its HP is "+ getLevel()*100 +" now!");
        }
/*        if(HP > level*level_HP_ratio){ // if it exceeds the upper bound, adjust it
            HP = level*level_HP_ratio;
        }*/
    }
    public void heroAddMana(int addMana){
        System.out.println(name+"'s mana increases "+addMana+ "!");
        mana =mana+ addMana;
    }

    public void setMana(int m){

        mana =m;
    }
    public void heroAddStrength(int addStrength){
        System.out.println(name+"'s Strength increases "+addStrength+ "!");
        strength =strength+ addStrength;
    }
    public void heroAddDexterity(int dex){
        System.out.println(name+"'s Dexterity increases "+dex+ "!");
        dexterity = dexterity+dex;
    }
    public void heroAddAgility(int agi){
        System.out.println(name+"'s Agility increases "+agi+ "!");
        agility = agility+ agi;
    }

    public void heroAddDefense(int Defen){
        System.out.println(name+"'s Defense increases "+Defen+ "!");
        Defense = Defense+ Defen;
    }

    public void heroAddMoney(int addMoney){
        money = money+addMoney;
    }

    public void heroAddExp(int addExp){
        experience = experience + addExp;

    }

    public void strengthIncrease(){

        strength = (int) Math.round(strength * levelSkillFactor);

    }
    public void agilityIncrease(){

        agility = (int) Math.round(agility * levelSkillFactor);

    }
    public void dexterityIncrease(){

        dexterity = (int) Math.round(dexterity * levelSkillFactor);

    }


    public void regainRound(){
        HP = (int) Math.round(HP* roundHPRegainFactor);
        mana = (int) Math.round(mana* roundMPRegainFactor);
        System.out.println(name+" regains HP! HP is "+HP+" now");
        System.out.println(name+" regains MP! MP is "+mana+" now");
    }

    @Override
    public boolean dodge() {
        Random random = new Random();
        return random.nextDouble() <= dodgeChance;

    }



    public void skillIncrease() {
        skillStrategy.skillIncrease(this);
    }

    public void levelUp(){
        if(experience >= level*levelFactor){
            System.out.println("*************************************************");
            experience = experience - level*levelFactor;
            level++;
            HP = level*levelHPFactor;
            mana = (int) Math.round(mana*levelManaFactor);
            skillIncrease();


        }

    }


    public String printSingleHero() {
        System.out.println(herotitle);
        return String.format("   %-20s %-10d %-10d %-10d %-10d %-10d %-10d %-13d %-13d",
                name, HP, level, mana, strength, agility, dexterity, money, experience);
    }



    @Override
    public String toString() {
        return String.format("   %-20s %-10d %-10d %-10d %-10d %-10d %-10d %-13d %-13d",
                name, HP, level, mana, strength, agility, dexterity, money, experience);
    }

    public void useSpell(Monster monster, int index){ // use spell
        Spell spell = (Spell) SpellInventory.get(index);
        // cost mana
        System.out.println("You are using a spell, and your mana is deducted. ");
        System.out.println("Before casting the spell, your mana is  "+mana);
        mana = mana - spell.getManaCost();
        System.out.println("After casting the spell, your mana is  "+mana);
        monster.getSpellAffect(spell);
        int spell_damage = (int) Math.round(2*heroattackFactor*(spell.getDamage() + spell.getDamage()*(dexterity/spellDamageFactor))); // calculate spell damage
        monster.takeDamage(spell_damage, this );
        boolean runOut = (spell.getRestUseTime()-1) <= 0;
        System.out.println("This Spell can continue to be used "+(spell.getRestUseTime()-1)+" times.");
        if (runOut){
            SpellInventory.remove(index);
            System.out.println("The spell is run out. It is removed from your inventory.");
        }


    }

    public void usePotion(int index){
        PotionsInventory.remove(index);
    }


    public void equip(Item item) {
        if(item instanceof Weaponry){
            if(weapon != null){
                //WeaponryInventory.add(weapon);

                System.out.println(name + "'s old weapon "+ weapon.getName()+" is removed. " );
            }
            weapon = (Weaponry) item;
            System.out.println(weapon.getName() + " is equipped!");
        }else if(item instanceof Armor){
            if(Arm != null){
                //ArmorInventory.add(Arm);

                System.out.println(name + "'s old armor "+ Arm.getName()+" is removed. " );
            }
            Arm = (Armor) item;
            System.out.println(Arm.getName() + " is using.");
        }
    }

    public void takeDamage(int damage, Monster monster) {
        int reduction = 0;
        //check using armor
        if(Arm != null){
            reduction = Arm.getDefense();
        }
        int realdamage = (int) ((damage-reduction)*mosnterattackFactor);
        realdamage = Math.max(0, realdamage); // cannot lower than 0
        HP = HP - realdamage;
        if(HP<0){
            HP = 0;
        }

        System.out.println(monster.getName()+ " attacks "+name+ " " + realdamage +" damage!");
        System.out.println(name+ " has "+ HP+ " HP.");

        if(!isAlive()){
            System.out.println(name+" dies.");
        }
    }

    public void setMarker( int index){
        setHeroNum(index+1);
        int heroNum = index + 1;
        heroMark = "H" + heroNum;
    }
    public void setHeroNum( int index){
        HeroIndex = index;
    }

    public int getHeroNum(){
        return HeroIndex;
    }

    public String getMarker(){
        return heroMark;
    }

    public void setStartPosition(int i){
        positionRow = 7;
        positionCol = 1+i*3;
    }
    public void setPositionCol(int c){
        positionCol = c;
    }

    public void setPositionRow(int r){
        positionRow = r;
    }

    public int getPositionCol(){
        return positionCol;
    }

    public int getPositionRow(){
        return positionRow;
    }

    public int getDexterity(){
        return dexterity;
    }

    public int getAgility(){
        return agility;
    }
    public int getStrength(){
        return strength;
    }

    public boolean isAlive(){
        return HP>0;
    }




    public void setSkillStrategy(SkillStrategy skillStrategy) {
        this.skillStrategy = skillStrategy;
    }

    public void addGameEventListener(GameEventListener listener) {
        listeners.add(listener);
    }

}
