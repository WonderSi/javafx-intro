package org.example.javafxintro.shiftingwords;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ShiftingWordsController {

    @FXML
    private TextField firstWord;
    @FXML
    private TextField secondWord;
    @FXML
    private Button shiftButton;

    @FXML
    public void initialize() {
        shiftButton.setOnAction(e -> {
            if (shiftButton.getText().equals("→")) {
                secondWord.setText(firstWord.getText());
                shiftButton.setText("←");
                firstWord.clear();
            } else {
                firstWord.setText(secondWord.getText());
                shiftButton.setText("→");
                secondWord.clear();
            }
        });
    }
}
