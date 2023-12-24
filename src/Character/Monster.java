package Character;
import java.util.Random;
import java.util.List;
import Game.GameEventListener;
import Item.Spell;
import Item.FireSpell;
import Item.IceSpell;
import Item.LightningSpell;
import java.util.ArrayList;
public class Monster extends Character implements MonsterCharacter{
    private int positionCol;
    private int positionRow;
    private final int levelHPFactor = 100;
    private final double dodgeChancefactor = 0.01;
    private final double defensefactor = 0.01;
    private String MonsterMark;
    private boolean alive = true;
    private int monsterIndex;
    private List<GameEventListener> listeners = new ArrayList<>();

    private final double spellFactor = 0.1;
    protected double dodgeChance;
    protected int damage;
    protected int defense;


    Monster(String n, int l, int dama, int den, int dodge){
        name = n;
        level = l;
        damage = dama;
        defense = (int) (den * defensefactor);
        dodgeChance = dodge * dodgeChancefactor;
        HP = level * levelHPFactor;
    }

    @Override
    public boolean dodge() {
        Random random = new Random();
        return random.nextDouble() <= dodgeChance;

    }

    public void addGameEventListener(GameEventListener listener) {
        listeners.add(listener);
    }
    public void getSpellAffect(Spell spell){
        int damageSpell = (int) Math.round(spell.getDamage()*spellFactor);
        if(spell instanceof IceSpell){
            System.out.println("Before using Ice spell, monster's damage is "+damage);
            damage = damage- damageSpell;

            if(damage<0){
                damage = 0;
            }

            System.out.println(String.format("%s use ice spell to %s", this.getName(), name));
            System.out.println(String.format("%s's base damage value decrease to %s by ice spell", name, damage));
        }
        if(spell instanceof FireSpell){
            System.out.println("Before using fire spell, monster's defense is "+defense);
            defense = (int)(defense - damageSpell*0.1); // reduces the defense of the target

            if(defense<0){
                defense = 0;
            }


            System.out.println(String.format("%s use fire spell to %s", this.getName(), name));
            System.out.println(String.format("%s's base defense value decrease to %s by fire spell", name, defense));
        }
        if(spell instanceof LightningSpell){
            System.out.println("Before using Ice spell, monster's dodge Chance is "+dodgeChance);
            dodgeChance = dodgeChance -  damageSpell* dodgeChancefactor;

            if(dodgeChance<0){
                dodgeChance = 0;
            }

            System.out.println(String.format("%s use lighting spell to %s", this.getName(), name));
            System.out.println(String.format("%s's base dodge chance decrease to %s by lighting spell", name, dodgeChance));
        }

    }
    public void takeDamage(int damage , Character hero) { // monster take damage

        damage = damage - defense;
        damage = Math.max(0 , damage);
        HP = HP - damage;
        if(HP<0){
            HP = 0;
        }
        System.out.println(hero.getName()+ " attacks "+name+ " and take " + damage +" damage!");
        System.out.println(name + " has only "+ HP+ " HP ");

        if(!isAlive()){
            System.out.println(name+" dies.");
        }
    }

    public void attack(Hero h) {
        if(!h.dodge()){
            h.takeDamage(damage, this);
        }
        else{
            System.out.println(h.getName()+" dodges successfully.");
        }
    }



    public String printMonster() {
        return String.format("   %-20s %-10d %-10d %-10d %-10d %-10.2f",
                name, HP, level, damage, defense, dodgeChance);
    }


    public void setMarker( int index){
        int heroNum = index + 1;
        setMonsterNum(index+1);
        MonsterMark = "M" + heroNum;
    }

    public void setMonsterNum( int index){
        monsterIndex = index;
    }

    public int getMonsterNum(){
        return monsterIndex;
    }

    public String getMarker(){
        return MonsterMark;
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

    public void setStartPosition(int i){
        i = i%3;
        positionRow = 0;
        positionCol = 1+i*3;
    }

    public void setMonDie(){
        alive  = false;
    }

    public boolean MonAlive(){
        return alive;
    }

    public void notifyMonsterReachedNexus(Monster monster) {

        for (GameEventListener listener : listeners) {
            listener.onMonsterReachedNexus(monster);
        }
    }

}
