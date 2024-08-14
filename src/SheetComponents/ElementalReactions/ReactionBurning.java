package SheetComponents.ElementalReactions;

import SheetComponents.Elements.Dendro;
import SheetComponents.Elements.Element;
import SheetComponents.Elements.Pyro;

public class ReactionBurning extends Reaction{


    public ReactionBurning() {
        Element element1 = new Pyro();

        this.element1 = element1;
        this.element2 = new Dendro();
        this.color = element1.getColor();
        this.colorHex = element1.getColorHex();

        this.description = "Applies the Burning condition";
    }
}
