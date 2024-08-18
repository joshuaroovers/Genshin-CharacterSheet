package SheetComponents.Actions.AttackEffects;

import SheetComponents.Actions.Attacks.Die;
import SheetComponents.Character;
import SheetComponents.Elements.Hydro;
import SheetComponents.Stat;
import UI.Util.ImageElementVariant;
import UI.Util.ImageHelper;

public class EffectHealing extends Effect{

    private Die die;
    private int dieCount;
    private Stat statBonus;

    public EffectHealing(Die die, int dieCount, Stat statBonus) {
        this.hasUnit = true;
        this.die = die;
        this.dieCount = dieCount;
        this.statBonus = statBonus;
    }

    @Override
    String getEffect(Character character) {
        int bonus = character.getPrimaryStat(statBonus).getModifier();
        String bonusString = "";
        if(bonus > 0){
            bonusString = "+" + bonus;
        }else if(bonus < 0){
            bonusString = "-" + bonus;
        }
        return dieCount + die.name()+bonusString;
    }

    public String getUnitImage(){//TODO temp hydro needs to be healing image of some kind
        return ImageHelper.getElementURL(new Hydro(), ImageElementVariant.FLAT);
    }
}
