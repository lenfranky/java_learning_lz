package learning_java.GrammarTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static learning_java.GrammarTest.IOTools.print;


public class ListEqualsTest {
    public static void main(String[] args) {
        HashSet<List<Integer>> listSet = new HashSet<>();

        List<Integer> listOne = new ArrayList<>();
        listOne.add(1);
        listOne.add(2);
        listSet.add(listOne);
        print(listOne.hashCode());
        listOne.add(30);
        ArrayList<Integer> listTwo = new ArrayList<>();
        listTwo.add(1);
        listTwo.add(2);
        listTwo.add(30);
        System.out.println(listOne.equals(listTwo));

        print(listOne.hashCode());
        print("listSet.contains(listOne):\t" + listSet.contains(listOne));
    }
}
