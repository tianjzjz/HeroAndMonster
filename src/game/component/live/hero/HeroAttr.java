package game.component.live.hero;

import utils.printUtil;

public class HeroAttr {

    private String name;
    private int mana;
    private int strength;
    private int agility;
    private int dexterity;
    private int startMoney;
    private int startExp;
    private String type;

    public HeroAttr(String name, int mana, int strength, int agility, int dexterity, int startMoney, int startExp, String type){
        this.name = name;
        this.mana = mana;
        this.strength = strength;
        this.agility = agility;
        this.dexterity = dexterity;
        this.startExp = startExp;
        this.startMoney = startMoney;
        this.type = type;
    }
    
    public String getType(){
        return type;
    }

    public String getName() {
        return name;
    }

    public int getMana() {
        return mana;
    }

    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getStartMoney() {
        return startMoney;
    }

    public int getStartExp() {
        return startExp;
    }

    public void printAtrr(){
        printUtil.printBlue("Hero Type: "+ type+"   name: "+name+ "   mana: " + mana +"   strength:" + strength + "   agility:" + agility + 
        " dexterity:" + dexterity + " startingMoney:" + startMoney +"   startingExperience:" + startExp);
    }
}
