package LeetCode;

public class No33 {
    public int searchOld(int[] nums, int target) {
        if(nums.length == 0) return -1;
        return helperOld(nums, target, 0, nums.length - 1);
    }

    public static int helperOld(int[] nums, int target, int startIndex, int endIndex) {
//        System.out.println(startIndex + " " + endIndex);
        if (startIndex == endIndex) {
            if (nums[startIndex] == target)
                return startIndex;
            else
                return -1;
        }
        int midIndex = (startIndex + endIndex) / 2;
        // 首先判断前半段是否是已经排序了
        // 若已经排序，则前半段已经排序，但后半段不一定，可能是乱序，也可能已排序（旋转点恰好再中间）
        if (nums[startIndex] < nums[midIndex]) {
            if (target >= nums[startIndex] && target <= nums[midIndex])
                return helperOld(nums, target, startIndex, midIndex);
            else
                return helperOld(nums, target, midIndex + 1, endIndex);
        }
        else {
            if (target >= nums[midIndex + 1] && target <= nums[endIndex])
                return helperOld(nums, target, midIndex + 1, endIndex);
            else
                return helperOld(nums, target, startIndex, midIndex);
        }
    }

    public int search(int[] nums, int target) {
        if(nums.length == 0) return -1;
        int[] currRes = {0, nums.length - 1};
        while(currRes[0] != currRes[1]) {
            helper(nums, target, currRes);
        }
        if (nums[currRes[0]] == target)
            return currRes[0];
        else
            return -1;
    }

    public void helper(int[] nums, int target, int[] currRes) {
        int midIndex = (currRes[0] + currRes[1]) / 2;
        if (nums[currRes[0]] < nums[midIndex]) {
            if (target >= nums[currRes[0]] && target <= nums[midIndex])
                currRes[1] = midIndex;
            else
                currRes[0] = midIndex + 1;
        }
        else {
            if (target >= nums[midIndex + 1] && target <= nums[currRes[1]])
                currRes[0] = midIndex + 1;
            else
                currRes[1] = midIndex;
        }
    }

    public static void main(String[] args) {
        int[] nums = {5, 1, 3};
        int target = 3;
        System.out.println(new No33().search(nums, target));
    }
}
