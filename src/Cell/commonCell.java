package Cell;
import java.io.FileNotFoundException;
import Party.Party;
public class commonCell extends Cell{

    private double occur_probability;
    private int result = -1;
    private final String symbol = " ";
    private boolean PlayerInCell = false;
    public commonCell(){
        occur_probability = 0.5;
    }


    @Override
    public void enterCell(Party party) {

        if (isBattleTriggered()) {
            System.out.println("A battle has started!");
        } else {
            System.out.println("It's peaceful here...");
        }
    }

    private boolean isBattleTriggered() {
        System.out.println("You are visiting a common tile.");
        System.out.println("You have 50% chance that you will engage in a battle with the monsters.");
        System.out.println("...");
        //simulate a dice roll
        double chance = Math.random(); // Rolls a 0.0 to 1.0
        double battleProbability = occur_probability; // For example, a 10% chance of battle.
        return chance < battleProbability;
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
    public void eventHere(Party p) throws FileNotFoundException {

        System.out.println("You are at the commonplace! ");
        if (Math.random() < 0.5) {
            System.out.println("Your party meets a group of monsters here! ");
            Battle battle = new Battle();
            int result = battle.start(p);
            battleResult(result);
            System.out.println("Battle end");
            System.out.println(result);

        }
        System.out.println("No monsters here! ");

    }

    public void battleResult(int r){
        result = r;

    }

    public int getbattleResult(){
        return result;

    }

}
