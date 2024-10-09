package LabWork_2.Task2.shapes.three_d;

public class Pyramid extends Shape3D {
    private final double baseLength;
    private final double baseWidth;
    private final double height;

    public Pyramid(double baseLength, double baseWidth, double height) {
        if (baseLength <= 0 || baseWidth <= 0 || height <= 0) {
            throw new IllegalArgumentException("Base length, base width, and height must be greater than 0");
        }
        this.baseLength = baseLength;
        this.baseWidth = baseWidth;
        this.height = height;
    }

    public double calcVolume() {
        return (baseLength * baseWidth * height) / 3;
    }

    public double calcSurfaceArea() {
        double baseArea = baseLength * baseWidth;
        double sideArea = baseLength * Math.sqrt(Math.pow(baseWidth / 2, 2) + Math.pow(height, 2)) / 2;
        return baseArea + 2 * sideArea;
    }

    public double getBaseLength() {
        return baseLength;
    }

    public double getBaseWidth() {
        return baseWidth;
    }

    public double getHeight() {
        return height;
    }
}
