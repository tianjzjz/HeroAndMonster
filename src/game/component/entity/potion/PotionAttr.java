package game.component.entity.potion;

import utils.*;

/**
 * potion attr class used to handle the basic properties of a potion in order to create a potion object
 */
public class PotionAttr {

    private String name;
    private int price;
    private int level;
    private int increasedStat;
    private String target;


    public PotionAttr(String name, int price, int level, int increasedStat, String target){
        this.name = name;
        this.price = price;
        this.level = level;
        this.increasedStat = increasedStat;
        this.target = target;
    }

    public int getIncreasedStat(){
        return increasedStat;
    }

    public String getTarget(){
        return target;
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

    public void printInfo() {
        printUtil.printBlue(String.format("Type: Potion | name: %s, price: %d, requiredLevel: %d, increase in damage: %d, affected target: %s",
        name, price, level, increasedStat, target));
    }


    
}
