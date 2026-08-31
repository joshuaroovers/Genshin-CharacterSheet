package GenshinCharacterSheet.UI;

import GenshinCharacterSheet.Main;
import GenshinCharacterSheet.SheetComponents.Actions.Action;
import GenshinCharacterSheet.SheetComponents.Actions.Actions;
import GenshinCharacterSheet.SheetComponents.Character;
import GenshinCharacterSheet.SheetComponents.*;
import GenshinCharacterSheet.UI.Components.*;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;

public class CharacterSheet extends BorderPane {

    public CharacterSheet(Character character, int boxSpacing, Stage stage) {
        BorderPane mainPane = this;

        HBox mainSheetWrapper = new HBox();
        mainPane.setCenter(mainSheetWrapper);
        mainSheetWrapper.setStyle("-fx-alignment: center; ");

        HBox mainSheetPane = new HBox(boxSpacing);
        mainSheetWrapper.getChildren().add(mainSheetPane);
        mainSheetPane.setStyle("-fx-pref-width: " + (12*100+11*20)+";");

        VBox leftPane = new VBox(boxSpacing);
        mainSheetPane.getChildren().add(leftPane);
        //#region leftPane
        BorderPane leftRow1 = new BorderPane();
        leftPane.getChildren().add(leftRow1);
        leftRow1.getStyleClass().add("basic-row");
        leftRow1.setStyle("-fx-border-color: black;");
        //#region leftRow1
        VBox nameCardWrapper = new VBox();
        leftRow1.setLeft(nameCardWrapper);
        nameCardWrapper.setAlignment(Pos.CENTER);

        nameCardWrapper.getChildren().add(new NameCard(character.getVisionElement(), character.getName(), character.getLineage(), character.getWeapon()));

        //#region settings button
        HBox settingsWrapper = new HBox();
        settingsWrapper.getStyleClass().add("settings-button-container");
        leftRow1.setRight(settingsWrapper);

        StackPane settingsStackPane = new StackPane();
        settingsWrapper.getChildren().add(settingsStackPane);

        settingsStackPane.setOnMouseClicked(e ->{
            Main.setBuilderScene(); //TODO temporary result should show settings menu
        });


        HBox settingsInside = new HBox();
        settingsStackPane.getChildren().add(settingsInside);
        settingsInside.getStyleClass().addAll("settings-button", "settings-button-inside");
        settingsInside.getStyleClass().add(character.getVisionElement().getName()+"-border");

        HBox settingsBorder = new HBox();
        settingsStackPane.getChildren().add(settingsBorder);
        settingsBorder.getStyleClass().addAll("settings-button", "settings-button-border");
        settingsBorder.getStyleClass().add(character.getVisionElement().getName()+"-border");

        //#endregion
        //#endregion leftRow1

        HBox leftRow2 = new HBox(boxSpacing);
        leftPane.getChildren().add(leftRow2);
        leftRow2.getStyleClass().add("basic-row");
        //#region leftRow2
        for (PrimaryStats key : character.getPrimaryStats().keySet()) {
            PrimaryStat stat = character.getPrimaryStat(key);
            leftRow2.getChildren().add(new PrimaryStatBox(stat));
        }
        //#endregion leftRow2

        HBox leftRow3 = new HBox(boxSpacing);
        leftPane.getChildren().add(leftRow3);
        //#region leftRow3
        //#region saves
        for (PrimaryStats key : character.getPrimaryStats().keySet()) {
            SavingThrow save = character.getSavingThrow(key);
            leftRow3.getChildren().add(new SavingThrowBox(save, character.getProficiencyBonus()));
        }
        //#endregion saves
        //#endregion leftRow3

        HBox leftRow4 = new HBox(boxSpacing);
        leftPane.getChildren().add(leftRow4);
        //#region leftRow4
        //#region skills
        VBox skillsLeft = new VBox();
        VBox skillsRight = new VBox();

        leftRow4.getChildren().addAll(skillsLeft,skillsRight);

        ArrayList<SkillProficiency> skills = character.getSkills();
        for (int i = 0; i < skills.size(); i++) {
            SkillProficiency currentSkill = skills.get(i);
            SkillBox newSkillBox = new SkillBox(
                    currentSkill,
                    character.getProficiencyBonus(),
                    character.getPrimaryStat(currentSkill.getStat())
            );

            if(i < skills.size()/2){
                skillsLeft.getChildren().add(newSkillBox);
            }else{
                skillsRight.getChildren().add(newSkillBox);
            }
        }
        //#endregion skills
        //#endregion leftRow4
        //#endregion leftPane

        VBox rightPane = new VBox(boxSpacing);
        mainSheetPane.getChildren().add(rightPane);
        //#region rightPane

        HBox rightRow1 = new HBox(boxSpacing);
        rightPane.getChildren().add(rightRow1);
        rightRow1.getStyleClass().add("basic-row");
        //#region rightRow1
        rightRow1.getChildren().add(new InspirationBox(character.getInspiration(), character.getVisionElement()));
        rightRow1.getChildren().add(new ArmorClassBox(character.getArmorClass()));
        rightRow1.getChildren().add(new HitPointsBox(character.getHitPoints()));
        //#endregion rightRow1

        HBox rightRow2 = new HBox(boxSpacing);
        rightPane.getChildren().add(rightRow2);
        rightRow2.getStyleClass().add("basic-row");
        //#region rightRow2
        rightRow2.getChildren().add(new MovementSpeedBox(character.getWalkingSpeed()));
        rightRow2.getChildren().add(new InitiativeBox(character.getInitiativeBonus()));
        rightRow2.getChildren().add(new StaminaBox(character.getStamina(), character.getVisionElement()));
        rightRow2.getChildren().add(new ConditionsBox(stage));
        //#endregion rightRow2

        HBox rightRow3 = new HBox(boxSpacing);
        rightPane.getChildren().add(rightRow3);
        //#region rightRow3
        ScrollPane actionsWrapper = new ScrollPane();
        rightRow3.getChildren().add(actionsWrapper);
        actionsWrapper.hbarPolicyProperty().set(ScrollPane.ScrollBarPolicy.NEVER);
        actionsWrapper.fitToWidthProperty().set(true);
        actionsWrapper.setMaxWidth(700.0);

        VBox actionsContainer = new VBox(1);
        actionsWrapper.setContent(actionsContainer);
        actionsContainer.setStyle("-fx-padding: 5;");

        Label attacksLabel = new Label("Attacks:");
        actionsContainer.getChildren().add(attacksLabel);
        attacksLabel.getStyleClass().add("action-type-label");

        //#region attacks labels
        HBox attackLabelsContainer = new HBox();
        actionsContainer.getChildren().add(attackLabelsContainer);

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

        actionsContainer.getChildren().add(new ElementalAttackBox(character, character.getVisionElement(), character.getElementalBurst()));
        actionsContainer.getChildren().add(new ElementalAttackBox(character, character.getVisionElement(), character.getElementalSkill()));
        actionsContainer.getChildren().add(new AttackBox(character, character.getWeapon(), character.getWeapon().getUnarmedStrike()));
        actionsContainer.getChildren().add(new AttackBox(character, character.getWeapon(), character.getWeapon().getBasicAttack()));
        actionsContainer.getChildren().add(new AttackBox(character, character.getWeapon(), character.getWeapon().getChargedAttack()));

        FlowPane standardActionsFlowPane = new FlowPane(5,5);
        actionsContainer.getChildren().add(standardActionsFlowPane);

        ArrayList<Action> standardActions = Actions.getStandardActions(character.getVisionElement());
//        for (int i = 0; i < standardActions.size(); i++) {
//            Action currentAction = standardActions.get(i);
//            String actionName = currentAction.getName();
//            String actionDescription = currentAction.getDescription();
//            if(i < standardActions.size()-1){
//                actionName = actionName+",";
//            }
//            Label actionLabel = new Label(actionName);
//            standardActionsFlowPane.getChildren().add(actionLabel);
//
//            //TODO change out with Popup because of short show time
//            Tooltip actionTooltip = new Tooltip(actionDescription);
//            Tooltip.install(actionLabel, actionTooltip);
//        }

        VBox basicActionsWrapper = new VBox(5);
        actionsContainer.getChildren().add(basicActionsWrapper);
        basicActionsWrapper.setStyle("-fx-padding: 5;");

        VBox basicActionsBox = new VBox(5);
        basicActionsWrapper.getChildren().add(basicActionsBox);

        Label basicActionsLabel = new Label("Actions:");
        basicActionsBox.getChildren().add(basicActionsLabel);
        basicActionsLabel.getStyleClass().add("action-type-label");

        VBox basicBonusActionsBox = new VBox(5);
        basicActionsWrapper.getChildren().add(basicBonusActionsBox);

        Label basicBonusActionsLabel = new Label("Bonus Actions:");
        basicBonusActionsBox.getChildren().add(basicBonusActionsLabel);
        basicBonusActionsLabel.getStyleClass().add("action-type-label");

        VBox basicReactionsBox = new VBox(5);
        basicActionsWrapper.getChildren().add(basicReactionsBox);

        Label basicReactionsLabel = new Label("Reactions:");
        basicReactionsBox.getChildren().add(basicReactionsLabel);
        basicReactionsLabel.getStyleClass().add("action-type-label");

        for (Action standardAction : standardActions) {
            VBox actionWrapper = new VBox(2);
            Label actionNameLabel = new Label(standardAction.getName());
            Label actionDescription = new Label(standardAction.getDescription());
            actionDescription.getStyleClass().add("action-description");
            actionWrapper.getChildren().addAll(actionNameLabel, actionDescription);
            actionDescription.setWrapText(true);

            switch (standardAction.getType()){
                case ACTION:
                    basicActionsBox.getChildren().add(actionWrapper);
                    break;
                case BONUS:
                    basicBonusActionsBox.getChildren().add(actionWrapper);
                    break;
                case REACTION:
                    basicReactionsBox.getChildren().add(actionWrapper);
                    break;
            }
        }
        //#endregion rightRow3

        //#endregion rightPane
    }
}
