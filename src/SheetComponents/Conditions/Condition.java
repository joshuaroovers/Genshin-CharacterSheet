package SheetComponents.Conditions;

import SheetComponents.ElementalReactions.Reaction;
import SheetComponents.Elements.Element;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Condition implements Comparable<Condition>{

    private static final ArrayList<Condition> allConditions = new ArrayList<Condition>(Arrays.asList(
            new ConditionBurning(),new ConditionFrozen(), new ConditionQuickened(), new ConditionSuperConductor()
            ));
    public static ArrayList<Condition> getAllConditions(){
        return allConditions;
    }

    String description;

    public String getName(){
        int baseClassNameLength = Condition.class.getSimpleName().length();
        return getClass().getSimpleName().substring(baseClassNameLength);
    }

    public String getDescription() {
        return description;
    }

    @Override
    public int compareTo(Condition o) {
        return this.getName().compareTo(o.getName());
    }

}
