package SheetComponents.Elements;

import javafx.scene.paint.Color;

public class Geo extends Element{

    public static final String COLOR = "#FFB00D";

    public Geo() {
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
