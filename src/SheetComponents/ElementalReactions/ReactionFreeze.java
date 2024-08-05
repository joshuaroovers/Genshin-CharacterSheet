package SheetComponents.ElementalReactions;

import SheetComponents.Elements.Cryo;
import SheetComponents.Elements.Electro;
import SheetComponents.Elements.Element;
import SheetComponents.Elements.Hydro;

public class ReactionFreeze extends Reaction{

    public ReactionFreeze() {
        this.element1 = new Cryo();
        this.element2 = new Hydro();
    }
}
