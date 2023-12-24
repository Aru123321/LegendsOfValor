package Cell;

import java.io.FileNotFoundException;
import Party.Party;
import Character.Hero;
public class CaveCell extends Cell{

    private final String symbol = "\u001b[35m" + "C" + "\u001B[0m";
    private final double agilityCaveFactor = 0.1;
    private int agilityAdd;



    @Override
    public String getSpaceType(){

        return symbol;

    }


    public void eventHereHero(Hero h) {

        System.out.println(h.getName() + " are at the Cave Space! You can get bonus: ");
        agilityAdd = (int)(agilityCaveFactor*h.getAgility());
        System.out.println(h.getName() +"'s original agility is "+ h.getAgility() +"now");// test
        h.heroAddAgility(agilityAdd);
        System.out.println(h.getName() +"'s agility is "+ h.getAgility() +"now");// test

    }

    public void leaveSpace(Hero h) {
        System.out.println(h.getName() + " left Cave Space! ");
        h.heroAddAgility(-1 * agilityAdd);
        System.out.println(h.getName() +"'s agility is "+ h.getAgility() +"now");// test

    }


}
