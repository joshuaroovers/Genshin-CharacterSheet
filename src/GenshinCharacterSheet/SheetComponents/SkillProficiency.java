package GenshinCharacterSheet.SheetComponents;

public class SkillProficiency {
    private Skill skill;
    private boolean proficient;

    public SkillProficiency(Skill skill, boolean prof) {
        this.skill = skill;
        this.proficient = prof;
    }

    public String getName() {
        return skill.getName();
    }

    public boolean isProficient() {
        return proficient;
    }

    public PrimaryStats getStat() {
        return skill.getStat();
    }
}
