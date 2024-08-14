package SheetComponents.ElementalReactions;

import SheetComponents.Elements.*;

import java.util.ArrayList;
import java.util.Arrays;

public class ReactionCrystallize extends Reaction{



    public ReactionCrystallize() {
        Element element1 = new Geo();
        this.element1 = element1;
        this.otherElements.addAll(Arrays.asList(new Cryo(), new Electro(), new Hydro(), new Pyro()));
        this.color = element1.getColor();
        this.colorHex = element1.getColorHex();
    }


    @Override
    public String toString() {
        return this.getClass().getSimpleName() +"{ elements: "+getElement1().getName() +", "+ getOtherElements()+"}";
    }
}
