package learning_java.Collections;

public class GenericsTest {
    public static void main(String[] args) {
        testMethod(1);
        GenericsTest.<Integer>testMethod(1);
        polymorphism();
    }

    public static <T> void testMethod(T element) {
        T currentValue = (T)new Object();
        //System.out.println(currentValue.getClass().getName());
        T[] elements = (T[]) new Object[5];
        elements[0] = element;
        System.out.println(elements[0].getClass().getName());
        //System.out.println(element.getClass().getName());
    }

    public static void polymorphism() {
        int num1 = 1;
        double num2 = 0.5;

        Object[] elements = new Object[2];

        elements[0] = num1;
        elements[1] = num2;

        System.out.println(elements[0].getClass().getName());
        System.out.println(elements[1].getClass().getName());
    }
}
