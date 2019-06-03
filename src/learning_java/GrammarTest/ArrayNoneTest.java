package learning_java.GrammarTest;

import java.util.ArrayList;
import java.util.List;

public class ArrayNoneTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(null);
        list.add(null);
        list.add(null);
        System.out.println(list.size());
    }
}
