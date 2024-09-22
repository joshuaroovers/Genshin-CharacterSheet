package GenshinCharacterSheet.UI.Components.SubComponents;

import GenshinCharacterSheet.SheetComponents.Elements.Element;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class EnergyCounterBox extends HBox {

    private HBox counter1;
    private Pane counter1Display;
    private HBox counter2;
    private Pane counter2Display;
    private HBox counter3;
    private Pane counter3Display;

    int tempEnergyCounter = 0;

    public EnergyCounterBox(Element visionElement) {
        HBox mainBox = this;
        mainBox.setStyle("-fx-border-color: black; -fx-padding: 2; -fx-max-width: 0;");
        mainBox.setSpacing(5);

        counter1 = new HBox();
        counter1.setStyle("-fx-alignment: center; -fx-border-color: black;");
        counter1.setOnMouseClicked(e -> {
            handleUpdate(counter1);
        });

        VBox counter1Wrapper = new VBox();
        counter1.getChildren().add(counter1Wrapper);
        counter1Wrapper.setAlignment(Pos.CENTER);

        counter1Display = new Pane();
        counter1Wrapper.getChildren().add(counter1Display);
        counter1Display.setStyle("-fx-background-color: "+visionElement.getColorHex()+";");
        counter1Display.getStyleClass().add("energy-counter-pip");
        counter1Display.setVisible(false);

        counter2 = new HBox();
        counter2.setStyle("-fx-alignment: center; -fx-border-color: black;");
        counter2.setOnMouseClicked(e -> {
            handleUpdate(counter2);
        });

        VBox counter2Wrapper = new VBox();
        counter2.getChildren().add(counter2Wrapper);
        counter2Wrapper.setAlignment(Pos.CENTER);

        counter2Display = new Pane();
        counter2Wrapper.getChildren().add(counter2Display);
        counter2Display.setStyle("-fx-background-color: "+visionElement.getColorHex()+";");
        counter2Display.getStyleClass().add("energy-counter-pip");
        counter2Display.setVisible(false);

        counter3 = new HBox();
        counter3.setStyle("-fx-alignment: center; -fx-border-color: black;");
        counter3.setOnMouseClicked(e -> {
            handleUpdate(counter3);
        });

        VBox counter3Wrapper = new VBox();
        counter3.getChildren().add(counter3Wrapper);
        counter3Wrapper.setAlignment(Pos.CENTER);

        counter3Display = new Pane();
        counter3Wrapper.getChildren().add(counter3Display);
        counter3Display.setStyle("-fx-background-color: "+visionElement.getColorHex()+";");
        counter3Display.getStyleClass().add("energy-counter-pip");
        counter3Display.setVisible(false);

        mainBox.getChildren().addAll(counter1, counter2, counter3);

    }

    private void handleUpdate(HBox counterContainer){
        if(tempEnergyCounter == 0){         // 0 -> 1 show first counter
            tempEnergyCounter++;
            counter1Display.setVisible(true);
        } else if(tempEnergyCounter == 1) {
            if(counterContainer == counter1){// 1 -> 2 show second counter
                tempEnergyCounter--;
                counter1Display.setVisible(false);
            }else{                          // 1 -> 0 hide first counter
                tempEnergyCounter++;
//                counter1Display.setVisible(true);
                counter2Display.setVisible(true);
            }
        } else if(tempEnergyCounter == 2){
            if(counterContainer == counter1 || counterContainer == counter2){  //2 -> 1 hide second counter
                tempEnergyCounter--;
                counter2Display.setVisible(false);
            }else{                              // 2 -> 3 show third counter
                tempEnergyCounter++;
//                counter1Display.setVisible(true);
//                counter2Display.setVisible(true);
                counter3Display.setVisible(true);
            }
        }else{  // 3 -> 0 hide all counters
            tempEnergyCounter = 0;
            counter1Display.setVisible(false);
            counter2Display.setVisible(false);
            counter3Display.setVisible(false);
        }
    }

}
