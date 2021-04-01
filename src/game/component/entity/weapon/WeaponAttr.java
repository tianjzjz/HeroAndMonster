package game.component.entity.weapon;
import utils.*;

public class WeaponAttr {

    private String name;
    private int price;
    private int level;
    private int damage;
    private int requiredHand;

    public WeaponAttr(String name, int price, int level, int damage, int requiredHands){
        this.name = name;
        this.price = price;
        this.level = level;    
        this.damage=damage;
        this.requiredHand=requiredHands;
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

    public int getDamage(){
        return this.damage;
    }
    public int getHands(){
        return this.requiredHand;
    }

    public void printInfo(){
        printUtil.printBlue(String.format("Type: Weapon | name: %s, price: %d, requiredLevel: %d, damage: %d",
        getName(), getPrice(), getLevel(),getDamage(), getHands()));
    }
 
}
