package GenshinCharacterSheet.SheetComponents.ElementalReactions;

import GenshinCharacterSheet.SheetComponents.Elements.Electro;
import GenshinCharacterSheet.SheetComponents.Elements.Element;
import GenshinCharacterSheet.SheetComponents.Elements.Hydro;

public class ReactionElectroCharged extends Reaction{

    public ReactionElectroCharged() {
        Element element1 = new Electro();

        this.element1 = element1;
        this.element2 = new Hydro();
        this.color = element1.getColor();
        this.colorHex = element1.getColorHex();

        this.description = "Deals extra Electro damage and at the end of the next turn the affected creature and anyone affected by Hydro will take this damage again.";
    }

    @Override
    public String getName() {
        return "Electro Charged";
    }
}
