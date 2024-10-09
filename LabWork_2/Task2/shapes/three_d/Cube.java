package LabWork_2.Task2.shapes.three_d;

public class Cube extends Shape3D {
    private final double side;

    public Cube(double side) {
        if (side <= 0) {
            throw new IllegalArgumentException("Side must be greater than 0");
        }
        this.side = side;
    }

    public double calcVolume() {
        return side * side * side;
    }

    public double calcSurfaceArea() {
        return 6 * side * side;
    }

    public double getSide() {
        return side;
    }
}
