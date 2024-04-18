package FXComponents;

import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class SkillBox extends VBox {

    public SkillBox(String skillName, boolean proficient, String primaryStatAbrev, int bonus, int profBonus){
        VBox mainBox = this;
        mainBox.setStyle("-fx-padding: 5 0 5 0;");

        HBox secondBox = new HBox();
        secondBox.getStyleClass().add("skill-box-base");
        mainBox.getChildren().add(secondBox);

        //#region prof
        HBox profBox = new HBox();
        profBox.getStyleClass().addAll("skill-prof-second","skill-proficiency-box");
        secondBox.getChildren().add(profBox);

        HBox profTick = new HBox();
        profTick.getStyleClass().add("skill-proficiency-tick");
        if(proficient)
            profTick.getStyleClass().add("skill-proficiency-tick-proficient");
        profBox.getChildren().add(profTick);
        //#endregion prof

        //#region mod
        HBox modBox = new HBox();
        modBox.getStyleClass().addAll("skill-prof-second","skill-modifier-box");
        secondBox.getChildren().add(modBox);

        Label modLabel = new Label(primaryStatAbrev);
        modBox.getChildren().add(modLabel);
        //#endregion mod

        //#region name
        HBox nameBox = new HBox();
        nameBox.getStyleClass().addAll("skill-prof-second2","skill-name-box");
        secondBox.getChildren().add(nameBox);

        Label nameLabel = new Label(skillName);
        nameBox.getChildren().add(nameLabel);
        //#endregion name

        //#region bonus
        HBox bonusBox = new HBox();
        bonusBox.getStyleClass().addAll("skill-prof-second","skill-bonus-box");
        secondBox.getChildren().add(bonusBox);

        int finalBonus = bonus;
        if(proficient){
            finalBonus += profBonus;
        }

        String bonusString = "";
        if(finalBonus >= 0){
            bonusString = "+"+finalBonus;
        }else{
            bonusString = ""+finalBonus;
        }

        Label bonusLabel = new Label(bonusString);
        bonusBox.getChildren().add(bonusLabel);
        //#endregion bonus
    }
}
