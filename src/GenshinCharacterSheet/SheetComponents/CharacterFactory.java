package GenshinCharacterSheet.SheetComponents;

import GenshinCharacterSheet.SheetComponents.Actions.Attacks.ElementalBursts.ElementalBurst;
import GenshinCharacterSheet.SheetComponents.Actions.Attacks.ElementalBursts.ElementalBurstDestructive;
import GenshinCharacterSheet.SheetComponents.Actions.Attacks.ElementalSkills.ElementalSkill;
import GenshinCharacterSheet.SheetComponents.Actions.Attacks.ElementalSkills.ElementalSkillSummonTaunt;
import GenshinCharacterSheet.SheetComponents.Elements.*;
import GenshinCharacterSheet.SheetComponents.Lineage.*;
import GenshinCharacterSheet.SheetComponents.Weapons.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class CharacterFactory {

    private static String[] randomFirstName = {"Novor","Beetle","Kaveh","Luca","Miles","Ghislaine","L","Seok", "Ard", "Joshua", "Ethari", "Xeyllosh", "Goose"};
    private static String[] randomLastName = {"Kamisato", "Shogun", "","","","","","","",""};

    public static Character random() {

        String name = randomFirstName[(int)(Math.random()*randomFirstName.length)] +" "+ randomLastName[(int)(Math.random()*randomLastName.length)];
        ArrayList<Element> randomElement = Elements.ALL;
        Element visionElement = randomElement.get((int)(Math.random()*7));

        ElementalSkill elementalSkill = new ElementalSkillSummonTaunt();
        ElementalBurst elementalBurst = new ElementalBurstDestructive(visionElement);

        Weapon[] randomWeapon = {new Sword(), new Claymore(), new Polearm(), new Bow(visionElement), new Catalyst(visionElement)};
        Weapon weapon = randomWeapon[(int)(Math.random()*5)];
        Lineage[] randomSpecies = {new Human(), new Anthro(), new Adeptus(), new Yokai(), new Fontainian(), new Khaenriahn() };
        Lineage lineage = randomSpecies[(int)(Math.random()*6)];

        Stamina stamina = new Stamina();
        stamina.adjustCurrentStamina( -(int)(Math.random()*100), 0);

        LinkedHashMap<PrimaryStats, Integer> primaryStatValues = new LinkedHashMap<>();
        ArrayList<String> skills = new ArrayList<>();

        for (PrimaryStats value : PrimaryStats.values()) {
            int randScore = (int)(Math.random()*6)+1 + (int)(Math.random()*6)+1 + (int)(Math.random()*6)+1 + (int)(Math.random()*6)+1;

            primaryStatValues.put(value, randScore);
        }


        for (String skillName : Skills.defaultSkills.keySet()) {

            if(Math.random()*5 > 4){
                System.out.println("random prof in: " +skillName);
                skills.add(skillName);
            }

        }

        return new Character(name, visionElement, weapon, lineage, primaryStatValues, skills, elementalBurst, elementalSkill);
    }
}
