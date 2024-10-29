package org.example.javafxintro.textflag;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

public class TextFlagController {
    @FXML private RadioButton Num1Red;
    @FXML private RadioButton Num1Green;
    @FXML private RadioButton Num1White;
    @FXML private RadioButton Num1Blue;

    @FXML private RadioButton Num2Red;
    @FXML private RadioButton Num2Green;
    @FXML private RadioButton Num2White;
    @FXML private RadioButton Num2Blue;

    @FXML private RadioButton Num3Red;
    @FXML private RadioButton Num3Green;
    @FXML private RadioButton Num3White;
    @FXML private RadioButton Num3Blue;

    @FXML private Label resultLabel;

    @FXML
    public void checkButton() {
        Num1Red.setOnAction(e ->{
            if(Num1Red.isSelected()) {
                Num1White.setSelected(false);
                Num1Green.setSelected(false);
                Num1Blue.setSelected(false);
            }});
        Num1White.setOnAction(e ->{
            if(Num1White.isSelected()) {
                Num1Red.setSelected(false);
                Num1Green.setSelected(false);
                Num1Blue.setSelected(false);
            }});
        Num1Green.setOnAction(e ->{
            if(Num1Green.isSelected()) {
                Num1White.setSelected(false);
                Num1Red.setSelected(false);
                Num1Blue.setSelected(false);
            }});
        Num1Blue.setOnAction(e ->{
            if(Num1Blue.isSelected()) {
                Num1White.setSelected(false);
                Num1Green.setSelected(false);
                Num1Red.setSelected(false);
            }});

        Num2Red.setOnAction(e ->{
            if(Num2Red.isSelected()) {
                Num2White.setSelected(false);
                Num2Green.setSelected(false);
                Num2Blue.setSelected(false);
            }});
        Num2White.setOnAction(e ->{
            if(Num2White.isSelected()) {
                Num2Red.setSelected(false);
                Num2Green.setSelected(false);
                Num2Blue.setSelected(false);
            }});
        Num2Green.setOnAction(e ->{
            if(Num2Green.isSelected()) {
                Num2White.setSelected(false);
                Num2Red.setSelected(false);
                Num2Blue.setSelected(false);
            }});
        Num2Blue.setOnAction(e ->{
            if(Num2Blue.isSelected()) {
                Num2White.setSelected(false);
                Num2Green.setSelected(false);
                Num2Red.setSelected(false);
            }});

        Num3Red.setOnAction(e ->{
            if(Num3Red.isSelected()) {
                Num3White.setSelected(false);
                Num3Green.setSelected(false);
                Num3Blue.setSelected(false);
            }});
        Num3White.setOnAction(e ->{
            if(Num3White.isSelected()) {
                Num3Red.setSelected(false);
                Num3Green.setSelected(false);
                Num3Blue.setSelected(false);
            }});
        Num3Green.setOnAction(e ->{
            if(Num3Green.isSelected()) {
                Num3White.setSelected(false);
                Num3Red.setSelected(false);
                Num3Blue.setSelected(false);
            }});
        Num3Blue.setOnAction(e ->{
            if(Num3Blue.isSelected()) {
                Num3White.setSelected(false);
                Num3Green.setSelected(false);
                Num3Red.setSelected(false);
            }});
    }

    @FXML
    public void handleDraw() {
        StringBuilder result = new StringBuilder();

        if (Num1Red.isSelected()) result.append("Красный, ");
        else if (Num1Green.isSelected()) result.append("Зелёный, ");
        else if (Num1White.isSelected()) result.append("Белый, ");
        else if (Num1Blue.isSelected()) result.append("Синий, ");

        if (Num2Red.isSelected()) result.append("Красный, ");
        else if (Num2Green.isSelected()) result.append("Зелёный, ");
        else if (Num2White.isSelected()) result.append("Белый, ");
        else if (Num2Blue.isSelected()) result.append("Синий, ");

        if (Num3Red.isSelected()) result.append("Красный, ");
        else if (Num3Green.isSelected()) result.append("Зелёный, ");
        else if (Num3White.isSelected()) result.append("Белый, ");
        else if (Num3Blue.isSelected()) result.append("Синий, ");

        if (result.length() > 0) {
            result.delete(result.length() - 2, result.length()); // Удаляем последнюю запятую и пробел
        } else {
            result.append("Выберите цвета");
        }

        resultLabel.setText(result.toString());

    }
}
