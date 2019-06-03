package LeetCode;

import static LeetCode.Tools.print;

public class No34 {
    public int[] searchRange(int[] nums, int target) {
//        int midIndex = Arrays.binarySearch(nums, target);
        if (nums.length == 0)
            return new int[] {-1, -1};
        int[] currRes = {0, nums.length -1};
        while(currRes[0] != currRes[1]) {
            binarySearch(nums, target, currRes);
        }
        int[] res = {currRes[0], currRes[0]};
        if(nums[currRes[0]] != target) {
            res[0] = -1;
            res[1] = -1;
            return res;
        }

//        if (currRes[0] < 0) {
//            res[0] = -1;
//            res[1] = -1;
//            return res;
//        }

        while(res[0] > 0) {
            if(nums[res[0] - 1] == target)
                res[0] = res[0] - 1;
            else
                break;
        }

        while(res[1] < nums.length - 1) {
            if(nums[res[1] + 1] == target)
                res[1] = res[1] + 1;
            else
                break;
        }

        return res;
    }

    public static void binarySearch(int[] nums, int target, int[] currRes) {
        int midIndex = (currRes[0] + currRes[1]) / 2;
        if (target > nums[midIndex])
            currRes[0] = midIndex + 1;
        else
            currRes[1] = midIndex;
    }

    public static void main(String[] args) {
        int[] nums = {};
        int target = 1;
        print(new No34().searchRange(nums, target));
    }
}
