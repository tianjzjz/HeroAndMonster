package game.component.live.monster;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * load all monster models in order to create monster objects
 */
public class MonsterModel {

    private static Map<String, MonsterAttr> monsterCollection;

    private static final String DRAGON = "Dragon";
    private static final String EXOSKELETON = "Exoskeleton";
    private static final String SPIRIT = "Spirit";

    static{
        monsterCollection = new HashMap<>();
        loadMonster();
    }

    public static void loadMonster(){
        // DRAGON
        monsterCollection.put("Desghidorrah",new MonsterAttr("Desghidorrah", 3,300,400,35,MonsterModel.DRAGON));
        monsterCollection.put("Chrysophylax",new MonsterAttr("Chrysophylax", 2,200,500,20,MonsterModel.DRAGON));
        monsterCollection.put("BunsenBurner",new MonsterAttr("BunsenBurner", 4,400,500,45,MonsterModel.DRAGON));
        monsterCollection.put("Natsunomeryu",new MonsterAttr("Natsunomeryu", 1,100,200,10,MonsterModel.DRAGON));
        monsterCollection.put("TheScaleless",new MonsterAttr("TheScaleless", 7,700,600,75,MonsterModel.DRAGON));
        monsterCollection.put("Kas_Ethelinh",new MonsterAttr("Kas-Ethelinh", 5,600,500,60,MonsterModel.DRAGON));
        monsterCollection.put("Alexstraszan",new MonsterAttr("Alexstraszan", 10,1000,9000,55,MonsterModel.DRAGON));
        monsterCollection.put("Phaarthurnax",new MonsterAttr("Phaarthurnax", 6,600,700,60,MonsterModel.DRAGON));
        monsterCollection.put("D_Maleficent",new MonsterAttr("D-Maleficent", 9,900,950,85,MonsterModel.DRAGON));
        monsterCollection.put("TheWeatherbe",new MonsterAttr("TheWeatherbe", 8,800,900,80,MonsterModel.DRAGON));
        monsterCollection.put("Igneel",new MonsterAttr("Igneel", 6,600,400,68,MonsterModel.DRAGON));
        monsterCollection.put("BlueEyesWhite",new MonsterAttr("BlueEyesWhite", 9,900,600,75,MonsterModel.DRAGON));

        //EXOSKELETON
        monsterCollection.put("Cyrrollalee",new MonsterAttr("Cyrrollalee", 7,700,800,75,MonsterModel.EXOSKELETON));
        monsterCollection.put("Brandobaris",new MonsterAttr("Brandobaris", 3,350,450,30,MonsterModel.EXOSKELETON));
        monsterCollection.put("BigBad_Wolf",new MonsterAttr("BigBad-Wolf", 1,150,250,15,MonsterModel.EXOSKELETON));
        monsterCollection.put("WickedWitch",new MonsterAttr("WickedWitch", 2,250,350,25,MonsterModel.EXOSKELETON));
        monsterCollection.put("Aasterinian",new MonsterAttr("Aasterinian", 4,400,500,45,MonsterModel.EXOSKELETON));
        monsterCollection.put("Chronepsish",new MonsterAttr("Chronepsish", 6,650,750,60,MonsterModel.EXOSKELETON));
        monsterCollection.put("Kiaransalee",new MonsterAttr("Kiaransalee", 8,850,950,85,MonsterModel.EXOSKELETON));
        monsterCollection.put("St_Shargaas",new MonsterAttr("St-Shargaas", 5,550,650,55,MonsterModel.EXOSKELETON));
        monsterCollection.put("Merrshaullk",new MonsterAttr("Merrshaullk", 10,1000,900,55,MonsterModel.EXOSKELETON));
        monsterCollection.put("St_Yeenoghu",new MonsterAttr("St-Yeenoghu ", 9,950,850,90,MonsterModel.EXOSKELETON));
        monsterCollection.put("DocOck",new MonsterAttr("DocOck", 6,600,600,55,MonsterModel.EXOSKELETON));
        monsterCollection.put("Exodia",new MonsterAttr("Exodia", 10,1000,1000,50,MonsterModel.EXOSKELETON));

        //SPIRIT
        monsterCollection.put("Andrealphus",new MonsterAttr("Andrealphus", 2,600,500,40,MonsterModel.SPIRIT));
        monsterCollection.put("Aim_Haborym",new MonsterAttr("Aim-Haborym", 1,450,350,35,MonsterModel.SPIRIT));
        monsterCollection.put("Andromalius",new MonsterAttr("Andromalius", 3,550,450,25,MonsterModel.SPIRIT));
        monsterCollection.put("Chiang_shih",new MonsterAttr("Chiang-shih ", 4,700,600,40,MonsterModel.SPIRIT));
        monsterCollection.put("FallenAngel",new MonsterAttr("FallenAngel", 5,800,700,50,MonsterModel.SPIRIT));
        monsterCollection.put("Ereshkigall",new MonsterAttr("Ereshkigall", 6,950,450,35,MonsterModel.SPIRIT));
        monsterCollection.put("Melchiresas",new MonsterAttr("Melchiresas", 7,350,150,75,MonsterModel.SPIRIT));
        monsterCollection.put("Jormunngand",new MonsterAttr("Jormunngand", 8,600,900,28,MonsterModel.SPIRIT));
        monsterCollection.put("Rakkshasass",new MonsterAttr("Rakkshasass",9,550,600,20,MonsterModel.SPIRIT ));
        monsterCollection.put("Taltecuhtli",new MonsterAttr("Taltecuhtli", 10,300,200,50,MonsterModel.SPIRIT));
        monsterCollection.put("Casper",new MonsterAttr("Casper", 1,100,100,35,MonsterModel.SPIRIT));
 
    }

    public static Monster createMonster(MonsterAttr attr){
        if(attr.getType().equals(DRAGON)){
            return new Dragon(attr.getName(), attr.getLevel(),attr.getDamage(),attr.getDefense(),attr.getDodgeChance());
        }else if(attr.getType().equals(EXOSKELETON)){
            return new Exoskeleton(attr.getName(), attr.getLevel(),attr.getDamage(),attr.getDefense(),attr.getDodgeChance());
        }else if(attr.getType().equals(SPIRIT)){
            return new Spirit(attr.getName(), attr.getLevel(),attr.getDamage(),attr.getDefense(),attr.getDodgeChance());

        }else{
            return null;
        }

    }

    public static List<MonsterAttr> getMonster(){
        return new ArrayList<>(monsterCollection.values());
    }
    
}
