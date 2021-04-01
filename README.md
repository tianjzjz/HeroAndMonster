## 1. introduction
- I follow the basic logistics described in the assignment document 
- I assume the probability of encountering a fight is .9
- I assume when a hero levels up, I use the floor value of double statistics.
- I assume a hero could hold at most one weapon at a time;
- I assume that hero, who doesn't faint after one fight, will regain 10% of HP that he/she lost during last around.
- I assume that onece you choose to quit the Market, you cannot enter the Market again and you should be ready to next move.


## 2. Structure

.
├── README.md
└── src
    ├── Main.java
    ├── game
    │   ├── HeroAndMonster.java
    │   ├── component
    │   │   ├── attr
    │   │   │   ├── Accessible.java
    │   │   │   ├── Alive.java
    │   │   │   ├── Equitable.java
    │   │   │   ├── Fightable.java
    │   │   │   ├── Movable.java
    │   │   │   ├── Saleable.java
    │   │   │   └── Usable.java
    │   │   ├── entity
    │   │   │   ├── AbstractEntity.java
    │   │   │   ├── Entity.java
    │   │   │   ├── armor
    │   │   │   │   ├── Armor.java
    │   │   │   │   ├── ArmorAttr.java
    │   │   │   │   └── ArmorModel.java
    │   │   │   ├── potion
    │   │   │   │   ├── Potion.java
    │   │   │   │   ├── PotionAttr.java
    │   │   │   │   └── PotionModel.java
    │   │   │   ├── spell
    │   │   │   │   ├── Spell.java
    │   │   │   │   ├── SpellAttr.java
    │   │   │   │   └── SpellModel.java
    │   │   │   └── weapon
    │   │   │       ├── Weapon.java
    │   │   │       ├── WeaponAttr.java
    │   │   │       └── WeaponModel.java
    │   │   ├── live
    │   │   │   ├── hero
    │   │   │   │   ├── AbstractHero.java
    │   │   │   │   ├── Hero.java
    │   │   │   │   ├── HeroAttr.java
    │   │   │   │   ├── HeroModel.java
    │   │   │   │   ├── Paladin.java
    │   │   │   │   ├── Sorcerer.java
    │   │   │   │   └── Warrior.java
    │   │   │   └── monster
    │   │   │       ├── AbstractMonster.java
    │   │   │       ├── Dragon.java
    │   │   │       ├── Exoskeleton.java
    │   │   │       ├── Monster.java
    │   │   │       ├── MonsterAttr.java
    │   │   │       ├── MonsterModel.java
    │   │   │       └── Spirit.java
    │   │   └── other
    │   │       ├── Bag.java
    │   │       └── HeroTeam.java
    │   └── world
    │       ├── Board.java
    │       ├── arena
    │       │   ├── Arena.java
    │       │   └── Market.java
    │       └── cell
    │           ├── AbstractCell.java
    │           ├── Cell.java
    │           ├── CommonCell.java
    │           ├── InaccessibleCell.java
    │           └── MarketCell.java
    └── utils
        ├── config.properties
        ├── configUtil.java
        ├── printUtil.java
        ├── randomUtil.java
        └── scannerUtil.java

17 directories, 54 files

## 3. Explaination
.
├── README.md
└── src
    ├── Main.java - Main function to run the game
    ├── game
    │   ├── HeroAndMonster.java -  a class used to initiate a Hero and Monster game with hero team, board, and option made to process
    │   ├── component
    │   │   ├── attr
    │   │   │   ├── Accessible.java - an interface for all the cells that are accessible by heros
    │   │   │   ├── Alive.java - Alive interface for all entities could be alive
    │   │   │   ├── Equitable.java - an interface for all equitable entities
    │   │   │   ├── Fightable.java - a fightable intefface for all entities that are able to have a fight
    │   │   │   ├── Movable.java - movable interface for all entities could move
    │   │   │   ├── Saleable.java - an interface for all saleable entities
    │   │   │   └── Usable.java - an interface for all usable entities
    │   │   ├── entity
    │   │   │   ├── AbstractEntity.java - an abstract class to capture common properties for an entity in the game
    │   │   │   ├── Entity.java - an interface for all entities 
    │   │   │   ├── armor
    │   │   │   │   ├── Armor.java - armor class used to handle basic methods on an entity Armor
    │   │   │   │   ├── ArmorAttr.java - armor attribute class to hold all properties of all armors
    │   │   │   │   └── ArmorModel.java - armor model class used to load all armor models in order to create an armor entitity
    │   │   │   ├── potion
    │   │   │   │   ├── Potion.java - Potion class used to handle basic methods on an entity Potion
    │   │   │   │   ├── PotionAttr.java - Potion attribute class to hold all properties of all Potion
    │   │   │   │   └── PotionModel.java - Potion model class used to load all Potion models in order to create a Potion entitity
    │   │   │   ├── spell
    │   │   │   │   ├── Spell.java - Spell class used to handle basic methods on an entity Spell
    │   │   │   │   ├── SpellAttr.java - Spell attribute class to hold all properties of all Spells
    │   │   │   │   └── SpellModel.java - Spell model class used to load all Spell models in order to create a Spell entitity
    │   │   │   └── weapon
    │   │   │       ├── Weapon.java - Weapon class used to handle basic methods on an entity Weapon
    │   │   │       ├── WeaponAttr.java - Weapon attribute class to hold all properties of all Wepons
    │   │   │       └── WeaponModel.java - Weapon model class used to load all Weapon models in order to create a Weapon entitity
    │   │   ├── live
    │   │   │   ├── hero
    │   │   │   │   ├── AbstractHero.java -  an abstract class to capture common properties for a hero in the game
    │   │   │   │   ├── Hero.java - an interface for all heros with necessary detailed methods
    │   │   │   │   ├── HeroAttr.java - Hero attribute class to hold all properties of all Heros
    │   │   │   │   ├── HeroModel.java - Hero model class used to load all Hero models in order to create a Hero 
    │   │   │   │   ├── Paladin.java - a hero type: Paladin class that specifies the level up details
    │   │   │   │   ├── Sorcerer.java - a hero type: Sorcerer class that specifies the level up details
    │   │   │   │   └── Warrior.java - a hero type: Warrior class that specifies the level up details
    │   │   │   └── monster
    │   │   │       ├── AbstractMonster.java -  an abstract class to capture common properties for a monster in the game
    │   │   │       ├── Dragon.java - a dragon class to create a specific dragon object
    │   │   │       ├── Exoskeleton.java - a Exoskeleton class to create a specific Exoskeleton object
    │   │   │       ├── Monster.java - an interface for all monsters with necessary detailed methods
    │   │   │       ├── MonsterAttr.java - Monster attribute class to hold all properties of all Monsters
    │   │   │       ├── MonsterModel.java - Monster model class used to load all Monster models in order to create a Monster 
    │   │   │       └── Spirit.java - a Spirit class to create a specific Spirit object
    │   │   └── other
    │   │       ├── Bag.java - a class to handle the items inside a hero's bag, including weapon, armor, spell, and potion
    │   │       └── HeroTeam.java - a class to handle the movement and initiation of the hero team in this game
    │   └── world
    │       ├── Board.java - a class to initiate the board composed of three typrs of cells for the game and basic manipulations on the board eg. print
    │       ├── arena
    │       │   ├── Arena.java - a class to handle the fight for heroes and monsters in the common place
    │       │   └── Market.java - a class to handle the transaction(sell and buy) in the Market
    │       └── cell
    │           ├── AbstractCell.java - an abstract class to capture all common properties for the cell
    │           ├── Cell.java - an interface for all cell in the board
    │           ├── CommonCell.java - a class to handle the basic properties of a common place cell
    │           ├── InaccessibleCell.java - a class to handle the basic properties of an inaccessible cell
    │           └── MarketCell.java - a class to handle the basic properties of a market cell
    └── utils
        ├── config.properties - configurations
        ├── configUtil.java - used to read the configuration of the game
        ├── printUtil.java - used to handle various printing style
        ├── randomUtil.java - used to generate a random with different conditions
        └── scannerUtil.java - usde to read user's input


## 4. run instruction

(base) JZJZ:Legends amari$ cd src
(base) JZJZ:src amari$ javac *.java
(base) JZJZ:src amari$ java Main

## Sample Output

(base) JZJZ:src amari$ cd /Users/amari/Documents/Boston_University/CS611/test/Legends 
(base) JZJZ:Legends amari$ ls
README.md	src
(base) JZJZ:Legends amari$ cd src
(base) JZJZ:src amari$ javac *.java
(base) JZJZ:src amari$ java Main
           WELCOME!               
Get ready to start your adventure!
Cannot find config file
Enter a number 1-3 to set the size of your team: 
3

------------------------Hero List---------------------
Hero Type: Warrior   name: Sehanine_Monnbow   mana: 600   strength:700   agility:800 dexterity:500 startingMoney:2500   startingExperience:8

Hero Type: Paladin   name: Caliber_Heist   mana: 400   strength:400   agility:400 dexterity:400 startingMoney:2500   startingExperience:2

Hero Type: Sorcerer   name: Radiant_Ash   mana: 800   strength:850   agility:400 dexterity:600 startingMoney:2500   startingExperience:6

Hero Type: Sorcerer   name: Rillifane_Rallathil   mana: 1300   strength:750   agility:450 dexterity:500 startingMoney:2500   startingExperience:9

Hero Type: Sorcerer   name: Segojan_Earthcaller   mana: 900   strength:800   agility:500 dexterity:650 startingMoney:2500   startingExperience:5

Hero Type: Warrior   name: Gaerdal_Ironhand   mana: 100   strength:700   agility:500 dexterity:600 startingMoney:1354   startingExperience:7

Hero Type: Warrior   name: Muamman_Duathall   mana: 300   strength:900   agility:500 dexterity:750 startingMoney:2546   startingExperience:6

Hero Type: Warrior   name: Flandal_Steelskin   mana: 200   strength:750   agility:650 dexterity:700 startingMoney:2500   startingExperience:7

Hero Type: Paladin   name: Sehanine_Moonbow   mana: 300   strength:750   agility:700 dexterity:700 startingMoney:2500   startingExperience:7

Hero Type: Sorcerer   name: Skye_Soar   mana: 1000   strength:700   agility:400 dexterity:500 startingMoney:2500   startingExperience:5

Hero Type: Paladin   name: Garl_Glittergold   mana: 100   strength:600   agility:500 dexterity:400 startingMoney:2500   startingExperience:5

Hero Type: Warrior   name: Eunoia_Cyn   mana: 400   strength:700   agility:800 dexterity:600 startingMoney:2500   startingExperience:6

Hero Type: Paladin   name: Skoraeus_Stonebones   mana: 250   strength:650   agility:600 dexterity:350 startingMoney:2500   startingExperience:4

Hero Type: Sorcerer   name: Reign_Havoc   mana: 800   strength:800   agility:800 dexterity:800 startingMoney:2500   startingExperience:8

Hero Type: Sorcerer   name: Reverie_Ashels   mana: 900   strength:800   agility:700 dexterity:400 startingMoney:2500   startingExperience:7

Hero Type: Warrior   name: Undefeated_Yoj   mana: 400   strength:800   agility:400 dexterity:700 startingMoney:2500   startingExperience:7

Hero Type: Paladin   name: Solonor_Thelandira   mana: 300   strength:750   agility:650 dexterity:700 startingMoney:2500   startingExperience:7

Hero Type: Paladin   name: Amaryllis_Astra   mana: 500   strength:500   agility:500 dexterity:500 startingMoney:2500   startingExperience:5

--------------------------------------------------------
Creating No.1 hero...
Please copy down one name of the hero you want to add. (Enter Q/q to quit)Sehanine_Monnbow
Successfully create new Hero: Sehanine_Monnbow

Creating No.2 hero...
Please copy down one name of the hero you want to add. (Enter Q/q to quit)Caliber_Heist
Successfully create new Hero: Caliber_Heist

Creating No.3 hero...
Please copy down one name of the hero you want to add. (Enter Q/q to quit)Radiant_Ash
Successfully create new Hero: Radiant_Ash


                 BOARD
--------------------------------------------------------
|     ||  X  ||     ||  $  ||  $  ||     ||  X  ||     |
--------------------------------------------------------
|     ||  ✵  ||  $  ||  $  ||  $  ||  $  ||  X  ||     |
--------------------------------------------------------
|     ||  $  ||     ||  $  ||     ||     ||     ||  $  |
--------------------------------------------------------
|     ||     ||     ||  X  ||  $  ||  $  ||  $  ||  X  |
--------------------------------------------------------
|  $  ||     ||     ||  $  ||     ||     ||  $  ||  X  |
--------------------------------------------------------
|     ||     ||  $  ||     ||     ||  $  ||     ||  $  |
--------------------------------------------------------
|  $  ||  X  ||     ||     ||     ||     ||  X  ||     |
--------------------------------------------------------
|     ||     ||     ||     ||     ||     ||     ||     |
--------------------------------------------------------
|     |: Common Space
|  $  |: Market Space
|  X  |: Inaccessible Space 
|  ✵  |: You are here!
--------------------------------------------------------
+ + + + + + + + + + + + Menu + + + + + + + + + + + +
(W/w) Move up
(A/a) Move left
(S/s) Move down
(D/d) Move right
(B/b) Open bag
(I/i) Show info
(Q/q) Quit

Your choice:w
ERROR INPUT: You aim to move to an inaccessible cell

                 BOARD
--------------------------------------------------------
|     ||  X  ||     ||  $  ||  $  ||     ||  X  ||     |
--------------------------------------------------------
|     ||  ✵  ||  $  ||  $  ||  $  ||  $  ||  X  ||     |
--------------------------------------------------------
|     ||  $  ||     ||  $  ||     ||     ||     ||  $  |
--------------------------------------------------------
|     ||     ||     ||  X  ||  $  ||  $  ||  $  ||  X  |
--------------------------------------------------------
|  $  ||     ||     ||  $  ||     ||     ||  $  ||  X  |
--------------------------------------------------------
|     ||     ||  $  ||     ||     ||  $  ||     ||  $  |
--------------------------------------------------------
|  $  ||  X  ||     ||     ||     ||     ||  X  ||     |
--------------------------------------------------------
|     ||     ||     ||     ||     ||     ||     ||     |
--------------------------------------------------------
|     |: Common Space
|  $  |: Market Space
|  X  |: Inaccessible Space 
|  ✵  |: You are here!
--------------------------------------------------------
+ + + + + + + + + + + + Menu + + + + + + + + + + + +
(W/w) Move up
(A/a) Move left
(S/s) Move down
(D/d) Move right
(B/b) Open bag
(I/i) Show info
(Q/q) Quit

Your choice:a
Your team enters a common space!
Unfortunately, your team encounter a fight!

------------------------Get Ready to your Fight!---------------------
Oooops! There is/are 3 monsters! Your team need to defeat all!

     *  *  *     Fight Starts!    *  *  *           

+ + + + + + + + + + + + Round 1 + + + + + + + + + + + +

|  Hero  |Sehanine_Monnbow   Hp: 100   Level: 1   Status: Alive
|  Hero  |Caliber_Heist   Hp: 100   Level: 1   Status: Alive
|  Hero  |Radiant_Ash   Hp: 100   Level: 1   Status: Alive

|  Monster  |Casper   Hp: 100   Level: 1   Status: Alive
|  Monster  |Aim-Haborym   Hp: 100   Level: 1   Status: Alive
|  Monster  |BigBad-Wolf   Hp: 100   Level: 1   Status: Alive

|  Hero Sehanine_Monnbow, please be ready for your fight against Monster Casper!  |
+ + + + + + + + + + + + Fight choice + + + + + + + + + + + +
(A/a) Regular attack
(S/s) Spell
(P/p) Potion
(C/c) Change/Equip Armor/Weapon
(I/i) Info
(Q/q) quit
Your choice: i
--------------------------------------------------------

name -----------> [ Sehanine_Monnbow ]
level ----------> [ 1 ]
hp -------------> [ 100 ]
mana -----------> [ 600 ]
strength -------> [ 700 ]
dexterity ------> [ 500 ]
agility --------> [ 800 ]
defense --------> [ 0 ]
money ----------> [ 2500 ]
experience -----> [ 8 ]
--------------------------------------------------------
weapon ---------> [ NONE ]
armor ----------> [ NONE ]
--------------------------------------------------------

------------------------Sehanine_Monnbow's Bag---------------------

+ + + + + + + + + + + +  WEAPON  + + + + + + + + + + + +
Empty
--------------------------------------------------------

+ + + + + + + + + + + +  ARMOR  + + + + + + + + + + + +
Empty
--------------------------------------------------------

+ + + + + + + + + + + +  SPELL  + + + + + + + + + + + +
Empty
--------------------------------------------------------

+ + + + + + + + + + + +  POTION  + + + + + + + + + + + +
Empty
--------------------------------------------------------

+ + + + + + + + + + + + Fight choice + + + + + + + + + + + +
(A/a) Regular attack
(S/s) Spell
(P/p) Potion
(C/c) Change/Equip Armor/Weapon
(I/i) Info
(Q/q) quit
Your choice: s
--------------------------------------------------------

+ + + + + + + + + + + +  SPELL  + + + + + + + + + + + +
Empty
--------------------------------------------------------

ERROR INPUT: You do not have any spell in the bag!
+ + + + + + + + + + + + Fight choice + + + + + + + + + + + +
(A/a) Regular attack
(S/s) Spell
(P/p) Potion
(C/c) Change/Equip Armor/Weapon
(I/i) Info
(Q/q) quit
Your choice: p
--------------------------------------------------------

+ + + + + + + + + + + +  POTION  + + + + + + + + + + + +
Empty
--------------------------------------------------------

ERROR INPUT: You do not have any potion in the bag!
+ + + + + + + + + + + + Fight choice + + + + + + + + + + + +
(A/a) Regular attack
(S/s) Spell
(P/p) Potion
(C/c) Change/Equip Armor/Weapon
(I/i) Info
(Q/q) quit
Your choice: a
--------------------------------------------------------

|  Hero  | Sehanine_Monnbow  -----35 damage---->  |  Monster   |Casper

After defense, Monster Casper Hp: 100 -> 70

|  Monster  | Casper  -----5 damage---->  |  Hero   |Sehanine_Monnbow

After defense, Hero Sehanine_Monnbow Hp: 100 -> 95

|  Hero  |Sehanine_Monnbow restoring 10% lost hp and mana from last fight.... 

Hp: 95 -> 95
Mana: 600 -> 600

|  Hero Caliber_Heist, please be ready for your fight against Monster Aim-Haborym!  |
+ + + + + + + + + + + + Fight choice + + + + + + + + + + + +
(A/a) Regular attack
(S/s) Spell
(P/p) Potion
(C/c) Change/Equip Armor/Weapon
(I/i) Info
(Q/q) quit
Your choice: a
--------------------------------------------------------

|  Hero  | Caliber_Heist  -----20 damage---->  |  Monster   |Aim-Haborym

After defense, Monster Aim-Haborym Hp: 100 -> 97

|  Monster  | Aim-Haborym  -----22 damage---->  |  Hero   |Caliber_Heist

After defense, Hero Caliber_Heist Hp: 100 -> 78

|  Hero  |Caliber_Heist restoring 10% lost hp and mana from last fight.... 

Hp: 78 -> 80
Mana: 400 -> 400

|  Hero Radiant_Ash, please be ready for your fight against Monster BigBad-Wolf!  |
+ + + + + + + + + + + + Fight choice + + + + + + + + + + + +
(A/a) Regular attack
(S/s) Spell
(P/p) Potion
(C/c) Change/Equip Armor/Weapon
(I/i) Info
(Q/q) quit
Your choice: a
--------------------------------------------------------

|  Hero  | Radiant_Ash  -----42 damage---->  |  Monster   |BigBad-Wolf

After defense, Monster BigBad-Wolf Hp: 100 -> 70

|  Monster  | BigBad-Wolf  -----7 damage---->  |  Hero   |Radiant_Ash

After defense, Hero Radiant_Ash Hp: 100 -> 93

|  Hero  |Radiant_Ash restoring 10% lost hp and mana from last fight.... 

Hp: 93 -> 93
Mana: 800 -> 800


+ + + + + + + + + + + + Round 2 + + + + + + + + + + + +

|  Hero  |Sehanine_Monnbow   Hp: 95   Level: 1   Status: Alive
|  Hero  |Caliber_Heist   Hp: 80   Level: 1   Status: Alive
|  Hero  |Radiant_Ash   Hp: 93   Level: 1   Status: Alive

|  Monster  |Casper   Hp: 70   Level: 1   Status: Alive
|  Monster  |Aim-Haborym   Hp: 97   Level: 1   Status: Alive
|  Monster  |BigBad-Wolf   Hp: 70   Level: 1   Status: Alive

|  Hero Sehanine_Monnbow, please be ready for your fight against Monster Casper!  |
+ + + + + + + + + + + + Fight choice + + + + + + + + + + + +
(A/a) Regular attack
(S/s) Spell
(P/p) Potion
(C/c) Change/Equip Armor/Weapon
(I/i) Info
(Q/q) quit
Your choice: a
--------------------------------------------------------

|  Hero  | Sehanine_Monnbow  -----35 damage---->  |  Monster   |Casper

After defense, Monster Casper Hp: 70 -> 40

|  Monster  | Casper  -----5 damage---->  |  Hero   |Sehanine_Monnbow

After defense, Hero Sehanine_Monnbow Hp: 95 -> 90

|  Hero  |Sehanine_Monnbow restoring 10% lost hp and mana from last fight.... 

Hp: 90 -> 90
Mana: 600 -> 600

|  Hero Caliber_Heist, please be ready for your fight against Monster Aim-Haborym!  |
+ + + + + + + + + + + + Fight choice + + + + + + + + + + + +
(A/a) Regular attack
(S/s) Spell
(P/p) Potion
(C/c) Change/Equip Armor/Weapon
(I/i) Info
(Q/q) quit
Your choice: a
--------------------------------------------------------

|  Hero  | Caliber_Heist  -----20 damage---->  |  Monster   |Aim-Haborym

After defense, Monster Aim-Haborym Hp: 97 -> 94

|  Monster  | Aim-Haborym  -----22 damage---->  |  Hero   |Caliber_Heist

After defense, Hero Caliber_Heist Hp: 80 -> 58

|  Hero  |Caliber_Heist restoring 10% lost hp and mana from last fight.... 

Hp: 58 -> 60
Mana: 400 -> 400

|  Hero Radiant_Ash, please be ready for your fight against Monster BigBad-Wolf!  |
+ + + + + + + + + + + + Fight choice + + + + + + + + + + + +
(A/a) Regular attack
(S/s) Spell
(P/p) Potion
(C/c) Change/Equip Armor/Weapon
(I/i) Info
(Q/q) quit
Your choice: a
--------------------------------------------------------

|  Hero  | Radiant_Ash  -----42 damage---->  |  Monster   |BigBad-Wolf

After defense, Monster BigBad-Wolf Hp: 70 -> 40

|  Monster  | BigBad-Wolf  -----7 damage---->  |  Hero   |Radiant_Ash

After defense, Hero Radiant_Ash Hp: 93 -> 86

|  Hero  |Radiant_Ash restoring 10% lost hp and mana from last fight.... 

Hp: 86 -> 86
Mana: 800 -> 800


+ + + + + + + + + + + + Round 3 + + + + + + + + + + + +

|  Hero  |Sehanine_Monnbow   Hp: 90   Level: 1   Status: Alive
|  Hero  |Caliber_Heist   Hp: 60   Level: 1   Status: Alive
|  Hero  |Radiant_Ash   Hp: 86   Level: 1   Status: Alive

|  Monster  |Casper   Hp: 40   Level: 1   Status: Alive
|  Monster  |Aim-Haborym   Hp: 94   Level: 1   Status: Alive
|  Monster  |BigBad-Wolf   Hp: 40   Level: 1   Status: Alive

|  Hero Sehanine_Monnbow, please be ready for your fight against Monster Casper!  |
+ + + + + + + + + + + + Fight choice + + + + + + + + + + + +
(A/a) Regular attack
(S/s) Spell
(P/p) Potion
(C/c) Change/Equip Armor/Weapon
(I/i) Info
(Q/q) quit
Your choice: a
--------------------------------------------------------

|  Hero  | Sehanine_Monnbow  -----35 damage---->  |  Monster   |Casper

After defense, Monster Casper Hp: 40 -> 10

|  Monster  | Casper  -----5 damage---->  |  Hero   |Sehanine_Monnbow

After defense, Hero Sehanine_Monnbow Hp: 90 -> 85

|  Hero  |Sehanine_Monnbow restoring 10% lost hp and mana from last fight.... 

Hp: 85 -> 85
Mana: 600 -> 600

|  Hero Caliber_Heist, please be ready for your fight against Monster Aim-Haborym!  |
+ + + + + + + + + + + + Fight choice + + + + + + + + + + + +
(A/a) Regular attack
(S/s) Spell
(P/p) Potion
(C/c) Change/Equip Armor/Weapon
(I/i) Info
(Q/q) quit
Your choice: a
--------------------------------------------------------

|  Hero  | Caliber_Heist  -----20 damage---->  |  Monster   |Aim-Haborym

After defense, Monster Aim-Haborym Hp: 94 -> 91

|  Monster  | Aim-Haborym  -----22 damage---->  |  Hero   |Caliber_Heist

After defense, Hero Caliber_Heist Hp: 60 -> 38

|  Hero  |Caliber_Heist restoring 10% lost hp and mana from last fight.... 

Hp: 38 -> 40
Mana: 400 -> 400

|  Hero Radiant_Ash, please be ready for your fight against Monster BigBad-Wolf!  |
+ + + + + + + + + + + + Fight choice + + + + + + + + + + + +
(A/a) Regular attack
(S/s) Spell
(P/p) Potion
(C/c) Change/Equip Armor/Weapon
(I/i) Info
(Q/q) quit
Your choice: a
--------------------------------------------------------

|  Hero  | Radiant_Ash  -----42 damage---->  |  Monster   |BigBad-Wolf

After defense, Monster BigBad-Wolf Hp: 40 -> 10

|  Monster  | BigBad-Wolf  -----7 damage---->  |  Hero   |Radiant_Ash

After defense, Hero Radiant_Ash Hp: 86 -> 79

|  Hero  |Radiant_Ash restoring 10% lost hp and mana from last fight.... 

Hp: 79 -> 79
Mana: 800 -> 800


+ + + + + + + + + + + + Round 4 + + + + + + + + + + + +

|  Hero  |Sehanine_Monnbow   Hp: 85   Level: 1   Status: Alive
|  Hero  |Caliber_Heist   Hp: 40   Level: 1   Status: Alive
|  Hero  |Radiant_Ash   Hp: 79   Level: 1   Status: Alive

|  Monster  |Casper   Hp: 10   Level: 1   Status: Alive
|  Monster  |Aim-Haborym   Hp: 91   Level: 1   Status: Alive
|  Monster  |BigBad-Wolf   Hp: 10   Level: 1   Status: Alive

|  Hero Sehanine_Monnbow, please be ready for your fight against Monster Casper!  |
+ + + + + + + + + + + + Fight choice + + + + + + + + + + + +
(A/a) Regular attack
(S/s) Spell
(P/p) Potion
(C/c) Change/Equip Armor/Weapon
(I/i) Info
(Q/q) quit
Your choice: a
--------------------------------------------------------

|  Hero  | Sehanine_Monnbow  -----35 damage---->  |  Monster   |Casper

After defense, Monster Casper Hp: 10 -> 0

Hero Sehanine_Monnbow has defeated Monster Casper
|  Hero Caliber_Heist, please be ready for your fight against Monster Aim-Haborym!  |
+ + + + + + + + + + + + Fight choice + + + + + + + + + + + +
(A/a) Regular attack
(S/s) Spell
(P/p) Potion
(C/c) Change/Equip Armor/Weapon
(I/i) Info
(Q/q) quit
Your choice: a
--------------------------------------------------------

|  Hero  | Caliber_Heist  -----20 damage---->  |  Monster   |Aim-Haborym

After defense, Monster Aim-Haborym Hp: 91 -> 88

|  Monster  | Aim-Haborym  -----22 damage---->  |  Hero   |Caliber_Heist

After defense, Hero Caliber_Heist Hp: 40 -> 18

|  Hero  |Caliber_Heist restoring 10% lost hp and mana from last fight.... 

Hp: 18 -> 20
Mana: 400 -> 400

|  Hero Radiant_Ash, please be ready for your fight against Monster BigBad-Wolf!  |
+ + + + + + + + + + + + Fight choice + + + + + + + + + + + +
(A/a) Regular attack
(S/s) Spell
(P/p) Potion
(C/c) Change/Equip Armor/Weapon
(I/i) Info
(Q/q) quit
Your choice: a
--------------------------------------------------------

|  Hero  | Radiant_Ash  -----42 damage---->  |  Monster   |BigBad-Wolf

After defense, Monster BigBad-Wolf Hp: 10 -> 0

Hero Radiant_Ash has defeated Monster BigBad-Wolf

+ + + + + + + + + + + + Round 5 + + + + + + + + + + + +

|  Hero  |Sehanine_Monnbow   Hp: 85   Level: 1   Status: Alive
|  Hero  |Caliber_Heist   Hp: 20   Level: 1   Status: Alive
|  Hero  |Radiant_Ash   Hp: 79   Level: 1   Status: Alive

|  Monster  |Casper   Hp: 0   Level: 1   Status: Dead
|  Monster  |Aim-Haborym   Hp: 88   Level: 1   Status: Alive
|  Monster  |BigBad-Wolf   Hp: 0   Level: 1   Status: Dead

|  Hero Sehanine_Monnbow please get ready for your fight against Monster Aim-Haborym  |
+ + + + + + + + + + + + Fight choice + + + + + + + + + + + +
(A/a) Regular attack
(S/s) Spell
(P/p) Potion
(C/c) Change/Equip Armor/Weapon
(I/i) Info
(Q/q) quit
Your choice: a
--------------------------------------------------------

|  Hero  | Sehanine_Monnbow  -----35 damage---->  |  Monster   |Aim-Haborym

After defense, Monster Aim-Haborym Hp: 88 -> 70

|  Monster  | Aim-Haborym  -----22 damage---->  |  Hero   |Sehanine_Monnbow

After defense, Hero Sehanine_Monnbow Hp: 85 -> 63

|  Hero  |Sehanine_Monnbow restoring 10% lost hp and mana from last fight.... 

Hp: 63 -> 65
Mana: 600 -> 600

|  Hero Caliber_Heist, please be ready for your fight against Monster Aim-Haborym!  |
+ + + + + + + + + + + + Fight choice + + + + + + + + + + + +
(A/a) Regular attack
(S/s) Spell
(P/p) Potion
(C/c) Change/Equip Armor/Weapon
(I/i) Info
(Q/q) quit
Your choice: a
--------------------------------------------------------

|  Hero  | Caliber_Heist  -----20 damage---->  |  Monster   |Aim-Haborym

After defense, Monster Aim-Haborym Hp: 70 -> 67

|  Monster  | Aim-Haborym  -----22 damage---->  |  Hero   |Caliber_Heist

After defense, Hero Caliber_Heist Hp: 20 -> 0

Hero Caliber_Heist has been defeated by Monster Aim-Haborym
|  Hero Radiant_Ash please get ready for your fight against Monster Aim-Haborym  |
+ + + + + + + + + + + + Fight choice + + + + + + + + + + + +
(A/a) Regular attack
(S/s) Spell
(P/p) Potion
(C/c) Change/Equip Armor/Weapon
(I/i) Info
(Q/q) quit
Your choice: a
--------------------------------------------------------

|  Hero  | Radiant_Ash  -----42 damage---->  |  Monster   |Aim-Haborym

After defense, Monster Aim-Haborym Hp: 67 -> 42

|  Monster  | Aim-Haborym  -----22 damage---->  |  Hero   |Radiant_Ash

After defense, Hero Radiant_Ash Hp: 79 -> 57

|  Hero  |Radiant_Ash restoring 10% lost hp and mana from last fight.... 

Hp: 57 -> 59
Mana: 800 -> 800


+ + + + + + + + + + + + Round 6 + + + + + + + + + + + +

|  Hero  |Sehanine_Monnbow   Hp: 65   Level: 1   Status: Alive
|  Hero  |Caliber_Heist   Hp: 0   Level: 1   Status: Dead
|  Hero  |Radiant_Ash   Hp: 59   Level: 1   Status: Alive

|  Monster  |Casper   Hp: 0   Level: 1   Status: Dead
|  Monster  |Aim-Haborym   Hp: 42   Level: 1   Status: Alive
|  Monster  |BigBad-Wolf   Hp: 0   Level: 1   Status: Dead

|  Hero Sehanine_Monnbow please get ready for your fight against Monster Aim-Haborym  |
+ + + + + + + + + + + + Fight choice + + + + + + + + + + + +
(A/a) Regular attack
(S/s) Spell
(P/p) Potion
(C/c) Change/Equip Armor/Weapon
(I/i) Info
(Q/q) quit
Your choice: a
--------------------------------------------------------

|  Hero  | Sehanine_Monnbow  -----35 damage---->  |  Monster   |Aim-Haborym

After defense, Monster Aim-Haborym Hp: 42 -> 24

|  Monster  | Aim-Haborym  -----22 damage---->  |  Hero   |Sehanine_Monnbow

After defense, Hero Sehanine_Monnbow Hp: 65 -> 43

|  Hero  |Sehanine_Monnbow restoring 10% lost hp and mana from last fight.... 

Hp: 43 -> 45
Mana: 600 -> 600

|  Hero Radiant_Ash please get ready for your fight against Monster Aim-Haborym  |
+ + + + + + + + + + + + Fight choice + + + + + + + + + + + +
(A/a) Regular attack
(S/s) Spell
(P/p) Potion
(C/c) Change/Equip Armor/Weapon
(I/i) Info
(Q/q) quit
Your choice: a
--------------------------------------------------------

|  Hero  | Radiant_Ash  -----42 damage---->  |  Monster   |Aim-Haborym

After defense, Monster Aim-Haborym Hp: 24 -> 0

Hero Radiant_Ash has defeated Monster Aim-Haborym
|  Hero Sehanine_Monnbow please get ready for your fight against Monster Aim-Haborym  |
+ + + + + + + + + + + + Fight choice + + + + + + + + + + + +
(A/a) Regular attack
(S/s) Spell
(P/p) Potion
(C/c) Change/Equip Armor/Weapon
(I/i) Info
(Q/q) quit
Your choice: q
--------------------------------------------------------

|        GAME OVER         |(base) JZJZ:src amari$ cd /Users/amari/Documents/Boston_University/CS611/test/Legends 
(base) JZJZ:Legends amari$ ls
README.md	src
(base) JZJZ:Legends amari$ cd src
(base) JZJZ:src amari$ javac *.java
(base) JZJZ:src amari$ java Main
           WELCOME!               
Get ready to start your adventure!
Cannot find config file
Enter a number 1-3 to set the size of your team: 
3

------------------------Hero List---------------------
Hero Type: Warrior   name: Sehanine_Monnbow   mana: 600   strength:700   agility:800 dexterity:500 startingMoney:2500   startingExperience:8

Hero Type: Paladin   name: Caliber_Heist   mana: 400   strength:400   agility:400 dexterity:400 startingMoney:2500   startingExperience:2

Hero Type: Sorcerer   name: Radiant_Ash   mana: 800   strength:850   agility:400 dexterity:600 startingMoney:2500   startingExperience:6

Hero Type: Sorcerer   name: Rillifane_Rallathil   mana: 1300   strength:750   agility:450 dexterity:500 startingMoney:2500   startingExperience:9

Hero Type: Sorcerer   name: Segojan_Earthcaller   mana: 900   strength:800   agility:500 dexterity:650 startingMoney:2500   startingExperience:5

Hero Type: Warrior   name: Gaerdal_Ironhand   mana: 100   strength:700   agility:500 dexterity:600 startingMoney:1354   startingExperience:7

Hero Type: Warrior   name: Muamman_Duathall   mana: 300   strength:900   agility:500 dexterity:750 startingMoney:2546   startingExperience:6

Hero Type: Warrior   name: Flandal_Steelskin   mana: 200   strength:750   agility:650 dexterity:700 startingMoney:2500   startingExperience:7

Hero Type: Paladin   name: Sehanine_Moonbow   mana: 300   strength:750   agility:700 dexterity:700 startingMoney:2500   startingExperience:7

Hero Type: Sorcerer   name: Skye_Soar   mana: 1000   strength:700   agility:400 dexterity:500 startingMoney:2500   startingExperience:5

Hero Type: Paladin   name: Garl_Glittergold   mana: 100   strength:600   agility:500 dexterity:400 startingMoney:2500   startingExperience:5

Hero Type: Warrior   name: Eunoia_Cyn   mana: 400   strength:700   agility:800 dexterity:600 startingMoney:2500   startingExperience:6

Hero Type: Paladin   name: Skoraeus_Stonebones   mana: 250   strength:650   agility:600 dexterity:350 startingMoney:2500   startingExperience:4

Hero Type: Sorcerer   name: Reign_Havoc   mana: 800   strength:800   agility:800 dexterity:800 startingMoney:2500   startingExperience:8

Hero Type: Sorcerer   name: Reverie_Ashels   mana: 900   strength:800   agility:700 dexterity:400 startingMoney:2500   startingExperience:7

Hero Type: Warrior   name: Undefeated_Yoj   mana: 400   strength:800   agility:400 dexterity:700 startingMoney:2500   startingExperience:7

Hero Type: Paladin   name: Solonor_Thelandira   mana: 300   strength:750   agility:650 dexterity:700 startingMoney:2500   startingExperience:7

Hero Type: Paladin   name: Amaryllis_Astra   mana: 500   strength:500   agility:500 dexterity:500 startingMoney:2500   startingExperience:5

--------------------------------------------------------
Creating No.1 hero...
Please copy down one name of the hero you want to add. (Enter Q/q to quit)Skye_Soar
Successfully create new Hero: Skye_Soar

Creating No.2 hero...
Please copy down one name of the hero you want to add. (Enter Q/q to quit)Amaryllis_Astra
Successfully create new Hero: Amaryllis_Astra

Creating No.3 hero...
Please copy down one name of the hero you want to add. (Enter Q/q to quit)Reverie_Ashels
Successfully create new Hero: Reverie_Ashels


                 BOARD
--------------------------------------------------------
|  $  ||     ||  X  ||  X  ||  $  ||  X  ||     ||  $  |
--------------------------------------------------------
|  X  ||  X  ||     ||     ||  X  ||  $  ||  $  ||     |
--------------------------------------------------------
|  $  ||     ||  $  ||     ||     ||  $  ||     ||  X  |
--------------------------------------------------------
|     ||     ||     ||     ||  $  ||  $  ||     ||     |
--------------------------------------------------------
|     ||     ||     ||     ||     ||  $  ||     ||  X  |
--------------------------------------------------------
|  $  ||     ||     ||     ||  X  ||  $  ||  $  ||  $  |
--------------------------------------------------------
|     ||  ✵  ||  $  ||  X  ||  $  ||     ||  X  ||     |
--------------------------------------------------------
|  $  ||  $  ||     ||     ||  X  ||     ||     ||     |
--------------------------------------------------------
|     |: Common Space
|  $  |: Market Space
|  X  |: Inaccessible Space 
|  ✵  |: You are here!
--------------------------------------------------------
+ + + + + + + + + + + + Menu + + + + + + + + + + + +
(W/w) Move up
(A/a) Move left
(S/s) Move down
(D/d) Move right
(B/b) Open bag
(I/i) Show info
(Q/q) Quit

Your choice:w
Your team enters a common space!
Unfortunately, your team encounter a fight!

------------------------Get Ready to your Fight!---------------------
Oooops! There is/are 3 monsters! Your team need to defeat all!

     *  *  *     Fight Starts!    *  *  *           

+ + + + + + + + + + + + Round 1 + + + + + + + + + + + +

|  Hero  |Skye_Soar   Hp: 100   Level: 1   Status: Alive
|  Hero  |Amaryllis_Astra   Hp: 100   Level: 1   Status: Alive
|  Hero  |Reverie_Ashels   Hp: 100   Level: 1   Status: Alive

|  Monster  |Natsunomeryu   Hp: 100   Level: 1   Status: Alive
|  Monster  |Casper   Hp: 100   Level: 1   Status: Alive
|  Monster  |BigBad-Wolf   Hp: 100   Level: 1   Status: Alive

|  Hero Skye_Soar, please be ready for your fight against Monster Natsunomeryu!  |
+ + + + + + + + + + + + Fight choice + + + + + + + + + + + +
(A/a) Regular attack
(S/s) Spell
(P/p) Potion
(C/c) Change/Equip Armor/Weapon
(I/i) Info
(Q/q) quit
Your choice: a
--------------------------------------------------------

|  Hero  | Skye_Soar  -----35 damage---->  |  Monster   |Natsunomeryu

After defense, Monster Natsunomeryu Hp: 100 -> 75

|  Monster  | Natsunomeryu  -----5 damage---->  |  Hero   |Skye_Soar

After defense, Hero Skye_Soar Hp: 100 -> 95

|  Hero  |Skye_Soar regains 10% of his/her hp and mana.... 

Hp: 95 -> 95
Mana: 1000 -> 1000

|  Hero Amaryllis_Astra, please be ready for your fight against Monster Casper!  |
+ + + + + + + + + + + + Fight choice + + + + + + + + + + + +
(A/a) Regular attack
(S/s) Spell
(P/p) Potion
(C/c) Change/Equip Armor/Weapon
(I/i) Info
(Q/q) quit
Your choice: a
--------------------------------------------------------

|  Hero  | Amaryllis_Astra  -----25 damage---->  |  Monster   |Casper

After defense, Monster Casper Hp: 100 -> 80

|  Monster  | Casper  -----5 damage---->  |  Hero   |Amaryllis_Astra

After defense, Hero Amaryllis_Astra Hp: 100 -> 95

|  Hero  |Amaryllis_Astra regains 10% of his/her hp and mana.... 

Hp: 95 -> 95
Mana: 500 -> 500

|  Hero Reverie_Ashels, please be ready for your fight against Monster BigBad-Wolf!  |
+ + + + + + + + + + + + Fight choice + + + + + + + + + + + +
(A/a) Regular attack
(S/s) Spell
(P/p) Potion
(C/c) Change/Equip Armor/Weapon
(I/i) Info
(Q/q) quit
Your choice: a
--------------------------------------------------------

|  Hero  | Reverie_Ashels  -----40 damage---->  |  Monster   |BigBad-Wolf

After defense, Monster BigBad-Wolf Hp: 100 -> 72

|  Monster  | BigBad-Wolf  -----7 damage---->  |  Hero   |Reverie_Ashels

After defense, Hero Reverie_Ashels Hp: 100 -> 93

|  Hero  |Reverie_Ashels regains 10% of his/her hp and mana.... 

Hp: 93 -> 93
Mana: 900 -> 900


+ + + + + + + + + + + + Round 2 + + + + + + + + + + + +

|  Hero  |Skye_Soar   Hp: 95   Level: 1   Status: Alive
|  Hero  |Amaryllis_Astra   Hp: 95   Level: 1   Status: Alive
|  Hero  |Reverie_Ashels   Hp: 93   Level: 1   Status: Alive

|  Monster  |Natsunomeryu   Hp: 75   Level: 1   Status: Alive
|  Monster  |Casper   Hp: 80   Level: 1   Status: Alive
|  Monster  |BigBad-Wolf   Hp: 72   Level: 1   Status: Alive

|  Hero Skye_Soar, please be ready for your fight against Monster Natsunomeryu!  |
+ + + + + + + + + + + + Fight choice + + + + + + + + + + + +
(A/a) Regular attack
(S/s) Spell
(P/p) Potion
(C/c) Change/Equip Armor/Weapon
(I/i) Info
(Q/q) quit
Your choice: a
--------------------------------------------------------

|  Hero  | Skye_Soar  -----35 damage---->  |  Monster   |Natsunomeryu

After defense, Monster Natsunomeryu Hp: 75 -> 50

|  Monster  | Natsunomeryu  -----5 damage---->  |  Hero   |Skye_Soar

After defense, Hero Skye_Soar Hp: 95 -> 90

|  Hero  |Skye_Soar regains 10% of his/her hp and mana.... 

Hp: 90 -> 90
Mana: 1000 -> 1000

|  Hero Amaryllis_Astra, please be ready for your fight against Monster Casper!  |
+ + + + + + + + + + + + Fight choice + + + + + + + + + + + +
(A/a) Regular attack
(S/s) Spell
(P/p) Potion
(C/c) Change/Equip Armor/Weapon
(I/i) Info
(Q/q) quit
Your choice: a
--------------------------------------------------------

|  Hero  | Amaryllis_Astra  -----25 damage---->  |  Monster   |Casper

After defense, Monster Casper Hp: 80 -> 60

|  Monster  | Casper  -----5 damage---->  |  Hero   |Amaryllis_Astra

After defense, Hero Amaryllis_Astra Hp: 95 -> 90

|  Hero  |Amaryllis_Astra regains 10% of his/her hp and mana.... 

Hp: 90 -> 90
Mana: 500 -> 500

|  Hero Reverie_Ashels, please be ready for your fight against Monster BigBad-Wolf!  |
+ + + + + + + + + + + + Fight choice + + + + + + + + + + + +
(A/a) Regular attack
(S/s) Spell
(P/p) Potion
(C/c) Change/Equip Armor/Weapon
(I/i) Info
(Q/q) quit
Your choice: a
--------------------------------------------------------

|  Hero  | Reverie_Ashels  -----40 damage---->  |  Monster   |BigBad-Wolf

After defense, Monster BigBad-Wolf Hp: 72 -> 44

|  Monster  | BigBad-Wolf  -----7 damage---->  |  Hero   |Reverie_Ashels

After defense, Hero Reverie_Ashels Hp: 93 -> 86

|  Hero  |Reverie_Ashels regains 10% of his/her hp and mana.... 

Hp: 86 -> 86
Mana: 900 -> 900


+ + + + + + + + + + + + Round 3 + + + + + + + + + + + +

|  Hero  |Skye_Soar   Hp: 90   Level: 1   Status: Alive
|  Hero  |Amaryllis_Astra   Hp: 90   Level: 1   Status: Alive
|  Hero  |Reverie_Ashels   Hp: 86   Level: 1   Status: Alive

|  Monster  |Natsunomeryu   Hp: 50   Level: 1   Status: Alive
|  Monster  |Casper   Hp: 60   Level: 1   Status: Alive
|  Monster  |BigBad-Wolf   Hp: 44   Level: 1   Status: Alive

|  Hero Skye_Soar, please be ready for your fight against Monster Natsunomeryu!  |
+ + + + + + + + + + + + Fight choice + + + + + + + + + + + +
(A/a) Regular attack
(S/s) Spell
(P/p) Potion
(C/c) Change/Equip Armor/Weapon
(I/i) Info
(Q/q) quit
Your choice: a
--------------------------------------------------------

|  Hero  | Skye_Soar  -----35 damage---->  |  Monster   |Natsunomeryu

After defense, Monster Natsunomeryu Hp: 50 -> 25

|  Monster  | Natsunomeryu  -----5 damage---->  |  Hero   |Skye_Soar

After defense, Hero Skye_Soar Hp: 90 -> 85

|  Hero  |Skye_Soar regains 10% of his/her hp and mana.... 

Hp: 85 -> 85
Mana: 1000 -> 1000

|  Hero Amaryllis_Astra, please be ready for your fight against Monster Casper!  |
+ + + + + + + + + + + + Fight choice + + + + + + + + + + + +
(A/a) Regular attack
(S/s) Spell
(P/p) Potion
(C/c) Change/Equip Armor/Weapon
(I/i) Info
(Q/q) quit
Your choice: a
--------------------------------------------------------

|  Hero  | Amaryllis_Astra  -----25 damage---->  |  Monster   |Casper

After defense, Monster Casper Hp: 60 -> 40

|  Monster  | Casper  -----5 damage---->  |  Hero   |Amaryllis_Astra

After defense, Hero Amaryllis_Astra Hp: 90 -> 85

|  Hero  |Amaryllis_Astra regains 10% of his/her hp and mana.... 

Hp: 85 -> 85
Mana: 500 -> 500

|  Hero Reverie_Ashels, please be ready for your fight against Monster BigBad-Wolf!  |
+ + + + + + + + + + + + Fight choice + + + + + + + + + + + +
(A/a) Regular attack
(S/s) Spell
(P/p) Potion
(C/c) Change/Equip Armor/Weapon
(I/i) Info
(Q/q) quit
Your choice: a
--------------------------------------------------------

|  Hero  | Reverie_Ashels  -----40 damage---->  |  Monster   |BigBad-Wolf

After defense, Monster BigBad-Wolf Hp: 44 -> 16

|  Monster  | BigBad-Wolf  -----7 damage---->  |  Hero   |Reverie_Ashels

After defense, Hero Reverie_Ashels Hp: 86 -> 79

|  Hero  |Reverie_Ashels regains 10% of his/her hp and mana.... 

Hp: 79 -> 79
Mana: 900 -> 900


+ + + + + + + + + + + + Round 4 + + + + + + + + + + + +

|  Hero  |Skye_Soar   Hp: 85   Level: 1   Status: Alive
|  Hero  |Amaryllis_Astra   Hp: 85   Level: 1   Status: Alive
|  Hero  |Reverie_Ashels   Hp: 79   Level: 1   Status: Alive

|  Monster  |Natsunomeryu   Hp: 25   Level: 1   Status: Alive
|  Monster  |Casper   Hp: 40   Level: 1   Status: Alive
|  Monster  |BigBad-Wolf   Hp: 16   Level: 1   Status: Alive

|  Hero Skye_Soar, please be ready for your fight against Monster Natsunomeryu!  |
+ + + + + + + + + + + + Fight choice + + + + + + + + + + + +
(A/a) Regular attack
(S/s) Spell
(P/p) Potion
(C/c) Change/Equip Armor/Weapon
(I/i) Info
(Q/q) quit
Your choice: a 
--------------------------------------------------------

|  Hero  | Skye_Soar  -----35 damage---->  |  Monster   |Natsunomeryu

After defense, Monster Natsunomeryu Hp: 25 -> 0

Hero Skye_Soar has defeated Monster Natsunomeryu
|  Hero Amaryllis_Astra, please be ready for your fight against Monster Casper!  |
+ + + + + + + + + + + + Fight choice + + + + + + + + + + + +
(A/a) Regular attack
(S/s) Spell
(P/p) Potion
(C/c) Change/Equip Armor/Weapon
(I/i) Info
(Q/q) quit
Your choice: a
--------------------------------------------------------

|  Hero  | Amaryllis_Astra  -----25 damage---->  |  Monster   |Casper

After defense, Monster Casper Hp: 40 -> 20

|  Monster  | Casper  -----5 damage---->  |  Hero   |Amaryllis_Astra

After defense, Hero Amaryllis_Astra Hp: 85 -> 80

|  Hero  |Amaryllis_Astra regains 10% of his/her hp and mana.... 

Hp: 80 -> 80
Mana: 500 -> 500

|  Hero Reverie_Ashels, please be ready for your fight against Monster BigBad-Wolf!  |
+ + + + + + + + + + + + Fight choice + + + + + + + + + + + +
(A/a) Regular attack
(S/s) Spell
(P/p) Potion
(C/c) Change/Equip Armor/Weapon
(I/i) Info
(Q/q) quit
Your choice: a
--------------------------------------------------------

|  Hero  | Reverie_Ashels  -----40 damage---->  |  Monster   |BigBad-Wolf

After defense, Monster BigBad-Wolf Hp: 16 -> 0

Hero Reverie_Ashels has defeated Monster BigBad-Wolf

+ + + + + + + + + + + + Round 5 + + + + + + + + + + + +

|  Hero  |Skye_Soar   Hp: 85   Level: 1   Status: Alive
|  Hero  |Amaryllis_Astra   Hp: 80   Level: 1   Status: Alive
|  Hero  |Reverie_Ashels   Hp: 79   Level: 1   Status: Alive

|  Monster  |Natsunomeryu   Hp: 0   Level: 1   Status: Dead
|  Monster  |Casper   Hp: 20   Level: 1   Status: Alive
|  Monster  |BigBad-Wolf   Hp: 0   Level: 1   Status: Dead

Natsunomeryu is dead! so you should help other member!
Natsunomeryu is dead! Look for next monster
BigBad-Wolf is dead! Look for next monster
|  Hero Skye_Soar please get ready for your fight against Monster Casper  |
+ + + + + + + + + + + + Fight choice + + + + + + + + + + + +
(A/a) Regular attack
(S/s) Spell
(P/p) Potion
(C/c) Change/Equip Armor/Weapon
(I/i) Info
(Q/q) quit
Your choice: a
--------------------------------------------------------

|  Hero  | Skye_Soar  -----35 damage---->  |  Monster   |Casper

After defense, Monster Casper Hp: 20 -> 0

Hero Skye_Soar has defeated Monster Casper


Congratulations! Heroes win the game!!!
Skye_Soar still alive after this fight! 
Coins: 2500 -> 2600
Exp: 5 -> 7
Amaryllis_Astra still alive after this fight! 
Coins: 2500 -> 2600
Exp: 5 -> 7
Reverie_Ashels still alive after this fight! 
Coins: 2500 -> 2600
Exp: 7 -> 9

                 BOARD
--------------------------------------------------------
|  $  ||     ||  X  ||  X  ||  $  ||  X  ||     ||  $  |
--------------------------------------------------------
|  X  ||  X  ||     ||     ||  X  ||  $  ||  $  ||     |
--------------------------------------------------------
|  $  ||     ||  $  ||     ||     ||  $  ||     ||  X  |
--------------------------------------------------------
|     ||     ||     ||     ||  $  ||  $  ||     ||     |
--------------------------------------------------------
|     ||     ||     ||     ||     ||  $  ||     ||  X  |
--------------------------------------------------------
|  $  ||  ✵  ||     ||     ||  X  ||  $  ||  $  ||  $  |
--------------------------------------------------------
|     ||     ||  $  ||  X  ||  $  ||     ||  X  ||     |
--------------------------------------------------------
|  $  ||  $  ||     ||     ||  X  ||     ||     ||     |
--------------------------------------------------------
|     |: Common Space
|  $  |: Market Space
|  X  |: Inaccessible Space 
|  ✵  |: You are here!
--------------------------------------------------------
+ + + + + + + + + + + + Menu + + + + + + + + + + + +
(W/w) Move up
(A/a) Move left
(S/s) Move down
(D/d) Move right
(B/b) Open bag
(I/i) Show info
(Q/q) Quit

Your choice:d
Your team enters a common space!
Unfortunately, your team encounter a fight!

------------------------Get Ready to your Fight!---------------------
Oooops! There is/are 3 monsters! Your team need to defeat all!

     *  *  *     Fight Starts!    *  *  *           

+ + + + + + + + + + + + Round 1 + + + + + + + + + + + +

|  Hero  |Skye_Soar   Hp: 85   Level: 1   Status: Alive
|  Hero  |Amaryllis_Astra   Hp: 80   Level: 1   Status: Alive
|  Hero  |Reverie_Ashels   Hp: 79   Level: 1   Status: Alive

|  Monster  |Casper   Hp: 100   Level: 1   Status: Alive
|  Monster  |Natsunomeryu   Hp: 100   Level: 1   Status: Alive
|  Monster  |BigBad-Wolf   Hp: 100   Level: 1   Status: Alive

|  Hero Skye_Soar, please be ready for your fight against Monster Casper!  |
+ + + + + + + + + + + + Fight choice + + + + + + + + + + + +
(A/a) Regular attack
(S/s) Spell
(P/p) Potion
(C/c) Change/Equip Armor/Weapon
(I/i) Info
(Q/q) quit
Your choice: a
--------------------------------------------------------

|  Hero  | Skye_Soar  -----35 damage---->  |  Monster   |Casper

After defense, Monster Casper Hp: 100 -> 70

|  Monster  | Casper  -----5 damage---->  |  Hero   |Skye_Soar

After defense, Hero Skye_Soar Hp: 85 -> 80

|  Hero  |Skye_Soar regains 10% of his/her hp and mana.... 

Hp: 80 -> 80
Mana: 1000 -> 1000

|  Hero Amaryllis_Astra, please be ready for your fight against Monster Natsunomeryu!  |
+ + + + + + + + + + + + Fight choice + + + + + + + + + + + +
(A/a) Regular attack
(S/s) Spell
(P/p) Potion
(C/c) Change/Equip Armor/Weapon
(I/i) Info
(Q/q) quit
Your choice: a
--------------------------------------------------------

|  Hero  | Amaryllis_Astra  -----25 damage---->  |  Monster   |Natsunomeryu

After defense, Monster Natsunomeryu Hp: 100 -> 85

|  Monster  | Natsunomeryu  -----5 damage---->  |  Hero   |Amaryllis_Astra

After defense, Hero Amaryllis_Astra Hp: 80 -> 75

|  Hero  |Amaryllis_Astra regains 10% of his/her hp and mana.... 

Hp: 75 -> 75
Mana: 500 -> 500

|  Hero Reverie_Ashels, please be ready for your fight against Monster BigBad-Wolf!  |
+ + + + + + + + + + + + Fight choice + + + + + + + + + + + +
(A/a) Regular attack
(S/s) Spell
(P/p) Potion
(C/c) Change/Equip Armor/Weapon
(I/i) Info
(Q/q) quit
Your choice: a
--------------------------------------------------------

|  Hero  | Reverie_Ashels  -----40 damage---->  |  Monster   |BigBad-Wolf

After defense, Monster BigBad-Wolf Hp: 100 -> 72

|  Monster  | BigBad-Wolf  -----7 damage---->  |  Hero   |Reverie_Ashels

After defense, Hero Reverie_Ashels Hp: 79 -> 72

|  Hero  |Reverie_Ashels regains 10% of his/her hp and mana.... 

Hp: 72 -> 72
Mana: 900 -> 900


+ + + + + + + + + + + + Round 2 + + + + + + + + + + + +

|  Hero  |Skye_Soar   Hp: 80   Level: 1   Status: Alive
|  Hero  |Amaryllis_Astra   Hp: 75   Level: 1   Status: Alive
|  Hero  |Reverie_Ashels   Hp: 72   Level: 1   Status: Alive

|  Monster  |Casper   Hp: 70   Level: 1   Status: Alive
|  Monster  |Natsunomeryu   Hp: 85   Level: 1   Status: Alive
|  Monster  |BigBad-Wolf   Hp: 72   Level: 1   Status: Alive

|  Hero Skye_Soar, please be ready for your fight against Monster Casper!  |
+ + + + + + + + + + + + Fight choice + + + + + + + + + + + +
(A/a) Regular attack
(S/s) Spell
(P/p) Potion
(C/c) Change/Equip Armor/Weapon
(I/i) Info
(Q/q) quit
Your choice: a
--------------------------------------------------------

|  Hero  | Skye_Soar  -----35 damage---->  |  Monster   |Casper

After defense, Monster Casper Hp: 70 -> 40

|  Monster  | Casper  -----5 damage---->  |  Hero   |Skye_Soar

After defense, Hero Skye_Soar Hp: 80 -> 75

|  Hero  |Skye_Soar regains 10% of his/her hp and mana.... 

Hp: 75 -> 75
Mana: 1000 -> 1000

|  Hero Amaryllis_Astra, please be ready for your fight against Monster Natsunomeryu!  |
+ + + + + + + + + + + + Fight choice + + + + + + + + + + + +
(A/a) Regular attack
(S/s) Spell
(P/p) Potion
(C/c) Change/Equip Armor/Weapon
(I/i) Info
(Q/q) quit
Your choice: a
--------------------------------------------------------

|  Hero  | Amaryllis_Astra  -----25 damage---->  |  Monster   |Natsunomeryu

After defense, Monster Natsunomeryu Hp: 85 -> 70

|  Monster  | Natsunomeryu  -----5 damage---->  |  Hero   |Amaryllis_Astra

After defense, Hero Amaryllis_Astra Hp: 75 -> 70

|  Hero  |Amaryllis_Astra regains 10% of his/her hp and mana.... 

Hp: 70 -> 70
Mana: 500 -> 500

|  Hero Reverie_Ashels, please be ready for your fight against Monster BigBad-Wolf!  |
+ + + + + + + + + + + + Fight choice + + + + + + + + + + + +
(A/a) Regular attack
(S/s) Spell
(P/p) Potion
(C/c) Change/Equip Armor/Weapon
(I/i) Info
(Q/q) quit
Your choice: a
--------------------------------------------------------

|  Hero  | Reverie_Ashels  -----40 damage---->  |  Monster   |BigBad-Wolf

After defense, Monster BigBad-Wolf Hp: 72 -> 44

|  Monster  | BigBad-Wolf  -----7 damage---->  |  Hero   |Reverie_Ashels

After defense, Hero Reverie_Ashels Hp: 72 -> 65

|  Hero  |Reverie_Ashels regains 10% of his/her hp and mana.... 

Hp: 65 -> 65
Mana: 900 -> 900


+ + + + + + + + + + + + Round 3 + + + + + + + + + + + +

|  Hero  |Skye_Soar   Hp: 75   Level: 1   Status: Alive
|  Hero  |Amaryllis_Astra   Hp: 70   Level: 1   Status: Alive
|  Hero  |Reverie_Ashels   Hp: 65   Level: 1   Status: Alive

|  Monster  |Casper   Hp: 40   Level: 1   Status: Alive
|  Monster  |Natsunomeryu   Hp: 70   Level: 1   Status: Alive
|  Monster  |BigBad-Wolf   Hp: 44   Level: 1   Status: Alive

|  Hero Skye_Soar, please be ready for your fight against Monster Casper!  |
+ + + + + + + + + + + + Fight choice + + + + + + + + + + + +
(A/a) Regular attack
(S/s) Spell
(P/p) Potion
(C/c) Change/Equip Armor/Weapon
(I/i) Info
(Q/q) quit
Your choice: a
--------------------------------------------------------

|  Hero  | Skye_Soar  -----35 damage---->  |  Monster   |Casper

After defense, Monster Casper Hp: 40 -> 10

|  Monster  | Casper  -----5 damage---->  |  Hero   |Skye_Soar

After defense, Hero Skye_Soar Hp: 75 -> 70

|  Hero  |Skye_Soar regains 10% of his/her hp and mana.... 

Hp: 70 -> 70
Mana: 1000 -> 1000

|  Hero Amaryllis_Astra, please be ready for your fight against Monster Natsunomeryu!  |
+ + + + + + + + + + + + Fight choice + + + + + + + + + + + +
(A/a) Regular attack
(S/s) Spell
(P/p) Potion
(C/c) Change/Equip Armor/Weapon
(I/i) Info
(Q/q) quit
Your choice: a
--------------------------------------------------------

|  Hero  | Amaryllis_Astra  -----25 damage---->  |  Monster   |Natsunomeryu

After defense, Monster Natsunomeryu Hp: 70 -> 55

|  Monster  | Natsunomeryu  -----5 damage---->  |  Hero   |Amaryllis_Astra

After defense, Hero Amaryllis_Astra Hp: 70 -> 65

|  Hero  |Amaryllis_Astra regains 10% of his/her hp and mana.... 

Hp: 65 -> 65
Mana: 500 -> 500

|  Hero Reverie_Ashels, please be ready for your fight against Monster BigBad-Wolf!  |
+ + + + + + + + + + + + Fight choice + + + + + + + + + + + +
(A/a) Regular attack
(S/s) Spell
(P/p) Potion
(C/c) Change/Equip Armor/Weapon
(I/i) Info
(Q/q) quit
Your choice: a
--------------------------------------------------------

|  Hero  | Reverie_Ashels  -----40 damage---->  |  Monster   |BigBad-Wolf

After defense, Monster BigBad-Wolf Hp: 44 -> 16

|  Monster  | BigBad-Wolf  -----7 damage---->  |  Hero   |Reverie_Ashels

After defense, Hero Reverie_Ashels Hp: 65 -> 58

|  Hero  |Reverie_Ashels regains 10% of his/her hp and mana.... 

Hp: 58 -> 58
Mana: 900 -> 900


+ + + + + + + + + + + + Round 4 + + + + + + + + + + + +

|  Hero  |Skye_Soar   Hp: 70   Level: 1   Status: Alive
|  Hero  |Amaryllis_Astra   Hp: 65   Level: 1   Status: Alive
|  Hero  |Reverie_Ashels   Hp: 58   Level: 1   Status: Alive

|  Monster  |Casper   Hp: 10   Level: 1   Status: Alive
|  Monster  |Natsunomeryu   Hp: 55   Level: 1   Status: Alive
|  Monster  |BigBad-Wolf   Hp: 16   Level: 1   Status: Alive

|  Hero Skye_Soar, please be ready for your fight against Monster Casper!  |
+ + + + + + + + + + + + Fight choice + + + + + + + + + + + +
(A/a) Regular attack
(S/s) Spell
(P/p) Potion
(C/c) Change/Equip Armor/Weapon
(I/i) Info
(Q/q) quit
Your choice: a
--------------------------------------------------------

|  Hero  | Skye_Soar  -----35 damage---->  |  Monster   |Casper

After defense, Monster Casper Hp: 10 -> 0

Hero Skye_Soar has defeated Monster Casper
|  Hero Amaryllis_Astra, please be ready for your fight against Monster Natsunomeryu!  |
+ + + + + + + + + + + + Fight choice + + + + + + + + + + + +
(A/a) Regular attack
(S/s) Spell
(P/p) Potion
(C/c) Change/Equip Armor/Weapon
(I/i) Info
(Q/q) quit
Your choice: a
--------------------------------------------------------

|  Hero  | Amaryllis_Astra  -----25 damage---->  |  Monster   |Natsunomeryu

After defense, Monster Natsunomeryu Hp: 55 -> 40

|  Monster  | Natsunomeryu  -----5 damage---->  |  Hero   |Amaryllis_Astra

After defense, Hero Amaryllis_Astra Hp: 65 -> 60

|  Hero  |Amaryllis_Astra regains 10% of his/her hp and mana.... 

Hp: 60 -> 60
Mana: 500 -> 500

|  Hero Reverie_Ashels, please be ready for your fight against Monster BigBad-Wolf!  |
+ + + + + + + + + + + + Fight choice + + + + + + + + + + + +
(A/a) Regular attack
(S/s) Spell
(P/p) Potion
(C/c) Change/Equip Armor/Weapon
(I/i) Info
(Q/q) quit
Your choice: a
--------------------------------------------------------

|  Hero  | Reverie_Ashels  -----40 damage---->  |  Monster   |BigBad-Wolf

After defense, Monster BigBad-Wolf Hp: 16 -> 0

Hero Reverie_Ashels has defeated Monster BigBad-Wolf

+ + + + + + + + + + + + Round 5 + + + + + + + + + + + +

|  Hero  |Skye_Soar   Hp: 70   Level: 1   Status: Alive
|  Hero  |Amaryllis_Astra   Hp: 60   Level: 1   Status: Alive
|  Hero  |Reverie_Ashels   Hp: 58   Level: 1   Status: Alive

|  Monster  |Casper   Hp: 0   Level: 1   Status: Dead
|  Monster  |Natsunomeryu   Hp: 40   Level: 1   Status: Alive
|  Monster  |BigBad-Wolf   Hp: 0   Level: 1   Status: Dead

Casper is dead! so you should help other member!
Casper is dead! Look for next monster
BigBad-Wolf is dead! Look for next monster
|  Hero Skye_Soar please get ready for your fight against Monster Natsunomeryu  |
+ + + + + + + + + + + + Fight choice + + + + + + + + + + + +
(A/a) Regular attack
(S/s) Spell
(P/p) Potion
(C/c) Change/Equip Armor/Weapon
(I/i) Info
(Q/q) quit
Your choice: a
--------------------------------------------------------

|  Hero  | Skye_Soar  -----35 damage---->  |  Monster   |Natsunomeryu

After defense, Monster Natsunomeryu Hp: 40 -> 15

|  Monster  | Natsunomeryu  -----5 damage---->  |  Hero   |Skye_Soar

After defense, Hero Skye_Soar Hp: 70 -> 65

|  Hero  |Skye_Soar regains 10% of his/her hp and mana.... 

Hp: 65 -> 65
Mana: 1000 -> 1000

|  Hero Amaryllis_Astra, please be ready for your fight against Monster Natsunomeryu!  |
+ + + + + + + + + + + + Fight choice + + + + + + + + + + + +
(A/a) Regular attack
(S/s) Spell
(P/p) Potion
(C/c) Change/Equip Armor/Weapon
(I/i) Info
(Q/q) quit
Your choice: a
--------------------------------------------------------

|  Hero  | Amaryllis_Astra  -----25 damage---->  |  Monster   |Natsunomeryu

After defense, Monster Natsunomeryu Hp: 15 -> 0

Hero Amaryllis_Astra has defeated Monster Natsunomeryu


Congratulations! Heroes win the game!!!
Skye_Soar still alive after this fight! 
Coins: 2600 -> 2700
Exp: 7 -> 9
Amaryllis_Astra still alive after this fight! 
Coins: 2600 -> 2700
Exp: 7 -> 9
Reverie_Ashels still alive after this fight! 
Coins: 2600 -> 2700
Exp: 9 -> 11
Successfully level up to Lv.2

                 BOARD
--------------------------------------------------------
|  $  ||     ||  X  ||  X  ||  $  ||  X  ||     ||  $  |
--------------------------------------------------------
|  X  ||  X  ||     ||     ||  X  ||  $  ||  $  ||     |
--------------------------------------------------------
|  $  ||     ||  $  ||     ||     ||  $  ||     ||  X  |
--------------------------------------------------------
|     ||     ||     ||     ||  $  ||  $  ||     ||     |
--------------------------------------------------------
|     ||     ||     ||     ||     ||  $  ||     ||  X  |
--------------------------------------------------------
|  $  ||     ||  ✵  ||     ||  X  ||  $  ||  $  ||  $  |
--------------------------------------------------------
|     ||     ||  $  ||  X  ||  $  ||     ||  X  ||     |
--------------------------------------------------------
|  $  ||  $  ||     ||     ||  X  ||     ||     ||     |
--------------------------------------------------------
|     |: Common Space
|  $  |: Market Space
|  X  |: Inaccessible Space 
|  ✵  |: You are here!
--------------------------------------------------------
+ + + + + + + + + + + + Menu + + + + + + + + + + + +
(W/w) Move up
(A/a) Move left
(S/s) Move down
(D/d) Move right
(B/b) Open bag
(I/i) Show info
(Q/q) Quit

Your choice:q
|        GAME OVER         |(base) JZJZ:src amari$ java Main
           WELCOME!               
Get ready to start your adventure!
Cannot find config file
Enter a number 1-3 to set the size of your team: 
3

------------------------Hero List---------------------
Hero Type: Warrior   name: Sehanine_Monnbow   mana: 600   strength:700   agility:800 dexterity:500 startingMoney:2500   startingExperience:8

Hero Type: Paladin   name: Caliber_Heist   mana: 400   strength:400   agility:400 dexterity:400 startingMoney:2500   startingExperience:2

Hero Type: Sorcerer   name: Radiant_Ash   mana: 800   strength:850   agility:400 dexterity:600 startingMoney:2500   startingExperience:6

Hero Type: Sorcerer   name: Rillifane_Rallathil   mana: 1300   strength:750   agility:450 dexterity:500 startingMoney:2500   startingExperience:9

Hero Type: Sorcerer   name: Segojan_Earthcaller   mana: 900   strength:800   agility:500 dexterity:650 startingMoney:2500   startingExperience:5

Hero Type: Warrior   name: Gaerdal_Ironhand   mana: 100   strength:700   agility:500 dexterity:600 startingMoney:1354   startingExperience:7

Hero Type: Warrior   name: Muamman_Duathall   mana: 300   strength:900   agility:500 dexterity:750 startingMoney:2546   startingExperience:6

Hero Type: Warrior   name: Flandal_Steelskin   mana: 200   strength:750   agility:650 dexterity:700 startingMoney:2500   startingExperience:7

Hero Type: Paladin   name: Sehanine_Moonbow   mana: 300   strength:750   agility:700 dexterity:700 startingMoney:2500   startingExperience:7

Hero Type: Sorcerer   name: Skye_Soar   mana: 1000   strength:700   agility:400 dexterity:500 startingMoney:2500   startingExperience:5

Hero Type: Paladin   name: Garl_Glittergold   mana: 100   strength:600   agility:500 dexterity:400 startingMoney:2500   startingExperience:5

Hero Type: Warrior   name: Eunoia_Cyn   mana: 400   strength:700   agility:800 dexterity:600 startingMoney:2500   startingExperience:6

Hero Type: Paladin   name: Skoraeus_Stonebones   mana: 250   strength:650   agility:600 dexterity:350 startingMoney:2500   startingExperience:4

Hero Type: Sorcerer   name: Reign_Havoc   mana: 800   strength:800   agility:800 dexterity:800 startingMoney:2500   startingExperience:8

Hero Type: Sorcerer   name: Reverie_Ashels   mana: 900   strength:800   agility:700 dexterity:400 startingMoney:2500   startingExperience:7

Hero Type: Warrior   name: Undefeated_Yoj   mana: 400   strength:800   agility:400 dexterity:700 startingMoney:2500   startingExperience:7

Hero Type: Paladin   name: Solonor_Thelandira   mana: 300   strength:750   agility:650 dexterity:700 startingMoney:2500   startingExperience:7

Hero Type: Paladin   name: Amaryllis_Astra   mana: 500   strength:500   agility:500 dexterity:500 startingMoney:2500   startingExperience:5

--------------------------------------------------------
Creating No.1 hero...
Please copy down one name of the hero you want to add. (Enter Q/q to quit)Sehanine_Monnbow
Successfully create new Hero: Sehanine_Monnbow

Creating No.2 hero...
Please copy down one name of the hero you want to add. (Enter Q/q to quit)Caliber_Heist
Successfully create new Hero: Caliber_Heist

Creating No.3 hero...
Please copy down one name of the hero you want to add. (Enter Q/q to quit)Radiant_Ash
Successfully create new Hero: Radiant_Ash


                 BOARD
--------------------------------------------------------
|     ||  X  ||     ||  $  ||     ||  X  ||  $  ||     |
--------------------------------------------------------
|  X  ||  $  ||     ||     ||     ||  $  ||  X  ||  $  |
--------------------------------------------------------
|  $  ||  $  ||     ||  $  ||     ||     ||  $  ||  $  |
--------------------------------------------------------
|     ||     ||  $  ||     ||  $  ||  X  ||     ||     |
--------------------------------------------------------
|     ||     ||     ||     ||     ||     ||  X  ||  $  |
--------------------------------------------------------
|     ||  $  ||  $  ||  $  ||     ||  ✵  ||     ||     |
--------------------------------------------------------
|  X  ||  $  ||     ||     ||     ||     ||  X  ||  $  |
--------------------------------------------------------
|  $  ||     ||     ||     ||     ||     ||  X  ||     |
--------------------------------------------------------
|     |: Common Space
|  $  |: Market Space
|  X  |: Inaccessible Space 
|  ✵  |: You are here!
--------------------------------------------------------
+ + + + + + + + + + + + Menu + + + + + + + + + + + +
(W/w) Move up
(A/a) Move left
(S/s) Move down
(D/d) Move right
(B/b) Open bag
(I/i) Show info
(Q/q) Quit

Your choice:b
openning bag...

------------------------Heroes in your team---------------------
Sehanine_Monnbow
Caliber_Heist
Radiant_Ash
Copy the name of Hero you wnant to operate:Radiant_Ash

+ + + + + + + + + + + + Menu + + + + + + + + + + + +
(W/w) Remove/Equip Weapon
(A/a) Remove/Equip Armor
(P/p) Use Potion
(I/i) Show bag info
(B/b) Back
(Q/q) Quit the game

Your Choice:i

------------------------Radiant_Ash's Bag---------------------

+ + + + + + + + + + + +  WEAPON  + + + + + + + + + + + +
Empty
--------------------------------------------------------

+ + + + + + + + + + + +  ARMOR  + + + + + + + + + + + +
Empty
--------------------------------------------------------

+ + + + + + + + + + + +  SPELL  + + + + + + + + + + + +
Empty
--------------------------------------------------------

+ + + + + + + + + + + +  POTION  + + + + + + + + + + + +
Empty
--------------------------------------------------------

+ + + + + + + + + + + + Menu + + + + + + + + + + + +
(W/w) Remove/Equip Weapon
(A/a) Remove/Equip Armor
(P/p) Use Potion
(I/i) Show bag info
(B/b) Back
(Q/q) Quit the game

Your Choice:b

                 BOARD
--------------------------------------------------------
|     ||  X  ||     ||  $  ||     ||  X  ||  $  ||     |
--------------------------------------------------------
|  X  ||  $  ||     ||     ||     ||  $  ||  X  ||  $  |
--------------------------------------------------------
|  $  ||  $  ||     ||  $  ||     ||     ||  $  ||  $  |
--------------------------------------------------------
|     ||     ||  $  ||     ||  $  ||  X  ||     ||     |
--------------------------------------------------------
|     ||     ||     ||     ||     ||     ||  X  ||  $  |
--------------------------------------------------------
|     ||  $  ||  $  ||  $  ||     ||  ✵  ||     ||     |
--------------------------------------------------------
|  X  ||  $  ||     ||     ||     ||     ||  X  ||  $  |
--------------------------------------------------------
|  $  ||     ||     ||     ||     ||     ||  X  ||     |
--------------------------------------------------------
|     |: Common Space
|  $  |: Market Space
|  X  |: Inaccessible Space 
|  ✵  |: You are here!
--------------------------------------------------------
+ + + + + + + + + + + + Menu + + + + + + + + + + + +
(W/w) Move up
(A/a) Move left
(S/s) Move down
(D/d) Move right
(B/b) Open bag
(I/i) Show info
(Q/q) Quit

Your choice:a
Your team enters a common space!
Unfortunately, your team encounter a fight!

------------------------Get Ready to your Fight!---------------------
Oooops! There is/are 3 monsters! Your team need to defeat all!

     *  *  *     Fight Starts!    *  *  *           

+ + + + + + + + + + + + Round 1 + + + + + + + + + + + +

|  Hero  |Sehanine_Monnbow   Hp: 100   Level: 1   Status: Alive
|  Hero  |Caliber_Heist   Hp: 100   Level: 1   Status: Alive
|  Hero  |Radiant_Ash   Hp: 100   Level: 1   Status: Alive

|  Monster  |Natsunomeryu   Hp: 100   Level: 1   Status: Alive
|  Monster  |BigBad-Wolf   Hp: 100   Level: 1   Status: Alive
|  Monster  |Aim-Haborym   Hp: 100   Level: 1   Status: Alive

|  Hero Sehanine_Monnbow, please be ready for your fight against Monster Natsunomeryu!  |
+ + + + + + + + + + + + Fight choice + + + + + + + + + + + +
(A/a) Regular attack
(S/s) Spell
(P/p) Potion
(C/c) Change/Equip Armor/Weapon
(I/i) Info
(Q/q) quit
Your choice: a
--------------------------------------------------------

|  Hero  | Sehanine_Monnbow  -----35 damage---->  |  Monster   |Natsunomeryu

After defense, Monster Natsunomeryu Hp: 100 -> 75

|  Monster  | Natsunomeryu  -----5 damage---->  |  Hero   |Sehanine_Monnbow

After defense, Hero Sehanine_Monnbow Hp: 100 -> 95

|  Hero  |Sehanine_Monnbow regains 10% of his/her hp and mana.... 

Hp: 95 -> 95
Mana: 600 -> 600

|  Hero Caliber_Heist, please be ready for your fight against Monster BigBad-Wolf!  |
+ + + + + + + + + + + + Fight choice + + + + + + + + + + + +
(A/a) Regular attack
(S/s) Spell
(P/p) Potion
(C/c) Change/Equip Armor/Weapon
(I/i) Info
(Q/q) quit
Your choice: a
--------------------------------------------------------

|  Hero  | Caliber_Heist  -----20 damage---->  |  Monster   |BigBad-Wolf

After defense, Monster BigBad-Wolf Hp: 100 -> 92

|  Monster  | BigBad-Wolf  -----7 damage---->  |  Hero   |Caliber_Heist

After defense, Hero Caliber_Heist Hp: 100 -> 93

|  Hero  |Caliber_Heist regains 10% of his/her hp and mana.... 

Hp: 93 -> 93
Mana: 400 -> 400

|  Hero Radiant_Ash, please be ready for your fight against Monster Aim-Haborym!  |
+ + + + + + + + + + + + Fight choice + + + + + + + + + + + +
(A/a) Regular attack
(S/s) Spell
(P/p) Potion
(C/c) Change/Equip Armor/Weapon
(I/i) Info
(Q/q) quit
Your choice: a
--------------------------------------------------------

|  Hero  | Radiant_Ash  -----42 damage---->  |  Monster   |Aim-Haborym

After defense, Monster Aim-Haborym Hp: 100 -> 75

|  Monster  | Aim-Haborym  -----22 damage---->  |  Hero   |Radiant_Ash

After defense, Hero Radiant_Ash Hp: 100 -> 78

|  Hero  |Radiant_Ash regains 10% of his/her hp and mana.... 

Hp: 78 -> 80
Mana: 800 -> 800


+ + + + + + + + + + + + Round 2 + + + + + + + + + + + +

|  Hero  |Sehanine_Monnbow   Hp: 95   Level: 1   Status: Alive
|  Hero  |Caliber_Heist   Hp: 93   Level: 1   Status: Alive
|  Hero  |Radiant_Ash   Hp: 80   Level: 1   Status: Alive

|  Monster  |Natsunomeryu   Hp: 75   Level: 1   Status: Alive
|  Monster  |BigBad-Wolf   Hp: 92   Level: 1   Status: Alive
|  Monster  |Aim-Haborym   Hp: 75   Level: 1   Status: Alive

|  Hero Sehanine_Monnbow, please be ready for your fight against Monster Natsunomeryu!  |
+ + + + + + + + + + + + Fight choice + + + + + + + + + + + +
(A/a) Regular attack
(S/s) Spell
(P/p) Potion
(C/c) Change/Equip Armor/Weapon
(I/i) Info
(Q/q) quit
Your choice: a
--------------------------------------------------------

|  Hero  | Sehanine_Monnbow  -----35 damage---->  |  Monster   |Natsunomeryu

After defense, Monster Natsunomeryu Hp: 75 -> 50

|  Monster  | Natsunomeryu  -----5 damage---->  |  Hero   |Sehanine_Monnbow

After defense, Hero Sehanine_Monnbow Hp: 95 -> 90

|  Hero  |Sehanine_Monnbow regains 10% of his/her hp and mana.... 

Hp: 90 -> 90
Mana: 600 -> 600

|  Hero Caliber_Heist, please be ready for your fight against Monster BigBad-Wolf!  |
+ + + + + + + + + + + + Fight choice + + + + + + + + + + + +
(A/a) Regular attack
(S/s) Spell
(P/p) Potion
(C/c) Change/Equip Armor/Weapon
(I/i) Info
(Q/q) quit
Your choice: a
--------------------------------------------------------

|  Hero  | Caliber_Heist  -----20 damage---->  |  Monster   |BigBad-Wolf

After defense, Monster BigBad-Wolf Hp: 92 -> 84

|  Monster  | BigBad-Wolf  -----7 damage---->  |  Hero   |Caliber_Heist

After defense, Hero Caliber_Heist Hp: 93 -> 86

|  Hero  |Caliber_Heist regains 10% of his/her hp and mana.... 

Hp: 86 -> 86
Mana: 400 -> 400

|  Hero Radiant_Ash, please be ready for your fight against Monster Aim-Haborym!  |
+ + + + + + + + + + + + Fight choice + + + + + + + + + + + +
(A/a) Regular attack
(S/s) Spell
(P/p) Potion
(C/c) Change/Equip Armor/Weapon
(I/i) Info
(Q/q) quit
Your choice: a
--------------------------------------------------------

|  Hero  | Radiant_Ash  -----42 damage---->  |  Monster   |Aim-Haborym

After defense, Monster Aim-Haborym Hp: 75 -> 50

|  Monster  | Aim-Haborym  -----22 damage---->  |  Hero   |Radiant_Ash

After defense, Hero Radiant_Ash Hp: 80 -> 58

|  Hero  |Radiant_Ash regains 10% of his/her hp and mana.... 

Hp: 58 -> 60
Mana: 800 -> 800


+ + + + + + + + + + + + Round 3 + + + + + + + + + + + +

|  Hero  |Sehanine_Monnbow   Hp: 90   Level: 1   Status: Alive
|  Hero  |Caliber_Heist   Hp: 86   Level: 1   Status: Alive
|  Hero  |Radiant_Ash   Hp: 60   Level: 1   Status: Alive

|  Monster  |Natsunomeryu   Hp: 50   Level: 1   Status: Alive
|  Monster  |BigBad-Wolf   Hp: 84   Level: 1   Status: Alive
|  Monster  |Aim-Haborym   Hp: 50   Level: 1   Status: Alive

|  Hero Sehanine_Monnbow, please be ready for your fight against Monster Natsunomeryu!  |
+ + + + + + + + + + + + Fight choice + + + + + + + + + + + +
(A/a) Regular attack
(S/s) Spell
(P/p) Potion
(C/c) Change/Equip Armor/Weapon
(I/i) Info
(Q/q) quit
Your choice: a
--------------------------------------------------------

|  Hero  | Sehanine_Monnbow  -----35 damage---->  |  Monster   |Natsunomeryu

After defense, Monster Natsunomeryu Hp: 50 -> 25

|  Monster  | Natsunomeryu  -----5 damage---->  |  Hero   |Sehanine_Monnbow

After defense, Hero Sehanine_Monnbow Hp: 90 -> 85

|  Hero  |Sehanine_Monnbow regains 10% of his/her hp and mana.... 

Hp: 85 -> 85
Mana: 600 -> 600

|  Hero Caliber_Heist, please be ready for your fight against Monster BigBad-Wolf!  |
+ + + + + + + + + + + + Fight choice + + + + + + + + + + + +
(A/a) Regular attack
(S/s) Spell
(P/p) Potion
(C/c) Change/Equip Armor/Weapon
(I/i) Info
(Q/q) quit
Your choice: a
--------------------------------------------------------

|  Hero  | Caliber_Heist  -----20 damage---->  |  Monster   |BigBad-Wolf

After defense, Monster BigBad-Wolf Hp: 84 -> 76

|  Monster  | BigBad-Wolf  -----7 damage---->  |  Hero   |Caliber_Heist

After defense, Hero Caliber_Heist Hp: 86 -> 79

|  Hero  |Caliber_Heist regains 10% of his/her hp and mana.... 

Hp: 79 -> 79
Mana: 400 -> 400

|  Hero Radiant_Ash, please be ready for your fight against Monster Aim-Haborym!  |
+ + + + + + + + + + + + Fight choice + + + + + + + + + + + +
(A/a) Regular attack
(S/s) Spell
(P/p) Potion
(C/c) Change/Equip Armor/Weapon
(I/i) Info
(Q/q) quit
Your choice: a
--------------------------------------------------------

|  Hero  | Radiant_Ash  -----42 damage---->  |  Monster   |Aim-Haborym

After defense, Monster Aim-Haborym Hp: 50 -> 25

|  Monster  | Aim-Haborym  -----22 damage---->  |  Hero   |Radiant_Ash

After defense, Hero Radiant_Ash Hp: 60 -> 38

|  Hero  |Radiant_Ash regains 10% of his/her hp and mana.... 

Hp: 38 -> 40
Mana: 800 -> 800


+ + + + + + + + + + + + Round 4 + + + + + + + + + + + +

|  Hero  |Sehanine_Monnbow   Hp: 85   Level: 1   Status: Alive
|  Hero  |Caliber_Heist   Hp: 79   Level: 1   Status: Alive
|  Hero  |Radiant_Ash   Hp: 40   Level: 1   Status: Alive

|  Monster  |Natsunomeryu   Hp: 25   Level: 1   Status: Alive
|  Monster  |BigBad-Wolf   Hp: 76   Level: 1   Status: Alive
|  Monster  |Aim-Haborym   Hp: 25   Level: 1   Status: Alive

|  Hero Sehanine_Monnbow, please be ready for your fight against Monster Natsunomeryu!  |
+ + + + + + + + + + + + Fight choice + + + + + + + + + + + +
(A/a) Regular attack
(S/s) Spell
(P/p) Potion
(C/c) Change/Equip Armor/Weapon
(I/i) Info
(Q/q) quit
Your choice: i
--------------------------------------------------------

name -----------> [ Sehanine_Monnbow ]
level ----------> [ 1 ]
hp -------------> [ 85 ]
mana -----------> [ 600 ]
strength -------> [ 700 ]
dexterity ------> [ 500 ]
agility --------> [ 800 ]
defense --------> [ 0 ]
money ----------> [ 2500 ]
experience -----> [ 8 ]
--------------------------------------------------------
weapon ---------> [ NONE ]
armor ----------> [ NONE ]
--------------------------------------------------------

------------------------Sehanine_Monnbow's Bag---------------------

+ + + + + + + + + + + +  WEAPON  + + + + + + + + + + + +
Empty
--------------------------------------------------------

+ + + + + + + + + + + +  ARMOR  + + + + + + + + + + + +
Empty
--------------------------------------------------------

+ + + + + + + + + + + +  SPELL  + + + + + + + + + + + +
Empty
--------------------------------------------------------

+ + + + + + + + + + + +  POTION  + + + + + + + + + + + +
Empty
--------------------------------------------------------

+ + + + + + + + + + + + Fight choice + + + + + + + + + + + +
(A/a) Regular attack
(S/s) Spell
(P/p) Potion
(C/c) Change/Equip Armor/Weapon
(I/i) Info
(Q/q) quit
Your choice: a
--------------------------------------------------------

|  Hero  | Sehanine_Monnbow  -----35 damage---->  |  Monster   |Natsunomeryu

After defense, Monster Natsunomeryu Hp: 25 -> 0

Hero Sehanine_Monnbow has defeated Monster Natsunomeryu
|  Hero Caliber_Heist, please be ready for your fight against Monster BigBad-Wolf!  |
+ + + + + + + + + + + + Fight choice + + + + + + + + + + + +
(A/a) Regular attack
(S/s) Spell
(P/p) Potion
(C/c) Change/Equip Armor/Weapon
(I/i) Info
(Q/q) quit
Your choice: a
--------------------------------------------------------

|  Hero  | Caliber_Heist  -----20 damage---->  |  Monster   |BigBad-Wolf

After defense, Monster BigBad-Wolf Hp: 76 -> 68

|  Monster  | BigBad-Wolf  -----7 damage---->  |  Hero   |Caliber_Heist

After defense, Hero Caliber_Heist Hp: 79 -> 72

|  Hero  |Caliber_Heist regains 10% of his/her hp and mana.... 

Hp: 72 -> 72
Mana: 400 -> 400

|  Hero Radiant_Ash, please be ready for your fight against Monster Aim-Haborym!  |
+ + + + + + + + + + + + Fight choice + + + + + + + + + + + +
(A/a) Regular attack
(S/s) Spell
(P/p) Potion
(C/c) Change/Equip Armor/Weapon
(I/i) Info
(Q/q) quit
Your choice: a
--------------------------------------------------------

|  Hero  | Radiant_Ash  -----42 damage---->  |  Monster   |Aim-Haborym

After defense, Monster Aim-Haborym Hp: 25 -> 0

Hero Radiant_Ash has defeated Monster Aim-Haborym

+ + + + + + + + + + + + Round 5 + + + + + + + + + + + +

|  Hero  |Sehanine_Monnbow   Hp: 85   Level: 1   Status: Alive
|  Hero  |Caliber_Heist   Hp: 72   Level: 1   Status: Alive
|  Hero  |Radiant_Ash   Hp: 40   Level: 1   Status: Alive

|  Monster  |Natsunomeryu   Hp: 0   Level: 1   Status: Dead
|  Monster  |BigBad-Wolf   Hp: 68   Level: 1   Status: Alive
|  Monster  |Aim-Haborym   Hp: 0   Level: 1   Status: Dead

Natsunomeryu is dead! so you should help other member!
Natsunomeryu is dead! Look for next monster
Aim-Haborym is dead! Look for next monster
|  Hero Sehanine_Monnbow please get ready for your fight against Monster BigBad-Wolf  |
+ + + + + + + + + + + + Fight choice + + + + + + + + + + + +
(A/a) Regular attack
(S/s) Spell
(P/p) Potion
(C/c) Change/Equip Armor/Weapon
(I/i) Info
(Q/q) quit
Your choice: a
--------------------------------------------------------

|  Hero  | Sehanine_Monnbow  -----35 damage---->  |  Monster   |BigBad-Wolf

After defense, Monster BigBad-Wolf Hp: 68 -> 45

|  Monster  | BigBad-Wolf  -----7 damage---->  |  Hero   |Sehanine_Monnbow

After defense, Hero Sehanine_Monnbow Hp: 85 -> 78

|  Hero  |Sehanine_Monnbow regains 10% of his/her hp and mana.... 

Hp: 78 -> 78
Mana: 600 -> 600

|  Hero Caliber_Heist, please be ready for your fight against Monster BigBad-Wolf!  |
+ + + + + + + + + + + + Fight choice + + + + + + + + + + + +
(A/a) Regular attack
(S/s) Spell
(P/p) Potion
(C/c) Change/Equip Armor/Weapon
(I/i) Info
(Q/q) quit
Your choice: a
--------------------------------------------------------

|  Hero  | Caliber_Heist  -----20 damage---->  |  Monster   |BigBad-Wolf

After defense, Monster BigBad-Wolf Hp: 45 -> 37

|  Monster  | BigBad-Wolf  -----7 damage---->  |  Hero   |Caliber_Heist

After defense, Hero Caliber_Heist Hp: 72 -> 65

|  Hero  |Caliber_Heist regains 10% of his/her hp and mana.... 

Hp: 65 -> 65
Mana: 400 -> 400

Aim-Haborym is dead! so you should help other member!
Natsunomeryu is dead! Look for next monster
Aim-Haborym is dead! Look for next monster
|  Hero Radiant_Ash please get ready for your fight against Monster BigBad-Wolf  |
+ + + + + + + + + + + + Fight choice + + + + + + + + + + + +
(A/a) Regular attack
(S/s) Spell
(P/p) Potion
(C/c) Change/Equip Armor/Weapon
(I/i) Info
(Q/q) quit
Your choice: a
--------------------------------------------------------

|  Hero  | Radiant_Ash  -----42 damage---->  |  Monster   |BigBad-Wolf

After defense, Monster BigBad-Wolf Hp: 37 -> 7

|  Monster  | BigBad-Wolf  -----7 damage---->  |  Hero   |Radiant_Ash

After defense, Hero Radiant_Ash Hp: 40 -> 33

|  Hero  |Radiant_Ash regains 10% of his/her hp and mana.... 

Hp: 33 -> 33
Mana: 800 -> 800


+ + + + + + + + + + + + Round 6 + + + + + + + + + + + +

|  Hero  |Sehanine_Monnbow   Hp: 78   Level: 1   Status: Alive
|  Hero  |Caliber_Heist   Hp: 65   Level: 1   Status: Alive
|  Hero  |Radiant_Ash   Hp: 33   Level: 1   Status: Alive

|  Monster  |Natsunomeryu   Hp: 0   Level: 1   Status: Dead
|  Monster  |BigBad-Wolf   Hp: 7   Level: 1   Status: Alive
|  Monster  |Aim-Haborym   Hp: 0   Level: 1   Status: Dead

Natsunomeryu is dead! so you should help other member!
Natsunomeryu is dead! Look for next monster
Aim-Haborym is dead! Look for next monster
|  Hero Sehanine_Monnbow please get ready for your fight against Monster BigBad-Wolf  |
+ + + + + + + + + + + + Fight choice + + + + + + + + + + + +
(A/a) Regular attack
(S/s) Spell
(P/p) Potion
(C/c) Change/Equip Armor/Weapon
(I/i) Info
(Q/q) quit
Your choice: a
--------------------------------------------------------

|  Hero  | Sehanine_Monnbow  -----35 damage---->  |  Monster   |BigBad-Wolf

After defense, Monster BigBad-Wolf Hp: 7 -> 0

Hero Sehanine_Monnbow has defeated Monster BigBad-Wolf


Congratulations! Heroes win the game!!!
Sehanine_Monnbow still alive after this fight! 
Coins: 2500 -> 2600
Exp: 8 -> 10
Successfully level up to Lv.2
Caliber_Heist still alive after this fight! 
Coins: 2500 -> 2600
Exp: 2 -> 4
Radiant_Ash still alive after this fight! 
Coins: 2500 -> 2600
Exp: 6 -> 8

                 BOARD
--------------------------------------------------------
|     ||  X  ||     ||  $  ||     ||  X  ||  $  ||     |
--------------------------------------------------------
|  X  ||  $  ||     ||     ||     ||  $  ||  X  ||  $  |
--------------------------------------------------------
|  $  ||  $  ||     ||  $  ||     ||     ||  $  ||  $  |
--------------------------------------------------------
|     ||     ||  $  ||     ||  $  ||  X  ||     ||     |
--------------------------------------------------------
|     ||     ||     ||     ||     ||     ||  X  ||  $  |
--------------------------------------------------------
|     ||  $  ||  $  ||  $  ||  ✵  ||     ||     ||     |
--------------------------------------------------------
|  X  ||  $  ||     ||     ||     ||     ||  X  ||  $  |
--------------------------------------------------------
|  $  ||     ||     ||     ||     ||     ||  X  ||     |
--------------------------------------------------------
|     |: Common Space
|  $  |: Market Space
|  X  |: Inaccessible Space 
|  ✵  |: You are here!
--------------------------------------------------------
+ + + + + + + + + + + + Menu + + + + + + + + + + + +
(W/w) Move up
(A/a) Move left
(S/s) Move down
(D/d) Move right
(B/b) Open bag
(I/i) Show info
(Q/q) Quit

Your choice:i
+ + + + + + + + + + + + Team member Sehanine_Monnbow info + + + + + + + + + + + +
name -----------> [ Sehanine_Monnbow ]
level ----------> [ 2 ]
hp -------------> [ 200 ]
mana -----------> [ 660 ]
strength -------> [ 770 ]
dexterity ------> [ 525 ]
agility --------> [ 880 ]
defense --------> [ 0 ]
money ----------> [ 2600 ]
experience -----> [ 0 ]
--------------------------------------------------------
weapon ---------> [ NONE ]
armor ----------> [ NONE ]
--------------------------------------------------------
+ + + + + + + + + + + + Team member Caliber_Heist info + + + + + + + + + + + +
name -----------> [ Caliber_Heist ]
level ----------> [ 1 ]
hp -------------> [ 65 ]
mana -----------> [ 400 ]
strength -------> [ 400 ]
dexterity ------> [ 400 ]
agility --------> [ 400 ]
defense --------> [ 0 ]
money ----------> [ 2600 ]
experience -----> [ 4 ]
--------------------------------------------------------
weapon ---------> [ NONE ]
armor ----------> [ NONE ]
--------------------------------------------------------
+ + + + + + + + + + + + Team member Radiant_Ash info + + + + + + + + + + + +
name -----------> [ Radiant_Ash ]
level ----------> [ 1 ]
hp -------------> [ 33 ]
mana -----------> [ 800 ]
strength -------> [ 850 ]
dexterity ------> [ 600 ]
agility --------> [ 400 ]
defense --------> [ 0 ]
money ----------> [ 2600 ]
experience -----> [ 8 ]
--------------------------------------------------------
weapon ---------> [ NONE ]
armor ----------> [ NONE ]
--------------------------------------------------------


                 BOARD
--------------------------------------------------------
|     ||  X  ||     ||  $  ||     ||  X  ||  $  ||     |
--------------------------------------------------------
|  X  ||  $  ||     ||     ||     ||  $  ||  X  ||  $  |
--------------------------------------------------------
|  $  ||  $  ||     ||  $  ||     ||     ||  $  ||  $  |
--------------------------------------------------------
|     ||     ||  $  ||     ||  $  ||  X  ||     ||     |
--------------------------------------------------------
|     ||     ||     ||     ||     ||     ||  X  ||  $  |
--------------------------------------------------------
|     ||  $  ||  $  ||  $  ||  ✵  ||     ||     ||     |
--------------------------------------------------------
|  X  ||  $  ||     ||     ||     ||     ||  X  ||  $  |
--------------------------------------------------------
|  $  ||     ||     ||     ||     ||     ||  X  ||     |
--------------------------------------------------------
|     |: Common Space
|  $  |: Market Space
|  X  |: Inaccessible Space 
|  ✵  |: You are here!
--------------------------------------------------------
+ + + + + + + + + + + + Menu + + + + + + + + + + + +
(W/w) Move up
(A/a) Move left
(S/s) Move down
(D/d) Move right
(B/b) Open bag
(I/i) Show info
(Q/q) Quit

Your choice:a
There is a Market!
--------------------------------------------------------
(Y/y) Enter
(I/i) Show team info
(C/c) Continue
(Q/q) Quit the game

Your choice:i
+ + + + + + + + + + + + Team member Sehanine_Monnbow info + + + + + + + + + + + +
name -----------> [ Sehanine_Monnbow ]
level ----------> [ 2 ]
hp -------------> [ 200 ]
mana -----------> [ 660 ]
strength -------> [ 770 ]
dexterity ------> [ 525 ]
agility --------> [ 880 ]
defense --------> [ 0 ]
money ----------> [ 2600 ]
experience -----> [ 0 ]
--------------------------------------------------------
weapon ---------> [ NONE ]
armor ----------> [ NONE ]
--------------------------------------------------------
+ + + + + + + + + + + + Team member Caliber_Heist info + + + + + + + + + + + +
name -----------> [ Caliber_Heist ]
level ----------> [ 1 ]
hp -------------> [ 65 ]
mana -----------> [ 400 ]
strength -------> [ 400 ]
dexterity ------> [ 400 ]
agility --------> [ 400 ]
defense --------> [ 0 ]
money ----------> [ 2600 ]
experience -----> [ 4 ]
--------------------------------------------------------
weapon ---------> [ NONE ]
armor ----------> [ NONE ]
--------------------------------------------------------
+ + + + + + + + + + + + Team member Radiant_Ash info + + + + + + + + + + + +
name -----------> [ Radiant_Ash ]
level ----------> [ 1 ]
hp -------------> [ 33 ]
mana -----------> [ 800 ]
strength -------> [ 850 ]
dexterity ------> [ 600 ]
agility --------> [ 400 ]
defense --------> [ 0 ]
money ----------> [ 2600 ]
experience -----> [ 8 ]
--------------------------------------------------------
weapon ---------> [ NONE ]
armor ----------> [ NONE ]
--------------------------------------------------------

There is a Market!
--------------------------------------------------------
(Y/y) Enter
(I/i) Show team info
(C/c) Continue
(Q/q) Quit the game

Your choice:y
Pick a hero to operate!

------------------------Heroes in your team---------------------
Sehanine_Monnbow
Caliber_Heist
Radiant_Ash
Copy the name of Hero you wnant to operate:Radiant_Ash



------------------------Radiant_Ash's Bag---------------------

+ + + + + + + + + + + +  WEAPON  + + + + + + + + + + + +
Empty
--------------------------------------------------------

+ + + + + + + + + + + +  ARMOR  + + + + + + + + + + + +
Empty
--------------------------------------------------------

+ + + + + + + + + + + +  SPELL  + + + + + + + + + + + +
Empty
--------------------------------------------------------

+ + + + + + + + + + + +  POTION  + + + + + + + + + + + +
Empty
--------------------------------------------------------

(B/b) Buy
(S/s) Sell
(I/i) Hero's info
(C/c) Change Character
(Q/q) Quit the Market
Your choice: b

(W/w) Weapon
(A/a) Armor
(P/p) Potion
(S/s) Spell
(B/b) Back
(Q/q) Quit the game

Your choice:p

------------------------Potion in store---------------------
Type: Potion | name: Luck_Elixir, price: 500, requiredLevel: 4, increase in damage: 65, affected target: Agility
Type: Potion | name: Ambrosia, price: 1000, requiredLevel: 8, increase in damage: 150, affected target: All Health/Mana/Strength/Dexterity/Defense/Agility
Type: Potion | name: Strength_Potion, price: 200, requiredLevel: 1, increase in damage: 75, affected target: Strength
Type: Potion | name: Magic_Potion, price: 350, requiredLevel: 2, increase in damage: 100, affected target: Mana
Type: Potion | name: Healing_Potion, price: 250, requiredLevel: 1, increase in damage: 100, affected target: Health
Type: Potion | name: Mermaid_Tears, price: 850, requiredLevel: 5, increase in damage: 100, affected target: Health/Mana/Strength/Agility
(B/b) Back
Please copy the name of item you want to buy or go back to previous menu: Healing_Potion
Hero Radiant_Ash successfully buy Potion: Healing_Potion
Coins: 2600 -> 2350
Please copy the name of item you want to buy or go back to previous menu: Healing_Potion
Hero Radiant_Ash successfully buy Potion: Healing_Potion
Coins: 2350 -> 2100
Please copy the name of item you want to buy or go back to previous menu: b
(W/w) Weapon
(A/a) Armor
(P/p) Potion
(S/s) Spell
(B/b) Back
(Q/q) Quit the game

Your choice:w

------------------------weapon in store---------------------
Type: Weapon | name: Sword, price: 500, requiredLevel: 1, damage: 800
Type: Weapon | name: TSwords, price: 1400, requiredLevel: 8, damage: 1600
Type: Weapon | name: Scythe, price: 1000, requiredLevel: 6, damage: 1100
Type: Weapon | name: Dagger, price: 200, requiredLevel: 1, damage: 250
Type: Weapon | name: Bow, price: 300, requiredLevel: 2, damage: 500
Type: Weapon | name: Axe, price: 550, requiredLevel: 5, damage: 850
(B/b) Back
Please copy the name of item you want to buy or go back to previous menu: Sword
Hero Radiant_Ash successfully buy weapon: Sword
Coins: 2100 -> 1600
Please copy the name of item you want to buy or go back to previous menu: b
(W/w) Weapon
(A/a) Armor
(P/p) Potion
(S/s) Spell
(B/b) Back
(Q/q) Quit the game

Your choice:a

------------------------Armor in store---------------------
[Armor] name: Guardian_Angel, price: 1000, required level: 10, reduction in damage: 1000
[Armor] name: Speed_Boots, price: 550, required level: 4, reduction in damage: 600
[Armor] name: Full_Body_Armor, price: 1000, required level: 8, reduction in damage: 1100
[Armor] name: Platinum_Shield, price: 150, required level: 1, reduction in damage: 200
[Armor] name: Wizard_Shield, price: 1200, required level: 10, reduction in damage: 1500
[Armor] name: Breastplate, price: 350, required level: 3, reduction in damage: 600
(B/b) Back
Please copy the name of item you want to buy or go back to previous menu: Platinum_Shield
Hero Radiant_Ash successfully buy Armor: Platinum_Shield
Coins: 1600 -> 1450
Please copy the name of item you want to buy or go back to previous menu: b
(W/w) Weapon
(A/a) Armor
(P/p) Potion
(S/s) Spell
(B/b) Back
(Q/q) Quit the game

Your choice:b
(B/b) Buy
(S/s) Sell
(I/i) Hero's info
(C/c) Change Character
(Q/q) Quit the Market
Your choice: c


------------------------Radiant_Ash's Bag---------------------

+ + + + + + + + + + + +  WEAPON  + + + + + + + + + + + +
Type: Weapon | name: Sword, price: 500, requiredLevel: 1, damage: 800
--------------------------------------------------------

+ + + + + + + + + + + +  ARMOR  + + + + + + + + + + + +
Type: Armor | name: Platinum_Shield, price: 150, requiredLevel: 1, reduction in damage: 200
--------------------------------------------------------

+ + + + + + + + + + + +  SPELL  + + + + + + + + + + + +
Empty
--------------------------------------------------------

+ + + + + + + + + + + +  POTION  + + + + + + + + + + + +
Type: Potion | name: Healing_Potion, price: 250, requiredLevel: 1, increase in damage: 100, affected target: Health
Type: Potion | name: Healing_Potion, price: 250, requiredLevel: 1, increase in damage: 100, affected target: Health
--------------------------------------------------------

Pick a hero to operate!

------------------------Heroes in your team---------------------
Sehanine_Monnbow
Caliber_Heist
Radiant_Ash
Copy the name of Hero you wnant to operate:Sehanine_Monnbow



------------------------Sehanine_Monnbow's Bag---------------------

+ + + + + + + + + + + +  WEAPON  + + + + + + + + + + + +
Empty
--------------------------------------------------------

+ + + + + + + + + + + +  ARMOR  + + + + + + + + + + + +
Empty
--------------------------------------------------------

+ + + + + + + + + + + +  SPELL  + + + + + + + + + + + +
Empty
--------------------------------------------------------

+ + + + + + + + + + + +  POTION  + + + + + + + + + + + +
Empty
--------------------------------------------------------

(B/b) Buy
(S/s) Sell
(I/i) Hero's info
(C/c) Change Character
(Q/q) Quit the Market
Your choice: b

(W/w) Weapon
(A/a) Armor
(P/p) Potion
(S/s) Spell
(B/b) Back
(Q/q) Quit the game

Your choice:Weapon
ERROR INPUT: Invalid command!
(W/w) Weapon
(A/a) Armor
(P/p) Potion
(S/s) Spell
(B/b) Back
(Q/q) Quit the game

Your choice:w

------------------------weapon in store---------------------
Type: Weapon | name: Sword, price: 500, requiredLevel: 1, damage: 800
Type: Weapon | name: TSwords, price: 1400, requiredLevel: 8, damage: 1600
Type: Weapon | name: Scythe, price: 1000, requiredLevel: 6, damage: 1100
Type: Weapon | name: Dagger, price: 200, requiredLevel: 1, damage: 250
Type: Weapon | name: Bow, price: 300, requiredLevel: 2, damage: 500
Type: Weapon | name: Axe, price: 550, requiredLevel: 5, damage: 850
(B/b) Back
Please copy the name of item you want to buy or go back to previous menu: Bow
Hero Sehanine_Monnbow successfully buy weapon: Bow
Coins: 2600 -> 2300
Please copy the name of item you want to buy or go back to previous menu: b
(W/w) Weapon
(A/a) Armor
(P/p) Potion
(S/s) Spell
(B/b) Back
(Q/q) Quit the game

Your choice:a

------------------------Armor in store---------------------
[Armor] name: Guardian_Angel, price: 1000, required level: 10, reduction in damage: 1000
[Armor] name: Speed_Boots, price: 550, required level: 4, reduction in damage: 600
[Armor] name: Full_Body_Armor, price: 1000, required level: 8, reduction in damage: 1100
[Armor] name: Platinum_Shield, price: 150, required level: 1, reduction in damage: 200
[Armor] name: Wizard_Shield, price: 1200, required level: 10, reduction in damage: 1500
[Armor] name: Breastplate, price: 350, required level: 3, reduction in damage: 600
(B/b) Back
Please copy the name of item you want to buy or go back to previous menu: Platinum_Shield
Hero Sehanine_Monnbow successfully buy Armor: Platinum_Shield
Coins: 2300 -> 2150
Please copy the name of item you want to buy or go back to previous menu: b
(W/w) Weapon
(A/a) Armor
(P/p) Potion
(S/s) Spell
(B/b) Back
(Q/q) Quit the game

Your choice:s

------------------------Spell in store---------------------
Type: Spell | name: Heat_Wave, price: 450, requiredLevel: 2, mana cost: 150, damage: 600, type: Fire
Type: Spell | name: Snow_Cannon, price: 500, requiredLevel: 2, mana cost: 250, damage: 650, type: Ice
Type: Spell | name: Arctic_Storm, price: 700, requiredLevel: 6, mana cost: 300, damage: 800, type: Ice
Type: Spell | name: Electric_Arrows, price: 550, requiredLevel: 5, mana cost: 200, damage: 650, type: Lightning
Type: Spell | name: Hell_Storm, price: 600, requiredLevel: 3, mana cost: 600, damage: 950, type: Fire
Type: Spell | name: Lava_Comet, price: 800, requiredLevel: 7, mana cost: 550, damage: 1000, type: Fire
Type: Spell | name: Spark_Needles, price: 500, requiredLevel: 2, mana cost: 200, damage: 600, type: Lightning
Type: Spell | name: Frost_Blizzard, price: 750, requiredLevel: 5, mana cost: 350, damage: 850, type: Ice
Type: Spell | name: Flame_Tornado, price: 700, requiredLevel: 4, mana cost: 300, damage: 850, type: Fire
Type: Spell | name: Lightning_Dagger, price: 400, requiredLevel: 1, mana cost: 150, damage: 500, type: Lightning
Type: Spell | name: Breath_of_Fire, price: 350, requiredLevel: 1, mana cost: 100, damage: 450, type: Fire
Type: Spell | name: Ice_Blade, price: 250, requiredLevel: 1, mana cost: 100, damage: 450, type: Ice
Type: Spell | name: Thunder_Blast, price: 750, requiredLevel: 4, mana cost: 400, damage: 950, type: Lightning
(B/b) Back
Please copy the name of item you want to buy or go back to previous menu: Spark_Needles
Hero Sehanine_Monnbow successfully buy Spell: Spark_Needles
Coins: 2150 -> 1650
Please copy the name of item you want to buy or go back to previous menu: b
(W/w) Weapon
(A/a) Armor
(P/p) Potion
(S/s) Spell
(B/b) Back
(Q/q) Quit the game

Your choice:b
(B/b) Buy
(S/s) Sell
(I/i) Hero's info
(C/c) Change Character
(Q/q) Quit the Market
Your choice: c


------------------------Sehanine_Monnbow's Bag---------------------

+ + + + + + + + + + + +  WEAPON  + + + + + + + + + + + +
Type: Weapon | name: Bow, price: 300, requiredLevel: 2, damage: 500
--------------------------------------------------------

+ + + + + + + + + + + +  ARMOR  + + + + + + + + + + + +
Type: Armor | name: Platinum_Shield, price: 150, requiredLevel: 1, reduction in damage: 200
--------------------------------------------------------

+ + + + + + + + + + + +  SPELL  + + + + + + + + + + + +
Type: Spell | name: Spark_Needles, price: 500, requiredLevel: 2, mana cost: 200, damage: 600, type: Lightning
--------------------------------------------------------

+ + + + + + + + + + + +  POTION  + + + + + + + + + + + +
Empty
--------------------------------------------------------

Pick a hero to operate!

------------------------Heroes in your team---------------------
Sehanine_Monnbow
Caliber_Heist
Radiant_Ash
Copy the name of Hero you wnant to operate:Caliber_Heist



------------------------Caliber_Heist's Bag---------------------

+ + + + + + + + + + + +  WEAPON  + + + + + + + + + + + +
Empty
--------------------------------------------------------

+ + + + + + + + + + + +  ARMOR  + + + + + + + + + + + +
Empty
--------------------------------------------------------

+ + + + + + + + + + + +  SPELL  + + + + + + + + + + + +
Empty
--------------------------------------------------------

+ + + + + + + + + + + +  POTION  + + + + + + + + + + + +
Empty
--------------------------------------------------------

(B/b) Buy
(S/s) Sell
(I/i) Hero's info
(C/c) Change Character
(Q/q) Quit the Market
Your choice: i

name -----------> [ Caliber_Heist ]
level ----------> [ 1 ]
hp -------------> [ 65 ]
mana -----------> [ 400 ]
strength -------> [ 400 ]
dexterity ------> [ 400 ]
agility --------> [ 400 ]
defense --------> [ 0 ]
money ----------> [ 2600 ]
experience -----> [ 4 ]
--------------------------------------------------------
weapon ---------> [ NONE ]
armor ----------> [ NONE ]
--------------------------------------------------------
(B/b) Buy
(S/s) Sell
(I/i) Hero's info
(C/c) Change Character
(Q/q) Quit the Market
Your choice: b

(W/w) Weapon
(A/a) Armor
(P/p) Potion
(S/s) Spell
(B/b) Back
(Q/q) Quit the game

Your choice:w

------------------------weapon in store---------------------
Type: Weapon | name: Sword, price: 500, requiredLevel: 1, damage: 800
Type: Weapon | name: TSwords, price: 1400, requiredLevel: 8, damage: 1600
Type: Weapon | name: Scythe, price: 1000, requiredLevel: 6, damage: 1100
Type: Weapon | name: Dagger, price: 200, requiredLevel: 1, damage: 250
Type: Weapon | name: Bow, price: 300, requiredLevel: 2, damage: 500
Type: Weapon | name: Axe, price: 550, requiredLevel: 5, damage: 850
(B/b) Back
Please copy the name of item you want to buy or go back to previous menu: Sword
Hero Caliber_Heist successfully buy weapon: Sword
Coins: 2600 -> 2100
Please copy the name of item you want to buy or go back to previous menu: b
(W/w) Weapon
(A/a) Armor
(P/p) Potion
(S/s) Spell
(B/b) Back
(Q/q) Quit the game

Your choice:a

------------------------Armor in store---------------------
[Armor] name: Guardian_Angel, price: 1000, required level: 10, reduction in damage: 1000
[Armor] name: Speed_Boots, price: 550, required level: 4, reduction in damage: 600
[Armor] name: Full_Body_Armor, price: 1000, required level: 8, reduction in damage: 1100
[Armor] name: Platinum_Shield, price: 150, required level: 1, reduction in damage: 200
[Armor] name: Wizard_Shield, price: 1200, required level: 10, reduction in damage: 1500
[Armor] name: Breastplate, price: 350, required level: 3, reduction in damage: 600
(B/b) Back
Please copy the name of item you want to buy or go back to previous menu: Platinum_Shield
Hero Caliber_Heist successfully buy Armor: Platinum_Shield
Coins: 2100 -> 1950
Please copy the name of item you want to buy or go back to previous menu: b
(W/w) Weapon
(A/a) Armor
(P/p) Potion
(S/s) Spell
(B/b) Back
(Q/q) Quit the game

Your choice:b
(B/b) Buy
(S/s) Sell
(I/i) Hero's info
(C/c) Change Character
(Q/q) Quit the Market
Your choice: q

Leving the market...

                 BOARD
--------------------------------------------------------
|     ||  X  ||     ||  $  ||     ||  X  ||  $  ||     |
--------------------------------------------------------
|  X  ||  $  ||     ||     ||     ||  $  ||  X  ||  $  |
--------------------------------------------------------
|  $  ||  $  ||     ||  $  ||     ||     ||  $  ||  $  |
--------------------------------------------------------
|     ||     ||  $  ||     ||  $  ||  X  ||     ||     |
--------------------------------------------------------
|     ||     ||     ||     ||     ||     ||  X  ||  $  |
--------------------------------------------------------
|     ||  $  ||  $  ||  ✵  ||     ||     ||     ||     |
--------------------------------------------------------
|  X  ||  $  ||     ||     ||     ||     ||  X  ||  $  |
--------------------------------------------------------
|  $  ||     ||     ||     ||     ||     ||  X  ||     |
--------------------------------------------------------
|     |: Common Space
|  $  |: Market Space
|  X  |: Inaccessible Space 
|  ✵  |: You are here!
--------------------------------------------------------
+ + + + + + + + + + + + Menu + + + + + + + + + + + +
(W/w) Move up
(A/a) Move left
(S/s) Move down
(D/d) Move right
(B/b) Open bag
(I/i) Show info
(Q/q) Quit

Your choice:b
openning bag...

------------------------Heroes in your team---------------------
Sehanine_Monnbow
Caliber_Heist
Radiant_Ash
Copy the name of Hero you wnant to operate:Sehanine_Monnbow

+ + + + + + + + + + + + Menu + + + + + + + + + + + +
(W/w) Remove/Equip Weapon
(A/a) Remove/Equip Armor
(P/p) Use Potion
(I/i) Show bag info
(B/b) Back
(Q/q) Quit the game

Your Choice:w
(E/e) Equip weapon
(R/r) Remove weapon
(B/b) Back to the menu
Your Choice: e
+ + + + + + + + + + + +  WEAPON  + + + + + + + + + + + +
Type: Weapon | name: Bow, price: 300, requiredLevel: 2, damage: 500
--------------------------------------------------------

(B/b) Back to the menu

Copy the name of item you want to equip:Bow
Successfully equip weapon [ Bow ] and removed previous weapon [ None ]
(E/e) Equip weapon
(R/r) Remove weapon
(B/b) Back to the menu
Your Choice: b
+ + + + + + + + + + + + Menu + + + + + + + + + + + +
(W/w) Remove/Equip Weapon
(A/a) Remove/Equip Armor
(P/p) Use Potion
(I/i) Show bag info
(B/b) Back
(Q/q) Quit the game

Your Choice:a
(E/e) Equip armor
(R/r) Remove armor
(B/b) Back to the menu

Your Choice: e
+ + + + + + + + + + + +  ARMOR  + + + + + + + + + + + +
Type: Armor | name: Platinum_Shield, price: 150, requiredLevel: 1, reduction in damage: 200
--------------------------------------------------------

(B/b) Back to the menu

Copy the name of item you want to equip:Platinum_Shield
Successfully equip armor [ Platinum_Shield ] and removed previous armor [ None ]

(E/e) Equip armor
(R/r) Remove armor
(B/b) Back to the menu

Your Choice: b
+ + + + + + + + + + + + Menu + + + + + + + + + + + +
(W/w) Remove/Equip Weapon
(A/a) Remove/Equip Armor
(P/p) Use Potion
(I/i) Show bag info
(B/b) Back
(Q/q) Quit the game

Your Choice:i

------------------------Sehanine_Monnbow's Bag---------------------

+ + + + + + + + + + + +  WEAPON  + + + + + + + + + + + +
Empty
--------------------------------------------------------

+ + + + + + + + + + + +  ARMOR  + + + + + + + + + + + +
Empty
--------------------------------------------------------

+ + + + + + + + + + + +  SPELL  + + + + + + + + + + + +
Type: Spell | name: Spark_Needles, price: 500, requiredLevel: 2, mana cost: 200, damage: 600, type: Lightning
--------------------------------------------------------

+ + + + + + + + + + + +  POTION  + + + + + + + + + + + +
Empty
--------------------------------------------------------

+ + + + + + + + + + + + Menu + + + + + + + + + + + +
(W/w) Remove/Equip Weapon
(A/a) Remove/Equip Armor
(P/p) Use Potion
(I/i) Show bag info
(B/b) Back
(Q/q) Quit the game

Your Choice:b

                 BOARD
--------------------------------------------------------
|     ||  X  ||     ||  $  ||     ||  X  ||  $  ||     |
--------------------------------------------------------
|  X  ||  $  ||     ||     ||     ||  $  ||  X  ||  $  |
--------------------------------------------------------
|  $  ||  $  ||     ||  $  ||     ||     ||  $  ||  $  |
--------------------------------------------------------
|     ||     ||  $  ||     ||  $  ||  X  ||     ||     |
--------------------------------------------------------
|     ||     ||     ||     ||     ||     ||  X  ||  $  |
--------------------------------------------------------
|     ||  $  ||  $  ||  ✵  ||     ||     ||     ||     |
--------------------------------------------------------
|  X  ||  $  ||     ||     ||     ||     ||  X  ||  $  |
--------------------------------------------------------
|  $  ||     ||     ||     ||     ||     ||  X  ||     |
--------------------------------------------------------
|     |: Common Space
|  $  |: Market Space
|  X  |: Inaccessible Space 
|  ✵  |: You are here!
--------------------------------------------------------
+ + + + + + + + + + + + Menu + + + + + + + + + + + +
(W/w) Move up
(A/a) Move left
(S/s) Move down
(D/d) Move right
(B/b) Open bag
(I/i) Show info
(Q/q) Quit

Your choice:b
openning bag...

------------------------Heroes in your team---------------------
Sehanine_Monnbow
Caliber_Heist
Radiant_Ash
Copy the name of Hero you wnant to operate:Caliber_Heist

+ + + + + + + + + + + + Menu + + + + + + + + + + + +
(W/w) Remove/Equip Weapon
(A/a) Remove/Equip Armor
(P/p) Use Potion
(I/i) Show bag info
(B/b) Back
(Q/q) Quit the game

Your Choice:w
(E/e) Equip weapon
(R/r) Remove weapon
(B/b) Back to the menu
Your Choice: e
+ + + + + + + + + + + +  WEAPON  + + + + + + + + + + + +
Type: Weapon | name: Sword, price: 500, requiredLevel: 1, damage: 800
--------------------------------------------------------

(B/b) Back to the menu

Copy the name of item you want to equip:Sword
Successfully equip weapon [ Sword ] and removed previous weapon [ None ]
(E/e) Equip weapon
(R/r) Remove weapon
(B/b) Back to the menu
Your Choice: b
+ + + + + + + + + + + + Menu + + + + + + + + + + + +
(W/w) Remove/Equip Weapon
(A/a) Remove/Equip Armor
(P/p) Use Potion
(I/i) Show bag info
(B/b) Back
(Q/q) Quit the game

Your Choice:a
(E/e) Equip armor
(R/r) Remove armor
(B/b) Back to the menu

Your Choice: e
+ + + + + + + + + + + +  ARMOR  + + + + + + + + + + + +
Type: Armor | name: Platinum_Shield, price: 150, requiredLevel: 1, reduction in damage: 200
--------------------------------------------------------

(B/b) Back to the menu

Copy the name of item you want to equip:Platinum_Shield
Successfully equip armor [ Platinum_Shield ] and removed previous armor [ None ]

(E/e) Equip armor
(R/r) Remove armor
(B/b) Back to the menu

Your Choice: b
+ + + + + + + + + + + + Menu + + + + + + + + + + + +
(W/w) Remove/Equip Weapon
(A/a) Remove/Equip Armor
(P/p) Use Potion
(I/i) Show bag info
(B/b) Back
(Q/q) Quit the game

Your Choice:i

------------------------Caliber_Heist's Bag---------------------

+ + + + + + + + + + + +  WEAPON  + + + + + + + + + + + +
Empty
--------------------------------------------------------

+ + + + + + + + + + + +  ARMOR  + + + + + + + + + + + +
Empty
--------------------------------------------------------

+ + + + + + + + + + + +  SPELL  + + + + + + + + + + + +
Empty
--------------------------------------------------------

+ + + + + + + + + + + +  POTION  + + + + + + + + + + + +
Empty
--------------------------------------------------------

+ + + + + + + + + + + + Menu + + + + + + + + + + + +
(W/w) Remove/Equip Weapon
(A/a) Remove/Equip Armor
(P/p) Use Potion
(I/i) Show bag info
(B/b) Back
(Q/q) Quit the game

Your Choice:b

                 BOARD
--------------------------------------------------------
|     ||  X  ||     ||  $  ||     ||  X  ||  $  ||     |
--------------------------------------------------------
|  X  ||  $  ||     ||     ||     ||  $  ||  X  ||  $  |
--------------------------------------------------------
|  $  ||  $  ||     ||  $  ||     ||     ||  $  ||  $  |
--------------------------------------------------------
|     ||     ||  $  ||     ||  $  ||  X  ||     ||     |
--------------------------------------------------------
|     ||     ||     ||     ||     ||     ||  X  ||  $  |
--------------------------------------------------------
|     ||  $  ||  $  ||  ✵  ||     ||     ||     ||     |
--------------------------------------------------------
|  X  ||  $  ||     ||     ||     ||     ||  X  ||  $  |
--------------------------------------------------------
|  $  ||     ||     ||     ||     ||     ||  X  ||     |
--------------------------------------------------------
|     |: Common Space
|  $  |: Market Space
|  X  |: Inaccessible Space 
|  ✵  |: You are here!
--------------------------------------------------------
+ + + + + + + + + + + + Menu + + + + + + + + + + + +
(W/w) Move up
(A/a) Move left
(S/s) Move down
(D/d) Move right
(B/b) Open bag
(I/i) Show info
(Q/q) Quit

Your choice:b
openning bag...

------------------------Heroes in your team---------------------
Sehanine_Monnbow
Caliber_Heist
Radiant_Ash
Copy the name of Hero you wnant to operate:Radiant_Ash

+ + + + + + + + + + + + Menu + + + + + + + + + + + +
(W/w) Remove/Equip Weapon
(A/a) Remove/Equip Armor
(P/p) Use Potion
(I/i) Show bag info
(B/b) Back
(Q/q) Quit the game

Your Choice:i

------------------------Radiant_Ash's Bag---------------------

+ + + + + + + + + + + +  WEAPON  + + + + + + + + + + + +
Type: Weapon | name: Sword, price: 500, requiredLevel: 1, damage: 800
--------------------------------------------------------

+ + + + + + + + + + + +  ARMOR  + + + + + + + + + + + +
Type: Armor | name: Platinum_Shield, price: 150, requiredLevel: 1, reduction in damage: 200
--------------------------------------------------------

+ + + + + + + + + + + +  SPELL  + + + + + + + + + + + +
Empty
--------------------------------------------------------

+ + + + + + + + + + + +  POTION  + + + + + + + + + + + +
Type: Potion | name: Healing_Potion, price: 250, requiredLevel: 1, increase in damage: 100, affected target: Health
Type: Potion | name: Healing_Potion, price: 250, requiredLevel: 1, increase in damage: 100, affected target: Health
--------------------------------------------------------

+ + + + + + + + + + + + Menu + + + + + + + + + + + +
(W/w) Remove/Equip Weapon
(A/a) Remove/Equip Armor
(P/p) Use Potion
(I/i) Show bag info
(B/b) Back
(Q/q) Quit the game

Your Choice:p
+ + + + + + + + + + + +  POTION  + + + + + + + + + + + +
Type: Potion | name: Healing_Potion, price: 250, requiredLevel: 1, increase in damage: 100, affected target: Health
Type: Potion | name: Healing_Potion, price: 250, requiredLevel: 1, increase in damage: 100, affected target: Health
--------------------------------------------------------

(B/b) Back to the menu

Copy the name of potion you want to use: Healing_Potion
Successfully use Potion Healing_Potion
hp: 33 +(100)
+ + + + + + + + + + + + Menu + + + + + + + + + + + +
(W/w) Remove/Equip Weapon
(A/a) Remove/Equip Armor
(P/p) Use Potion
(I/i) Show bag info
(B/b) Back
(Q/q) Quit the game

Your Choice:w
(E/e) Equip weapon
(R/r) Remove weapon
(B/b) Back to the menu
Your Choice: e
+ + + + + + + + + + + +  WEAPON  + + + + + + + + + + + +
Type: Weapon | name: Sword, price: 500, requiredLevel: 1, damage: 800
--------------------------------------------------------

(B/b) Back to the menu

Copy the name of item you want to equip:Sword
Successfully equip weapon [ Sword ] and removed previous weapon [ None ]
(E/e) Equip weapon
(R/r) Remove weapon
(B/b) Back to the menu
Your Choice: b
+ + + + + + + + + + + + Menu + + + + + + + + + + + +
(W/w) Remove/Equip Weapon
(A/a) Remove/Equip Armor
(P/p) Use Potion
(I/i) Show bag info
(B/b) Back
(Q/q) Quit the game

Your Choice:a
(E/e) Equip armor
(R/r) Remove armor
(B/b) Back to the menu

Your Choice: e
+ + + + + + + + + + + +  ARMOR  + + + + + + + + + + + +
Type: Armor | name: Platinum_Shield, price: 150, requiredLevel: 1, reduction in damage: 200
--------------------------------------------------------

(B/b) Back to the menu

Copy the name of item you want to equip:Platinum_Shield
Successfully equip armor [ Platinum_Shield ] and removed previous armor [ None ]

(E/e) Equip armor
(R/r) Remove armor
(B/b) Back to the menu

Your Choice: b
+ + + + + + + + + + + + Menu + + + + + + + + + + + +
(W/w) Remove/Equip Weapon
(A/a) Remove/Equip Armor
(P/p) Use Potion
(I/i) Show bag info
(B/b) Back
(Q/q) Quit the game

Your Choice:b

                 BOARD
--------------------------------------------------------
|     ||  X  ||     ||  $  ||     ||  X  ||  $  ||     |
--------------------------------------------------------
|  X  ||  $  ||     ||     ||     ||  $  ||  X  ||  $  |
--------------------------------------------------------
|  $  ||  $  ||     ||  $  ||     ||     ||  $  ||  $  |
--------------------------------------------------------
|     ||     ||  $  ||     ||  $  ||  X  ||     ||     |
--------------------------------------------------------
|     ||     ||     ||     ||     ||     ||  X  ||  $  |
--------------------------------------------------------
|     ||  $  ||  $  ||  ✵  ||     ||     ||     ||     |
--------------------------------------------------------
|  X  ||  $  ||     ||     ||     ||     ||  X  ||  $  |
--------------------------------------------------------
|  $  ||     ||     ||     ||     ||     ||  X  ||     |
--------------------------------------------------------
|     |: Common Space
|  $  |: Market Space
|  X  |: Inaccessible Space 
|  ✵  |: You are here!
--------------------------------------------------------
+ + + + + + + + + + + + Menu + + + + + + + + + + + +
(W/w) Move up
(A/a) Move left
(S/s) Move down
(D/d) Move right
(B/b) Open bag
(I/i) Show info
(Q/q) Quit

Your choice:i
+ + + + + + + + + + + + Team member Sehanine_Monnbow info + + + + + + + + + + + +
name -----------> [ Sehanine_Monnbow ]
level ----------> [ 2 ]
hp -------------> [ 200 ]
mana -----------> [ 660 ]
strength -------> [ 770 ]
dexterity ------> [ 525 ]
agility --------> [ 880 ]
defense --------> [ 0 ]
money ----------> [ 1650 ]
experience -----> [ 0 ]
--------------------------------------------------------
weapon ---------> [ Bow ]  (extra increased damage = 500)
armor ----------> [ Platinum_Shield ]  (extra reduced damage = 200)
--------------------------------------------------------
+ + + + + + + + + + + + Team member Caliber_Heist info + + + + + + + + + + + +
name -----------> [ Caliber_Heist ]
level ----------> [ 1 ]
hp -------------> [ 65 ]
mana -----------> [ 400 ]
strength -------> [ 400 ]
dexterity ------> [ 400 ]
agility --------> [ 400 ]
defense --------> [ 0 ]
money ----------> [ 1950 ]
experience -----> [ 4 ]
--------------------------------------------------------
weapon ---------> [ Sword ]  (extra increased damage = 800)
armor ----------> [ Platinum_Shield ]  (extra reduced damage = 200)
--------------------------------------------------------
+ + + + + + + + + + + + Team member Radiant_Ash info + + + + + + + + + + + +
name -----------> [ Radiant_Ash ]
level ----------> [ 1 ]
hp -------------> [ 133 ]
mana -----------> [ 800 ]
strength -------> [ 850 ]
dexterity ------> [ 600 ]
agility --------> [ 400 ]
defense --------> [ 0 ]
money ----------> [ 1450 ]
experience -----> [ 8 ]
--------------------------------------------------------
weapon ---------> [ Sword ]  (extra increased damage = 800)
armor ----------> [ Platinum_Shield ]  (extra reduced damage = 200)
--------------------------------------------------------


                 BOARD
--------------------------------------------------------
|     ||  X  ||     ||  $  ||     ||  X  ||  $  ||     |
--------------------------------------------------------
|  X  ||  $  ||     ||     ||     ||  $  ||  X  ||  $  |
--------------------------------------------------------
|  $  ||  $  ||     ||  $  ||     ||     ||  $  ||  $  |
--------------------------------------------------------
|     ||     ||  $  ||     ||  $  ||  X  ||     ||     |
--------------------------------------------------------
|     ||     ||     ||     ||     ||     ||  X  ||  $  |
--------------------------------------------------------
|     ||  $  ||  $  ||  ✵  ||     ||     ||     ||     |
--------------------------------------------------------
|  X  ||  $  ||     ||     ||     ||     ||  X  ||  $  |
--------------------------------------------------------
|  $  ||     ||     ||     ||     ||     ||  X  ||     |
--------------------------------------------------------
|     |: Common Space
|  $  |: Market Space
|  X  |: Inaccessible Space 
|  ✵  |: You are here!
--------------------------------------------------------
+ + + + + + + + + + + + Menu + + + + + + + + + + + +
(W/w) Move up
(A/a) Move left
(S/s) Move down
(D/d) Move right
(B/b) Open bag
(I/i) Show info
(Q/q) Quit

Your choice:w
Your team enters a common space!
Unfortunately, your team encounter a fight!

------------------------Get Ready to your Fight!---------------------
Oooops! There is/are 3 monsters! Your team need to defeat all!

     *  *  *     Fight Starts!    *  *  *           

+ + + + + + + + + + + + Round 1 + + + + + + + + + + + +

|  Hero  |Sehanine_Monnbow   Hp: 200   Level: 2   Status: Alive
|  Hero  |Caliber_Heist   Hp: 65   Level: 1   Status: Alive
|  Hero  |Radiant_Ash   Hp: 133   Level: 1   Status: Alive

|  Monster  |Chrysophylax   Hp: 200   Level: 2   Status: Alive
|  Monster  |WickedWitch   Hp: 200   Level: 2   Status: Alive
|  Monster  |Andrealphus   Hp: 200   Level: 2   Status: Alive

|  Hero Sehanine_Monnbow, please be ready for your fight against Monster Chrysophylax!  |
+ + + + + + + + + + + + Fight choice + + + + + + + + + + + +
(A/a) Regular attack
(S/s) Spell
(P/p) Potion
(C/c) Change/Equip Armor/Weapon
(I/i) Info
(Q/q) quit
Your choice: a
--------------------------------------------------------

|  Hero  | Sehanine_Monnbow  -----63 damage---->  |  Monster   |Chrysophylax

After defense, Monster Chrysophylax Hp: 200 -> 162

|  Monster  | Chrysophylax  -----10 damage---->  |  Hero   |Sehanine_Monnbow

|  Hero  |Sehanine_Monnbow regains 10% of his/her hp and mana.... 

Hp: 200 -> 200
Mana: 660 -> 660

|  Hero Caliber_Heist, please be ready for your fight against Monster WickedWitch!  |
+ + + + + + + + + + + + Fight choice + + + + + + + + + + + +
(A/a) Regular attack
(S/s) Spell
(P/p) Potion
(C/c) Change/Equip Armor/Weapon
(I/i) Info
(Q/q) quit
Your choice: a
--------------------------------------------------------

|  Hero  | Caliber_Heist  -----60 damage---->  |  Monster   |WickedWitch

After defense, Monster WickedWitch Hp: 200 -> 157

|  Monster  | WickedWitch  -----12 damage---->  |  Hero   |Caliber_Heist

After defense, Hero Caliber_Heist Hp: 65 -> 63

|  Hero  |Caliber_Heist regains 10% of his/her hp and mana.... 

Hp: 63 -> 63
Mana: 400 -> 400

|  Hero Radiant_Ash, please be ready for your fight against Monster Andrealphus!  |
+ + + + + + + + + + + + Fight choice + + + + + + + + + + + +
(A/a) Regular attack
(S/s) Spell
(P/p) Potion
(C/c) Change/Equip Armor/Weapon
(I/i) Info
(Q/q) quit
Your choice: a
--------------------------------------------------------

|  Hero  | Radiant_Ash  -----82 damage---->  |  Monster   |Andrealphus

After defense, Monster Andrealphus Hp: 200 -> 143

|  Monster  | Andrealphus  -----30 damage---->  |  Hero   |Radiant_Ash

After defense, Hero Radiant_Ash Hp: 133 -> 113

|  Hero  |Radiant_Ash regains 10% of his/her hp and mana.... 

Hp: 113 -> 115
Mana: 800 -> 800


+ + + + + + + + + + + + Round 2 + + + + + + + + + + + +

|  Hero  |Sehanine_Monnbow   Hp: 200   Level: 2   Status: Alive
|  Hero  |Caliber_Heist   Hp: 63   Level: 1   Status: Alive
|  Hero  |Radiant_Ash   Hp: 115   Level: 1   Status: Alive

|  Monster  |Chrysophylax   Hp: 162   Level: 2   Status: Alive
|  Monster  |WickedWitch   Hp: 157   Level: 2   Status: Alive
|  Monster  |Andrealphus   Hp: 143   Level: 2   Status: Alive

|  Hero Sehanine_Monnbow, please be ready for your fight against Monster Chrysophylax!  |
+ + + + + + + + + + + + Fight choice + + + + + + + + + + + +
(A/a) Regular attack
(S/s) Spell
(P/p) Potion
(C/c) Change/Equip Armor/Weapon
(I/i) Info
(Q/q) quit
Your choice: a
--------------------------------------------------------

|  Hero  | Sehanine_Monnbow  -----63 damage---->  |  Monster   |Chrysophylax

After defense, Monster Chrysophylax Hp: 162 -> 124

|  Monster  | Chrysophylax  -----10 damage---->  |  Hero   |Sehanine_Monnbow

|  Hero  |Sehanine_Monnbow regains 10% of his/her hp and mana.... 

Hp: 200 -> 200
Mana: 660 -> 660

|  Hero Caliber_Heist, please be ready for your fight against Monster WickedWitch!  |
+ + + + + + + + + + + + Fight choice + + + + + + + + + + + +
(A/a) Regular attack
(S/s) Spell
(P/p) Potion
(C/c) Change/Equip Armor/Weapon
(I/i) Info
(Q/q) quit
Your choice: a
--------------------------------------------------------

|  Hero  | Caliber_Heist  -----60 damage---->  |  Monster   |WickedWitch

After defense, Monster WickedWitch Hp: 157 -> 114

|  Monster  | WickedWitch  -----12 damage---->  |  Hero   |Caliber_Heist

After defense, Hero Caliber_Heist Hp: 63 -> 61

|  Hero  |Caliber_Heist regains 10% of his/her hp and mana.... 

Hp: 61 -> 61
Mana: 400 -> 400

|  Hero Radiant_Ash, please be ready for your fight against Monster Andrealphus!  |
+ + + + + + + + + + + + Fight choice + + + + + + + + + + + +
(A/a) Regular attack
(S/s) Spell
(P/p) Potion
(C/c) Change/Equip Armor/Weapon
(I/i) Info
(Q/q) quit
Your choice: a
--------------------------------------------------------

|  Hero  | Radiant_Ash  -----82 damage---->  |  Monster   |Andrealphus

After defense, Monster Andrealphus Hp: 143 -> 86

|  Monster  | Andrealphus  -----30 damage---->  |  Hero   |Radiant_Ash

After defense, Hero Radiant_Ash Hp: 115 -> 95

|  Hero  |Radiant_Ash regains 10% of his/her hp and mana.... 

Hp: 95 -> 97
Mana: 800 -> 800


+ + + + + + + + + + + + Round 3 + + + + + + + + + + + +

|  Hero  |Sehanine_Monnbow   Hp: 200   Level: 2   Status: Alive
|  Hero  |Caliber_Heist   Hp: 61   Level: 1   Status: Alive
|  Hero  |Radiant_Ash   Hp: 97   Level: 1   Status: Alive

|  Monster  |Chrysophylax   Hp: 124   Level: 2   Status: Alive
|  Monster  |WickedWitch   Hp: 114   Level: 2   Status: Alive
|  Monster  |Andrealphus   Hp: 86   Level: 2   Status: Alive

|  Hero Sehanine_Monnbow, please be ready for your fight against Monster Chrysophylax!  |
+ + + + + + + + + + + + Fight choice + + + + + + + + + + + +
(A/a) Regular attack
(S/s) Spell
(P/p) Potion
(C/c) Change/Equip Armor/Weapon
(I/i) Info
(Q/q) quit
Your choice: a
--------------------------------------------------------

|  Hero  | Sehanine_Monnbow  -----63 damage---->  |  Monster   |Chrysophylax

After defense, Monster Chrysophylax Hp: 124 -> 86

|  Monster  | Chrysophylax  -----10 damage---->  |  Hero   |Sehanine_Monnbow

|  Hero  |Sehanine_Monnbow regains 10% of his/her hp and mana.... 

Hp: 200 -> 200
Mana: 660 -> 660

|  Hero Caliber_Heist, please be ready for your fight against Monster WickedWitch!  |
+ + + + + + + + + + + + Fight choice + + + + + + + + + + + +
(A/a) Regular attack
(S/s) Spell
(P/p) Potion
(C/c) Change/Equip Armor/Weapon
(I/i) Info
(Q/q) quit
Your choice: i
--------------------------------------------------------

name -----------> [ Caliber_Heist ]
level ----------> [ 1 ]
hp -------------> [ 61 ]
mana -----------> [ 400 ]
strength -------> [ 400 ]
dexterity ------> [ 400 ]
agility --------> [ 400 ]
defense --------> [ 0 ]
money ----------> [ 1950 ]
experience -----> [ 4 ]
--------------------------------------------------------
weapon ---------> [ Sword ]  (extra increased damage = 800)
armor ----------> [ Platinum_Shield ]  (extra reduced damage = 200)
--------------------------------------------------------

------------------------Caliber_Heist's Bag---------------------

+ + + + + + + + + + + +  WEAPON  + + + + + + + + + + + +
Empty
--------------------------------------------------------

+ + + + + + + + + + + +  ARMOR  + + + + + + + + + + + +
Empty
--------------------------------------------------------

+ + + + + + + + + + + +  SPELL  + + + + + + + + + + + +
Empty
--------------------------------------------------------

+ + + + + + + + + + + +  POTION  + + + + + + + + + + + +
Empty
--------------------------------------------------------

+ + + + + + + + + + + + Fight choice + + + + + + + + + + + +
(A/a) Regular attack
(S/s) Spell
(P/p) Potion
(C/c) Change/Equip Armor/Weapon
(I/i) Info
(Q/q) quit
Your choice: a
--------------------------------------------------------

|  Hero  | Caliber_Heist  -----60 damage---->  |  Monster   |WickedWitch

After defense, Monster WickedWitch Hp: 114 -> 71

|  Monster  | WickedWitch  -----12 damage---->  |  Hero   |Caliber_Heist

After defense, Hero Caliber_Heist Hp: 61 -> 59

|  Hero  |Caliber_Heist regains 10% of his/her hp and mana.... 

Hp: 59 -> 59
Mana: 400 -> 400

|  Hero Radiant_Ash, please be ready for your fight against Monster Andrealphus!  |
+ + + + + + + + + + + + Fight choice + + + + + + + + + + + +
(A/a) Regular attack
(S/s) Spell
(P/p) Potion
(C/c) Change/Equip Armor/Weapon
(I/i) Info
(Q/q) quit
Your choice: s
--------------------------------------------------------

+ + + + + + + + + + + +  SPELL  + + + + + + + + + + + +
Empty
--------------------------------------------------------

ERROR INPUT: You do not have any spell in the bag!
+ + + + + + + + + + + + Fight choice + + + + + + + + + + + +
(A/a) Regular attack
(S/s) Spell
(P/p) Potion
(C/c) Change/Equip Armor/Weapon
(I/i) Info
(Q/q) quit
Your choice: a
--------------------------------------------------------

|  Hero  | Radiant_Ash  -----82 damage---->  |  Monster   |Andrealphus

After defense, Monster Andrealphus Hp: 86 -> 29

|  Monster  | Andrealphus  -----30 damage---->  |  Hero   |Radiant_Ash

After defense, Hero Radiant_Ash Hp: 97 -> 77

|  Hero  |Radiant_Ash regains 10% of his/her hp and mana.... 

Hp: 77 -> 79
Mana: 800 -> 800


+ + + + + + + + + + + + Round 4 + + + + + + + + + + + +

|  Hero  |Sehanine_Monnbow   Hp: 200   Level: 2   Status: Alive
|  Hero  |Caliber_Heist   Hp: 59   Level: 1   Status: Alive
|  Hero  |Radiant_Ash   Hp: 79   Level: 1   Status: Alive

|  Monster  |Chrysophylax   Hp: 86   Level: 2   Status: Alive
|  Monster  |WickedWitch   Hp: 71   Level: 2   Status: Alive
|  Monster  |Andrealphus   Hp: 29   Level: 2   Status: Alive

|  Hero Sehanine_Monnbow, please be ready for your fight against Monster Chrysophylax!  |
+ + + + + + + + + + + + Fight choice + + + + + + + + + + + +
(A/a) Regular attack
(S/s) Spell
(P/p) Potion
(C/c) Change/Equip Armor/Weapon
(I/i) Info
(Q/q) quit
Your choice: a
--------------------------------------------------------

|  Hero  | Sehanine_Monnbow  -----63 damage---->  |  Monster   |Chrysophylax

After defense, Monster Chrysophylax Hp: 86 -> 48

|  Monster  | Chrysophylax  -----10 damage---->  |  Hero   |Sehanine_Monnbow

|  Hero  |Sehanine_Monnbow regains 10% of his/her hp and mana.... 

Hp: 200 -> 200
Mana: 660 -> 660

|  Hero Caliber_Heist, please be ready for your fight against Monster WickedWitch!  |
+ + + + + + + + + + + + Fight choice + + + + + + + + + + + +
(A/a) Regular attack
(S/s) Spell
(P/p) Potion
(C/c) Change/Equip Armor/Weapon
(I/i) Info
(Q/q) quit
Your choice: a
--------------------------------------------------------

|  Hero  | Caliber_Heist  -----60 damage---->  |  Monster   |WickedWitch

After defense, Monster WickedWitch Hp: 71 -> 28

|  Monster  | WickedWitch  -----12 damage---->  |  Hero   |Caliber_Heist

After defense, Hero Caliber_Heist Hp: 59 -> 57

|  Hero  |Caliber_Heist regains 10% of his/her hp and mana.... 

Hp: 57 -> 57
Mana: 400 -> 400

|  Hero Radiant_Ash, please be ready for your fight against Monster Andrealphus!  |
+ + + + + + + + + + + + Fight choice + + + + + + + + + + + +
(A/a) Regular attack
(S/s) Spell
(P/p) Potion
(C/c) Change/Equip Armor/Weapon
(I/i) Info
(Q/q) quit
Your choice: a
--------------------------------------------------------

|  Hero  | Radiant_Ash  -----82 damage---->  |  Monster   |Andrealphus

After defense, Monster Andrealphus Hp: 29 -> 0

Hero Radiant_Ash has defeated Monster Andrealphus

+ + + + + + + + + + + + Round 5 + + + + + + + + + + + +

|  Hero  |Sehanine_Monnbow   Hp: 200   Level: 2   Status: Alive
|  Hero  |Caliber_Heist   Hp: 57   Level: 1   Status: Alive
|  Hero  |Radiant_Ash   Hp: 79   Level: 1   Status: Alive

|  Monster  |Chrysophylax   Hp: 48   Level: 2   Status: Alive
|  Monster  |WickedWitch   Hp: 28   Level: 2   Status: Alive
|  Monster  |Andrealphus   Hp: 0   Level: 2   Status: Dead

|  Hero Sehanine_Monnbow, please be ready for your fight against Monster Chrysophylax!  |
+ + + + + + + + + + + + Fight choice + + + + + + + + + + + +
(A/a) Regular attack
(S/s) Spell
(P/p) Potion
(C/c) Change/Equip Armor/Weapon
(I/i) Info
(Q/q) quit
Your choice: a
--------------------------------------------------------

|  Hero  | Sehanine_Monnbow  -----63 damage---->  |  Monster   |Chrysophylax

After defense, Monster Chrysophylax Hp: 48 -> 10

|  Monster  | Chrysophylax  -----10 damage---->  |  Hero   |Sehanine_Monnbow

|  Hero  |Sehanine_Monnbow regains 10% of his/her hp and mana.... 

Hp: 200 -> 200
Mana: 660 -> 660

|  Hero Caliber_Heist, please be ready for your fight against Monster WickedWitch!  |
+ + + + + + + + + + + + Fight choice + + + + + + + + + + + +
(A/a) Regular attack
(S/s) Spell
(P/p) Potion
(C/c) Change/Equip Armor/Weapon
(I/i) Info
(Q/q) quit
Your choice: a
--------------------------------------------------------

|  Hero  | Caliber_Heist  -----60 damage---->  |  Monster   |WickedWitch

After defense, Monster WickedWitch Hp: 28 -> 0

Hero Caliber_Heist has defeated Monster WickedWitch
Andrealphus is dead! so you should help other member!
WickedWitch is dead! Look for next monster
Andrealphus is dead! Look for next monster
|  Hero Radiant_Ash please get ready for your fight against Monster Chrysophylax  |
+ + + + + + + + + + + + Fight choice + + + + + + + + + + + +
(A/a) Regular attack
(S/s) Spell
(P/p) Potion
(C/c) Change/Equip Armor/Weapon
(I/i) Info
(Q/q) quit
Your choice: a
--------------------------------------------------------

|  Hero  | Radiant_Ash  -----82 damage---->  |  Monster   |Chrysophylax

After defense, Monster Chrysophylax Hp: 10 -> 0

Hero Radiant_Ash has defeated Monster Chrysophylax


Congratulations! Heroes win the game!!!
Sehanine_Monnbow still alive after this fight! 
Coins: 1650 -> 1850
Exp: 0 -> 2
Caliber_Heist still alive after this fight! 
Coins: 1950 -> 2150
Exp: 4 -> 6
Radiant_Ash still alive after this fight! 
Coins: 1450 -> 1650
Exp: 8 -> 10
Successfully level up to Lv.2

                 BOARD
--------------------------------------------------------
|     ||  X  ||     ||  $  ||     ||  X  ||  $  ||     |
--------------------------------------------------------
|  X  ||  $  ||     ||     ||     ||  $  ||  X  ||  $  |
--------------------------------------------------------
|  $  ||  $  ||     ||  $  ||     ||     ||  $  ||  $  |
--------------------------------------------------------
|     ||     ||  $  ||     ||  $  ||  X  ||     ||     |
--------------------------------------------------------
|     ||     ||     ||  ✵  ||     ||     ||  X  ||  $  |
--------------------------------------------------------
|     ||  $  ||  $  ||  $  ||     ||     ||     ||     |
--------------------------------------------------------
|  X  ||  $  ||     ||     ||     ||     ||  X  ||  $  |
--------------------------------------------------------
|  $  ||     ||     ||     ||     ||     ||  X  ||     |
--------------------------------------------------------
|     |: Common Space
|  $  |: Market Space
|  X  |: Inaccessible Space 
|  ✵  |: You are here!
--------------------------------------------------------
+ + + + + + + + + + + + Menu + + + + + + + + + + + +
(W/w) Move up
(A/a) Move left
(S/s) Move down
(D/d) Move right
(B/b) Open bag
(I/i) Show info
(Q/q) Quit

Your choice:i
+ + + + + + + + + + + + Team member Sehanine_Monnbow info + + + + + + + + + + + +
name -----------> [ Sehanine_Monnbow ]
level ----------> [ 2 ]
hp -------------> [ 200 ]
mana -----------> [ 660 ]
strength -------> [ 770 ]
dexterity ------> [ 525 ]
agility --------> [ 880 ]
defense --------> [ 0 ]
money ----------> [ 1850 ]
experience -----> [ 2 ]
--------------------------------------------------------
weapon ---------> [ Bow ]  (extra increased damage = 500)
armor ----------> [ Platinum_Shield ]  (extra reduced damage = 200)
--------------------------------------------------------
+ + + + + + + + + + + + Team member Caliber_Heist info + + + + + + + + + + + +
name -----------> [ Caliber_Heist ]
level ----------> [ 1 ]
hp -------------> [ 57 ]
mana -----------> [ 400 ]
strength -------> [ 400 ]
dexterity ------> [ 400 ]
agility --------> [ 400 ]
defense --------> [ 0 ]
money ----------> [ 2150 ]
experience -----> [ 6 ]
--------------------------------------------------------
weapon ---------> [ Sword ]  (extra increased damage = 800)
armor ----------> [ Platinum_Shield ]  (extra reduced damage = 200)
--------------------------------------------------------
+ + + + + + + + + + + + Team member Radiant_Ash info + + + + + + + + + + + +
name -----------> [ Radiant_Ash ]
level ----------> [ 2 ]
hp -------------> [ 200 ]
mana -----------> [ 880 ]
strength -------> [ 892 ]
dexterity ------> [ 660 ]
agility --------> [ 440 ]
defense --------> [ 0 ]
money ----------> [ 1650 ]
experience -----> [ 0 ]
--------------------------------------------------------
weapon ---------> [ Sword ]  (extra increased damage = 800)
armor ----------> [ Platinum_Shield ]  (extra reduced damage = 200)
--------------------------------------------------------


                 BOARD
--------------------------------------------------------
|     ||  X  ||     ||  $  ||     ||  X  ||  $  ||     |
--------------------------------------------------------
|  X  ||  $  ||     ||     ||     ||  $  ||  X  ||  $  |
--------------------------------------------------------
|  $  ||  $  ||     ||  $  ||     ||     ||  $  ||  $  |
--------------------------------------------------------
|     ||     ||  $  ||     ||  $  ||  X  ||     ||     |
--------------------------------------------------------
|     ||     ||     ||  ✵  ||     ||     ||  X  ||  $  |
--------------------------------------------------------
|     ||  $  ||  $  ||  $  ||     ||     ||     ||     |
--------------------------------------------------------
|  X  ||  $  ||     ||     ||     ||     ||  X  ||  $  |
--------------------------------------------------------
|  $  ||     ||     ||     ||     ||     ||  X  ||     |
--------------------------------------------------------
|     |: Common Space
|  $  |: Market Space
|  X  |: Inaccessible Space 
|  ✵  |: You are here!
--------------------------------------------------------
+ + + + + + + + + + + + Menu + + + + + + + + + + + +
(W/w) Move up
(A/a) Move left
(S/s) Move down
(D/d) Move right
(B/b) Open bag
(I/i) Show info
(Q/q) Quit

Your choice:q
|        GAME OVER         |(base) JZJZ:src amari$ 
