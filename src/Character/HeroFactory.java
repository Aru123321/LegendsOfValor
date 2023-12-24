package Character;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import InputAndReader.txtReader;


public class HeroFactory implements HeroFactoryCreator{
    private static txtReader txt = new txtReader();


    private static ArrayList<Warrior> WarriorsList = new ArrayList<Warrior>();
    private static ArrayList<Paladin> PaladinsList = new ArrayList<Paladin>();
    private static ArrayList<Sorcerer> SorcererList = new ArrayList<Sorcerer>();



    public Hero createHero(String heroLine, String HeroType){
        String HeroStat[] = heroLine.split("\\s+");
        String name = HeroStat[0];
        int mana = Integer.parseInt(HeroStat[1]);
        int strength = Integer.parseInt(HeroStat[2]);
        int agility = Integer.parseInt(HeroStat[3]);
        int dexterity = Integer.parseInt(HeroStat[4]);
        int money = Integer.parseInt(HeroStat[5]);
        int experience = Integer.parseInt(HeroStat[6]);


        if(HeroType.equals("Warriors")){
            return new Warrior(name, mana, strength, agility, dexterity, money, experience);
        }
        else if(HeroType.equals("Sorcerers")){
            return new Sorcerer(name, mana, strength, agility, dexterity, money, experience);
        }
        else if(HeroType.equals("Paladins")){
            return new Paladin(name, mana, strength, agility, dexterity, money, experience);
        }
        return null;
    }
    public Hero getHero(Scanner sc, String heroType) {
        if (sc.hasNext()) {
            String heroLine = sc.nextLine();
            return createHero(heroLine, heroType);
        } else {
            return null;
        }
    }


    public void initialHeroList() throws FileNotFoundException {
        ArrayList<String> threeTypes = new ArrayList<>(Arrays.asList("Warriors", "Sorcerers", "Paladins"));
        txtReader reader = new txtReader();

        for (int i = 0; i < threeTypes.size(); i++) {
            String type = threeTypes.get(i);
            Scanner sc = reader.openFile(type + ".txt");
            while (sc.hasNext()) {
                Hero hero = getHero(sc, type);
                if(hero == null) {
                    break;
                }
                if(i == 0){
                    WarriorsList.add((Warrior)hero);
                }
                if(i == 1){
                    SorcererList.add((Sorcerer)hero);
                }
                if(i == 2){
                    PaladinsList.add((Paladin)hero);
                }
            }
            sc.close();
        }
    }



    public ArrayList getWarriorsList() {
        return WarriorsList;
    }
    public ArrayList getSorcererList() {
        return SorcererList;
    }
    public ArrayList getPaladinsList() {
        return PaladinsList;
    }

    public void showHeroList() throws FileNotFoundException {
        initialHeroList();

        // Title format string used by all hero types
        String title = String.format("   %-20s %-10s %-10s %-10s %-10s %-10s %-10s %-13s %-13s\n",
                "Name", "HP","Level","Mana", "Strength", "Agility", "Dexterity", "Starting Money", "Starting Experience");

        System.out.println("List of Heroes:\n");
        printHeroTypeList("Warriors:", title, WarriorsList);


        printHeroTypeList("Sorcerers:", title, SorcererList);


        printHeroTypeList("Paladins:", title, PaladinsList);
    }


    // Helper method to print each hero type list
    private void printHeroTypeList(String heroTypeName, String title, ArrayList<? extends Hero> heroList) {
        System.out.println(heroTypeName);
        System.out.println(title);
        int number = 1;
        for (Hero hero : heroList) {
            System.out.println(number + ". " + hero.toString());
            number++;
        }
        System.out.println();
    }




    /*
    public static void main(String[] args) throws FileNotFoundException {
        HeroFactory m = new HeroFactory();
        m.showHeroList();
    }
*/

}
