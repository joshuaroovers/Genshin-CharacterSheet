package GenshinCharacterSheet.SheetComponents.Actions;

import GenshinCharacterSheet.SheetComponents.Elements.Element;

import java.util.ArrayList;
import java.util.Arrays;

public class Actions {
    public static final Action DASH = new ActionDash();
    public static final Action DODGE = new ActionDodge();
    public static ArrayList<Action> STANDARD = new ArrayList<>(
            Arrays.asList(
                    DASH,
                    DODGE
            )
    );

    public static ArrayList<Action> getStandardActions(Element element) {
        ArrayList<Action> actions = new ArrayList<>(STANDARD);
        actions.add(new ActionMinorElementManipulation(element));
        return actions;
    }
}
