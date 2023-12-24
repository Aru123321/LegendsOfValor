package Character;

public class SorcererSkillStrategy implements SkillStrategy {
    @Override
    public void skillIncrease(Hero h) {
        h.strengthIncrease();
        h.agilityIncrease();
        h.agilityIncrease();
        h.dexterityIncrease();
        h.dexterityIncrease();

    }
}
