package SheetComponents.Actions.AttackEffects;

import SheetComponents.Actions.Attacks.Dice;
import SheetComponents.Character;
import SheetComponents.Elements.Hydro;
import SheetComponents.Stat;
import UI.Util.ImageElementVariant;
import UI.Util.ImageHelper;

public class EffectHealing extends Effect{

    private Dice dice;
    private int dieCount;
    private Stat statBonus;

    public EffectHealing(Dice dice, int dieCount, Stat statBonus) {
        this.hasUnit = true;
        this.dice = dice;
        this.dieCount = dieCount;
        this.statBonus = statBonus;
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
        return dieCount + dice.name()+bonusString;
    }

    @Override
    public String getUnitURL() {
        return null; //TODO
    }

    @Override
    public String getUnitString() {
        return null;
    }

    public String getUnitImage(){//TODO temp hydro needs to be healing image of some kind
        return ImageHelper.getElementURL(new Hydro(), ImageElementVariant.FLAT);
    }
}
