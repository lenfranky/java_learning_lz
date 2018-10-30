package learning_java.sortTry;

import java.util.Comparator;

public class CircleComparator
        implements Comparator<Circle> {
    public int compare(Circle o1, Circle o2) {
        if (o1.getArea() > o2.getArea())
                return 1;
        else if (o1.getArea() < o2.getArea())
            return -1;
        else
            return 0;
    }
}
