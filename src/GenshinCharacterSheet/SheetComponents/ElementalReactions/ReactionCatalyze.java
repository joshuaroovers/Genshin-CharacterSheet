package GenshinCharacterSheet.SheetComponents.ElementalReactions;

import GenshinCharacterSheet.SheetComponents.Elements.Element;
import GenshinCharacterSheet.SheetComponents.Elements.Elements;

public class ReactionCatalyze extends Reaction {

    public ReactionCatalyze() {
        Element element1 = Elements.DENDRO;

        this.element1 = element1;
        this.element2 = Elements.ELECTRO;
        this.color = element1.getColor();
        this.colorHex = element1.getColorHex();

        this.description = "Applies the Quickened Condition";
    }
}
