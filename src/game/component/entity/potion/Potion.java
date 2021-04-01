package game.component.entity.potion;

import utils.*;
import game.component.entity.*;
import game.component.attr.Saleable;
import game.component.attr.Usable;

public class Potion extends AbstractEntity implements Saleable, Usable{
    private int increasedStat;
    private String target;

    public Potion(String name, int price, int level, int increasedStat, String target){
        super(name,price,level);
        this.increasedStat = increasedStat;
        this.target = target;
    }

    public int getIncreasedStat(){
        return increasedStat;
    }

    public String getTarget(){
        return target;
    }

    public void printInfo(){
        printUtil.printBlue(String.format("Type: Potion | name: %s, price: %d, requiredLevel: %d, increase in damage: %d, affected target: %s",
        getName(), getPrice(), getLevel(), getIncreasedStat(), getTarget()));
    }
    
}
