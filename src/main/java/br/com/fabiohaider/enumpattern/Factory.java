package br.com.fabiohaider.enumpattern;

import java.util.function.Supplier;

abstract class Shape {
    public abstract void draw();
}

class Circle extends Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a circle");
    }
}

class Square extends Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a square");
    }
}

class Triangle extends Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a triangle");
    }
}

public enum Factory {
    CIRCLE(Circle::new),
    SQUARE(Square::new),
    TRIANGLE(Triangle::new);

    private final Supplier<Shape> shapeSupplier;

    Factory(Supplier<Shape> shapeSupplier) {
        this.shapeSupplier = shapeSupplier;
    }

    public Shape create() {
        return shapeSupplier.get();
    }

    public static void main(String[] args) {
        Shape shape = Factory.SQUARE.create();
        shape.draw();
    }
}