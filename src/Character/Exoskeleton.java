package Character;
public class Exoskeleton extends Monster implements MonsterCharacter{

    Exoskeleton(String name, int level, int damage, int defense, int dodgeChance) {
        super(name, level, damage, defense, dodgeChance);
    }
    @Override
    public String toString() {
        return "Exoskeleton{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", damage=" + damage +
                ", defense=" + defense +
                ", dodge chance=" + dodgeChance +
                '}';
    }

}
