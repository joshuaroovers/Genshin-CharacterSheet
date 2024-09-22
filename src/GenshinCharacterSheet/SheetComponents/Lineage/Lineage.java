package GenshinCharacterSheet.SheetComponents.Lineage;

import java.util.ArrayList;

public abstract class Lineage {
    int walkingSpeed = 30;
    int swimmingSpeed = walkingSpeed/2;
    int climbingSpeed = walkingSpeed/2;
    int flyingSpeed = 0;
    private static ArrayList<Lineage> allLineages;
    static {
        allLineages = new ArrayList<>();
        allLineages.add(new Adeptus());
        allLineages.add(new Anthro());
        allLineages.add(new Fontainian());
        allLineages.add(new Human());
        allLineages.add(new Khaenriahn());
        allLineages.add(new Yokai());
    }

    public String getName(){
        return this.getClass().getSimpleName();
    }

    public int getWalkingSpeed() {
        return walkingSpeed;
    }

    public static ArrayList<Lineage> getAllLineages() {
        return allLineages;
    }

    @Override
    public String toString() {
        return getName();
    }
}
