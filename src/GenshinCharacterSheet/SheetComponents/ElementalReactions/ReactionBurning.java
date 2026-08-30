package GenshinCharacterSheet.SheetComponents.ElementalReactions;

import GenshinCharacterSheet.SheetComponents.Elements.Element;
import GenshinCharacterSheet.SheetComponents.Elements.Elements;

public class ReactionBurning extends Reaction{


    public ReactionBurning() {
        Element element1 = Elements.PYRO;

        this.element1 = element1;
        this.element2 = Elements.DENDRO;
        this.color = element1.getColor();
        this.colorHex = element1.getColorHex();

        this.description = "Applies the Burning condition";
    }
}
