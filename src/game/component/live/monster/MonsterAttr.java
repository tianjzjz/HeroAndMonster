package game.component.live.monster;

/**
 * a monster attribute class to handle basic attributes of monsters in order to create monster objects
 */
public class MonsterAttr {

    private String name;
    private int level;
    private int damage;
    private int defense;
    private int dodgeChance;
    private String type;

    public MonsterAttr(String name, int level, int damage, int defense, int dc, String type){
        this.name = name;
        this.level = level;
        this.damage = damage;
        this.defense = defense;
        this.dodgeChance = dc;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getLevel() {
        return level;
    }

    public int getDamage() {
        return damage;
    }

    public int getDefense() {
        return defense;
    }

    public int getDodgeChance() {
        return dodgeChance;
    }
    
}
