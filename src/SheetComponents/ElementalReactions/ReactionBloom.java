package SheetComponents.ElementalReactions;

import SheetComponents.Elements.Dendro;
import SheetComponents.Elements.Element;
import SheetComponents.Elements.Hydro;

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
