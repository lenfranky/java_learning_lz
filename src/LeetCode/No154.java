package LeetCode;

public class No154 {
    // 只看中间值和最右边？
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        return helper(nums, 0, nums.length - 1);
    }
    /*
    如果mid > end:
        1) 567 123
        2)
     */

    private int helper(int[] nums, int start, int end) {
        if (start >= end) return nums[end];
        int mid = (start + end) / 2;
        int firstHalfMinValue = Math.min(nums[start], nums[mid]);
        int lastHalfMinValue = mid == end ? nums[end] : Math.min(nums[mid + 1], nums[end]);
        if (firstHalfMinValue == lastHalfMinValue) return helper(nums, start + 1, end);
        else if (firstHalfMinValue < lastHalfMinValue) return helper(nums, start, mid);
        else return helper(nums, mid + 1, end);
    }

    /*
    [10,1,10,10,10]
     */
    public static void main(String[] args) {
        System.out.println(new No154().findMin(new int[] {10,1,10,10,10}));
    }
}
