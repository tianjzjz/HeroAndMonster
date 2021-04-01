package game.component.entity.armor;

import game.component.entity.*;
import game.component.attr.Equitable;
import game.component.attr.Saleable;
import utils.*;

public class Armor extends AbstractEntity implements Equitable, Saleable {

    private int reducedDamage;

    public Armor(String name, int price, int level, int reducedDamage){
        super(name, price,level);
        this.reducedDamage=reducedDamage;
    }

    public int getReducedDamage(){
        return reducedDamage;
    }
    
    public void printInfo(){
        printUtil.printBlue(String.format("Type: Armor | name: %s, price: %d, requiredLevel: %d, reduction in damage: %d",getName(), getPrice(), getLevel(), getReducedDamage()));
    }
    
}
