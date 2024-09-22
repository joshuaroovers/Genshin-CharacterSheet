package GenshinCharacterSheet.SheetComponents.Elements;

import javafx.scene.paint.Color;

public class Cryo extends Element{

    public static final String COLOR = "#7AF2F2";

    public Cryo() {
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
