package LeetCode;

public class No115 {
    public int numDistinct(String s, String t) {
        char[] S = s.toCharArray(), T = t.toCharArray();
        if (s.length() == 0) return 0;
        if (t.length() == 0) return 1;
        int row = t.length() + 1, col = s.length() + 1;
        int[][] dp = new int[row][col];
        for (int i = 1; i < row; i ++) dp[i][0] = 0;
        for (int j = 0; j < col; j ++) dp[0][j] = 1;
        for (int i = 1; i < row; i ++) {
            for (int j = 1; j < col; j ++) {
                if (S[j-1] == T[i-1])
                    dp[i][j] = dp[i][j-1] + dp[i-1][j-1];
                else
                    dp[i][j] = dp[i][j-1];
            }
        }

        return dp[row-1][col-1];
    }

    public static void main(String[] args) {
        System.out.println(new No115().numDistinct("rabbbit", "rabbit"));
    }
}
