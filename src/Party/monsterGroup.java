package Party;
import Character.Monster;
import Character.MonsterFactory;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class monsterGroup {
    private List<Monster> allMonsters = new ArrayList<Monster>();
    private Party party = new Party();
    private int groupSize = 3;
    private ArrayList<Monster> monsterGroup ;
    private MonsterFactory mf = new MonsterFactory();
    public monsterGroup(Party p) throws FileNotFoundException {
        //allMonsters = MonsterFactory.getAllMonsters();
        party = p;

    }
    public ArrayList<Monster> getMonsterList(){

        return monsterGroup;
    }

    public void createGroup(int index) throws FileNotFoundException {
        allMonsters = mf.getAllMonsters();
        mf = new MonsterFactory();
        monsterGroup = new ArrayList<Monster>();

        int maxLevel = party.getMaxLevel();
        for (Monster m : allMonsters) {
            if (m.getLevel() == maxLevel) {
                monsterGroup.add(m);
            }
        }


        Collections.shuffle(monsterGroup);

        if (groupSize < monsterGroup.size()) {
            monsterGroup.subList(groupSize, monsterGroup.size()).clear();
        }

        for (Monster m : monsterGroup) {
            m.setMarker(index);
            m.setStartPosition(index);
            index++;
        }
        System.out.println("*************************************************");
        System.out.println("Three monsters spawn in the monsters’ Nexus： ");
        printMonsterGroupSituation();


    }
    public void printMonsterGroupSituation() {

        String title = String.format("   %-20s %-10s %-10s %-10s %-10s %-10s\n",
                "Name", "HP", "level", "damage", "defense", "dodge chance");
        System.out.println(title);

        int number = 1;
        for (Monster mon : monsterGroup) {

            System.out.println(number + ". " + mon.printMonster());
            number++;
        }
        System.out.println();


    }
    public int size(){

        return monsterGroup.size();
    }

    public Monster getMonster(int index) {
        return monsterGroup.get(index);
    }

}
