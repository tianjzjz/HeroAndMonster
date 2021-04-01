package game.component.live.monster;

import utils.*;

public abstract class AbstractMonster implements Monster{

    private String name;
    private int level;
    private int hp;
    private int damage;
    private int defense;
    private int dodgeChance;

    public AbstractMonster(String name, int level, int damage, int defense, int dodgeChance){
        this.name = name;
        this.level = level;
        this.hp = level * 100;
        this.damage = damage;
        this.defense = defense;
        this.dodgeChance = dodgeChance;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getHp() {
        return hp;
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


    public void setDamage(int damage){
        this.damage = damage;
    }

    public void setDefense(int df){
        this.defense = df;
    }

    public void setDodgeChance(int dc){
        this.dodgeChance = dc;
    }
    
    @Override
    public void printInfo(){
        printUtil.printWithBoundary("MONSTER");
        printUtil.printGreen("name : " + name);
        printUtil.printGreen("lv : " + level);
        printUtil.printGreen("hp : " + hp);
        printUtil.printGreen("baseDamage : " + damage);
        printUtil.printGreen("defenseStat : " + defense);
        printUtil.printGreen("dodgeChance : " + dodgeChance);
        printUtil.printBoundary();
    }
    
    @Override
    public void iced(){
        int old = damage;
        setDamage((int)(damage * 0.9));
        printUtil.printBlueBackground("Monster");

        printUtil.print(name+ " is iced! Damage: "+old+" -> "+damage);
    }

    @Override
    public void fired(){
        int old = defense;
        setDefense((int)(defense * 0.9));
        printUtil.printBlueBackground("Monster");
        printUtil.print(name+ " is fired! Defense: "+old+" -> "+defense);

    }

    @Override
    public void lightened(){
        int old = dodgeChance;
        printUtil.printBlueBackground("Monster");

        setDodgeChance((int)(dodgeChance * 0.9));
        printUtil.print(name+" is lightened! Dodgechance: "+old+" -> "+dodgeChance);

    }

    @Override
    public boolean isAlive() {
        return this.hp>0;
    }

    @Override
    public void defense(int incomeDamage) {
        double dgChance = randomUtil.nextDouble();
        if(dgChance< dodgeChance * 0.01){
            printUtil.printGreen("The monster "+name+" successfully dodge the attack");
            return;
        }else{
            int sufferedDamage = incomeDamage - (int)(0.05*defense);
            if(sufferedDamage>0){
                int oldHp = hp;
                hp-=sufferedDamage;
                if(hp<0){
                    hp=0;

                }
                printUtil.print("After defense, Monster " +name+ " Hp: "+ oldHp + " -> "+hp);
                printUtil.print();

            }
        }     
    }
}
