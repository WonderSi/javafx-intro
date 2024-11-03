package org.example.javafxintro.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.util.LinkedList;
import java.util.Queue;

public class CalculatorController {
    @FXML
    private TextField display;

    public void initialize() {
        // Сделать TextField не редактируемым
        display.setEditable(false);
    }


    @FXML
    public void processNumber(String number) {
        display.appendText(number);
    }

    @FXML
    public void addPoint() {
        display.appendText(".");
    }

    @FXML
    public void clear() {
        display.clear();
    }

    @FXML
    public void deleteLastCharacter() {
        String currentText = display.getText();
        if (!currentText.isEmpty()) {
            display.setText(currentText.substring(0, currentText.length() - 1));
        }
    }

    @FXML
    public void processOperation(String operation) {
        display.appendText(" " + operation + " ");
    }

    @FXML
    public void calculateResult() {
        try {
            String expression = display.getText();
            double result = evaluateExpression(expression);
            display.setText(String.valueOf(result));
        } catch (Exception e) {
            showAlert("Ошибка", "Неверное выражение!");
            clear();
        }
    }

    private double evaluateExpression(String expression) {
        // Парсинг и вычисление математического выражения
        ExpressionParser parser = new ExpressionParser(expression);
        return parser.parse();
    }

    @FXML
    public void onButtonClick(ActionEvent event) {
        Button button = (Button) event.getSource();
        String buttonText = button.getText();

        switch (buttonText) {
            case "C" -> clear();
            case "←" -> deleteLastCharacter();
            case "=" -> calculateResult();
            default -> {
                if (buttonText.matches("[0-9]")) {
                    processNumber(buttonText);
                } else if (buttonText.equals(".")) {
                    addPoint();
                } else {
                    processOperation(buttonText);
                }
            }
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // Внутренний класс для парсинга математических выражений
    class ExpressionParser {
        private final Queue<String> tokens;

        public ExpressionParser(String expression) {
            tokens = new LinkedList<>();
            String[] tokenArray = expression.trim().split("\\s+");
            for (String token : tokenArray) {
                if (!token.isEmpty()) {
                    tokens.add(token);
                }
            }
        }

        public double parse() {
            return expression();
        }

        private double expression() {
            double result = term();
            while (!tokens.isEmpty()) {
                String op = tokens.peek();
                if (op.equals("+") || op.equals("-")) {
                    tokens.poll();
                    double nextTerm = term();
                    result = applyOperator(result, nextTerm, op);
                } else {
                    break;
                }
            }
            return result;
        }

        private double term() {
            double result = factor();
            while (!tokens.isEmpty()) {
                String op = tokens.peek();
                if (op.equals("*") || op.equals("/")) {
                    tokens.poll();
                    double nextFactor = factor();
                    result = applyOperator(result, nextFactor, op);
                } else {
                    break;
                }
            }
            return result;
        }

        private double factor() {
            String token = tokens.poll();
            // Обработка унарного минуса
            if (token.equals("-")) {
                double nextFactor = factor(); // Получаем следующий фактор
                return -nextFactor; // Меняем знак
            }
            if (token.matches("-?\\d+(\\.\\d+)?")) {
                return Double.parseDouble(token);
            }
            throw new IllegalArgumentException("Unexpected token: " + token);
        }

        private double applyOperator(double left, double right, String operator) {
            return switch (operator) {
                case "+" -> left + right;
                case "-" -> left - right;
                case "*" -> left * right;
                case "/" -> {
                    if (right == 0) throw new ArithmeticException("Деление на ноль");
                    yield left / right;
                }
                default -> throw new IllegalArgumentException("Unexpected operator: " + operator);
            };
        }
    }
}
