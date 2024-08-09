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

        LinkedHashMap<String, Character.stat> defaultSkills = new LinkedHashMap<>();
        //#region default skills list
        defaultSkills.put("Acrobatics", Character.stat.DEXTERITY);
        defaultSkills.put("Animal Handling", Character.stat.WISDOM);
        defaultSkills.put("Arcana", Character.stat.INTELLIGENCE);
        defaultSkills.put("Athletics", Character.stat.STRENGTH);
        defaultSkills.put("Deception", Character.stat.CHARISMA);
        defaultSkills.put("History", Character.stat.INTELLIGENCE);
        defaultSkills.put("Insight", Character.stat.WISDOM);
        defaultSkills.put("Intimidation", Character.stat.CHARISMA);
        defaultSkills.put("Investigation", Character.stat.INTELLIGENCE);
        defaultSkills.put("Medicine", Character.stat.WISDOM);
        defaultSkills.put("Nature", Character.stat.INTELLIGENCE);
        defaultSkills.put("Perception", Character.stat.WISDOM);
        defaultSkills.put("Performance", Character.stat.CHARISMA);
        defaultSkills.put("Persuasion", Character.stat.CHARISMA);
        defaultSkills.put("Religion", Character.stat.INTELLIGENCE);
        defaultSkills.put("Sleight of Hand", Character.stat.DEXTERITY);
        defaultSkills.put("Stealth", Character.stat.DEXTERITY);
        defaultSkills.put("Survival", Character.stat.WISDOM);
        //#endregion

        Character character = new Character(defaultSkills);

        BorderPane mainPane = new CharacterSheet(character, boxSpacing);


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

        stage.setTitle("Genshin CharacterSheet V0.23");
        stage.setScene(scene);
        stage.show();
    }
}