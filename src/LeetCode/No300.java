package LeetCode;

public class No300 {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int dp[] = new int[nums.length];
        int res = 1;
        dp[0] = 1;
        for (int i = 1; i < nums.length; i ++) {
            int currentRes = 0;
            for (int j = 0; j < i; j ++) {
                if (nums[j] < nums[i]) {
                    if (currentRes < dp[j])
                        currentRes = dp[j];
                }
            }
            currentRes ++;
            if (currentRes > res)
                res = currentRes;
            dp[i] = currentRes;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new No300().lengthOfLIS(new int[] {10,9,2,5,3,7,101,18}));
    }
}
