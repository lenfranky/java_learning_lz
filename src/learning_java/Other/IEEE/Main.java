package learning_java.Other.IEEE;

import java.util.Scanner;

public class Main {
//    public static int getMinCost(int[] costs, int n, int k) {
//        if (n < k) {
//            int res = Integer.MAX_VALUE;
//            for (int cost: costs) res = Math.min(res, cost);
//            return res;
//        }
//
//        int[] dp = new int[n];
//        dp[0] = costs[0];
//
//        for (int i = 1; i <= k; i ++) {
//            dp[i] = Math.min(dp[i - 1], costs[i]);
//        }
//
//        for (int i = k + 1; i < n; i ++) {
//            dp[i] = Integer.MAX_VALUE;
//            int j;
//            for (j = i - k; j < i; j ++) {
//                dp[i] = Math.min(dp[i], (j - k - 1 > 0 ? dp[j - k - 1] : 0) + costs[j]);
//            }
//            for (j = Math.max(0, i - 2 * k); j < i; j ++) {
//                dp[i] = Math.min(dp[i], costs[i] + costs[j] + (j - k - 1 >= 0 ? (dp[j - k - 1]) : 0));
//            }
//        }
//        print (dp);
//        return dp[n - 1];
//    }

    public static long getMinCostTwo(int[] costs, int n, int k) {
        if (n == 0) return 0;
        if (n < k) {
            long res = Integer.MAX_VALUE;
            for (int cost: costs) res = Math.min(res, cost);
            return res;
        }

        long[] dp = new long[n];
        dp[0] = costs[0];

        for (int i = 1; i <= k; i ++) {
            dp[i] = Math.min(dp[i - 1], costs[i]);
        }

        for (int i = k + 1; i < n; i ++) {
            dp[i] = Integer.MAX_VALUE;
            int j;
            for (j = i - k; j < i; j ++) {
                dp[i] = Math.min(dp[i], (j - k - 1 >= 0 ? dp[j - k - 1] : 0) + costs[j]);
            }
            dp[i] = Math.min((i - k - 1 >= 0 ? dp[i - k - 1] : 0) + costs[i], dp[i]);
        }
        return dp[n - 1];
    }

    public static long getMinCost(int[] costs, int n, int k) {
        int res = Integer.MAX_VALUE;
        int index = 0;
        for (int startIndex = 0; startIndex <= k; startIndex++) {
            int currRes = 0;
            for (index = startIndex; index < n; index = index + 2 * k + 1)
                currRes += costs[index];

            if (index - n + 1> k)
                res = Math.min(res, currRes);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String temp = in.nextLine();
        String[] ss = temp.trim().split(" ");
        int n = Integer.parseInt(ss[0]);
        int k = Integer.parseInt(ss[1]);
        int[] costs = new int[n];
        temp = in.nextLine();
        ss = temp.trim().split(" ");
        for (int i = 0; i < n; i ++) {
            costs[i] = Integer.parseInt(ss[i]);
        }
        System.out.println(Main.getMinCost(costs, n, k));
    }
}
