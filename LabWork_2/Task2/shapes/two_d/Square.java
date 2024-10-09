package LabWork_2.Task2.shapes.two_d;

public class Square extends Shape2D {
    private final double side;

    public Square(double side) {
        if (side <= 0) {
            throw new IllegalArgumentException("Side must be greater than 0");
        }
        this.side = side;
    }

    @Override
    public double calcArea() {
        return side * side;
    }

    public double getSide() {
        return side;
    }
}
