package GenshinCharacterSheet.UI.Components;

import GenshinCharacterSheet.SheetComponents.Elements.Element;
import GenshinCharacterSheet.SheetComponents.Inspiration;
import GenshinCharacterSheet.UI.Components.SubComponents.SmallBasicBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class InspirationBox extends VBox {

    private final String text = "Inspiration";
    private final HBox button;
    private final HBox buttonGraphic;

    public InspirationBox(Inspiration inspiration, Element themeColor) {
        VBox mainBox = this;
        mainBox.getStyleClass().add("basic-container");

        HBox buttonWrapper = new HBox();

        StackPane stackPane = new StackPane();
        buttonWrapper.getChildren().add(stackPane);

        button = new HBox();
        stackPane.getChildren().add(button);
        button.getStyleClass().add("inspiration-box");

        stackPane.setOnMouseClicked(e -> {
            handleOnClick(inspiration);
        });

        buttonGraphic = new HBox();
        stackPane.getChildren().add(buttonGraphic);
        buttonGraphic.setStyle("-fx-max-width: 40; -fx-max-height: 40;");
        buttonGraphic.getStyleClass().addAll(themeColor.getName());
        buttonGraphic.setVisible(inspiration.getValue());
//        buttonGraphic

        SmallBasicBox baseBox = new SmallBasicBox(SmallBasicBox.labelPosition.BOTTOM, text,  buttonWrapper);
        mainBox.getChildren().add(baseBox);
    }

    private void handleOnClick(Inspiration inspiration) {
        inspiration.toggleValue();
        if(inspiration.getValue()){
            buttonGraphic.setVisible(true);
        }else{
            buttonGraphic.setVisible(false);
        }

    }
}
