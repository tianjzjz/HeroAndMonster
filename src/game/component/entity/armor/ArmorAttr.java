package game.component.entity.armor;

import utils.*;

/**
 * armor attribute class to capture all properties of armors
 */
public class ArmorAttr {

    private String name;
    private int requiredLevel;
    private int price;
    private int reducedDamage;

    public ArmorAttr(String name, int price, int level, int reduc){
        this.name = name;
        this.requiredLevel = level;
        this.price = price;
        this.reducedDamage = reduc;

    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getLevel() {
        return requiredLevel;
    }

    public int getReduction() {
        return reducedDamage;
    }

    public void printInfo() {
        printUtil.printBlue(String.format("[Armor] name: %s, price: %d, required level: %d, reduction in damage: %d",
                name, price, requiredLevel, reducedDamage));
    }



    
}
