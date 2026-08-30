package GenshinCharacterSheet.SheetComponents.ElementalReactions;

import GenshinCharacterSheet.SheetComponents.Elements.Element;
import GenshinCharacterSheet.SheetComponents.Elements.Elements;

public class ReactionFrozen extends Reaction{

    public ReactionFrozen() {
        Element element1 = Elements.CRYO;

        this.element1 = element1;
        this.element2 = Elements.HYDRO;
        this.color = element1.getColor();
        this.colorHex = element1.getColorHex();

        this.description = "Applies the Frozen Condition";
    }
}
