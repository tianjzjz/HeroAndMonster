package game.component.live.monster;

import game.component.attr.Alive;
import game.component.attr.Fightable;

public interface Monster extends Alive, Fightable{

    // obatin basic info of a monster
    int getLevel();
    int getDamage();
    int getDefense();
    int getDodgeChance();
    String getName();
    
    // set attr of a monster
    void setDefense(int df);
    void setDamage(int damage);
    void setDodgeChance(int chance);


    // affected by spells
    void iced();
    void fired();
    void lightened();

    // print info
    void printInfo();

}
