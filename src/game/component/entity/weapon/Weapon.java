package game.component.entity.weapon;

import utils.*;
import game.component.entity.*;
import game.component.attr.Equitable;
import game.component.attr.Saleable;


public class Weapon extends AbstractEntity implements Equitable, Saleable{

    private int damage;
    private int requiredHand;

    public Weapon(String name, int price, int level, int damage, int requiredHands){
        super(name,price,level);
        this.damage=damage;
        this.requiredHand=requiredHands;
    }

    public int getDamage(){
        return this.damage;
    }

    public int getHand(){
        return this.requiredHand;
    }
    
    public void printInfo(){
        printUtil.printBlue(String.format("Type: Weapon | name: %s, price: %d, requiredLevel: %d, damage: %d",
        getName(), getPrice(), getLevel(),getDamage()));
    }

}
