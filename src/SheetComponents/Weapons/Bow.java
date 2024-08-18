package SheetComponents.Weapons;

import SheetComponents.Actions.AttackEffects.EffectDamage;
import SheetComponents.Actions.Attacks.Attack;
import SheetComponents.Actions.Attacks.Die;
import SheetComponents.Elements.Element;
import SheetComponents.Elements.Physical;
import SheetComponents.Stat;

public class Bow extends Weapon{

    private static final String BASIC_ATTACK_DESC = "fire an arrow";
    private static final String CHARGED_ATTACK_DESC = "fire an arrow infused with elemental energy";

    public Bow(Element visionElement) {
        this.basicAttackAmount = 5;
        this.description = "";
        this.basicAttack = new Attack(
                BASIC_ATTACK_DESC,
                60,
                Stat.DEXTERITY,
                new EffectDamage(Die.D6, 1, Stat.DEXTERITY, new Physical()),
                false,
                null);
        this.chargedAttack = new Attack(
                CHARGED_ATTACK_DESC,
                120,
                Stat.DEXTERITY,
                new EffectDamage(Die.D6, 2, Stat.DEXTERITY, visionElement),
                true,
                null);
    }
}
