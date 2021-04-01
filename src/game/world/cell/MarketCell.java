package game.world.cell;

import game.HeroAndMonster;
import game.component.attr.Accessible;
import game.world.arena.*;
import utils.*;


public class MarketCell extends AbstractCell implements Accessible{

    private Market market;

    // TODO
    public MarketCell(HeroAndMonster game){
        super(game);
        market = new Market(game);
    }


    @Override
    public boolean isInaccessible(){
        return false;

    }

    @Override
    public boolean isMarket(){
        return true;

    }
    @Override
    public boolean isCommon(){
        return false;

    }

    @Override
    public void printCell(){
        printUtil.printGreenBackground("$");
    }

    public void printCell(String s){
        printUtil.printGreenBackground(s);
    }

    @Override
    public void processOption(){
        
        market.enterMarket();
            
    }

    
}
