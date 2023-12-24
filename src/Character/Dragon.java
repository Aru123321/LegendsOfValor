package Character;
public class Dragon extends Monster implements MonsterCharacter{

    Dragon(String name, int level, int damage, int defense, int dodgeChance) {
        super(name, level, damage, defense, dodgeChance);
    }
    @Override
    public String toString() {
        return "Dragon{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", damage=" + damage +
                ", defense=" + defense +
                ", dodge chance=" + dodgeChance +
                '}';
    }

}
