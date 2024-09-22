package GenshinCharacterSheet.UI.Components;

import GenshinCharacterSheet.UI.Components.SubComponents.SmallBasicBox;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ArmorClassBox extends VBox {

    private final String label1Text = "Armor";
    private final String label2Text = "Class";

    public ArmorClassBox(int AC) {
        VBox mainBox = this;
        mainBox.getStyleClass().addAll("basic-container","armor-class-box");

        HBox contentWrapper = new HBox();


        HBox ACBox = new HBox();
        ACBox.setAlignment(Pos.CENTER);
        Label ACLabel = new Label(Integer.toString(AC));
        ACLabel.getStyleClass().addAll("armor-class-score");
        ACBox.getChildren().add(ACLabel);

        SmallBasicBox baseBox = new SmallBasicBox(label1Text, label2Text, ACBox );
        mainBox.getChildren().add(baseBox);
    }
}
