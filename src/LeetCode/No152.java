package LeetCode;

public class No152 {
    // badcase: [-2]
    public int maxProductOld(int[] nums) {
        if (nums.length ==  0) return 0;
        int res = 0, cur = 0;
        for (int num: nums) {
            if (num <= 0) {
                if (cur > res) res = cur;
                cur = 0;
            }
            else {
                if (cur > 0)
                    cur *= num;
                else
                    cur = num;
            }
        }
        return res;
    }

    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;
        int[] maxLocal = new int[nums.length];
        int[] minLocal = new int[nums.length];

        int res = nums[0];
        maxLocal[0] = nums[0];
        minLocal[0] = nums[0];
        for (int i = 1; i < nums.length; i ++) {
            maxLocal[i] = Math.max(Math.max(maxLocal[i - 1] * nums[i], nums[i]), minLocal[i - 1] * nums[i]);
            minLocal[i] = Math.min(Math.min(minLocal[i - 1] * nums[i], nums[i]), maxLocal[i - 1] * nums[i]);
            res = Math.max(maxLocal[i], res);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {
                2, 3, 0, -2 , 4, -1
        };
        System.out.println(new No152().maxProduct(nums));
    }
}
