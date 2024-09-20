package SheetComponents.Weapons;

import SheetComponents.Actions.AttackEffects.EffectDamage;
import SheetComponents.Actions.Attacks.Attack;
import SheetComponents.Actions.Attacks.Dice;
import SheetComponents.Elements.Physical;
import SheetComponents.Stat;

import java.util.Arrays;

public abstract class Weapon {

    int basicAttackAmount;
    String description;
    Attack unarmedStrike;
    Attack basicAttack;
    Attack chargedAttack;

    public Weapon(int unarmedStrikeAmount, int basicAttackAmount, String description, Attack basicAttack, Attack chargedAttack) {
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

    public Weapon(int basicAttackAmount, String description,Attack basicAttack, Attack chargedAttack) {
        this(basicAttackAmount, basicAttackAmount, description, basicAttack, chargedAttack);
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
}
