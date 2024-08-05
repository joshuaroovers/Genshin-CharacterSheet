package SheetComponents.ElementalReactions;

import SheetComponents.Elements.Electro;
import SheetComponents.Elements.Element;
import SheetComponents.Elements.Hydro;

public class ReactionElectroCharged extends Reaction{

    public ReactionElectroCharged() {
        this.element1 = new Hydro();
        this.element2 = new Electro();
    }

    @Override
    public String getName() {
        return "Electro-Charged";
    }
}
