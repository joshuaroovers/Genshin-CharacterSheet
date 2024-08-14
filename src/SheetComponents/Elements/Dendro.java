package SheetComponents.Elements;

import javafx.scene.paint.Color;

public class Dendro extends Element{

    public static final String COLOR = "#9BE53D";

    public Dendro() {
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
