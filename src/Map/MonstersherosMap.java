
package Map;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import InputAndReader.InputValidator;


import Cell.Cell;

import Cell.commonCell;
import Cell.inaccessibleCell;
import Cell.marketCell;

public class MonstersherosMap implements map{

    private final int col;
    private final int row;
    private final double inaccessibleRate;
    private final double marketRate;

    private Cell[][] cellBoard;
    private int partyCol;
    private int partyRow;
    private int cellNum;
    InputValidator inputValidator = new InputValidator();
    private List<Cell> allCell;



    public MonstersherosMap(){
        col = 8;
        row = 8;
        inaccessibleRate = 0.2;
        marketRate = 0.3;
        partyCol = 0;
        partyRow = 0;

        cellNum = col*row;
    }

    public Cell[][] getMap() {
        return cellBoard;

    }

    public int getPartyCol() {
        return partyCol;

    }

    public int getPartyRow() {
        return partyRow;

    }
    public int getCol() {
        return col;

    }

    public int getRow() {
        return row;

    }

    public void randomMap() throws FileNotFoundException {
        cellBoard = new Cell[row][col];
        allCell = new ArrayList<Cell>();

        for(int i = 0; i < cellNum*inaccessibleRate; i++){
            allCell.add(new inaccessibleCell());
        }
        for(int i = 0; i < cellNum*marketRate; i++){
            allCell.add(new marketCell());
        }
        for(int i = 0; allCell.size() <= cellNum-1; i++){
            allCell.add(new commonCell());
        }

        Collections.shuffle(allCell);

        // Set the startCell at position (0,0)
        cellBoard[partyCol][partyRow] = new Cell();
        cellBoard[partyCol][partyRow].setPlayerCell();

        // Fill the rest of the world with cells from the pool
        int i = 0;
        for (int y = 0; y < row; y++) {
            for (int x = 0; x < col; x++) {
                    if (cellBoard[y][x] == null) {
                        cellBoard[y][x] = allCell.get(i++);

                }
            }
        }

        System.out.println(toString());
        resetMap();



    }
    public void resetMap() throws FileNotFoundException {
        System.out.println("In this map, P means where the party is, M spaces are Market spaces, X spaces are Inaccessible spaces, and all other empty cells are common spaces. ");
        System.out.println("Are you satisfied with the map? (Y/N): ");

        boolean isSatisfied = inputValidator.checkYesNoInput();
        if(!isSatisfied){
            randomMap();
        }

    }





@Override
public String toString() {
    StringBuilder map = new StringBuilder();
    String topLine = "";

    //top line of the map
    for (int i = 0; i < col; i++) {
        topLine += "+---";
    }
    topLine += "+\n";

    // each line of the map
    for (int y = 0; y < row; y++) {
        map.append(topLine); // top line
        String currentline = "";
        for (int x = 0; x < col; x++) {
            currentline += "| " + cellBoard[y][x].toString() + " ";
        }
        currentline += "|\n";

        map.append(currentline);
    }

    // bottom line
    map.append(topLine);

    return map.toString();
}

    public Cell currentCell() {

        return cellBoard[partyRow][partyCol];
    }
    @Override
    public boolean move(char direction) {
        switch (direction) {
            case 'W': return move_up();
            case 'A': return move_left();
            case 'S': return move_down();
            case 'D': return move_right();
            default:
                System.out.println("Invalid direction. Please use W, A, S, or D.");
                return false;
        }
    }
    @Override
    public boolean move_up() {
        if (partyRow - 1 < 0 || cellBoard[partyRow - 1][partyCol] instanceof inaccessibleCell) {
            System.out.println("Your movement is invalid.");
            return false;
        }
        performMove(-1, 0);
        return true;
    }
    @Override
    public boolean move_down() {
        if (partyRow + 1 >= row || cellBoard[partyRow + 1][partyCol] instanceof inaccessibleCell) {
            System.out.println("Your movement is invalid.");
            return false;
        }
        performMove(1, 0);
        return true;
    }
    @Override
    public boolean move_left() {
        if (partyCol - 1 < 0 || cellBoard[partyRow][partyCol - 1] instanceof inaccessibleCell) {
            System.out.println("Your movement is invalid.");
            return false;
        }
        performMove(0, -1);
        return true;
    }
    @Override
    public boolean move_right() {
        if (partyCol + 1 >= col || cellBoard[partyRow][partyCol + 1] instanceof inaccessibleCell) {
            System.out.println("Your movement is invalid.");
            return false;
        }
        performMove(0, 1);
        return true;
    }


    @Override
    public void performMove(int rowDelta, int colDelta) {
        cellBoard[partyRow][partyCol].partyLeave();
        partyRow += rowDelta;
        partyCol += colDelta;
        cellBoard[partyRow][partyCol].setPlayerCell();
    }


    public static void main(String[] args) throws FileNotFoundException { // for test
        MonstersherosMap m = new MonstersherosMap();
        m.randomMap();
        System.out.println(m);
    }
}
