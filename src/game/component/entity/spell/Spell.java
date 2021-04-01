package game.component.entity.spell;

import utils.*;
import game.component.entity.*;
import game.component.attr.Saleable;
import game.component.attr.Usable;


public class Spell extends AbstractEntity implements Usable, Saleable{

    private int damageRange;
    private int mana;
    private String type;

    public Spell(String name, int price, int level, int damageRange, int mana, String type){
        super(name,price,level);
        this.damageRange=damageRange;
        this.mana=mana;
        this.type=type;
    }

    public int getDamageRange(){
        return damageRange;
    }

    public int getMana(){
        return mana;
    }

    public String getType(){
        return type;
    }

    public void printInfo(){
        printUtil.printBlue(String.format("Type: Spell | name: %s, price: %d, requiredLevel: %d, mana cost: %d, damage: %d, type: %s",
        getName(), getPrice(), getLevel(), getMana(), getDamageRange(),getType()));
    }

    
}
