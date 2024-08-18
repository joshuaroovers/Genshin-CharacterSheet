package SheetComponents.Weapons;

import SheetComponents.Actions.Attacks.Attack;

public abstract class Weapon {

    int basicAttackAmount;
    String description;
    Attack basicAttack;
    Attack chargedAttack;

    public String getName(){
        return getClass().getSimpleName();
    }
}
