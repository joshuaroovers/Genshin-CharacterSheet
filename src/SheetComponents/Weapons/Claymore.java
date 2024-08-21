package SheetComponents.Weapons;

import SheetComponents.Actions.AttackEffects.EffectDamage;
import SheetComponents.Actions.Attacks.Attack;
import SheetComponents.Actions.Attacks.Die;
import SheetComponents.Elements.Physical;
import SheetComponents.Stat;

public class Claymore extends Weapon{

    private static final String BASIC_ATTACK_NAME = "Normal Attack";
    private static final String BASIC_ATTACK_DESC = "fire an arrow";
    private static final String CHARGED_ATTACK_NAME = "Charged Attack";
    private static final String CHARGED_ATTACK_DESC = "fire an arrow infused with elemental energy";

    public Claymore() {
        this.basicAttackAmount = 2;
        this.description = "";
        this.basicAttack = new Attack(
                BASIC_ATTACK_NAME,
                BASIC_ATTACK_DESC,
                5,
                Stat.STRENGTH,
                new EffectDamage(Die.D12, 1, Stat.STRENGTH, new Physical()),
                false,
                null);
        this.chargedAttack = new Attack(
                CHARGED_ATTACK_NAME,
                CHARGED_ATTACK_DESC,
                5,
                Stat.STRENGTH,
                Stat.DEXTERITY,
                new EffectDamage(Die.D8, 1, Stat.STRENGTH, new Physical()),
                false,
                null);
    }
}
