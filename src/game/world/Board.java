package game.world;

import game.HeroAndMonster;
import game.world.cell.Cell;
import utils.*;

public class Board {

    private Cell[] [] board;
    private int boardSize;
    private int currRow;
    private int currCol;
    private HeroAndMonster game;

    public Board(int boardSize, HeroAndMonster game){
        this.boardSize = boardSize;
        board = new Cell[boardSize][boardSize];
        this.game = game;
    }

    public void setCell(int i, int j, Cell cell){
        board[i][j] = cell;
    }

    public boolean isCommon(int i, int j){
        return board[i][j].isCommon();
    }

    /**
     * print the board
     */
    public void printBoard(){
        printUtil.print();
        printUtil.println("                 BOARD");
        printUtil.printBoundary();
        for(int i=0; i<boardSize; i++){
            for(int j=0; j<boardSize; j++){
                if(i==currRow && j==currCol){
                    board[i][j].printCell("✵");
                }else{
                    board[i][j].printCell();
                }
            }
            printUtil.println("");
            printUtil.printBoundary();
        }

        printUtil.printWhiteBackground(" ");
        printUtil.print(": Common Space");

        printUtil.printGreenBackground("$");
        printUtil.print(": Market Space");

        printUtil.printBlueBackground("X");
        printUtil.print(": Inaccessible Space ");

        printUtil.printSingle("|  ✵  |");
        printUtil.print(": You are here!");

    }

    public void setCurrPos(int i, int j){
        currRow = i;
        currCol = j;
    }

    public void printBoardMenu(){

        printUtil.printBoundary();

        printUtil.printDotBoundary("Menu");
        printUtil.printYellow("(W/w) Move up");
        printUtil.printYellow("(A/a) Move left");
        printUtil.printYellow("(S/s) Move down");
        printUtil.printYellow("(D/d) Move right");
        printUtil.printYellow("(B/b) Open bag");

        printUtil.printYellow("(I/i) Show info");
        printUtil.printYellow("(Q/q) Quit");
        printUtil.print();

    }

    public void printMarketOpt(){
        printUtil.printYellow("There is a Market!");
        printUtil.printBoundary();
        printUtil.printYellow("(Y/y) Enter");
        printUtil.printYellow("(I/i) Show team info");
        printUtil.printYellow("(C/c) Continue");

        printUtil.printYellow("(Q/q) Quit the game");
        printUtil.print();

    }
    
    public boolean isMarket(){
        return board[currRow][currCol].isMarket();
    }

    public void processMarket(){
        printMarketOpt();
        while(true){

            String choice = scannerUtil.readLine("Your choice:");
            if(choice.equalsIgnoreCase("c")){
                return;
            }else if(choice.equalsIgnoreCase("y")){
                board[currRow][currCol].processOption();
                return;
            }else if(choice.equalsIgnoreCase("q")){
                game.setOver();
                return;
                
            }else if(choice.equalsIgnoreCase("i")){
                game.printInfo();
                
            }else{
                printUtil.printError("Invalid command!");
            }
            printMarketOpt();

        }
    }
    public boolean canMove(int i, int j){
        if(board[i][j].isInaccessible()){
            printUtil.printError("You aim to move to an inaccessible cell");
            return false;

        }

        return true;

    }

    public void move(int i, int j){
        currRow = i;
        currCol = j;
    }

    public Cell getCell(int i, int j){
        return board[i][j];
    }
}
