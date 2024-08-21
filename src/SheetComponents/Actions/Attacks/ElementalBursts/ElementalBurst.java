package SheetComponents.Actions.Attacks.ElementalBursts;

import SheetComponents.Actions.AttackEffects.Effect;
import SheetComponents.Actions.Attacks.Attack;
import SheetComponents.Actions.Attacks.ElementalSkills.ElementalSkill;
import SheetComponents.Elements.Element;
import SheetComponents.Stat;

import java.util.Collection;

public abstract class ElementalBurst extends Attack {

    private String customName;
    private final int requiredEnergy = 3;
    int currentEnergy;


    public ElementalBurst(String description, int range, Stat stat, Stat saveType, Effect effect, boolean appliesElement, Collection<String> notes) {
        super(null, description, range, stat, saveType, effect, appliesElement, notes);
        this.currentEnergy = 0;
    }

    public ElementalBurst(String description, int range, Stat stat, Effect effect, boolean appliesElement, Collection<String> notes) {
        super(null, description, range, stat, effect, appliesElement, notes);
        this.currentEnergy = 0;
    }

    private int getRequiredEnergy(){return requiredEnergy;}
    public int getCurrentEnergy() {
        return currentEnergy;
    }
    private void increaseEnergy(){if(currentEnergy+1 <= requiredEnergy){currentEnergy++;}}
    private void decreaseEnergy(){if(currentEnergy-1 >= 0){currentEnergy--;}}

    public void setCustomName(String customName) {
        this.customName = customName;
    }

    @Override
    public String getName() {
        if(!customName.isEmpty()){
            return customName;
        }else{
            int baseClassNameLength = ElementalBurst.class.getSimpleName().length();
            return getClass().getSimpleName().substring(baseClassNameLength);
        }
    }
}
