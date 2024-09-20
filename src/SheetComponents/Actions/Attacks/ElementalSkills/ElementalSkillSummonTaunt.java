package SheetComponents.Actions.Attacks.ElementalSkills;

import SheetComponents.Actions.AttackEffects.EffectSpecial;
import SheetComponents.Actions.Attacks.Dice;
import SheetComponents.Stat;

import java.util.Arrays;
import java.util.List;

public class ElementalSkillSummonTaunt extends ElementalSkill{

    private final static String NAME = "Summon Taunt";
    private final static int damageDieCount = 1;
    private final static Dice DICE = Dice.D10;

    private final static String DESCRIPTION = "Summons an elemental creation, any hostile creatures that can see it must make a wisdom saving throw" +
            " or be taunted and spend their next turn attacking the creation." +
            System.lineSeparator() +
            " The creation has 10 hitpoints, if it's reduced to 0 it explodes with Elemental energy dealing "+
            damageDieCount+ DICE.name()+
            " Elemental damage, applying the element and granting you +1 energy. " +
            System.lineSeparator() +
            "At the start of your next turn if it hasn't yet the creation explodes.";
    private final static int RANGE = 15;
    //TODO what stat to base the save on?? base it on class?   Maybe make it different per skill/burst
    private final static Stat SAVE_SCALE = Stat.CONSTITUTION;
    private final static boolean APPLIES_ELEMENT = false;
    private final static Stat SAVE_TYPE = Stat.WISDOM;
    private final static List<String> NOTES = Arrays.asList("+1 Energy");



    public ElementalSkillSummonTaunt() {
        super(NAME, DESCRIPTION, RANGE, SAVE_SCALE, SAVE_TYPE, new EffectSpecial("Summoning"), APPLIES_ELEMENT, NOTES);
    }

}
