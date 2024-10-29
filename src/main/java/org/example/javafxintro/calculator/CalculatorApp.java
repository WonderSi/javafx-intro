package org.example.javafxintro.calculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CalculatorApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/javafxintro/Calculator.fxml"));
            Scene scene = new Scene(loader.load());
            primaryStage.setTitle("Calculator");
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace(); // Вывод ошибки в консоль
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
