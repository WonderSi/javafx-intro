package org.example.javafxintro.geometry2d;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Shape {
    public double x;
    public double y;
    protected Color color;

    public Shape(double x, double y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public abstract void draw(GraphicsContext gc);

    public abstract boolean contains(double px, double py);

    public void setColor(Color color) {
        this.color = color;
    }

    public void moveTo(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
