package Character;
public class Sorcerer extends Hero implements HeroCharacter{
    Sorcerer(String name, int mana, int str, int agi, int dex, int money, int exp) {
        super(name, mana, str, agi, dex, money, exp);
        this.setSkillStrategy(new SorcererSkillStrategy());
    }


//    public void skillIncrease() {
//        super.strengthIncrease();
//        super.agilityIncrease();
//        super.agilityIncrease();
//        super.dexterityIncrease();
//        super.dexterityIncrease();
//
//    }

//    @Override
//    public String toString() {
//        return "Sorcerer name=" + name + '\'' +
//                ", mana=" + mana +
//                ", strength=" + strength +
//                ", agility=" + agility +
//                ", dexterity=" + dexterity +
//                ", money=" + money +
//                ", experience=" + experience
//                ;
//    }
}
