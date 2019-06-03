package learning_java.GrammarTest;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

import static learning_java.GrammarTest.IOTools.print;

public class PriorityQueueTest {
    public void fundamentalTest() {
        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(1);
        queue.add(10);
        queue.add(5);
        queue.add(2);
        print(queue.poll());
        print(queue.poll());
    }
    static public class Circle {
        private double radius;

        public Circle() {
            this.radius = 0;
        }

        public Circle(double radius) {
            this.radius = radius;
        }

        public double getArea() {
            return Math.PI * radius * radius;
        }
    }

    /*
    在ComparableTimSort中会报出
    if (((Comparable) a[runHi++]).compareTo(a[lo]) < 0) {
    learning_java.GrammarTest.PriorityQueueTest$Circle cannot be cast to java.lang.Comparable
     */
    public static void CollectionWithClassWithoutComparable() {
        Circle circle1 = new Circle(3);
        Circle circle2 = new Circle(4);
        Circle circle3 = new Circle(5);
        PriorityQueue<Circle> circles = new PriorityQueue<>();
        circles.offer(circle1);
        circles.offer(circle2);
    }

    public static void ArrayWithClassWithoutComparable() {
        Circle circle1 = new Circle(3);
        Circle circle2 = new Circle(4);
        Circle circle3 = new Circle(5);
        Circle[] circles = {circle1, circle2, circle3};
        Arrays.sort(circles);
    }

    public static void main(String[] args) {
        CollectionWithClassWithoutComparable();
        ArrayWithClassWithoutComparable();
    }
}
