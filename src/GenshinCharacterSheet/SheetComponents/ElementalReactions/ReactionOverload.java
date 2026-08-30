package GenshinCharacterSheet.SheetComponents.ElementalReactions;

import GenshinCharacterSheet.SheetComponents.Elements.Elements;
import javafx.scene.paint.Color;

public class ReactionOverload extends Reaction{

    public ReactionOverload() {
        this.element1 = Elements.PYRO;
        this.element2 = Elements.ELECTRO;

        String color = "#FF7F9C";
        this.color = Color.valueOf(color);
        this.colorHex = color;

        this.description = "Causes an AOE dealing pyro damage and can knock weak enemies prone";
    }
}
