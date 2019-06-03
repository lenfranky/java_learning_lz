package learning_java.GrammarTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapTest {
    public static void main(String[] args){
        HashMap<List<Integer>, Integer> map = new HashMap<>();
        List<Integer> listOne = new ArrayList<>();
        listOne.add(1);
        listOne.add(2);
        List<Integer> listTwo = new ArrayList<>();
        listTwo.add(1);
        listTwo.add(2);
        map.put(listOne, 1);
        System.out.println("map.get(listOne) : \t" + map.get(listOne));
        System.out.println("map.get(listTwo) : \t" + map.get(listTwo));

        listOne.add(3);
        System.out.println("map.get(listOne) : \t" + map.get(listOne));
        System.out.println("map.get(listTwo) : \t" + map.get(listTwo));
    }
}
