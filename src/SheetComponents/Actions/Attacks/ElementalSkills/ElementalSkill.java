package SheetComponents.Actions.Attacks.ElementalSkills;

import SheetComponents.Actions.Action;
import SheetComponents.Actions.AttackEffects.Effect;
import SheetComponents.Actions.Attacks.Attack;
import SheetComponents.Actions.Attacks.ElementalBursts.ElementalBurst;
import SheetComponents.Elements.Element;
import SheetComponents.Stat;

import java.util.Collection;

public abstract class ElementalSkill extends Attack {

    private String customName;

    public ElementalSkill(String description, int range, Stat stat, Stat saveType, Effect effect, boolean appliesElement, Collection<String> notes) {
        super(description, range, stat, saveType, effect, appliesElement, notes);
    }

    public ElementalSkill(String description, int range, Stat stat, Effect effect, boolean appliesElement, Collection<String> notes) {
        super(description, range, stat, effect, appliesElement, notes);
    }

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
