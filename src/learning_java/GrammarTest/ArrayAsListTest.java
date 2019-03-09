package learning_java.GrammarTest;

import java.util.Arrays;
import java.util.List;

public class ArrayAsListTest {
    public static void main(String[] args) {
        int[] intArray = {1, 3 ,5};
        char[] charArray = {'a', 'b', 'c'};

        Integer[] integerArray = {1, 3, 5};
//        Character characterArray = ArrayUtils.to

        List temp = Arrays.asList(integerArray);

        System.out.println(temp.size());

    }
}
