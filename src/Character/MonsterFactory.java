package Character;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import InputAndReader.txtReader;




public class MonsterFactory implements MonsterFactoryCreator{
    private static txtReader txt= new txtReader();
    private static List<Monster> MonsterList;


    public List<Monster> getAllMonsters() throws FileNotFoundException {
        initialMonsterList();
        return MonsterList;
    }
     public Monster createMonster(String Line, String Type){
        String MonStat[] = Line.split("\\s+");
        String name = MonStat[0];
        int level = Integer.parseInt(MonStat[1]);
        int damage = Integer.parseInt(MonStat[2]);
        int defense = Integer.parseInt(MonStat[3]);
        int dodgeChance = Integer.parseInt(MonStat[4]);



        if(Type.equals("Dragons")){
            return new Dragon(name, level, damage, defense, dodgeChance);
        }
        else if(Type.equals("Exoskeletons")){
            return new Exoskeleton(name, level, damage, defense, dodgeChance);
        }
        else if(Type.equals("Spirits")){
            return new Spirit(name, level, damage, defense, dodgeChance);
        }
        return null;
    }

    public  Monster getMonster(Scanner sc, String Type) {
        if (sc.hasNext()) {
            String Line = sc.nextLine();
            return createMonster(Line, Type);
        } else {
            return null;
        }
    }
     public void initialMonsterList() throws FileNotFoundException {
        MonsterList= new ArrayList<Monster>();
        ArrayList<String> threeTypes = new ArrayList<String>(Arrays.asList("Dragons", "Exoskeletons", "Spirits"));
        txtReader reader = new txtReader();

        for (int i = 0; i < threeTypes.size(); i++) {
            String type = threeTypes.get(i);
            Scanner sc = reader.openFile(type + ".txt");
            while (sc.hasNext()) {
                Monster mon = getMonster(sc, type);
                if (mon == null) {
                    break;
                }
                MonsterList.add(mon);
            }
            sc.close();
        }

    }

     public void showMonsterList() throws FileNotFoundException {
       initialMonsterList();

        System.out.println("List of Monsters:");
        for (Monster mon : MonsterList) {
            System.out.println(mon.toString());
        }
    }
/*
    public static void main(String[] args) throws FileNotFoundException {
        MonsterFactory m = new MonsterFactory();
        m.showMonsterList();
    }
*/
}
