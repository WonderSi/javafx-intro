package org.example.javafxintro;

import org.example.javafxintro.geometry2d.*;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeometryController {

    @FXML
    private Canvas canvas;

    private final List<Shape> shapes = new ArrayList<>();
    private Shape selectedShape = null; //
    private double offsetX, offsetY;

    @FXML
    private void initialize() {
//      GraphicsContext gc = canvas.getGraphicsContext2D();

        canvas.setOnMousePressed(this::onMousePressed); //Обработчик событий при нажатии мыши
        canvas.setOnMouseDragged(this::onMouseDragged); //Обработчик событий при зажатии мыши(перетаскивание)
        canvas.setOnMouseReleased(e -> selectedShape = null);
    }

    @FXML
    private void onDrawCircle() {
        Random random = new Random();
        double x = random.nextDouble() * canvas.getWidth();
        double y = random.nextDouble() * canvas.getHeight();
        double radius = 20 + random.nextDouble() * 50;
        Color color = Color.color(random.nextDouble(), random.nextDouble(), random.nextDouble());
        shapes.add(new Circle(x, y, radius, color));
        redraw();
    } //Добавляет случайно сгенерированную окружность на холст

    @FXML
    private void onDrawRectangle() {
        Random random = new Random();
        double x = random.nextDouble() * canvas.getWidth();
        double y = random.nextDouble() * canvas.getHeight();
        double width = 30 + random.nextDouble() * 70;
        double height = 30 + random.nextDouble() * 70;
        Color color = Color.color(random.nextDouble(), random.nextDouble(), random.nextDouble());
        shapes.add(new Rectangle(x, y, width, height, color));
        redraw();
    } //Добавляет случайно сгенерированный прямоугольник на холст

    @FXML
    private void clear() {
        shapes.clear();
        redraw();
    }

    private void onMousePressed(MouseEvent e) {
        if (e.isPrimaryButtonDown()) {
            for (int i = shapes.size() - 1; i >= 0; i--) {
                Shape shape = shapes.get(i);
                if (shape.contains(e.getX(), e.getY())) {
                    selectedShape = shape;
                    offsetX = e.getX() - shape.x;
                    offsetY = e.getY() - shape.y; //Захват мыши относительно фигуры
                    shapes.remove(i);
                    shapes.add(shape); //Смещение поверх списка
                    redraw();
                    break;
                }
            }
        } else if (e.isSecondaryButtonDown()) {
            for (int i = shapes.size() - 1; i >= 0; i--) {
                Shape shape = shapes.get(i);
                if (shape.contains(e.getX(), e.getY())) {
                    shape.setColor(Color.color(new Random().nextDouble(), new Random().nextDouble(), new Random().nextDouble()));
                    redraw();
                    break;
                }
            }
        }
    } //Определяет, какое действие выполнить при нажатии кнопки мыши

    private void onMouseDragged(MouseEvent e) {
        if (selectedShape != null && e.isPrimaryButtonDown()) {
            selectedShape.moveTo(e.getX() - offsetX, e.getY() - offsetY);
            redraw();
        }
    } //Обрабатывает перемещение выбранной фигуры при зажатой левой кнопке мыши

    private void redraw() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        for (Shape shape : shapes) {
            shape.draw(gc);
        }
    } //Полностью очищает холст и заново рисует все фигуры из списка shapes
}
