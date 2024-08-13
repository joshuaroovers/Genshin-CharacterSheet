package UIComponents;

import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class ConditionsBox extends VBox {

    private final String conditionsLabel = "Conditions";

    private final int elementBoxSize = 50;

    public ConditionsBox(Stage stage) {
        VBox mainBox = this;
        mainBox.getStyleClass().add("conditions-box");
        mainBox.setSpacing(5);

        Label mainLabel = new Label(conditionsLabel);
        mainBox.getChildren().add(mainLabel);

        //#region conditions
        HBox conditionsContainer = new HBox();
        mainBox.getChildren().add(conditionsContainer);
        conditionsContainer.setStyle("-fx-border-color: black;");
        //TODO make a floating ChoiceBox? using a stackpane (hopefully) and have it switch with a smaller display list (just like shield inputs)
        Label placeHolderLabel = new Label("Burning, Frozen, Quickened");
        conditionsContainer.getChildren().add(placeHolderLabel);
        //#endregion

        //#region elements
        StackPane elementsContainer = new StackPane();
        mainBox.getChildren().add(elementsContainer);
        elementsContainer.setStyle("-fx-border-color: black;");

        VBox elementLabelWrapper = new VBox();
        elementsContainer.getChildren().add(elementLabelWrapper);




        HBox elementsRow = new HBox();
        elementsContainer.getChildren().add(elementsRow);

        BorderPane reactionsToolTipWrapper = new BorderPane();
        elementsRow.getChildren().add(reactionsToolTipWrapper);
        reactionsToolTipWrapper.setStyle("-fx-min-width: 65; -fx-max-width: 65; -fx-alignment: center"); //this should size the with to the label width BUT NO so hardcoded it is

        Label elementsLabel = new Label("Element");
        reactionsToolTipWrapper.setTop(elementsLabel);
        elementsLabel.setStyle("-fx-min-width: 100;");
        //#region tooltip
        Label reactionsToolTip = new Label("i");
        reactionsToolTipWrapper.setCenter(reactionsToolTip);
        reactionsToolTip.setStyle("-fx-border-color: black; -fx-max-width: 15; -fx-max-height: 15; -fx-text-alignment: center;");

        Popup popup = new Popup();
        VBox tooltip = new VBox();
        tooltip.setStyle("-fx-border-color: black; -fx-pref-width: 500; -fx-pref-height: 500");
        popup.getContent().add(tooltip);


        reactionsToolTip.setOnMouseEntered(e -> {
            final double miscXOffset = 9;
            final double miscYOffset = 38;

            double xOffset = - tooltip.getBoundsInLocal().getWidth() - 25;
            double yOffset = (reactionsToolTip.getBoundsInLocal().getHeight()/2) - (tooltip.getBoundsInLocal().getHeight()/2);

            double x = stage.getX()+reactionsToolTip.localToScene(reactionsToolTip.getBoundsInLocal()).getMinX() + miscXOffset +xOffset;
            double y = stage.getY()+reactionsToolTip.localToScene(reactionsToolTip.getBoundsInLocal()).getMinY() + miscYOffset +yOffset;

            popup.show(reactionsToolTip,  x, y);
        });

        reactionsToolTip.setOnMouseExited(e -> {
            popup.hide();
        });
        //#endregion

        StackPane elementsStackPane = new StackPane();
        elementsRow.getChildren().add(elementsStackPane);

        HBox elementSelectorWrapper = new HBox(5);
        elementsStackPane.getChildren().add(elementSelectorWrapper);
        elementSelectorWrapper.setStyle("-fx-alignment: center;");

        HBox elementWrapper = new HBox(10);
        elementSelectorWrapper.getChildren().add(elementWrapper);
        elementWrapper.setStyle("-fx-pref-width: 9999; -fx-alignment: center; -fx-padding: 0 30 0 0;");

        HBox elementSelector1 = new HBox();
        elementWrapper.getChildren().add(elementSelector1);
        elementSelector1.setStyle("-fx-border-color: black; -fx-pref-width: "+elementBoxSize+"; -fx-pref-height: "+elementBoxSize+";");

        HBox elementSelector2 = new HBox();
        elementWrapper.getChildren().add(elementSelector2);
        elementSelector2.setStyle("-fx-border-color: black; -fx-pref-width: "+elementBoxSize+"; -fx-pref-height: "+elementBoxSize+";");

        Label reactionLabel = new Label("Overload");   //TODO when a reaction occures also show an X button to clear it all
        elementsStackPane.getChildren().add(reactionLabel);
        reactionLabel.setStyle("-fx-padding: 0 30 0 0; -fx-font-size: 18; -fx-font-weight: Bold;");




        //#endregion
    }
}
