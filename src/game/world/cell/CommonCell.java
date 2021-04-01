package game.world.cell;

import game.HeroAndMonster;
import utils.printUtil;

public class CommonCell extends AbstractCell {

    public CommonCell(HeroAndMonster game){
        super(game);

    }

    @Override
    public boolean isInaccessible(){
        return false;

    }

    @Override
    public boolean isMarket(){
        return false;

    }
    @Override
    public boolean isCommon(){
        return true;

    }

    @Override
    public void printCell(){
        printUtil.printWhiteBackground(" ");
    }

    public void printCell(String s){
        printUtil.printWhiteBackground(s);
    }

    @Override
    public void processOption(){
        return;
  

    }
    
}
