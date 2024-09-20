package UI.Components.SubComponents;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;


public class SmallBasicBox extends VBox {
    public enum labelPosition {TOP, BOTTOM}
//    public enum contentPosition {TOP, CENTER, BOTTOM}

    public SmallBasicBox(String labelText, String secondLabelText, Pane content){
        this(null, labelText, secondLabelText, content);
    }
    public SmallBasicBox(labelPosition labelPosition, String labelText, Pane content){
        this(labelPosition, labelText, null, content);
    }

    public SmallBasicBox(labelPosition labelPosition, String labelText, String secondLabelText, Pane content) {
        VBox mainBox = this;
        mainBox.getStyleClass().add("basic-container");

        Label label = new Label(labelText);
        label.getStyleClass().addAll("basic-box-label");

        Label label2 = new Label(secondLabelText);
        label2.getStyleClass().addAll("basic-box-label");

        content.getStyleClass().addAll("basic-container-width");

        if(labelPosition != null && secondLabelText == null){
            if(labelPosition == SmallBasicBox.labelPosition.TOP){
                mainBox.getChildren().addAll(label, content);
            }else{
                mainBox.getChildren().addAll(content, label);
            }
        }else{
            label.getStyleClass().addAll("basic-box-label-top");
            label2.getStyleClass().addAll("basic-box-label-bottom");
            mainBox.getChildren().addAll(label, content, label2);
        }


    }
}
