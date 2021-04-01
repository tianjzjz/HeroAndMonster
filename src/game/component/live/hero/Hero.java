package game.component.live.hero;

import game.component.attr.*;
import game.component.entity.AbstractEntity;
import game.component.entity.armor.Armor;
import game.component.attr.Saleable;
import game.component.entity.potion.Potion;
import game.component.entity.spell.Spell;
import game.component.entity.weapon.Weapon;
import game.component.other.Bag;

public interface Hero extends Alive, Fightable{
    
    // obtain basic information of the Hero
    String getName();
    int getLevel();
    int getHp();
    int getMana();
    int getExp();
    int getMoney();
    int getStrength();
    int getDexterity();
    int getDefense();
    Bag getBag();

    // print information
    void printHeroInfo();
    void printHeroInfoWithBag();

    // void printBagInfo();


    void use(Usable usable);
    void change(Equitable equitable);
    void sell(Saleable item, String type);
    Weapon getWeapon();
    Armor getArmor();
    void removeWeapon();
    void removeArmor();
    int attack();
    void defense(int incomeDamage);
    boolean canUsePell(Spell spell);


    void setMana(int mana);
    void revive();
    void win(int monsterLevel);
    void fail();
    void printBagInfo();
    void buy(Saleable itemToBuy, String type);
    boolean canBuy(AbstractEntity entity);
    void regain();
    void setLastConsumedMana(int lastConsumedMana);
    // void buy(String type);



    
    
}
