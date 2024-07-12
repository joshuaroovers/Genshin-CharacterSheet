package UIComponents.subUIComponents;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class SmallBasicBox extends VBox {
    public enum labelPosition {TOP, BOTTOM}
    public enum contentPosition {TOP, CENTER, BOTTOM}
    private Label label;

    public SmallBasicBox(labelPosition labelPosition, String labelText, HBox content, contentPosition contentPosition) {
        VBox mainBox = this;
        mainBox.getStyleClass().add("basic-container");

        label = new Label(labelText);
        label.getStyleClass().addAll("basic-box-label");

        content.getStyleClass().addAll("basic-container");

        if(labelPosition == SmallBasicBox.labelPosition.TOP){
            mainBox.getChildren().addAll(label, content);
        }else{
            mainBox.getChildren().addAll(content, label);
        }

    }
}
