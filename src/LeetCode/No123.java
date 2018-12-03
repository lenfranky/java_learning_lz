package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// badcase: [1,2,4,2,5,7,2,4,9,0]
public class No123 {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        List<Integer> profitList = new ArrayList<>();
        int profit = 0;
        for (int i = 1; i < prices.length; i ++) {
            if (prices[i] - prices[i - 1] >= 0) {
                profit += prices[i] - prices[i - 1];
            }
            else {
                if (profit > 0)
                    profitList.add(profit);
                profit = 0;
            }
        }
        if (profit > 0)
            profitList.add(profit);
        Collections.sort(profitList);
        System.out.println(profitList);
        if (profitList.size() == 0)
            return 0;
        else if (profitList.size() == 1)
            return profitList.get(0);
        else
            return profitList.get(profitList.size() - 1) + profitList.get(profitList.size() - 2);
    }

    public static void main(String[] args) {
        System.out.println(new No123().maxProfit(new int[] {1,2,4,2,5,7,2,4,9,0}));
    }
}
