package Character;

import Cell.Cell;
import Game.GameEventListener;
import Item.Item;
import Map.LegendsOfValorMap;

import java.util.ArrayList;
import java.util.Random;

public interface HeroCharacter {



    // x is original positionRow, y is original positionCol,
    // nx is the new positionRow of movement, ny is the new positionCol of movement
    public void handleMovement(Cell[][] cellBoard, int x, int y, int nx, int ny);
    public boolean moveHero(LegendsOfValorMap board, String direction) ;




    public void setSpawnPosition(int i, LegendsOfValorMap board);

    // Method to recall the hero to their spawn position
    public void recall() ;
    public boolean teleport(LegendsOfValorMap board, Hero targetHero) ;


    public void attack(Monster monster);


    public int getMoney();

    public void buy(int cost,Item item) ;

    public Item sell(String type) ;
    public void printTradeResult(String type,String title,ArrayList<Item> list);

    public Item sellRemove(String type,String title,ArrayList<Item> list);
    public void printItemList(String TypeName, String title, ArrayList<? extends Item> List) ;
    public int getLevel();


    public int getMana();


    public void setHP();

    public void hasDamageWithArm(int damage) ;
    public void heroAddHP(int more);
    public void heroAddMana(int addMana);

    public void setMana(int m);
    public void heroAddStrength(int addStrength);
    public void heroAddDexterity(int dex);
    public void heroAddAgility(int agi);

    public void heroAddDefense(int Defen);

    public void heroAddMoney(int addMoney);
    public void heroAddExp(int addExp);

    public void strengthIncrease();
    public void agilityIncrease();
    public void dexterityIncrease();


    public void regainRound();


    public void skillIncrease() ;




    public String printSingleHero() ;

    public void useSpell(Monster monster, int index);

    public void usePotion(int index);


    public void equip(Item item) ;

    public void takeDamage(int damage, Monster monster);

    public void setMarker( int index);
    public void setHeroNum( int index);

    public int getHeroNum();

    public String getMarker();

    public void setStartPosition(int i);

    public void setPositionCol(int c);

    public void setPositionRow(int r);

    public int getPositionCol();

    public int getPositionRow();

    public int getDexterity();

    int getAgility();
    int getStrength();

    boolean isAlive();


     void setSkillStrategy(SkillStrategy skillStrategy);

     void addGameEventListener(GameEventListener listener);

     void notifyHeroReachedNexus() ;
}
