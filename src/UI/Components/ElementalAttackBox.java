package UI.Components;

import SheetComponents.Actions.Attacks.Attack;
import SheetComponents.Actions.Attacks.ElementalBursts.ElementalBurst;
import SheetComponents.Actions.Attacks.ElementalSkills.ElementalSkill;
import SheetComponents.Character;
import SheetComponents.Elements.Element;
import UI.Components.SubComponents.AttackBoxBase;
import UI.Util.ImageHelper;
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
