import SheetComponents.Skill;
import SheetComponents.PrimaryStat;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeSet;

public class CharacterSheet {

    public enum stat {STRENGTH,DEXTERITY,CONSTITUTION,INTELLIGENCE,WISDOM,CHARISMA}

    private LinkedHashMap<stat, PrimaryStat> primaryStats;

    private final int proficiencyBonus =  3;

    private LinkedHashMap<String, Skill> skills;

    public CharacterSheet(LinkedHashMap<String,stat> defaultSkillList) {
        this.primaryStats = new LinkedHashMap<>();
        for (stat value : stat.values()) {
            primaryStats.put(value, new PrimaryStat(value.name(), 10));
        }

        this.skills = new LinkedHashMap<>();
        for (String skillName : defaultSkillList.keySet()) {

            PrimaryStat primaryStat = primaryStats.get(defaultSkillList.get(skillName));
            skills.put(skillName, new Skill(skillName, primaryStat,false));
        }
    }

    public LinkedHashMap<stat, PrimaryStat> getPrimaryStats() {
        return primaryStats;
    }
    public PrimaryStat getPrimaryStat(stat key){
        return primaryStats.get(key);
    }


}
