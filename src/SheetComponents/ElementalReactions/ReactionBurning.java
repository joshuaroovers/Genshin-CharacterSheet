package SheetComponents.ElementalReactions;

import SheetComponents.Elements.Dendro;
import SheetComponents.Elements.Element;
import SheetComponents.Elements.Pyro;

public class ReactionBurning extends Reaction{


    public ReactionBurning() {
        this.element1 = new Dendro();
        this.element2 = new Pyro();
    }
}
