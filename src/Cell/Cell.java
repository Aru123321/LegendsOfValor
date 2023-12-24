package Cell;
import java.io.FileNotFoundException;
import Character.Hero;
import Character.Monster;
import Party.Party;
public class Cell {
    protected boolean accessible;
    private Hero hero;
    private Monster monster;
    private final String symbol = " ";
    protected final String playerSymbol = "P";
    private boolean PlayerInCell = false;




    public void enterCell(Party party) {

        System.out.println("You are at (0,0).");
    }

    public void setPlayerCell(){
        PlayerInCell = true;

    }

    public void partyLeave(){
        PlayerInCell = false;
    }

    public boolean playerHere() {

        return PlayerInCell;
    }

    public String getSpaceType() {
        return " ";
    }

    //start point
    public String toString(){
        if(playerHere()) {
            return playerSymbol;
        }
        return " ";
    }

    public void eventHere(Party p) throws FileNotFoundException {
        System.out.println("This space does not have event! ");
    }

    public String characterMarker() {
        StringBuilder markerBuilder = new StringBuilder();

        if (hero != null) {
            markerBuilder.append(hero.getMarker());
        } else {
            markerBuilder.append("  ");
        }

        markerBuilder.append(" "); // Adding space between hero and monster markers

        if (monster != null) {
            markerBuilder.append(monster.getMarker());
        } else {
            markerBuilder.append("  ");
        }

        return markerBuilder.toString();
    }

    public Hero getHeroInCell() {
        return hero;
    }

    public Monster getMonsterInCell() {
        return monster;
    }



    public void setHero(Hero h) {
        hero = h;
    }

    public void setMonster(Monster m) {
        monster = m;
    }

    public void heroLeave() {
        hero = null;
    }
    public void monsterLeave() {
        monster = null;
    }

}
