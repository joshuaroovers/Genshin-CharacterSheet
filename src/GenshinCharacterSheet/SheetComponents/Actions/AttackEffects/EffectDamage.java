package GenshinCharacterSheet.SheetComponents.Actions.AttackEffects;

import GenshinCharacterSheet.SheetComponents.Actions.Attacks.Dice;
import GenshinCharacterSheet.SheetComponents.Character;
import GenshinCharacterSheet.SheetComponents.Elements.Element;
import GenshinCharacterSheet.SheetComponents.Stat;
import GenshinCharacterSheet.UI.Util.ImageHelper;

public class EffectDamage extends Effect{

    private Dice dice;
    private int damageDieCount;
    private Stat statBonus;
    private Element damageType;

    public EffectDamage(Dice dice, int damageDieCount, Stat statBonus, Element damageType) {
        this.hasUnit = true;
        this.dice = dice;
        this.damageDieCount = damageDieCount;
        this.statBonus = statBonus;
        this.damageType = damageType;
    }

    @Override
    public String getEffect(Character character) {

        String bonusString = "";
        if(statBonus != null){
            int bonus = character.getPrimaryStat(statBonus).getModifier();
            if(bonus > 0){
                bonusString = "+" + bonus;
            }else if(bonus < 0){
                bonusString = ""+bonus;
            }
        }
        if(dice == Dice.D1){
            return ""+(damageDieCount+character.getPrimaryStat(statBonus).getModifier());
        }else{
            return damageDieCount+ dice.name()+bonusString;
        }
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
