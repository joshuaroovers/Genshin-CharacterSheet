package GenshinCharacterSheet.SheetComponents.Features;

import GenshinCharacterSheet.SheetComponents.Actions.Action;

public class Feature {
    final String name;
    final String description;

    public Feature(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
