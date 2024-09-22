package GenshinCharacterSheet.SheetComponents;

import GenshinCharacterSheet.Main;
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

    private LinkedHashMap<Stat, PrimaryStat> primaryStats;

    private final int proficiencyBonus =  3;
    private Inspiration inspiration;

    private LinkedHashMap<Stat, SavingThrow> savingThrows;

    private LinkedHashMap<String, Skill> skills;

    private HitPoints hitPoints;

    private ElementalBurst elementalBurst;
    private ElementalSkill elementalSkill;

    public Character(String name, Element visionElement, Weapon weapon, Lineage lineage, HashMap<Stat, Integer> primaryStatValues, LinkedHashMap<String, Skill> proficientSkills, ElementalBurst elementalBurst, ElementalSkill elementalSkill) {
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

        ArrayList<Stat> weaponSaveProfs = weapon.getSaveProficiencies();
        for (Stat value : Stat.values()) {

            primaryStats.put(value, new PrimaryStat(value.name(), primaryStatValues.get(value)));

            boolean saveProf = false;
            if(weaponSaveProfs.contains(value)){
                saveProf = true;
            }
            savingThrows.put(value, new SavingThrow(getPrimaryStat(value),saveProf));
        }

        for (String skillName : Main.defaultSkills.keySet()) {

            boolean randProf = false;
            if(Math.random()*5 > 4){
                System.out.println("prof! "+skillName);
                randProf = true;
            }
            PrimaryStat primaryStat = primaryStats.get(Main.defaultSkills.get(skillName));
            skills.put(skillName, new Skill(skillName, primaryStat,randProf));
        }
        int maxHP = (int)(Math.random()*50) + getPrimaryStat(Stat.CONSTITUTION).getModifier()*5;
        this.hitPoints = new HitPoints(maxHP);
    }

    public Character(LinkedHashMap<String, Stat> defaultSkillList) {
            String[] randomFirstName = {"Novor","Beetle","Kaveh","Luca","Marls","Ghislaine","Elkana","Seok", "Ard", "Joshua", "Ethari", "Xeyllosh"};
            String[] randomLastName = {"Kamisato", "Shogun", "","","","","","","",""};
        this.name = randomFirstName[(int)(Math.random()*randomFirstName.length)] +" "+ randomLastName[(int)(Math.random()*randomLastName.length)];
            ArrayList<Element> randomElement = new ArrayList<>(Arrays.asList(new Anemo(), new Cryo(), new Dendro(), new Electro(), new Geo(), new Hydro(), new Pyro()));
        this.visionElement = randomElement.get((int)(Math.random()*7));

        this.elementalSkill = new ElementalSkillSummonTaunt();
        this.elementalBurst = new ElementalBurstDestructive(getVisionElement());

            Weapon[] randomWeapon = {new Sword(), new Claymore(), new Polearm(), new Bow(getVisionElement()), new Catalyst(getVisionElement())};
        this.weapon = randomWeapon[(int)(Math.random()*5)];
            Lineage[] randomSpecies = {new Human(), new Anthro(), new Adeptus(), new Yokai(), new Fontainian(), new Khaenriahn() };
        this.lineage = randomSpecies[(int)(Math.random()*6)];

        this.stamina = new Stamina();
        stamina.adjustCurrentStamina( -(int)(Math.random()*100), 0);

        this.primaryStats = new LinkedHashMap<>();
        this.savingThrows = new LinkedHashMap<>();
        this.skills = new LinkedHashMap<>();

        this.inspiration = new Inspiration(false);

        ArrayList<Stat> weaponSaveProfs = weapon.getSaveProficiencies();

        for (Stat value : Stat.values()) {
            int randScore = (int)(Math.random()*6)+1 + (int)(Math.random()*6)+1 + (int)(Math.random()*6)+1 + (int)(Math.random()*6)+1;

            primaryStats.put(value, new PrimaryStat(value.name(), randScore));

            boolean saveProf = false;
            if(weaponSaveProfs.contains(value)){
                saveProf = true;
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

        int maxHP = (int)(Math.random()*50) + getPrimaryStat(Stat.CONSTITUTION).getModifier()*5;
        this.hitPoints = new HitPoints(maxHP);
        this.hitPoints.setShieldHP((int)(Math.random()*50));
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

    public LinkedHashMap<Stat, PrimaryStat> getPrimaryStats() {
        return primaryStats;
    }
    public PrimaryStat getPrimaryStat(Stat key){
        return primaryStats.get(key);
    }
    public int getSaveDC(Stat key){return 8 + getProficiencyBonus() +getPrimaryStat(key).getModifier();}
    public int getToHit(Stat stat) {
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

    public LinkedHashMap<Stat, SavingThrow> getSavingThrows() {
        return savingThrows;
    }
    public SavingThrow getSavingThrow(Stat stat){
        return getSavingThrows().get(stat);
    }

    public HitPoints getHitPoints() {
        return hitPoints;
    }

    public int getArmorClass(){
        return 10 + getPrimaryStat(Stat.DEXTERITY).getModifier();
    }

    public int getInitiativeBonus(){
        return getPrimaryStat(Stat.DEXTERITY).getModifier();
    }

}
