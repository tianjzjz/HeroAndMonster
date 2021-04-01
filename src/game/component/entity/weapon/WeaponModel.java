package game.component.entity.weapon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * weapon model class is used to load all weapon models and create new weapon model
 */
public class WeaponModel {

    public static Map<String, WeaponAttr> weaponCollection;

    static{
        weaponCollection = new HashMap<>();
        loadWeapon();
    }

    public static void loadWeapon(){
        weaponCollection.put("Sword", new WeaponAttr("Sword", 500,1,800,1));
        weaponCollection.put("Bow", new WeaponAttr("Bow", 300,2,500,2));
        weaponCollection.put("Scythe", new WeaponAttr("Scythe", 1000,6,1100,2));
        weaponCollection.put("Axe", new WeaponAttr("Axe", 550,5,850,1));
        weaponCollection.put("TSwords", new WeaponAttr("TSwords", 1400,8,1600,2));
        weaponCollection.put("Dagger", new WeaponAttr("Dagger", 200,1,250,1));
    }

    public static Weapon createWeapon(String name){
        WeaponAttr attr = weaponCollection.get(name);
        if(attr == null){
            return null;
        }else{
            return new Weapon(attr.getName(), attr.getPrice(), attr.getLevel(), attr.getDamage(), attr.getHands());
        }
    }

    public static List<WeaponAttr> getWeapons(){
        return new ArrayList<>(weaponCollection.values());
    }



    
    
}
