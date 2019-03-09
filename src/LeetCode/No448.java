package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class No448 {
    /*
    // HashSet速度并不如ArrayList（在这个题目中）
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums.length == 0) return res;

        Set<Integer> numsSet = new HashSet<>();

        for (int num: nums) {
            numsSet.add(num);
        }

        for (int i = 1; i <= nums.length; i ++) {
            if (! numsSet.contains(i)) {
                res.add(i);
            }
        }

        return res;
    }
    */

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int[] numsArray = new int[nums.length + 1];
        for (int num: nums) {
            numsArray[num] = 6;
        }

        for (int i = 1; i <= nums.length; i ++) {
            if (numsArray[i] != 6) {
                res.add(i);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new No448().findDisappearedNumbers(new int[] {4,3,2,7,8,2,3,1}));
    }
}
