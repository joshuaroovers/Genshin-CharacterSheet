package SheetComponents.ElementalReactions;

import SheetComponents.Elements.Element;
import javafx.scene.paint.Color;

public abstract class Reaction {

    Element element1;
    Element element2;
    Color color;
    String colorHex;

    public String getName(){
        String name =  this.getClass().getSimpleName();
        if(name.length() > 8){
            name = name.substring(8);
        }

        return name;
    }

    public Element getElement1() {
        return element1;
    }

    public Element getElement2() {
        return element2;
    }

    public Color getColor() {
        return color;
    }

    public String getColorHex() {
        return colorHex;
    }

    public boolean checkForReaction(Element elem1, Element elem2){
        if(hasElement(elem1) && hasElement(elem2)){
            return true;
        }else{
            return false;
        }
    }

    public boolean hasElement(Element element){ //TODO adapt to swirl and crystallize
        if(element1.getName().equals(element.getName()) || element2.getName().equals(element.getName())){
            return true;
        }else{
            return false;
        }
    }


    @Override
    public String toString() {
        return this.getClass().getSimpleName() +"{ elements: "+getElement1().getName() +", "+getElement2().getName()+"}";
    }
}
