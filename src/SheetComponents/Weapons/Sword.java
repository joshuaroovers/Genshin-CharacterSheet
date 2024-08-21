package SheetComponents.Weapons;

import SheetComponents.Actions.AttackEffects.EffectDamage;
import SheetComponents.Actions.Attacks.Attack;
import SheetComponents.Actions.Attacks.Die;
import SheetComponents.Elements.Physical;
import SheetComponents.Stat;

public class Sword extends Weapon{

    private static final String BASIC_ATTACK_NAME = "Normal Attack";
    private static final String BASIC_ATTACK_DESC = "";
    private static final String CHARGED_ATTACK_NAME = "Charged Attack";
    private static final String CHARGED_ATTACK_DESC = "fire an arrow infused with elemental energy";

    public Sword() {
        this.basicAttackAmount = 3;
        this.description = "";
        this.basicAttack = new Attack(
                BASIC_ATTACK_NAME,
                BASIC_ATTACK_DESC,
                5,
                Stat.DEXTERITY,
                new EffectDamage(Die.D8, 1, Stat.DEXTERITY, new Physical()),
                false,
                null);
        this.chargedAttack = new Attack(
                CHARGED_ATTACK_NAME,
                CHARGED_ATTACK_DESC,
                5,
                Stat.DEXTERITY,
                Stat.DEXTERITY,
                new EffectDamage(Die.D8, 1, Stat.DEXTERITY, new Physical()),
                false,
                null);
    }
}
