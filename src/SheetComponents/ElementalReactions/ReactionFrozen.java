package SheetComponents.ElementalReactions;

import SheetComponents.Elements.Cryo;
import SheetComponents.Elements.Element;
import SheetComponents.Elements.Hydro;

public class ReactionFrozen extends Reaction{

    public ReactionFrozen() {
        Element element1 = new Cryo();

        this.element1 = element1;
        this.element2 = new Hydro();
        this.color = element1.getColor();
        this.colorHex = element1.getColorHex();

        this.description = "Applies the Frozen Condition";
    }
}
