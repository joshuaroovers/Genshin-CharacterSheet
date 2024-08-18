package SheetComponents.Actions.Attacks;

import SheetComponents.Actions.Action;
import SheetComponents.Actions.AttackEffects.Effect;
import SheetComponents.Character;
import SheetComponents.Elements.Element;
import SheetComponents.PrimaryStat;
import SheetComponents.Stat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Attack extends Action {

    int range;
    boolean isSave;
    Stat saveType;
    Stat stat;
    Effect effect;
    boolean appliesElement;
    ArrayList<String> notes;


    private Attack(String description, int range, Stat stat, boolean isSave, Stat saveType, Effect effect, boolean appliesElement, Collection<String> notes){
        this.description = description;
        this.range = range;
        this.isSave = isSave;
        this.saveType = saveType;
        this.stat = stat;
        this.effect = effect;
        this.appliesElement = appliesElement;
        this.notes = new ArrayList<>();
        if(notes != null){
            Arrays.sort(notes.toArray());
            this.notes.addAll(notes);
        }
    }
    public Attack(String description, int range, Stat stat, Stat saveType, Effect effect, boolean appliesElement, Collection<String> notes) {
        this(description, range, stat, true, saveType, effect, appliesElement, notes);
    }
    public Attack(String description, int range, Stat stat, Effect effect, boolean appliesElement, Collection<String> notes) {
        this(description, range, stat, false, null, effect, appliesElement, notes);
    }

    public PrimaryStat getStat(Character character) {
        return character.getPrimaryStat(stat);
    }

    public int getToHit(Character character){
        return character.getToHit(stat);
    }

    public boolean isSave() {
        return isSave;
    }
    public int getSaveDC(Character character){
        return character.getSaveDC(stat);
    };

    public String getRange() {
        if(range == 0){
            return "self";
        }else{
            return Integer.toString(range);
        }
    }

    @Override
    public String getName() {
        return getClass().getSimpleName();
    }
}
