package GenshinCharacterSheet.SheetComponents.Weapons;

import GenshinCharacterSheet.SheetComponents.Actions.AttackEffects.EffectDamage;
import GenshinCharacterSheet.SheetComponents.Actions.Attacks.Attack;
import GenshinCharacterSheet.SheetComponents.Actions.Attacks.Dice;
import GenshinCharacterSheet.SheetComponents.Elements.Elements;
import GenshinCharacterSheet.SheetComponents.PrimaryStats;

import java.util.ArrayList;
import java.util.Arrays;

public class Claymore extends Weapon{

    private static final int BASIC_ATTACK_AMOUNT = 2;
    private static final String DESCRIPTION = "";
    private static final String BASIC_ATTACK_AMOUNT_NOTE = BASIC_ATTACK_AMOUNT+" Attacks";
    private static final String BASIC_ATTACK_NAME = "Normal Attack";
    private static final String BASIC_ATTACK_DESC = "fire an arrow";
    private static final String CHARGED_ATTACK_NAME = "Charged Attack";
    private static final String CHARGED_ATTACK_DESC = "fire an arrow infused with elemental energy";
    private static final ArrayList<PrimaryStats> SAVE_PROFICIENCIES;

    static {
        SAVE_PROFICIENCIES = new ArrayList<>();
        SAVE_PROFICIENCIES.add(PrimaryStats.STRENGTH);
        SAVE_PROFICIENCIES.add(PrimaryStats.CONSTITUTION);
    }

    public Claymore() {
        super(
            BASIC_ATTACK_AMOUNT,
            DESCRIPTION,
            new Attack(
                    BASIC_ATTACK_NAME,
                    BASIC_ATTACK_DESC,
                    5,
                    PrimaryStats.STRENGTH,
                    new EffectDamage(Dice.D12, 1, PrimaryStats.STRENGTH, Elements.PHYSICAL),
                    false,
                    Arrays.asList(BASIC_ATTACK_AMOUNT_NOTE)),
            new Attack(
                    CHARGED_ATTACK_NAME,
                    CHARGED_ATTACK_DESC,
                    5,
                    PrimaryStats.STRENGTH,
                    PrimaryStats.DEXTERITY,
                    new EffectDamage(Dice.D8, 1, PrimaryStats.STRENGTH, Elements.PHYSICAL),
                    false,
                    null),
            SAVE_PROFICIENCIES
        );
    }
}
