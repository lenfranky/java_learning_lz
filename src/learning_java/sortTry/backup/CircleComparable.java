package learning_java.sortTry.backup;

import java.util.Arrays;

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
        CircleComparable[] circles = new CircleComparable[] {new CircleComparable(4), new CircleComparable(3), new CircleComparable(5)};
        for (CircleComparable circle: circles)
            System.out.print(circle.getArea() + " ");
        System.out.println();
        Arrays.sort(circles);
        for (CircleComparable circle: circles)
            System.out.print(circle.getArea() + " ");
    }
}
