package Character;

public class PaladinSkillStrategy implements SkillStrategy {
    @Override
    public void skillIncrease(Hero h) {
        h.strengthIncrease();
        h.agilityIncrease();
        h.dexterityIncrease();
        h.strengthIncrease();
        h.dexterityIncrease();

    }
}
