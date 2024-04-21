package UIComponents.subUIComponents;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class ModifierBox extends HBox {

    public ModifierBox(int bonus, boolean proficient, int proficiencyBonus) {
        HBox modifierBox = this;

        int finalModifier = bonus;
        if(proficient){
            finalModifier += proficiencyBonus;
        }

        String modifierString;
        if(finalModifier >= 0){
            modifierString = "+"+finalModifier;
        }else{
            modifierString = ""+finalModifier;
        }

        String prefix = modifierString.substring(0,1);
        String number = modifierString.substring(1);

        HBox subContainer = new HBox();
        subContainer.getStyleClass().add("modifier-box");

        Label modifierPrefixLabel = new Label(prefix);
        modifierPrefixLabel.getStyleClass().add("modifier-prefix");
        Label modifierLabel = new Label(number);
        modifierLabel.getStyleClass().add("modifier");
        subContainer.getChildren().addAll(modifierPrefixLabel,modifierLabel);

        modifierBox.getChildren().add(subContainer);
    }

    public ModifierBox(int bonus) {
        this(bonus, false, 0);
    }
}
