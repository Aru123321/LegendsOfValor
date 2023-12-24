package Cell;
import java.io.FileNotFoundException;
import Party.Party;
import Character.Hero;
public class PlainCell extends Cell{

    private final String symbol = "P";




    @Override
    public String getSpaceType(){

        return symbol;

    }


    public void eventHereHero(Hero h) {

        System.out.println("You are at the Plain Space! ");
    }


}
