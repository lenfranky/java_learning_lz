package LeetCode;

public class No121 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int minValue = prices[0];
        int[] dp = new int[prices.length];

        for (int i = 1; i < prices.length; i ++) {
            dp[i] = Math.max(dp[i - 1], prices[i] - minValue);
            if (prices[i] < minValue) minValue = prices[i];
        }

        return dp[prices.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new No121().maxProfit(new int[] {7, 1, 5, 3, 6, 4}));
    }
}
