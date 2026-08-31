package GenshinCharacterSheet.SheetComponents.Lineage;

import java.util.ArrayList;
import java.util.Arrays;

public class Lineages {
    public static final Lineage HUMAN = new Human();
    public static final Lineage ADEPTUS = new Adeptus();
    public static final Lineage YOKAI = new Yokai();
    public static final Lineage ANTHRO = new Anthro();
    public static final Lineage FONTAINIAN = new Fontainian();
    public static final Lineage KHAENRIAHN = new Khaenriahn();
    public static final ArrayList<Lineage> ALL = new ArrayList<>(
            Arrays.asList(
                    HUMAN,
                    ADEPTUS,
                    YOKAI,
                    ANTHRO,
                    FONTAINIAN,
                    KHAENRIAHN
            )
    );

}
