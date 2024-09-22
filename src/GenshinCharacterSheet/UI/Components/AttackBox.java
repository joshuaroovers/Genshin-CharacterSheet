package GenshinCharacterSheet.UI.Components;

import GenshinCharacterSheet.SheetComponents.Actions.Attacks.Attack;
import GenshinCharacterSheet.SheetComponents.Character;
import GenshinCharacterSheet.SheetComponents.Weapons.Weapon;
import GenshinCharacterSheet.UI.Components.SubComponents.AttackBoxBase;
import GenshinCharacterSheet.UI.Util.ImageHelper;
import javafx.scene.layout.HBox;

public class AttackBox extends HBox {
    //components width add up to 690 (230 per section) (700 is absolute with minus 5*2 for padding)

    public AttackBox(Character character, Weapon weapon, Attack attack) {
        HBox mainBox = this;

        String weaponURL = ImageHelper.getWeaponURL(weapon);

        AttackBoxBase attackBoxBase = new AttackBoxBase(character, weaponURL, attack);
        mainBox.getChildren().add(attackBoxBase);
    }
}
