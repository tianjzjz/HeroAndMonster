package game.component.live.hero;

import java.util.HashMap;
import java.util.Map;

import utils.printUtil;

/**
 * this is a class to load all hero models and create an individual hero
 */
public class HeroModel {

    private static Map<String, HeroAttr> heroCollection;

    private static final String WARRIOR = "Warrior";
    private static final String SORCERER = "Sorcerer";
    private static final String PALADIN = "Paladin";

    static{
        heroCollection = new HashMap<>();
        loadModels();
    }
    
    /**
     * load hero models of three types
     */
    private static void loadModels(){
        //WARRIOR
        heroCollection.put("Gaerdal_Ironhand",new HeroAttr("Gaerdal_Ironhand", 100, 700, 500, 600, 1354, 7, HeroModel.WARRIOR));
        heroCollection.put("Sehanine_Monnbow",new HeroAttr("Sehanine_Monnbow", 600, 700, 800, 500, 2500, 8, HeroModel.WARRIOR));
        heroCollection.put("Muamman_Duathall",new HeroAttr("Muamman_Duathall", 300, 900, 500, 750, 2546, 6, HeroModel.WARRIOR));
        heroCollection.put("Flandal_Steelskin",new HeroAttr("Flandal_Steelskin", 200, 750, 650, 700, 2500, 7, HeroModel.WARRIOR));
        heroCollection.put("Undefeated_Yoj",new HeroAttr("Undefeated_Yoj", 400, 800, 400, 700, 2500, 7, HeroModel.WARRIOR));
        heroCollection.put("Eunoia_Cyn",new HeroAttr("Eunoia_Cyn", 400, 700, 800, 600, 2500, 6, HeroModel.WARRIOR));
        //SORCERER
        heroCollection.put("Rillifane_Rallathil",new HeroAttr("Rillifane_Rallathil", 1300, 750, 450, 500, 2500, 9, HeroModel.SORCERER));
        heroCollection.put("Segojan_Earthcaller",new HeroAttr("Segojan_Earthcaller", 900, 800, 500, 650, 2500, 5, HeroModel.SORCERER));
        heroCollection.put("Reign_Havoc",new HeroAttr("Reign_Havoc", 800, 800, 800, 800, 2500, 8, HeroModel.SORCERER));
        heroCollection.put("Reverie_Ashels",new HeroAttr("Reverie_Ashels", 900, 800, 700, 400, 2500, 7, HeroModel.SORCERER));
        heroCollection.put("Radiant_Ash",new HeroAttr("Radiant_Ash", 800, 850, 400, 600, 2500, 6, HeroModel.SORCERER));
        heroCollection.put("Skye_Soar",new HeroAttr("Skye_Soar", 1000, 700, 400, 500, 2500, 5, HeroModel.SORCERER));
        //PALADIN
        heroCollection.put("Solonor_Thelandira",new HeroAttr("Solonor_Thelandira", 300, 750, 650, 700, 2500, 7, HeroModel.PALADIN));
        heroCollection.put("Sehanine_Moonbow",new HeroAttr("Sehanine_Moonbow", 300, 750, 700, 700, 2500, 7, HeroModel.PALADIN));
        heroCollection.put("Skoraeus_Stonebones",new HeroAttr("Skoraeus_Stonebones", 250, 650, 600, 350, 2500, 4, HeroModel.PALADIN));
        heroCollection.put("Garl_Glittergold",new HeroAttr("Garl_Glittergold", 100, 600, 500, 400, 2500, 5, HeroModel.PALADIN));
        heroCollection.put("Amaryllis_Astra",new HeroAttr("Amaryllis_Astra", 500, 500, 500, 500, 2500, 5, HeroModel.PALADIN));
        heroCollection.put("Caliber_Heist",new HeroAttr("Caliber_Heist", 400, 400, 400, 400, 2500, 2, HeroModel.PALADIN));
    }

    /**
     * @param name: hero's name
     * @return corresponding hero model
     */
    public static Hero createHero(String name){
        if(name == null || name.trim().equals("")){
            return null;
        }
        
        HeroAttr attr = heroCollection.get(name);
        if(attr == null){
            return null;
        }
        if(attr.getType().equals(WARRIOR)){
            return new Warrior(attr.getName(), attr.getMana(),attr.getStrength(),attr.getDexterity(), attr.getAgility(),attr.getStartMoney(), attr.getStartExp());
        }else if(attr.getType().equals(SORCERER)){
            return new Sorcerer(attr.getName(), attr.getMana(),attr.getStrength(),attr.getDexterity(), attr.getAgility(),attr.getStartMoney(), attr.getStartExp());
        }else if(attr.getType().equals(PALADIN)){
            return new Paladin(attr.getName(), attr.getMana(),attr.getStrength(),attr.getDexterity(), attr.getAgility(),attr.getStartMoney(), attr.getStartExp());
        }
        return null;
        
    }

    public static void print(){
        for(HeroAttr attr:heroCollection.values()){
            attr.printAtrr();
            printUtil.print();
        }
    }

}
