package GenshinCharacterSheet.SheetComponents.Actions;

import GenshinCharacterSheet.SheetComponents.Elements.Element;

import java.util.ArrayList;

public class Action {
    public enum actionType {ATTACK, ACTION, BONUS, REACTION}
    protected actionType type;
    protected String description;

    public String getName() {
        int baseClassNameLength = Action.class.getSimpleName().length();
        return getClass().getSimpleName().substring(baseClassNameLength);
    }

    public String getDescription() {
        return description;
    }

    public actionType getType() {
        return type;
    }


}
