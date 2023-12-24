package Character;



public class Paladin extends Hero implements HeroCharacter{
    Paladin(String name, int mana, int str, int agi, int dex, int money, int exp) {
        super(name, mana, str, agi, dex, money, exp);
        this.setSkillStrategy(new PaladinSkillStrategy());
    }


//    public void skillIncrease() {
//        super.strengthIncrease();
//        super.agilityIncrease();
//        super.dexterityIncrease();
//        super.strengthIncrease();
//        super.dexterityIncrease();
//
//    }

//    @Override
//    public String toString() {
//        return "Paladins name= " + name +
//                ", mana=" + mana +
//                ", strength=" + strength +
//                ", agility=" + agility +
//                ", dexterity=" + dexterity +
//                ", money=" + money +
//                ", experience=" + experience;
//    }

}
