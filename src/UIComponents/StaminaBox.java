package UIComponents;

import SheetComponents.Stamina;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

public class StaminaBox extends HBox {

    public StaminaBox(Stamina stamina) {
        HBox mainBox = this;
        mainBox.getStyleClass().add("basic-container");
        mainBox.setStyle("-fx-border-color: black");

        HBox gaugeWrapper = new HBox();
        mainBox.getChildren().add(gaugeWrapper);
        gaugeWrapper.setStyle("-fx-alignment: center; -fx-border-color: red;");

        Canvas gaugeCanvas = new Canvas(75, 75);
        gaugeCanvas.setStyle("-fx-border-color: blue;"); //doesn't work??????
        gaugeWrapper.getChildren().add(gaugeCanvas);

        drawPieChart(gaugeCanvas.getGraphicsContext2D(), stamina.getSpentPercentage(), 150, 30);

    }

    private void drawPieChart(GraphicsContext gc, double percentage, int size, int thickness) {
        System.out.println("used stamina: "+ percentage);
        double anglePercentage = 360.0/100.0*percentage;
        int startAngle = 270;
        int radius = size/2; // leave some margin
        int smallRadius = radius-thickness;
        int x = 0;
        int y = 0;

        // Define the angles for the two slices
        double angle1 = startAngle+anglePercentage;  // 90 degrees for the first slice (25% of the circle)
        double angle2 = 360-anglePercentage; // 270 degrees for the second slice (75% of the circle)

        // Draw the first slice
        gc.setFill(Color.RED);
        gc.fillArc(x, y, radius, radius, startAngle, angle1, ArcType.ROUND);

        // Draw the second slice
        gc.setFill(Color.BLUE);
        gc.fillArc(x, y, radius, radius, angle1, angle2, ArcType.ROUND);

        gc.setFill(Color.WHITE);
        gc.fillArc(x+(thickness/2), y+(thickness/2), smallRadius, smallRadius, 0, 360, ArcType.ROUND);
    }
}
