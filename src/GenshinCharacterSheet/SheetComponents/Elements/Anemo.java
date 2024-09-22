package GenshinCharacterSheet.SheetComponents.Elements;

import javafx.scene.paint.Color;

public class Anemo extends Element{

    public static final String COLOR = "#33D7A0";

    public Anemo() {
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
