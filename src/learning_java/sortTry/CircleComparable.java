package learning_java.sortTry;

import java.util.Comparator;

public class CircleComparable
        implements Comparable<CircleComparable> {
    private double radius;

    public CircleComparable() {
        this.radius = 0;
    }

    public CircleComparable(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public int compareTo(CircleComparable circleToCom) {
        if (this.getArea() > circleToCom.getArea())
            return 1;
        else if (this.getArea() < circleToCom.getArea())
            return -1;
        else
            return 0;
    }

    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle.getArea());
    }
}
