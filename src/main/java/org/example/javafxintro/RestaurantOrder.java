package org.example.javafxintro;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RestaurantOrder extends Application {

    @Override
    public void start(Stage primaryStage) {
        //Инициализация GUI
        Label menuLabel = new Label("Выберите блюда:");
        CheckBox dish1 = new CheckBox("Паста - 10.00");
        CheckBox dish2 = new CheckBox("Пицца - 15.00");
        CheckBox dish3 = new CheckBox("Салат - 5.00");

        TextField quantity1 = new TextField("0");
        TextField quantity2 = new TextField("0");
        TextField quantity3 = new TextField("0");

        Button orderButton = new Button("Заказать");

        TextArea receipt = new TextArea();
        receipt.setEditable(false);
        receipt.setWrapText(true);


        //Логика checkbox: Если true - количество блюд равняется 1, иначе 0. Количество изменяемо
        dish1.setOnAction(e1 ->{
            if(dish1.isSelected()) {
                quantity1.setText("1");
            } else {
                quantity1.setText("0");
            }
        });
        dish2.setOnAction(e1 ->{
            if(dish2.isSelected()) {
                quantity2.setText("1");
            } else {
                quantity2.setText("0");
            }
        });
        dish3.setOnAction(e ->{
            if(dish3.isSelected()) {
                quantity3.setText("1");
            } else {
                quantity3.setText("0");
            }
        });

        orderButton.setOnAction(e -> {
            StringBuilder orderDetails = new StringBuilder(); //Вызываем StringBuilder, т.к. в зависимости от выбора строка постоянно изменяется
            double total = 0; //Общая сумма заказ

            if (dish1.isSelected()) {
                int qty = Integer.parseInt(quantity1.getText()); //Считывание количества заказных блюд
                double cost = qty * 10.00; //Подсчет суммы блюд(-а)
                total += cost; //Суммирование сумм
                orderDetails.append("Паста: ").append(qty).append(" шт. - ").append(cost).append("\n"); //Добавление блюда в чек
            }
            //Рассматриваем блюдо из меню, если оно выбрано

            if (dish2.isSelected()) {
                int qty = Integer.parseInt(quantity2.getText());
                double cost = qty * 15.00;
                total += cost;

                orderDetails.append("Пицца: ").append(qty).append(" шт. - ").append(cost).append("\n");
            }

            if (dish3.isSelected()) {
                int qty = Integer.parseInt(quantity3.getText());
                double cost = qty * 5.00;
                total += cost;
                orderDetails.append("Салат: ").append(qty).append(" шт. - ").append(cost).append("\n");
            }

            orderDetails.append("Итого: ").append(total); //Добавляем строчку с итоговой суммой выбранных блюд
            receipt.setText(orderDetails.toString()); //Переносим всю собранную информацию в текстовую область receipt
        });
        //Отслеживание события кнопки

        ScrollPane scrollReceipt = new ScrollPane(receipt); //Добавляем элемент скролла
        scrollReceipt.setFitToWidth(true); //Делаем окно на всю ширину, чтобы избавиться от нижнего скролла
        VBox layout = new VBox(10, menuLabel, dish1, quantity1, dish2, quantity2, dish3, quantity3, orderButton, scrollReceipt);
        Scene scene = new Scene(layout, 400, 320);
        primaryStage.setTitle("Ordering at the restaurant");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
