package learning_java.GrammarTest;

import java.util.Arrays;
import java.util.Comparator;

import static learning_java.GrammarTest.IOTools.print;

public class ArrayCompatorTest {
    public static void main(String[] args) {
        int[][] nums = {{1, 2}, {5, 3}, {5, 2}, {6, 0}, {6, 2}};
//        print(nums);
        Arrays.sort(nums, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] < o2[0]) {
//                    print(o1);
//                    print(o2);
                    return 1;
                }
                else if (o1[0] > o2[0]) {
                    return -1;
                }
                else if (o1[1] > o2[1]) {
//                    print(o1);
//                    print(o2);
                    return 1;
                }
                else if (o1[1] < o2[1]) {
//                    print(o1);
//                    print(o2);
                    return -1;
                }
                else
                    return 0;
            }
        });
        print(nums);
    }
}
