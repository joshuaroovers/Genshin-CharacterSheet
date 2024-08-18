package SheetComponents.Weapons;

import SheetComponents.Actions.AttackEffects.EffectDamage;
import SheetComponents.Actions.Attacks.Attack;
import SheetComponents.Actions.Attacks.Die;
import SheetComponents.Elements.Physical;
import SheetComponents.Stat;

import java.util.Arrays;

public class Polearm extends Weapon{

    private static final String BASIC_ATTACK_DESC = "fire an arrow";
    private static final String CHARGED_ATTACK_DESC = "fire an arrow infused with elemental energy";

    public Polearm() {
        this.basicAttackAmount = 3;
        this.description = "";
        this.basicAttack = new Attack(
                BASIC_ATTACK_DESC,
                10,
                Stat.DEXTERITY,
                new EffectDamage(Die.D8, 1, Stat.DEXTERITY, new Physical()),
                false,
                null);
        this.chargedAttack = new Attack(
                CHARGED_ATTACK_DESC,
                0,
                Stat.DEXTERITY,
                Stat.DEXTERITY,
                new EffectDamage(Die.D8, 1, Stat.DEXTERITY, new Physical()),
                false,
                Arrays.asList("20ft Line"));
    }
}
