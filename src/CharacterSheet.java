import SheetComponents.*;

import java.util.LinkedHashMap;

public class CharacterSheet {

    public enum stat {STRENGTH,DEXTERITY,CONSTITUTION,INTELLIGENCE,WISDOM,CHARISMA}

    private LinkedHashMap<stat, PrimaryStat> primaryStats;

    private final int proficiencyBonus =  3;

    private LinkedHashMap<stat, SavingThrow> savingThrows;

    private LinkedHashMap<String, Skill> skills;

    private HitPoints hitPoints;

    public CharacterSheet(LinkedHashMap<String,stat> defaultSkillList) {
        this.primaryStats = new LinkedHashMap<>();
        this.savingThrows = new LinkedHashMap<>();
        this.skills = new LinkedHashMap<>();

        for (stat value : stat.values()) {
            int randScore = (int)(Math.random()*5)+1 + (int)(Math.random()*5)+1 + (int)(Math.random()*5)+1 + (int)(Math.random()*5)+1;

            primaryStats.put(value, new PrimaryStat(value.name(), randScore));

            boolean saveProf = false;
            if((Math.random() < 0.5)){
                saveProf = true;
                System.out.println("prof! "+value.name()+" saves");
            }
            savingThrows.put(value, new SavingThrow(getPrimaryStat(value),saveProf));
        }

        for (String skillName : defaultSkillList.keySet()) {

            boolean randProf = false;
            if(Math.random()*5 > 4){
                System.out.println("prof! "+skillName);
                randProf = true;
            }
            PrimaryStat primaryStat = primaryStats.get(defaultSkillList.get(skillName));
            skills.put(skillName, new Skill(skillName, primaryStat,randProf));
        }

        int maxHP = (int)(Math.random()*50) + getPrimaryStat(stat.CONSTITUTION).getModifier()*5;
        this.hitPoints = new HitPoints(maxHP);
        this.hitPoints.setShieldHP((int)(Math.random()*50));
//        this.hitPoints.setElementalShieldElement(Element.DENDRO);
//        this.hitPoints.setElementalShieldHP((int)(Math.random()*50));
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

    public LinkedHashMap<stat, SavingThrow> getSavingThrows() {
        return savingThrows;
    }
    public SavingThrow getSavingThrow(stat stat){
        return savingThrows.get(stat);
    }

    public HitPoints getHitPoints() {
        return hitPoints;
    }
}
