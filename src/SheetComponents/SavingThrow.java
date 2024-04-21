package SheetComponents;

public class SavingThrow {
    private boolean proficient;
    private PrimaryStat stat;

    public SavingThrow(PrimaryStat stat, boolean proficient) {
        this.proficient = proficient;
        this.stat = stat;
    }

    public boolean isProficient() {
        return proficient;
    }

    public PrimaryStat getStat() {
        return stat;
    }
}
