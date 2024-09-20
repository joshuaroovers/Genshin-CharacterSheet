package SheetComponents.Weapons;

import SheetComponents.Actions.AttackEffects.EffectDamage;
import SheetComponents.Actions.Attacks.Attack;
import SheetComponents.Actions.Attacks.Dice;
import SheetComponents.Elements.Element;
import SheetComponents.Elements.Physical;
import SheetComponents.Stat;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Bow extends Weapon{

    private static final int BASIC_ATTACK_AMOUNT = 3;
    private static final String DESCRIPTION = "";
    private static final String BASIC_ATTACK_AMOUNT_NOTE = BASIC_ATTACK_AMOUNT+" Attacks";
    private static final String BASIC_ATTACK_NAME = "Normal Attack";
    private static final String BASIC_ATTACK_DESC = "fire an arrow";
    private static final String CHARGED_ATTACK_NAME = "Charged Attack: \nAimed Shot";
    private static final String CHARGED_ATTACK_DESC = "fire an arrow infused with elemental energy";

    public Bow(Element visionElement) {
        super(
            BASIC_ATTACK_AMOUNT,
            DESCRIPTION,
            new Attack(
                    BASIC_ATTACK_NAME,
                    BASIC_ATTACK_DESC,
                    60,
                    Stat.DEXTERITY,
                    new EffectDamage(Dice.D6, 1, Stat.DEXTERITY, new Physical()),
                    false,
                    Arrays.asList(BASIC_ATTACK_AMOUNT_NOTE)),
            new Attack(
                    CHARGED_ATTACK_NAME,
                    CHARGED_ATTACK_DESC,
                    120,
                    Stat.DEXTERITY,
                    new EffectDamage(Dice.D6, 2, Stat.DEXTERITY, visionElement),
                    true,
                    null)
        );
    }
}
