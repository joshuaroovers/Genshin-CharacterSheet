package Components;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class PrimaryStatBox extends VBox {

    public PrimaryStatBox(String name, int score, String modifier) {
        VBox mainBox = this;
        this.getStyleClass().addAll("primary-stat-box","basic-container");

        HBox nameBox = new HBox();
        Label nameLabel = new Label(name);
        nameLabel.getStyleClass().add("primary-stat-label");
        nameBox.getChildren().add(nameLabel);

        HBox scoreBox = new HBox();
        Label scoreLabel = new Label(Integer.toString(score));
        scoreLabel.getStyleClass().add("primary-stat-score");
        scoreBox.getChildren().add(scoreLabel);

        HBox modifierBox = new HBox();
        modifierBox.getStyleClass().add("primary-stat-mod-box");

        String prefix = modifier.substring(0,1);
        Label modifierPrefixLabel = new Label(prefix);
        modifierPrefixLabel.getStyleClass().add("primary-stat-mod-prefix");
        Label modifierLabel = new Label(modifier.substring(1));
        modifierLabel.getStyleClass().add("primary-stat-mod");
        modifierBox.getChildren().addAll(modifierPrefixLabel,modifierLabel);


        mainBox.getChildren().addAll(nameBox,scoreBox,modifierBox);

//        return mainBox;
    }
}
