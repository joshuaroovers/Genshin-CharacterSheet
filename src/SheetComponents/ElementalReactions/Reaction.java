package SheetComponents.ElementalReactions;

import SheetComponents.Elements.Element;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Reaction {

    private static ArrayList<Reaction> allReactions = new ArrayList<>(Arrays.asList(
            new ReactionBloom(), new ReactionBurning(), new ReactionCatalyze(),
            new ReactionCrystallize(), new ReactionElectroCharged(), new ReactionFrozen(),
            new ReactionMelt(), new ReactionOverload(), new ReactionSuperConduct(),
            new ReactionSwirl(), new ReactionVaporize()));

    public static ArrayList<Reaction> getAllReactions() {
        return allReactions;
    }

    Element element1;
    Element element2;
    ArrayList<Element> otherElements = new ArrayList<>();
    Color color;
    String colorHex;

    String description;

    public String getName(){
        String name = this.getClass().getSimpleName();
        if(name.length() > 8){
            name = name.substring(8); //remove the 'Reaction' part of the name
        }

        return name;
    }

    public Element getElement1() {
        return element1;
    }

    public Element getElement2() {
        return element2;
    }

    public boolean hasOtherElements(){
        return !otherElements.isEmpty();
    }
    public ArrayList<Element> getOtherElements() {
        return otherElements;
    }

    public Color getColor() {
        return color;
    }

    public String getColorHex() {
        return colorHex;
    }

    public String getDescription() {
        return description;
    }

    public boolean checkForReaction(Element elem1, Element elem2){
        if(hasOtherElements()){
            boolean hasElem1 = false;
            boolean hasElem2 = false;
            for (Element otherElement : otherElements) {
                if(otherElement.getName().equals(elem1.getName())){
                    hasElem1 = true;
                }
                if(otherElement.getName().equals(elem2.getName())){
                    hasElem2 = true;
                }
            }
            if(hasElem1 && hasElem2){
                return false;
            }else{
                return hasElement(elem1) && hasElement(elem2);
            }
        }else{
            return hasElement(elem1) && hasElement(elem2);
        }
    }

    public boolean hasElement(Element element){
        if(this.hasOtherElements()){
            if(element1.getClass().equals(element.getClass())){
                return true;
            }else{
                boolean isOtherElement = false;
                for (Element otherElement : otherElements) {
                    if(otherElement.getClass().equals(element.getClass())){
                        isOtherElement = true;
                    }
                }
                return isOtherElement;
            }
        }else{
            return element1.getClass().equals(element.getClass()) || element2.getClass().equals(element.getClass());
        }
    }


    @Override
    public String toString() {
        return this.getClass().getSimpleName() +"{ elements: "+getElement1().getName() +", "+getElement2().getName()+"}";
    }
}
