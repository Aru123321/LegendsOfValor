
package Character;
public class Spirit extends Monster implements MonsterCharacter{

    Spirit(String name, int level, int damage, int defense, int dodgeChance) {
        super(name, level, damage, defense, dodgeChance);
    }
    @Override
    public String toString() {
        return "Spirit{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", damage=" + damage +
                ", defense=" + defense +
                ", dodge chance=" + dodgeChance +
                '}';
    }

}
