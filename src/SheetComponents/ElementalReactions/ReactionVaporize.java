package SheetComponents.ElementalReactions;

import SheetComponents.Elements.Element;
import SheetComponents.Elements.Hydro;
import SheetComponents.Elements.Pyro;

public class ReactionVaporize extends Reaction{

    public ReactionVaporize() {
        this.element1 = new Hydro();
        this.element2 = new Pyro();
    }
}
