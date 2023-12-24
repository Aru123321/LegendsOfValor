package Party;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import InputAndReader.InputValidator;

import Character.Hero;

import Character.HeroFactory;


public class Party {
    private ArrayList<Hero> party = new ArrayList<Hero>();
    InputValidator validator = new InputValidator();
    ArrayList<Hero> WarriorsList;
    ArrayList<Hero> SorcerersList;
    ArrayList<Hero> PaladinsList;
    private int numEachType = 6;
    private int maxLevel = 1;
    private int moneyfactor = 200;
    private int numValorHero = 3;
    HeroFactory hf;


    public Party() {
        hf = new HeroFactory();
        WarriorsList = hf.getWarriorsList();
        SorcerersList = hf.getSorcererList();
        PaladinsList = hf.getPaladinsList();

    }

    public void addDeadPool(ArrayList<Hero> FaintHero) {
        party.addAll(FaintHero);

    }

    public int getMaxLevel() {
        for (int i = 0; i < party.size(); i++) {
            if (party.get(i).getLevel() > maxLevel) {
                maxLevel = party.get(i).getLevel();
            }
        }
        return maxLevel;
    }

    public void createValorParty() throws FileNotFoundException {
        System.out.print("Please select 3 heroes in your party: ");
        hf.showHeroList();
        System.out.println("You will need to select " + numValorHero + " heroes!");
        for (int i = 0; i < numValorHero; ) {
            System.out.println("Please enter one hero type you want to join your party (Warrior: w/ Sorcerer: s/ Paladin: p): ");
            char type = validator.checkHeroTypeInput();
            System.out.println("Please enter his/her ID number: ");
            int numID = validator.promptPositiveInteger();
            while (numID > numEachType) {
                System.out.print("Invalid ID number. The ID number should be less than " + numEachType + ": ");
                numID = validator.promptPositiveInteger();
            }

            Hero h = findHero(type, numID);
            if (isInList(h)) {
                System.out.println("This hero cannot join your party, because he/she is already in your party.");
            } else {
                addHero(h);

                System.out.println(h.getName() + " successfully join your party! ");
                h.setMarker(i);
                h.setStartPosition(i);
                i++;
            }

        }


        System.out.println("Your party have assembled： ");
        printPartySituation();
    }

    public void createParty() throws FileNotFoundException {
        System.out.print("How many Heroes will be in your party (limit is 3): ");
        int numHero = validator.promptPositiveInteger();
        while (numHero > 3) {
            System.out.print("The number of Heroes should be less than 3: ");
            numHero = validator.promptPositiveInteger();
        }

        hf.showHeroList();
        System.out.println("You will need to select " + numHero + " heroes!");
        for (int i = 0; i < numHero; ) {
            System.out.println("Please enter one hero type you want to join your party (Warrior: w/ Sorcerer: s/ Paladin: p): ");
            char type = validator.checkHeroTypeInput();
            System.out.println("Please enter his/her ID number: ");
            int numID = validator.promptPositiveInteger();
            while (numID > numEachType) {
                System.out.print("Invalid ID number. The ID number should be less than " + numEachType + ": ");
                numID = validator.promptPositiveInteger();
            }

            Hero h = findHero(type, numID);
            if (isInList(h)) {
                System.out.println("This hero cannot join your party, because he/she is already in your party.");
            } else {
                addHero(h);
                System.out.println(h.getName() + " successfully join your party! ");
                h.setMarker(i);
                i++;
            }

        }

        System.out.println("Your party have assembled： ");
        printPartySituation();
    }

    public Hero getHero(int index) {
        return party.get(index);
    }

    public int size() {
        return party.size();
    }

    public void winBattleBenefit(int level) {

        for (Hero h : party) {
            h.heroAddMoney(level * moneyfactor);
            h.heroAddExp(level);
            System.out.println(h.getName() + " gains $" + level * moneyfactor + " and " + level + " exprience. ");
        }
    }

    public void levelUpHPMANA() {

        for (Hero h : party) {
            int previousL = h.getLevel();
            h.levelUp();
            int nowL = h.getLevel();
            if (nowL>previousL){
                System.out.println("Congratulations!" + h.getName()+" has leveled up! His level is " + nowL+"!");
                System.out.println("His skills increase! HP and Mana increase!");

                h.setHP();
            }


        }
    }


    public void gainHPMANA() {
        System.out.println("Your party wins the game, so heroes' HP and MANA will increase! ");
        for (Hero h : party) {
            h.regainRound();

        }
    }

    public void printPartySituation() {

        String title = String.format("   %-20s %-10s %-10s %-10s %-10s %-10s %-10s %-13s %-13s\n",
                "Name", "HP", "Level", "Mana", "Strength", "Agility", "Dexterity", "Money", "Experience");
        System.out.println(title);
        int i = 1;

        for (Hero hero : party) {

            System.out.println(i + ". " + hero.toString());
            i++;
        }

    }


    public void addHero(Hero h) {

        party.add(h);
    }

    public Hero findHero(char type, int numID) {
        if (type == 'W') {
            return WarriorsList.get(numID - 1);
        }
        if (type == 'S') {
            return SorcerersList.get(numID - 1);
        }
        if (type == 'P') {
            return PaladinsList.get(numID - 1);
        }
        return null;

    }

    public boolean isInList(Hero h) {

        for (int i = 0; i < party.size(); i++) {
            if (party.get(i).getName().equals(h.getName())) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Hero> getHeroList() {

        return party;
    }

    public void remove(int index) {
        party.remove(index);
    }

    public int indexOf(Hero hero) {
        for (Hero h : party) {
            if (h.equals(hero)) {
                return hero.getHeroNum();
            }
        }
        return -1;
    }


}
