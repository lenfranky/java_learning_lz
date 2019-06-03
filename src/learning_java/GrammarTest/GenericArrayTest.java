package learning_java.GrammarTest;

import java.util.ArrayList;
import java.util.List;

public class GenericArrayTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        ArrayList<Integer>[] lists;
//        lists = new ArrayList<Integer>()[10];
        lists = (ArrayList<Integer>[]) new Object[10];
    }
}
