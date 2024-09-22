package GenshinCharacterSheet.SheetComponents.Weapons;

import GenshinCharacterSheet.SheetComponents.Actions.AttackEffects.EffectDamage;
import GenshinCharacterSheet.SheetComponents.Actions.Attacks.Attack;
import GenshinCharacterSheet.SheetComponents.Actions.Attacks.Dice;
import GenshinCharacterSheet.SheetComponents.Elements.Physical;
import GenshinCharacterSheet.SheetComponents.Stat;

import java.util.ArrayList;
import java.util.Arrays;

public class Polearm extends Weapon{

    private static final int BASIC_ATTACK_AMOUNT = 3;
    private static final String DESCRIPTION = "";
    private static final String BASIC_ATTACK_AMOUNT_NOTE = BASIC_ATTACK_AMOUNT+" Attacks";
    private static final String BASIC_ATTACK_NAME = "Normal Attack";
    private static final String BASIC_ATTACK_DESC = "fire an arrow";
    private static final String CHARGED_ATTACK_NAME = "Charged Attack";
    private static final String CHARGED_ATTACK_DESC = "fire an arrow infused with elemental energy";
    private static final ArrayList<Stat> SAVE_PROFICIENCIES;

    static {
        SAVE_PROFICIENCIES = new ArrayList<>();
        SAVE_PROFICIENCIES.add(Stat.DEXTERITY);
        SAVE_PROFICIENCIES.add(Stat.CONSTITUTION);
    }

    public Polearm() {
        super(
            BASIC_ATTACK_AMOUNT,
            DESCRIPTION,
            new Attack(
                    BASIC_ATTACK_NAME,
                    BASIC_ATTACK_DESC,
                    10,
                    Stat.DEXTERITY,
                    new EffectDamage(Dice.D8, 1, Stat.DEXTERITY, new Physical()),
                    false,
                    Arrays.asList(BASIC_ATTACK_AMOUNT_NOTE)),
            new Attack(
                    CHARGED_ATTACK_NAME,
                    CHARGED_ATTACK_DESC,
                    0,
                    Stat.DEXTERITY,
                    Stat.DEXTERITY,
                    new EffectDamage(Dice.D8, 1, Stat.DEXTERITY, new Physical()),
                    false,
                    Arrays.asList("20ft Line")),
            SAVE_PROFICIENCIES
        );
    }
}
