package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class No77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        addCombine(res, new ArrayList<Integer>(), n , k, 1);
        return res;
    }

    public void addCombine(List<List<Integer>> res, List<Integer> currentRes, int n, int k, int start) {
        if (currentRes.size() == k){
            res.add(new ArrayList<>(currentRes));
            return;
        }
        for (int i = start; i <= n; i ++) {
            currentRes.add(i);
            addCombine(res, currentRes, n, k, i + 1);
            currentRes.remove(currentRes.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new No77().combine(4, 2));
    }
}
