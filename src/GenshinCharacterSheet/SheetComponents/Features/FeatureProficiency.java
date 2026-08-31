package GenshinCharacterSheet.SheetComponents.Features;

import GenshinCharacterSheet.SheetComponents.Skill;

public class FeatureProficiency extends Feature{
    private final Skill skill;

    public FeatureProficiency(String name, String description, Skill skill) {
        super(name, description);
        this.skill = skill;
    }

    public Skill getSkill() {
        return skill;
    }
}
