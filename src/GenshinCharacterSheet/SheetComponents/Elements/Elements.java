package GenshinCharacterSheet.SheetComponents.Elements;

import java.util.ArrayList;
import java.util.Arrays;

public final class Elements {
    public static final Element ANEMO = new Anemo();
    public static final Element CRYO = new Cryo();
    public static final Element DENDRO = new Dendro();
    public static final Element ELECTRO = new Electro();
    public static final Element GEO = new Geo();
    public static final Element HYDRO = new Hydro();
    public static final Element PYRO = new Pyro();
    public static final Element PHYSICAL = new Physical();

    public static final ArrayList<Element> ALL = new ArrayList<>(
            Arrays.asList(
                    ANEMO,
                    CRYO,
                    DENDRO,
                    ELECTRO,
                    GEO,
                    HYDRO,
                    PYRO
    ));
}
