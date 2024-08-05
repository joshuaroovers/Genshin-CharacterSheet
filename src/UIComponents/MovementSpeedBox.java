package UIComponents;

import UIComponents.subUIComponents.ModifierBox;
import UIComponents.subUIComponents.SmallBasicBox;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MovementSpeedBox extends VBox {

    private final String labelText1 = "Movement";
    private final String labelText2 = "Speed";

    public MovementSpeedBox(int movementSpeed) {
        VBox mainBox = this;
        mainBox.getStyleClass().addAll("basic-container");
        mainBox.setAlignment(Pos.CENTER);


        VBox contentWrapper = new VBox();
        contentWrapper.setAlignment(Pos.CENTER);

        HBox content = new HBox();
        contentWrapper.getChildren().add(content);
        content.setAlignment(Pos.BOTTOM_CENTER);

        Label ftLabelSpacer = new Label("t."); //"ft." for equal spacing using "t." looks a bit better imo
        content.getChildren().add(ftLabelSpacer);
        ftLabelSpacer.getStyleClass().addAll("movement-ft-label");
        ftLabelSpacer.setVisible(false);

        Label movementLabel = new Label(Integer.toString(movementSpeed));
        content.getChildren().add(movementLabel);
        movementLabel.getStyleClass().addAll("movement-speed-label");

        Label ftLabel = new Label("ft.");
        content.getChildren().add(ftLabel);
        ftLabel.getStyleClass().addAll("movement-ft-label");

        SmallBasicBox basicBox = new SmallBasicBox(labelText1,labelText2, contentWrapper);
        basicBox.setStyle("-fx-border-color: black;");
        mainBox.getChildren().add(basicBox);
    }
}
