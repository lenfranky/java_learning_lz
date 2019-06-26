package LeetCode.Old;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> remainNums = new ArrayList<>();
        for (int num: nums) {
            remainNums.add(num);
        }
        permuteUniqueIterNew(res, new ArrayList<Integer>(), remainNums);
        return res;
    }

    public void permuteUniqueIter(List<List<Integer>> res, List<Integer> currentRes, List<Integer> remainNums) {
        if (remainNums.isEmpty()) {
            res.add(currentRes);
            return;
        }
        for (int i = 0; i < remainNums.size(); i ++) {
            // 可以理解为，在同一位置上出现过一次的数字，就不再在同一位置再次出现
            if(i > 0 && remainNums.get(i) == remainNums.get(i - 1)) continue;
            ArrayList<Integer> newRemainNums = new ArrayList<>(remainNums);
            ArrayList<Integer> newCurrentRes = new ArrayList<>(currentRes);
            newCurrentRes.add(newRemainNums.get(i));
            newRemainNums.remove(i);
            permuteUniqueIter(res, newCurrentRes, newRemainNums);
        }
    }

    public void permuteUniqueIterNew(List<List<Integer>> res, List<Integer> currentRes, List<Integer> remainNums) {
        if (remainNums.isEmpty()) {
            ArrayList<Integer> newCurrentRes = new ArrayList<>(currentRes);
            res.add(new ArrayList<Integer>(newCurrentRes));
            return;
        }
        for (int i = 0; i < remainNums.size(); i ++) {
            // 可以理解为，在同一位置上出现过一次的数字，就不再在同一位置再次出现
            if(i > 0 && remainNums.get(i) == remainNums.get(i - 1)) continue;
            int currentNum = remainNums.get(i);
            currentRes.add(currentNum);
            remainNums.remove(i);
            permuteUniqueIterNew(res, currentRes, remainNums);
            currentRes.remove(currentRes.size() - 1);
            remainNums.add(i, currentNum);
        }
    }

    public static void main(String[] args) {
        System.out.println(new No47().permuteUnique(new int[] {1, 1, 2}));
    }
}
