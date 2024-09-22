package GenshinCharacterSheet.SheetComponents.ElementalReactions;

import GenshinCharacterSheet.SheetComponents.Elements.Electro;
import GenshinCharacterSheet.SheetComponents.Elements.Pyro;
import javafx.scene.paint.Color;

public class ReactionOverload extends Reaction{

    public ReactionOverload() {
        this.element1 = new Pyro();
        this.element2 = new Electro();

        String color = "#FF7F9C";
        this.color = Color.valueOf(color);
        this.colorHex = color;

        this.description = "Causes an AOE dealing pyro damage and can knock weak enemies prone";
    }
}
