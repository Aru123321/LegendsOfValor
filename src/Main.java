import java.io.FileNotFoundException;
import Game.MonstersHerosGame;
import Game.LegendsOfValorGame;
import InputAndReader.InputValidator;
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        InputValidator validator = new InputValidator();
            System.out.println("Do you want to play 1. <Monsters and Heroes Game> or 2. <Legends Of Valor Game> ? Please enter 1 or 2:");
            int gameNum = validator.promptPositiveInteger();
            while (gameNum >2){
                System.out.println("Your input is invalid. Please enter 1 or 2:");
                gameNum = validator.promptPositiveInteger();
            }
            if(gameNum == 1){
                MonstersHerosGame game = new MonstersHerosGame();
                game.startGame();
            }else if(gameNum == 2){
                LegendsOfValorGame game = new LegendsOfValorGame();
                game.startGame();
            }



    }
}