package GenshinCharacterSheet.SheetComponents.ElementalReactions;

import GenshinCharacterSheet.SheetComponents.Elements.Cryo;
import GenshinCharacterSheet.SheetComponents.Elements.Electro;
import javafx.scene.paint.Color;

public class ReactionSuperConduct extends Reaction{

    public ReactionSuperConduct() {
        this.element1 = new Cryo();
        this.element2 = new Electro();

        String color = "#B4B2FF";
        this.color = Color.valueOf(color);
        this.colorHex = color;

        this.description = "Causes an AOE dealing Cryo damage and applying the Superconductor Condition";
    }
    @Override
    public String getName() {
        return "Super Conduct";
    }
}
