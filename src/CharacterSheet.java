import SheetComponents.Skill;
import SheetComponents.PrimaryStat;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.TreeSet;

public class CharacterSheet {

    public enum stat {STRENGTH,DEXTERITY,CONSTITUTION,INTELLIGENCE,WISDOM,CHARISMA}

    private LinkedHashMap<stat, PrimaryStat> primaryStats;

    private final int proficiencyBonus =  3;

    private LinkedHashMap<String, Skill> skills;

    public CharacterSheet(LinkedHashMap<String,stat> defaultSkillList) {
        this.primaryStats = new LinkedHashMap<>();
        for (stat value : stat.values()) {
            int randScore = (int)(Math.random()*6)+ (int)(Math.random()*6)+ (int)(Math.random()*6)+ (int)(Math.random()*6);

            primaryStats.put(value, new PrimaryStat(value.name(), randScore));
        }

        this.skills = new LinkedHashMap<>();
        for (String skillName : defaultSkillList.keySet()) {

            boolean randProf = false;
            if(Math.random()*5 > 4){
                System.out.println("prof! "+skillName);
                randProf = true;
            }
            PrimaryStat primaryStat = primaryStats.get(defaultSkillList.get(skillName));
            skills.put(skillName, new Skill(skillName, primaryStat,randProf));
        }
    }

    public int getProficiencyBonus() {
        return proficiencyBonus;
    }

    public LinkedHashMap<stat, PrimaryStat> getPrimaryStats() {
        return primaryStats;
    }
    public PrimaryStat getPrimaryStat(stat key){
        return primaryStats.get(key);
    }

    public LinkedHashMap<String, Skill> getSkills() {
        return skills;
    }
    public Skill getSkill(String key){
        return skills.get(key);
    }
}
