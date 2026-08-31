package GenshinCharacterSheet.SheetComponents.Lineage;

import GenshinCharacterSheet.SheetComponents.Features.Feature;
import GenshinCharacterSheet.SheetComponents.Features.HasFeatures;

import java.util.ArrayList;
import java.util.Arrays;

public class Fontainian extends Lineage implements HasFeatures{

    private static final Feature SWIMMING = new Feature(
            "Of Primordial Waters",
            "you can swim real good!");
    
    private static final ArrayList<Feature> features = new ArrayList<>(
            Arrays.asList(
                    SWIMMING
            )
    );

    @Override
    public ArrayList<Feature> getFeatures() {
        return features;
    }
}
