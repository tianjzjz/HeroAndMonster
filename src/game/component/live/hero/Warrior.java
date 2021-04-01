package game.component.live.hero;

/**
 *  a hero type: Warrior class that specifies the level up details
 */
public class Warrior extends AbstractHero{

    public Warrior(String name, int mana, int strength, int dexterity, int agility, int money, int exp) {
        super(name, mana, strength, dexterity, agility, money, exp);
    }

    @Override
    public void levelUp(){
        super.levelUp();

        setStrength((int)(getStrength() * 1.1));
        setDexterity((int)(getDexterity() * 1.05));
        setAgility( (int)(getAgility() * 1.1));
        setDefense((int)(getDefense() * 1.05));
    }
    


    
}
