package SheetComponents.Actions.AttackEffects;

import SheetComponents.Character;

public abstract class Effect {

    boolean hasUnit;

    abstract String getEffect(Character character);
    public boolean hasUnit(){return hasUnit;}
}
