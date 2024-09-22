package GenshinCharacterSheet.SheetComponents.Conditions;

public class ConditionSuperConductor extends Condition{

    public ConditionSuperConductor() {
        this.description = "Makes affected creatures more vulnerable to physical damage";
    }

    @Override
    public String getName() {
        return "Superconductor";
    }
}
