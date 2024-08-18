import SheetComponents.Character;
import SheetComponents.Stat;
import UI.CharacterSheet;
import UI.Util.IOController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

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

        VBox tempMain = new VBox(10);

        LinkedHashMap<String, Stat> defaultSkills = new LinkedHashMap<>();
        //#region default skills list
        defaultSkills.put("Acrobatics", Stat.DEXTERITY);
        defaultSkills.put("Animal Handling", Stat.WISDOM);
        defaultSkills.put("Arcana", Stat.INTELLIGENCE);
        defaultSkills.put("Athletics", Stat.STRENGTH);
        defaultSkills.put("Deception", Stat.CHARISMA);
        defaultSkills.put("History", Stat.INTELLIGENCE);
        defaultSkills.put("Insight", Stat.WISDOM);
        defaultSkills.put("Intimidation", Stat.CHARISMA);
        defaultSkills.put("Investigation", Stat.INTELLIGENCE);
        defaultSkills.put("Medicine", Stat.WISDOM);
        defaultSkills.put("Nature", Stat.INTELLIGENCE);
        defaultSkills.put("Perception", Stat.WISDOM);
        defaultSkills.put("Performance", Stat.CHARISMA);
        defaultSkills.put("Persuasion", Stat.CHARISMA);
        defaultSkills.put("Religion", Stat.INTELLIGENCE);
        defaultSkills.put("Sleight of Hand", Stat.DEXTERITY);
        defaultSkills.put("Stealth", Stat.DEXTERITY);
        defaultSkills.put("Survival", Stat.WISDOM);
        //#endregion

        Character character = new Character(defaultSkills);

        BorderPane mainPane = new CharacterSheet(character, boxSpacing, stage);
        tempMain.getChildren().add(mainPane);

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



        //#endregion


        Scene scene = new Scene(tempMain, 12*100+11*boxSpacing, 800);
        scene.getStylesheets().add("styles.css");

        stage.setTitle("Genshin UIComponents.CharacterSheet V0.31");
        stage.setScene(scene);
        stage.show();
    }
}