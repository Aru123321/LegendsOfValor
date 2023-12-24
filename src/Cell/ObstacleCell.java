package Cell;
import java.io.FileNotFoundException;
import Party.Party;
import Character.Hero;
public class ObstacleCell extends Cell{

    private final String symbol = "\u001b[31m" + "O" + "\u001B[0m";
    private boolean hasObstacle = false;


    @Override
    public String getSpaceType(){

        return symbol;

    }

    public boolean spaceHasObstacle(){

        return hasObstacle;

    }

    public void setNoObstacle(){

        hasObstacle = true;

    }

//   if the charcter enter the space, the space already was changed to plain space

//    public void eventHere(Hero h) {
//
//        System.out.println("You are at the Obstacle Space! ");
//    }


}
