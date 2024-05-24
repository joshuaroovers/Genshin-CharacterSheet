package UIComponents;

import SheetComponents.Element;
import SheetComponents.HitPoints;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.util.Callback;


public class HitPointsBox extends HBox {



    private TextField healDmgInputBox;
    private Label currentHP;
    private TextField currentHPInput;
    private Label shieldHP;
    private TextField shieldHPInput;
    private HBox elemShieldDisplayValue;
    private Label elemShieldDisplayHP;
    private StackPane elemShieldDisplayTypeContainer;
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

        //#region display
        elemShieldDisplayValue = new HBox();
        elemShieldDisplayValue.getStyleClass().addAll("hp-tracker-label","hp-tracker-hp");
        elemShieldDisplayValue.managedProperty().bind(elemShieldDisplayValue.visibleProperty());
        elemShieldContainer.getChildren().add(elemShieldDisplayValue);

        elemShieldDisplayHP = new Label();

        elemShieldDisplayTypeContainer = new StackPane();
        elemShieldDisplayTypeContainer.getStyleClass().addAll("shield","hp-tracker-element");
        elemShieldDisplayTypeContainer.managedProperty().bind(elemShieldDisplayTypeContainer.visibleProperty());
        elemShieldDisplayTypeContainer.setVisible(false);

        elemShieldDisplayType = new Label();
        elemShieldDisplayTypeContainer.getChildren().add(elemShieldDisplayType);
        elemShieldDisplayType.getStyleClass().addAll("hp-tracker-element","element-image");


        elemShieldDisplayValue.getChildren().addAll(elemShieldDisplayHP, elemShieldDisplayTypeContainer);


        //#endregion

        //#region input
        elemShieldInputValue = new HBox();
        elemShieldInputValue.getStyleClass().addAll("hp-tracker-label");
        elemShieldInputValue.managedProperty().bind(elemShieldInputValue.visibleProperty());
        elemShieldInputValue.setVisible(false);
        elemShieldContainer.getChildren().add(elemShieldInputValue);


        elemShieldHPInput = new TextField();
        elemShieldHPInput.getStyleClass().add("hp-tracker-hp");
        elemShieldHPInput.setStyle("-fx-text-alignment: center; -fx-padding: 0;");

        elemShieldTypeInput = new ComboBox<Element>();
        elemShieldTypeInput.setStyle("-fx-min-width: 30; -fx-pref-width: 30; -fx-min-height: 30; -fx-pref-height: 30; -fx-padding: 0;");
        elemShieldTypeInput.setVisibleRowCount(4);
        elemShieldTypeInput.getItems().addAll(Element.PYRO, Element.HYDRO, Element.CRYO, Element.ELECTRO);

        //#region combobox nightmare things
        elemShieldTypeInput.setCellFactory(new Callback<ListView<Element>, ListCell<Element>>() {
            @Override
            public ListCell<Element> call(ListView<Element> param) {
                return new ListCell<Element>() {
                    private final Pane image;
                    {
                        setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
                        setStyle("-fx-padding: 0;");
                        image = new Pane();
                    }

                    @Override
                    protected void updateItem(Element item, boolean empty) {
                        super.updateItem(item, empty);

                        if (item == null || empty) {
                            setGraphic(null);
                        } else {
                            setMinWidth(30);
                            setMinHeight(30);
                            setPrefWidth(30);
                            setPrefHeight(30);
                            setMaxWidth(30);
                            setMaxHeight(30);

                            image.setStyle(
                                    "-fx-background-image: url("+ImageHelper.getElementURL(item,ImageVariant.FLAT)+");"
                            );
                            image.getStyleClass().add("element-image");
                            Tooltip tooltip = new Tooltip(item.toString());
                            Tooltip.install(image, tooltip);
                            setGraphic(image);
                        }
                    }
                };
            }
        });
        elemShieldTypeInput.setButtonCell(new ListCell<Element>() {
            private final StackPane shield = new StackPane();
            {
                setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
                setStyle("-fx-min-width: 30; -fx-pref-width: 30; -fx-min-height: 30; -fx-pref-height: 30; -fx-padding: 0;");
                shield.getStyleClass().add("shield");
            }

            @Override
            protected void updateItem(Element item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setGraphic(null);
                } else {
                    shield.getChildren().clear();
                    for (Element o : Element.values()) {
                        shield.getStyleClass().remove(o.toString());
                    }
                    shield.getStyleClass().addAll(item.toString());


                    Pane element = new Pane();
                    shield.getChildren().add(element);
                    element.setStyle(
                            "-fx-background-image: url("+ImageHelper.getElementURL(item,ImageVariant.FLAT)+");"
                    );
                    element.getStyleClass().addAll("element-image");

                    System.out.println(shield.getStyleClass());


                    Tooltip tooltip = new Tooltip(item.toString());
                    Tooltip.install(shield, tooltip);
                    setGraphic(shield);
                }
            }
        });
        //#endregion

        elemShieldInputValue.getChildren().addAll(elemShieldHPInput,elemShieldTypeInput);
        //#endregion input


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
        //#endregion elemental shield

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
//            System.out.println(hitPoints.getElementalShield());
            elemShieldDisplayHP.setText(Integer.toString(hitPoints.getElementalShield().getHP()));
            elemShieldDisplayTypeContainer.setVisible(true);
            elemShieldDisplayType.setStyle("-fx-background-image: url("+ImageHelper.getElementURL(hitPoints.getElementalShield().getElement(), ImageVariant.FLAT)+");");
            for (Element value : Element.values()) {
                elemShieldDisplayTypeContainer.getStyleClass().remove(value.toString());
            }
            elemShieldDisplayTypeContainer.getStyleClass().add(hitPoints.getElementalShield().getElement().toString());
//            System.out.println(elemShieldDisplayTypeContainer.getStyleClass());
        }else{
            elemShieldDisplayHP.setText("+");
            elemShieldDisplayType.setStyle("-fx-background-image: none;");
            elemShieldHPInput.clear();
            elemShieldTypeInput.setValue(null);
            elemShieldDisplayTypeContainer.setVisible(false);
        }
    }
}
