package GenshinCharacterSheet.UI;

import GenshinCharacterSheet.Main;
import GenshinCharacterSheet.SheetComponents.*;
import GenshinCharacterSheet.SheetComponents.Actions.Attacks.ElementalBursts.ElementalBurst;
import GenshinCharacterSheet.SheetComponents.Actions.Attacks.ElementalBursts.ElementalBurstDestructive;
import GenshinCharacterSheet.SheetComponents.Actions.Attacks.ElementalSkills.ElementalSkill;
import GenshinCharacterSheet.SheetComponents.Actions.Attacks.ElementalSkills.ElementalSkillSummonTaunt;
import GenshinCharacterSheet.SheetComponents.Character;
import GenshinCharacterSheet.SheetComponents.Elements.Element;
import GenshinCharacterSheet.SheetComponents.Elements.Elements;
import GenshinCharacterSheet.SheetComponents.Lineage.Lineage;
import GenshinCharacterSheet.SheetComponents.Lineage.Lineages;
import GenshinCharacterSheet.SheetComponents.Weapons.*;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class CharacterBuilder extends VBox {

    private static final String NAME_LABEL = "Name:";
    private final TextField nameInput;

    private static final String VISION_LABEL = "Element:";
    private final ComboBox<Element> visionInput;

    private static final String WEAPON_LABEL = "Weapon:";
    private final ComboBox<weaponOptions> weaponInput;

    enum weaponOptions {Sword, Polearm, Claymore, Catalyst, Bow}

    private static final String LINEAGE_LABEL = "Lineage:";
    private final ComboBox<Lineage> lineageInput;

    private static final String ELEMENTAL_SKILL_LABEL = "Elemental Skill:";
    private final ComboBox<elementalSkillOption> elementalSkillInput;
    enum elementalSkillOption {SummonTaunt}

    private static final String ELEMENTAL_BURST_LABEL = "Elemental Burst:";
    private final ComboBox<elementalBurstOption> elementalBurstInput;
    enum elementalBurstOption {Destructive}

    private final TextField strInput;
    private final TextField dexInput;
    private final TextField conInput;
    private final TextField intInput;
    private final TextField wisInput;
    private final TextField chaInput;


    public CharacterBuilder() {
        VBox mainBox = this;
        mainBox.setSpacing(10d);

        GridPane gridPane = new GridPane();
        mainBox.getChildren().add(gridPane);

        int labelColumn = 0;
        int inputColumn = 1;

        int currentRow = -1;
//        VBox labelsColumn = new VBox();
//        gridPane.add(labelsColumn);

//        VBox inputsColumn = new VBox();
//        gridPane.setRight(inputsColumn);

        //#region name
        currentRow++;
        Label charNameLabel = new Label(NAME_LABEL);
        gridPane.add(charNameLabel, labelColumn, currentRow);

        nameInput = new TextField();
        gridPane.add(nameInput, inputColumn, currentRow);
        //#endregion

        //#region weapon
        currentRow++;
        Label lineageLabel = new Label(LINEAGE_LABEL);
        gridPane.add(lineageLabel, labelColumn, currentRow);

        lineageInput = new ComboBox<>();
        gridPane.add(lineageInput, inputColumn, currentRow);
        lineageInput.getItems().addAll(Lineages.ALL);
        //#endregion

        //#region element
        currentRow++;
        Label elementLabel = new Label(VISION_LABEL);
        gridPane.add(elementLabel, labelColumn, currentRow);

        visionInput = new ComboBox<>();
        gridPane.add(visionInput, inputColumn, currentRow);
        visionInput.getItems().addAll(Elements.ALL);
        //#endregion

        //#region weapon
        currentRow++;
        Label weaponLabel = new Label(WEAPON_LABEL);
        gridPane.add(weaponLabel, labelColumn, currentRow);

        weaponInput = new ComboBox<>();
        gridPane.add(weaponInput, inputColumn, currentRow);
        weaponInput.getItems().addAll(weaponOptions.values());
        //#endregion

        //#region elemental skill
        currentRow++;
        Label elementalSkillLabel = new Label(ELEMENTAL_SKILL_LABEL);
        gridPane.add(elementalSkillLabel, labelColumn, currentRow);

        elementalSkillInput = new ComboBox<>();
        gridPane.add(elementalSkillInput, inputColumn, currentRow);
        elementalSkillInput.getItems().addAll(elementalSkillOption.values());
        //#endregion

        //#region elemental burst
        currentRow++;
        Label elementalBurstLabel = new Label(ELEMENTAL_BURST_LABEL);
        gridPane.add(elementalBurstLabel, labelColumn, currentRow);

        elementalBurstInput = new ComboBox<>();
        gridPane.add(elementalBurstInput, inputColumn ,currentRow);
        elementalBurstInput.getItems().addAll(elementalBurstOption.values());
        //#endregion

        strInput = new TextField();
        dexInput = new TextField();
        conInput = new TextField();
        intInput = new TextField();
        wisInput = new TextField();
        chaInput = new TextField();

        for (PrimaryStats value : PrimaryStats.values()) {
            currentRow++;

            Label statLabel = new Label(value.name());
            gridPane.add(statLabel, labelColumn, currentRow);

            TextField statInput;
            switch (value){
                case STRENGTH:
                    statInput = strInput;
                    break;
                case DEXTERITY:
                    statInput = dexInput;
                    break;
                case CONSTITUTION:
                    statInput = conInput;
                    break;
                case INTELLIGENCE:
                    statInput = intInput;
                    break;
                case WISDOM:
                    statInput = wisInput;
                    break;
                case CHARISMA:
                    statInput = chaInput;
                    break;
                default:
                    statInput = new TextField();
                    break;
            }
            gridPane.add(statInput, inputColumn, currentRow);
        }

        Button submitButton = new Button("Create Character");
        mainBox.getChildren().add(submitButton);

        submitButton.setOnAction(e ->{
            Main.setCharacterScene(getNewCharacter());
        });

    }

    //TODO validate input field methods

    private int getStatValue(PrimaryStats primaryStats){
        switch (primaryStats){
            case STRENGTH:
                return Integer.parseInt(strInput.getText());
            case DEXTERITY:
                return Integer.parseInt(dexInput.getText());
            case CONSTITUTION:
                return Integer.parseInt(conInput.getText());
            case INTELLIGENCE:
                return Integer.parseInt(intInput.getText());
            case WISDOM:
                return Integer.parseInt(wisInput.getText());
            case CHARISMA:
                return Integer.parseInt(chaInput.getText());
            default:
                return 0;
        }
    }

    private ElementalSkill getElementalSkill(Element element){
        switch (elementalSkillInput.getValue()){
            case SummonTaunt:
                return new ElementalSkillSummonTaunt();
            default:
                return null;
        }
    }

    private ElementalBurst getElementalBurst(Element element){
        switch (elementalBurstInput.getValue()){
            case Destructive:
                return new ElementalBurstDestructive(element);
            default:
                return null;
        }
    }

    public Character getNewCharacter(){
        Element visionElement = visionInput.getValue();
        HashMap<PrimaryStats, Integer> primaryStatValues = new HashMap<>();
        for (PrimaryStats value : PrimaryStats.values()) {
            primaryStatValues.put(value, getStatValue(value));
        }
        return new Character(
                nameInput.getText(),
                visionInput.getValue(),
                getNewWeapon(visionElement),
                lineageInput.getValue(),
                primaryStatValues,
                null,
                getElementalBurst(visionElement),
                getElementalSkill(visionElement)
        );
    }

    private Weapon getNewWeapon(Element element){
        switch (weaponInput.getValue()){
            case Sword:
                return new Sword();
            case Polearm:
                return new Polearm();
            case Claymore:
                return new Claymore();
            case Catalyst:
                return new Catalyst(element);
            case Bow:
                return new Bow(element);
            default:
                return null;
        }
    }

}
