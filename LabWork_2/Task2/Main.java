package LabWork_2.Task2;

import LabWork_2.Task2.shapes.three_d.Cone;
import LabWork_2.Task2.shapes.three_d.Cylinder;
import LabWork_2.Task2.shapes.two_d.Circle;
import LabWork_2.Task2.shapes.two_d.Square;
import LabWork_2.Task2.shapes.two_d.Triangle;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(6);
        Square square = new Square(4);
        Triangle triangle = new Triangle(3, 4);

        Cone cone = new Cone(5, 10);
        Cylinder cylinder = new Cylinder(5, 10);

        System.out.println("Площа кола: " + circle.calcArea());
        System.out.println("Площа квадрата: " + square.calcArea());
        System.out.println("Площа трикутника: " + triangle.calcArea());
        System.out.println("Об'єм конуса: " + cone.calcVolume());
        System.out.println("Площа бічної сторони конуса: " + cone.calcSurfaceArea());
        System.out.println("площа циліндра: " + cylinder.calcVolume());
        System.out.println("Площа бічної сторони циліндра: " + cylinder.calcSurfaceArea());
    }
}
