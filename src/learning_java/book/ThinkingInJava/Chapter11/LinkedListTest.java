package learning_java.book.ThinkingInJava.Chapter11;

import java.util.Collections;
import java.util.LinkedList;

public class LinkedListTest {
    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5};
        LinkedList<Integer> list = new LinkedList<>();
        Collections.addAll(list, intArray);

        for (int i = 6; i <= 10; i ++) {
            list.offer(i);
        }

        System.out.println(list);

        for (int i = 0; i < 5; i ++) {
            System.out.println(list.poll());
        }

        System.out.println(list.getClass().getName());

        System.out.println(list);
    }
}
