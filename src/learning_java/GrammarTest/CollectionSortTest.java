package learning_java.GrammarTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionSortTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(6, 12, 1, 2, 3, 4, 5));
        Collections.sort(list);
        System.out.println(list);
        list.size();
    }
}
