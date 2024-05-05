package UIComponents;

import SheetComponents.HitPoints;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class HitPointsBox extends HBox {

    private TextField healDmgInputBox;

    public HitPointsBox(HitPoints hitPoints) {
        HBox mainBox = this;

        //#region heal/damage buttons area
        VBox healDmgBox = new VBox();
        mainBox.getChildren().add(healDmgBox);

        //#region heal button
        Button healButton = new Button("Heal");
        healDmgBox.getChildren().add(healButton);

        healButton.setOnAction(e ->{
            hitPoints.adjustCurrentHP(Integer.parseInt(healDmgInputBox.getText()));
        });


        //#endregion heal button
        //healDmgInputBox
        healDmgInputBox = new TextField();
        healDmgBox.getChildren().add(healDmgInputBox);
        //#region dmg button
        Button dmgButton = new Button("Damage");
        healDmgBox.getChildren().add(dmgButton);

        dmgButton.setOnAction(e ->{
            hitPoints.adjustCurrentHP(-Integer.parseInt(healDmgInputBox.getText()));
        });
        //#endregion dmg button

        //#endregion heal/damage buttons area

        //#region current/max hp
        HBox hpBox = new HBox();
        mainBox.getChildren().add(hpBox);

        //#region current hp
        VBox currentHPBox = new VBox();
        hpBox.getChildren().add(currentHPBox);
        Label currentHPLabel = new Label("current");
        Label currentHP = new Label(Integer.toString(hitPoints.getCurrentHP()));
        currentHPBox.getChildren().addAll(currentHPLabel,currentHP);
        //#endregion current hp
        //#region max hp
        VBox maxHPBox = new VBox();
        hpBox.getChildren().add(maxHPBox);
        Label maxHPLabel = new Label("max");
        Label maxHP = new Label(Integer.toString(hitPoints.getMaxHP()));
        maxHPBox.getChildren().addAll(maxHPLabel,maxHP);
        //#endregion max hp
        //#endregion current/max hp

        //#region max hp
        VBox shieldBox = new VBox();
        mainBox.getChildren().add(shieldBox);
        Label shieldLabel = new Label("shield");
        Label shieldHP = new Label();
        if(hitPoints.getShieldHP() == 0){
            shieldHP.setText("--");
        }else{
            shieldHP.setText(Integer.toString(hitPoints.getShieldHP()));
        }
        shieldBox.getChildren().addAll(shieldLabel,shieldHP);
        //#endregion max hp

        //#region max hp
        VBox ElemShieldBox = new VBox();
        mainBox.getChildren().add(ElemShieldBox);
        Label elemShieldLabel = new Label("elemental shield");
        Label elemShieldHP = new Label();
        if(hitPoints.getElementalShield() != null){
            elemShieldHP.setText(Integer.toString(hitPoints.getElementalShield().getHP()));
        }else{
            elemShieldHP.setText("--");
        }
        //todo stackpane or smth for elemental type overlaping with the rest of the container
        ElemShieldBox.getChildren().addAll(elemShieldLabel,elemShieldHP);
        //#endregion max hp
    }
}
