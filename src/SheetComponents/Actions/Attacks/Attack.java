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

    protected String name;
    int range;
    boolean isSave;
    Stat saveType;
    Stat stat;
    Effect effect;
    boolean appliesElement;
    ArrayList<String> notes;


    private Attack(String name, String description, int range, Stat stat, boolean isSave, Stat saveType, Effect effect, boolean appliesElement, Collection<String> notes){
        this.name = name;
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
    public Attack(String name, String description, int range, Stat stat, Stat saveType, Effect effect, boolean appliesElement, Collection<String> notes) {
        this(name, description, range, stat, true, saveType, effect, appliesElement, notes);
    }
    public Attack(String name, String description, int range, Stat stat, Effect effect, boolean appliesElement, Collection<String> notes) {
        this(name, description, range, stat, false, null, effect, appliesElement, notes);
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
    public PrimaryStat getSaveType(Character character){
        //TODO not ideal should really make Stat a class
        return character.getPrimaryStat(saveType);
    };

    public String getRange() {
        if(range == 0){
            return "self";
        }else{
            return range+"ft";
        }
    }

    public Effect getEffect() {
        return effect;
    }

    @Override
    public String getName() {
        return name;
    }

    public ArrayList<String> getNotes() {
        return notes;
    }

    public boolean appliesElement() {
        return appliesElement;
    }
}
