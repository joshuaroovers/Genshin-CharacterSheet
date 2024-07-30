package UIComponents;

import UIComponents.subUIComponents.ModifierBox;
import UIComponents.subUIComponents.SmallBasicBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class InitiativeBox extends VBox {

    private final String labelText = "Initiative";

    public InitiativeBox(int initiativeBonus){
        VBox mainBox = this;
        mainBox.getStyleClass().addAll("basic-container");

        ModifierBox initiativeModifierBox = new ModifierBox(initiativeBonus);
        initiativeModifierBox.getStyleClass().add("initiative-modifier-box");

        SmallBasicBox basicBox = new SmallBasicBox(SmallBasicBox.labelPosition.TOP, labelText, initiativeModifierBox);
        mainBox.getChildren().add(basicBox);

    }
}
