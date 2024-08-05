package UIComponents;

import SheetComponents.Elements.Element;
import SheetComponents.Stamina;
import UIComponents.util.ImageHelper;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;



public class StaminaBox extends VBox {

    private Stamina stamina;

    private final int gaugeSize = 170;
    private final int gaugeThickness = 30;
    private final Label gaugeCounterLabel;
    private final GraphicsContext graphicsContext;
    private Color gaugeBackgroundColor = Color.WHITE;
    private Color gaugeEmptyColor;
    private Color gaugeFullColor;

    private TextField recoverUseInputBox;

    public StaminaBox(Stamina stamina, Element element) {
        this.stamina = stamina;
        this.gaugeFullColor = element.getColor();
        this.gaugeEmptyColor = element.getColor().desaturate().desaturate().darker();
        VBox mainBox = this;
        mainBox.getStyleClass().addAll("basic-container", "stamina-box");
        mainBox.setStyle("-fx-border-color: black");

        Label staminaBoxLabel = new Label("Stamina");
        mainBox.getChildren().add(staminaBoxLabel);
        staminaBoxLabel.getStyleClass().add("basic-box-label");

        HBox controlWrapper = new HBox(10);
        controlWrapper.setAlignment(Pos.CENTER);
        mainBox.getChildren().add(controlWrapper);

        StackPane gaugeWrapper = new StackPane();
        controlWrapper.getChildren().add(gaugeWrapper);
////        gaugeWrapper.getStyleClass().add("GREEN");
//        gaugeWrapper.setStyle("-fx-alignment: center; -fx-border-color: red;");

        Canvas gaugeCanvas = new Canvas(gaugeSize/2, gaugeSize/2); //canvas is not style-able just style the gaugeWrapper
        gaugeWrapper.getChildren().add(gaugeCanvas);

        graphicsContext = gaugeCanvas.getGraphicsContext2D();

        gaugeCounterLabel = new Label("X"); //why doesn't it cast the int to string??
        gaugeWrapper.getChildren().add(gaugeCounterLabel);

        updateGauge(0);

        //#region recover/use buttons area
        VBox recoverUseBox = new VBox();
        recoverUseBox.getStyleClass().add("hp-button-container");
        controlWrapper.getChildren().add(recoverUseBox);

        //#region heal button
        Button recoverButton = new Button("Recover");
        recoverButton.getStyleClass().add("hp-button");
        recoverUseBox.getChildren().add(recoverButton);

        recoverButton.setOnAction(e ->{
            if(!recoverUseInputBox.getText().isEmpty()){
                updateGauge(Integer.parseInt(recoverUseInputBox.getText()));
            }
        });
        //#endregion heal button

        //recover/use input
        recoverUseInputBox = new TextField();
        recoverUseInputBox.getStyleClass().add("hp-button");
        recoverUseBox.getChildren().add(recoverUseInputBox);

        //#region use button
        Button useButton = new Button("Use");
        useButton.getStyleClass().add("hp-button");
        recoverUseBox.getChildren().add(useButton);

        useButton.setOnAction(e ->{
            if(!recoverUseInputBox.getText().isEmpty()){
                updateGauge(-Integer.parseInt(recoverUseInputBox.getText()));
            }
        });
        //#endregion use button

        //#endregion recover/use buttons area

    }

    private void updateGauge(int modifier){
        if(modifier != 0){
            stamina.adjustCurrentStamina(modifier, 0);
        }
        gaugeCounterLabel.setText(""+stamina.getCurrentStamina());
        drawGauge(stamina.getSpentPercentage());
    }
    private void drawGauge(double percentage) {
        System.out.println("used stamina: "+ percentage);
        double anglePercentage = 360.0/100.0*percentage;
        int startAngle = 270;
        int radius = gaugeSize/2;
        int smallRadius = radius-gaugeThickness;
        int x = 0;
        int y = 0;

        // Define the angles for the two slices
        double angle1 = startAngle+anglePercentage;  // 90 degrees for the first slice (25% of the circle)
        double angle2 = 360-anglePercentage; // 270 degrees for the second slice (75% of the circle)

        // Draw the first slice
        graphicsContext.setFill(gaugeEmptyColor);
        graphicsContext.fillArc(x, y, radius, radius, startAngle, angle1, ArcType.ROUND);

        // Draw the second slice
        graphicsContext.setFill(gaugeFullColor);
        graphicsContext.fillArc(x, y, radius, radius, angle1, angle2, ArcType.ROUND);

        graphicsContext.setFill(gaugeBackgroundColor);
        graphicsContext.fillArc(x+(gaugeThickness/2), y+(gaugeThickness/2), smallRadius, smallRadius, 0, 360, ArcType.ROUND);
    }
}
