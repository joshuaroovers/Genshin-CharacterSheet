package GenshinCharacterSheet.SheetComponents.Weapons;

import GenshinCharacterSheet.SheetComponents.Actions.AttackEffects.EffectDamage;
import GenshinCharacterSheet.SheetComponents.Actions.Attacks.Attack;
import GenshinCharacterSheet.SheetComponents.Actions.Attacks.Dice;
import GenshinCharacterSheet.SheetComponents.Elements.Physical;
import GenshinCharacterSheet.SheetComponents.Stat;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Weapon {

    int basicAttackAmount;
    String description;
    Attack unarmedStrike;
    Attack basicAttack;
    Attack chargedAttack;
    ArrayList<Stat> saveProficiencies;
    //TODO hitdice

    public Weapon(int unarmedStrikeAmount, int basicAttackAmount, String description, Attack basicAttack, Attack chargedAttack, ArrayList<Stat> saveProficiencies) {
        this.saveProficiencies = saveProficiencies;
        this.basicAttackAmount = basicAttackAmount;
        this.description = description;
        this.unarmedStrike = new Attack(
                "Unarmed Strike",
                "",
                5,
                Stat.STRENGTH,
                new EffectDamage(Dice.D1, 1, Stat.STRENGTH, new Physical()),
                false,
                Arrays.asList(unarmedStrikeAmount+" Attacks"));
        this.basicAttack = basicAttack;
        this.chargedAttack = chargedAttack;
    }

    public Weapon(int basicAttackAmount, String description,Attack basicAttack, Attack chargedAttack, ArrayList<Stat> saveProficiencies) {
        this(basicAttackAmount, basicAttackAmount, description, basicAttack, chargedAttack, saveProficiencies);
    }

    public String getName(){
        return getClass().getSimpleName();
    }

    public int getBasicAttackAmount() {
        return basicAttackAmount;
    }

    public String getDescription() {
        return description;
    }

    public Attack getBasicAttack() {
        return basicAttack;
    }

    public Attack getChargedAttack() {
        return chargedAttack;
    }

    public Attack getUnarmedStrike() {
        return unarmedStrike;
    }

    public ArrayList<Stat> getSaveProficiencies() {
        return saveProficiencies;
    }
}
