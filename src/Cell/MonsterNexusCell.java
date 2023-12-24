package Cell;
import java.io.FileNotFoundException;
import Party.Party;
import Character.Hero;
public class MonsterNexusCell extends Cell{

    private final String symbol = "\u001b[34m" + "N" + "\u001B[0m";


    @Override
    public String getSpaceType(){

        return symbol;

    }


    public void eventHereHero(Hero h){

        System.out.println(h.getName()+" is at the Monster's Nexus! Congratulation!!");
    }


}
