package UIComponents;

import SheetComponents.Element;
import SheetComponents.HitPoints;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class HitPointsBox extends HBox {

    private TextField healDmgInputBox;
    private Label currentHP;
    private Label shieldHP;
    private Label elemShieldHP;

    public HitPointsBox(HitPoints hitPoints) {
        HBox mainBox = this;
        mainBox.getStyleClass().add("hp-control-container");

        //#region heal/damage buttons area
        VBox healDmgBox = new VBox();
        healDmgBox.getStyleClass().add("hp-button-container");
        mainBox.getChildren().add(healDmgBox);

        //#region heal button
        Button healButton = new Button("Heal");
        healButton.getStyleClass().add("hp-button");
        healDmgBox.getChildren().add(healButton);

        healButton.setOnAction(e ->{
            if(!healDmgInputBox.getText().isEmpty()){
                hitPoints.adjustCurrentHP(Integer.parseInt(healDmgInputBox.getText()));

                updateHPPools(hitPoints);
            }
        });


        //#endregion heal button
        //healDmgInputBox
        healDmgInputBox = new TextField();
        healDmgInputBox.getStyleClass().add("hp-button");
        healDmgBox.getChildren().add(healDmgInputBox);
        //#region dmg button
        Button dmgButton = new Button("Damage");
        dmgButton.getStyleClass().add("hp-button");
        healDmgBox.getChildren().add(dmgButton);

        dmgButton.setOnAction(e ->{
            if(!healDmgInputBox.getText().isEmpty()){
                hitPoints.adjustCurrentHP(-Integer.parseInt(healDmgInputBox.getText()));

                updateHPPools(hitPoints);
            }
        });
        //#endregion dmg button

        //#endregion heal/damage buttons area

        //#region current/max hp
        VBox hpBox = new VBox();
        hpBox.getStyleClass().add("hp-sub-container-hp");
        mainBox.getChildren().add(hpBox);

        HBox hpSubBox = new HBox();
        hpBox.getChildren().add(hpSubBox);

        //#region current hp
        VBox currentHPBox = new VBox();
        currentHPBox.getStyleClass().add("hp-tracker-box");
        hpSubBox.getChildren().add(currentHPBox);

        Label currentHPLabel = new Label("Current");
        currentHPLabel.getStyleClass().add("hp-tracker-label");
        currentHP = new Label(Integer.toString(hitPoints.getCurrentHP()));
        currentHP.getStyleClass().addAll("hp-tracker-label","hp-tracker-hp");
        currentHPBox.getChildren().addAll(currentHPLabel,currentHP);
        //#endregion current hp

        Label currentMaxHpDivider = new Label("/");
        currentMaxHpDivider.getStyleClass().add("hp-tracker-slash");
        hpSubBox.getChildren().add(currentMaxHpDivider);

        //#region max hp
        VBox maxHPBox = new VBox();
        maxHPBox.getStyleClass().add("hp-tracker-box");
        hpSubBox.getChildren().add(maxHPBox);
        Label maxHPLabel = new Label("Max");
        maxHPLabel.getStyleClass().add("hp-tracker-label");
        Label maxHP = new Label(Integer.toString(hitPoints.getMaxHP()));
        maxHP.getStyleClass().addAll("hp-tracker-label","hp-tracker-hp");
        maxHPBox.getChildren().addAll(maxHPLabel,maxHP);
        //#endregion max hp

        Label hpDescriptionLabel = new Label("Hit Points");
        hpDescriptionLabel.getStyleClass().add("hp-tracker-descriptor");
        hpBox.getChildren().add(hpDescriptionLabel);
        //#endregion current/max hp


        VBox shieldsBox = new VBox();
        shieldsBox.getStyleClass().add("hp-sub-container");
        mainBox.getChildren().add(shieldsBox);

        HBox shieldsSubBox = new HBox();
        shieldsBox.getChildren().add(shieldsSubBox);

        //#region shield
        VBox shieldBox = new VBox();
        shieldBox.getStyleClass().add("hp-tracker-box");
        shieldsSubBox.getChildren().add(shieldBox);
        Label shieldLabel = new Label("Special");
        shieldLabel.getStyleClass().add("hp-tracker-label");
        shieldHP = new Label();
        shieldHP.getStyleClass().addAll("hp-tracker-label","hp-tracker-hp");
        updateShield(hitPoints);
        shieldBox.getChildren().addAll(shieldLabel,shieldHP);
        //#endregion shield

        //#region elemental shield
        VBox ElemShieldBox = new VBox();
        ElemShieldBox.getStyleClass().add("hp-tracker-box");
        shieldsSubBox.getChildren().add(ElemShieldBox);
        Label elemShieldLabel = new Label("Elemental");
        elemShieldLabel.getStyleClass().add("hp-tracker-label");
        elemShieldHP = new Label();
        elemShieldHP.getStyleClass().addAll("hp-tracker-label","hp-tracker-hp");
        updateElementalShield(hitPoints);
        //todo stackpane or smth for elemental type overlaping with the rest of the container
        ElemShieldBox.getChildren().addAll(elemShieldLabel,elemShieldHP);
        //#endregion elemental shield

        Label shieldsDescriptionLabel = new Label("Shields");
        shieldsDescriptionLabel.getStyleClass().add("hp-tracker-descriptor");
        shieldsBox.getChildren().add(shieldsDescriptionLabel);
    }

    private void updateHPPools(HitPoints hitPoints){
        currentHP.setText(Integer.toString(hitPoints.getCurrentHP()));
        updateShield(hitPoints);
        updateElementalShield(hitPoints);
    }

    private void updateShield(HitPoints hitPoints){
        if(hitPoints.getShieldHP() == 0){
            shieldHP.setText("--");
        }else{
            shieldHP.setText(Integer.toString(hitPoints.getShieldHP()));
        }
    }

    private void updateElementalShield(HitPoints hitPoints){
        if(hitPoints.getElementalShield() != null){
            elemShieldHP.setText(Integer.toString(hitPoints.getElementalShield().getHP()));
        }else{
            elemShieldHP.setText("--");
        }
    }
}
