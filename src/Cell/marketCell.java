package Cell;
import java.io.FileNotFoundException;
import InputAndReader.InputValidator;

import Party.Party;


public class marketCell extends Cell{
    private final String symbol = "M";
    private boolean PlayerInCell = false;
    InputValidator inputValidator = new InputValidator();
    Market market;


    public marketCell() throws FileNotFoundException {
        market = new Market(); // Each cell has its own unique market
    }


    @Override
    public void enterCell(Party party) {

        System.out.println("Welcome to the market!");
    }

    @Override
    public void setPlayerCell(){
        PlayerInCell = true;

    }
    @Override
    public void partyLeave(){
        PlayerInCell = false;

    }
    @Override
    public boolean playerHere() {

        return PlayerInCell;
    }

    @Override
    public String toString(){
        if(playerHere()) {
            return playerSymbol;
        }
        return symbol;
    }
    @Override
    public void eventHere(Party p) {
        System.out.println("You are at the marketplace! Would you like to enter the market? (Y/N): ");
        boolean enter = inputValidator.checkYesNoInput();
        if(enter){
            market.EnterMarket(p);
        }

    }

}
