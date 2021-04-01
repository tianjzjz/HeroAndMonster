package game.world.arena;

import game.HeroAndMonster;
import game.component.entity.AbstractEntity;
import game.component.entity.armor.ArmorAttr;
import game.component.entity.armor.ArmorModel;
import game.component.entity.potion.PotionAttr;
import game.component.entity.potion.PotionModel;
import game.component.entity.spell.SpellAttr;
import game.component.entity.spell.SpellModel;
import game.component.entity.weapon.WeaponAttr;
import game.component.entity.weapon.WeaponModel;
import game.component.live.hero.Hero;
import game.component.other.Bag;
import utils.printUtil;
import utils.scannerUtil;

public class Market {

    private HeroAndMonster game;

    public Market(HeroAndMonster game){
        this.game = game;
    }

    
    public void enterMarket(){

        // choose one hero to operate
        while(true){
            printUtil.printYellow("Pick a hero to operate!");
            Hero hero = game.pickHero();
            printUtil.print();
            hero.printBagInfo();
            Bag bag = hero.getBag();
            // choose buy or sell
    
            printMarketOpt();
            while(true){

                String choice = scannerUtil.readLine("Your choice: ");
                printUtil.print();

                if(choice.equalsIgnoreCase("q")){
                    printUtil.print("Leving the market...");
                    return;
                }else if(choice.equalsIgnoreCase("b")){
                    buy(hero, bag);
                }else if(choice.equalsIgnoreCase("s")){
                    bag.sell();
                }else if(choice.equalsIgnoreCase("c")){
                    break;
                }else if(choice.equalsIgnoreCase("i")){
                    hero.printHeroInfo();
                }else{
                    printUtil.printError("Invalid command!");
                }

                printMarketOpt();

            }

            hero.printBagInfo();
        }

        

        

        // case1 buy: 1. choose which categories 2. choose which one 3. buy
        // case2 sell: 1. show bag 2. choose one, 3. confirm

    }

    public void buy(Hero hero, Bag bag){

        while(true){
            bag.printCategoryOpt();

            String input = scannerUtil.readLine("Your choice:");
            if (input.equalsIgnoreCase("W")) {
                buy(hero,bag,"weapon");
            } else if (input.equalsIgnoreCase("A")) {
                buy(hero,bag,"Armor");
            } else if (input.equalsIgnoreCase("P")) {
                buy(hero,bag,"Potion");
            } else if (input.equalsIgnoreCase("S")) {
                buy(hero,bag,"Spell");
            } else if (input.equalsIgnoreCase("b")) {
                return;
            } else {
                printUtil.printError("Invalid command!");
            }
        }
    }

    public void printMarketOpt(){
        printUtil.printYellow("(B/b) Buy");
        printUtil.printYellow("(S/s) Sell");
        printUtil.printYellow("(I/i) Hero's info");

        printUtil.printYellow("(C/c) Change Character");
        printUtil.printYellow("(Q/q) Quit the Market");

    }

    /**
     * @param hero which hero wants to buy
     * @param type what type of entities he/she wants to buy
     */
    private void buy(Hero hero, Bag bag,String type){

        printUtil.printWithBoundary(type+" in store");
        if(type.equalsIgnoreCase("weapon")){
            for(WeaponAttr wp: WeaponModel.getWeapons()){
                wp.printInfo();
            }
        }else if(type.equalsIgnoreCase("Armor")){
            for(ArmorAttr am: ArmorModel.getArmors()){
                am.printInfo();
            }
        }else if(type.equalsIgnoreCase("Spell")){
            for(SpellAttr sp: SpellModel.getSpells()){
                sp.printInfo();
            }
        }else if(type.equalsIgnoreCase("Potion")){
            for(PotionAttr pt: PotionModel.getPotions()){
                pt.printInfo();
            }
        }
        printUtil.printBlue("(B/b) Back");

        while(true){

            String input = scannerUtil.readLine("Please copy the name of item you want to buy or go back to previous menu: ");
            
            if(input.equalsIgnoreCase("b")){
                return;
            }
            AbstractEntity entity = null;
            if(type.equalsIgnoreCase("Weapon")){
                entity = WeaponModel.createWeapon(input);
            }else if(type.equalsIgnoreCase("Armor")){
                entity = ArmorModel.createArmor(input);
            }else if(type.equalsIgnoreCase("Potion")){
                entity = PotionModel.createPotion(input);
            }else if(type.equalsIgnoreCase("Spell")){
                entity = SpellModel.createSpell(input);
            }else{
                printUtil.printError("Canot find corresponding item in the Market!");
                continue;
            }
            if(entity == null){
                printUtil.printError("Cannot find this item in store! Please correctly copy the name of item!");
            }

            if(hero.canBuy(entity)){
                int old = hero.getMoney();
                hero.buy(entity, type);
                printUtil.printGreen("Hero "+hero.getName()+" successfully buy "+type+ ": "+input);
                printUtil.printBlue("Coins: "+ old+" -> "+hero.getMoney());
            }else{
            }

        }

        

    }
}
