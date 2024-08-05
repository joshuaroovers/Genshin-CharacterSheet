package SheetComponents.ElementalReactions;

import SheetComponents.Elements.Dendro;
import SheetComponents.Elements.Electro;
import SheetComponents.Elements.Element;
import SheetComponents.Elements.Hydro;

public class ReactionCatalyze extends Reaction {

    public ReactionCatalyze() {
        this.element1 = new Dendro();
        this.element2 = new Electro();
    }
}
