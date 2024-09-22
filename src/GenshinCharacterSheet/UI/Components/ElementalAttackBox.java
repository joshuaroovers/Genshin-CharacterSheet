package GenshinCharacterSheet.UI.Components;

import GenshinCharacterSheet.SheetComponents.Actions.Attacks.ElementalBursts.ElementalBurst;
import GenshinCharacterSheet.SheetComponents.Actions.Attacks.ElementalSkills.ElementalSkill;
import GenshinCharacterSheet.SheetComponents.Character;
import GenshinCharacterSheet.SheetComponents.Elements.Element;
import GenshinCharacterSheet.UI.Components.SubComponents.AttackBoxBase;
import GenshinCharacterSheet.UI.Util.ImageHelper;
import javafx.scene.layout.HBox;

public class ElementalAttackBox extends HBox {
    //components width add up to 690 (230 per section) (700 is absolute with minus 5*2 for padding)

    public ElementalAttackBox(Character character, Element element, ElementalBurst attack) {
        HBox mainBox = this;

        String elementURL = ImageHelper.getAttackUnitURL(element);

        AttackBoxBase attackBoxBase = new AttackBoxBase(character, elementURL, attack);
        mainBox.getChildren().add(attackBoxBase);
    }

    public ElementalAttackBox(Character character, Element element, ElementalSkill attack) {
        HBox mainBox = this;

        String elementURL = ImageHelper.getAttackUnitURL(element);

        AttackBoxBase attackBoxBase = new AttackBoxBase(character, elementURL, attack);
        mainBox.getChildren().add(attackBoxBase);
    }
}
