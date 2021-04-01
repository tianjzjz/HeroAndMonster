package game.component.entity.armor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * armor model class used to load all armor models in order to create an armor entity
 */
public class ArmorModel {

    private static Map<String, ArmorAttr> ArmorCollection;

    static{
        ArmorCollection = new HashMap<>();

        loadArmor();
    }
    
    /**
     * load all armor types
     */
    public static void loadArmor(){
        ArmorCollection.put("Platinum_Shield",new ArmorAttr("Platinum_Shield",150,1,200));
        ArmorCollection.put("Breastplate",new ArmorAttr("Breastplate", 350,3,600));
        ArmorCollection.put("Full_Body_Armor",new ArmorAttr("Full_Body_Armor",1000,8,1100));
        ArmorCollection.put("Wizard_Shield",new ArmorAttr("Wizard_Shield",1200,10,1500));
        ArmorCollection.put("Speed_Boots",new ArmorAttr("Speed_Boots",550,4,600));
        ArmorCollection.put("Guardian_Angel",new ArmorAttr("Guardian_Angel",1000,10,1000));
    }


    /**
     * create a new armor with given armor name
     */
    public static Armor createArmor(String name){
        ArmorAttr attr = ArmorCollection.get(name);
        if(attr == null){
            return null;
        }else{
            return new Armor(attr.getName(),attr.getPrice(),attr.getLevel(), attr.getReduction());
        }
    }

    public static List<ArmorAttr> getArmors(){
        return new ArrayList<>(ArmorCollection.values());
    }


}
