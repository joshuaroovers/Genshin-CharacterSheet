package SheetComponents.Elements;

import javafx.scene.paint.Color;

public class Physical extends Element{

    //I'd rather not have a "Physical" element but it's the simplest way to account for damage type in attacks
    //+ it's considered as an element in the fandom wiki!
    public static final String COLOR = "#FFFFFF";

    public Physical() {
        super(COLOR);
    }

    @Override
    Color getStaticColor() {
        return Color.valueOf(COLOR);
    }

    @Override
    String getStaticColorHex() {
        return COLOR;
    }
}
