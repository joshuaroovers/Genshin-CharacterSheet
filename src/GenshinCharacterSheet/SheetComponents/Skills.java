package GenshinCharacterSheet.SheetComponents;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;

public final class Skills {
    public static final Skill ACROBATICS        = new Skill("Acrobatics", PrimaryStats.DEXTERITY);
    public static final Skill ANIMALHANDELING   = new Skill("Animal Handling", PrimaryStats.WISDOM);
    public static final Skill ARCANA            = new Skill("Arcana", PrimaryStats.INTELLIGENCE);
    public static final Skill ATHLETICS         = new Skill("Athletics", PrimaryStats.STRENGTH);
    public static final Skill DECEPTION         = new Skill("Deception", PrimaryStats.CHARISMA);
    public static final Skill HISTORY           = new Skill("History", PrimaryStats.INTELLIGENCE);
    public static final Skill INSIGHT           = new Skill("Insight", PrimaryStats.WISDOM);
    public static final Skill INTIMIDATION      = new Skill("Intimidation", PrimaryStats.CHARISMA);
    public static final Skill INVESTIGATION     = new Skill("Investigation", PrimaryStats.INTELLIGENCE);
    public static final Skill MEDICINE          = new Skill("Medicine", PrimaryStats.WISDOM);
    public static final Skill NATURE            = new Skill("Nature", PrimaryStats.INTELLIGENCE);
    public static final Skill PERCEPTION        = new Skill("Perception", PrimaryStats.WISDOM);
    public static final Skill PERFORMANCE       = new Skill("Performance", PrimaryStats.CHARISMA);
    public static final Skill PERSUASION        = new Skill("Persuasion", PrimaryStats.CHARISMA);
    public static final Skill RELIGION          = new Skill("Religion", PrimaryStats.INTELLIGENCE);
    public static final Skill SLEIGHTOFHAND     = new Skill("Sleight of Hand", PrimaryStats.DEXTERITY);
    public static final Skill STEALTH           = new Skill("Stealth", PrimaryStats.DEXTERITY);
    public static final Skill SURVIVAL          = new Skill("Survival", PrimaryStats.WISDOM);
    public static final ArrayList<Skill> ALL = new ArrayList<>(
            Arrays.asList(
                    ACROBATICS,
                    ANIMALHANDELING,
                    ARCANA,
                    ATHLETICS,
                    DECEPTION,
                    HISTORY,
                    INSIGHT,
                    INTIMIDATION,
                    INVESTIGATION,
                    MEDICINE,
                    NATURE,
                    PERCEPTION,
                    PERFORMANCE,
                    PERSUASION,
                    RELIGION,
                    SLEIGHTOFHAND,
                    STEALTH,
                    SURVIVAL
    ));

    /**
     * Skills.where()
     * @param predicate (lambda predicate ie: (s -> s.getStat() == PrimaryStats.STRENGTH))
     * @return arraylist of filtered skills
     */
    public static ArrayList<Skill> where(Predicate<Skill> predicate) {
        return new ArrayList<>(
                Arrays.asList(
                        ALL
                        .stream()
                        .filter(predicate)
                        .toArray(Skill[]::new)));
    }
}
