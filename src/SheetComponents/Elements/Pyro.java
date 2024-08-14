package SheetComponents.Elements;

import javafx.scene.paint.Color;

public class Pyro extends Element{

    public static final String COLOR = "#FF6640";

    public Pyro() {
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
