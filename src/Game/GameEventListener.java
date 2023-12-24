package Game;

import Character.Hero;
import Character.Monster;


public interface GameEventListener {    //an observer interface to check game win
    void onHeroReachedNexus(Hero hero);
    void onMonsterReachedNexus(Monster monster);
}
