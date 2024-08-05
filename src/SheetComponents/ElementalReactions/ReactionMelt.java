package SheetComponents.ElementalReactions;

import SheetComponents.Elements.Cryo;
import SheetComponents.Elements.Element;
import SheetComponents.Elements.Pyro;

public class ReactionMelt extends Reaction{

    public ReactionMelt() {
        this.element1 = new Cryo();
        this.element2 = new Pyro();
    }
}
