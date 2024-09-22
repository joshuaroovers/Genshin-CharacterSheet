package GenshinCharacterSheet.SheetComponents.ElementalReactions;

import GenshinCharacterSheet.SheetComponents.Elements.*;

import java.util.ArrayList;
import java.util.Arrays;

public class ReactionSwirl extends Reaction{


    public ReactionSwirl() {
        Element element1 = new Anemo();
        this.element1 = element1;
        this.otherElements = new ArrayList<>(Arrays.asList(new Cryo(), new Electro(), new Hydro(), new Pyro()));
        this.color = element1.getColor();
        this.colorHex = element1.getColorHex();

        this.description = "Causes an AOE of the non-Anemo element dealing damage of that type and applying the element";
    }


//    public boolean checkForReaction(Element elem1, Element elem2) {
//        if((element1 == elem1 && otherElements.contains(elem2)) || (element1 == elem2 && otherElements.contains(elem1))){
//            return true;
//        }else{
//            return false;
//        }
//    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +"{ elements: "+getElement1().getName() +", "+ getOtherElements()+"}";
    }
}
