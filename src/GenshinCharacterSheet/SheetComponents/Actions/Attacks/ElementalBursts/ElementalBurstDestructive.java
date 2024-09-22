package GenshinCharacterSheet.SheetComponents.Actions.Attacks.ElementalBursts;

import GenshinCharacterSheet.SheetComponents.Actions.AttackEffects.EffectDamage;
import GenshinCharacterSheet.SheetComponents.Actions.Attacks.Dice;
import GenshinCharacterSheet.SheetComponents.Elements.Element;
import GenshinCharacterSheet.SheetComponents.Stat;

import java.util.Arrays;
import java.util.List;

public class ElementalBurstDestructive extends ElementalBurst{

    private final static String NAME = "Destructive";
    private final static String DESCRIPTION = "";
    private final static int RANGE = 30;
    //TODO what stat to base the save on?? base it on class?   Maybe make it different per skill/burst
    private final static Stat SAVE_SCALE = Stat.CONSTITUTION;
    private final static boolean APPLIES_ELEMENT = true;
    private final static Stat SAVE_TYPE = Stat.DEXTERITY;
    private final static List<String> NOTES = Arrays.asList("30ft Cube","");

    public ElementalBurstDestructive(Element damageType) {
        super(NAME, DESCRIPTION, RANGE, SAVE_SCALE, SAVE_TYPE, new EffectDamage(Dice.D6, 5, null, damageType), APPLIES_ELEMENT, NOTES);
    }
}
