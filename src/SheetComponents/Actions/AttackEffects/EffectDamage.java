package SheetComponents.Actions.AttackEffects;

import SheetComponents.Actions.Attacks.Die;
import SheetComponents.Character;
import SheetComponents.Elements.Element;
import SheetComponents.Stat;
import UI.Util.ImageHelper;

public class EffectDamage extends Effect{

    private Die die;
    private int damageDieCount;
    private Stat statBonus;
    private Element damageType;

    public EffectDamage(Die die, int damageDieCount, Stat statBonus, Element damageType) {
        this.hasUnit = true;
        this.die = die;
        this.damageDieCount = damageDieCount;
        this.statBonus = statBonus;
        this.damageType = damageType;
    }

    @Override
    public String getEffect(Character character) {
        int bonus = character.getPrimaryStat(statBonus).getModifier();
        String bonusString = "";
        if(bonus > 0){
            bonusString = "+" + bonus;
        }else if(bonus < 0){
            bonusString = ""+bonus;
        }
        return damageDieCount+ die.name()+bonusString;
    }

    @Override
    public String getUnitURL() {
        return ImageHelper.getAttackUnitURL(damageType);
    }

    @Override
    public String getUnitString() {
        return damageType.getName();
    }
}
