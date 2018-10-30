package learning_java;

import java.util.ArrayList;

public class ArrayListNest {
    public static void main(String[] args) {
        ArrayList combinationList = new ArrayList();
        ArrayList firstCombination = new ArrayList<Integer>();
        ArrayList secondCombination = new ArrayList<Integer>();
        firstCombination.add(1);
        firstCombination.add(2);
        firstCombination.add(3);
        secondCombination.add(4);
        secondCombination.add(5);
        secondCombination.add(6);
        combinationList.add(firstCombination);
        combinationList.add(secondCombination);

        System.out.println(combinationList.get(1));
    }
}
