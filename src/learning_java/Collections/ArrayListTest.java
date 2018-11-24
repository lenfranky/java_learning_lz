package learning_java.Collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
    Test1 several ways to traversal a List.
 */
public class ArrayListTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int iterNum = 0; iterNum < 50000000; iterNum ++) {
            list.add(iterNum);
        }

        long startTime = System.currentTimeMillis();
        System.out.println(startTime);
        iterOne(list);
        long timeTwo = System.currentTimeMillis();
        System.out.println(timeTwo);
        iterTwo(list);
        // iterThree(list);
    }

    public static <E> void iterOne(List<E> list) {
        long startTime = System.currentTimeMillis();
        int length = list.size();
        E currentValue;
        for (int i = 0; i < length; i ++) {
            currentValue = list.get(i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }

    public static <E> void iterTwo(List<E> list) {
        long startTime = System.currentTimeMillis();
        Iterator iterator = list.iterator();
        E currentValue;
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getClass());
            // currentValue = (E)iterator.next();
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }

    public static <E> void iterThree(List<E> list) {
        long startTime = System.currentTimeMillis();
        E currentValue;
        for (E o: list) {
            currentValue = o;
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }

}
