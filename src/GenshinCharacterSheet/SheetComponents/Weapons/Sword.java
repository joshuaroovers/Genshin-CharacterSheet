package GenshinCharacterSheet.SheetComponents.Weapons;

import GenshinCharacterSheet.SheetComponents.Actions.AttackEffects.EffectDamage;
import GenshinCharacterSheet.SheetComponents.Actions.Attacks.Attack;
import GenshinCharacterSheet.SheetComponents.Actions.Attacks.Dice;
import GenshinCharacterSheet.SheetComponents.Elements.Elements;
import GenshinCharacterSheet.SheetComponents.PrimaryStats;

import java.util.ArrayList;
import java.util.Arrays;

public class Sword extends Weapon{

    private static final int BASIC_ATTACK_AMOUNT = 3;
    private static final String DESCRIPTION = "";
    private static final String BASIC_ATTACK_AMOUNT_NOTE = BASIC_ATTACK_AMOUNT+" Attacks";
    private static final String BASIC_ATTACK_NAME = "Normal Attack";
    private static final String BASIC_ATTACK_DESC = "";
    private static final String CHARGED_ATTACK_NAME = "Charged Attack";
    private static final String CHARGED_ATTACK_DESC = "";
    private static final ArrayList<PrimaryStats> SAVE_PROFICIENCIES;

    static {
        SAVE_PROFICIENCIES = new ArrayList<>();
        SAVE_PROFICIENCIES.add(PrimaryStats.DEXTERITY);
        SAVE_PROFICIENCIES.add(PrimaryStats.STRENGTH);
    }

    public Sword() {
        super(
            BASIC_ATTACK_AMOUNT,
            DESCRIPTION,
            new Attack(
                    BASIC_ATTACK_NAME,
                    BASIC_ATTACK_DESC,
                    5,
                    PrimaryStats.DEXTERITY,
                    new EffectDamage(Dice.D8, 1, PrimaryStats.DEXTERITY, Elements.PHYSICAL),
                    false,
                    Arrays.asList(BASIC_ATTACK_AMOUNT_NOTE)),
            new Attack(
                    CHARGED_ATTACK_NAME,
                    CHARGED_ATTACK_DESC,
                    5,
                    PrimaryStats.DEXTERITY,
                    PrimaryStats.DEXTERITY,
                    new EffectDamage(Dice.D8, 1, PrimaryStats.DEXTERITY, Elements.PHYSICAL),
                    false,
                    null),
                SAVE_PROFICIENCIES
            );
    }
}
