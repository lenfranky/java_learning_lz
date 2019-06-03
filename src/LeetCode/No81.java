package LeetCode;

public class No81 {
    /*
    1 2 3 3 3 3 3 3 4 5 -> 3 4 5 3 | 3 3 3 3
    1 2 3 3 3 3 3 3  -> 3 3 3 3 1 2 3 3
     */
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        return helper(nums, 0, nums.length - 1, target);
    }

    private boolean helper(int[] nums, int startIndex, int endIndex, int target) {
        if (startIndex > endIndex) return false;
        if (startIndex == endIndex) return (nums[startIndex] == target);
        int midIndex = (startIndex + endIndex) / 2;
        if (nums[midIndex] == target) return true;

        if (nums[startIndex] == nums[midIndex]) return helper(nums, startIndex + 1, endIndex, target);
        else if(nums[startIndex] < nums[midIndex]) {
            if (target <= nums[midIndex] && target >= nums[startIndex]) return helper(nums, startIndex, midIndex - 1, target);
            else return helper(nums, midIndex + 1, endIndex, target);
        }
        else {
            if (target > nums[midIndex] && target <= nums[endIndex]) return helper(nums, midIndex + 1, endIndex, target);
            else return helper(nums, startIndex, midIndex - 1, target);
        }
    }

    /*
    [1,3,5]
    5
     */
    public static void main(String[] args){
        int[] nums = {2,5,6,0,0,1,2};
        int[] num2 = {1, 3, 5};
        int target = 5;
        System.out.println(new No81().search(num2, target));
    }
}
