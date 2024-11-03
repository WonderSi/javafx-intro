package org.example.javafxintro.textflag;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

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
    public void initialize() {
        // Создаем ToggleGroup для каждой группы радиокнопок
        ToggleGroup group1 = new ToggleGroup();
        ToggleGroup group2 = new ToggleGroup();
        ToggleGroup group3 = new ToggleGroup();

        // Присоединяем радиокнопки к их группе
        Num1Red.setToggleGroup(group1);
        Num1Green.setToggleGroup(group1);
        Num1White.setToggleGroup(group1);
        Num1Blue.setToggleGroup(group1);

        Num2Red.setToggleGroup(group2);
        Num2Green.setToggleGroup(group2);
        Num2White.setToggleGroup(group2);
        Num2Blue.setToggleGroup(group2);

        Num3Red.setToggleGroup(group3);
        Num3Green.setToggleGroup(group3);
        Num3White.setToggleGroup(group3);
        Num3Blue.setToggleGroup(group3);
    }

    @FXML
    public void handleDraw() {

        StringBuilder result = new StringBuilder();

        // Получаем выбранные цвета из каждой группы
        result.append(getSelectedColor(Num1Red, Num1Green, Num1White, Num1Blue)).append(", ");
        result.append(getSelectedColor(Num2Red, Num2Green, Num2White, Num2Blue)).append(", ");
        result.append(getSelectedColor(Num3Red, Num3Green, Num3White, Num3Blue));

        resultLabel.setText(result.toString());
    }

    private String getSelectedColor(RadioButton... buttons) {
        for (RadioButton button : buttons) {
            if (button.isSelected()) {
                switch (button.getText()) {
                    case "Красный":
                        return "Красный";
                    case "Зелёный":
                        return "Зелёный";
                    case "Белый":
                        return "Белый";
                    case "Синий":
                        return "Синий";
                }
            }
        }
        return "Не выбрано";
    }
}
