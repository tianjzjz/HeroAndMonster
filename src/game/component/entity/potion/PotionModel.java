package game.component.entity.potion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PotionModel {

    private static Map<String,PotionAttr> potionCollection;

    static{
        potionCollection = new HashMap<>();
        loadPotion();
    }

    public static void loadPotion(){
        potionCollection.put("Healing_Potion", new PotionAttr("Healing_Potion", 250, 1, 100, "Health"));
        potionCollection.put("Strength_Potion", new PotionAttr("Strength_Potion", 200, 1, 75, "Strength"));
        potionCollection.put("Magic_Potion", new PotionAttr("Magic_Potion", 350, 2, 100, "Mana"));
        potionCollection.put("Luck_Elixir", new PotionAttr("Luck_Elixir", 500, 4, 65, "Agility"));
        potionCollection.put("Mermaid_Tears", new PotionAttr("Mermaid_Tears", 850, 5, 100, "Health/Mana/Strength/Agility"));
        potionCollection.put("Ambrosia", new PotionAttr("Ambrosia", 1000, 8, 150, "All Health/Mana/Strength/Dexterity/Defense/Agility"));
    }

    public static Potion createPotion(String name){
        PotionAttr attr = potionCollection.get(name);
        if(attr == null){
            return null;
        }
        else{
            return new Potion(attr.getName(), attr.getPrice(), attr.getLevel(), attr.getIncreasedStat(), attr.getTarget());
        }
    }

    public static List<PotionAttr> getPotions(){
        return new ArrayList<>(potionCollection.values());
    }

    
    
}
