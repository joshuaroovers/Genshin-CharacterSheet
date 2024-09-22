package GenshinCharacterSheet;

import GenshinCharacterSheet.SheetComponents.Character;
import GenshinCharacterSheet.SheetComponents.Stat;
import GenshinCharacterSheet.UI.CharacterBuilder;
import GenshinCharacterSheet.UI.CharacterSheet;
import GenshinCharacterSheet.UI.Util.IOController;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.LinkedHashMap;

public class Main extends Application{

    private static Scene scene;
    private static Stage mainStage;

    public static LinkedHashMap<String, Stat> defaultSkills;
    static {
        defaultSkills = new LinkedHashMap<>();
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
    }

    public static void main(String[] args) {
        launch(args);
    }

    private static final int boxSpacing = 20;

    @Override
    public void start(Stage stage) throws Exception {
        mainStage = stage;
        IOController.init();
        Font.loadFont(getClass().getResourceAsStream("/genshin-font.ttf"),12);

        scene = new Scene(new Pane(), 12*100+11*boxSpacing, 800);
        scene.getStylesheets().add("styles.css");
        VBox tempMain = new VBox(10);

//        Character character = new Character(defaultSkills);
//
//        BorderPane mainPane = new CharacterSheet(character, boxSpacing, stage);
//        tempMain.getChildren().add(mainPane);

//        scene.setRoot(tempMain);

        CharacterBuilder characterBuilder = new CharacterBuilder(defaultSkills);
        scene.setRoot(characterBuilder);



//        Button buttonTest = new Button("new char");
//        tempMain.getChildren().add(buttonTest);
//        buttonTest.setOnAction(e ->{
//            VBox smallTest = new VBox(10);
//            BorderPane newCharTest = new CharacterSheet(new Character(defaultSkills), boxSpacing, stage);
//            smallTest.getChildren().addAll(newCharTest, buttonTest);
//            scene.setRoot(smallTest);
//        });

        stage.setTitle("Genshin CharacterSheet V0.36");
        stage.setScene(scene);
        stage.show();
    }


    public static void setBuilderScene(){
        setScene(new CharacterBuilder(defaultSkills));
    }

    public static void setCharacterScene(Character character){
        setScene(new CharacterSheet(character, boxSpacing, mainStage));
    }

    private static void setScene(Parent parent){
        scene.setRoot(parent);
    }
}