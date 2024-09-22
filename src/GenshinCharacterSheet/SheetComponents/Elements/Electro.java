package GenshinCharacterSheet.SheetComponents.Elements;

import javafx.scene.paint.Color;

public class Electro extends Element{

    public static final String COLOR = "#CC80FF";

    public Electro() {
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
