package game.component.other;

import java.util.List;

import javax.swing.JTable.PrintMode;

import java.util.ArrayList;
import game.component.live.hero.*;
import utils.printUtil;
import utils.scannerUtil;
import game.component.entity.*;
import game.component.entity.armor.*;
import game.component.attr.*;
import game.component.entity.spell.*;
import game.component.entity.potion.*;
import game.component.entity.weapon.*;


/**
 * a class to handle the items inside a hero's bag, including weapon, armor, spell, and potion
 */
public class Bag {

    private List<Weapon> weaponList;
    private List<Armor> armorList;
    private List<Spell> spellList;
    private List<Potion> potionList;
    
    private Hero hero;

    public Bag(Hero hero){
        weaponList = new ArrayList<>();
        armorList = new ArrayList<>();
        spellList = new ArrayList<>();
        potionList = new ArrayList<>();
        this.hero = hero;
    }

    public List<Weapon> getWeapons(){
        return weaponList;
    }

    public List<Armor> getArmors(){
        return armorList;
    }

    public List<Spell> getSpells(){
        return spellList;
    }

    public List<Potion> getPotion(){
        return potionList;
    }

    public void printWeapon(){
        printUtil.printDotBoundary(" WEAPON ");

        if(weaponList.isEmpty()){
            printUtil.printRed("Empty");
        }else{
            for(Weapon wp: weaponList){
                wp.printInfo();;
            }
        }
        printUtil.printBoundary();
        printUtil.print();

    }

    public void printArmor(){
        printUtil.printDotBoundary(" ARMOR ");

        if(armorList.isEmpty()){
            printUtil.printRed("Empty");
        }else{
            for(Armor am: armorList){
                am.printInfo();
            }
        }
        printUtil.printBoundary();
        printUtil.print();

    }



    public void printSpell(){
        printUtil.printDotBoundary(" SPELL ");

        if(spellList.isEmpty()){
            printUtil.printRed("Empty");
        }else{
            for(Spell sp: spellList){
                sp.printInfo();
            }
        }
        printUtil.printBoundary();
        printUtil.print();

    }


    public void printPotion(){
        printUtil.printDotBoundary(" POTION ");

        if(potionList.isEmpty()){
            printUtil.printRed("Empty");
        }else{
            for(Potion pt: potionList){
                pt.printInfo();
            }
        }
        printUtil.printBoundary();
        printUtil.print();

    }

    public void printBagInfo(){
        printUtil.printWithBoundary(hero.getName()+"'s Bag");
        printUtil.print();
        printWeapon();
        printArmor();
        printSpell();
        printPotion();

    }


    public Weapon findWeapon(String name){
        for(Weapon wp: weaponList){
            if(wp.getName().equals(name)){
                return wp;
            }
        }
        return null;
    }

    public Armor findArmor(String name){
        for(Armor am: armorList){
            if(am.getName().equals(name)){
                return am;
            }
        }
        return null;
    }

    public Spell findSpell(String name){
        for(Spell sp: spellList){
            if(sp.getName().equals(name)){
                return sp;
            }
        }
        return null;
    }    
    public Potion findPotion(String name){
        for(Potion pt: potionList){
            if(pt.getName().equals(name)){
                return pt;
            }
        }
        return null;
    }

    public void addWeapon(Weapon wp){
        weaponList.add(wp);
    }

    public void addArmor(Armor am){
        armorList.add(am);
    }

    public void addPotion(Potion pt){
        potionList.add(pt);
    }

    public void addSpell(Spell sp){
        spellList.add(sp);
    }

    public void removeWeapon(Weapon wp){
        weaponList.remove(wp);
    }

    public void removeArmor(Armor am){
        armorList.remove(am);
    }

    public void removeSpell(Spell item){
        spellList.remove(item);
    }

    public void removePotion(Potion pt){
        potionList.remove(pt);
    }

    /**
     * find the entity list by given type name
     */
    public List<? extends Entity> getListByType(String type){
        if(type.equalsIgnoreCase("Weapon")){
            return weaponList;
        }else if(type.equalsIgnoreCase("Armor")){
            return armorList;
        }else if(type.equalsIgnoreCase("Spell")){
            return spellList;
        }else if(type.equalsIgnoreCase("Potion")){
            return potionList;
        }else{
            return null;
        }

    }

    /**
     * find the specific entity by given type and name
     */
    public AbstractEntity findEntity(String type, String name){
        if(type.equalsIgnoreCase("Weapon")){
            return findWeapon(name);
        }else if(type.equalsIgnoreCase("Armor")){
            return findArmor(name);
        }else if(type.equalsIgnoreCase("Spell")){
            return findSpell(name);
        }else if(type.equalsIgnoreCase("Potion")){
            return findPotion(name);
        }else{
            return null;
        }
    }

    public void printBagOpt(){

        printUtil.printDotBoundary("Menu");
        printUtil.printYellow("(W/w) Remove/Equip Weapon");
        printUtil.printYellow("(A/a) Remove/Equip Armor");
        printUtil.printYellow("(P/p) Use Potion");
        printUtil.printYellow("(I/i) Show bag info");

        printUtil.printYellow("(B/b) Back");
        printUtil.printYellow("(Q/q) Quit the game");


        printUtil.print();


    }

    public void printCategoryOpt(){

        printUtil.printYellow("(W/w) Weapon");
        printUtil.printYellow("(A/a) Armor");
        printUtil.printYellow("(P/p) Potion");
        printUtil.printYellow("(S/s) Spell");

        printUtil.printYellow("(B/b) Back");
        printUtil.printYellow("(Q/q) Quit the game");

        printUtil.print();
    }


    public void printQuit(){
        printUtil.printYellow("(Q/q) quit");
    }

    public void printBack(){
        printUtil.printYellow("(B/b) Back to the menu");
    }

    public void weaponChoice(){

        while(true){
            printUtil.printYellow("(E/e) Equip weapon");
            printUtil.printYellow("(R/r) Remove weapon");
            printBack();

            String input = scannerUtil.readLine("Your Choice: ");
            if(input.equalsIgnoreCase("b")){
                return;
            }else if(input.equalsIgnoreCase("e")){
                changeEquip("Weapon");
            }else if(input.equalsIgnoreCase("r")){
                if(hero.getWeapon()==null){
                    printUtil.printError("You have not equipped any weapon yet!");
                }else{
                    hero.removeWeapon();
                    hero.printHeroInfo();
                    return;
                }
            }else{
                printUtil.printError("Invalid input!");
            }
        }
    }

    public void armorChoice(){

        while(true){
            printUtil.printYellow("(E/e) Equip armor");
            printUtil.printYellow("(R/r) Remove armor");
            printBack();
            printUtil.print();
            String input = scannerUtil.readLine("Your Choice: ");
            if(input.equalsIgnoreCase("b")){
                return;
            }else if(input.equalsIgnoreCase("e")){
                changeEquip("armor");
            }else if(input.equalsIgnoreCase("r")){
                if(hero.getArmor()==null){
                    printUtil.printError("You have not equipped any armot yet!");
                }else{
                    hero.removeArmor();
                    // hero.printHeroInfo();
                    return;
                }
            }else{
                printUtil.printError("Invalid input!");
            }
            printUtil.print();

        }
    }


    public boolean changeEquip(String type){

        if(type.equalsIgnoreCase("weapon")){

            printWeapon();
            if(weaponList.size()==0){
                printUtil.printRed("No weapon available in your bag to be equipped!");
                return false;
            }

        }else if(type.equalsIgnoreCase("armor")){
            printArmor();
            if(armorList.size()==0){
                printUtil.printRed("No armor available in your bag to be equipped!");

                return false;
            }
        }


        Equitable equitable = null;
        while(true){
            printBack();
            printUtil.print();
    
            String choice = scannerUtil.readLine("Copy the name of item you want to equip:");
            if(choice.equalsIgnoreCase("b")){
                return false;
            }
            if(type.equalsIgnoreCase("weapon")){
                equitable = findWeapon(choice);
            }else if(type.equalsIgnoreCase("armor")){
                equitable = findArmor(choice);
            }

            if(equitable == null){
                printUtil.printError("Cannot find this item in yout bag!");

            }else{
                hero.change(equitable);
                return true;
            }

            
        }
        

    }

    public void usePotion(){


        // check availability of potions
        printPotion();

        if(getPotion().size()==0){
            printUtil.printRed("No Potion Available!");
            return;
        }

        // obtain the potion the user wants to use
        Potion potion;
        while(true){

            printBack();
            printUtil.print();
    
            String choice = scannerUtil.readLine("Copy the name of potion you want to use: ");
            if(choice.equalsIgnoreCase("b")){
                return;
            }

            potion = findPotion(choice);
            if(potion == null){
                printUtil.printError("Cannot find potion "+ choice);
            }else{
                printUtil.printGreen("Successfully use Potion "+potion.getName());
                hero.use(potion);
                return;
            }
        
        }

    }





    public void sell(){

        while(true){
            printCategoryOpt();
            String input = scannerUtil.readLine("Your choice:");
            if (input.equalsIgnoreCase("W")) {
                sellEntity("Weapon");
            } else if (input.equalsIgnoreCase("A")) {
                sellEntity("Armor");
            } else if (input.equalsIgnoreCase("P")) {
                sellEntity("Potion");
            } else if (input.equalsIgnoreCase("S")) {
                sellEntity("Spell");
            } else if (input.equalsIgnoreCase("b")) {
                return;
            } else {
                printUtil.printError("Invalid input!");
            }

        }

    }

    public void sellEntity(String name){
        while(true){
            List<? extends Entity> list = getListByType(name);
            if(list.size()==0){
                printUtil.printRed("There is no "+name+" could be sold!");
                return;
            }
            printUtil.printDotBoundary(name);

            for(Entity item: list){
                item.printInfo();
            }
            printBack();
            String input = scannerUtil.readLine("Copy the name of "+name+" you want to sell:");
            if(input.equalsIgnoreCase("b")){
                return;
            }
            AbstractEntity item = findEntity(name, input);
            if(item == null){
                printUtil.printError("Cannot find " + input + " in your bag!");
            }else{
                hero.sell(item, name);
            }

        }

    }



}

