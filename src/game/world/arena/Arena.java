package game.world.arena;

import java.util.ArrayList;
import java.util.List;

import game.HeroAndMonster;
import game.component.entity.potion.Potion;
import game.component.entity.spell.Spell;
import game.component.entity.spell.SpellModel;
import game.component.live.hero.Hero;
import game.component.live.monster.Monster;
import game.component.other.Bag;
import utils.printUtil;
import utils.scannerUtil;

public class Arena {

    private List<Hero> heroList;
    private List<Monster> monsterList;
    private List<Monster> waitingMonsterList;
    private HeroAndMonster game;

    // private List<Boolean> heroStatus;
    // private List<Boolean> monsterStatus;


    public Arena(List<Hero> heroList, List<Monster> monserList, HeroAndMonster game){
        this.heroList = heroList;
        this.monsterList = monserList;
        this.waitingMonsterList = new ArrayList<>();
        this.game = game;
        // initiateStatus();


    }

    public void fight(){

        printUtil.printRed("     *  *  *     Fight Starts!    *  *  *           ");;
        printUtil.print();
        // loop for each round
        int i =0;
        while(true){
            i++;

            // check wheher there is one team has aced
            if(isHeroAced()||isMonsterAced()){
                if(isMonsterAced()){
                    heroWin(monsterList.get(0).getLevel());
                    return;
                }
                if(isHeroAced()){
                    monsterWin();
                    return;
                }
            }

            // print live hero and monster info
            printUtil.printDotBoundary("Round "+i);
            printUtil.print();
            printAllInfo();


            for(int heroId=0; heroId<heroList.size() && !isMonsterAced(); heroId++){

                Hero currHero = heroList.get(heroId);
                Monster currMonster = monsterList.get(heroId);


                if(currHero.isAlive() && currMonster.isAlive()){
                    // fight with his corresponding monster
                    printUtil.printBlueBackground("Hero "+currHero.getName()+", please be ready for your fight against Monster " +currMonster.getName()+"!");
                    printUtil.print();
                    if(heroMakeChoice(currHero, currMonster)){
                        if(isHeroDefeatMonster(currHero,currMonster)){
                            continue;
                        }else{
                            monsterAttack(currHero, currMonster);
                            if(!isMonsterDefeatHero(currHero,currMonster)){
                                currHero.regain();
                            };
                        }

                    }else{
                        return;
                    }
                }else if(currHero.isAlive() && !currMonster.isAlive()){
                    printUtil.print(currMonster.getName()+" is dead! so you should help other member!");

                    Monster newMonster = null;

                    for(Monster m: monsterList){
                        if(m.isAlive()){
                            newMonster = m;
                        }else{
                            printUtil.print(m.getName()+" is dead! Look for next monster");

                        }
                    }
                    printUtil.printBlueBackground("Hero "+currHero.getName()+" please get ready for your fight against Monster "+newMonster.getName());
                    printUtil.print();

                    if(heroMakeChoice(currHero, newMonster)){
                        if(isHeroDefeatMonster(currHero,newMonster)){
                            continue;
                        }else{
                            monsterAttack(currHero, newMonster);
                            if(!isMonsterDefeatHero(currHero,newMonster)){
                                currHero.regain();
                            }
                        }

                    }else{
                        return;
                    }

                }else if(!currHero.isAlive() && !currMonster.isAlive()){
                    continue;
                }
                // if this hero is faint but his/her corresponding monster is still alive,
                // then store this monster to the list and waiting for the other heroes to fight with
                else{
                    waitingMonsterList.add(currMonster);
                }

                // checkResult();
            }

            // printUtil.print("All Alive heroes have finished their this round fight with their corresponding monster!");

            
            while(waitingMonsterList.isEmpty()==false && !isHeroAced()){
                i++;
                printUtil.printDotBoundary("Round "+i);
                printUtil.print();
                printAllInfo();


                for(Hero tempHero: heroList){

                    // if this hero is alive then fight
                    if(tempHero.isAlive()&& !isMonsterAced()){
                        Monster waitMonster = waitingMonsterList.get(0);
                        printUtil.printBlueBackground("Hero "+tempHero.getName()+" please get ready for your fight against Monster "+waitMonster.getName());
                        printUtil.print();


                        if(heroMakeChoice(tempHero, waitMonster)){

                            if(isHeroDefeatMonster(tempHero, waitMonster)){
                                waitingMonsterList.remove(0);

                            }else{
                                monsterAttack(tempHero, waitMonster);
                                if(!isMonsterDefeatHero(tempHero, waitMonster)){
                                    tempHero.regain();
                                }
                            }
                        }else{
                            return;
                        }

                    
                    }
                }

                

            }
            // checkResult();
            printUtil.print();

        }
    }



    public void checkResult(){
        if(isMonsterAced()){
            heroWin(monsterList.get(0).getLevel());
            return;
        }
        if(isHeroAced()){
            monsterWin();
            return;
        }

    }

    public void printFightOpt(){
        printUtil.printDotBoundary("Fight choice");
        printUtil.printYellow("(A/a) Regular attack");
        printUtil.printYellow("(S/s) Spell");
        printUtil.printYellow("(P/p) Potion");
        printUtil.printYellow("(C/c) Change/Equip Armor/Weapon");
        printUtil.printYellow("(I/i) Info");
        printUtil.printYellow("(Q/q) quit");
    }

    

    // time for this hero to make choice: attack, spell, potion, or change
    public boolean heroMakeChoice(Hero hero, Monster monster){

        while(true){

            printFightOpt();

            String input = scannerUtil.readLine("Your choice: ");
            printUtil.printBoundary();
            printUtil.print();
            if (input.equalsIgnoreCase("a")) {
                implementAttack(hero, monster);
                return true;
            } 
            // use spell 
            else if (input.equalsIgnoreCase("s")) {
                Bag bag = hero.getBag();
                List<Spell> spellList = bag.getSpells();
                bag.printSpell();

                if(spellList.isEmpty()){
                    printUtil.printError("You do not have any spell in the bag!");
                    continue;
                }else{
                    if(implementSpell(hero, monster, bag)){
                        return true;
                    }
                    // user choose not to use the spell
                    else{continue;
                    }
                }
            } 
            // use potion
            else if (input.equalsIgnoreCase("p")) {
                Bag bag = hero.getBag();
                List<Potion> potionList = bag.getPotion();
                bag.printPotion();

                if(potionList.isEmpty()){
                    printUtil.printError("You do not have any potion in the bag!");
                    continue;
                }else{
                    if(implementPotion(hero, monster, bag)){
                        return true;
                    }
                    // user choose not to use the spell
                    else{
                        continue;
                    }
                }
            } 
            // change or quip
            else if (input.equalsIgnoreCase("c")) {
                Bag bag = hero.getBag();
                if(changeEquip(hero, monster,bag)){
                    hero.setLastConsumedMana(0);
                    implementAttack(hero, monster);
                    return true;
                }else{
                    continue;
                }    
            } else if (input.equalsIgnoreCase("i")) {
                hero.printHeroInfoWithBag();
            } else if(input.equalsIgnoreCase("q")){
                game.setOver();
                return false;
            }else{
                printUtil.printError("Invalid input!");
            }     
        }
    }

    public boolean changeEquip(Hero hero, Monster monster, Bag bag){

        while(true){
            printUtil.printYellow("(W/w) Change/Equip Weapon");
            printUtil.printYellow("(A/a) Change/Equip Armor");
            printUtil.printYellow("(B/b) Back)");
            printUtil.print();
            String choice = scannerUtil.readLine("Your choice: ");
            if(choice.equalsIgnoreCase("b")){
                return false;
            }
            else if(choice.equalsIgnoreCase("w")){
                return bag.changeEquip("weapon");
            }else if(choice.equalsIgnoreCase("a")){
                return bag.changeEquip("armor");
            }else{
                printUtil.printError("Cannot find "+choice+" in your bag! Please try again!");
            }
        }
    }


    public void implementAttack(Hero hero, Monster monster){
        int attackCreated = hero.attack();
        hero.setLastConsumedMana(0);

        printUtil.printHeroDamage(hero.getName(), monster.getName(), attackCreated);
        monster.defense(attackCreated);

    }

    public boolean implementSpell(Hero hero, Monster monster, Bag bag){

        printUtil.printYellow("(B/b) Back");
        while(true){
            String choice = scannerUtil.readLine("Copy the name of spell you want to use: ");
            if(choice.equalsIgnoreCase("b")){
                printUtil.printYellow("Going back to the menu...");
                return false;
            }
            Spell spell = bag.findSpell(choice);

            if(spell != null){
                // if user is not able to use the spell then break
                if(!hero.canUsePell(spell)){
                    printUtil.printYellow("Please choose another spell or go back to the menu");
                    return false;
                }

                // use spell on the monster
                if (spell.getType().equalsIgnoreCase(SpellModel.FIRE)) {
                    
                    monster.fired();
                } else if (spell.getType().equals(SpellModel.ICE)) {
                    monster.iced();
                } else if (spell.getType().equals(SpellModel.LIGHTNING)) {
                    monster.lightened();
                }

                bag.removeSpell(spell);

                // create damage and monster defenses the attack
                int spellDamage = (int) ((spell.getDamageRange()+(hero.getDexterity()/10000)*spell.getDamageRange()));
                int attackCreated = hero.attack() +(int) 0.05*spellDamage;
                monster.defense(attackCreated);

                printUtil.printHeroDamage(hero.getName(), monster.getName(), attackCreated);
                
                hero.setMana(hero.getMana()-spell.getMana());
                hero.setLastConsumedMana(spell.getMana());

                return true;
            }else{
                printUtil.printError("Cannot find "+choice+" in your bag! Please try again!");
            }
        }      

    }

    public boolean implementPotion(Hero hero, Monster monster, Bag bag){

        printUtil.printYellow("(B/b) Back");
        while(true){
            String choice = scannerUtil.readLine("Copy the name of potion you want to use: ");
            if(choice.equalsIgnoreCase("b")){
                printUtil.printYellow("Going back to the menu...");
                return false;
            }
            Potion potion = bag.findPotion(choice);

            if(potion != null){

                hero.use(potion);
                hero.setLastConsumedMana(0);
                // create damage and monster defenses the attack
                int attackCreated = hero.attack();
                monster.defense(attackCreated);
                printUtil.printHeroDamage(hero.getName(), monster.getName(), attackCreated);
                return true;
            }else{
                printUtil.printError("Cannot find "+choice+" in your bag! Please try again!");
            }
        }      
    }


    /**
     * print all heroes and monsters info
     */
    public void printAllInfo(){
        for(Hero hero:heroList){
            printUtil.printGreenBackground("Hero");

            String status;
            if(hero.isAlive()){
                status = "Alive";
            }else{
                status = "Dead";
            }
            printUtil.print(hero.getName()+ "   Hp: "+hero.getHp()+"   Level: "+hero.getLevel()+"   Status: "+status);
        }
        printUtil.print();

        for(Monster monster:monsterList){
            String status;
            printUtil.printBlueBackground("Monster");

            if(monster.isAlive()){
                status = "Alive";
            }else{
                status = "Dead";
            }
            printUtil.print(monster.getName()+ "   Hp: "+monster.getHp()+"   Level: "+monster.getLevel()+"   Status: "+status);
        }
        printUtil.print();
    }


    /**
     * monsters win and update heroes info
     */
    public void monsterWin(){
        printUtil.print();
        printUtil.printGreen("OOOPs! Monster win the game!!!");
        for(Hero hero: heroList){
           hero.fail();
        }

    }

    /**
     * heroes win and update heroes including money and revive
     */
    public void heroWin(int monsterLv){
        printUtil.print();
        printUtil.printGreen("Congratulations! Heroes win the game!!!");
        for(Hero hero: heroList){
            if(!hero.isAlive()){
                hero.revive();
            }else{
                hero.win(monsterLv);
            }
        }


    }

    public boolean isMonsterAced(){
        for(Monster monster: monsterList){
            if(monster.isAlive()){
                return false;
            }
        }
        return true;

    }

    public boolean isHeroAced(){
        for(Hero hero: heroList){
            if(hero.isAlive()){
                return false;
            }
        }
        return true;

    }

    public boolean isHeroDefeatMonster(Hero hero,Monster monster){
        if(monster.isAlive()){
            return false;
        }else{
            printUtil.printGreen("Hero "+hero.getName()+" has defeated Monster "+ monster.getName());

            return true;
        }
    }
    public boolean isMonsterDefeatHero(Hero hero, Monster monster){
        if(hero.isAlive()){
            return false;
        }else{
            printUtil.printRed("Hero "+hero.getName()+" has been defeated by Monster "+ monster.getName());

            return true;
        }
    }

    public void monsterAttack(Hero hero, Monster monster){
        int attackCreated = (int)(0.05*monster.getDamage());
        printUtil.printMonsterDamage(monster.getName(), hero.getName(), attackCreated);
        hero.defense(attackCreated);

    }

    
}
