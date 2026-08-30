package GenshinCharacterSheet.SheetComponents.ElementalReactions;

import GenshinCharacterSheet.SheetComponents.Elements.Element;
import GenshinCharacterSheet.SheetComponents.Elements.Elements;

public class ReactionBloom extends Reaction{

    public ReactionBloom() {
        Element element1 = Elements.DENDRO;

        this.element1 = element1;
        this.element2 = Elements.HYDRO;
        this.color = element1.getColor();
        this.colorHex = element1.getColorHex();

        this.description = "Creates a Dendro-Core within 5ft of the affected creature";
    }
}
