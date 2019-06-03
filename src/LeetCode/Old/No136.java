package LeetCode.Old;

import java.util.HashSet;
import java.util.Set;

public class No136 {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num: nums) {
            res = res ^ num;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new No136().singleNumber(new int[] {4,1,2,1,2}));
    }
}
