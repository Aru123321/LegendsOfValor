package Game;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import InputAndReader.InputValidator;


import Cell.Cell;

import Cell.commonCell;

import Map.MonstersherosMap;
import Party.Party;



public class MonstersHerosGame extends roundGame {
    InputValidator inputValidator = new InputValidator();
    private Party party;


    private MonstersherosMap map;
    int result;
    public MonstersHerosGame() throws FileNotFoundException {

        map = new MonstersherosMap();
        party = new Party();
        result = 1;
    }

    @Override
    public void startGame() throws FileNotFoundException {
        welcomeText();
        party.createParty();
        map.randomMap();

        //game start
        //round
        System.out.println();
        System.out.println("Reminder you can quit the game if you enter [Q] at any time. ");
        System.out.println("Reminder hero can attack more if he or she hold the weapon by two hands. ");
        System.out.println();
        System.out.println("************************************");
        System.out.println("Game Start! ");


        while(result != 0){

            System.out.println(map.toString());
            System.out.println("In which direction will the party go?");
            System.out.print("Please enter your move (W for up, A for left, S for down, D for right): ");
            char direction = inputValidator.checkMovementInput();
            boolean canMove = map.move(direction);
            while(!canMove){
                System.out.print("Please enter your move (W for up, A for left, S for down, D for right): ");
                direction = inputValidator.checkMovementInput();
                canMove = map.move(direction);
            }
            System.out.println(map.toString());
            Cell currentCell = map.currentCell();
            currentCell.eventHere(party);


            if (currentCell instanceof commonCell){
                result = ((commonCell) currentCell).getbattleResult();
            }

            System.out.println("This round ends. Let's keep exploring the world！Reminder you can quit the game if you enter [Q] at any time. ");
            //System.out.println("If you want to quit, enter [Q]. If not, enter anything else.");
            //play = inputValidator.checkContinueGame();

        }





    }


    public void welcomeText(){
        System.out.println("*************************************************");
        System.out.println("     Welcome to Legends: Monsters and Heroes ");
        System.out.println("*************************************************");

        System.out.println("The monsters and heroes live in a fictional world. They do not get along and therefore fight each other.\n" +
                "Every time the heroes win, they gain experience and money. Heroes use the money to buy a variety of\n" +
                "items to aid them in their battles with the monsters. When they accumulate enough experience, they\n" +
                "level up, which improves their skills. The goal of the game is for the heroes to defeat monsters and level\n" +
                "up indefinitely.");


    }


}
