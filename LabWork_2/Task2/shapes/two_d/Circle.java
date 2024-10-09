package LabWork_2.Task2.shapes.two_d;

public class Circle extends Shape2D {
    private final double radius;

    public Circle(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Radius must be greater than 0");
        }
        this.radius = radius;
    }

    @Override
    public double calcArea() {
        return Math.PI * radius * radius;
    }

    public double getRadius() {
        return radius;
    }
}