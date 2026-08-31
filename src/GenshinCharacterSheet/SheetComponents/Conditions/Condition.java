package GenshinCharacterSheet.SheetComponents.Conditions;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Condition implements Comparable<Condition>{

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
