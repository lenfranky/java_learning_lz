package learning_java.GrammarTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListMapTest {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list3.add(4);
        list3.add(5);
        System.out.println(list1.equals(list2));
        System.out.println(list1.equals(list3));
//
//        Set<List<Integer>> listSet = new HashSet<>();
//        System.out.println(listSet.add(list1));
//        System.out.println(listSet.contains(list2));
//        System.out.println(listSet.add(list2));
//        System.out.println(listSet.size());
    }
}
