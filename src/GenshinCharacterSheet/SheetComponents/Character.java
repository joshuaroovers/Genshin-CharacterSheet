package GenshinCharacterSheet.SheetComponents;

import GenshinCharacterSheet.SheetComponents.Actions.Attacks.ElementalBursts.ElementalBurst;
import GenshinCharacterSheet.SheetComponents.Actions.Attacks.ElementalBursts.ElementalBurstDestructive;
import GenshinCharacterSheet.SheetComponents.Actions.Attacks.ElementalSkills.ElementalSkill;
import GenshinCharacterSheet.SheetComponents.Actions.Attacks.ElementalSkills.ElementalSkillSummonTaunt;
import GenshinCharacterSheet.SheetComponents.Elements.*;
import GenshinCharacterSheet.SheetComponents.Lineage.*;
import GenshinCharacterSheet.SheetComponents.Weapons.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Character {

    private String name;

    private Element visionElement;
    private Weapon weapon;
    private Lineage lineage;

    private Stamina stamina;

    private LinkedHashMap<PrimaryStats, PrimaryStat> primaryStats;

    private final int proficiencyBonus =  3;
    private Inspiration inspiration;

    private LinkedHashMap<PrimaryStats, SavingThrow> savingThrows;

    private LinkedHashMap<String, Skill> skills;

    private HitPoints hitPoints;

    private ElementalBurst elementalBurst;
    private ElementalSkill elementalSkill;

    public Character(String name, Element visionElement, Weapon weapon, Lineage lineage, HashMap<PrimaryStats, Integer> primaryStatValues, ArrayList<String> proficientSkills, ElementalBurst elementalBurst, ElementalSkill elementalSkill) {
        this.name = name;
        this.visionElement = visionElement;
        this.weapon = weapon;
        this.lineage = lineage;
        this.stamina = new Stamina();
        this.elementalBurst = elementalBurst;
        this.elementalSkill = elementalSkill;

        this.primaryStats = new LinkedHashMap<>();
        this.savingThrows = new LinkedHashMap<>();
        this.skills = new LinkedHashMap<>();

        this.inspiration = new Inspiration(false);

        ArrayList<PrimaryStats> weaponSaveProfs = weapon.getSaveProficiencies();
        for (PrimaryStats value : PrimaryStats.values()) {

            primaryStats.put(value, new PrimaryStat(value.name(), primaryStatValues.get(value)));
            savingThrows.put(value, new SavingThrow(getPrimaryStat(value), weaponSaveProfs.contains(value)));
        }

        for (String skillName : Skills.defaultSkills.keySet()) {

            PrimaryStat primaryStat = primaryStats.get(Skills.defaultSkills.get(skillName));
            skills.put(skillName, new Skill(skillName, primaryStat, proficientSkills.contains(skillName)));
        }
        int maxHP = 50 + getPrimaryStat(PrimaryStats.CONSTITUTION).getModifier()*5;
        this.hitPoints = new HitPoints(maxHP);
    }

    public String getName(){
        return name;
    }
    public Element getVisionElement() {
        return visionElement;
    }
    public Weapon getWeapon() {
        return weapon;
    }

    public ElementalBurst getElementalBurst() {
        return elementalBurst;
    }

    public ElementalSkill getElementalSkill() {
        return elementalSkill;
    }

    public Lineage getLineage(){return lineage;}

    public int getWalkingSpeed(){
        return getLineage().getWalkingSpeed();
    }
    public Stamina getStamina() {
        return stamina;
    }

    public int getProficiencyBonus() {
        return proficiencyBonus;
    }

    public LinkedHashMap<PrimaryStats, PrimaryStat> getPrimaryStats() {
        return primaryStats;
    }
    public PrimaryStat getPrimaryStat(PrimaryStats key){
        return primaryStats.get(key);
    }
    public int getSaveDC(PrimaryStats key){return 8 + getProficiencyBonus() +getPrimaryStat(key).getModifier();}
    public int getToHit(PrimaryStats stat) {
        return getPrimaryStat(stat).getModifier() + getProficiencyBonus();
    }

    public Inspiration getInspiration(){
        return inspiration;
    }

    public LinkedHashMap<String, Skill> getSkills() {
        return skills;
    }
    public Skill getSkill(String key){
        return skills.get(key);
    }

    public LinkedHashMap<PrimaryStats, SavingThrow> getSavingThrows() {
        return savingThrows;
    }
    public SavingThrow getSavingThrow(PrimaryStats stat){
        return getSavingThrows().get(stat);
    }

    public HitPoints getHitPoints() {
        return hitPoints;
    }

    public int getArmorClass(){
        return 10 + getPrimaryStat(PrimaryStats.DEXTERITY).getModifier();
    }

    public int getInitiativeBonus(){
        return getPrimaryStat(PrimaryStats.DEXTERITY).getModifier();
    }

}
