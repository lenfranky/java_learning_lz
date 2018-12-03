package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class No136 {
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num: nums) {
            if (set.contains(num))
                set.remove(num);
            else
                set.add(num);
        }
        int res = 0;
        for (int num: set)
            res = num;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new No136().singleNumber(new int[] {4,1,2,1,2}));
    }
}
