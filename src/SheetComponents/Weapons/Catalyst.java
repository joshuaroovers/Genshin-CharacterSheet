package SheetComponents.Weapons;

import SheetComponents.Actions.AttackEffects.EffectDamage;
import SheetComponents.Actions.Attacks.Attack;
import SheetComponents.Actions.Attacks.Die;
import SheetComponents.Elements.Element;
import SheetComponents.Stat;

import java.util.Arrays;

public class Catalyst extends Weapon{

    private static final String BASIC_ATTACK_DESC = "attack with a burst of elemental energy";
    private static final String CHARGED_ATTACK_DESC = "big effect wow";

    //would melee catalyst be strength or dex based?
    public Catalyst(Element visionElement) {
        this.basicAttackAmount = 2;
        this.description = "";
        this.basicAttack = new Attack(
                BASIC_ATTACK_DESC,
                60,
                Stat.INTELLIGENCE,
                new EffectDamage(Die.D10, 1, Stat.INTELLIGENCE, visionElement),
                true,
                null);
        this.chargedAttack = new Attack(
                CHARGED_ATTACK_DESC,
                0,
                Stat.INTELLIGENCE,
                Stat.DEXTERITY,
                new EffectDamage(Die.D6, 2, Stat.INTELLIGENCE, visionElement),
                true,
                Arrays.asList("15ft cone"));
    }
}
