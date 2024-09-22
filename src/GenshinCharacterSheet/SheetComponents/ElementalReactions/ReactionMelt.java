package GenshinCharacterSheet.SheetComponents.ElementalReactions;

import GenshinCharacterSheet.SheetComponents.Elements.Cryo;
import GenshinCharacterSheet.SheetComponents.Elements.Pyro;
import javafx.scene.paint.Color;

public class ReactionMelt extends Reaction{

    public ReactionMelt() {
        this.element1 = new Cryo();
        this.element2 = new Pyro();
        String color = "#FFCC68";
        this.color = Color.valueOf(color);
        this.colorHex = color;

        this.description = "The triggering Elemental damage adds another die to count towards the total damage";
    }
}
