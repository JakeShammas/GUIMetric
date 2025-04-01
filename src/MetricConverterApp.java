import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MetricConverterApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create the main layout container
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        // Label for the title
        Label titleLabel = new Label("Metric Converter");
        titleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
        gridPane.add(titleLabel, 0, 0, 2, 1);

        // Label for input
        Label inputLabel = new Label("Enter Value:");
        gridPane.add(inputLabel, 0, 1);

        // Text field for user input
        TextField inputField = new TextField();
        gridPane.add(inputField, 1, 1);

        // ComboBox for unit selection (From)
        Label fromLabel = new Label("From:");
        gridPane.add(fromLabel, 0, 2);

        ComboBox<String> fromComboBox = new ComboBox<>();
        fromComboBox.getItems().addAll("Meters", "Kilometers", "Centimeters", "Millimeters", "Grams", "Kilograms");
        fromComboBox.setValue("Meters"); // default value
        gridPane.add(fromComboBox, 1, 2);

        // ComboBox for unit selection (To)
        Label toLabel = new Label("To:");
        gridPane.add(toLabel, 0, 3);

        ComboBox<String> toComboBox = new ComboBox<>();
        toComboBox.getItems().addAll("Meters", "Kilometers", "Centimeters", "Millimeters", "Grams", "Kilograms");
        toComboBox.setValue("Kilometers"); // default value
        gridPane.add(toComboBox, 1, 3);

        // Button to perform the conversion
        Button convertButton = new Button("Convert");
        gridPane.add(convertButton, 0, 4, 2, 1);

        // Label to display the result
        Label resultLabel = new Label("Result: ");
        gridPane.add(resultLabel, 0, 5, 2, 1);

        // Define the conversion logic
        convertButton.setOnAction(event -> {
            try {
                // Get the user input value
                double inputValue = Double.parseDouble(inputField.getText());

                // Get selected units
                String fromUnit = fromComboBox.getValue();
                String toUnit = toComboBox.getValue();

                // Conversion logic
                double result = convert(inputValue, fromUnit, toUnit);

                // Display the result
                resultLabel.setText("Result: " + result);
            } catch (NumberFormatException e) {
                // Handle invalid input
                resultLabel.setText("Result: Invalid input");
            }
        });

        // Create the scene and set it on the stage
        Scene scene = new Scene(gridPane, 400, 300);
        primaryStage.setTitle("Metric Converter");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Method to perform the conversion based on selected units
    private double convert(double value, String fromUnit, String toUnit) {
        // Simple conversion logic: You can extend this as needed
        if (fromUnit.equals("Meters") && toUnit.equals("Kilometers")) {
            return value / 1000;
        } else if (fromUnit.equals("Kilometers") && toUnit.equals("Meters")) {
            return value * 1000;
        } else if (fromUnit.equals("Centimeters") && toUnit.equals("Meters")) {
            return value / 100;
        } else if (fromUnit.equals("Millimeters") && toUnit.equals("Meters")) {
            return value / 1000;
        } else if (fromUnit.equals("Grams") && toUnit.equals("Kilograms")) {
            return value / 1000;
        } else if (fromUnit.equals("Kilograms") && toUnit.equals("Grams")) {
            return value * 1000;
        }
        return value; // If no conversion is needed, return the original value
    }

    public static void main(String[] args) {
        launch(args);
    }
}
