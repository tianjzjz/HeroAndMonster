package game.component.live.hero;

/**
 *  a hero type: Sorcerer class that specifies the level up details
 */
public class Sorcerer extends AbstractHero{

    public Sorcerer(String name, int mana, int strength, int dexterity, int agility, int money, int exp) {
        super(name, mana, strength, dexterity, agility, money, exp);
    }
    
    @Override
    public void levelUp(){
        super.levelUp();

        setStrength((int)(getStrength() * 1.05));
        setDexterity((int)(getDexterity() * 1.1));
        setAgility( (int)(getAgility() * 1.1));
        setDefense((int)(getDefense() * 1.05));
    }
}
