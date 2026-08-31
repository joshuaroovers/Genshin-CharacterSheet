package GenshinCharacterSheet.SheetComponents.Features;

import GenshinCharacterSheet.SheetComponents.Actions.Action;

public class FeatureAction extends Feature{
    private final Action action;

    public FeatureAction(String name, String description, Action action) {
        super(name,description);
        this.action = action;
    }

    public Action getAction() {
        return action;
    }
}
