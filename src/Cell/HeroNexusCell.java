package Cell;
import java.io.FileNotFoundException;
import Party.Party;
import Character.Hero;
import InputAndReader.InputValidator;
public class HeroNexusCell extends Cell{

    private final String symbol = "\u001b[34m" + "N" + "\u001B[0m";
    InputValidator inputValidator = new InputValidator();

    Market market;
    public HeroNexusCell() throws FileNotFoundException {
        market = new Market();
    }

    @Override
    public String getSpaceType(){

        return symbol;

    }


    public void eventHereHero(Hero h){

        System.out.println(h.getName()+" is at the Nexus! ");
        System.out.println("Would you like to enter the market? (Y/N): ");
        boolean enter = inputValidator.checkYesNoInput();
        if(enter){
            market.heroEnterMarket(h);
        }
    }


}
