package learning_java.sortTry.backup;

import java.util.Arrays;

public class Circle {
    private double radius;

    public Circle() { this.radius = 0; }

    public Circle(double radius) { this.radius = radius;}

    public double getArea() { return Math.PI * radius * radius; }

    public static void main(String[] args) {
//        Circle circle = new Circle();
//        System.out.println(circle.getArea());
        Circle[] circles = new Circle[] {new Circle(4), new Circle(3), new Circle(5)};
        for (Circle circle: circles)
            System.out.println(circle.getArea());
        Arrays.sort(circles);
    }
}
