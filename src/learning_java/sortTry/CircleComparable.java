package learning_java.sortTry;

import java.util.Arrays;

public class CircleComparable
        extends Circle
        implements Comparable<CircleComparable> {

    public CircleComparable(double radius) {
        super(radius);
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
        CircleComparable c = new CircleComparable(1);
        System.out.println("c instanceof CircleComparable:\t" + (c instanceof CircleComparable));
        System.out.println("c instanceof Circle:\t" + (c instanceof Circle));
        System.out.println("c instanceof Comparable:\t" + (c instanceof Comparable));
        System.out.println("c instanceof Object:\t" + (c instanceof Object));
        Circle[] circles = new CircleComparable[] {new CircleComparable(4), new CircleComparable(3), new CircleComparable(5)};
        for (Circle circle: circles)
            System.out.print(circle.getArea() + " ");
        System.out.println();
        Arrays.sort(circles);
        for (Circle circle: circles)
            System.out.print(circle.getArea() + " ");
    }
}
