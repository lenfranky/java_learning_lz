package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class No46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> remainNums = new ArrayList<>(nums.length);
        for (int num: nums)
            remainNums.add(num);
        addElementIter(res, new ArrayList<Integer>(), remainNums);
        return res;
    }

    public void addElementIter(List<List<Integer>> res, ArrayList<Integer> currentRes, ArrayList<Integer> remainNums) {
        if (remainNums.isEmpty()) {
            res.add(currentRes);
            return;
        }
        for (int i = 0; i < remainNums.size(); i ++) {
            ArrayList<Integer> newRemainNums = new ArrayList<>(remainNums);
            ArrayList<Integer> newCurrentRes = new ArrayList<>(currentRes);
            newCurrentRes.add(newRemainNums.get(i));
            newRemainNums.remove(i);
            addElementIter(res, newCurrentRes, newRemainNums);
        }
    }

    public static void main(String[] args) {
        No46 solution = new No46();
        System.out.println(solution.permute(new int[] {1, 2, 3}));
        System.out.println(solution.permute(new int[] {1, 2, 1}));
    }
}
