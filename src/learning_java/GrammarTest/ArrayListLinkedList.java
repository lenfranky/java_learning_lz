package learning_java.GrammarTest;

import java.util.ArrayList;
import java.util.LinkedList;

public class ArrayListLinkedList {
    public static void main(String[] args) {
        int iterNum = 20000000;

        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < iterNum; i ++) {
            arrayList.add(i);
        }
        long endTime = System.currentTimeMillis();
        long arrayListTime = endTime - startTime;
        System.out.println("arrayListTime:\t" + arrayListTime);

        startTime = System.currentTimeMillis();
        for (int i = 0; i < iterNum; i ++) {
            linkedList.add(i);
        }
        endTime = System.currentTimeMillis();
        long linkedListTime = endTime - startTime;
        System.out.println("linkedListTime:\t" + linkedListTime);

        startTime = System.currentTimeMillis();
        for (int i = 0; i < iterNum; i ++) {
//            System.out.println(arrayList.size() - 1);
            arrayList.remove(arrayList.size() - 1);
        }
        endTime = System.currentTimeMillis();
        long arrayListRemoveTime = endTime - startTime;
        System.out.println("arrayListRemoveTime:\t" + arrayListRemoveTime);

        startTime = System.currentTimeMillis();
        for (int i = 0; i < iterNum; i ++) {
            linkedList.pollLast();
        }
        endTime = System.currentTimeMillis();
        long linkedListRemoveTime = endTime - startTime;
        System.out.println("linkedListRemoveTime:\t" + linkedListRemoveTime);
    }
}
