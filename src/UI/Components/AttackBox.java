package UI.Components;

import SheetComponents.Actions.Attacks.Attack;
import SheetComponents.Character;
import SheetComponents.Elements.Physical;
import SheetComponents.Weapons.Weapon;
import UI.Util.ImageHelper;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class AttackBox extends HBox {
    //components width add up to 690 (230 per section) (700 is absolute with minus 5*2 for padding)

    public AttackBox(Character character, Weapon weapon, Attack attack) {
        HBox mainBox = this;
        mainBox.getStyleClass().add("attack-box");
        mainBox.setStyle("-fx-border-color: black;");

        VBox attackTypeWrapper = new VBox();
        mainBox.getChildren().add(attackTypeWrapper);
        attackTypeWrapper.setAlignment(Pos.CENTER_LEFT);
        attackTypeWrapper.getStyleClass().addAll("attack-type");

        Pane attackTypeImage = new Pane();
        attackTypeWrapper.getChildren().add(attackTypeImage);
        attackTypeImage.setStyle("-fx-background-image: url("+ImageHelper.getWeaponURL(weapon)+");");
        attackTypeImage.getStyleClass().addAll("attack-type-image", "element-image");

        VBox nameWrapper = new VBox();
        mainBox.getChildren().add(nameWrapper);
        nameWrapper.setAlignment(Pos.CENTER_LEFT);
        nameWrapper.getStyleClass().addAll("attack-name");

        Label attackNameLabel = new Label(attack.getName());
        nameWrapper.getChildren().add(attackNameLabel);

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
            Label attackBonusLabel = new Label(attack.getStat(character).getModifierString());
            toAffectWrapper.getChildren().add(attackBonusLabel);
            attackBonusLabel.getStyleClass().addAll("attack-to-hit-label");
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
            effectUnitImage.setStyle("-fx-background-image: url("+ attack.getEffect().getUnitURL()+");");//TODO more images
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
            if(i < notes.size()-1){
                noteString = noteString+",";
            }
            Label noteLabel = new Label(noteString);
            notesFlowPane.getChildren().add(noteLabel);
        }
    }
}
