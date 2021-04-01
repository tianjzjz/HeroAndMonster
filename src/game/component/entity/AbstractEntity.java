package game.component.entity;

import game.component.attr.*;
/**
 * an abstract class to capture common properties for an entity in the game
 */
public abstract class AbstractEntity implements Entity, Saleable{

    private String name;
    private int requiredLevel;
    private int price;

    public AbstractEntity(String name, int price, int requiredLevel){
        this.name = name;
        this.requiredLevel = requiredLevel;
        this.price = price;
    }
    public String getName(){
        return name;
    }

    public int getLevel(){
        return requiredLevel;
    }
    
    public int getPrice(){
        return price;
    }

    
}
