import SheetComponents.ElementalReactions.*;
import SheetComponents.Elements.Cryo;
import SheetComponents.Elements.Element;
import SheetComponents.SavingThrow;
import UIComponents.*;
import SheetComponents.PrimaryStat;
import SheetComponents.Skill;
import UIComponents.util.ImageHelper;
import UIComponents.util.ImageVariant;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Popup;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;

public class Main extends Application{

    private VBox testScrollPane;

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
        tempSettings.getStyleClass().add(character.getVisionElement().getName());
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

        thirdRowRight.getChildren().add(new MovementSpeedBox(character.getWalkingSpeed()));
        thirdRowRight.getChildren().add(new InitiativeBox(character.getInitiativeBonus()));
        thirdRowRight.getChildren().add(new StaminaBox(character.getStamina(), character.getVisionElement()));
        thirdRowRight.getChildren().add(new ConditionsBox());


        //#region testing area

//        ArrayList<Reaction> reactions = new ArrayList<>(Arrays.asList(
//                new ReactionBloom(), new ReactionBurning(), new ReactionCatalyze(),
//                new ReactionCrystallize(), new ReactionElectroCharged(), new ReactionFreeze(),
//                new ReactionMelt(), new ReactionOverload(), new ReactionSuperConduct(),
//                new ReactionSwirl(), new ReactionVaporize()));
//
//        testScrollPane = new VBox();
//        ScrollPane scrollPane = new ScrollPane(testScrollPane);
//        leftPane.getChildren().add(scrollPane);
//
//        for (Reaction reactionTest : reactions) {
//
//            Label reactionTestLabel = new Label(reactionTest.getName());
//            testScrollPane.getChildren().add(reactionTestLabel);
//
//            HBox testWrapper = new HBox();
//            testScrollPane.getChildren().add(testWrapper);
//
//            HBox elementImage1 = new HBox();
//            testWrapper.getChildren().add(elementImage1);
//            elementImage1.setStyle("-fx-background-image: url(" + ImageHelper.getElementURL(reactionTest.getElement1(), ImageVariant.FLAT) + ")");
//            elementImage1.getStyleClass().addAll("name-card-element-image", "element-image");
//
//
//            HBox elementImage2 = new HBox();
//            testWrapper.getChildren().add(elementImage2);
//            String imageUrl = "";
//            if (reactionTest.getClass() == ReactionSwirl.class || reactionTest.getClass() == ReactionCrystallize.class) {
//                imageUrl = ImageHelper.getElementURL(reactionTest.getElement1(), ImageVariant.GILDED);
//                if (reactionTest.getClass() == ReactionSwirl.class) {
//                    System.out.println(((ReactionSwirl) reactionTest).getElements());
//                } else if (reactionTest.getClass() == ReactionCrystallize.class) {
//                    System.out.println(((ReactionCrystallize) reactionTest).getElements());
//                }
//            } else {
//                imageUrl = ImageHelper.getElementURL(reactionTest.getElement2(), ImageVariant.FLAT);
//            }
//
//            elementImage2.setStyle("-fx-background-image: url(" + imageUrl + ")");
//            elementImage2.getStyleClass().addAll("name-card-element-image", "element-image");
//        }



//        VBox root = new VBox();
//        rightPane.getChildren().add(root);
//        root.setStyle("-fx-pref-height: 100; -fx-min-height: 100");
//        Button button = new Button("Hover over me");
//
//        Label tooltip = new Label("This is a tooltip!");
//        tooltip.setStyle("-fx-background-color: yellow; -fx-padding: 10;");
//
//        tooltip.setVisible(false);
//
//        root.getChildren().addAll(button, tooltip);
//
//        button.setOnMouseEntered(e -> {
//            System.out.println("show tooltip");
//            tooltip.setVisible(true);
//            tooltip.setTranslateX(button.getLayoutX());
//            tooltip.setTranslateY(button.getLayoutY());
//        });
//
//        button.setOnMouseExited(e -> {
//            tooltip.setVisible(false);
//        });
//
//
//        Button button2 = new Button("Hover over me2");
//        rightPane.getChildren().add(button2);
//        Popup popup2 = new Popup();
//        Label tooltip2 = new Label("This is a tooltip!");
//        tooltip.setStyle("-fx-background-color: yellow; -fx-padding: 10;");
//        popup2.getContent().add(tooltip2);
//
//        button2.setOnMouseEntered(e -> {
//            popup2.show(button, e.getScreenX(), e.getScreenY());
//        });
//
//        button2.setOnMouseExited(e -> {
//            popup2.hide();
//        });
//
//        VBox stackPaneTestWrapper = new VBox();
//        rightPane.getChildren().add(stackPaneTestWrapper);
//
//        Label testLabel1 = new Label("Stackpane overflow/resizing test");
//        stackPaneTestWrapper.getChildren().add(testLabel1);
//
//        StackPane stackPane = new StackPane();
//        stackPaneTestWrapper.getChildren().add(stackPane);
//        stackPane.getStyleClass().add("GREEN");
//        stackPane.setStyle("-fx-pref-height: 100; -fx-max-height: 100; -fx-pref-width: 100; -fx-max-width: 100;");
//
//
//
//        HBox box1 = new HBox();
//        stackPane.getChildren().add(box1);
////        box1.setManaged(false);
//        box1.getStyleClass().add("RED");
//        box1.setStyle("-fx-pref-height: 200; -fx-max-height: 200; -fx-pref-width: 75; -fx-max-width: 75;");
//
//        HBox box2 = new HBox();
//        stackPane.getChildren().add(box2);
//        box2.getStyleClass().add("BLUE");
//        box2.setStyle("-fx-pref-height: 50; -fx-max-height: 50; -fx-pref-width: 50; -fx-max-width: 50;");
//
//        Label testLabel2 = new Label("pls stay put ty");
//        stackPaneTestWrapper.getChildren().add(testLabel2);
//
//        StackPane mainPane2 = new StackPane();
//        Pane root2 = new Pane();
//        rightPane.getChildren().add(root2);
//
//        Button button3 = new Button("Hover over me3");
//        mainPane2.getChildren().add(button3);
//
//        Label tooltip3 = new Label("This is a tooltip!");
//        tooltip3.setStyle("-fx-background-color: yellow; -fx-padding: 10;");
//        tooltip3.setVisible(false);
//
//        root.getChildren().addAll(mainPane2, tooltip3);
//
//        button3.setOnMouseEntered(e -> {
//            tooltip3.setVisible(true);
//            tooltip3.setLayoutX(button3.localToScene(button3.getBoundsInLocal()).getMinX() + 10);
//            tooltip3.setLayoutY(button3.localToScene(button3.getBoundsInLocal()).getMinY() - tooltip3.getHeight() - 10);
//        });
//
//        button3.setOnMouseExited(e -> {
//            tooltip3.setVisible(false);
//        });


        //#endregion




        Scene scene = new Scene(mainPane, 12*100+11*boxSpacing, 800);
        scene.getStylesheets().add("styles.css");

        stage.setTitle("Genshin CharacterSheet V0.22");
        stage.setScene(scene);
        stage.show();
    }
}