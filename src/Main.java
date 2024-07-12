import SheetComponents.Element;
import SheetComponents.SavingThrow;
import UIComponents.*;
import SheetComponents.PrimaryStat;
import SheetComponents.Skill;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.LinkedHashMap;

public class Main extends Application{

    public static void main(String[] args) {
        launch(args);
    }

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

        VBox mainPane = new VBox(20);

        HBox firstRow = new HBox(20);
        mainPane.getChildren().add(firstRow);

        for (CharacterSheet.stat key : character.getPrimaryStats().keySet()) {
            PrimaryStat stat = character.getPrimaryStat(key);
            firstRow.getChildren().add(new PrimaryStatBox(stat));
        }


        firstRow.getChildren().add(new InspirationBox(character.getInspiration()));

        HitPointsBox hitPointsBox = new HitPointsBox(character.getHitPoints());
        firstRow.getChildren().add(hitPointsBox);


        VBox leftPane = new VBox(20);
        mainPane.getChildren().add(leftPane);

        //#region saves
        HBox savesBox = new HBox(20);
        leftPane.getChildren().add(savesBox);
        for (CharacterSheet.stat key : character.getPrimaryStats().keySet()) {
            SavingThrow save = character.getSavingThrow(key);
            savesBox.getChildren().add(new SavingThrowBox(save, character.getProficiencyBonus()));
        }
        //#endregion saves

        //#region skills
        HBox skills = new HBox(20);
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


        Scene scene = new Scene(mainPane, 1300, 800);
        scene.getStylesheets().add("styles.css");

        stage.setTitle("Genshin CharacterSheet V0.12");
        stage.setScene(scene);
        stage.show();
    }
}