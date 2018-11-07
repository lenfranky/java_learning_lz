package LeetCode;

// badcase: [1,1,1,2,2,3]
public class No80 {
    // 11ms
    public int removeDuplicates(int[] nums) {
        if (nums.length < 3) {
            return nums.length;
        }
        int res = 2;
        for (int i = 2; i < nums.length; i ++) {
            // 此时若加进去，则结果中会出现长度为3的连续数字
            if (nums[i] == nums[res-2])
                continue;
            else {
                nums[res] = nums[i];
                res ++;
            }
        }
        return res;
    }

    // 1ms
    public int removeDuplicatesFast(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int num : nums) {
            if (i < 2 || num > nums[i - 2]) {
                nums[i] = num;
                i = i + 1;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(new No80().removeDuplicates(new int[] {1,1,1,2,2,3}));
    }
}
