package hust.soict.ict.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;

    @FXML
    private RadioButton penRadioButton;

    @FXML
    private RadioButton eraserRadioButton;

    @FXML
    private ToggleGroup tools;

    @FXML
    void clearButtonPressed(ActionEvent event) {
      
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
     
        Color inkColor = Color.BLACK;

        if (eraserRadioButton.isSelected()) {
            inkColor = Color.WHITE;
        }

     
        double radius = eraserRadioButton.isSelected() ? 10.0 : 4.0;

        Circle newCircle = new Circle(event.getX(), event.getY(), radius, inkColor);
        drawingAreaPane.getChildren().add(newCircle);
    }
}