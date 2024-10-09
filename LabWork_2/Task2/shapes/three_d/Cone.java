package LabWork_2.Task2.shapes.three_d;

public class Cone extends Shape3D {
    private final double radius;
    private final double height;

    public Cone(double radius, double height) {
        if (radius <= 0 || height <= 0) {
            throw new IllegalArgumentException("Radius and height must be greater than 0");
        }
        this.radius = radius;
        this.height = height;
    }

    @Override
    public double calcVolume() {
        return Math.PI * Math.pow(radius, 2) * height / 3;
    }

    @Override
    public double calcSurfaceArea() {
        return Math.PI * radius * (radius + Math.sqrt(Math.pow(height, 2) + Math.pow(radius, 2)));
    }

    public double getRadius() {
        return radius;
    }

    public double getHeight() {
        return height;
    }
}
