package LeetCode;

public class No153 {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        return helper(nums, 0, nums.length -1);
    }

    private int helper(int[] nums, int startIndex, int endIndex) {
//        if (startIndex > endIndex) return -1;
        if (startIndex >= endIndex) return nums[startIndex];
        int midIndex = (startIndex + endIndex) / 2;
        // 如果前面一半是按顺序的，有两种可能，一种是被翻转过来的，一种是本来就是较小的部分
//        if (nums[midIndex] > nums[startIndex]) {
//            if (nums[midIndex] < nums[endIndex]) return helper(nums, startIndex, midIndex);
//            else return helper(nums, midIndex + 1, endIndex);
//        }
//        // 前面一半不是按顺序的,就用后一半来判断（最小值位于哪一半中）
//        else {
//            if (nums[startIndex] < nums[endIndex]) return helper(nums, startIndex, midIndex);
//            else return helper(nums, midIndex + 1, endIndex);
//        }

        int firstHalfMinValue = Math.min(nums[startIndex], nums[midIndex]);
        int lastHalfMinValue = midIndex == endIndex ? nums[endIndex] : Math.min(nums[midIndex + 1], nums[endIndex]);
        if (firstHalfMinValue < lastHalfMinValue) return helper(nums, startIndex, midIndex);
        else return helper(nums, midIndex + 1, endIndex);
    }

    /*
    3, 1, 2
     */
    public static void main(String[] args) {
        System.out.println(new No153().findMin(new int[] {4,5,6,7,0,1,2}));
    }
}
