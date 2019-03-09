package learning_java.GrammarTest;

import java.util.ArrayList;

public class ArrayListOperation {
    public static void main(String[] args) {
        ArrayList<Integer> listA = new ArrayList<>();
        listA.add(1);
        listA.add(3);
        listA.add(5);
        print(listA);
    }

    public static void print(ArrayList<?> list) {
        for (int iterNum = 0; iterNum < list.size(); iterNum ++) {
            System.out.print(list.get(iterNum) + " ");
        }
        System.out.println();
    }
}
