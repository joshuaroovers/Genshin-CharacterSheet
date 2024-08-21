package SheetComponents.Actions.AttackEffects;

import SheetComponents.Character;

public abstract class Effect {

    boolean hasUnit;

    abstract public String getEffect(Character character);
    public boolean hasUnit(){return hasUnit;}
    abstract public String getUnitURL();
    abstract public String getUnitString();
}
