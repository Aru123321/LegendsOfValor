package Character;

public class WarriorSkillStrategy implements SkillStrategy {
    @Override
    public void skillIncrease(Hero h) {
        // Implementation for warrior's skill gaining
        h.strengthIncrease();
        h.agilityIncrease();
        h.agilityIncrease();
        h.strengthIncrease();
        h.dexterityIncrease();
    }
}
