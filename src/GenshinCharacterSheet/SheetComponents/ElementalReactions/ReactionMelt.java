package GenshinCharacterSheet.SheetComponents.ElementalReactions;

import GenshinCharacterSheet.SheetComponents.Elements.Elements;
import javafx.scene.paint.Color;

public class ReactionMelt extends Reaction{

    public ReactionMelt() {
        this.element1 = Elements.CRYO;
        this.element2 = Elements.PYRO;
        String color = "#FFCC68";
        this.color = Color.valueOf(color);
        this.colorHex = color;

        this.description = "The triggering Elemental damage adds another die to count towards the total damage";
    }
}
