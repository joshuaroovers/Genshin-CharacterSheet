package GenshinCharacterSheet;

import GenshinCharacterSheet.SheetComponents.Character;
import GenshinCharacterSheet.SheetComponents.CharacterFactory;
import GenshinCharacterSheet.SheetComponents.Skills;
import GenshinCharacterSheet.UI.CharacterBuilder;
import GenshinCharacterSheet.UI.CharacterSheet;
import GenshinCharacterSheet.UI.Util.IOController;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application{

    private static Scene scene;
    private static Stage mainStage;

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

        Character character = CharacterFactory.random();

        BorderPane mainPane = new CharacterSheet(character, boxSpacing, stage);
        tempMain.getChildren().add(mainPane);

        scene.setRoot(tempMain);

//        CharacterBuilder characterBuilder = new CharacterBuilder(Skills.defaultSkills);
//        scene.setRoot(characterBuilder);



//        Button buttonTest = new Button("new char");
//        tempMain.getChildren().add(buttonTest);
//        buttonTest.setOnAction(e ->{
//            VBox smallTest = new VBox(10);
//            BorderPane newCharTest = new CharacterSheet(new Character(defaultSkills), boxSpacing, stage);
//            smallTest.getChildren().addAll(newCharTest, buttonTest);
//            scene.setRoot(smallTest);
//        });

        stage.setTitle("Genshin CharacterSheet V0.37");
        stage.setScene(scene);
        stage.show();
    }


    public static void setBuilderScene(){
        setScene(new CharacterBuilder(Skills.defaultSkills));
    }

    public static void setCharacterScene(Character character){
        setScene(new CharacterSheet(character, boxSpacing, mainStage));
    }

    private static void setScene(Parent parent){
        scene.setRoot(parent);
    }
}