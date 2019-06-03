package learning_java.GrammarTest;

import java.util.ArrayList;
import java.util.Arrays;

public class ListToArrayTest {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(1, 2, 3, 4));
        Integer[] nums = list.toArray(new Integer[list.size()]);
    }
}
