import SheetComponents.*;
import SheetComponents.Elements.*;
import SheetComponents.Species.*;
import SheetComponents.Weapons.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;

public class CharacterSheet {

    private String name;

    private Element visionElement;
    private Weapon weapon;
    private Species species;

    private Stamina stamina;

    public enum stat {STRENGTH,DEXTERITY,CONSTITUTION,INTELLIGENCE,WISDOM,CHARISMA}

    private LinkedHashMap<stat, PrimaryStat> primaryStats;

    private final int proficiencyBonus =  3;
    private Inspiration inspiration;

    private LinkedHashMap<stat, SavingThrow> savingThrows;

    private LinkedHashMap<String, Skill> skills;

    private HitPoints hitPoints;

    public CharacterSheet(LinkedHashMap<String,stat> defaultSkillList) {
        String[] randomFirstName = {"Novor","Beetle","Kaveh","Luca","Marls","Ghislaine","Elkana","Seok", "Ard", "Joshua", "Ethari", "Xeyllosh"};
        String[] randomLastName = {"Kamisato", "Shogun", "","","","","","","",""};
        this.name = randomFirstName[(int)(Math.random()*randomFirstName.length)] +" "+ randomLastName[(int)(Math.random()*randomLastName.length)];
        ArrayList<Element> randomElement = new ArrayList<>(Arrays.asList(new Anemo(), new Cryo(), new Dendro(), new Electro(), new Geo(), new Hydro(), new Pyro()));
        int number = (int)(Math.random()*7);
        System.out.println(number);
        this.visionElement = randomElement.get(number);

            Weapon[] randomWeapon = {new Sword(), new Claymore(), new Polearm(), new Bow(), new Catalyst()};
        this.weapon = randomWeapon[(int)(Math.random()*5)];
            Species[] randomSpecies = {new Human(), new Anthro(), new Adeptus(), new Yokai(), new Fontainian(), new Khaenriahn() };
        this.species = randomSpecies[(int)(Math.random()*6)];

        this.stamina = new Stamina();
        stamina.adjustCurrentStamina( -(int)(Math.random()*100), 0);

        this.primaryStats = new LinkedHashMap<>();
        this.savingThrows = new LinkedHashMap<>();
        this.skills = new LinkedHashMap<>();

        this.inspiration = new Inspiration(false);

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
//        this.hitPoints.setElementalShield((int)(Math.random()*50), Element.DENDRO);
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
    public Species getSpecies(){return species;}

    public int getWalkingSpeed(){
        return getSpecies().getWalkingSpeed();
    }
    public Stamina getStamina() {
        return stamina;
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

    public Inspiration getInspiration(){
        return inspiration;
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

    public int getArmorClass(){
        return 10 + getPrimaryStat(stat.DEXTERITY).getModifier();
    }

    public int getInitiativeBonus(){
        return getPrimaryStat(stat.DEXTERITY).getModifier();
    }
}
