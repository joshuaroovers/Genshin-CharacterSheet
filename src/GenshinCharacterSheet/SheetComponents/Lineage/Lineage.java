package GenshinCharacterSheet.SheetComponents.Lineage;

import java.util.ArrayList;

public abstract class Lineage {
    int walkingSpeed = 30;
    int swimmingSpeed = walkingSpeed/2;
    int climbingSpeed = walkingSpeed/2;
    int flyingSpeed = 0;

    public String getName(){
        return this.getClass().getSimpleName();
    }

    public int getWalkingSpeed() {
        return walkingSpeed;
    }

    @Override
    public String toString() {
        return getName();
    }
}
