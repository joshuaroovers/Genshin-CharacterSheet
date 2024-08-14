package SheetComponents.ElementalReactions;

import SheetComponents.Elements.Cryo;
import SheetComponents.Elements.Pyro;
import javafx.scene.paint.Color;

public class ReactionMelt extends Reaction{

    public ReactionMelt() {
        this.element1 = new Cryo();
        this.element2 = new Pyro();
        String color = "#FFCC68";
        this.color = Color.valueOf(color);
        this.colorHex = color;
    }
}
