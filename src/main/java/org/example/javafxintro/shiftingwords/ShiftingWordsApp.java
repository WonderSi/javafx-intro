package org.example.javafxintro.shiftingwords;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import javafx.stage.Stage;

public class ShiftingWordsApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/javafxintro/ShiftingWords.fxml"));
            Scene scene = new Scene(loader.load());
            primaryStage.setTitle("ShiftingWords");
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