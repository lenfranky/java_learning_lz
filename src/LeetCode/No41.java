package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class No41 {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> numSet = new HashSet<>(nums.length);
        for (int num: nums) {
            numSet.add(num);
        }
        for (int i = 1; i < nums.length + 2; i ++) {
            if (!numSet.contains(i)) {
                return i;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        System.out.println(new No41().firstMissingPositive(new int[] {3,4,-1,1}));
    }
}
