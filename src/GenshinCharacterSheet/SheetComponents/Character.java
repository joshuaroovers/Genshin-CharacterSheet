package GenshinCharacterSheet.SheetComponents;

import GenshinCharacterSheet.SheetComponents.Actions.Attacks.ElementalBursts.ElementalBurst;
import GenshinCharacterSheet.SheetComponents.Actions.Attacks.ElementalSkills.ElementalSkill;
import GenshinCharacterSheet.SheetComponents.Elements.*;
import GenshinCharacterSheet.SheetComponents.Lineage.*;
import GenshinCharacterSheet.SheetComponents.Weapons.*;

import java.util.ArrayList;
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

    private ArrayList<SkillProficiency> skills;

    private HitPoints hitPoints;

    private ElementalBurst elementalBurst;
    private ElementalSkill elementalSkill;

    public Character(String name, Element visionElement, Weapon weapon, Lineage lineage, HashMap<PrimaryStats, Integer> primaryStatValues, ArrayList<Skill> proficientSkills, ElementalBurst elementalBurst, ElementalSkill elementalSkill) {
        this.name = name;
        this.visionElement = visionElement;
        this.weapon = weapon;
        this.lineage = lineage;
        this.stamina = new Stamina();
        this.elementalBurst = elementalBurst;
        this.elementalSkill = elementalSkill;

        this.primaryStats = new LinkedHashMap<>();
        this.savingThrows = new LinkedHashMap<>();
        this.skills = new ArrayList<>();

        this.inspiration = new Inspiration(false);

        ArrayList<PrimaryStats> weaponSaveProfs = weapon.getSaveProficiencies();
        for (PrimaryStats value : PrimaryStats.values()) {

            primaryStats.put(value, new PrimaryStat(value.name(), primaryStatValues.get(value)));
            savingThrows.put(value, new SavingThrow(getPrimaryStat(value), weaponSaveProfs.contains(value)));
        }

        for (Skill skill : Skills.ALL) {

            skills.add(new SkillProficiency(skill, proficientSkills.contains(skill)));
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

    public ArrayList<SkillProficiency> getSkills() {
        return skills;
    }
//    public SkillProficiency getSkill(SkillProficiency skill){
//        return skills.;
//    }

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
