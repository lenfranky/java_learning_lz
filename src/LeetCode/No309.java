package LeetCode;

import static Tools.IOTools.print;

public class No309 {
    public int maxProfit(int[] prices) {
        int m = prices.length;
        if (m == 0) return 0;
        int[] s0 = new int[m];
        int[] s1 = new int[m];
        int[] s2 = new int[m];
        s0[0] = 0;
        s1[0] = - prices[0];
        s2[0] = Integer.MIN_VALUE;
        for (int i = 1; i < m; i ++) {
            s0[i] = Math.max(s0[i - 1], s2[i - 1]);
            s1[i] = Math.max(s1[i - 1], s0[i - 1] - prices[i]);
            s2[i] = s1[i - 1] + prices[i];
        }
        return Math.max(s0[m - 1], s1[m - 1] + prices[m - 1]);
    }

    public static void main(String[] args) {
        print(new No309().maxProfit(new int[] {1,2,3,0,2}));
    }
}
