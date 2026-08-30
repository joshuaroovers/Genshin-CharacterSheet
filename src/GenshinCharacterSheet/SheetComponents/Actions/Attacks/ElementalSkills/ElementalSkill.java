package GenshinCharacterSheet.SheetComponents.Actions.Attacks.ElementalSkills;

import GenshinCharacterSheet.SheetComponents.Actions.AttackEffects.Effect;
import GenshinCharacterSheet.SheetComponents.Actions.Attacks.Attack;
import GenshinCharacterSheet.SheetComponents.PrimaryStats;

import java.util.Collection;

public abstract class ElementalSkill extends Attack {

    public static final String NAME_BASE = "Elemental Skill: \n";
    private String customName;

    public ElementalSkill(String name, String description, int range, PrimaryStats stat, PrimaryStats saveType, Effect effect, boolean appliesElement, Collection<String> notes) {
        super(name, description, range, stat, saveType, effect, appliesElement, notes);
    }

    public ElementalSkill(String name, String description, int range, PrimaryStats stat, Effect effect, boolean appliesElement, Collection<String> notes) {
        super(name, description, range, stat, effect, appliesElement, notes);
    }

    public void setCustomName(String customName) {
        if(customName.isEmpty()){
            this.customName = null;
        }else{
            this.customName = customName;
        }
    }

    public String getCustomName() {
        if(customName == null){
            return super.getName();
        }else{
            return customName;
        }
    }

    @Override
    public String getName() {

        if(customName != null){
            return NAME_BASE+customName;
        }else{
            return NAME_BASE+super.getName();
        }
    }
}
