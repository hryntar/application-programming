package LabWork_2.Task2;
import LabWork_2.Task2.shapes.three_d.Cube;
import LabWork_2.Task2.shapes.three_d.Pyramid;
import LabWork_2.Task2.shapes.three_d.Sphere;
import LabWork_2.Task2.shapes.two_d.Circle;
import LabWork_2.Task2.shapes.two_d.Rectangle;
import LabWork_2.Task2.shapes.two_d.Square;
import LabWork_2.Task2.shapes.two_d.Triangle;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(6);
        Square square = new Square(4);
        Rectangle rectangle = new Rectangle(3, 4);
        Triangle triangle = new Triangle(3, 4);

        Cube cube = new Cube(10);
        Sphere sphere = new Sphere(10);
        Pyramid pyramid = new Pyramid(5, 10, 10);

        System.out.println("Площа кола: " + circle.calcArea());
        System.out.println("Площа квадрата: " + square.calcArea());
        System.out.println("Площа прямокутника: " + rectangle.calcArea());
        System.out.println("Площа трикутника: " + triangle.calcArea());
        System.out.println("Об'єм куба: " + cube.calcVolume());
        System.out.println("Площа бічної сторони куба: " + cube.calcSurfaceArea());
        System.out.println("Об'єм піраміди: " + pyramid.calcVolume());
        System.out.println("Площа бічної сторони піраміди: " + pyramid.calcSurfaceArea());
        System.out.println("Об'єм сфери: " + sphere.calcVolume());
        System.out.println("Площа сфери: " + sphere.calcSurfaceArea());
    }
}
