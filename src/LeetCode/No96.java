package LeetCode;

public class No96 {
    public int numTrees(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        int currRes;
        for (int i = 3; i <= n; i ++) {
            currRes = 0;
            for (int rootIndex = 1; rootIndex <= i; rootIndex ++) {
                currRes += dp[rootIndex - 1] * dp[i - rootIndex];
            }
            dp[i] = currRes;
        }

//        print(dp);

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new No96().numTrees(20));
    }
}
