package Map;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import InputAndReader.InputValidator;
import Cell.BushCell;
import Character.Hero;
import Character.Monster;
import Cell.CaveCell;

import Cell.Cell;
import Cell.HeroNexusCell;
import Cell.inaccessibleCell;
import Cell.KoulouCell;
import Cell.MonsterNexusCell;
import Cell.ObstacleCell;
import Cell.PlainCell;



public class LegendsOfValorMap implements map{

    private final int col;
    private final int row;
    private final int koulouNum;
    private final int obstacleNum;
    private final int plainNum;
    private final int bushNum;
    private final int caveNum;


    private Cell[][] cellBoard;
    private int partyCol;
    private int partyRow;
    private int cellNum;
    InputValidator inputValidator = new InputValidator();
    private List<Cell> allCell;



    public LegendsOfValorMap(){
        col = 8;
        row = 8;
        koulouNum = 6;
        obstacleNum = 6;
        plainNum = 12;
        bushNum = 6;
        caveNum = 6;
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
    public int getLane(int row) { //teleport
        // Assuming each row represents a different lane
        return row;
    }

    public boolean canTeleportTo(Hero teleportingHero, int targetRow, int targetCol) {
        // Ensure not teleporting ahead of the target hero
        //if (teleportingHero.getPositionRow() <= targetRow) return false;
        if(targetCol <0 || targetCol>7) return false;

        // Ensure not teleporting to an occupied cell
        Cell targetCell = cellBoard[targetRow][targetCol];
        if (targetCell.getHeroInCell() != null || targetCell.getMonsterInCell() != null) return false;

        // Ensure not teleporting to an inaccessible cell
        if (targetCell instanceof inaccessibleCell) return false;

        return true;
    }

    public int[] getValidTeleportPosition(Hero teleportingHero, Hero targetHero) {
        int targetRow = targetHero.getPositionRow();
        int targetCol = targetHero.getPositionCol();

        // Check positions around the target hero for a valid teleport position
        int[][] potentialPositions = {
            {targetRow, targetCol - 1},  // Left of the target
            {targetRow, targetCol + 1},  // Right of the target
            {targetRow + 1, targetCol}   // Behind the target
        };

        for (int[] pos : potentialPositions) {
            if (canTeleportTo(teleportingHero, pos[0], pos[1])) {
                return pos; // Return the first valid position found
            }
        }

        return null; // No valid position found
    }

    public void randomMap() throws FileNotFoundException {
        cellBoard = new Cell[row][col];
        allCell = new ArrayList<Cell>();

        for(int i = 0; i < caveNum; i++){
            allCell.add(new CaveCell());
        }
        for(int i = 0; i < koulouNum; i++){
            allCell.add(new KoulouCell());
        }
        for(int i = 0; i < plainNum; i++){
            allCell.add(new PlainCell());
        }
        for(int i = 0; i < obstacleNum; i++){
            allCell.add(new ObstacleCell());
        }
        for(int i = 0; i < bushNum; i++){
            allCell.add(new BushCell());
        }

        Collections.shuffle(allCell);
        int i = 0;
        for (int r = 0; r < col; r++){
            for(int c = 0; c < row; c++){
                if(c == 2 || c ==5){
                    cellBoard[r][c] = new inaccessibleCell();
                }
                else{
                    if(r==0){
                        cellBoard[r][c] = new MonsterNexusCell();
                    }
                    else if(r==7){
                        cellBoard[r][c] = new HeroNexusCell();
                    }
                    else{
                        if (cellBoard[r][c] == null) {
                            cellBoard[r][c] = allCell.get(i++);

                        }
                    }
                }
            }
        }



    }




    @Override
    public String toString() {
        StringBuilder mapBuilder = new StringBuilder();
        for (int i = 0; i < col; i++) {
            StringBuilder spaceType = new StringBuilder();
            StringBuilder characterLine = new StringBuilder();
            for (int j = 0; j < row; j++) {
                String symbol = cellBoard[i][j].getSpaceType();
                spaceType.append(" ").append(symbol).append("-").append(symbol).append("-").append(symbol).append(" ");
                characterLine.append("|").append(cellBoard[i][j].characterMarker()).append("|");
            }
            mapBuilder.append(spaceType).append("\n").append(characterLine).append("\n").append(spaceType).append("\n");
        }
        return mapBuilder.toString();
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

    public Cell getMonsterCell(Monster m){

        return cellBoard[m.getPositionRow()][m.getPositionCol()];
    }
    public Cell getHeroCell(Hero h){


        return cellBoard[h.getPositionRow()][h.getPositionCol()];
    }


    public static void main(String[] args) throws FileNotFoundException { // for test
        LegendsOfValorMap m = new LegendsOfValorMap();
        m.randomMap();
        System.out.println(m);
    }

    public Cell getPositionCell(int x, int y) {

        return cellBoard[x][y];

    }
}
