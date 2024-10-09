package LabWork_2.Task2.shapes.three_d;

public class Sphere extends Shape3D {
    private final double radius;

    public Sphere(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Radius must be greater than 0");
        }
        this.radius = radius;
    }

    public double calcVolume() {
        return 4.0 / 3.0 * Math.PI * Math.pow(radius, 3);
    }

    public double calcSurfaceArea() {
        return 4 * Math.PI * Math.pow(radius, 2);
    }

    public double getRadius() {
        return radius;
    }
}
