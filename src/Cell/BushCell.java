package Cell;
import java.io.FileNotFoundException;
import Party.Party;
import Character.Hero;
public class BushCell extends Cell{

    private final String symbol = "\u001b[32m" + "B" + "\u001B[0m";
    private final double dexBushFactor = 0.1;

    private int dexAdd;




    @Override
    public String getSpaceType(){

        return symbol;

    }



    public void eventHereHero(Hero h) {
        System.out.println(h.getName() + " are at the Bush Space! You can get bonus: ");
        dexAdd = (int)(dexBushFactor*h.getDexterity());

        System.out.println(h.getName() +"'s original Dexterity is "+ h.getDexterity() +" now");// test
        h.heroAddDexterity(dexAdd);
        System.out.println(h.getName() +"'s Dexterity is "+ h.getDexterity() +" now");// test

    }

    public void leaveSpace(Hero h) {
        System.out.println(h.getName() + " left Bush Space! ");
        h.heroAddDexterity(-1 * dexAdd);
        System.out.println(h.getName() +"'s Dexterity is "+ h.getDexterity() +" now");// test

    }




}
