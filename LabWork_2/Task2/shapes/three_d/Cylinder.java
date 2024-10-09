package LabWork_2.Task2.shapes.three_d;

public class Cylinder extends Shape3D {
    private final double radius;
    private final double height;

    public Cylinder(double radius, double height) {
        if (radius <= 0 || height <= 0) {
            throw new IllegalArgumentException("Radius and height must be greater than 0");
        }
        this.radius = radius;
        this.height = height;
    }

    @Override
    public double calcVolume() {
        return Math.PI * radius * radius * height;
    }

    @Override
    public double calcSurfaceArea() {
        return 2 * Math.PI * radius * (radius + height);
    }

    public double getRadius() {
        return radius;
    }

    public double getHeight() {
        return height;
    }
}
