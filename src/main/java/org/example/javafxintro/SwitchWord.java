package org.example.javafxintro;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SwitchWord extends Application {
    private boolean isFirstToSecond = true;

    @Override
    public void start(Stage primaryStage) {
        TextField textField1 = new TextField();
        TextField textField2 = new TextField();
        Button switchButton = new Button("→");

        switchButton.setOnAction(event -> {
            if (isFirstToSecond) {
                textField2.setText(textField1.getText());
                switchButton.setText("←");
                textField1.clear();

            } else {
                textField1.setText(textField2.getText());
                switchButton.setText("→");
                textField2.clear();
            }
            isFirstToSecond = !isFirstToSecond;
        });

        VBox layout = new VBox(10, textField1, switchButton, textField2);
        Scene scene = new Scene(layout, 300, 200);
        primaryStage.setTitle("Word Switcher");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}