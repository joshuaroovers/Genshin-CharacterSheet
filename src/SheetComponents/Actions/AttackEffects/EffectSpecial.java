package SheetComponents.Actions.AttackEffects;

import SheetComponents.Character;

public class EffectSpecial extends Effect{

    private String effect;

    public EffectSpecial(String effect) {
        this.hasUnit = false;
        this.effect = effect;
    }

    @Override
    String getEffect(Character character) {
        return effect;
    }
}
