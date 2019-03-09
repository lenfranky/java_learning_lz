package LeetCode;

public class No416 {
    /*
    // 应用了贪婪的思想，但是只能得到近似解，由于初始值的不确定性，不能得到准确界
    // badcase: [3, 3, 3, 4, 5]
    public boolean canPartition(int[] nums) {
        if (nums.length == 0) return true;
        Arrays.sort(nums);
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        int sum1 = 0, sum2 = 0;
        for (int i = nums.length - 1; i >= 0; i --) {
            if (sum1 <= sum2)
                sum1 += nums[i];
            else
                sum2 += nums[i];
        }
        return sum1 == sum2;
    }
    */
    public boolean canPartition(int[] nums) {
        if (nums.length == 0) return true;
        int sum = 0;
        for (int num: nums)
            sum += num;
        if (sum % 2 == 1) return false;
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int num: nums) {
            for (int i = target; i >= num; i --) {
                dp[i] = dp[i] || dp[i - num];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        System.out.println(new No416().canPartition(new int[] {3, 3, 3, 4, 5}));
    }
}
