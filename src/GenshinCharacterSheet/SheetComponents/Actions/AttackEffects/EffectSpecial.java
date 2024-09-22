package GenshinCharacterSheet.SheetComponents.Actions.AttackEffects;

import GenshinCharacterSheet.SheetComponents.Character;

public class EffectSpecial extends Effect{

    private String effect;

    public EffectSpecial(String effect) {
        this.hasUnit = false;
        this.effect = effect;
    }

    @Override
    public String getEffect(Character character) {
        return effect;
    }

    @Override
    public String getUnitURL() {
        return null;
    }

    @Override
    public String getUnitString() {
        return null;
    }
}
