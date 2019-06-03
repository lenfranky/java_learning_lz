package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class No39 {
    public List<List<Integer>> combinationSumDP(int[] candidates, int target) {
        List<List<List<Integer>>> dp = new ArrayList<>(target + 1);
        List<List<Integer>> currList = new ArrayList<>();
        dp.add(currList);
        for (int i = 1; i <= target; i ++) {
            currList = new ArrayList<>();
            for (int j: candidates) {
                if (i == j) {
                    currList.add(new ArrayList<Integer>(Arrays.asList(j)));
                }
                if (i - j > 0 && i - j < dp.size()) {
                    if (dp.get(i - j).size() > 0) {
                        for (List<Integer> numList: dp.get(i - j)) {
                            List<Integer> newNumList = new ArrayList<>(numList);
                            newNumList.add(j);
                            Collections.sort(newNumList);
                            if(!isInList(currList, newNumList))
                                currList.add(newNumList);
                        }
                    }
                }
            }
            dp.add(currList);
        }
        return dp.get(target);
    }

    public static boolean isInList(List<List<Integer>> allNumList, List<Integer> newNumList) {
        int index = 0;
        boolean res = false;
        for (List<Integer> numList: allNumList) {
            if(numList.size() == newNumList.size()) {
                index = 0;
                for (; index < numList.size(); index ++) {
                    if (!numList.get(index).equals(newNumList.get(index))) {
                        break;
                    }
                }
                if (index == numList.size())
                    return true;
            }
        }
        return false;

//        return allNumList.contains(newNumList);
//        allNumList.equals(newNumList);
    }


    /*
    像这种，需要输出多个列表的题，首先考虑回溯的方法

    本题中，通过向回溯函数中传入上一次开始遍历的数组中的位置，来避免重复列表的出现
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backTracking(candidates, target, res, 0, new ArrayList<Integer>(), 0);
        return res;
    }

    public static void backTracking(int[] candidates, int target, List<List<Integer>> res, int currSum, List<Integer> currList, int startIndex) {
        if (currSum == target){
            res.add(new ArrayList<>(currList));
            return;
        }

        int nextSum = 0;
        for (int i = startIndex; i < candidates.length; i ++) {
            nextSum = candidates[i] + currSum;
            if(nextSum > target)
                continue;
            currList.add(candidates[i]);
            backTracking(candidates, target, res, nextSum, currList, i);
            currList.remove(currList.size() - 1);
        }
    }


    public static void main(String[] args) {
        int[] candidates = {2, 3, 5, 7};
        int target = 7;
        System.out.println(new No39().combinationSum(candidates, target));
    }
}
