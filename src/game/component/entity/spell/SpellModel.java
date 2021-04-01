package game.component.entity.spell;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpellModel {

    public static Map<String,SpellAttr> spellCollection;

    public static final String ICE = "Ice";
    public static final String FIRE = "Fire";
    public static final String LIGHTNING = "Lightning";

    static{
        spellCollection = new HashMap<>();
        loadSpell();
    }

    public static void loadSpell(){

        // ice spell
        spellCollection.put("Snow_Cannon", new SpellAttr("Snow_Cannon", 500, 2, 650, 250,SpellModel.ICE));
        spellCollection.put("Ice_Blade", new SpellAttr("Ice_Blade", 250, 1, 450, 100, SpellModel.ICE));
        spellCollection.put("Frost_Blizzard", new SpellAttr("Frost_Blizzard",  750, 5, 850, 350,SpellModel.ICE));
        spellCollection.put("Arctic_Storm", new SpellAttr("Arctic_Storm", 700, 6, 800, 300,SpellModel.ICE));

        // fire spell
        spellCollection.put("Flame_Tornado", new SpellAttr("Flame_Tornado", 700, 4, 850, 300, SpellModel.FIRE));
        spellCollection.put("Breath_of_Fire", new SpellAttr("Breath_of_Fire", 350, 1, 450, 100, SpellModel.FIRE));
        spellCollection.put("Heat_Wave", new SpellAttr("Heat_Wave", 450, 2, 600, 150, SpellModel.FIRE));
        spellCollection.put("Lava_Comet", new SpellAttr("Lava_Comet", 800, 7, 1000, 550, SpellModel.FIRE));
        spellCollection.put("Hell_Storm", new SpellAttr("Hell_Storm", 600, 3, 950, 600, SpellModel.FIRE));

        // lightening spell
        spellCollection.put("Lightning_Dagger", new SpellAttr("Lightning_Dagger",  400, 1, 500, 150,SpellModel.LIGHTNING));
        spellCollection.put("Thunder_Blast", new SpellAttr("Thunder_Blast",  750, 4, 950, 400,SpellModel.LIGHTNING));
        spellCollection.put("Electric_Arrows", new SpellAttr("Electric_Arrows",  550, 5, 650, 200,SpellModel.LIGHTNING));
        spellCollection.put("Spark_Needles", new SpellAttr("Spark_Needles",  500, 2, 600, 200,SpellModel.LIGHTNING));
        
    }

    /**
     * @param name: spell name
     * @return a new spell object
     */
    public static Spell createSpell(String name){

        SpellAttr attr = spellCollection.get(name);

        if(attr==null){
            return null;
        }else{
            return new Spell(attr.getName(), attr.getPrice(), attr.getLevel(), attr.getDamageRange(), attr.getMana(), attr.getType());
        }

    }
    
    public static List<SpellAttr> getSpells(){
        return new ArrayList<>(spellCollection.values());
    }
}
