package SheetComponents.ElementalReactions;

import SheetComponents.Elements.Cryo;
import SheetComponents.Elements.Electro;
import SheetComponents.Elements.Element;
import SheetComponents.Elements.Pyro;

public class ReactionSuperConduct extends Reaction{

    public ReactionSuperConduct() {
        this.element1 = new Cryo();
        this.element2 = new Electro();
    }
    @Override
    public String getName() {
        return "Super-Conduct";
    }
}
