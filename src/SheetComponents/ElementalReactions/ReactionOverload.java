package SheetComponents.ElementalReactions;

import SheetComponents.Elements.Electro;
import SheetComponents.Elements.Element;
import SheetComponents.Elements.Pyro;

public class ReactionOverload extends Reaction{

    public ReactionOverload() {
        this.element1 = new Pyro();
        this.element2 = new Electro();
    }
}
