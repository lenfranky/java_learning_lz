package LeetCode;

public class No279 {
    public int numSquares(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        int currMin;
        int j;
        for (int i = 3; i <= n; i ++) {
            j = 1;
            currMin = Integer.MAX_VALUE;
            while (j * j <= i) {
                currMin = Math.min(currMin, dp[i - j * j]);
                j ++;
            }
            // 把+1移到循环外，减少重复计算，加快计算速度
            dp[i] = currMin + 1;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new No279().numSquares(2));
    }
}
