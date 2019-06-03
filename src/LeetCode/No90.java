package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        helper(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void helper(int[] nums, int startIndex, List<Integer> currRes, List<List<Integer>> res) {
        if (currRes.size() > 0) {
            res.add(new ArrayList<>(currRes));
        }
        for (int i = startIndex; i < nums.length; i ++) {
            if (i > startIndex && nums[i] == nums[i - 1]) continue;
            currRes.add(nums[i]);
            helper(nums, i + 1, currRes, res);
            currRes.remove(currRes.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new No90().subsetsWithDup(new int[] {1, 2, 3, 0, 1}));
    }
}
