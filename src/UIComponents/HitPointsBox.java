package UIComponents;

import SheetComponents.HitPoints;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class HitPointsBox extends HBox {

    private TextField healDmgInputBox;

    public HitPointsBox(HitPoints hitPoints) {
        HBox mainBox = this;

        //#region heal/damage buttons area
        VBox healDmgBox = new VBox();
        mainBox.getChildren().add(healDmgBox);

        //#region heal button
        Button healButton = new Button("Heal");
        healDmgBox.getChildren().add(healButton);

        healButton.setOnAction(e ->{
            hitPoints.adjustCurrentHP(Integer.parseInt(healDmgInputBox.getText()));
        });


        //#endregion heal button
        //#region healDmgInputBox
        healDmgInputBox = new TextField();
        //#endregion healDmgInputBox
        //#region dmg button
        Button dmgButton = new Button("Damage");
        healDmgBox.getChildren().add(dmgButton);

        dmgButton.setOnAction(e ->{
            hitPoints.adjustCurrentHP(-Integer.parseInt(healDmgInputBox.getText()));
        });
        //#endregion dmg button

        //#endregion heal/damage buttons area
    }
}
