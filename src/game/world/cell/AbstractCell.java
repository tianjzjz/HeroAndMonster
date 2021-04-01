package game.world.cell;

import game.HeroAndMonster;

/**
 * an abstract class to handle the basic construction for a cell that implements Cell interface
 */
public abstract class AbstractCell implements Cell {

    HeroAndMonster game;

    public AbstractCell(HeroAndMonster game){
        this.game = game;
    }
    
}
