package org.example.javafxintro.restaurantorder;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.util.HashMap;

public class RestaurantOrderController {

    @FXML
    private ListView<String> dishList;
    @FXML
    private Spinner<Integer> quantitySpinner;
    @FXML
    private TextArea orderTextArea;
    @FXML
    private Button addButton;
    @FXML
    private Button orderButton;

    private final ObservableList<String> dishes = FXCollections.observableArrayList(
            "Пицца 4 сыра - 620 руб.",
            "Пицца Пепперони - 620 руб.",
            "Салат Цезарь - 270 руб.",
            "Салат Греческий - 260 руб.",
            "Картофель фри - 185 руб.",
            "Картофельные дольки - 180 руб.",
            "Рисовые шарики - 215 руб.",
            "Гамбургер - 415 руб.",
            "Рамен - 365 руб.",
            "Солянка мясная - 325 руб."
    ); // Хранит названия блюд и их количество в меню

    private final HashMap<String, Integer> orderMap = new HashMap<>(); // Хранит названия блюд и их количество в заказе

    public void initialize() {
        dishList.setItems(dishes);

        // Инициализация спиннера
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1); // Мин Макс Поставлено
        quantitySpinner.setValueFactory(valueFactory);

        addButton.setOnAction(event -> addDishToOrder());
        orderButton.setOnAction(event -> finalizeOrder());
    }

    private void addDishToOrder() {
        String selectedDish = dishList.getSelectionModel().getSelectedItem();
        if (selectedDish != null) {
            int quantity = quantitySpinner.getValue(); // Кол-во блюда
            String dishName = selectedDish.split(" - ")[0]; // Название блюда
            int price = Integer.parseInt(selectedDish.split(" - ")[1].replace(" руб.", "")); // Цена блюда

            // Добавление блюда в HashMap
            orderMap.put(dishName, orderMap.getOrDefault(dishName, 0) + quantity);
            updateOrderTextArea();
            dishList.getSelectionModel().clearSelection();
        }
    }

    private void updateOrderTextArea() {
        orderTextArea.clear();  // Очищаем текстовую область перед обновлением
        for (String dish : orderMap.keySet()) {
            int quantity = orderMap.get(dish);
            int price = Integer.parseInt(dishes.stream()
                    .filter(d -> d.startsWith(dish))
                    .findFirst()
                    .get()
                    .split(" - ")[1].replace(" руб.", ""));
            int totalPrice = price * quantity;
            String orderLine = String.format("%s: %d шт. - %d руб.\n", dish, quantity, totalPrice);
            orderTextArea.appendText(orderLine);
        }
    }

    private void finalizeOrder() {
        String orderSummary = orderTextArea.getText();
        if (orderSummary.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Empty order");
            alert.setHeaderText(null);
            alert.setContentText("Ваш заказ пуст. Выберите блюда из списка меню.");
            alert.showAndWait();
            return;
        }

        double totalCost = 0;
        String[] lines = orderSummary.split("\n");
        for (String line : lines) {
            if (!line.isEmpty()) {
                totalCost += Integer.parseInt(line.split(" - ")[1].replace(" руб.", ""));
            }
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Your order");
        alert.setHeaderText(null);
        alert.setContentText(orderTextArea.getText() + "\n" + "Итого: " + String.format("%.2f", totalCost) + " рублей");
        alert.showAndWait();

        orderTextArea.clear();
        orderMap.clear();
    }
}
