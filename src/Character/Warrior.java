package Character;
public class Warrior extends Hero implements HeroCharacter{
    Warrior(String name, int mana, int str, int agi, int dex, int money, int exp) {
        super(name, mana, str, agi, dex, money, exp);
        this.setSkillStrategy(new WarriorSkillStrategy());
    }


//    public void skillIncrease() {
//        super.strengthIncrease();
//        super.agilityIncrease();
//        super.agilityIncrease();
//        super.strengthIncrease();
//        super.dexterityIncrease();
//
//    }

//    @Override
//    public String toString() {
//        return "Warrior name= " + name + '\'' +
//                ", mana=" + mana +
//                ", strength=" + strength +
//                ", agility=" + agility +
//                ", dexterity=" + dexterity +
//                ", money=" + money +
//                ", experience=" + experience ;
//    }

}
