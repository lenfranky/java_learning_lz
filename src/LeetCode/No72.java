package LeetCode;

public class No72 {
    public int minDistance(String word1, String word2) {
        // 此时word2的长度可能为0
        if(word1.length() == 0) return word2.length();
        // 此时word1肯定长度不为0
        if(word2.length() == 0) return word1.length();

        int m = word2.length();
        int n = word1.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int j = 0; j <= n; j ++)
            dp[0][j] = j;

        for (int i = 1; i <= m; i ++) {
            for (int j = 0; j <= n; j ++) {
                if (j > 0) {
                    if (word1.charAt(j - 1) == word2.charAt(i - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                    else
                        dp[i][j] = min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1;
                }
                else {
                    dp[i][j] = dp[i - 1][j] + 1;
                }
            }
        }
//        print(dp);
        return dp[m][n];
    }
    public static int min(int num1, int num2, int num3) {
        int res = num1;
        if (num2 < res) res = num2;
        if (num3 < res) res = num3;
        return res;
    }

    public static void main(String[] args) {
        String word1 = "bcaty";
        String word2 = "beauty";
        System.out.println(new No72().minDistance(word1, word2));
    }
}
