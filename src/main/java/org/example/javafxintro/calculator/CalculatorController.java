package org.example.javafxintro.calculator;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CalculatorController {

    @FXML
    private TextField number1;
    @FXML
    private TextField number2;
    @FXML
    private Label resultLabel;

    private void performOperation(char operation) {
        try {
            double num1 = Double.parseDouble(number1.getText());
            double num2 = Double.parseDouble(number2.getText());
            double result = 0;

            switch (operation) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 == 0) {
                        resultLabel.setText("Ошибка: деление на 0");
                        return;
                    }
                    result = num1 / num2;
                    break;
            }
            resultLabel.setText("Результат: " + result);
        } catch (NumberFormatException e) {
            resultLabel.setText("Ошибка: некорректный ввод");
        }
    }

    @FXML
    public void handleAdd() {
        performOperation('+');
    }

    @FXML
    public void handleSubtract() {
        performOperation('-');
    }

    @FXML
    public void handleMultiply() {
        performOperation('*');
    }

    @FXML
    public void handleDivide() {
        performOperation('/');
    }
}
