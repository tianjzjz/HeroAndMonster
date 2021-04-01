package game.component.live.hero;

import game.component.entity.*;
import game.component.other.Bag;
import utils.*;
import game.component.entity.armor.*;
import game.component.attr.Usable;
import game.component.attr.Saleable;
import game.component.attr.Equitable;
import game.component.entity.weapon.*;
import java.util.Objects;

import javax.print.event.PrintJobEvent;

import game.component.entity.potion.*;
import game.component.entity.spell.Spell;



public abstract class AbstractHero implements Hero {
    private String name;
    private int level;
    private int hp;
    private int mana;
    private int strength;
    private int dexterity;
    private int agility;
    private Bag bag;
    private Weapon weapon;
    private Armor armor;
    private int exp;
    private int money;
    private int defense;
    private int lastConsumedMana;
    private int lastConsumedHp;

    public AbstractHero(String name, int mana, int strength, int dexterity, int agility, int money, int exp) {
        this.name = name;
        this.mana = mana;
        this.strength = strength;
        this.dexterity = dexterity;
        this.agility = agility;
        this.money = money;
        this.exp = exp;
        this.level = 1;
        this.hp = level * 100;
        this.defense = 0;
        this.bag = new Bag(this);
        this.weapon = null;
        this.armor = null;
        this.lastConsumedHp=0;
        this.lastConsumedMana=0;
    }

    /** ------------------- get value -------------------------- */

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getHp() {
        return hp;
    }

    public int getMana() {
        return mana;
    }

    public int getExp(){
        return exp;
    }

    public int getMoney(){
        return money;
    }

    public int getStrength(){
        return strength;
    }

    public int getDexterity(){
        return dexterity;
    }

    public int getAgility(){
        return agility;
    }

    public int getDefense(){
        return defense;
    }

    public Bag getBag(){
        return bag;
    }

    public Weapon getWeapon(){
        return weapon;
    }
    public Armor getArmor(){
        return armor;
    }

    /** ------------------- print info -------------------------- */


    public void printHeroInfo(){
        printUtil.printBlue(String.format("name -----------> [ %s ]", name));
        printUtil.printBlue(String.format("level ----------> [ %d ]", level));
        printUtil.printBlue(String.format("hp -------------> [ %d ]", hp));
        printUtil.printBlue(String.format("mana -----------> [ %d ]", mana));
        printUtil.printBlue(String.format("strength -------> [ %d ]", strength));
        printUtil.printBlue(String.format("dexterity ------> [ %d ]", dexterity));
        printUtil.printBlue(String.format("agility --------> [ %d ]", agility));
        printUtil.printBlue(String.format("defense --------> [ %d ]", defense));
        printUtil.printBlue(String.format("money ----------> [ %d ]", money));
        printUtil.printBlue(String.format("experience -----> [ %d ]", exp));


        printUtil.printBoundary();
        if(weapon != null){
            printUtil.printBlue(String.format("weapon ---------> [ %s ]  (extra increased damage = %d)", weapon.getName(),weapon.getDamage()));

        }else{
            
            printUtil.printBlue(String.format("weapon ---------> [ NONE ]"));
        }
        if(armor != null){
            printUtil.printBlue(String.format("armor ----------> [ %s ]  (extra reduced damage = %d)", armor.getName(), armor.getReducedDamage()));
        }else{
            printUtil.printBlue(String.format("armor ----------> [ NONE ]"));
        }
        printUtil.printBoundary();

    }

    @Override
    public void printHeroInfoWithBag(){
        printHeroInfo();


        printBagInfo();
    }

    public void printBagInfo(){

        bag.printBagInfo();

    }

    /** ------------------- set value -------------------------- */

    public void setMoney(int money){
        this.money = money;
    }

    public void setExp(int exp){
        this.exp = exp;
    }

    public void setLevel(int level){
        this.level = level;
    }

    public void setHp(int hp){
        this.hp = hp;
    }

    public void setMana(int mana){
        this.mana = mana;
    }

    public void setStrength(int strength){
        this.strength = strength;
    }

    public void setDexterity(int dex){
        this.dexterity = dex;
    }

    public void setAgility(int ag){
        this.agility = ag;
    }

    public void setDefense(int df){
        this.defense = df;
    }

    public void setWeapon(Weapon wp){
        this.weapon = wp;
    }

    public void setArmor(Armor am){
        this.armor = am;
    }

    /** ------------------- update status -------------------------- */


    /**
     * when a hero levels up, reset values of exp, level, hp, and mana
     */
    public void levelUp(){
        setExp( getExp() - getLevel() * 10 );
        setLevel( getLevel() + 1 );
        if((level*100)<hp){
            ;
        }else{
            setHp( getLevel() * 100 );

        }

        setMana((int)( getMana() * 1.1 ));
        printUtil.printGreen("Successfully level up to Lv."+level);
    }

    //TODO
    public void win(int monsterLevel){
        printUtil.printBlue(name+" still alive after this fight! ");
        int oldMoney = money;
        int oldExp= exp;
        money += 100*monsterLevel;
        exp+=2;
        printUtil.printBlue("Coins: "+ oldMoney + " -> "+money);
        printUtil.printBlue(("Exp: "+oldExp+" -> "+exp));

        if(canLevelup()){
            levelUp();
        }
        // printHeroInfo();
    }

    public boolean canLevelup(){
        if(exp>= level*10){
            return true;
        }
        else{
            return false;
        }

    }


    @Override
    public boolean isAlive(){
        return getHp()>0;
    }

    // TODO
    public void revive(){

        printUtil.printBlue(name+" revives");

        int oldHp = hp;
        hp = level * 50;
        printUtil.printBlue("Hp: "+ oldHp + " -> "+hp);

    }

    public void fail(){
        printUtil.printBlue(name+" fails this fight! ");
        int oldMoney = money;
        money = money/2;
        printUtil.printBlue("Coins: "+ oldMoney + " -> "+money);

    }

    public void regain(){
        printUtil.printGreenBackground("Hero");
        printUtil.print(name+" regains 10% of his/her hp and mana.... ");

        int oldHp = hp;
        int oldMana = mana;

        int addHp = (int)(lastConsumedHp * 0.1);
        int addMana = (int)(lastConsumedMana *0.1);

        hp = hp+addHp;
        mana = mana+addMana;
        printUtil.print();

        printUtil.print("Hp: "+ oldHp + " -> "+hp);
        printUtil.print("Mana: "+ oldMana + " -> "+mana);
        printUtil.print();



    }

    /** ------------------- action in a fight -------------------- */


 
    public void defense(int incomeDamage){

        int dgChance = randomUtil.nextInt(100);
        if(dgChance < agility *0.002){
            printUtil.printGreen("Successfully dodging the incoming attack!");
            return;
        }else{

            int armorDefense;
            if(armor == null){
                armorDefense = 0;

            }else{
                armorDefense = (int) (0.05 * this.armor.getReducedDamage());
            }

            int sufferedDamage = incomeDamage - armorDefense;


            if(sufferedDamage>0){
                int oldHp = hp;
                hp -= sufferedDamage;
                if(hp<0){
                    hp = 0;
                }else{
                    lastConsumedHp = sufferedDamage;
                }
                printUtil.print("After defense, Hero "+name+" Hp: "+ oldHp + " -> "+hp);
                printUtil.print();

            }
            
        }
        
    }

    /**
     * return how much attck damage this hero could result
     * (strength + weapon damage)*0.05.
     */
    public int attack(){
        int weaponDamage;
        if(weapon == null){
            weaponDamage = 0;
        }else{
            weaponDamage = weapon.getDamage();
        }
        return (int) ((strength + weaponDamage) * 0.05);

    }



    /** ------------------- use item -------------------------- */

    public boolean canBuy(AbstractEntity entity){
        if(entity == null){
            return false;
        }else if( money<entity.getPrice()){
            printUtil.printError( entity.getName()+ " requires " +entity.getPrice()+" coins but you only have " + money+" coinis");
            return false;
        }else if( level<entity.getLevel()){
            printUtil.printError( entity.getName()+ " requires min level " +entity.getLevel()+" but you are only level " + level);

            return false;
        }else{
            return true;
        }
    }

    public void buy(Saleable itemToBuy, String type){

        if (type.equalsIgnoreCase("Weapon")) {
            bag.addWeapon((Weapon) itemToBuy);
        } else if (type.equalsIgnoreCase("Spell")) {
            bag.addSpell((Spell) itemToBuy);
        } else if (type.equalsIgnoreCase("Potion")) {
            bag.addPotion((Potion) itemToBuy);
        } else if (type.equalsIgnoreCase("Armor")) {
            bag.addArmor((Armor) itemToBuy);
        }
        this.money -= itemToBuy.getPrice();


    }

    public boolean canUsePell(Spell spell){
        if(mana<spell.getMana()){
            printUtil.printRed("Spell "+spell.getName()+" requires "+ spell.getName()+" mana, but you only have "+ mana);
            return false;
        }else{
            return true;
        }
    }

    public void setLastConsumedMana(int lastConsumedMana) {
        this.lastConsumedMana = lastConsumedMana;
    }




    @Override
    public void sell(Saleable item, String type){
        if (type.equalsIgnoreCase("Weapon")) {
            bag.removeWeapon((Weapon) item);
        } else if (type.equalsIgnoreCase("Spell")) {
            bag.removeSpell((Spell)item);
        } else if (type.equalsIgnoreCase("Potion")) {
            bag.removePotion((Potion) item);
        } else if (type.equalsIgnoreCase("Armor")) {
            bag.removeArmor((Armor) item);
        }
        int old = money;
        this.money += (item.getPrice() / 2);
        printUtil.printGreen("You successfully sold item "+ item.getName());
        printUtil.printBlue("Coins "+ old +" -> "+ money);
        printUtil.print();

    }


    @Override
    public void use(Usable usable){

        if(usable instanceof Potion){
            usePotion((Potion)usable);
        }
    }

    public void usePotion(Potion pt){

        if(pt.getTarget().contains("Health")){
            int temp = hp;
            hp+= pt.getIncreasedStat();
            printUtil.printBlue("hp: "+ temp +" +("+pt.getIncreasedStat()+")");
        }
        
        if(pt.getTarget().contains("Mana")){
            int temp = mana;
            mana+=pt.getIncreasedStat();
            printUtil.printBlue("mana: "+ temp +" +( "+pt.getIncreasedStat()+" )");
        }
        
        if(pt.getTarget().contains("Strength")){
            int temp = strength;
            strength+=pt.getIncreasedStat();
            printUtil.printBlue("strength: "+ temp +" +( "+pt.getIncreasedStat()+" )");
        }
        
        if(pt.getTarget().contains("Dexterity")){
            int temp=dexterity;
            dexterity+=pt.getIncreasedStat();
            printUtil.printBlue("dexterity: "+ temp +" +( "+pt.getIncreasedStat()+" )");
        }
        
        if(pt.getTarget().contains("Defense")){
            int temp = defense;
            defense+=pt.getIncreasedStat();
            printUtil.printBlue("defense: "+ temp +" +( "+pt.getIncreasedStat()+" )");
        }
        
        if(pt.getTarget().contains("Agility")){

            int temp = agility;
            agility+=pt.getIncreasedStat();
            printUtil.printBlue("agility: "+ temp +" +("+pt.getIncreasedStat()+")");
        }

        bag.removePotion(pt);
        // bag.printBagInfo();

    }

    @Override
    public void change(Equitable equip){

        String old="";
        if(equip instanceof Weapon){
            if(weapon != null){
                old = weapon.getName();
                bag.addWeapon(weapon);
            }else{
                old="None";
            }
            this.weapon = (Weapon) equip;
            bag.removeWeapon(weapon);

            printUtil.printGreen("Successfully equip weapon [ "+weapon.getName()+" ] and removed previous weapon [ "+old+" ]");

        }else if(equip instanceof Armor){
            if(armor != null){
                old = armor.getName();
                bag.addArmor(armor);
            }else{
                old="None";
            }
            this.armor = (Armor) equip;
            bag.removeArmor(armor);

            printUtil.printGreen("Successfully equip armor [ "+armor.getName()+" ] and removed previous armor [ "+old+" ]");

        }
    }

    public void removeWeapon() {
        bag.addWeapon(weapon);
        printUtil.printGreen("Successfully removed weapon "+weapon.getName());

        this.weapon = null;
    }

    public void removeArmor(){
        bag.addArmor(armor);
        printUtil.printGreen("Successfully removed armor "+armor.getName());
        this.armor = null;

    }

    /** ------------------- other functions -------------------------- */

    // TODO
    @Override
    public boolean equals(Object o){
        if(this== o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        AbstractHero that = (AbstractHero) o;
        return Objects.equals(name, that.getName());
    }

    // TODO
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }


}
