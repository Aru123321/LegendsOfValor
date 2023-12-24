
Aru Pandey
arupande@bu.edu
U14204225

## Files
---------------------------------------------------------------------------
Packages：

1. Cell

    Classes Used in the Monster and Hero Game:
    -Cell: a basic cell, many other cell classes extends this class (super class of those cell); Be used in both game.
    -market: a market, heroes can buy items here. Items are ramdomly selected in each market. Be used in both game.
    -inaccessibleCell: A cell inaccessible to heroes; Be used in both game.
    -Battle: a battle in the common space
    -commonCell: a common space with a 50% chance of encountering a battle.
    -marketCell: heroes can enter market in this cell


    Classes Used in the Legends Of Valor Game:
    -Cell: a basic cell, all other cell classes extends this class (super class of those cell); Be used in both game.
    -market: a market, heroes can buy items here. Be used in both game.
    -inaccessibleCell: A cell inaccessible to heroes; Be used in both game.
    -BushCell: Bush space
    -CaveCell: Cave space
    -KoulouCell: Koulou space
    -PlainCell: Plain space
    -HeroNexusCell: The event here is to enter a market.
    -MonsterNexusCell: when a hero is in this cell, hero wins
    -ObstacleCell: A cell inaccessible to heroes, but it can be changed to plain space based on the rule

2. Character
    All classes are used in both game:
    Character: an abstract class for both heroes and monsters; super class of Hero class and Monster class
    HeroCharacter: an interface for heroes to implement
    MonsterCharacter: an interface for Monsters to implement
    HeroFactory: Create all heroes
    MonsterFactory: Create all monsters
    HeroFactoryCreator: an interface of the factory
    MonsterFactoryCreator: an interface of the factory

    Hero: a basic hero class; super class of all heroes; extends Character; implements HeroCharacter
            -Paladin, Warrior, Sorcerer
    Monster: a basic monster class; super class of all monsters; extends Character; implements MonsterCharacter
             -Dragon, Exoskeleton, Spirit

    Strategy pattern:
    SkillStrategy: an interface to increase skills for different type of heroes
    PaladinSkillStrategy: A class implements SkillStrategy.
    WarriorkillStrategy: A class implements SkillStrategy.
    SorcererSkillStrategy: A class implements SkillStrategy.


3. Game
    -roundGame: abstract class for all round games
    -LegendsOfValorGame: the game of Legend of Valor Game, extends roundGame
    -MonsterHeroGame: the game of Monster and Hero Game, extends roundGame
    -GameEventListener: an observer interface to check whether monster or hero wins

4.InputAndReader
    -InputValidator: many methods to check the inputs
    -txtReader: this class is to help herofactory, monsterfactory and itemfactory to read txt

5. Item
    All classes are used in both game:
	Consumable: an interface to be used for consumable items
	Equipable:  an interface to be used for Equipable items
	Item: an interface for all items and  can be implemented
	ItemFactory: create all items
	    -Armor, Potions, Spell, Weaponry extend Item and implement Consumable and Equipable
	    -IceSpell, FirSpell, LightningSpell extend Spell
	ItemFactoryCreator: an interface of the item


6. Map
    -map: an interface for all maps
    -LegendsOfValorMap: the Map of Legend of Valor Game, implements map
    -MonsterHeroMap: the Map of Monster and Hero Game, implements map

7. Party
    -monsterGroup: generate monster group, group size is 3; be used in LegendsOfValorGame
    -party: generate hero party; be used in both games



## Notes
---------------------------------------------------------------------------
1. You quit game at anytime if enter 'q'
2. A spell can be used 3 times
3. A potion is a single-use item.
4. Factory Pattern is used for MonsterFactory, HeroFactory, and ItemFactory
5. When a hero or a monster is killed, his body is still on the map during that round.
    When round over, Monster's body will disappear and hero will respawn.
6. A game statistic is at the end of the game.
7. Strategy pattern is used for the skill increases of different hero types.
8. Observer pattern is used for win check.



##  Some rules of Legends Of Valor Game we followed:
---------------------------------------------------------------------------
1.	Every round every hero that is still alive regains 10% of their hp and 10% of their mana.
2.	When a hero dies, they respawn in their specific Nexus space at the start of the next round.
3.	When a monster dies, Monsters drop 500×𝑚𝑜𝑛𝑠𝑡𝑒𝑟_𝑙𝑒𝑣𝑒𝑙 gold and 2∗𝑚𝑜𝑛𝑠𝑡𝑒𝑟_𝑙𝑒𝑣𝑒𝑙 experience points, given to all heroes
4.	Every 8 rounds, new monsters spawn
5.	Monster action: Go down except meet Obstacle space (turn left or turn right) or meet a hero (must fight)
6.  Using two hands to hold the weapon can increase attack points


## How to compile and run
---------------------------------------------------------------------------
Run the following instructions:
javac *.java -d bin
java -cp ./bin Main



## Input/Output Example
---------------------------------------------------------------------------
/Users/jingyili/Library/Java/JavaVirtualMachines/corretto-1.8.0_382/Contents/Home/bin/java -javaagent:/Applications/IntelliJ IDEA CE.app/Contents/lib/idea_rt.jar=55006:/Applications/IntelliJ IDEA CE.app/Contents/bin -Dfile.encoding=UTF-8 -classpath /Users/jingyili/Library/Java/JavaVirtualMachines/corretto-1.8.0_382/Contents/Home/jre/lib/charsets.jar:/Users/jingyili/Library/Java/JavaVirtualMachines/corretto-1.8.0_382/Contents/Home/jre/lib/ext/cldrdata.jar:/Users/jingyili/Library/Java/JavaVirtualMachines/corretto-1.8.0_382/Contents/Home/jre/lib/ext/dnsns.jar:/Users/jingyili/Library/Java/JavaVirtualMachines/corretto-1.8.0_382/Contents/Home/jre/lib/ext/jaccess.jar:/Users/jingyili/Library/Java/JavaVirtualMachines/corretto-1.8.0_382/Contents/Home/jre/lib/ext/jfxrt.jar:/Users/jingyili/Library/Java/JavaVirtualMachines/corretto-1.8.0_382/Contents/Home/jre/lib/ext/localedata.jar:/Users/jingyili/Library/Java/JavaVirtualMachines/corretto-1.8.0_382/Contents/Home/jre/lib/ext/nashorn.jar:/Users/jingyili/Library/Java/JavaVirtualMachines/corretto-1.8.0_382/Contents/Home/jre/lib/ext/sunec.jar:/Users/jingyili/Library/Java/JavaVirtualMachines/corretto-1.8.0_382/Contents/Home/jre/lib/ext/sunjce_provider.jar:/Users/jingyili/Library/Java/JavaVirtualMachines/corretto-1.8.0_382/Contents/Home/jre/lib/ext/sunpkcs11.jar:/Users/jingyili/Library/Java/JavaVirtualMachines/corretto-1.8.0_382/Contents/Home/jre/lib/ext/zipfs.jar:/Users/jingyili/Library/Java/JavaVirtualMachines/corretto-1.8.0_382/Contents/Home/jre/lib/jce.jar:/Users/jingyili/Library/Java/JavaVirtualMachines/corretto-1.8.0_382/Contents/Home/jre/lib/jfr.jar:/Users/jingyili/Library/Java/JavaVirtualMachines/corretto-1.8.0_382/Contents/Home/jre/lib/jfxswt.jar:/Users/jingyili/Library/Java/JavaVirtualMachines/corretto-1.8.0_382/Contents/Home/jre/lib/jsse.jar:/Users/jingyili/Library/Java/JavaVirtualMachines/corretto-1.8.0_382/Contents/Home/jre/lib/management-agent.jar:/Users/jingyili/Library/Java/JavaVirtualMachines/corretto-1.8.0_382/Contents/Home/jre/lib/resources.jar:/Users/jingyili/Library/Java/JavaVirtualMachines/corretto-1.8.0_382/Contents/Home/jre/lib/rt.jar:/Users/jingyili/611-Legends-of-Valor/out/production/611-Legends-of-Valor Main
Do you want to play 1. <Monsters and Heroes Game> or 2. <Legends Of Valor Game> ? Please enter 1 or 2:
2
*************************************************
     Welcome to Legends: Legends of Valor
*************************************************
Legends of Valor is a MOBA (multiplayer online battle arena)-like game. The monsters and
heroes live in a fictional world. They do not get along and therefore fight each other.
Every time the heroes win, they gain experience and money. Heroes use the money to buy a variety of
items to aid them in their battles with the monsters. When they accumulate enough experience, they
level up, which improves their skills. You will control a team of 3 heroes who will attempt to fight
their way through to the monsters’ Nexus. The heroes win if any of them reach the monsters’ Nexus.
The heroes lose if any monster reaches the heroes’ Nexus.
Please select 3 heroes in your party: List of Heroes:

Warriors:
   Name                 HP         Level      Mana       Strength   Agility    Dexterity  Starting Money Starting Experience

1.    Gaerdal_Ironhand     100        1          100        700        500        600        1354          7
2.    Sehanine_Monnbow     100        1          600        700        800        500        2500          8
3.    Muamman_Duathall     100        1          300        900        500        750        2546          6
4.    Flandal_Steelskin    100        1          200        750        650        700        2500          7
5.    Undefeated_Yoj       100        1          400        800        400        700        2500          7
6.    Eunoia_Cyn           100        1          400        700        800        600        2500          6

Sorcerers:
   Name                 HP         Level      Mana       Strength   Agility    Dexterity  Starting Money Starting Experience

1.    Rillifane_Rallathil  100        1          1300       750        450        500        2500          9
2.    Segojan_Earthcaller  100        1          900        800        500        650        2500          5
3.    Reign_Havoc          100        1          800        800        800        800        2500          8
4.    Reverie_Ashels       100        1          900        800        700        400        2500          7
5.    Kalabar              100        1          800        850        400        600        2500          6
6.    Skye_Soar            100        1          1000       700        400        500        2500          5

Paladins:
   Name                 HP         Level      Mana       Strength   Agility    Dexterity  Starting Money Starting Experience

1.    Parzival             100        1          300        750        650        700        2500          7
2.    Sehanine_Moonbow     100        1          300        750        700        700        2500          7
3.    Skoraeus_Stonebones  100        1          250        650        600        350        2500          4
4.    Garl_Glittergold     100        1          100        600        500        400        2500          5
5.    Amaryllis_Astra      100        1          500        500        500        500        2500          5
6.    Caliber_Heist        100        1          400        400        400        400        2500          8

You will need to select 3 heroes!
Please enter one hero type you want to join your party (Warrior: w/ Sorcerer: s/ Paladin: p):
p
Please enter his/her ID number:
1
Parzival successfully join your party!
Please enter one hero type you want to join your party (Warrior: w/ Sorcerer: s/ Paladin: p):
p
Please enter his/her ID number:
2
Sehanine_Moonbow successfully join your party!
Please enter one hero type you want to join your party (Warrior: w/ Sorcerer: s/ Paladin: p):
p
Please enter his/her ID number:
3
Skoraeus_Stonebones successfully join your party!
Your party have assembled：
   Name                 HP         Level      Mana       Strength   Agility    Dexterity  Money         Experience

1.    Parzival             100        1          300        750        650        700        2500          7
2.    Sehanine_Moonbow     100        1          300        750        700        700        2500          7
3.    Skoraeus_Stonebones  100        1          250        650        600        350        2500          4
*************************************************
Three monsters spawn in the monsters’ Nexus：
   Name                 HP         level      damage     defense    dodge chance

1.    BigBad-Wolf          100        1          150        2          0.15
2.    Casper               100        1          100        1          0.50
3.    Natsunomeryu         100        1          100        2          0.10

Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||   M1||     ||     ||   M2||     ||     ||   M3|
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  O-O-O  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  K-K-K  O-O-O  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 O-O-O  O-O-O  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 O-O-O  O-O-O  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||H1   ||     ||     ||H2   ||     ||     ||H3   |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N


Reminder you can quit the game if you enter [Q] at any time.
Reminder hero can attack more if he or she hold the weapon by two hands.

************************************
Game Start!
Parzival is at the Nexus!
Would you like to enter the market? (Y/N):
y
   Name                 HP         Level      Mana       Strength   Agility    Dexterity  Money         Experience

   Parzival             100        1          300        750        650        700        2500          7
Please enter the ID number of the hero you want who to enter the market:
Parzival is in the market, she/he can buy:
        1. Weapons
        2. Armors
        3. Potions
        4. Spells
She/he can sell:
        5. Weapons
        6. Armors
        7. Potions
        8. Spells
Enter [I] for hero info, [L] to leave the market, or choose an option from 1-8:
4
Spell:
   Type                 Name                 cost       required level damage     mana cost

1. FireSpells           Flame_Tornado        700        4          850        300

2. FireSpells           Breath_of_Fire       350        1          450        100

3. FireSpells           Heat_Wave            450        2          600        150

4. FireSpells           Lava_Comet           800        7          1000       550

5. FireSpells           Hell_Storm           600        3          950        600

6. IceSpells            Snow_Cannon          500        2          650        250

7. IceSpells            Ice_Blade            250        1          450        100

8. IceSpells            Frost_Blizzard       750        5          850        350

9. IceSpells            Arctic_Storm         700        6          800        300

10. LightningSpells      Lightning_Dagger     400        1          500        150

11. LightningSpells      Thunder_Blast        750        4          950        400

12. LightningSpells      Electric_Arrows      550        5          650        200

13. LightningSpells      Spark_Needles        500        2          600        200


Enter [I] for hero info, [X] to change your mind if you don't want to buy anything, or select an option number:
10
Parzival bought the item successfully!
Your Spells inventory:
Spells
   Type                 Name                 cost       required level damage     mana cost

1. LightningSpells      Lightning_Dagger     400        1          500        150


   Name                 HP         Level      Mana       Strength   Agility    Dexterity  Money         Experience

   Parzival             100        1          300        750        650        700        2100          7
Do you want to continue shopping [Y/N]:
n
**************** It's Hero 1-- Parzival's turn: ******************
[T] Attack    [S] Use Spells   [P] Use Potions
[A] Equip Armor  [W] Equip Weapon  [V] Move [O]Teleport [R] Recall [I] Hero Info [M] Monster Info
Choose an action:v
Please enter your movement direction [W/A/S/D]:
w
You are at the Plain Space!
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||   M1||     ||     ||   M2||     ||     ||   M3|
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  O-O-O  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  K-K-K  O-O-O  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 O-O-O  O-O-O  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 O-O-O  O-O-O  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||H1   ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||H2   ||     ||     ||H3   |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

Sehanine_Moonbow is at the Nexus!
Would you like to enter the market? (Y/N):
y
   Name                 HP         Level      Mana       Strength   Agility    Dexterity  Money         Experience

   Sehanine_Moonbow     100        1          300        750        700        700        2500          7
Please enter the ID number of the hero you want who to enter the market:
Sehanine_Moonbow is in the market, she/he can buy:
        1. Weapons
        2. Armors
        3. Potions
        4. Spells
She/he can sell:
        5. Weapons
        6. Armors
        7. Potions
        8. Spells
Enter [I] for hero info, [L] to leave the market, or choose an option from 1-8:
1
Weapons:
  Type                  Name                 cost       required level damage     required hands

1. Weaponry             Sword                500        1          800        1

2. Weaponry             Bow                  300        2          500        2

3. Weaponry             Scythe               1000       6          1100       2

4. Weaponry             Axe                  550        5          850        1

5. Weaponry             TSwords              1400       8          1600       2

6. Weaponry             Dagger               200        1          250        1


Enter [I] for hero info, [X] to change your mind if you don't want to buy anything, or select an option number:
6
Sehanine_Moonbow bought the item successfully!
Your Weapons inventory:
Weapons
  Type                  Name                 cost       required level damage     required hands

1. Weaponry             Dagger               200        1          250        1


   Name                 HP         Level      Mana       Strength   Agility    Dexterity  Money         Experience

   Sehanine_Moonbow     100        1          300        750        700        700        2300          7
Do you want to continue shopping [Y/N]:
n
**************** It's Hero 2-- Sehanine_Moonbow's turn: ******************
[T] Attack    [S] Use Spells   [P] Use Potions
[A] Equip Armor  [W] Equip Weapon  [V] Move [O]Teleport [R] Recall [I] Hero Info [M] Monster Info
Choose an action:v
Please enter your movement direction [W/A/S/D]:
w
You are at the Plain Space!
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||   M1||     ||     ||   M2||     ||     ||   M3|
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  O-O-O  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  K-K-K  O-O-O  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 O-O-O  O-O-O  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 O-O-O  O-O-O  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||H1   ||     ||     ||H2   ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||H3   |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

Skoraeus_Stonebones is at the Nexus!
Would you like to enter the market? (Y/N):
v
Invalid input. Please enter 'Y' for Yes or 'N' for No (or 'Q' to quit):
w
Invalid input. Please enter 'Y' for Yes or 'N' for No (or 'Q' to quit):
y
   Name                 HP         Level      Mana       Strength   Agility    Dexterity  Money         Experience

   Skoraeus_Stonebones  100        1          250        650        600        350        2500          4
Please enter the ID number of the hero you want who to enter the market:
Skoraeus_Stonebones is in the market, she/he can buy:
        1. Weapons
        2. Armors
        3. Potions
        4. Spells
She/he can sell:
        5. Weapons
        6. Armors
        7. Potions
        8. Spells
Enter [I] for hero info, [L] to leave the market, or choose an option from 1-8:
2
Armor:
  Type                  Name                 cost       required level damage reduction

1. Armory               Platinum_Shield      150        1          200

2. Armory               Breastplate          350        3          600

3. Armory               Full_Body_Armor      1000       8          1100

4. Armory               Wizard_Shield        1200       10         1500

5. Armory               Guardian_Angel       1000       10         1000


Enter [I] for hero info, [X] to change your mind if you don't want to buy anything, or select an option number:
1
Skoraeus_Stonebones bought the item successfully!
Your Armors inventory:
Armors
  Type                  Name                 cost       required level damage reduction

1. Armory               Platinum_Shield      150        1          200


   Name                 HP         Level      Mana       Strength   Agility    Dexterity  Money         Experience

   Skoraeus_Stonebones  100        1          250        650        600        350        2350          4
Do you want to continue shopping [Y/N]:
n
**************** It's Hero 3-- Skoraeus_Stonebones's turn: ******************
[T] Attack    [S] Use Spells   [P] Use Potions
[A] Equip Armor  [W] Equip Weapon  [V] Move [O]Teleport [R] Recall [I] Hero Info [M] Monster Info
Choose an action:v
Please enter your movement direction [W/A/S/D]:
w
Skoraeus_Stonebones are at the Cave Space! You can get bonus:
Skoraeus_Stonebones's original agility is 600now
Skoraeus_Stonebones's Agility increases 60!
Skoraeus_Stonebones's agility is 660now
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||   M1||     ||     ||   M2||     ||     ||   M3|
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  O-O-O  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  K-K-K  O-O-O  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 O-O-O  O-O-O  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 O-O-O  O-O-O  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||H1   ||     ||     ||H2   ||     ||     ||H3   |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

*****************It's Monster 1 -- BigBad-Wolf Turn: *********************
The monster goes forward!
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||   M2||     ||     ||   M3|
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  O-O-O  I-I-I  P-P-P  P-P-P
|     ||   M1||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  K-K-K  O-O-O  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 O-O-O  O-O-O  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 O-O-O  O-O-O  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||H1   ||     ||     ||H2   ||     ||     ||H3   |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

*****************It's Monster 2 -- Casper Turn: *********************
The monster meets an obstacle!
The monster goes left
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||   M2||     ||     ||     ||   M3|
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  O-O-O  I-I-I  P-P-P  P-P-P
|     ||   M1||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  K-K-K  O-O-O  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 O-O-O  O-O-O  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 O-O-O  O-O-O  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||H1   ||     ||     ||H2   ||     ||     ||H3   |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

*****************It's Monster 3 -- Natsunomeryu Turn: *********************
The monster goes forward!
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||   M2||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  O-O-O  I-I-I  P-P-P  P-P-P
|     ||   M1||     ||     ||     ||     ||     ||   M3|
 B-B-B  C-C-C  I-I-I  K-K-K  O-O-O  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 O-O-O  O-O-O  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 O-O-O  O-O-O  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||H1   ||     ||     ||H2   ||     ||     ||H3   |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

***********************************************
The round is over:
Reminder you can quit the game if you enter [Q] at any time.
All alive heroes get 10% HP and 10% mana!
Parzival's HP increases 10!
The hero has a HP limit which is 100, so its HP is 100 now!
Parzival's mana increases 30!
Sehanine_Moonbow's HP increases 10!
The hero has a HP limit which is 100, so its HP is 100 now!
Sehanine_Moonbow's mana increases 30!
Skoraeus_Stonebones's HP increases 10!
The hero has a HP limit which is 100, so its HP is 100 now!
Skoraeus_Stonebones's mana increases 25!
**************** It's Hero 1-- Parzival's turn: ******************
[T] Attack    [S] Use Spells   [P] Use Potions
[A] Equip Armor  [W] Equip Weapon  [V] Move [O]Teleport [R] Recall [I] Hero Info [M] Monster Info
Choose an action:v
Please enter your movement direction [W/A/S/D]:
w
You are at the Plain Space!
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||   M2||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  O-O-O  I-I-I  P-P-P  P-P-P
|     ||   M1||     ||     ||     ||     ||     ||   M3|
 B-B-B  C-C-C  I-I-I  K-K-K  O-O-O  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 O-O-O  O-O-O  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 O-O-O  O-O-O  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||H1   ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||H2   ||     ||     ||H3   |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

**************** It's Hero 2-- Sehanine_Moonbow's turn: ******************
[T] Attack    [S] Use Spells   [P] Use Potions
[A] Equip Armor  [W] Equip Weapon  [V] Move [O]Teleport [R] Recall [I] Hero Info [M] Monster Info
Choose an action:v
Please enter your movement direction [W/A/S/D]:
w
You are at the Plain Space!
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||   M2||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  O-O-O  I-I-I  P-P-P  P-P-P
|     ||   M1||     ||     ||     ||     ||     ||   M3|
 B-B-B  C-C-C  I-I-I  K-K-K  O-O-O  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 O-O-O  O-O-O  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 O-O-O  O-O-O  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||H1   ||     ||     ||H2   ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||H3   |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

**************** It's Hero 3-- Skoraeus_Stonebones's turn: ******************
[T] Attack    [S] Use Spells   [P] Use Potions
[A] Equip Armor  [W] Equip Weapon  [V] Move [O]Teleport [R] Recall [I] Hero Info [M] Monster Info
Choose an action:v
Please enter your movement direction [W/A/S/D]:
w
You left Cave Space， so the bonus in Cave Space is deducted.
Skoraeus_Stonebones left Cave Space!
Skoraeus_Stonebones's Agility increases -60!
Skoraeus_Stonebones's agility is 600now
You are at the Plain Space!
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||   M2||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  O-O-O  I-I-I  P-P-P  P-P-P
|     ||   M1||     ||     ||     ||     ||     ||   M3|
 B-B-B  C-C-C  I-I-I  K-K-K  O-O-O  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 O-O-O  O-O-O  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 O-O-O  O-O-O  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||H1   ||     ||     ||H2   ||     ||     ||H3   |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

*****************It's Monster 1 -- BigBad-Wolf Turn: *********************
The monster goes forward!
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||   M2||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  O-O-O  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||   M3|
 B-B-B  C-C-C  I-I-I  K-K-K  O-O-O  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||   M1||     ||     ||     ||     ||     ||     |
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 O-O-O  O-O-O  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 O-O-O  O-O-O  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||H1   ||     ||     ||H2   ||     ||     ||H3   |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

*****************It's Monster 2 -- Casper Turn: *********************
The monster goes forward!
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  O-O-O  I-I-I  P-P-P  P-P-P
|     ||     ||     ||   M2||     ||     ||     ||   M3|
 B-B-B  C-C-C  I-I-I  K-K-K  O-O-O  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||   M1||     ||     ||     ||     ||     ||     |
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 O-O-O  O-O-O  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 O-O-O  O-O-O  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||H1   ||     ||     ||H2   ||     ||     ||H3   |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

*****************It's Monster 3 -- Natsunomeryu Turn: *********************
The monster goes forward!
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  O-O-O  I-I-I  P-P-P  P-P-P
|     ||     ||     ||   M2||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  K-K-K  O-O-O  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||   M1||     ||     ||     ||     ||     ||   M3|
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 O-O-O  O-O-O  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 O-O-O  O-O-O  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||H1   ||     ||     ||H2   ||     ||     ||H3   |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

***********************************************
The round is over:
Reminder you can quit the game if you enter [Q] at any time.
All alive heroes get 10% HP and 10% mana!
Parzival's HP increases 10!
The hero has a HP limit which is 100, so its HP is 100 now!
Parzival's mana increases 33!
Sehanine_Moonbow's HP increases 10!
The hero has a HP limit which is 100, so its HP is 100 now!
Sehanine_Moonbow's mana increases 33!
Skoraeus_Stonebones's HP increases 10!
The hero has a HP limit which is 100, so its HP is 100 now!
Skoraeus_Stonebones's mana increases 27!
**************** It's Hero 1-- Parzival's turn: ******************
[T] Attack    [S] Use Spells   [P] Use Potions
[A] Equip Armor  [W] Equip Weapon  [V] Move [O]Teleport [R] Recall [I] Hero Info [M] Monster Info
Choose an action:v
Please enter your movement direction [W/A/S/D]:
w
Parzival are at the Cave Space! You can get bonus:
Parzival's original agility is 650now
Parzival's Agility increases 65!
Parzival's agility is 715now
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  O-O-O  I-I-I  P-P-P  P-P-P
|     ||     ||     ||   M2||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  K-K-K  O-O-O  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||   M1||     ||     ||     ||     ||     ||   M3|
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 O-O-O  O-O-O  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 O-O-O  O-O-O  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||H1   ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||H2   ||     ||     ||H3   |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

**************** It's Hero 2-- Sehanine_Moonbow's turn: ******************
[T] Attack    [S] Use Spells   [P] Use Potions
[A] Equip Armor  [W] Equip Weapon  [V] Move [O]Teleport [R] Recall [I] Hero Info [M] Monster Info
Choose an action:v
Please enter your movement direction [W/A/S/D]:
w
Sehanine_Moonbow are at the Koulou Space! You can get bonus:
Sehanine_Moonbow's original strength is 750now
Sehanine_Moonbow's Strength increases 75!
Sehanine_Moonbow's strength is 825now
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  O-O-O  I-I-I  P-P-P  P-P-P
|     ||     ||     ||   M2||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  K-K-K  O-O-O  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||   M1||     ||     ||     ||     ||     ||   M3|
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 O-O-O  O-O-O  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 O-O-O  O-O-O  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||H1   ||     ||     ||H2   ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||H3   |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

**************** It's Hero 3-- Skoraeus_Stonebones's turn: ******************
[T] Attack    [S] Use Spells   [P] Use Potions
[A] Equip Armor  [W] Equip Weapon  [V] Move [O]Teleport [R] Recall [I] Hero Info [M] Monster Info
Choose an action:v
Please enter your movement direction [W/A/S/D]:
w
You are at the Plain Space!
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  O-O-O  I-I-I  P-P-P  P-P-P
|     ||     ||     ||   M2||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  K-K-K  O-O-O  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||   M1||     ||     ||     ||     ||     ||   M3|
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 O-O-O  O-O-O  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 O-O-O  O-O-O  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||H1   ||     ||     ||H2   ||     ||     ||H3   |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

*****************It's Monster 1 -- BigBad-Wolf Turn: *********************
The monster meets an obstacle!
The monster goes left
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  O-O-O  I-I-I  P-P-P  P-P-P
|     ||     ||     ||   M2||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  K-K-K  O-O-O  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|   M1||     ||     ||     ||     ||     ||     ||   M3|
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 O-O-O  O-O-O  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 O-O-O  O-O-O  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||H1   ||     ||     ||H2   ||     ||     ||H3   |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

*****************It's Monster 2 -- Casper Turn: *********************
The monster meets an obstacle!
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  O-O-O  I-I-I  P-P-P  P-P-P
|     ||     ||     ||   M2||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  K-K-K  O-O-O  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|   M1||     ||     ||     ||     ||     ||     ||   M3|
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 O-O-O  O-O-O  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 O-O-O  O-O-O  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||H1   ||     ||     ||H2   ||     ||     ||H3   |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

*****************It's Monster 3 -- Natsunomeryu Turn: *********************
The monster goes forward!
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  O-O-O  I-I-I  P-P-P  P-P-P
|     ||     ||     ||   M2||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  K-K-K  O-O-O  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|   M1||     ||     ||     ||     ||     ||     ||     |
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 O-O-O  O-O-O  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||     ||     ||     ||     ||     ||     ||   M3|
 O-O-O  O-O-O  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||H1   ||     ||     ||H2   ||     ||     ||H3   |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

***********************************************
The round is over:
Reminder you can quit the game if you enter [Q] at any time.
All alive heroes get 10% HP and 10% mana!
Parzival's HP increases 10!
The hero has a HP limit which is 100, so its HP is 100 now!
Parzival's mana increases 36!
Sehanine_Moonbow's HP increases 10!
The hero has a HP limit which is 100, so its HP is 100 now!
Sehanine_Moonbow's mana increases 36!
Skoraeus_Stonebones's HP increases 10!
The hero has a HP limit which is 100, so its HP is 100 now!
Skoraeus_Stonebones's mana increases 30!
**************** It's Hero 1-- Parzival's turn: ******************
[T] Attack    [S] Use Spells   [P] Use Potions
[A] Equip Armor  [W] Equip Weapon  [V] Move [O]Teleport [R] Recall [I] Hero Info [M] Monster Info
Choose an action:v
Please enter your movement direction [W/A/S/D]:
w
You meet an Obstacle. Do you want to use one turn to remove this obstacle [Y/N]:
y
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  O-O-O  I-I-I  P-P-P  P-P-P
|     ||     ||     ||   M2||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  K-K-K  O-O-O  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|   M1||     ||     ||     ||     ||     ||     ||     |
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 O-O-O  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||     ||     ||     ||     ||     ||     ||   M3|
 O-O-O  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||H1   ||     ||     ||H2   ||     ||     ||H3   |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

**************** It's Hero 2-- Sehanine_Moonbow's turn: ******************
[T] Attack    [S] Use Spells   [P] Use Potions
[A] Equip Armor  [W] Equip Weapon  [V] Move [O]Teleport [R] Recall [I] Hero Info [M] Monster Info
Choose an action:v
Please enter your movement direction [W/A/S/D]:
w
You left Koulou Space， so the bonus in Koulou Space is deducted.
Sehanine_Moonbow left Koulou Space!
Sehanine_Moonbow's Strength increases -75!
Sehanine_Moonbow's strength is 750now
Sehanine_Moonbow are at the Cave Space! You can get bonus:
Sehanine_Moonbow's original agility is 700now
Sehanine_Moonbow's Agility increases 70!
Sehanine_Moonbow's agility is 770now
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  O-O-O  I-I-I  P-P-P  P-P-P
|     ||     ||     ||   M2||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  K-K-K  O-O-O  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|   M1||     ||     ||     ||     ||     ||     ||     |
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 O-O-O  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||     ||     ||     ||H2   ||     ||     ||   M3|
 O-O-O  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||H1   ||     ||     ||     ||     ||     ||H3   |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

**************** It's Hero 3-- Skoraeus_Stonebones's turn: ******************
[T] Attack    [S] Use Spells   [P] Use Potions
[A] Equip Armor  [W] Equip Weapon  [V] Move [O]Teleport [R] Recall [I] Hero Info [M] Monster Info
Choose an action:v
Please enter your movement direction [W/A/S/D]:
w
Skoraeus_Stonebones are at the Cave Space! You can get bonus:
Skoraeus_Stonebones's original agility is 600now
Skoraeus_Stonebones's Agility increases 60!
Skoraeus_Stonebones's agility is 660now
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  O-O-O  I-I-I  P-P-P  P-P-P
|     ||     ||     ||   M2||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  K-K-K  O-O-O  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|   M1||     ||     ||     ||     ||     ||     ||     |
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 O-O-O  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||     ||     ||     ||H2   ||     ||     ||H3 M3|
 O-O-O  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||H1   ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

*****************It's Monster 1 -- BigBad-Wolf Turn: *********************
The monster meets an obstacle!
The monster goes right
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  O-O-O  I-I-I  P-P-P  P-P-P
|     ||     ||     ||   M2||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  K-K-K  O-O-O  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||   M1||     ||     ||     ||     ||     ||     |
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 O-O-O  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||     ||     ||     ||H2   ||     ||     ||H3 M3|
 O-O-O  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||H1   ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

*****************It's Monster 2 -- Casper Turn: *********************
The monster meets an obstacle!
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  O-O-O  I-I-I  P-P-P  P-P-P
|     ||     ||     ||   M2||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  K-K-K  O-O-O  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||   M1||     ||     ||     ||     ||     ||     |
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 O-O-O  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||     ||     ||     ||H2   ||     ||     ||H3 M3|
 O-O-O  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||H1   ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

*****************It's Monster 3 -- Natsunomeryu Turn: *********************
The monster attacks!
Skoraeus_Stonebones dodges successfully.
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  O-O-O  I-I-I  P-P-P  P-P-P
|     ||     ||     ||   M2||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  K-K-K  O-O-O  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||   M1||     ||     ||     ||     ||     ||     |
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 O-O-O  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||     ||     ||     ||H2   ||     ||     ||H3 M3|
 O-O-O  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||H1   ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

***********************************************
The round is over:
Reminder you can quit the game if you enter [Q] at any time.
All alive heroes get 10% HP and 10% mana!
Parzival's HP increases 10!
The hero has a HP limit which is 100, so its HP is 100 now!
Parzival's mana increases 39!
Sehanine_Moonbow's HP increases 10!
The hero has a HP limit which is 100, so its HP is 100 now!
Sehanine_Moonbow's mana increases 39!
Skoraeus_Stonebones's HP increases 10!
The hero has a HP limit which is 100, so its HP is 100 now!
Skoraeus_Stonebones's mana increases 33!
**************** It's Hero 1-- Parzival's turn: ******************
[T] Attack    [S] Use Spells   [P] Use Potions
[A] Equip Armor  [W] Equip Weapon  [V] Move [O]Teleport [R] Recall [I] Hero Info [M] Monster Info
Choose an action:v
Please enter your movement direction [W/A/S/D]:
w
You left Cave Space， so the bonus in Cave Space is deducted.
Parzival left Cave Space!
Parzival's Agility increases -65!
Parzival's agility is 650now
You are at the Plain Space!
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  O-O-O  I-I-I  P-P-P  P-P-P
|     ||     ||     ||   M2||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  K-K-K  O-O-O  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||   M1||     ||     ||     ||     ||     ||     |
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 O-O-O  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||H1   ||     ||     ||H2   ||     ||     ||H3 M3|
 O-O-O  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

**************** It's Hero 2-- Sehanine_Moonbow's turn: ******************
[T] Attack    [S] Use Spells   [P] Use Potions
[A] Equip Armor  [W] Equip Weapon  [V] Move [O]Teleport [R] Recall [I] Hero Info [M] Monster Info
Choose an action:v
Please enter your movement direction [W/A/S/D]:
w
You left Cave Space， so the bonus in Cave Space is deducted.
Sehanine_Moonbow left Cave Space!
Sehanine_Moonbow's Agility increases -70!
Sehanine_Moonbow's agility is 700now
Sehanine_Moonbow are at the Cave Space! You can get bonus:
Sehanine_Moonbow's original agility is 700now
Sehanine_Moonbow's Agility increases 70!
Sehanine_Moonbow's agility is 770now
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  O-O-O  I-I-I  P-P-P  P-P-P
|     ||     ||     ||   M2||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  K-K-K  O-O-O  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||   M1||     ||     ||H2   ||     ||     ||     |
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 O-O-O  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||H1   ||     ||     ||     ||     ||     ||H3 M3|
 O-O-O  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

**************** It's Hero 3-- Skoraeus_Stonebones's turn: ******************
[T] Attack    [S] Use Spells   [P] Use Potions
[A] Equip Armor  [W] Equip Weapon  [V] Move [O]Teleport [R] Recall [I] Hero Info [M] Monster Info
Choose an action:a
Skoraeus_Stonebones has these Armor:
Armor
  Type                  Name                 cost       required level damage reduction

1. Armory               Platinum_Shield      150        1          200


Which item does Skoraeus_Stonebones want to equip/use?
Enter [I] for hero info, [X] to change your mind if you don't want to equip, or select an option number:
1
Platinum_Shield is using.
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  O-O-O  I-I-I  P-P-P  P-P-P
|     ||     ||     ||   M2||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  K-K-K  O-O-O  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||   M1||     ||     ||H2   ||     ||     ||     |
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 O-O-O  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||H1   ||     ||     ||     ||     ||     ||H3 M3|
 O-O-O  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

*****************It's Monster 1 -- BigBad-Wolf Turn: *********************
The monster goes forward!
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  O-O-O  I-I-I  P-P-P  P-P-P
|     ||     ||     ||   M2||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  K-K-K  O-O-O  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||     ||     ||     ||H2   ||     ||     ||     |
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 O-O-O  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||H1 M1||     ||     ||     ||     ||     ||H3 M3|
 O-O-O  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

*****************It's Monster 2 -- Casper Turn: *********************
The monster meets an obstacle!
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  O-O-O  I-I-I  P-P-P  P-P-P
|     ||     ||     ||   M2||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  K-K-K  O-O-O  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||     ||     ||     ||H2   ||     ||     ||     |
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 O-O-O  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||H1 M1||     ||     ||     ||     ||     ||H3 M3|
 O-O-O  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

*****************It's Monster 3 -- Natsunomeryu Turn: *********************
The monster attacks!
Natsunomeryu attacks Skoraeus_Stonebones 0 damage!
Skoraeus_Stonebones has 100 HP.
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  O-O-O  I-I-I  P-P-P  P-P-P
|     ||     ||     ||   M2||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  K-K-K  O-O-O  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||     ||     ||     ||H2   ||     ||     ||     |
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 O-O-O  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||H1 M1||     ||     ||     ||     ||     ||H3 M3|
 O-O-O  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

***********************************************
The round is over:
Reminder you can quit the game if you enter [Q] at any time.
All alive heroes get 10% HP and 10% mana!
Parzival's HP increases 10!
The hero has a HP limit which is 100, so its HP is 100 now!
Parzival's mana increases 43!
Sehanine_Moonbow's HP increases 10!
The hero has a HP limit which is 100, so its HP is 100 now!
Sehanine_Moonbow's mana increases 43!
Skoraeus_Stonebones's HP increases 10!
The hero has a HP limit which is 100, so its HP is 100 now!
Skoraeus_Stonebones's mana increases 36!
**************** It's Hero 1-- Parzival's turn: ******************
[T] Attack    [S] Use Spells   [P] Use Potions
[A] Equip Armor  [W] Equip Weapon  [V] Move [O]Teleport [R] Recall [I] Hero Info [M] Monster Info
Choose an action:v
Please enter your movement direction [W/A/S/D]:
w
You cannot move behind a monster without killing it.
Your movement is invalid.
Please enter your movement direction again [W/A/S/D]:
a
You meet an Obstacle. Do you want to use one turn to remove this obstacle [Y/N]:
y
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  O-O-O  I-I-I  P-P-P  P-P-P
|     ||     ||     ||   M2||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  K-K-K  O-O-O  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||     ||     ||     ||H2   ||     ||     ||     |
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||H1 M1||     ||     ||     ||     ||     ||H3 M3|
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

**************** It's Hero 2-- Sehanine_Moonbow's turn: ******************
[T] Attack    [S] Use Spells   [P] Use Potions
[A] Equip Armor  [W] Equip Weapon  [V] Move [O]Teleport [R] Recall [I] Hero Info [M] Monster Info
Choose an action:v
Please enter your movement direction [W/A/S/D]:
w
You meet an Obstacle. Do you want to use one turn to remove this obstacle [Y/N]:
y
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
|     ||     ||     ||   M2||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||     ||     ||     ||H2   ||     ||     ||     |
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||H1 M1||     ||     ||     ||     ||     ||H3 M3|
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

**************** It's Hero 3-- Skoraeus_Stonebones's turn: ******************
[T] Attack    [S] Use Spells   [P] Use Potions
[A] Equip Armor  [W] Equip Weapon  [V] Move [O]Teleport [R] Recall [I] Hero Info [M] Monster Info
Choose an action:t
Skoraeus_Stonebones attacks Natsunomeryu
Natsunomeryu successfully dodges
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
|     ||     ||     ||   M2||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||     ||     ||     ||H2   ||     ||     ||     |
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||H1 M1||     ||     ||     ||     ||     ||H3 M3|
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

*****************It's Monster 1 -- BigBad-Wolf Turn: *********************
The monster attacks!
BigBad-Wolf attacks Parzival 15 damage!
Parzival has 85 HP.
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
|     ||     ||     ||   M2||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||     ||     ||     ||H2   ||     ||     ||     |
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||H1 M1||     ||     ||     ||     ||     ||H3 M3|
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

*****************It's Monster 2 -- Casper Turn: *********************
The monster meets an obstacle!
The monster goes right
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||   M2||     ||     ||     |
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||     ||     ||     ||H2   ||     ||     ||     |
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||H1 M1||     ||     ||     ||     ||     ||H3 M3|
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

*****************It's Monster 3 -- Natsunomeryu Turn: *********************
The monster attacks!
Natsunomeryu attacks Skoraeus_Stonebones 0 damage!
Skoraeus_Stonebones has 100 HP.
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||   M2||     ||     ||     |
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||     ||     ||     ||H2   ||     ||     ||     |
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||H1 M1||     ||     ||     ||     ||     ||H3 M3|
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

***********************************************
The round is over:
Reminder you can quit the game if you enter [Q] at any time.
All alive heroes get 10% HP and 10% mana!
Parzival's HP increases 8!
Parzival's mana increases 48!
Sehanine_Moonbow's HP increases 10!
The hero has a HP limit which is 100, so its HP is 100 now!
Sehanine_Moonbow's mana increases 48!
Skoraeus_Stonebones's HP increases 10!
The hero has a HP limit which is 100, so its HP is 100 now!
Skoraeus_Stonebones's mana increases 40!
**************** It's Hero 1-- Parzival's turn: ******************
[T] Attack    [S] Use Spells   [P] Use Potions
[A] Equip Armor  [W] Equip Weapon  [V] Move [O]Teleport [R] Recall [I] Hero Info [M] Monster Info
Choose an action:s
Parzival has these Spell:
Spell
   Type                 Name                 cost       required level damage     mana cost

1. LightningSpells      Lightning_Dagger     400        1          500        150


Which item does Parzival want to equip/use?
Enter [I] for hero info, [X] to change your mind if you don't want to equip, or select an option number:
1
You are using a spell, and your mana is deducted.
Before casting the spell, your mana is  529
After casting the spell, your mana is  379
Before using Ice spell, monster's dodge Chance is 0.15
BigBad-Wolf use lighting spell to BigBad-Wolf
BigBad-Wolf's base dodge chance decrease to 0.0 by lighting spell
Parzival attacks BigBad-Wolf and take 68 damage!
BigBad-Wolf has only 32 HP
This Spell can continue to be used 2 times.
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||   M2||     ||     ||     |
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||     ||     ||     ||H2   ||     ||     ||     |
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||H1 M1||     ||     ||     ||     ||     ||H3 M3|
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

**************** It's Hero 2-- Sehanine_Moonbow's turn: ******************
[T] Attack    [S] Use Spells   [P] Use Potions
[A] Equip Armor  [W] Equip Weapon  [V] Move [O]Teleport [R] Recall [I] Hero Info [M] Monster Info
Choose an action:v
Please enter your movement direction [W/A/S/D]:
w
You left Cave Space， so the bonus in Cave Space is deducted.
Sehanine_Moonbow left Cave Space!
Sehanine_Moonbow's Agility increases -70!
Sehanine_Moonbow's agility is 700now
You are at the Plain Space!
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||H2 M2||     ||     ||     |
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||H1 M1||     ||     ||     ||     ||     ||H3 M3|
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

**************** It's Hero 3-- Skoraeus_Stonebones's turn: ******************
[T] Attack    [S] Use Spells   [P] Use Potions
[A] Equip Armor  [W] Equip Weapon  [V] Move [O]Teleport [R] Recall [I] Hero Info [M] Monster Info
Choose an action:t
Skoraeus_Stonebones attacks Natsunomeryu and take 43 damage!
Natsunomeryu has only 57 HP
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||H2 M2||     ||     ||     |
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||H1 M1||     ||     ||     ||     ||     ||H3 M3|
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

*****************It's Monster 1 -- BigBad-Wolf Turn: *********************
The monster attacks!
BigBad-Wolf attacks Parzival 15 damage!
Parzival has 78 HP.
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||H2 M2||     ||     ||     |
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||H1 M1||     ||     ||     ||     ||     ||H3 M3|
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

*****************It's Monster 2 -- Casper Turn: *********************
The monster attacks!
Casper attacks Sehanine_Moonbow 10 damage!
Sehanine_Moonbow has 90 HP.
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||H2 M2||     ||     ||     |
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||H1 M1||     ||     ||     ||     ||     ||H3 M3|
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

*****************It's Monster 3 -- Natsunomeryu Turn: *********************
The monster attacks!
Natsunomeryu attacks Skoraeus_Stonebones 0 damage!
Skoraeus_Stonebones has 100 HP.
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||H2 M2||     ||     ||     |
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||H1 M1||     ||     ||     ||     ||     ||H3 M3|
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

***********************************************
The round is over:
Reminder you can quit the game if you enter [Q] at any time.
All alive heroes get 10% HP and 10% mana!
Parzival's HP increases 7!
Parzival's mana increases 37!
Sehanine_Moonbow's HP increases 9!
Sehanine_Moonbow's mana increases 52!
Skoraeus_Stonebones's HP increases 10!
The hero has a HP limit which is 100, so its HP is 100 now!
Skoraeus_Stonebones's mana increases 44!
**************** It's Hero 1-- Parzival's turn: ******************
[T] Attack    [S] Use Spells   [P] Use Potions
[A] Equip Armor  [W] Equip Weapon  [V] Move [O]Teleport [R] Recall [I] Hero Info [M] Monster Info
Choose an action:s
Parzival has these Spell:
Spell
   Type                 Name                 cost       required level damage     mana cost

1. LightningSpells      Lightning_Dagger     400        1          500        150


Which item does Parzival want to equip/use?
Enter [I] for hero info, [X] to change your mind if you don't want to equip, or select an option number:
1
You are using a spell, and your mana is deducted.
Before casting the spell, your mana is  416
After casting the spell, your mana is  266
Before using Ice spell, monster's dodge Chance is 0.0
BigBad-Wolf use lighting spell to BigBad-Wolf
BigBad-Wolf's base dodge chance decrease to 0.0 by lighting spell
Parzival attacks BigBad-Wolf and take 68 damage!
BigBad-Wolf has only 0 HP
BigBad-Wolf dies.
This Spell can continue to be used 1 times.
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||H2 M2||     ||     ||     |
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||H1 M1||     ||     ||     ||     ||     ||H3 M3|
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

**************** It's Hero 2-- Sehanine_Moonbow's turn: ******************
[T] Attack    [S] Use Spells   [P] Use Potions
[A] Equip Armor  [W] Equip Weapon  [V] Move [O]Teleport [R] Recall [I] Hero Info [M] Monster Info
Choose an action:w
Sehanine_Moonbow has these Weapon:
Weapon
  Type                  Name                 cost       required level damage     required hands

1. Weaponry             Dagger               200        1          250        1


Which item does Sehanine_Moonbow want to equip/use?
Enter [I] for hero info, [X] to change your mind if you don't want to equip, or select an option number:
1
Dagger is equipped!
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||H2 M2||     ||     ||     |
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||H1 M1||     ||     ||     ||     ||     ||H3 M3|
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

**************** It's Hero 3-- Skoraeus_Stonebones's turn: ******************
[T] Attack    [S] Use Spells   [P] Use Potions
[A] Equip Armor  [W] Equip Weapon  [V] Move [O]Teleport [R] Recall [I] Hero Info [M] Monster Info
Choose an action:t
Skoraeus_Stonebones attacks Natsunomeryu and take 43 damage!
Natsunomeryu has only 14 HP
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||H2 M2||     ||     ||     |
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||H1 M1||     ||     ||     ||     ||     ||H3 M3|
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

*************************************************
In this round:
Monster BigBad-Wolf dead.
A monster is dead in this round. All heroes can get $500 money and 2 experience!
*****************It's Monster 2 -- Casper Turn: *********************
The monster attacks!
Casper attacks Sehanine_Moonbow 10 damage!
Sehanine_Moonbow has 89 HP.
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||H2 M2||     ||     ||     |
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||H1   ||     ||     ||     ||     ||     ||H3 M3|
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

*****************It's Monster 3 -- Natsunomeryu Turn: *********************
The monster attacks!
Natsunomeryu attacks Skoraeus_Stonebones 0 damage!
Skoraeus_Stonebones has 100 HP.
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||H2 M2||     ||     ||     |
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||H1   ||     ||     ||     ||     ||     ||H3 M3|
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

***********************************************
The round is over:
Reminder you can quit the game if you enter [Q] at any time.
All alive heroes get 10% HP and 10% mana!
Parzival's HP increases 8!
Parzival's mana increases 26!
Sehanine_Moonbow's HP increases 8!
Sehanine_Moonbow's mana increases 58!
Skoraeus_Stonebones's HP increases 10!
The hero has a HP limit which is 100, so its HP is 100 now!
Skoraeus_Stonebones's mana increases 48!
*************************************************
Three monsters spawn in the monsters’ Nexus：
   Name                 HP         level      damage     defense    dodge chance

1.    Casper               100        1          100        1          0.50
2.    BigBad-Wolf          100        1          150        2          0.15
3.    Natsunomeryu         100        1          100        2          0.10

**************** It's Hero 1-- Parzival's turn: ******************
[T] Attack    [S] Use Spells   [P] Use Potions
[A] Equip Armor  [W] Equip Weapon  [V] Move [O]Teleport [R] Recall [I] Hero Info [M] Monster Info
Choose an action:s
Parzival has these Spell:
Spell
   Type                 Name                 cost       required level damage     mana cost

1. LightningSpells      Lightning_Dagger     400        1          500        150


Which item does Parzival want to equip/use?
Enter [I] for hero info, [X] to change your mind if you don't want to equip, or select an option number:
1
No monster is in your spell attack range.
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||   M4||     ||     ||   M5||     ||     ||   M6|
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||H2 M2||     ||     ||     |
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||H1   ||     ||     ||     ||     ||     ||H3 M3|
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

**************** It's Hero 1-- Parzival's turn: ******************
[T] Attack    [S] Use Spells   [P] Use Potions
[A] Equip Armor  [W] Equip Weapon  [V] Move [O]Teleport [R] Recall [I] Hero Info [M] Monster Info
Choose an action:m
   Name                 HP         level      damage     defense    dodge chance

1.    BigBad-Wolf          0          1          150        2          0.00
2.    Casper               100        1          100        1          0.50
3.    Natsunomeryu         14         1          100        2          0.10
4.    Casper               100        1          100        1          0.50
5.    BigBad-Wolf          100        1          150        2          0.15
6.    Natsunomeryu         100        1          100        2          0.10

**************** It's Hero 1-- Parzival's turn: ******************
[T] Attack    [S] Use Spells   [P] Use Potions
[A] Equip Armor  [W] Equip Weapon  [V] Move [O]Teleport [R] Recall [I] Hero Info [M] Monster Info
Choose an action:t
No monster is in your attack range.
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||   M4||     ||     ||   M5||     ||     ||   M6|
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||H2 M2||     ||     ||     |
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||H1   ||     ||     ||     ||     ||     ||H3 M3|
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

**************** It's Hero 1-- Parzival's turn: ******************
[T] Attack    [S] Use Spells   [P] Use Potions
[A] Equip Armor  [W] Equip Weapon  [V] Move [O]Teleport [R] Recall [I] Hero Info [M] Monster Info
Choose an action:t
No monster is in your attack range.
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||   M4||     ||     ||   M5||     ||     ||   M6|
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||H2 M2||     ||     ||     |
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||H1   ||     ||     ||     ||     ||     ||H3 M3|
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

**************** It's Hero 1-- Parzival's turn: ******************
[T] Attack    [S] Use Spells   [P] Use Potions
[A] Equip Armor  [W] Equip Weapon  [V] Move [O]Teleport [R] Recall [I] Hero Info [M] Monster Info
Choose an action:v
Please enter your movement direction [W/A/S/D]:
w
Parzival are at the Koulou Space! You can get bonus:
Parzival's original strength is 750now
Parzival's Strength increases 75!
Parzival's strength is 825now
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||   M4||     ||     ||   M5||     ||     ||   M6|
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||H2 M2||     ||     ||     |
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||H1   ||     ||     ||     ||     ||     ||     |
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||     ||     ||     ||     ||     ||     ||H3 M3|
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

**************** It's Hero 2-- Sehanine_Moonbow's turn: ******************
[T] Attack    [S] Use Spells   [P] Use Potions
[A] Equip Armor  [W] Equip Weapon  [V] Move [O]Teleport [R] Recall [I] Hero Info [M] Monster Info
Choose an action:t
 Do you want to hold the weapon buy two hands: [N/Y]
y
Sehanine_Moonbow attacks Casper
Casper successfully dodges
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||   M4||     ||     ||   M5||     ||     ||   M6|
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||H2 M2||     ||     ||     |
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||H1   ||     ||     ||     ||     ||     ||     |
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||     ||     ||     ||     ||     ||     ||H3 M3|
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

**************** It's Hero 3-- Skoraeus_Stonebones's turn: ******************
[T] Attack    [S] Use Spells   [P] Use Potions
[A] Equip Armor  [W] Equip Weapon  [V] Move [O]Teleport [R] Recall [I] Hero Info [M] Monster Info
Choose an action:t
Skoraeus_Stonebones attacks Natsunomeryu and take 43 damage!
Natsunomeryu has only 0 HP
Natsunomeryu dies.
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||   M4||     ||     ||   M5||     ||     ||   M6|
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||H2 M2||     ||     ||     |
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||H1   ||     ||     ||     ||     ||     ||     |
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||     ||     ||     ||     ||     ||     ||H3 M3|
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

*************************************************
In this round:
Monster Natsunomeryu dead.
A monster is dead in this round. All heroes can get $500 money and 2 experience!
*****************It's Monster 2 -- Casper Turn: *********************
The monster attacks!
Casper attacks Sehanine_Moonbow 10 damage!
Sehanine_Moonbow has 87 HP.
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||   M4||     ||     ||   M5||     ||     ||   M6|
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||H2 M2||     ||     ||     |
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||H1   ||     ||     ||     ||     ||     ||     |
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||     ||     ||     ||     ||     ||     ||H3   |
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

*****************It's Monster 4 -- Casper Turn: *********************
The monster goes forward!
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||   M5||     ||     ||   M6|
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
|     ||   M4||     ||     ||H2 M2||     ||     ||     |
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||H1   ||     ||     ||     ||     ||     ||     |
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||     ||     ||     ||     ||     ||     ||H3   |
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

*****************It's Monster 5 -- BigBad-Wolf Turn: *********************
There's another monster ahead
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||   M5||     ||     ||   M6|
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
|     ||   M4||     ||     ||H2 M2||     ||     ||     |
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||H1   ||     ||     ||     ||     ||     ||     |
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||     ||     ||     ||     ||     ||     ||H3   |
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

*****************It's Monster 6 -- Natsunomeryu Turn: *********************
The monster goes forward!
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||   M5||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
|     ||   M4||     ||     ||H2 M2||     ||     ||   M6|
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||H1   ||     ||     ||     ||     ||     ||     |
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||     ||     ||     ||     ||     ||     ||H3   |
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

***********************************************
The round is over:
Reminder you can quit the game if you enter [Q] at any time.
All alive heroes get 10% HP and 10% mana!
Parzival's HP increases 9!
The hero has a HP limit which is 100, so its HP is 100 now!
Parzival's mana increases 29!
Sehanine_Moonbow's HP increases 8!
Sehanine_Moonbow's mana increases 63!
Skoraeus_Stonebones's HP increases 10!
The hero has a HP limit which is 100, so its HP is 100 now!
Skoraeus_Stonebones's mana increases 53!
*************************************************
Congratulations!Parzival has leveled up! His level is 2!
His skills increase! HP and Mana increase!
*************************************************
Congratulations!Sehanine_Moonbow has leveled up! His level is 2!
His skills increase! HP and Mana increase!
**************** It's Hero 1-- Parzival's turn: ******************
[T] Attack    [S] Use Spells   [P] Use Potions
[A] Equip Armor  [W] Equip Weapon  [V] Move [O]Teleport [R] Recall [I] Hero Info [M] Monster Info
Choose an action:i
   Name                 HP         Level      Mana       Strength   Agility    Dexterity  Money         Experience

1.    Parzival             200        2          353        909        683        772        3100          1
2.    Sehanine_Moonbow     200        2          772        827        735        772        3300          1
3.    Skoraeus_Stonebones  100        1          586        650        660        350        3350          8
**************** It's Hero 1-- Parzival's turn: ******************
[T] Attack    [S] Use Spells   [P] Use Potions
[A] Equip Armor  [W] Equip Weapon  [V] Move [O]Teleport [R] Recall [I] Hero Info [M] Monster Info
Choose an action:s
Parzival has these Spell:
Spell
   Type                 Name                 cost       required level damage     mana cost

1. LightningSpells      Lightning_Dagger     400        1          500        150


Which item does Parzival want to equip/use?
Enter [I] for hero info, [X] to change your mind if you don't want to equip, or select an option number:
1
You are using a spell, and your mana is deducted.
Before casting the spell, your mana is  353
After casting the spell, your mana is  203
Before using Ice spell, monster's dodge Chance is 0.5
Casper use lighting spell to Casper
Casper's base dodge chance decrease to 0.0 by lighting spell
Parzival attacks Casper and take 69 damage!
Casper has only 31 HP
This Spell can continue to be used 0 times.
The spell is run out. It is removed from your inventory.
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||   M5||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
|     ||   M4||     ||     ||H2 M2||     ||     ||   M6|
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||H1   ||     ||     ||     ||     ||     ||     |
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||     ||     ||     ||     ||     ||     ||H3   |
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

**************** It's Hero 2-- Sehanine_Moonbow's turn: ******************
[T] Attack    [S] Use Spells   [P] Use Potions
[A] Equip Armor  [W] Equip Weapon  [V] Move [O]Teleport [R] Recall [I] Hero Info [M] Monster Info
Choose an action:t
 Do you want to hold the weapon buy two hands: [N/Y]
y
Sehanine_Moonbow attacks Casper
Casper successfully dodges
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||   M5||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
|     ||   M4||     ||     ||H2 M2||     ||     ||   M6|
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||H1   ||     ||     ||     ||     ||     ||     |
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||     ||     ||     ||     ||     ||     ||H3   |
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

**************** It's Hero 3-- Skoraeus_Stonebones's turn: ******************
[T] Attack    [S] Use Spells   [P] Use Potions
[A] Equip Armor  [W] Equip Weapon  [V] Move [O]Teleport [R] Recall [I] Hero Info [M] Monster Info
Choose an action:v
Please enter your movement direction [W/A/S/D]:

Invalid input. Please enter 'W', 'A', 'S', 'D' (or 'Q' to quit):
w
You left Cave Space， so the bonus in Cave Space is deducted.
Skoraeus_Stonebones left Cave Space!
Skoraeus_Stonebones's Agility increases -60!
Skoraeus_Stonebones's agility is 600now
Skoraeus_Stonebones are at the Koulou Space! You can get bonus:
Skoraeus_Stonebones's original strength is 650now
Skoraeus_Stonebones's Strength increases 65!
Skoraeus_Stonebones's strength is 715now
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||   M5||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
|     ||   M4||     ||     ||H2 M2||     ||     ||   M6|
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||H1   ||     ||     ||     ||     ||     ||H3   |
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

*****************It's Monster 2 -- Casper Turn: *********************
The monster attacks!
Casper attacks Sehanine_Moonbow 10 damage!
Sehanine_Moonbow has 190 HP.
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||   M5||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
|     ||   M4||     ||     ||H2 M2||     ||     ||   M6|
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||H1   ||     ||     ||     ||     ||     ||H3   |
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

*****************It's Monster 4 -- Casper Turn: *********************
The monster goes forward!
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||   M5||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||H2 M2||     ||     ||   M6|
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||H1 M4||     ||     ||     ||     ||     ||H3   |
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

*****************It's Monster 5 -- BigBad-Wolf Turn: *********************
There's another monster ahead
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||   M5||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||H2 M2||     ||     ||   M6|
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||H1 M4||     ||     ||     ||     ||     ||H3   |
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

*****************It's Monster 6 -- Natsunomeryu Turn: *********************
The monster goes forward!
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||   M5||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||H2 M2||     ||     ||     |
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||H1 M4||     ||     ||     ||     ||     ||H3 M6|
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

***********************************************
The round is over:
Reminder you can quit the game if you enter [Q] at any time.
All alive heroes get 10% HP and 10% mana!
Parzival's HP increases 20!
The hero has a HP limit which is 200, so its HP is 200 now!
Parzival's mana increases 20!
Sehanine_Moonbow's HP increases 19!
The hero has a HP limit which is 200, so its HP is 200 now!
Sehanine_Moonbow's mana increases 77!
Skoraeus_Stonebones's HP increases 10!
The hero has a HP limit which is 100, so its HP is 100 now!
Skoraeus_Stonebones's mana increases 58!
**************** It's Hero 1-- Parzival's turn: ******************
[T] Attack    [S] Use Spells   [P] Use Potions
[A] Equip Armor  [W] Equip Weapon  [V] Move [O]Teleport [R] Recall [I] Hero Info [M] Monster Info
Choose an action:s
Parzival doesn't have any Spell.
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||   M5||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||H2 M2||     ||     ||     |
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||H1 M4||     ||     ||     ||     ||     ||H3 M6|
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

**************** It's Hero 1-- Parzival's turn: ******************
[T] Attack    [S] Use Spells   [P] Use Potions
[A] Equip Armor  [W] Equip Weapon  [V] Move [O]Teleport [R] Recall [I] Hero Info [M] Monster Info
Choose an action:t
Parzival attacks Casper and take 62 damage!
Casper has only 0 HP
Casper dies.
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||   M5||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||H2 M2||     ||     ||     |
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||H1 M4||     ||     ||     ||     ||     ||H3 M6|
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

**************** It's Hero 2-- Sehanine_Moonbow's turn: ******************
[T] Attack    [S] Use Spells   [P] Use Potions
[A] Equip Armor  [W] Equip Weapon  [V] Move [O]Teleport [R] Recall [I] Hero Info [M] Monster Info
Choose an action:t
 Do you want to hold the weapon buy two hands: [N/Y]
y
Sehanine_Moonbow attacks Casper and take 79 damage!
Casper has only 21 HP
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||   M5||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||H2 M2||     ||     ||     |
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||H1 M4||     ||     ||     ||     ||     ||H3 M6|
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

**************** It's Hero 3-- Skoraeus_Stonebones's turn: ******************
[T] Attack    [S] Use Spells   [P] Use Potions
[A] Equip Armor  [W] Equip Weapon  [V] Move [O]Teleport [R] Recall [I] Hero Info [M] Monster Info
Choose an action:t
Skoraeus_Stonebones attacks Natsunomeryu and take 48 damage!
Natsunomeryu has only 52 HP
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||   M5||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||H2 M2||     ||     ||     |
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||H1 M4||     ||     ||     ||     ||     ||H3 M6|
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

*************************************************
In this round:
Monster Casper dead.
A monster is dead in this round. All heroes can get $500 money and 2 experience!
*****************It's Monster 2 -- Casper Turn: *********************
The monster attacks!
Casper attacks Sehanine_Moonbow 10 damage!
Sehanine_Moonbow has 190 HP.
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||   M5||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||H2 M2||     ||     ||     |
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||H1   ||     ||     ||     ||     ||     ||H3 M6|
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

*****************It's Monster 5 -- BigBad-Wolf Turn: *********************
There's another monster ahead
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||   M5||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||H2 M2||     ||     ||     |
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||H1   ||     ||     ||     ||     ||     ||H3 M6|
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

*****************It's Monster 6 -- Natsunomeryu Turn: *********************
The monster attacks!
Skoraeus_Stonebones dodges successfully.
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||   M5||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||H2 M2||     ||     ||     |
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||H1   ||     ||     ||     ||     ||     ||H3 M6|
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

***********************************************
The round is over:
Reminder you can quit the game if you enter [Q] at any time.
All alive heroes get 10% HP and 10% mana!
Parzival's HP increases 20!
The hero has a HP limit which is 200, so its HP is 200 now!
Parzival's mana increases 22!
Sehanine_Moonbow's HP increases 19!
The hero has a HP limit which is 200, so its HP is 200 now!
Sehanine_Moonbow's mana increases 84!
Skoraeus_Stonebones's HP increases 10!
The hero has a HP limit which is 100, so its HP is 100 now!
Skoraeus_Stonebones's mana increases 64!
*************************************************
Congratulations!Skoraeus_Stonebones has leveled up! His level is 2!
His skills increase! HP and Mana increase!
**************** It's Hero 1-- Parzival's turn: ******************
[T] Attack    [S] Use Spells   [P] Use Potions
[A] Equip Armor  [W] Equip Weapon  [V] Move [O]Teleport [R] Recall [I] Hero Info [M] Monster Info
Choose an action:m
   Name                 HP         level      damage     defense    dodge chance

1.    BigBad-Wolf          0          1          150        2          0.00
2.    Casper               21         1          100        1          0.50
3.    Natsunomeryu         0          1          100        2          0.10
4.    Casper               0          1          100        1          0.00
5.    BigBad-Wolf          100        1          150        2          0.15
6.    Natsunomeryu         52         1          100        2          0.10

**************** It's Hero 1-- Parzival's turn: ******************
[T] Attack    [S] Use Spells   [P] Use Potions
[A] Equip Armor  [W] Equip Weapon  [V] Move [O]Teleport [R] Recall [I] Hero Info [M] Monster Info
Choose an action:r
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||   M5||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||H2 M2||     ||     ||     |
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||     ||     ||     ||     ||     ||     ||H3 M6|
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||H1   ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

**************** It's Hero 2-- Sehanine_Moonbow's turn: ******************
[T] Attack    [S] Use Spells   [P] Use Potions
[A] Equip Armor  [W] Equip Weapon  [V] Move [O]Teleport [R] Recall [I] Hero Info [M] Monster Info
Choose an action:t
 Do you want to hold the weapon buy two hands: [N/Y]
y
Sehanine_Moonbow attacks Casper
Casper successfully dodges
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||   M5||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||H2 M2||     ||     ||     |
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||     ||     ||     ||     ||     ||     ||H3 M6|
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||H1   ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

**************** It's Hero 3-- Skoraeus_Stonebones's turn: ******************
[T] Attack    [S] Use Spells   [P] Use Potions
[A] Equip Armor  [W] Equip Weapon  [V] Move [O]Teleport [R] Recall [I] Hero Info [M] Monster Info
Choose an action:t
Skoraeus_Stonebones attacks Natsunomeryu
Natsunomeryu successfully dodges
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||   M5||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||H2 M2||     ||     ||     |
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||     ||     ||     ||     ||     ||     ||H3 M6|
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||H1   ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

*****************It's Monster 2 -- Casper Turn: *********************
The monster attacks!
Casper attacks Sehanine_Moonbow 10 damage!
Sehanine_Moonbow has 190 HP.
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||   M5||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||H2 M2||     ||     ||     |
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||     ||     ||     ||     ||     ||     ||H3 M6|
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||H1   ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

*****************It's Monster 5 -- BigBad-Wolf Turn: *********************
There's another monster ahead
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||   M5||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||H2 M2||     ||     ||     |
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||     ||     ||     ||     ||     ||     ||H3 M6|
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||H1   ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

*****************It's Monster 6 -- Natsunomeryu Turn: *********************
The monster attacks!
Natsunomeryu attacks Skoraeus_Stonebones 0 damage!
Skoraeus_Stonebones has 200 HP.
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||   M5||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||H2 M2||     ||     ||     |
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||     ||     ||     ||     ||     ||     ||H3 M6|
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||H1   ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

***********************************************
The round is over:
Reminder you can quit the game if you enter [Q] at any time.
All alive heroes get 10% HP and 10% mana!
Parzival's HP increases 20!
The hero has a HP limit which is 200, so its HP is 200 now!
Parzival's mana increases 24!
Sehanine_Moonbow's HP increases 19!
The hero has a HP limit which is 200, so its HP is 200 now!
Sehanine_Moonbow's mana increases 93!
Skoraeus_Stonebones's HP increases 20!
The hero has a HP limit which is 200, so its HP is 200 now!
Skoraeus_Stonebones's mana increases 77!
Parzival is at the Nexus!
Would you like to enter the market? (Y/N):
y
   Name                 HP         Level      Mana       Strength   Agility    Dexterity  Money         Experience

   Parzival             200        2          269        909        683        772        3600          3
Please enter the ID number of the hero you want who to enter the market:
Parzival is in the market, she/he can buy:
        1. Weapons
        2. Armors
        3. Potions
        4. Spells
She/he can sell:
        5. Weapons
        6. Armors
        7. Potions
        8. Spells
Enter [I] for hero info, [L] to leave the market, or choose an option from 1-8:
4
Spell:
   Type                 Name                 cost       required level damage     mana cost

1. FireSpells           Flame_Tornado        700        4          850        300

2. FireSpells           Breath_of_Fire       350        1          450        100

3. FireSpells           Heat_Wave            450        2          600        150

4. FireSpells           Lava_Comet           800        7          1000       550

5. FireSpells           Hell_Storm           600        3          950        600

6. IceSpells            Snow_Cannon          500        2          650        250

7. IceSpells            Ice_Blade            250        1          450        100

8. IceSpells            Frost_Blizzard       750        5          850        350

9. IceSpells            Arctic_Storm         700        6          800        300

10. LightningSpells      Thunder_Blast        750        4          950        400

11. LightningSpells      Electric_Arrows      550        5          650        200

12. LightningSpells      Spark_Needles        500        2          600        200


Enter [I] for hero info, [X] to change your mind if you don't want to buy anything, or select an option number:
x
Do you want to continue shopping [Y/N]:
y
   Name                 HP         Level      Mana       Strength   Agility    Dexterity  Money         Experience

   Parzival             200        2          269        909        683        772        3600          3
Please enter the ID number of the hero you want who to enter the market:
Parzival is in the market, she/he can buy:
        1. Weapons
        2. Armors
        3. Potions
        4. Spells
She/he can sell:
        5. Weapons
        6. Armors
        7. Potions
        8. Spells
Enter [I] for hero info, [L] to leave the market, or choose an option from 1-8:
8
Do you want to continue shopping [Y/N]:
n
**************** It's Hero 1-- Parzival's turn: ******************
[T] Attack    [S] Use Spells   [P] Use Potions
[A] Equip Armor  [W] Equip Weapon  [V] Move [O]Teleport [R] Recall [I] Hero Info [M] Monster Info
Choose an action:o
Select a target hero number for teleportation:
0: Parzival
1: Sehanine_Moonbow
2: Skoraeus_Stonebones
0
Invalid selection. Teleportation cancelled.
Your action is inValid or you changed your mind, please choose a new action:
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||   M5||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||H2 M2||     ||     ||     |
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||     ||     ||     ||     ||     ||     ||H3 M6|
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||H1   ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

Parzival is at the Nexus!
Would you like to enter the market? (Y/N):
n
**************** It's Hero 1-- Parzival's turn: ******************
[T] Attack    [S] Use Spells   [P] Use Potions
[A] Equip Armor  [W] Equip Weapon  [V] Move [O]Teleport [R] Recall [I] Hero Info [M] Monster Info
Choose an action:o
Select a target hero number for teleportation:
0: Parzival
1: Sehanine_Moonbow
2: Skoraeus_Stonebones
1
Parzival has teleported to a position near Sehanine_Moonbow
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||   M5||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
|     ||     ||     ||H1   ||H2 M2||     ||     ||     |
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||     ||     ||     ||     ||     ||     ||H3 M6|
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

**************** It's Hero 2-- Sehanine_Moonbow's turn: ******************
[T] Attack    [S] Use Spells   [P] Use Potions
[A] Equip Armor  [W] Equip Weapon  [V] Move [O]Teleport [R] Recall [I] Hero Info [M] Monster Info
Choose an action:t
 Do you want to hold the weapon buy two hands: [N/Y]
y
Sehanine_Moonbow attacks Casper
Casper successfully dodges
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||   M5||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
|     ||     ||     ||H1   ||H2 M2||     ||     ||     |
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||     ||     ||     ||     ||     ||     ||H3 M6|
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

**************** It's Hero 3-- Skoraeus_Stonebones's turn: ******************
[T] Attack    [S] Use Spells   [P] Use Potions
[A] Equip Armor  [W] Equip Weapon  [V] Move [O]Teleport [R] Recall [I] Hero Info [M] Monster Info
Choose an action:t
Skoraeus_Stonebones attacks Natsunomeryu
Natsunomeryu successfully dodges
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||   M5||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
|     ||     ||     ||H1   ||H2 M2||     ||     ||     |
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||     ||     ||     ||     ||     ||     ||H3 M6|
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

*****************It's Monster 2 -- Casper Turn: *********************
The monster attacks!
Casper attacks Sehanine_Moonbow 10 damage!
Sehanine_Moonbow has 190 HP.
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||   M5||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
|     ||     ||     ||H1   ||H2 M2||     ||     ||     |
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||     ||     ||     ||     ||     ||     ||H3 M6|
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

*****************It's Monster 5 -- BigBad-Wolf Turn: *********************
There's another monster ahead
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||   M5||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
|     ||     ||     ||H1   ||H2 M2||     ||     ||     |
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||     ||     ||     ||     ||     ||     ||H3 M6|
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

*****************It's Monster 6 -- Natsunomeryu Turn: *********************
The monster attacks!
Natsunomeryu attacks Skoraeus_Stonebones 0 damage!
Skoraeus_Stonebones has 200 HP.
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||   M5||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
|     ||     ||     ||H1   ||H2 M2||     ||     ||     |
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||     ||     ||     ||     ||     ||     ||H3 M6|
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

***********************************************
The round is over:
Reminder you can quit the game if you enter [Q] at any time.
All alive heroes get 10% HP and 10% mana!
Parzival's HP increases 20!
The hero has a HP limit which is 200, so its HP is 200 now!
Parzival's mana increases 26!
Sehanine_Moonbow's HP increases 19!
The hero has a HP limit which is 200, so its HP is 200 now!
Sehanine_Moonbow's mana increases 102!
Skoraeus_Stonebones's HP increases 20!
The hero has a HP limit which is 200, so its HP is 200 now!
Skoraeus_Stonebones's mana increases 85!
**************** It's Hero 1-- Parzival's turn: ******************
[T] Attack    [S] Use Spells   [P] Use Potions
[A] Equip Armor  [W] Equip Weapon  [V] Move [O]Teleport [R] Recall [I] Hero Info [M] Monster Info
Choose an action:o
Select a target hero number for teleportation:
0: Parzival
1: Sehanine_Moonbow
2: Skoraeus_Stonebones
0
Invalid selection. Teleportation cancelled.
Your action is inValid or you changed your mind, please choose a new action:
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||   M5||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
|     ||     ||     ||H1   ||H2 M2||     ||     ||     |
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||     ||     ||     ||     ||     ||     ||H3 M6|
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

**************** It's Hero 1-- Parzival's turn: ******************
[T] Attack    [S] Use Spells   [P] Use Potions
[A] Equip Armor  [W] Equip Weapon  [V] Move [O]Teleport [R] Recall [I] Hero Info [M] Monster Info
Choose an action:o
Select a target hero number for teleportation:
0: Parzival
1: Sehanine_Moonbow
2: Skoraeus_Stonebones
1
Cannot teleport within the same lane.
Teleportation failed.
Your action is inValid or you changed your mind, please choose a new action:
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||   M5||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
|     ||     ||     ||H1   ||H2 M2||     ||     ||     |
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||     ||     ||     ||     ||     ||     ||H3 M6|
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

**************** It's Hero 1-- Parzival's turn: ******************
[T] Attack    [S] Use Spells   [P] Use Potions
[A] Equip Armor  [W] Equip Weapon  [V] Move [O]Teleport [R] Recall [I] Hero Info [M] Monster Info
Choose an action:o
Select a target hero number for teleportation:
0: Parzival
1: Sehanine_Moonbow
2: Skoraeus_Stonebones
2
Parzival has teleported to a position near Skoraeus_Stonebones
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||   M5||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||H2 M2||     ||     ||     |
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||     ||     ||     ||     ||     ||H1   ||H3 M6|
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

**************** It's Hero 2-- Sehanine_Moonbow's turn: ******************
[T] Attack    [S] Use Spells   [P] Use Potions
[A] Equip Armor  [W] Equip Weapon  [V] Move [O]Teleport [R] Recall [I] Hero Info [M] Monster Info
Choose an action:t
 Do you want to hold the weapon buy two hands: [N/Y]
y
Sehanine_Moonbow attacks Casper
Casper successfully dodges
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||   M5||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||H2 M2||     ||     ||     |
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||     ||     ||     ||     ||     ||H1   ||H3 M6|
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

**************** It's Hero 3-- Skoraeus_Stonebones's turn: ******************
[T] Attack    [S] Use Spells   [P] Use Potions
[A] Equip Armor  [W] Equip Weapon  [V] Move [O]Teleport [R] Recall [I] Hero Info [M] Monster Info
Choose an action:t
Skoraeus_Stonebones attacks Natsunomeryu and take 53 damage!
Natsunomeryu has only 0 HP
Natsunomeryu dies.
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||   M5||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||H2 M2||     ||     ||     |
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||     ||     ||     ||     ||     ||H1   ||H3 M6|
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

*************************************************
In this round:
Monster Natsunomeryu dead.
A monster is dead in this round. All heroes can get $500 money and 2 experience!
*****************It's Monster 2 -- Casper Turn: *********************
The monster attacks!
Casper attacks Sehanine_Moonbow 10 damage!
Sehanine_Moonbow has 190 HP.
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||   M5||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||H2 M2||     ||     ||     |
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||     ||     ||     ||     ||     ||H1   ||H3   |
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

*****************It's Monster 5 -- BigBad-Wolf Turn: *********************
There's another monster ahead
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||   M5||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||H2 M2||     ||     ||     |
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||     ||     ||     ||     ||     ||H1   ||H3   |
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

***********************************************
The round is over:
Reminder you can quit the game if you enter [Q] at any time.
All alive heroes get 10% HP and 10% mana!
Parzival's HP increases 20!
The hero has a HP limit which is 200, so its HP is 200 now!
Parzival's mana increases 29!
Sehanine_Moonbow's HP increases 19!
The hero has a HP limit which is 200, so its HP is 200 now!
Sehanine_Moonbow's mana increases 112!
Skoraeus_Stonebones's HP increases 20!
The hero has a HP limit which is 200, so its HP is 200 now!
Skoraeus_Stonebones's mana increases 94!
**************** It's Hero 1-- Parzival's turn: ******************
[T] Attack    [S] Use Spells   [P] Use Potions
[A] Equip Armor  [W] Equip Weapon  [V] Move [O]Teleport [R] Recall [I] Hero Info [M] Monster Info
Choose an action:t
No monster is in your attack range.
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||   M5||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||H2 M2||     ||     ||     |
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||     ||     ||     ||     ||     ||H1   ||H3   |
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

**************** It's Hero 1-- Parzival's turn: ******************
[T] Attack    [S] Use Spells   [P] Use Potions
[A] Equip Armor  [W] Equip Weapon  [V] Move [O]Teleport [R] Recall [I] Hero Info [M] Monster Info
Choose an action:v
Please enter your movement direction [W/A/S/D]:
w
You left Bush Space， so the bonus in Bush Space is deducted.
Parzival left Bush Space!
Parzival's Dexterity increases 0!
Parzival's Dexterity is 772 now
You are at the Plain Space!
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||   M5||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||H2 M2||     ||H1   ||     |
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||     ||     ||     ||     ||     ||     ||H3   |
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

**************** It's Hero 2-- Sehanine_Moonbow's turn: ******************
[T] Attack    [S] Use Spells   [P] Use Potions
[A] Equip Armor  [W] Equip Weapon  [V] Move [O]Teleport [R] Recall [I] Hero Info [M] Monster Info
Choose an action:t
 Do you want to hold the weapon buy two hands: [N/Y]
y
Sehanine_Moonbow attacks Casper
Casper successfully dodges
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||   M5||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||H2 M2||     ||H1   ||     |
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||     ||     ||     ||     ||     ||     ||H3   |
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

**************** It's Hero 3-- Skoraeus_Stonebones's turn: ******************
[T] Attack    [S] Use Spells   [P] Use Potions
[A] Equip Armor  [W] Equip Weapon  [V] Move [O]Teleport [R] Recall [I] Hero Info [M] Monster Info
Choose an action:v
Please enter your movement direction [W/A/S/D]:
w
You left Koulou Space， so the bonus in Koulou Space is deducted.
Skoraeus_Stonebones left Koulou Space!
Skoraeus_Stonebones's Strength increases -65!
Skoraeus_Stonebones's strength is 724now
You are at the Plain Space!
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||   M5||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||H2 M2||     ||H1   ||H3   |
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

*****************It's Monster 2 -- Casper Turn: *********************
The monster attacks!
Casper attacks Sehanine_Moonbow 10 damage!
Sehanine_Moonbow has 190 HP.
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||   M5||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||H2 M2||     ||H1   ||H3   |
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

*****************It's Monster 5 -- BigBad-Wolf Turn: *********************
There's another monster ahead
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||   M5||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||H2 M2||     ||H1   ||H3   |
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

***********************************************
The round is over:
Reminder you can quit the game if you enter [Q] at any time.
All alive heroes get 10% HP and 10% mana!
Parzival's HP increases 20!
The hero has a HP limit which is 200, so its HP is 200 now!
Parzival's mana increases 32!
Sehanine_Moonbow's HP increases 19!
The hero has a HP limit which is 200, so its HP is 200 now!
Sehanine_Moonbow's mana increases 124!
Skoraeus_Stonebones's HP increases 20!
The hero has a HP limit which is 200, so its HP is 200 now!
Skoraeus_Stonebones's mana increases 103!
**************** It's Hero 1-- Parzival's turn: ******************
[T] Attack    [S] Use Spells   [P] Use Potions
[A] Equip Armor  [W] Equip Weapon  [V] Move [O]Teleport [R] Recall [I] Hero Info [M] Monster Info
Choose an action:m
   Name                 HP         level      damage     defense    dodge chance

1.    BigBad-Wolf          0          1          150        2          0.00
2.    Casper               21         1          100        1          0.50
3.    Natsunomeryu         0          1          100        2          0.10
4.    Casper               0          1          100        1          0.00
5.    BigBad-Wolf          100        1          150        2          0.15
6.    Natsunomeryu         0          1          100        2          0.10

**************** It's Hero 1-- Parzival's turn: ******************
[T] Attack    [S] Use Spells   [P] Use Potions
[A] Equip Armor  [W] Equip Weapon  [V] Move [O]Teleport [R] Recall [I] Hero Info [M] Monster Info
Choose an action:v
Please enter your movement direction [W/A/S/D]:
w
Parzival is at the Monster's Nexus! Congratulation!!
******************************************
Congratulations! Your party of Heroes wins!
Your game map:
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||   M5||     ||H1   ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||H2 M2||     ||     ||H3   |
 B-B-B  C-C-C  I-I-I  K-K-K  P-P-P  I-I-I  P-P-P  P-P-P
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  K-K-K  I-I-I  O-O-O  C-C-C  I-I-I  B-B-B  K-K-K
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  P-P-P  C-C-C  I-I-I  P-P-P  C-C-C
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  C-C-C  I-I-I  O-O-O  K-K-K  I-I-I  P-P-P  P-P-P
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
|     ||     ||     ||     ||     ||     ||     ||     |
 B-B-B  P-P-P  I-I-I  K-K-K  P-P-P  I-I-I  K-K-K  P-P-P
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
|     ||     ||     ||     ||     ||     ||     ||     |
 P-P-P  P-P-P  I-I-I  B-B-B  P-P-P  I-I-I  O-O-O  C-C-C
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N
|     ||     ||     ||     ||     ||     ||     ||     |
 N-N-N  N-N-N  I-I-I  N-N-N  N-N-N  I-I-I  N-N-N  N-N-N

***********************************************
The round is over:
Reminder you can quit the game if you enter [Q] at any time.
All alive heroes get 10% HP and 10% mana!
Parzival's HP increases 20!
The hero has a HP limit which is 200, so its HP is 200 now!
Parzival's mana increases 35!
Sehanine_Moonbow's HP increases 20!
The hero has a HP limit which is 200, so its HP is 200 now!
Sehanine_Moonbow's mana increases 136!
Skoraeus_Stonebones's HP increases 20!
The hero has a HP limit which is 200, so its HP is 200 now!
Skoraeus_Stonebones's mana increases 113!
******************************************
Game statistic:
Game over in 16 rounds.
There are 6 monsters spawned on the map.
Your party killed 4 monsters.
Your party respawned 0 heroes.
Your party's max level is 2.
Game End...
Quit...