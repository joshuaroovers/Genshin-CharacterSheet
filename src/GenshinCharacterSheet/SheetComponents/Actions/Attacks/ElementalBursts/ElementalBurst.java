package GenshinCharacterSheet.SheetComponents.Actions.Attacks.ElementalBursts;

import GenshinCharacterSheet.SheetComponents.Actions.AttackEffects.Effect;
import GenshinCharacterSheet.SheetComponents.Actions.Attacks.Attack;
import GenshinCharacterSheet.SheetComponents.PrimaryStats;

import java.util.Collection;

public abstract class ElementalBurst extends Attack {

    public static final String NAME_BASE = "Elemental Burst: \n";
    private String customName;
    private final int requiredEnergy = 3;
    int currentEnergy;


    public ElementalBurst(String name, String description, int range, PrimaryStats stat, PrimaryStats saveType, Effect effect, boolean appliesElement, Collection<String> notes) {
        super(name, description, range, stat, saveType, effect, appliesElement, notes);
        this.currentEnergy = 0;
    }

    public ElementalBurst(String name, String description, int range, PrimaryStats stat, Effect effect, boolean appliesElement, Collection<String> notes) {
        super(name, description, range, stat, effect, appliesElement, notes);
        this.currentEnergy = 0;
    }

    private int getRequiredEnergy(){return requiredEnergy;}
    public int getCurrentEnergy() {
        return currentEnergy;
    }
    private void increaseEnergy(){if(currentEnergy+1 <= requiredEnergy){currentEnergy++;}}
    private void decreaseEnergy(){if(currentEnergy-1 >= 0){currentEnergy--;}}

    public void setCustomName(String customName) {
        if(customName == null || customName.isEmpty()){
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
