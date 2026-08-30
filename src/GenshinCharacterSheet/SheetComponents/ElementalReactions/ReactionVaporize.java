package GenshinCharacterSheet.SheetComponents.ElementalReactions;

import GenshinCharacterSheet.SheetComponents.Elements.Elements;
import javafx.scene.paint.Color;

public class ReactionVaporize extends Reaction{

    public ReactionVaporize() {
        this.element1 = Elements.HYDRO;
        this.element2 = Elements.PYRO;
        String color = "#FFCC68";
        this.color = Color.valueOf(color);
        this.colorHex = color;

        this.description = "The triggering Elemental damage adds another die to count towards the total damage";
    }
}
