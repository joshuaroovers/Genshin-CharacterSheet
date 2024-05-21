package UIComponents;

import SheetComponents.Element;
import SheetComponents.HitPoints;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.stream.Collectors;


public class HitPointsBox extends HBox {


    private TextField healDmgInputBox;
    private Label currentHP;
    private TextField currentHPInput;
    private Label shieldHP;
    private TextField shieldHPInput;
    private HBox elemShieldDisplayValue;
    private Label elemShieldDisplayHP;
    private Label elemShieldDisplayType;
    private ComboBox<Element> elemShieldTypeInput;
    private HBox elemShieldInputValue;
    private TextField elemShieldHPInput;

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
                hitPoints.adjustCurrentHP(-Integer.parseInt(healDmgInputBox.getText()),Element.DENDRO);

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

        VBox currentHPSubBox = new VBox();
        currentHPSubBox.getStyleClass().add("hp-tracker-hp-box");

        currentHP = new Label(Integer.toString(hitPoints.getCurrentHP()));
        currentHPSubBox.getChildren().add(currentHP);
        currentHP.getStyleClass().addAll("hp-tracker-label","hp-tracker-hp");
        currentHP.managedProperty().bind(currentHP.visibleProperty());

        currentHPInput = new TextField(Integer.toString(hitPoints.getCurrentHP()));
        currentHPSubBox.getChildren().add(currentHPInput);
        currentHPInput.getStyleClass().addAll("hp-tracker-label","hp-tracker-hp");
        currentHPInput.managedProperty().bind(currentHPInput.visibleProperty());
        currentHPInput.setVisible(false);

        currentHP.setOnMouseClicked(e -> {
            currentHP.setVisible(false);
            currentHPInput.setVisible(true);
            currentHPInput.requestFocus();
        });
        currentHPInput.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.ENTER){
                hitPoints.setCurrentHP(Integer.parseInt(currentHPInput.getText()));
                updateHP(hitPoints);

                currentHP.setVisible(true);
                currentHPInput.setVisible(false);
            }
        });
        currentHPInput.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if(!newValue){
                hitPoints.setCurrentHP(Integer.parseInt(currentHPInput.getText()));
                updateHP(hitPoints);

                currentHP.setVisible(true);
                currentHPInput.setVisible(false);
            }
        });


        currentHPBox.getChildren().addAll(currentHPLabel,currentHPSubBox);
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
        maxHP.getStyleClass().addAll("hp-tracker-label","hp-tracker-hp","hp-tracker-hp-box");

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

        VBox shieldHPBox = new VBox();
        shieldHPBox.getStyleClass().add("hp-tracker-hp-box");

        shieldHP = new Label();
        shieldHPBox.getChildren().add(shieldHP);
        shieldHP.getStyleClass().addAll("hp-tracker-label","hp-tracker-hp");
        shieldHP.managedProperty().bind(shieldHP.visibleProperty());

        shieldHPInput = new TextField();
        shieldHPBox.getChildren().add(shieldHPInput);
        shieldHPInput.getStyleClass().addAll("hp-tracker-label","hp-tracker-hp");
        shieldHPInput.managedProperty().bind(shieldHPInput.visibleProperty());
        shieldHPInput.setVisible(false);

        shieldHP.setOnMouseClicked(e -> {
            shieldHP.setVisible(false);
            shieldHPInput.setVisible(true);
            shieldHPInput.requestFocus();
        });
        shieldHPInput.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.ENTER){
                hitPoints.setShieldHP(Integer.parseInt(shieldHPInput.getText()));
                updateShield(hitPoints);

                shieldHP.setVisible(true);
                shieldHPInput.setVisible(false);
            }
        });
        shieldHPInput.focusedProperty().addListener(new ChangeListener<Boolean>(){

            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue){
                    hitPoints.setShieldHP(Integer.parseInt(shieldHPInput.getText()));
                    updateShield(hitPoints);

                    shieldHP.setVisible(true);
                    shieldHPInput.setVisible(false);
                }
            }
        });

        updateShield(hitPoints);
        shieldBox.getChildren().addAll(shieldLabel,shieldHPBox);
        //#endregion shield

        //#region elemental shield
        VBox elemShieldDisplayBox = new VBox();
        elemShieldDisplayBox.getStyleClass().add("hp-tracker-box");
        shieldsSubBox.getChildren().add(elemShieldDisplayBox);
        Label elemShieldDisplayLabel = new Label("Elemental");
        elemShieldDisplayBox.getChildren().add(elemShieldDisplayLabel);
        elemShieldDisplayLabel.getStyleClass().add("hp-tracker-label");

        VBox elemShieldContainer = new VBox();
        elemShieldContainer.getStyleClass().add("hp-tracker-hp-box");
        elemShieldDisplayBox.getChildren().add(elemShieldContainer);

        elemShieldDisplayValue = new HBox();
        elemShieldDisplayValue.getStyleClass().addAll("hp-tracker-label","hp-tracker-hp");
        elemShieldDisplayValue.managedProperty().bind(elemShieldDisplayValue.visibleProperty());
        elemShieldContainer.getChildren().add(elemShieldDisplayValue);

        elemShieldDisplayHP = new Label();
        elemShieldDisplayType = new Label();
        elemShieldDisplayType.getStyleClass().addAll("hp-tracker-element","element-image");
        elemShieldDisplayType.managedProperty().bind(elemShieldDisplayType.visibleProperty());
        elemShieldDisplayType.setVisible(false);

        elemShieldDisplayValue.getChildren().addAll(elemShieldDisplayHP, elemShieldDisplayType);


        //#endregion elemental shield

        //#region elemental shield input box whatever
        elemShieldInputValue = new HBox();
        elemShieldInputValue.getStyleClass().addAll("hp-tracker-label");
        elemShieldInputValue.managedProperty().bind(elemShieldInputValue.visibleProperty());
        elemShieldInputValue.setVisible(false);
        elemShieldContainer.getChildren().add(elemShieldInputValue);


        elemShieldHPInput = new TextField();
        elemShieldHPInput.getStyleClass().add("hp-tracker-hp");

        elemShieldTypeInput = new ComboBox<Element>();
        elemShieldTypeInput.setStyle("-fx-pref-width: 30; -fx-max-width: 30; -fx-pref-height: 50; -fx-padding: 0;");
        for (Element value : Element.values()) {
            elemShieldTypeInput.getItems().add(value);
        }
        //#region combobox nightmare things
        elemShieldTypeInput.setCellFactory(new Callback<ListView<Element>, ListCell<Element>>() {
            @Override
            public ListCell<Element> call(ListView<Element> param) {
                return new ListCell<Element>() {
                    private final Pane image;
                    {
                        setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
                        setStyle("-fx-max-width: 40; -fx-pref-height: 40; -fx-padding: 2; -fx-alignment: center;");
                        image = new Pane();
                    }

                    @Override
                    protected void updateItem(Element item, boolean empty) {
                        super.updateItem(item, empty);

                        if (item == null || empty) {
                            setGraphic(null);
                        } else {
                            image.setStyle(
                                    "-fx-background-image: url("+ImageHelper.getElementURL(item,ImageVariant.FLAT)+");" +
                                    "-fx-background-position: center;" +
                                    "-fx-background-size: contain;" +
                                    "-fx-background-repeat: no-repeat;"
                            );
                            Tooltip tooltip = new Tooltip(item.toString());
                            Tooltip.install(image, tooltip);
                            setGraphic(image);
                        }
                    }
                };
            }
        });
        elemShieldTypeInput.setButtonCell(new ListCell<Element>() {
            private final Pane image = new Pane();
            {
                setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
                setStyle("-fx-max-width: 40; -fx-pref-height: 40; -fx-padding: 0; -fx-alignment: center;");
            }

            @Override
            protected void updateItem(Element item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setGraphic(null);
                } else {
                    image.setStyle(
                            "-fx-background-image: url("+ImageHelper.getElementURL(item,ImageVariant.FLAT)+");" +
                            "-fx-background-position: center;" +
                            "-fx-background-size: contain;" +
                            "-fx-background-repeat: no-repeat;"
                    );
                    Tooltip tooltip = new Tooltip(item.toString());
                    Tooltip.install(image, tooltip);
                    setGraphic(image);
                }
            }
        });
        //#endregion

        elemShieldInputValue.getChildren().addAll(elemShieldHPInput,elemShieldTypeInput);

        //#endregion elemental shield

        elemShieldDisplayValue.setOnMouseClicked(e -> {
            elemShieldDisplayValue.setVisible(false);
            elemShieldInputValue.setVisible(true);

            if(hitPoints.getElementalShield() != null){
                elemShieldHPInput.requestFocus();
            }else{
                elemShieldTypeInput.requestFocus();
                elemShieldTypeInput.show();
            }

        });
        elemShieldHPInput.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.ENTER){
                if(!elemShieldHPInput.getText().isEmpty() && elemShieldTypeInput.getValue() != null){
                    hitPoints.setElementalShield(Integer.parseInt(elemShieldHPInput.getText()), elemShieldTypeInput.getValue());
                    updateElementalShield(hitPoints);
                }

                elemShieldDisplayValue.setVisible(true);
                elemShieldInputValue.setVisible(false);
                elemShieldDisplayType.setVisible(true);
            }
        });


        updateElementalShield(hitPoints);

        Label shieldsDescriptionLabel = new Label("Shields");
        shieldsDescriptionLabel.getStyleClass().add("hp-tracker-descriptor");
        shieldsBox.getChildren().add(shieldsDescriptionLabel);
    }

    private void updateHPPools(HitPoints hitPoints){
        updateHP(hitPoints);
        updateShield(hitPoints);
        updateElementalShield(hitPoints);
    }

    private void updateHP(HitPoints hitPoints){
        currentHP.setText(Integer.toString(hitPoints.getCurrentHP()));
        currentHPInput.setText(Integer.toString(hitPoints.getCurrentHP()));
    }

    private void updateShield(HitPoints hitPoints){
        if(hitPoints.getShieldHP() == 0){
            shieldHP.setText("--");
            shieldHPInput.setText(Integer.toString(0));
        }else{
            shieldHP.setText(Integer.toString(hitPoints.getShieldHP()));
            shieldHPInput.setText(Integer.toString(hitPoints.getShieldHP()));
        }
    }

    private void updateElementalShield(HitPoints hitPoints){
        if(hitPoints.getElementalShield() != null){
            elemShieldDisplayHP.setText(Integer.toString(hitPoints.getElementalShield().getHP()));
            elemShieldDisplayType.setStyle("-fx-background-image: url("+ImageHelper.getElementURL(hitPoints.getElementalShield().getElement(), ImageVariant.FLAT)+");");
        }else{
            elemShieldDisplayHP.setText("+");
            elemShieldDisplayType.setStyle("-fx-background-image: none;");
            elemShieldHPInput.clear();
            elemShieldTypeInput.setValue(null);
            elemShieldDisplayType.setVisible(false);
        }
    }
}
