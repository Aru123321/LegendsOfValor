package Character;

import Game.GameEventListener;
import Item.Spell;

public interface MonsterCharacter {

    public void getSpellAffect(Spell spell);
    public void takeDamage(int damage , Character hero) ;

    public void attack(Hero h) ;



    public String printMonster() ;
    public void setMarker( int index);

    public String getMarker();

    public void setPositionRow(int r);

    public int getPositionCol();

    public int getPositionRow();

    public void setStartPosition(int i);
    public void setMonDie();

    public boolean MonAlive();

     void notifyMonsterReachedNexus(Monster monster) ;


}
