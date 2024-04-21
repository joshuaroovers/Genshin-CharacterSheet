package UIComponents;

import SheetComponents.SavingThrow;
import UIComponents.subUIComponents.ModifierBox;
import UIComponents.subUIComponents.ProficiencyTickBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class SavingThrowBox extends VBox {

    public SavingThrowBox(SavingThrow savingThrow, int proficiencyBonus) {
        VBox mainBox = this;
        mainBox.getStyleClass().add("saves-box");

        HBox secondBox = new HBox();
        mainBox.getChildren().add(secondBox);


        //#region prof
        ProficiencyTickBox proficiencyTickBox = new ProficiencyTickBox(savingThrow.isProficient());
        secondBox.getChildren().add(proficiencyTickBox);
        //#endregion prof

        //#region primaryStatAbbreviation
        HBox primaryStatAbbrev = new HBox();
        primaryStatAbbrev.getStyleClass().addAll("save-stat-box");
        secondBox.getChildren().add(primaryStatAbbrev);

        Label modLabel = new Label(savingThrow.getStat().getNameAbbreviation());
        primaryStatAbbrev.getChildren().add(modLabel);
        //#endregion primaryStatAbbreviation

        //#region bonus
        ModifierBox modifierBox = new ModifierBox(savingThrow.getStat().getModifier(),savingThrow.isProficient(),proficiencyBonus);
        modifierBox.getStyleClass().add("");
        secondBox.getChildren().add(modifierBox);
        //#endregion
    }
}
