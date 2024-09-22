package GenshinCharacterSheet.SheetComponents.ElementalReactions;

import GenshinCharacterSheet.SheetComponents.Elements.Dendro;
import GenshinCharacterSheet.SheetComponents.Elements.Element;
import GenshinCharacterSheet.SheetComponents.Elements.Hydro;

public class ReactionBloom extends Reaction{

    public ReactionBloom() {
        Element element1 = new Dendro();

        this.element1 = element1;
        this.element2 = new Hydro();
        this.color = element1.getColor();
        this.colorHex = element1.getColorHex();

        this.description = "Creates a Dendro-Core within 5ft of the affected creature";
    }
}
