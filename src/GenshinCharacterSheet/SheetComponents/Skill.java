package GenshinCharacterSheet.SheetComponents;

public class Skill {
    private String name;
    private PrimaryStats stat;

    public Skill(String name, PrimaryStats stat) {
        this.name = name;
        this.stat = stat;
    }

    public String getName() {
        return name;
    }
    public PrimaryStats getStat() {
        return stat;
    }
}
