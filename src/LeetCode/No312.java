package LeetCode;

import static Tools.IOTools.print;

public class No312 {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        if (n == 0) return 1;
        boolean[] isDeleted = new boolean[n];
        int res = 0;

        int deleteCount = 0;
        while (deleteCount < n) {
            int currMin = Integer.MAX_VALUE;
            for (int i = 0; i < n; i ++) {
                currMin = (!isDeleted[i] && nums[i] < currMin) ? nums[i] : currMin;
            }
            for (int i = 0; i < n; i++) {
                if (nums[i] == currMin) {
                    res += getCoinsMul(nums, n, isDeleted, i);
                    deleteCount ++;
                    break;
                }
            }
        }
        return res;
    }

    public int getCoinsMul(int[] nums, int n, boolean[] isDeleted, int index) {
        int res = 1;
        for (int i = index - 1; i >= 0; i --) {
            if (isDeleted[i])
                continue;
            else {
                res *= nums[i];
                break;
            }
        }
        for (int i = index + 1; i < n; i ++) {
            if (isDeleted[i])
                continue;
            else {
                res *= nums[i];
                break;
            }
        }
        res *= nums[index];
        isDeleted[index] = true;
        return res;
    }

    public static void main(String[] args) {
        print(new No312().maxCoins(new int[] {3,1,5,8}));
    }
}
