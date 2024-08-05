package SheetComponents.Elements;

import SheetComponents.ElementalReactions.Reaction;
import SheetComponents.ElementalReactions.ElementalReactionHelper;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Element implements Comparable<Element> {
    private Color color;
    private String colorHex;
    private static ArrayList<Element> allElements = new ArrayList<Element>(Arrays.asList(new Anemo(), new Cryo(), new Dendro(), new Electro(), new Geo(), new Hydro(), new Pyro()));

    public String getName(){
        return this.getClass().getSimpleName();
    }

    protected void setColor(String colorHex){
        this.colorHex = colorHex;
        this.color = Color.valueOf(colorHex);
    }

    public Color getColor() {
        return color;
    }

    public String getColorHex() {
        return colorHex;
    }

    @Override
    public int compareTo(Element o) {
        return this.getName().compareTo(o.getName());
    }

    public Reaction getElementalReaction(Element secondElement){
        return ElementalReactionHelper.getReaction(this, secondElement);
    }
    public ArrayList<Reaction> getElementalReactions(){
        return ElementalReactionHelper.getReactions(this);
    }

    public static ArrayList<Element> getAll(){
        return allElements;
    }
}
