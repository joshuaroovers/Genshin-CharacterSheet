package GenshinCharacterSheet.SheetComponents.Conditions;

import java.util.ArrayList;
import java.util.Arrays;

public class Conditions {
    public static final Condition BURNING = new ConditionBurning();
    public static final Condition QUICKENED = new ConditionQuickened();
    public static final Condition SUPERCONDUCTOR = new ConditionSuperConductor();
    public static final ArrayList<Condition> ALL = new ArrayList<>(
            Arrays.asList(
                    BURNING,
                    QUICKENED,
                    SUPERCONDUCTOR
    ));
}
