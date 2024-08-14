package SheetComponents.ElementalReactions;

import SheetComponents.Elements.Electro;
import SheetComponents.Elements.Element;
import SheetComponents.Elements.Hydro;

public class ReactionElectroCharged extends Reaction{

    public ReactionElectroCharged() {
        Element element1 = new Electro();

        this.element1 = element1;
        this.element2 = new Hydro();
        this.color = element1.getColor();
        this.colorHex = element1.getColorHex();
    }

    @Override
    public String getName() {
        return "Electro-Charged";
    }
}
