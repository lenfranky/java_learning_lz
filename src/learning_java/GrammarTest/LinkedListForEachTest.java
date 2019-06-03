package learning_java.GrammarTest;

import java.util.LinkedList;

public class LinkedListForEachTest {
    public static void main(String[] args) {
        LinkedList<Integer> nums = new LinkedList<>();
        nums.addFirst(1);
        nums.addFirst(2);
        nums.addFirst(3);
        System.out.println(nums);
        for (int num: nums) {
            System.out.println(num);
        }
    }
}
