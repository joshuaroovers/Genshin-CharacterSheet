import SheetComponents.PrimaryStat;
import Components.PrimaryStatBox;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
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

        VBox mainPane = new VBox();

        HBox firstRow = new HBox(20);
        mainPane.getChildren().add(firstRow);

        for (CharacterSheet.stat key : character.getPrimaryStats().keySet()) {
            PrimaryStat stat = character.getPrimaryStat(key);
            firstRow.getChildren().add(new PrimaryStatBox(stat.getName(), stat.getScore(), stat.getModifierString()));
        }

        Scene scene = new Scene(mainPane, 1200, 800);
        scene.getStylesheets().add("styles.css");

        stage.setTitle("Genshin CharacterSheet V0.1");
        stage.setScene(scene);
        stage.show();
    }
}