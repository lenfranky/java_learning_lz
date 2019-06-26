package JianZhiOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        List<List<List<Integer>>> helpRes = new ArrayList<>();
        for (int i = 0; i < nums.length; i ++) helper(helpRes, nums, i);
        for (List<List<Integer>> lists: helpRes) for (List<Integer> list: lists) res.add(list);
        return res;
    }

    public void helper(List<List<List<Integer>>> helpRes, int[] nums, int index) {
        if (index >= nums.length) return;
        List<List<Integer>> currRes = new ArrayList<>();

        if (index == 0) {
            currRes.add(new ArrayList<>(Arrays.asList(nums[index])));
        }
        else {
            if (nums[index] == nums[index - 1]) {
                for (List<Integer> list: helpRes.get(index - 1)) {
                    List<Integer> currList = new ArrayList<>(list);
                    currList.add(nums[index]);
                    currRes.add(currList);
                }
            }
            else {
                currRes.add(new ArrayList<>(Arrays.asList(nums[index])));
                for (int i = 0; i < index; i ++) {
                    for (List<Integer> list: helpRes.get(i)) {
                        List<Integer> currList = new ArrayList<>(list);
                        currList.add(nums[index]);
                        currRes.add(currList);
                    }
                }
            }
        }
        helpRes.add(currRes);
    }

    public static void main(String[] args) {
        System.out.println(new Permutation2().permuteUnique(new int[] {1, 1, 2}));
    }
}
