package UI;

import SheetComponents.*;
import SheetComponents.Character;
import UI.Components.*;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CharacterSheet extends BorderPane {

    public CharacterSheet(Character character, int boxSpacing, Stage stage) {
        BorderPane mainPane = this;

        HBox mainSheetWrapper = new HBox();
        mainPane.setCenter(mainSheetWrapper);
        mainSheetWrapper.setStyle("-fx-alignment: center; -fx-padding: "+boxSpacing+" 0 0 0;");

        VBox mainSheetPane = new VBox(boxSpacing);
        mainSheetWrapper.getChildren().add(mainSheetPane);
        mainSheetPane.setStyle("-fx-pref-width: " + (12*100+11*20)+";");

//        HBox firstRowWrapper = new HBox();
//        mainSheetPane.getChildren().add(firstRowWrapper);

        BorderPane firstRow = new BorderPane();
        mainPane.setTop(firstRow);
        firstRow.setStyle("-fx-pref-width: " + 9999999);

        firstRow.setLeft(new NameCard(character.getVisionElement(), character.getName(), character.getLineage(), character.getWeapon()));

        //#region settings button
        HBox tempWrapper = new HBox();
        tempWrapper.getStyleClass().add("settings-button-container");

        HBox tempSettings = new HBox();
        tempWrapper.getChildren().add(tempSettings);
        tempSettings.getStyleClass().add("settings-button");
        tempSettings.getStyleClass().add(character.getVisionElement().getName());
        firstRow.setRight(tempWrapper);
        //#endregion


        HBox secondRow = new HBox(boxSpacing);
        mainSheetPane.getChildren().add(secondRow);

        for (Stat key : character.getPrimaryStats().keySet()) {
            PrimaryStat stat = character.getPrimaryStat(key);
            secondRow.getChildren().add(new PrimaryStatBox(stat));
        }

        secondRow.getChildren().add(new InspirationBox(character.getInspiration(), character.getVisionElement()));
        secondRow.getChildren().add(new ArmorClassBox(character.getArmorClass()));
        secondRow.getChildren().add(new HitPointsBox(character.getHitPoints()));


        HBox thirdRow = new HBox(boxSpacing);
        mainSheetPane.getChildren().add(thirdRow);

        VBox leftPane = new VBox(boxSpacing);
        thirdRow.getChildren().add(leftPane);

        //#region saves
        HBox savesBox = new HBox(boxSpacing);
        leftPane.getChildren().add(savesBox);
        for (Stat key : character.getPrimaryStats().keySet()) {
            SavingThrow save = character.getSavingThrow(key);
            savesBox.getChildren().add(new SavingThrowBox(save, character.getProficiencyBonus()));
        }
        //#endregion saves

        //#region skills
        HBox skills = new HBox(boxSpacing);
        leftPane.getChildren().add(skills);

        VBox skillsLeft = new VBox();
        VBox skillsRight = new VBox();

        skills.getChildren().addAll(skillsLeft,skillsRight);

        String[] skillNames = character.getSkills().keySet().toArray(new String[character.getSkills().keySet().size()]);
        for (int i = 0; i < skillNames.length; i++) {
            Skill currentSkill = character.getSkill(skillNames[i]);
            SkillBox newSkillBox = new SkillBox(
                    currentSkill,
                    character.getProficiencyBonus()
            );

            if(i < skillNames.length/2){
                skillsLeft.getChildren().add(newSkillBox);
            }else{
                skillsRight.getChildren().add(newSkillBox);
            }
        }
        //#endregion skills

        VBox rightPane = new VBox(boxSpacing);
        thirdRow.getChildren().add(rightPane);
        rightPane.setStyle("-fx-max-width: 700; -fx-pref-width: 700;");

        HBox thirdRowRight = new HBox(boxSpacing);
        rightPane.getChildren().add(thirdRowRight);

        thirdRowRight.getChildren().add(new MovementSpeedBox(character.getWalkingSpeed()));
        thirdRowRight.getChildren().add(new InitiativeBox(character.getInitiativeBonus()));
        thirdRowRight.getChildren().add(new StaminaBox(character.getStamina(), character.getVisionElement()));
        thirdRowRight.getChildren().add(new ConditionsBox(stage));

        VBox rightSubPane = new VBox(1);
        rightPane.getChildren().add(rightSubPane);

        //#region attacks labels
        HBox attackLabelsContainer = new HBox();
        rightSubPane.getChildren().add(attackLabelsContainer);
        attackLabelsContainer.setStyle("-fx-padding: 0 6 0 6;");
        //                              ^^padding is like this to match attackbox padding+border

        Pane attackTypeSpacer = new Pane();
        attackTypeSpacer.getStyleClass().addAll("attack-type");

        Label attackNameLabel = new Label("Name");
        attackNameLabel.getStyleClass().addAll("attack-name", "attack-category-label");

        Label attackRangeLabel = new Label("Range");
        attackRangeLabel.getStyleClass().addAll("attack-range", "attack-category-label");

        Label attackToAffectLabel = new Label("Hit/DC");
        attackToAffectLabel.getStyleClass().addAll("attack-to-affect", "attack-category-label");

        Label attackEffectLabel = new Label("Effect");
        attackEffectLabel.getStyleClass().addAll("attack-effect", "attack-category-label");

        Label attackNotesLabel = new Label("Notes");
        attackNotesLabel.getStyleClass().addAll("attack-notes", "attack-category-label");

        attackLabelsContainer.getChildren().addAll(
                attackTypeSpacer,
                attackNameLabel,
                attackRangeLabel,
                attackToAffectLabel,
                attackEffectLabel,
                attackNotesLabel
                );
        //#endregion

        rightSubPane.getChildren().add(new ElementalAttackBox(character, character.getVisionElement(), character.getElementalBurst()));
        rightSubPane.getChildren().add(new ElementalAttackBox(character, character.getVisionElement(), character.getElementalSkill()));
        rightSubPane.getChildren().add(new AttackBox(character, character.getWeapon(), character.getWeapon().getBasicAttack()));
        rightSubPane.getChildren().add(new AttackBox(character, character.getWeapon(), character.getWeapon().getChargedAttack()));

    }
}
