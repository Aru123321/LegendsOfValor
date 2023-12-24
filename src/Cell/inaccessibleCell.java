package Cell;
import Party.Party;
public class inaccessibleCell extends Cell{
    private final String symbol = "X";
    private final String symbol_V = "\u001b[31m" + "I" + "\u001B[0m";
    private boolean PlayerInCell = false;

    @Override
    public void enterCell(Party party) {
        throw new IllegalStateException("Cannot enter an inaccessible cell.");
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
    public String getSpaceType(){

        return symbol_V;

    }

}
