package ds.client;

import ds.service1.client1;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ControllerGUI extends Application {

    private client1 grpcClient;
    private Label responseLabel;

    @Override
    public void start(Stage primaryStage) {
        grpcClient = new client1("localhost", 50051);
        grpcClient.startStreaming();

        VBox root = new VBox();
        root.setSpacing(10);

        TextField temperatureInput = new TextField();
        temperatureInput.setPromptText("Enter temperature");

        Button sendButton = new Button("Send Temperature");
        sendButton.setOnAction(event -> {
            try {
                int temperature = Integer.parseInt(temperatureInput.getText());
                grpcClient.sendTemperature(temperature);
            } catch (NumberFormatException e) {
                responseLabel.setText("Invalid temperature input");
            }
        });

        responseLabel = new Label();

        root.getChildren().addAll(temperatureInput, sendButton, responseLabel);

        Scene scene = new Scene(root, 300, 200);
        primaryStage.setTitle("Temperature Control Client");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        grpcClient.stop();
        super.stop();
    }

    public void updateGUI(String action) {
        Platform.runLater(() -> responseLabel.setText(action));
    }

    public static void main(String[] args) {
        launch(args);
    }
}