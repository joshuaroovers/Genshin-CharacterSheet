package SheetComponents.ElementalReactions;

import SheetComponents.Elements.*;

import java.util.ArrayList;
import java.util.Arrays;

public class ReactionCrystallize extends Reaction{


    private final ArrayList<Element> elements = new ArrayList<>(Arrays.asList(new Cryo(), new Electro(), new Hydro(), new Pyro()));


    public ReactionCrystallize() {
        Element element1 = new Geo();
        this.element1 = element1;

        this.color = element1.getColor();
        this.colorHex = element1.getColorHex();
    }

    public ArrayList<Element> getElements() {
        return elements;
    }

    public boolean checkForReaction(Element elem1, Element elem2) {
        if((element1 == elem1 && elements.contains(elem2)) || (element1 == elem2 && elements.contains(elem1))){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +"{ elements: "+getElement1().getName() +", "+getElements()+"}";
    }
}
