package org.example.javafxintro.showhidewidget;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ShowHideWidgetController {

    @FXML
    private Label label;
    @FXML
    private TextField text;
    @FXML
    private Button button;
    @FXML
    private CheckBox checkBox1;
    @FXML
    private CheckBox checkBox2;
    @FXML
    private CheckBox checkBox3;

    @FXML
    public void initialize() {
        checkBox1.setSelected(true); // Установка значения true
        checkBox2.setSelected(true);
        checkBox3.setSelected(true);

        checkBox1.setOnAction(e -> {label.setVisible(checkBox1.isSelected());});
        checkBox2.setOnAction(e -> {text.setVisible(checkBox2.isSelected());});
        checkBox3.setOnAction(e -> {button.setVisible(checkBox3.isSelected());});
    }

}
