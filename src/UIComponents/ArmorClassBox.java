package UIComponents;

import UIComponents.subUIComponents.SmallBasicBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ArmorClassBox extends VBox {

    private final String label1Text = "Armor";
    private final String label2Text = "Class";

    public ArmorClassBox(int AC) {
        VBox mainBox = this;
        mainBox.getStyleClass().add("armor-class-box");

        HBox ACBox = new HBox();
        Label ACLabel = new Label(Integer.toString(AC));
        ACLabel.getStyleClass().add("armor-class-score");
        ACBox.getChildren().add(ACLabel);

        SmallBasicBox baseBox = new SmallBasicBox(label1Text, label2Text, ACBox );
        mainBox.getChildren().add(baseBox);
    }
}
