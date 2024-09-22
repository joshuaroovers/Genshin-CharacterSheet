package GenshinCharacterSheet.SheetComponents.Elements;

import javafx.scene.paint.Color;

public class Hydro extends Element{

    public static final String COLOR = "#00C0FF";

    public Hydro() {
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
