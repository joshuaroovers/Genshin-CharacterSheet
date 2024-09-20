package SheetComponents.Actions;

import SheetComponents.Elements.Element;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Action {

    private static ArrayList<Action> standardActions;
    public enum actionType {ATTACK, ACTION, BONUS, REACTION}
    protected actionType type;
    protected String description;

    static{
        standardActions = new ArrayList<>();
        standardActions.add(new ActionDash());
        standardActions.add(new ActionDodge());
    }

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

    public static ArrayList<Action> getStandardActions(Element element) {
        ArrayList<Action> actions = new ArrayList<>(standardActions);
        actions.add(new ActionMinorElementManipulation(element));
        return actions;
    }
}
