## 1. introduction
- I follow the basic logistics described in the assignment document 
- I assume the probability of encountering a fight is .9
- I assume when a hero levels up, I use the floor value of double statistics.
- I assume a hero could hold at most one weapon at a time;
- I assume that hero, who doesn't faint after one fight, will regain 10% of HP that he/she lost during last around.
- I assume that onece you choose to quit the Market, you cannot enter the Market again and you should be ready to next move.


## 2. Explaination

   
- Main.java - Main function to run the game
- HeroAndMonster.java -  a class used to initiate a Hero and Monster game with hero team, board, and option made to process
- Accessible.java - an interface for all the cells that are accessible by heros
- Alive.java - Alive interface for all entities could be alive
- Equitable.java - an interface for all equitable entities
- Fightable.java - a fightable intefface for all entities that are able to have a fight
- Movable.java - movable interface for all entities could move
- Saleable.java - an interface for all saleable entities
- Usable.java - an interface for all usable entities
- AbstractEntity.java - an abstract class to capture common properties for an entity in the game
- Entity.java - an interface for all entities 
- Armor.java - armor class used to handle basic methods on an entity Armor
- ArmorAttr.java - armor attribute class to hold all properties of all armors
- ArmorModel.java - armor model class used to load all armor models in order to create an armor entitity
- Potion.java - Potion class used to handle basic methods on an entity Potion
- PotionAttr.java - Potion attribute class to hold all properties of all Potion
- PotionModel.java - Potion model class used to load all Potion models in order to create a Potion entitity
- Spell.java - Spell class used to handle basic methods on an entity Spell
- SpellAttr.java - Spell attribute class to hold all properties of all Spells
- SpellModel.java - Spell model class used to load all Spell models in order to create a Spell entitity
- Weapon.java - Weapon class used to handle basic methods on an entity Weapon
- WeaponAttr.java - Weapon attribute class to hold all properties of all Wepons
- WeaponModel.java - Weapon model class used to load all Weapon models in order to create a Weapon entitity
-  AbstractHero.java -  an abstract class to capture common properties for a hero in the game
- Hero.java - an interface for all heros with necessary detailed methods
- HeroAttr.java - Hero attribute class to hold all properties of all Heros
- HeroModel.java - Hero model class used to load all Hero models in order to create a Hero 
- Paladin.java - a hero type: Paladin class that specifies the level up details
- Sorcerer.java - a hero type: Sorcerer class that specifies the level up details
- Warrior.java - a hero type: Warrior class that specifies the level up details
- AbstractMonster.java -  an abstract class to capture common properties for a monster in the game
- Dragon.java - a dragon class to create a specific dragon object
- Exoskeleton.java - a Exoskeleton class to create a specific Exoskeleton object
- Monster.java - an interface for all monsters with necessary detailed methods
- MonsterAttr.java - Monster attribute class to hold all properties of all Monsters
- MonsterModel.java - Monster model class used to load all Monster models in order to create a Monster 
- Spirit.java - a Spirit class to create a specific Spirit object
- Bag.java - a class to handle the items inside a hero's bag, including weapon, armor, spell, and potion
- HeroTeam.java - a class to handle the movement and initiation of the hero team in this game
- Board.java - a class to initiate the board composed of three typrs of cells for the game and basic manipulations on the board eg. print
- Arena.java - a class to handle the fight for heroes and monsters in the common place
- Market.java - a class to handle the transaction(sell and buy) in the Market
- AbstractCell.java - an abstract class to capture all common properties for the cell
- Cell.java - an interface for all cell in the board
- CommonCell.java - a class to handle the basic properties of a common place cell
- InaccessibleCell.java - a class to handle the basic properties of an inaccessible cell
-  MarketCell.java - a class to handle the basic properties of a market cell
- config.properties - configurations
-  configUtil.java - used to read the configuration of the game
-  printUtil.java - used to handle various printing style
- randomUtil.java - used to generate a random with different conditions
- scannerUtil.java - usde to read user's input

## 3. run instruction

(base) JZJZ:Legends amari$ cd src
(base) JZJZ:src amari$ javac *.java
(base) JZJZ:src amari$ java Main
