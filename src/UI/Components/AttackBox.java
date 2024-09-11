package UI.Components;

import SheetComponents.Actions.Attacks.Attack;
import SheetComponents.Actions.Attacks.ElementalBursts.ElementalBurst;
import SheetComponents.Character;
import SheetComponents.Weapons.Weapon;
import UI.Components.SubComponents.AttackBoxBase;
import UI.Util.ImageHelper;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class AttackBox extends HBox {
    //components width add up to 690 (230 per section) (700 is absolute with minus 5*2 for padding)

    public AttackBox(Character character, Weapon weapon, Attack attack) {
        HBox mainBox = this;

        String weaponURL = ImageHelper.getWeaponURL(weapon);

        AttackBoxBase attackBoxBase = new AttackBoxBase(character, weaponURL, attack);
        mainBox.getChildren().add(attackBoxBase);
    }
}
