package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class No78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());
        if (nums.length == 0) return res;
        addSubsets(nums, res, new ArrayList<Integer>(), 0);
        return res;
    }

    public void addSubsets(int[] nums, List<List<Integer>> res, List<Integer> currentRes, int start) {
        for (int i = start; i < nums.length; i ++) {
            currentRes.add(nums[i]);
            res.add(new ArrayList<>(currentRes));
            addSubsets(nums, res, currentRes,i + 1);
            currentRes.remove(currentRes.size() - 1);
        }
    }
    public static void main(String[] args) {
        System.out.println(new No78().subsets(new int[] {1, 2, 3}));
    }
}
