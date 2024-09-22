package GenshinCharacterSheet.SheetComponents.Elements;

import GenshinCharacterSheet.SheetComponents.ElementalReactions.Reaction;
import GenshinCharacterSheet.SheetComponents.ElementalReactions.ElementalReactionHelper;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Element implements Comparable<Element> {
    private Color color;
    private String colorHex;
    private static ArrayList<Element> allElements = new ArrayList<>(Arrays.asList(new Anemo(), new Cryo(), new Dendro(), new Electro(), new Geo(), new Hydro(), new Pyro()));

    public Element(String colorHex) {
        setColor(colorHex);
    }

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
    abstract Color getStaticColor();

    public String getColorHex() {
        return colorHex;
    }
    abstract String getStaticColorHex();

    @Override
    public int compareTo(Element o) {
        return this.getName().compareTo(o.getName());
    }

    public Reaction getElementalReaction(Element secondElement){ //TODO might be unnecessary
        return ElementalReactionHelper.getReaction(this, secondElement);
    }
    public ArrayList<Reaction> getElementalReactions(){ //TODO might be unnecessary
        return ElementalReactionHelper.getReactions(this);
    }

    public static ArrayList<Element> getAll(){
        return allElements;
    }

    @Override
    public String toString() {
        return getName();
    }
}
