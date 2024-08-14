package SheetComponents.ElementalReactions;

import SheetComponents.Elements.Cryo;
import SheetComponents.Elements.Electro;
import javafx.scene.paint.Color;

public class ReactionSuperConduct extends Reaction{

    public ReactionSuperConduct() {
        this.element1 = new Cryo();
        this.element2 = new Electro();

        String color = "#B4B2FF";
        this.color = Color.valueOf(color);
        this.colorHex = color;
    }
    @Override
    public String getName() {
        return "Super Conduct";
    }
}
