package SheetComponents.ElementalReactions;

import SheetComponents.Elements.Dendro;
import SheetComponents.Elements.Element;
import SheetComponents.Elements.Hydro;
import SheetComponents.Elements.Pyro;

public class ReactionBloom extends Reaction{

    public ReactionBloom() {
        this.element1 = new Dendro();
        this.element2 = new Hydro();
    }
}
