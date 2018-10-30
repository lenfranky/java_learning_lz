package learning_java.ClassType;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        test2();
    }

    public static void test1() {
        List<Integer> listTest = new ArrayList<>();
        System.out.println(listTest.getClass().toString());
        System.out.println(listTest.getClass().getName());
        System.out.println(listTest.getClass().getName());
    }

    public static void test2() {
        Animal pet = new Cat("Miao", 3);
        System.out.println(ArrayList.class.getName());
    }
}
