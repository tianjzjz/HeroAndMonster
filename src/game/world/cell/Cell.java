package game.world.cell;

/**
 *  an interface for all cells in the board
 */
public interface Cell {

    // check type of current cell
    boolean isInaccessible();
    boolean isMarket();
    boolean isCommon();

    // print
    void printCell();
    void printCell(String s);
    
    // do action on this cell
    void processOption();
    
}
