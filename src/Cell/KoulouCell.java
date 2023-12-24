package Cell;
import java.io.FileNotFoundException;
import Party.Party;
import Character.Hero;
public class KoulouCell extends Cell{

    private final String symbol =  "\u001b[33m" + "K" + "\u001B[0m";
    private final double strengthCaveFactor = 0.1;
    private int strengthAdd;




    @Override
    public String getSpaceType(){

        return symbol;

    }

    public void eventHereHero(Hero h) {
        System.out.println(h.getName() + " are at the Koulou Space! You can get bonus: ");
        strengthAdd = (int)(strengthCaveFactor*h.getStrength());
        System.out.println(h.getName() +"'s original strength is "+ h.getStrength() +"now");// test
        h.heroAddStrength(strengthAdd);
        System.out.println(h.getName() +"'s strength is "+ h.getStrength() +"now");// test

    }

    public void leaveSpace(Hero h) {
        System.out.println(h.getName() + " left Koulou Space! ");
        h.heroAddStrength(-1 * strengthAdd);
        System.out.println(h.getName() +"'s strength is "+ h.getStrength() +"now");// test

    }

}
