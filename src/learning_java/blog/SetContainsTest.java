package learning_java.blog;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetContainsTest {
    public static void main(String[] args) {
        HashSet<List<Integer>> listSet = new HashSet<>();

        List<Integer> listOne = new ArrayList<>();
        listOne.add(1);
        listOne.add(2);
        List<Integer> listTwo = new ArrayList<>();
        listTwo.add(1);
        listTwo.add(2);
        listSet.add(listOne);

        System.out.println("listSet.contains(listOne):\t" + listSet.contains(listOne));
        System.out.println("listOne.hashCode():\t" + listOne.hashCode());
        System.out.println("listSet.contains(listTwo):\t" + listSet.contains(listTwo));
        System.out.println("listTwo.hashCode():\t" + listTwo.hashCode());

        listOne.add(3);
        System.out.println("-----------after listOne's adding------------------");
        System.out.println("listSet.contains(listOne):\t" + listSet.contains(listOne));
        System.out.println("listOne.hashCode():\t" + listOne.hashCode());
        System.out.println("listSet.contains(listTwo):\t" + listSet.contains(listTwo));
        System.out.println("listTwo.hashCode():\t" + listTwo.hashCode());

        for (List<Integer> list: listSet) {
            System.out.println(list.hashCode());
        }
    }
}
