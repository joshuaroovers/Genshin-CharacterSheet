package SheetComponents;

public class Skill {
    private String name;
    private boolean proficient;
    private PrimaryStat stat;

    public Skill(String name, PrimaryStat primaryStat, boolean prof) {
        this.name = name;
        this.stat = primaryStat;
        this.proficient = prof;
    }

    public String getName() {
        return name;
    }

    public boolean isProficient() {
        return proficient;
    }

    public PrimaryStat getStat() {
        return stat;
    }
}
