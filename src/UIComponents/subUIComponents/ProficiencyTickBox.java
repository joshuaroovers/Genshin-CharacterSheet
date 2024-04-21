package UIComponents.subUIComponents;

import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

public class ProficiencyTickBox extends StackPane {

    public ProficiencyTickBox(boolean proficient) {

        StackPane profBox = this;

        HBox profTick = new HBox();
        profTick.getStyleClass().addAll("proficiency-tick","proficiency-tick-empty");
        profBox.getChildren().add(profTick);

        if(proficient){
            HBox profTickFill = new HBox();
            profTickFill.getStyleClass().addAll("proficiency-tick","proficiency-tick-fill");
            profBox.getChildren().add(profTickFill);
        }
    }
}
