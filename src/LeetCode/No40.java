package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates.length == 0) return res;
        Arrays.sort(candidates);
        helper(candidates, 0, new ArrayList<>(), target, res);
        return res;
    }

    private void helper(int[] candidates, int startIndex, List<Integer> currRes, int target, List<List<Integer>> res){
        if (target == 0) {
            res.add(new ArrayList<>(currRes));
            return;
        }
//        if (target < 0) return;
        for (int i = startIndex; i < candidates.length; i ++) {
            if (i > startIndex && candidates[i] == candidates[i - 1]) continue;
            int newTarget = target - candidates[i];
            // 可减少多次的add()和remove()
            if (newTarget < 0) continue;
            currRes.add(candidates[i]);
            helper(candidates, i + 1, currRes, newTarget, res);
            currRes.remove(currRes.size() - 1);
//            while (i < candidates.length - 1 && candidates[i] == candidates[i + 1])
//                i ++;
        }
    }

    /*
    [14,6,25,9,30,20,33,34,28,30,16,12,31,9,9,12,34,16,25,32,8,7,30,12,33,20,21,29,24,17,27,34,11,17,30,6,32,21,27,17,16,8,24,12,12,28,11,33,10,32,22,13,34,18,12]
    27
     */
    public static void main(String[] args) {
        int[] candidates1 = {10,1,2,7,6,1,5};
        int[] candidates2 = {2,5,2,1,2};
        int[] candidates3 = {14,6,25,9,30,20,33,34,28,30,16,12,31,9,9,12,34,16,25,32,8,7,30,12,33,20,21,29,24,17,27,34,11,17,30,6,32,21,27,17,16,8,24,12,12,28,11,33,10,32,22,13,34,18,12};
        int target1 = 8;
        int tsrget2 = 5;
        int target3 = 27;
        System.out.println(new No40().combinationSum2(candidates1, target1));
    }
}
