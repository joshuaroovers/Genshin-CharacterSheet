package GenshinCharacterSheet.SheetComponents;

import java.util.LinkedHashMap;

public final class Skills {
    public static LinkedHashMap<String, PrimaryStats> defaultSkills;
    static {
        defaultSkills = new LinkedHashMap<>();
        //#region default skills list
        defaultSkills.put("Acrobatics", PrimaryStats.DEXTERITY);
        defaultSkills.put("Animal Handling", PrimaryStats.WISDOM);
        defaultSkills.put("Arcana", PrimaryStats.INTELLIGENCE);
        defaultSkills.put("Athletics", PrimaryStats.STRENGTH);
        defaultSkills.put("Deception", PrimaryStats.CHARISMA);
        defaultSkills.put("History", PrimaryStats.INTELLIGENCE);
        defaultSkills.put("Insight", PrimaryStats.WISDOM);
        defaultSkills.put("Intimidation", PrimaryStats.CHARISMA);
        defaultSkills.put("Investigation", PrimaryStats.INTELLIGENCE);
        defaultSkills.put("Medicine", PrimaryStats.WISDOM);
        defaultSkills.put("Nature", PrimaryStats.INTELLIGENCE);
        defaultSkills.put("Perception", PrimaryStats.WISDOM);
        defaultSkills.put("Performance", PrimaryStats.CHARISMA);
        defaultSkills.put("Persuasion", PrimaryStats.CHARISMA);
        defaultSkills.put("Religion", PrimaryStats.INTELLIGENCE);
        defaultSkills.put("Sleight of Hand", PrimaryStats.DEXTERITY);
        defaultSkills.put("Stealth", PrimaryStats.DEXTERITY);
        defaultSkills.put("Survival", PrimaryStats.WISDOM);
        //#endregion
    }
}
