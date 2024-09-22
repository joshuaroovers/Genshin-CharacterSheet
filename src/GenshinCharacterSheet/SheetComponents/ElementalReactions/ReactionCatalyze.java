package GenshinCharacterSheet.SheetComponents.ElementalReactions;

import GenshinCharacterSheet.SheetComponents.Elements.Dendro;
import GenshinCharacterSheet.SheetComponents.Elements.Electro;
import GenshinCharacterSheet.SheetComponents.Elements.Element;

public class ReactionCatalyze extends Reaction {

    public ReactionCatalyze() {
        Element element1 = new Dendro();

        this.element1 = element1;
        this.element2 = new Electro();
        this.color = element1.getColor();
        this.colorHex = element1.getColorHex();

        this.description = "Applies the Quickened Condition";
    }
}
