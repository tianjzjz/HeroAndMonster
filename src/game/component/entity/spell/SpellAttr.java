package game.component.entity.spell;

import utils.*;

/**
 * speel attr class is used to store basic properties of a spell and further to create a new spell object
 */
public class SpellAttr {

    private String name;
    private int price;
    private int level;
    private int damageRange;
    private int mana;
    private String type;

    public SpellAttr(String name, int price, int level, int damageRange, int mana, String type){
        this.name = name;
        this.price = price;
        this.level = level;        
        this.mana=mana;
        this.type=type;
        this.damageRange = damageRange;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getLevel() {
        return level;
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
        name, price, level, mana, damageRange,type));
    }



    
}
