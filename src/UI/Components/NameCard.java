package UI.Components;

import SheetComponents.Elements.Element;
import SheetComponents.Lineage.Lineage;
import SheetComponents.Weapons.Weapon;
import UI.Util.ImageHelper;
import UI.Util.ImageElementVariant;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

public class NameCard extends HBox {

    public NameCard(Element element, String name, Lineage lineage, Weapon weapon) {
        HBox mainBox = this;
        mainBox.getStyleClass().add("name-card");

        StackPane stackPane = new StackPane();
        mainBox.getChildren().add(stackPane);

        //#region image
        BorderPane imageBorderPane = new BorderPane();
        stackPane.getChildren().add(imageBorderPane);

        HBox elementImage = new HBox();
        imageBorderPane.setLeft(elementImage);
        elementImage.setStyle("-fx-background-image: url("+ ImageHelper.getElementURL(element, ImageElementVariant.FLAT)+")");
        elementImage.getStyleClass().addAll("name-card-element-image","element-image");
        //#endregion

        BorderPane borderPane = new BorderPane();
        stackPane.getChildren().add(borderPane);
        borderPane.getStyleClass().add("name-card-text-container");

        Label spacing = new Label("lazy spacing fix hehe");
        borderPane.setTop(spacing);
        spacing.setVisible(false);
        spacing.getStyleClass().add("name-card-detail"); //to keep sizing consistent with it's functional counterpart (detailsWrapper content)



        Label characterNameLabel = new Label(name);
        borderPane.setLeft(characterNameLabel);
        characterNameLabel.getStyleClass().add("name-card-name-label");

        HBox detailsWrapper = new HBox();
        borderPane.setBottom(detailsWrapper);
        detailsWrapper.getStyleClass().add("name-card-details-wrapper");

        Label speciesBox = new Label(lineage.getName());
        detailsWrapper.getChildren().add(speciesBox);
        speciesBox.getStyleClass().add("name-card-detail");

        Label elementNameBox = new Label(element.getName());
        detailsWrapper.getChildren().add(elementNameBox);
        elementNameBox.getStyleClass().add("name-card-detail");

        Label weaponTypeBox = new Label(weapon.getName());
        detailsWrapper.getChildren().add(weaponTypeBox);
        weaponTypeBox.getStyleClass().add("name-card-detail");
    }
}
