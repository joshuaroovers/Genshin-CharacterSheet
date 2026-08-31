package GenshinCharacterSheet.UI.Components;

import GenshinCharacterSheet.SheetComponents.PrimaryStat;
import GenshinCharacterSheet.SheetComponents.SkillProficiency;
import GenshinCharacterSheet.UI.Components.SubComponents.ModifierBox;
import GenshinCharacterSheet.UI.Components.SubComponents.ProficiencyTickBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class SkillBox extends VBox {

    public SkillBox(SkillProficiency skill, int proficiencyBonus, PrimaryStat primaryStat){
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

        Label modLabel = new Label(primaryStat.getNameAbbreviation());
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
        ModifierBox bonusBox = new ModifierBox(primaryStat.getModifier(), skill.isProficient(), proficiencyBonus);
        bonusBox.getStyleClass().addAll("skill-bonus-box");
        secondBox.getChildren().add(bonusBox);
        //#endregion bonus
    }
}
