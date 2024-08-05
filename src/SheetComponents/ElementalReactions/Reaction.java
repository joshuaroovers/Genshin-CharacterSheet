package SheetComponents.ElementalReactions;

import SheetComponents.Elements.Element;

public abstract class Reaction {

    Element element1;
    Element element2;

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

    public boolean checkForReaction(Element elem1, Element elem2){
        if(hasElement(elem1) && hasElement(elem2)){
            return true;
        }else{
            return false;
        }
    }

    public boolean hasElement(Element element){
        if(element1 == element || element2 == element){
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
