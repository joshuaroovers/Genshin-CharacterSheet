package GenshinCharacterSheet.UI.Components;

import GenshinCharacterSheet.SheetComponents.Conditions.Condition;
import GenshinCharacterSheet.SheetComponents.ElementalReactions.ElementalReactionHelper;
import GenshinCharacterSheet.SheetComponents.ElementalReactions.Reaction;
import GenshinCharacterSheet.SheetComponents.Elements.Anemo;
import GenshinCharacterSheet.SheetComponents.Elements.Element;
import GenshinCharacterSheet.SheetComponents.Elements.Geo;
import GenshinCharacterSheet.UI.Util.ImageHelper;
import GenshinCharacterSheet.UI.Util.ImageElementVariant;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.util.ArrayList;
import java.util.Collections;

public class ConditionsBox extends VBox {

    private ArrayList<Condition> conditions = new ArrayList<>();

    private final String conditionsLabelText = "Conditions";
    private final FlowPane conditionsContainer;
    private ComboBox<Condition> conditionSelector;
    private final Label addConditionButton;

    private final String elementsLabelText = "Element";
    private final Button clearButton;
    private final StackPane elementSelector1Stack;
    private final ComboBox<Element> elementSelector1;
    private final HBox elementDisplay1;
    private final StackPane elementSelector2Stack;
    private final ComboBox<Element> elementSelector2;
    private final HBox elementDisplay2;
    private final Label reactionLabel;

    public ConditionsBox(Stage stage) {
        VBox mainBox = this;
        mainBox.getStyleClass().add("conditions-box");
        mainBox.setSpacing(2);

        Label mainLabel = new Label(conditionsLabelText);
        mainBox.getChildren().add(mainLabel);
        mainLabel.setStyle("-fx-padding: 0 0 0 5;");

        //#region conditions
        conditions.addAll(Condition.getAllConditions());

        conditionsContainer = new FlowPane();
        mainBox.getChildren().add(conditionsContainer);

        conditionsContainer.setStyle("-fx-border-color: black; -fx-padding: 0 0 0 5;");

        //#regino conditionSelector

        createConditionsSelector();

        //#endregion

        addConditionButton = new Label("+");
        conditionsContainer.getChildren().add(addConditionButton);

        addConditionButton.setOnMouseClicked(e -> {
            conditionSelector.setVisible(true);

            conditionSelector.requestFocus();
            conditionSelector.show();
            conditionSelector.hide(); //without this it misplaces the dropdown when shown for the first time
            conditionSelector.show();
        });

        conditionSelector.focusedProperty().addListener(new ChangeListener<Boolean>(){

            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue){
                    conditionSelector.setVisible(false);
                }
            }
        });
        //#endregion

        //#region elements
        HBox elementsContainer = new HBox(5);
        mainBox.getChildren().add(elementsContainer);
        elementsContainer.setStyle("-fx-border-color: black; -fx-padding: 0 0 0 5;");

        BorderPane conditionElementLeftWrapper = new BorderPane();
        elementsContainer.getChildren().add(conditionElementLeftWrapper);
        conditionElementLeftWrapper.setStyle("-fx-min-width: 70; -fx-max-width: 70; -fx-alignment: center;"); //this should size the with to the label width BUT NO so hardcoded it is

        Label elementsLabel = new Label(elementsLabelText);
        conditionElementLeftWrapper.setTop(elementsLabel);
        elementsLabel.setStyle("-fx-text-alignment: center; -fx-pref-width: 9999;");

        //#region tooltip
        StackPane reactionsToolTipStack = new StackPane();
        conditionElementLeftWrapper.setCenter(reactionsToolTipStack);

        Pane reactionsToolTipBacking = new Pane();
        reactionsToolTipStack.getChildren().add(reactionsToolTipBacking);
        reactionsToolTipBacking.setStyle("-fx-border-color: black; -fx-border-radius: 10; -fx-max-width: 20; -fx-max-height: 20;");

        HBox reactionsToolTipWrapper = new HBox();
        reactionsToolTipStack.getChildren().add(reactionsToolTipWrapper);
        reactionsToolTipWrapper.setStyle("-fx-alignment: center;");

        Label reactionsToolTip = new Label("i");
        reactionsToolTipWrapper.getChildren().add(reactionsToolTip);
        reactionsToolTip.setStyle("-fx-text-alignment: center;");

        Popup popup = new Popup();
        VBox tooltip = new VBox();
        tooltip.setStyle("-fx-border-color: black; -fx-background-color: white; -fx-padding: 10");
        tooltip.getStyleClass().add("");
        popup.getContent().add(tooltip);
        for (Reaction reaction : Reaction.getAllReactions()) {
            //#region reaction info
            VBox reactionWrapper = new VBox();
            tooltip.getChildren().add(reactionWrapper);

            HBox basicInfoWrapper = new HBox(10);
            reactionWrapper.getChildren().add(basicInfoWrapper);

            Label reactionNameLabel = new Label(reaction.getName());
            basicInfoWrapper.getChildren().add(reactionNameLabel);
            reactionNameLabel.getStyleClass().add("condition-element-tooltip-label");

            HBox reactionElementsWrapper = new HBox();
            basicInfoWrapper.getChildren().add(reactionElementsWrapper);

            Pane element1Image = new Pane();
            reactionElementsWrapper.getChildren().add(element1Image);
            element1Image.getStyleClass().addAll("element-image","condition-element-tooltip-image");
            element1Image.setStyle("-fx-background-image: url("+ ImageHelper.getElementURL(reaction.getElement1(), ImageElementVariant.FLAT)+");");

            Label elementPlusLabel = new Label("+");
            reactionElementsWrapper.getChildren().add(elementPlusLabel);
            elementPlusLabel.getStyleClass().add("condition-element-tooltip-label");

            if(reaction.hasOtherElements()){
                ArrayList<Element> otherElements = reaction.getOtherElements();
                int otherElementsCount = otherElements.size();

                for (Element element : otherElements) {
                    otherElementsCount--;
                    Pane elementImage = new Pane();
                    reactionElementsWrapper.getChildren().add(elementImage);
                    elementImage.getStyleClass().addAll("element-image","condition-element-tooltip-image");
                    elementImage.setStyle("-fx-background-image: url("+ ImageHelper.getElementURL(element, ImageElementVariant.FLAT)+");");

                    if(otherElementsCount > 0){
                        Label elementSlashLabel = new Label("/");
                        reactionElementsWrapper.getChildren().add(elementSlashLabel);
                        elementSlashLabel.getStyleClass().add("condition-element-tooltip-label");
                    }
                }
            }
            else{
                Pane element2Image = new Pane();
                reactionElementsWrapper.getChildren().add(element2Image);
                element2Image.getStyleClass().addAll("element-image","condition-element-tooltip-image");
                element2Image.setStyle("-fx-background-image: url("+ ImageHelper.getElementURL(reaction.getElement2(), ImageElementVariant.FLAT)+");");
            }

            Label reactionDescriptionLabel = new Label(reaction.getDescription());
            reactionWrapper.getChildren().add(reactionDescriptionLabel);
            reactionDescriptionLabel.getStyleClass().add("condition-element-tooltip-description-label");
            //#endregion
        }


        reactionsToolTip.setOnMouseEntered(e -> {
            final double miscXOffset = 9;
            final double miscYOffset = 38;

            double xOffset = - tooltip.getBoundsInLocal().getWidth() - 30;
            double yOffset = (reactionsToolTip.getBoundsInLocal().getHeight()/2) - (tooltip.getBoundsInLocal().getHeight()/2);

            double x = stage.getX()+reactionsToolTip.localToScene(reactionsToolTip.getBoundsInLocal()).getMinX() + miscXOffset +xOffset;
            double y = stage.getY()+reactionsToolTip.localToScene(reactionsToolTip.getBoundsInLocal()).getMinY() + miscYOffset +yOffset;

            popup.show(reactionsToolTip,  x, y); //TODO misaligned on first view
        });

        reactionsToolTip.setOnMouseExited(e -> {
            popup.hide();
        });
        //#endregion

        StackPane elementsStackPane = new StackPane();
        elementsContainer.getChildren().add(elementsStackPane);
        elementsStackPane.setStyle("-fx-alignment: center;");

        HBox elementWrapper = new HBox(5);
        elementsStackPane.getChildren().add(elementWrapper);
        elementWrapper.setStyle("-fx-alignment: center;");

        //#region selector1
        elementSelector1Stack = new StackPane();
        elementWrapper.getChildren().add(elementSelector1Stack);

        elementDisplay1 = new HBox();
        elementSelector1Stack.getChildren().add(elementDisplay1);
        elementDisplay1.getStyleClass().addAll("condition-element", "element-image");
        elementDisplay1.managedProperty().bind(elementDisplay1.visibleProperty());

        elementSelector1 = new ComboBox<>();
        elementSelector1Stack.getChildren().add(elementSelector1);
        elementSelector1.getStyleClass().addAll("condition-element","condition-element-selector","combo-box");

        elementSelector1.managedProperty().bind(elementSelector1.visibleProperty());
        elementSelector1.setVisible(false);


        elementDisplay1.setOnMouseClicked(e -> {
            elementDisplay1.setVisible(false);
            elementSelector1.setVisible(true);

            elementSelector1.requestFocus();
            elementSelector1.show();
            elementSelector1.hide(); //without this it misplaces the dropdown when shown for the first time
            elementSelector1.show();
        });
        elementSelector1.focusedProperty().addListener(new ChangeListener<Boolean>(){

            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue){
                    elementSelector1.setVisible(false);
                    elementDisplay1.setVisible(true);
                }
            }
        });

        for (Element element : Element.getAll()) {
            ArrayList<Element> items = new ArrayList<>();
            if(!(element.getClass().equals(Geo.class)) && !(element.getClass().equals(Anemo.class)) ){
                items.add(element);
            }
            Collections.sort(items);
            elementSelector1.getItems().addAll(items);
        }


        //#region selector1 combobox
        elementSelector1.setButtonCell(new ListCell<Element>(){
            {
                setStyle("-fx-padding: 0 0 0 0;");
            }

            @Override
            protected void updateItem(Element item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setGraphic(null);
                } else {

                    Pane element = new Pane();
                    element.setStyle(
                            "-fx-background-image: url("+ ImageHelper.getElementURL(item, ImageElementVariant.FLAT)+");"
                    );
                    element.getStyleClass().addAll("element-image");

                    Tooltip tooltip = new Tooltip(item.toString());
                    Tooltip.install(element, tooltip);
                    setGraphic(element);
                }
            }
        });
        elementSelector1.setCellFactory(new Callback<ListView<Element>, ListCell<Element>>() {
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
                            setMinWidth(50);
                            setMinHeight(50);
                            setPrefWidth(50);
                            setPrefHeight(50);
                            setMaxWidth(50);
                            setMaxHeight(50);

                            image.setStyle(
                                    "-fx-background-image: url("+ ImageHelper.getElementURL(item, ImageElementVariant.FLAT)+");"
                            );
                            image.getStyleClass().add("element-image");
                            Tooltip tooltip = new Tooltip(item.getName());
                            Tooltip.install(image, tooltip);
                            setGraphic(image);
                        }
                    }
                };
            }
        });
        elementSelector1.valueProperty().addListener(new ChangeListener<Element>() {
            @Override
            public void changed(ObservableValue<? extends Element> observable, Element oldValue, Element newValue) {
                if(newValue != null){
                    selectedFirstElement();
                }
            }
        });
        //#endregion

        //#endregion

        //#region selector2
        elementSelector2Stack = new StackPane();
        elementWrapper.getChildren().add(elementSelector2Stack);
        elementSelector2Stack.managedProperty().bind(elementSelector2Stack.visibleProperty());
        elementSelector2Stack.setVisible(false);

        elementDisplay2 = new HBox();
        elementSelector2Stack.getChildren().add(elementDisplay2);
        elementDisplay2.getStyleClass().addAll("condition-element", "element-image");
        elementDisplay2.managedProperty().bind(elementDisplay2.visibleProperty());
        elementDisplay2.setVisible(false);

        elementSelector2 = new ComboBox<>();
        elementSelector2Stack.getChildren().add(elementSelector2);
        elementSelector2.getStyleClass().addAll("condition-element","condition-element-selector","combo-box");
        elementSelector2.managedProperty().bind(elementSelector2.visibleProperty());
        elementSelector2.setVisible(false);

        elementDisplay2.setOnMouseClicked(e -> {
            elementDisplay2.setVisible(false);
            elementSelector2.setVisible(true);

            elementSelector2.requestFocus();
            elementSelector2.show();
            elementSelector2.hide(); //without this it misplaces the dropdown when shown for the first time
            elementSelector2.show();
        });
        elementSelector2.focusedProperty().addListener(new ChangeListener<Boolean>(){

            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue){
                    elementSelector2.setVisible(false);
                    elementDisplay2.setVisible(true);
                }
            }
        });

        //#region selector2 combobox
        elementSelector2.setButtonCell(new ListCell<Element>(){
            {
                setStyle("-fx-padding: 0 0 0 0;");
            }

            @Override
            protected void updateItem(Element item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setGraphic(null);
                } else {

                    Pane element = new Pane();
                    element.setStyle(
                            "-fx-background-image: url("+ ImageHelper.getElementURL(item, ImageElementVariant.FLAT)+");"
                    );
                    element.getStyleClass().addAll("element-image");

                    Tooltip tooltip = new Tooltip(item.toString());
                    Tooltip.install(element, tooltip);
                    setGraphic(element);
                }
            }
        });
        elementSelector2.setCellFactory(new Callback<ListView<Element>, ListCell<Element>>() {
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
                            setMinWidth(50);
                            setMinHeight(50);
                            setPrefWidth(50);
                            setPrefHeight(50);
                            setMaxWidth(50);
                            setMaxHeight(50);

                            image.setStyle(
                                    "-fx-background-image: url("+ ImageHelper.getElementURL(item, ImageElementVariant.FLAT)+");"
                            );
                            image.getStyleClass().add("element-image");
                            Tooltip tooltip = new Tooltip(item.getName());
                            Tooltip.install(image, tooltip);
                            setGraphic(image);
                        }
                    }
                };
            }
        });
        elementSelector2.valueProperty().addListener(new ChangeListener<Element>() {
            @Override
            public void changed(ObservableValue<? extends Element> observable, Element oldValue, Element newValue) {
                if(newValue != null){
                    selectedSecondElement();
                }
            }
        });

        //#endregion

        //#endregion

        reactionLabel = new Label("Error");
        elementsStackPane.getChildren().add(reactionLabel);
        reactionLabel.getStyleClass().add("condition-elemental-reaction-label");
        reactionLabel.managedProperty().bind(reactionLabel.visibleProperty());
        reactionLabel.setVisible(false);


        HBox clearButtonWrapper = new HBox();
        elementsContainer.getChildren().add(clearButtonWrapper);
        clearButtonWrapper.getStyleClass().addAll("condition-elements-clear-wrapper");

        clearButton = new Button("X");
        clearButtonWrapper.getChildren().add(clearButton);
        clearButton.setStyle("-fx-border-color: black; -fx-padding: 0 5 0 5");
        clearButton.managedProperty().bind(clearButton.visibleProperty());
        clearButton.setVisible(false);

        clearButton.setOnAction(e -> {
            System.out.println("clear button pressed!");
            clearElements();
        });

        //#endregion

    }

    private void createConditionsSelector(){
        //TODO this feels so incredibly gross but it does work so.. (cuz it won't let me consistantly update the combobox items and the only way to do so is by throwing away the old one and making a new one)
        conditionSelector = new ComboBox<>();
        conditionsContainer.getChildren().add(conditionSelector);
        conditionSelector.getStyleClass().add("condition-selector");
        conditionSelector.getItems().addAll(conditions);
        conditionSelector.managedProperty().bind(conditionSelector.visibleProperty());
        conditionSelector.setVisible(false);

        conditionSelector.setButtonCell(new ListCell<Condition>(){
            private final Label condition;
            {
                setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
                setStyle("-fx-padding: 2;");
                condition = new Label();
            }

            @Override
            protected void updateItem(Condition item, boolean empty) {
                super.updateItem(item, empty);
                if (item == null || empty) {
                    setGraphic(null);
                } else {
                    condition.setText(item.getName());
                    Tooltip tooltip = new Tooltip(item.getDescription());
                    Tooltip.install(condition, tooltip);
                    setGraphic(condition);
                }
            }
        });
        conditionSelector.setCellFactory(new Callback<ListView<Condition>, ListCell<Condition>>() {
            @Override
            public ListCell<Condition> call(ListView<Condition> param) {
                return new ListCell<Condition>() {
                    private final Label condition;
                    {
                        setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
//                        setStyle("-fx-padding: 0;");
                        condition = new Label();
                    }
                    @Override
                    protected void updateItem(Condition item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item == null || empty) {
                            setGraphic(null);
                        } else {
                            condition.setText(item.getName());
                            Tooltip tooltip = new Tooltip(item.getDescription());
                            Tooltip.install(condition, tooltip);
                            setGraphic(condition);
                        }
                    }
                };
            }
        });
        conditionSelector.valueProperty().addListener(new ChangeListener<Condition>() {
            @Override
            public void changed(ObservableValue<? extends Condition> observable, Condition oldValue, Condition newValue) {
                if(conditions.contains(newValue)){
                    addCondition(newValue); //TODO gives an error?
                }
            }
        });
        conditionSelector.focusedProperty().addListener(new ChangeListener<Boolean>(){

            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue){
                    conditionSelector.setVisible(false);
                }
            }
        });
    }
    private void addCondition(Condition condition){
        conditions.remove(condition);

        //TODO this feels so incredibly gross but it does work so..
        conditionsContainer.getChildren().remove(conditionSelector);
        createConditionsSelector();
        //TODO

        StackPane newConditionLabelStack = new StackPane();
        conditionsContainer.getChildren().add(newConditionLabelStack);
        newConditionLabelStack.setStyle("-fx-alignment: center-right");

        Label newConditionLabel = new Label(condition.getName());
        newConditionLabelStack.getChildren().add(newConditionLabel);
        newConditionLabel.setStyle("-fx-padding: 0 10 0 0;");
        Tooltip tooltip = new Tooltip(condition.getDescription());
        Tooltip.install(newConditionLabel, tooltip);

        Label deleteConditionButton = new Label("x");
        newConditionLabelStack.getChildren().add(deleteConditionButton);
        deleteConditionButton.setStyle("-fx-text-fill: red;");
        deleteConditionButton.managedProperty().bind(deleteConditionButton.visibleProperty());
        deleteConditionButton.setVisible(false);

        newConditionLabelStack.setOnMouseEntered(e ->{
            deleteConditionButton.setVisible(true);
        });

        newConditionLabelStack.setOnMouseExited(e ->{
            deleteConditionButton.setVisible(false);
        });

        deleteConditionButton.setOnMouseClicked(e -> {
            conditionsContainer.getChildren().remove(newConditionLabelStack);
            removeCondition(condition);
        });


        conditionSelector.toFront();
        addConditionButton.toFront();
    }
    private void removeCondition(Condition condition){
        conditions.add(condition);
        Collections.sort(conditions);

        //TODO this feels so incredibly gross but it does work so..
        conditionsContainer.getChildren().remove(conditionSelector);
        createConditionsSelector();
        //TODO

        conditionSelector.toFront();
        addConditionButton.toFront();
    }

    private void clearElements(){
        clearButton.setVisible(false);

        elementSelector1.valueProperty().set(null);
        elementDisplay1.setStyle("-fx-background-image: none;");
        elementDisplay1.setDisable(false);

        elementSelector2Stack.setVisible(false);
        elementSelector2.valueProperty().set(null);
        elementDisplay2.setStyle("-fx-background-image: none;");
        elementDisplay2.setDisable(false);

        reactionLabel.setVisible(false);
        reactionLabel.setText("Error");
        reactionLabel.setStyle("");
    }
    private void selectedFirstElement(){
        Element element = elementSelector1.getValue();
        if(element != null){

            clearButton.setVisible(true);

            elementDisplay1.setVisible(true);
            elementDisplay1.setStyle("-fx-background-image: url("+ ImageHelper.getElementURL(element, ImageElementVariant.FLAT)+");");
            elementDisplay1.setDisable(true);
            elementSelector1.setVisible(false);

            elementSelector2Stack.setVisible(true);
            elementDisplay2.setVisible(true);
            elementSelector2.setVisible(false);

            System.out.println("filling selector2"); //TODO currently gets triggered twice
            elementSelector2.getItems().clear();
            ArrayList<Element> items = new ArrayList<>();
            for (Reaction reaction : ElementalReactionHelper.getReactions(element)) {
                Element reactionElement;
                if(reaction.getElement1().getClass().equals(element.getClass())){
                    reactionElement = reaction.getElement2();
                }else{
                    reactionElement = reaction.getElement1();
                }
                items.add(reactionElement);
            }
            Collections.sort(items);
            elementSelector2.getItems().addAll(items);

        }


    }
    private void selectedSecondElement(){
        Element element1 = elementSelector1.getValue();
        Element element2 = elementSelector2.getValue();

        elementDisplay2.setVisible(true);
        elementDisplay2.setStyle("-fx-background-image: url("+ ImageHelper.getElementURL(element2, ImageElementVariant.FLAT)+");");            elementDisplay1.setDisable(true);
        elementDisplay2.setDisable(true);
        elementSelector2.setVisible(false);
        reactionLabel.setVisible(true);

        Reaction reaction = ElementalReactionHelper.getReaction(element1, element2);
        reactionLabel.setText(reaction.getName());

        Color bC = reaction.getColor().brighter().brighter().brighter().desaturate().desaturate();
        reactionLabel.setStyle("-fx-text-fill: "+reaction.getColorHex()+"; -fx-effect: dropshadow(gaussian, rgb("+bC.getRed()*255+","+bC.getGreen()*255+","+bC.getBlue()*255+"), 10, 0.7, 0.0, 0.0);");

    }
}
