package learning_java.GrammarTest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static learning_java.GrammarTest.IOTools.print;

public class ArrayToList {
    public static void main(String[] args) {
        int[][] nums = {{1,2}, {3, 4}, {5, 6}};
        List<int[]> res = new ArrayList<>();
//        for (int[] line: nums) {
//            res.add(line);
//        }
        for (int i = 0; i < nums.length; i ++) {
            res.add(nums[i]);
        }
//        for (int[] line: res) {
//            print(line);
//        }
        for (int i = 0; i < res.size(); i ++) {
            print(res.get(i));
        }
    }
}
