package game.world.cell;

import game.HeroAndMonster;
import utils.printUtil;

/**
 * an inaccessible cell class for all the cells that are inaccessible
 */
public class InaccessibleCell extends AbstractCell {

    

    public InaccessibleCell(HeroAndMonster game){
        super(game);

    }

    @Override
    public boolean isInaccessible(){
        return true;

    }

    @Override
    public boolean isMarket(){
        return false;

    }
    @Override
    public boolean isCommon(){
        return false;

    }

    @Override
    public void printCell(){
        printUtil.printBlueBackground("X");
    }

    public void printCell(String s){
        printUtil.printBlueBackground(s);
    }


    // TODO
    @Override
    public void processOption(){
        return;
    }

    
}
