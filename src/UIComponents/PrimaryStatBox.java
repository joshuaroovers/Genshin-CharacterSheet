package UIComponents;

import SheetComponents.PrimaryStat;
import UIComponents.subUIComponents.ModifierBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class PrimaryStatBox extends VBox {

    public PrimaryStatBox(PrimaryStat primaryStat) {
        VBox mainBox = this;
        this.getStyleClass().addAll("primary-stat-box","basic-container");

        //#region name
        HBox nameBox = new HBox();
        Label nameLabel = new Label(primaryStat.getName());
        nameLabel.getStyleClass().add("primary-stat-label");
        nameBox.getChildren().add(nameLabel);
        //#endregion name
        //#region score
        HBox scoreBox = new HBox();
        Label scoreLabel = new Label(Integer.toString(primaryStat.getScore()));
        scoreLabel.getStyleClass().add("primary-stat-score");
        scoreBox.getChildren().add(scoreLabel);
        //#endregion score
        //#region bonus
        ModifierBox modifierBox = new ModifierBox(primaryStat.getModifier());
        modifierBox.getStyleClass().add("primary-stat-mod-box");
        //#endregion bonus

        mainBox.getChildren().addAll(nameBox,scoreBox,modifierBox);

//        return mainBox;
    }
}
