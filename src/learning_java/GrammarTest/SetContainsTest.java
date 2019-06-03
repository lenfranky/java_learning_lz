package learning_java.GrammarTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SetContainsTest {
    public static void main(String[] args) {
        HashSet<List<Integer>> listSet = new HashSet<>();

        List<Integer> listOne = new ArrayList<>();
        listOne.add(1);
        listOne.add(2);
        listSet.add(listOne);
        System.out.println(listOne.hashCode());

        listOne.add(3);
        System.out.println(listOne.hashCode());
        System.out.println("listSet.contains(listOne):\t" + listSet.contains(listOne));

        List<Integer> listTwo = new ArrayList<>();
        listTwo.add(1);
        listTwo.add(2);
        System.out.println(listTwo.hashCode());
        System.out.println("listSet.contains(listTwo):\t" + listSet.contains(listTwo));
    }
}
