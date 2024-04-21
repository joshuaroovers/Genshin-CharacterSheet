package UIComponents;

import SheetComponents.Skill;
import UIComponents.subUIComponents.ModifierBox;
import UIComponents.subUIComponents.ProficiencyTickBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class SkillBox extends VBox {

    public SkillBox(Skill skill, int proficiencyBonus){
        VBox mainBox = this;

        HBox secondBox = new HBox();
        secondBox.getStyleClass().add("skill-box-base");
        mainBox.getChildren().add(secondBox);

        //#region prof
        ProficiencyTickBox proficiencyTickBox = new ProficiencyTickBox(skill.isProficient());
        proficiencyTickBox.getStyleClass().add("skill-proficiency-box");
        secondBox.getChildren().add(proficiencyTickBox);
        //#endregion prof

        //#region primaryStatAbbreviation
        HBox primaryStatAbbrev = new HBox();
        primaryStatAbbrev.getStyleClass().addAll("skill-stat-box");
        secondBox.getChildren().add(primaryStatAbbrev);

        Label modLabel = new Label(skill.getStat().getNameAbbreviation());
        primaryStatAbbrev.getChildren().add(modLabel);
        //#endregion primaryStatAbbreviation

        //#region name
        HBox nameBox = new HBox();
        nameBox.getStyleClass().addAll("skill-name-box");
        secondBox.getChildren().add(nameBox);

        Label nameLabel = new Label(skill.getName());
        nameBox.getChildren().add(nameLabel);
        //#endregion name

        //#region bonus
        ModifierBox bonusBox = new ModifierBox(skill.getStat().getModifier(), skill.isProficient(), proficiencyBonus);
        bonusBox.getStyleClass().addAll("skill-bonus-box");
        secondBox.getChildren().add(bonusBox);
        //#endregion bonus
    }
}
