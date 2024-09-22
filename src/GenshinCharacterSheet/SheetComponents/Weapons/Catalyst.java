package GenshinCharacterSheet.SheetComponents.Weapons;

import GenshinCharacterSheet.SheetComponents.Actions.AttackEffects.EffectDamage;
import GenshinCharacterSheet.SheetComponents.Actions.Attacks.Attack;
import GenshinCharacterSheet.SheetComponents.Actions.Attacks.Dice;
import GenshinCharacterSheet.SheetComponents.Elements.Element;
import GenshinCharacterSheet.SheetComponents.Stat;

import java.util.ArrayList;
import java.util.Arrays;

public class Catalyst extends Weapon{

    private static final int BASIC_ATTACK_AMOUNT = 3;
    private static final String DESCRIPTION = "";
    private static final String BASIC_ATTACK_AMOUNT_NOTE = BASIC_ATTACK_AMOUNT+" Attacks";
    private static final String BASIC_ATTACK_NAME = "Normal Attack";
    private static final String BASIC_ATTACK_DESC = "attack with a burst of elemental energy";
    private static final String CHARGED_ATTACK_NAME = "Charged Attack";
    private static final String CHARGED_ATTACK_DESC = "big effect wow";
    private static final ArrayList<Stat> SAVE_PROFICIENCIES;

    static {
        SAVE_PROFICIENCIES = new ArrayList<>();
        SAVE_PROFICIENCIES.add(Stat.INTELLIGENCE);
        SAVE_PROFICIENCIES.add(Stat.WISDOM);
    }

    //would melee catalyst be strength or dex based? (also make it an option)
    //TODO primary stat option (instead of default Intelligence)
    public Catalyst(Element visionElement) {
        super(
            1,
            BASIC_ATTACK_AMOUNT,
            DESCRIPTION,
            new Attack(
                    BASIC_ATTACK_NAME,
                    BASIC_ATTACK_DESC,
                    60,
                    Stat.INTELLIGENCE,
                    new EffectDamage(Dice.D10, 1, null, visionElement),
                    true,
                    Arrays.asList(BASIC_ATTACK_AMOUNT_NOTE)),
            new Attack(
                    CHARGED_ATTACK_NAME,
                    CHARGED_ATTACK_DESC,
                    0,
                    Stat.INTELLIGENCE,
                    Stat.DEXTERITY,
                    new EffectDamage(Dice.D6, 2, null, visionElement),
                    true,
                    Arrays.asList("15ft cone")),
            SAVE_PROFICIENCIES
        );
    }
}
