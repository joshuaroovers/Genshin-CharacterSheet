package UI.Components.SubComponents;

import SheetComponents.Actions.Attacks.Attack;
import SheetComponents.Actions.Attacks.ElementalBursts.ElementalBurst;
import SheetComponents.Actions.Attacks.ElementalSkills.ElementalSkill;
import SheetComponents.Character;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;

import java.util.ArrayList;

public class AttackBoxBase extends HBox {
    private VBox nameInputWrapper;
    private VBox nameWrapper;
    private Label attackNameLabel;
    private TextArea nameInputBox;
    //components width add up to 690 (230 per section) (700 is absolute with minus 5*2 for padding)

    //TODO these could've probably been overloading constructors.... or like a private base constructor
    public AttackBoxBase(Character character, String attackTypeImageURL, Attack attack) {
        HBox mainBox = this;
        mainBox.getStyleClass().add("attack-box");
        mainBox.setSpacing(5);

        VBox attackTypeWrapper = new VBox();
        mainBox.getChildren().add(attackTypeWrapper);
        attackTypeWrapper.setAlignment(Pos.CENTER_LEFT);
        attackTypeWrapper.getStyleClass().addAll("attack-type");

        Pane attackTypeImage = new Pane();
        attackTypeWrapper.getChildren().add(attackTypeImage);
        attackTypeImage.setStyle("-fx-background-image: url("+attackTypeImageURL+");");
        attackTypeImage.getStyleClass().addAll("attack-type-image", "element-image");

        VBox nameWrapper = new VBox();
        mainBox.getChildren().add(nameWrapper);
        nameWrapper.setAlignment(Pos.CENTER_LEFT);
        nameWrapper.getStyleClass().addAll("attack-name");

        Label attackNameLabel = new Label(attack.getName());
        nameWrapper.getChildren().add(attackNameLabel);
        attackNameLabel.setStyle("-fx-wrap-text: true;");

        VBox rangeWrapper = new VBox();
        mainBox.getChildren().add(rangeWrapper);
        rangeWrapper.setAlignment(Pos.CENTER_LEFT);
        rangeWrapper.getStyleClass().addAll("attack-range");

        Label rangeLabel = new Label(attack.getRange());
        rangeWrapper.getChildren().add(rangeLabel);

        VBox toAffectWrapper = new VBox();
        mainBox.getChildren().add(toAffectWrapper);
        toAffectWrapper.setAlignment(Pos.CENTER_LEFT);
        toAffectWrapper.getStyleClass().addAll("attack-to-affect");

        if(attack.isSave()){
            HBox saveWrapper = new HBox();
            toAffectWrapper.getChildren().add(saveWrapper);

            VBox saveContainer = new VBox();
            saveWrapper.getChildren().add(saveContainer);
            saveContainer.setAlignment(Pos.CENTER);

            Label saveTypeLabel = new Label(attack.getSaveType(character).getNameAbbreviation());
            saveContainer.getChildren().add(saveTypeLabel);
            Label saveDCLabel = new Label(attack.getSaveDC(character)+"");
            saveContainer.getChildren().add(saveDCLabel);
        }else{
            ModifierBox modifierBox = new ModifierBox(attack.getStat(character).getModifier(), true, character.getProficiencyBonus());
            toAffectWrapper.getChildren().add(modifierBox);
            modifierBox.getStyleClass().addAll("attack-to-hit-label");
        }

        VBox effectWrapper = new VBox();
        mainBox.getChildren().add(effectWrapper);
        effectWrapper.setAlignment(Pos.CENTER_LEFT);
        effectWrapper.getStyleClass().addAll("attack-effect");

        HBox effectContainer = new HBox();
        effectWrapper.getChildren().add(effectContainer);

        VBox effectLabelWrapper = new VBox();
        effectContainer.getChildren().add(effectLabelWrapper);
        effectLabelWrapper.setAlignment(Pos.CENTER_LEFT);

        Label effectLabel = new Label(attack.getEffect().getEffect(character));
        effectLabelWrapper.getChildren().add(effectLabel);

        if(attack.getEffect().hasUnit()){
            Pane effectUnitImage = new Pane();
            effectContainer.getChildren().add(effectUnitImage);
            effectUnitImage.setStyle("-fx-background-image: url("+ attack.getEffect().getUnitURL()+");");
            effectUnitImage.getStyleClass().addAll("attack-effect-image", "element-image");
        }

        VBox notesWrapper = new VBox();
        mainBox.getChildren().add(notesWrapper);
        notesWrapper.setAlignment(Pos.CENTER_LEFT);
        notesWrapper.getStyleClass().addAll("attack-notes");

        FlowPane notesFlowPane = new FlowPane(5, 5);
        notesWrapper.getChildren().add(notesFlowPane);

        if(attack.appliesElement()){
            String appliesNoteString = "Applies "+attack.getEffect().getUnitString();
            if(!attack.getNotes().isEmpty()){
                appliesNoteString = appliesNoteString + ",";
            }
            Label appliesElementNoteLabel = new Label(appliesNoteString);
            notesFlowPane.getChildren().add(appliesElementNoteLabel);
        }

        ArrayList<String> notes = attack.getNotes();
        for (int i = 0; i < notes.size(); i++) {
            String noteString = notes.get(i);
            if(i < notes.size()-2){
                noteString = noteString+",";
            }
            Label noteLabel = new Label(noteString);
            notesFlowPane.getChildren().add(noteLabel);
        }
    }

    public AttackBoxBase(Character character, String attackTypeImageURL, ElementalBurst elementalBurst) {
        HBox mainBox = this;
        mainBox.getStyleClass().add("attack-box");
        mainBox.setSpacing(5);

        VBox attackTypeWrapper = new VBox();
        mainBox.getChildren().add(attackTypeWrapper);
        attackTypeWrapper.setAlignment(Pos.CENTER_LEFT);
        attackTypeWrapper.getStyleClass().addAll("attack-type");

        Pane attackTypeImage = new Pane();
        attackTypeWrapper.getChildren().add(attackTypeImage);
        attackTypeImage.setStyle("-fx-background-image: url("+attackTypeImageURL+");");
        attackTypeImage.getStyleClass().addAll("attack-type-image", "element-image");

        HBox nameEnergyWrapper = new HBox();
        mainBox.getChildren().add(nameEnergyWrapper);
        nameEnergyWrapper.getStyleClass().addAll("attack-name");
        //#region nameBox
        nameWrapper = new VBox();
        nameEnergyWrapper.getChildren().add(nameWrapper);
        nameWrapper.setAlignment(Pos.CENTER_LEFT);

        attackNameLabel = new Label(elementalBurst.getName());
        nameWrapper.getChildren().add(attackNameLabel);
        attackNameLabel.setStyle("-fx-wrap-text: true;");
        attackNameLabel.managedProperty().bind(attackNameLabel.visibleProperty());

        attackNameLabel.setOnMouseClicked(e -> {
            handleNameClick(elementalBurst);
        });

        nameInputWrapper = new VBox();
        nameWrapper.getChildren().add(nameInputWrapper);
        nameInputWrapper.managedProperty().bind(nameInputWrapper.visibleProperty());
        nameInputWrapper.setVisible(false);

        Label baseNameLabel = new Label(ElementalBurst.NAME_BASE);
        nameInputWrapper.getChildren().add(baseNameLabel);

        nameInputBox = new TextArea();
        nameInputWrapper.getChildren().add(nameInputBox);
        nameInputBox.getStyleClass().add("attack-name-input");
        nameInputBox.setPrefRowCount(3);

        nameInputBox.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.ENTER){
                handelNameUpdate(elementalBurst);
            }
        });
        //#endregion

        VBox energyWrapper = new VBox();
        nameEnergyWrapper.getChildren().add(energyWrapper);
        energyWrapper.setAlignment(Pos.CENTER);

        EnergyCounterBox energyCounterBox = new EnergyCounterBox(character.getVisionElement());
        energyWrapper.getChildren().add(energyCounterBox);

        VBox rangeWrapper = new VBox();
        mainBox.getChildren().add(rangeWrapper);
        rangeWrapper.setAlignment(Pos.CENTER_LEFT);
        rangeWrapper.getStyleClass().addAll("attack-range");

        Label rangeLabel = new Label(elementalBurst.getRange());
        rangeWrapper.getChildren().add(rangeLabel);

        VBox toAffectWrapper = new VBox();
        mainBox.getChildren().add(toAffectWrapper);
        toAffectWrapper.setAlignment(Pos.CENTER_LEFT);
        toAffectWrapper.getStyleClass().addAll("attack-to-affect");

        if(elementalBurst.isSave()){
            HBox saveWrapper = new HBox();
            toAffectWrapper.getChildren().add(saveWrapper);

            VBox saveContainer = new VBox();
            saveWrapper.getChildren().add(saveContainer);
            saveContainer.setAlignment(Pos.CENTER);

            Label saveTypeLabel = new Label(elementalBurst.getSaveType(character).getNameAbbreviation());
            saveContainer.getChildren().add(saveTypeLabel);
            Label saveDCLabel = new Label(elementalBurst.getSaveDC(character)+"");
            saveContainer.getChildren().add(saveDCLabel);
        }else{
            ModifierBox modifierBox = new ModifierBox(elementalBurst.getStat(character).getModifier(), true, character.getProficiencyBonus());
            toAffectWrapper.getChildren().add(modifierBox);
            modifierBox.getStyleClass().addAll("attack-to-hit-label");
        }

        VBox effectWrapper = new VBox();
        mainBox.getChildren().add(effectWrapper);
        effectWrapper.setAlignment(Pos.CENTER_LEFT);
        effectWrapper.getStyleClass().addAll("attack-effect");

        HBox effectContainer = new HBox();
        effectWrapper.getChildren().add(effectContainer);

        VBox effectLabelWrapper = new VBox();
        effectContainer.getChildren().add(effectLabelWrapper);
        effectLabelWrapper.setAlignment(Pos.CENTER_LEFT);

        Label effectLabel = new Label(elementalBurst.getEffect().getEffect(character));
        effectLabelWrapper.getChildren().add(effectLabel);

        if(elementalBurst.getEffect().hasUnit()){
            Pane effectUnitImage = new Pane();
            effectContainer.getChildren().add(effectUnitImage);
            effectUnitImage.setStyle("-fx-background-image: url("+ elementalBurst.getEffect().getUnitURL()+");");
            effectUnitImage.getStyleClass().addAll("attack-effect-image", "element-image");
        }

        VBox notesWrapper = new VBox();
        mainBox.getChildren().add(notesWrapper);
        notesWrapper.setAlignment(Pos.CENTER_LEFT);
        notesWrapper.getStyleClass().addAll("attack-notes");

        FlowPane notesFlowPane = new FlowPane(5, 5);
        notesWrapper.getChildren().add(notesFlowPane);

        if(elementalBurst.appliesElement()){
            String appliesNoteString = "Applies "+elementalBurst.getEffect().getUnitString();
            if(!elementalBurst.getNotes().isEmpty()){
                appliesNoteString = appliesNoteString + ",";
            }
            Label appliesElementNoteLabel = new Label(appliesNoteString);
            notesFlowPane.getChildren().add(appliesElementNoteLabel);
        }

        ArrayList<String> notes = elementalBurst.getNotes();
        for (int i = 0; i < notes.size(); i++) {
            String noteString = notes.get(i);
            if(i < notes.size()-2){
                noteString = noteString+",";
            }
            Label noteLabel = new Label(noteString);
            notesFlowPane.getChildren().add(noteLabel);
        }
    }

    public AttackBoxBase(Character character, String attackTypeImageURL, ElementalSkill elementalSkill) {
        HBox mainBox = this;
        mainBox.getStyleClass().add("attack-box");
        mainBox.setSpacing(5);

        VBox attackTypeWrapper = new VBox();
        mainBox.getChildren().add(attackTypeWrapper);
        attackTypeWrapper.setAlignment(Pos.CENTER_LEFT);
        attackTypeWrapper.getStyleClass().addAll("attack-type");

        Pane attackTypeImage = new Pane();
        attackTypeWrapper.getChildren().add(attackTypeImage);
        attackTypeImage.setStyle("-fx-background-image: url("+attackTypeImageURL+");");
        attackTypeImage.getStyleClass().addAll("attack-type-image", "element-image");

        HBox nameEnergyWrapper = new HBox();
        mainBox.getChildren().add(nameEnergyWrapper);
        nameEnergyWrapper.getStyleClass().addAll("attack-name");
        //#region nameBox
        nameWrapper = new VBox();
        nameEnergyWrapper.getChildren().add(nameWrapper);
        nameWrapper.setAlignment(Pos.CENTER_LEFT);

        attackNameLabel = new Label(elementalSkill.getName());
        nameWrapper.getChildren().add(attackNameLabel);
        attackNameLabel.setStyle("-fx-wrap-text: true;");
        attackNameLabel.managedProperty().bind(attackNameLabel.visibleProperty());

        attackNameLabel.setOnMouseClicked(e -> {
            handleNameClick(elementalSkill);
        });

        nameInputWrapper = new VBox();
        nameWrapper.getChildren().add(nameInputWrapper);
        nameInputWrapper.managedProperty().bind(nameInputWrapper.visibleProperty());
        nameInputWrapper.setVisible(false);

        Label baseNameLabel = new Label(ElementalSkill.NAME_BASE);
        nameInputWrapper.getChildren().add(baseNameLabel);

        nameInputBox = new TextArea();
        nameInputWrapper.getChildren().add(nameInputBox);
        nameInputBox.getStyleClass().add("attack-name-input");
        nameInputBox.setPrefRowCount(3);

        nameInputBox.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.ENTER){
                handelNameUpdate(elementalSkill);
            }
        });
        //#endregion

        VBox rangeWrapper = new VBox();
        mainBox.getChildren().add(rangeWrapper);
        rangeWrapper.setAlignment(Pos.CENTER_LEFT);
        rangeWrapper.getStyleClass().addAll("attack-range");

        Label rangeLabel = new Label(elementalSkill.getRange());
        rangeWrapper.getChildren().add(rangeLabel);

        VBox toAffectWrapper = new VBox();
        mainBox.getChildren().add(toAffectWrapper);
        toAffectWrapper.setAlignment(Pos.CENTER_LEFT);
        toAffectWrapper.getStyleClass().addAll("attack-to-affect");

        if(elementalSkill.isSave()){
            HBox saveWrapper = new HBox();
            toAffectWrapper.getChildren().add(saveWrapper);

            VBox saveContainer = new VBox();
            saveWrapper.getChildren().add(saveContainer);
            saveContainer.setAlignment(Pos.CENTER);

            Label saveTypeLabel = new Label(elementalSkill.getSaveType(character).getNameAbbreviation());
            saveContainer.getChildren().add(saveTypeLabel);
            Label saveDCLabel = new Label(elementalSkill.getSaveDC(character)+"");
            saveContainer.getChildren().add(saveDCLabel);
        }else{
            ModifierBox modifierBox = new ModifierBox(elementalSkill.getStat(character).getModifier(), true, character.getProficiencyBonus());
            toAffectWrapper.getChildren().add(modifierBox);
            modifierBox.getStyleClass().addAll("attack-to-hit-label");
        }

        VBox effectWrapper = new VBox();
        mainBox.getChildren().add(effectWrapper);
        effectWrapper.setAlignment(Pos.CENTER_LEFT);
        effectWrapper.getStyleClass().addAll("attack-effect");

        HBox effectContainer = new HBox();
        effectWrapper.getChildren().add(effectContainer);

        VBox effectLabelWrapper = new VBox();
        effectContainer.getChildren().add(effectLabelWrapper);
        effectLabelWrapper.setAlignment(Pos.CENTER_LEFT);

        Label effectLabel = new Label(elementalSkill.getEffect().getEffect(character));
        effectLabelWrapper.getChildren().add(effectLabel);

        if(elementalSkill.getEffect().hasUnit()){
            Pane effectUnitImage = new Pane();
            effectContainer.getChildren().add(effectUnitImage);
            effectUnitImage.setStyle("-fx-background-image: url("+ elementalSkill.getEffect().getUnitURL()+");");
            effectUnitImage.getStyleClass().addAll("attack-effect-image", "element-image");
        }

        VBox notesWrapper = new VBox();
        mainBox.getChildren().add(notesWrapper);
        notesWrapper.setAlignment(Pos.CENTER_LEFT);
        notesWrapper.getStyleClass().addAll("attack-notes");

        FlowPane notesFlowPane = new FlowPane(5, 5);
        notesWrapper.getChildren().add(notesFlowPane);

        if(elementalSkill.appliesElement()){
            String appliesNoteString = "Applies "+elementalSkill.getEffect().getUnitString();
            if(!elementalSkill.getNotes().isEmpty()){
                appliesNoteString = appliesNoteString + ",";
            }
            Label appliesElementNoteLabel = new Label(appliesNoteString);
            notesFlowPane.getChildren().add(appliesElementNoteLabel);
        }

        ArrayList<String> notes = elementalSkill.getNotes();
        for (int i = 0; i < notes.size(); i++) {
            String noteString = notes.get(i);
            if(i < notes.size()-2){
                noteString = noteString+",";
            }
            Label noteLabel = new Label(noteString);
            notesFlowPane.getChildren().add(noteLabel);
        }
    }


    private void handleNameClick(ElementalBurst elementalBurst){
        nameInputBox.setText(elementalBurst.getCustomName());
        attackNameLabel.setVisible(false);
        nameInputWrapper.setVisible(true);
    }
    private void handleNameClick(ElementalSkill elementalSkill){
        nameInputBox.setText(elementalSkill.getCustomName());
        attackNameLabel.setVisible(false);
        nameInputWrapper.setVisible(true);
    }

    private void handelNameUpdate(ElementalBurst elementalBurst){
        elementalBurst.setCustomName(nameInputBox.getText());
        attackNameLabel.setText(elementalBurst.getName());
        attackNameLabel.setVisible(true);
        nameInputWrapper.setVisible(false);
    }
    private void handelNameUpdate(ElementalSkill elementalSkill){
        elementalSkill.setCustomName(nameInputBox.getText());
        attackNameLabel.setText(elementalSkill.getName());
        attackNameLabel.setVisible(true);
        nameInputWrapper.setVisible(false);
    }
}
