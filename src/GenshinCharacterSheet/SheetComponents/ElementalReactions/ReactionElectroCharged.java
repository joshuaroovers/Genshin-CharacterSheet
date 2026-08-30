package GenshinCharacterSheet.SheetComponents.ElementalReactions;

import GenshinCharacterSheet.SheetComponents.Elements.Element;
import GenshinCharacterSheet.SheetComponents.Elements.Elements;

public class ReactionElectroCharged extends Reaction{

    public ReactionElectroCharged() {
        Element element1 = Elements.ELECTRO;

        this.element1 = element1;
        this.element2 = Elements.HYDRO;
        this.color = element1.getColor();
        this.colorHex = element1.getColorHex();

        this.description = "Deals extra Electro damage and at the end of the next turn the affected creature and anyone affected by Hydro will take this damage again.";
    }

    @Override
    public String getName() {
        return "Electro Charged";
    }
}
