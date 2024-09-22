package GenshinCharacterSheet.SheetComponents.ElementalReactions;

import GenshinCharacterSheet.SheetComponents.Elements.Hydro;
import GenshinCharacterSheet.SheetComponents.Elements.Pyro;
import javafx.scene.paint.Color;

public class ReactionVaporize extends Reaction{

    public ReactionVaporize() {
        this.element1 = new Hydro();
        this.element2 = new Pyro();
        String color = "#FFCC68";
        this.color = Color.valueOf(color);
        this.colorHex = color;

        this.description = "The triggering Elemental damage adds another die to count towards the total damage";
    }
}
