import SheetComponents.SavingThrow;
import UIComponents.*;
import SheetComponents.PrimaryStat;
import SheetComponents.Skill;
import UIComponents.util.ImageHelper;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.LinkedHashMap;

public class Main extends Application{

    public static void main(String[] args) {
        launch(args);
    }
    private final int boxSpacing = 20;

    @Override
    public void start(Stage stage) throws Exception {
//        stage.setOpacity(0.8);
        IOController.init();
        Font.loadFont(getClass().getResourceAsStream("/genshin-font.ttf"),12);

        LinkedHashMap<String, CharacterSheet.stat> defaultSkills = new LinkedHashMap<>();
        //#region default skills list
        defaultSkills.put("Acrobatics", CharacterSheet.stat.DEXTERITY);
        defaultSkills.put("Animal Handling", CharacterSheet.stat.WISDOM);
        defaultSkills.put("Arcana", CharacterSheet.stat.INTELLIGENCE);
        defaultSkills.put("Athletics", CharacterSheet.stat.STRENGTH);
        defaultSkills.put("Deception", CharacterSheet.stat.CHARISMA);
        defaultSkills.put("History", CharacterSheet.stat.INTELLIGENCE);
        defaultSkills.put("Insight", CharacterSheet.stat.WISDOM);
        defaultSkills.put("Intimidation", CharacterSheet.stat.CHARISMA);
        defaultSkills.put("Investigation", CharacterSheet.stat.INTELLIGENCE);
        defaultSkills.put("Medicine", CharacterSheet.stat.WISDOM);
        defaultSkills.put("Nature", CharacterSheet.stat.INTELLIGENCE);
        defaultSkills.put("Perception", CharacterSheet.stat.WISDOM);
        defaultSkills.put("Performance", CharacterSheet.stat.CHARISMA);
        defaultSkills.put("Persuasion", CharacterSheet.stat.CHARISMA);
        defaultSkills.put("Religion", CharacterSheet.stat.INTELLIGENCE);
        defaultSkills.put("Sleight of Hand", CharacterSheet.stat.DEXTERITY);
        defaultSkills.put("Stealth", CharacterSheet.stat.DEXTERITY);
        defaultSkills.put("Survival", CharacterSheet.stat.WISDOM);
        //#endregion

        CharacterSheet character = new CharacterSheet(defaultSkills);

        BorderPane mainPane = new BorderPane();

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

        firstRow.setLeft(new NameCard(character.getVisionElement(), character.getName(), character.getSpecies().getName(), character.getWeapon().getBaseName()));

        //#region settings button
        HBox tempWrapper = new HBox();
        tempWrapper.getStyleClass().add("settings-button-container");

        HBox tempSettings = new HBox();
        tempWrapper.getChildren().add(tempSettings);
        tempSettings.getStyleClass().add("settings-button");
        tempSettings.getStyleClass().add(character.getVisionElement().toString());
        firstRow.setRight(tempWrapper);
        //#endregion


        HBox secondRow = new HBox(boxSpacing);
        mainSheetPane.getChildren().add(secondRow);

        for (CharacterSheet.stat key : character.getPrimaryStats().keySet()) {
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
        for (CharacterSheet.stat key : character.getPrimaryStats().keySet()) {
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

        HBox thirdRowRight = new HBox(boxSpacing);
        rightPane.getChildren().add(thirdRowRight);

        thirdRowRight.getChildren().add(new StaminaBox(character.getStamina()));



        //#region testing area
//        StackPane test2 = new StackPane();
//        leftPane.getChildren().add(test2);
//        test2.getStyleClass().addAll("shield","ANEMO");
//        test2.setStyle("-fx-max-width: 200;"+
//                "-fx-pref-height: 200;"+
//                "-fx-padding: 50;");
//
//        HBox test = new HBox();
//        test.getStyleClass().add("element-image");
////        System.out.println(ImageHelper.getElementURL(Element.ANEMO, ImageVariant.FLAT));
//        test.setStyle("-fx-background-image: url("+ImageHelper.getElementURL(Element.ANEMO, ImageVariant.FLAT)+");"+
//                "-fx-max-width: 200;"+
//                "-fx-pref-height: 200;");
//        test2.getChildren().add(test);


//        ComboBox comboTest = new ComboBox();
//        leftPane.getChildren().add(comboTest);
//        comboTest.setStyle("-fx-pref-width: 0; -fx-min-width: 10; -fx-pref-height: 10; -fx-min-height: 0; -fx-padding: 0; -fx-background-color: red; -fx-font-size: 0;");
//        comboTest.getItems().addAll("test1","test2","test3");



        //#endregion


        Scene scene = new Scene(mainPane, 12*100+11*boxSpacing, 800);
        scene.getStylesheets().add("styles.css");

        stage.setTitle("Genshin CharacterSheet V0.15");
        stage.setScene(scene);
        stage.show();
    }
}