package LeetCode;

public class No322 {
    /*
    // 应用贪婪的思想
    // badcase: {1, 80, 90}, 160
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (coins.length == 0 || amount < 0) return -1;

        Arrays.sort(coins);

        int index = coins.length - 1;
        LinkedList<Integer> indexStack = new LinkedList<>();

        if (help(coins, index, indexStack, amount))
            return indexStack.size();
        else
            return -1;
    }

    public Boolean help(int[] coins, int index, LinkedList<Integer> indexStack, int amount) {
        if (amount == 0) return true;


        for (int nextIndex = index; nextIndex >= 0; nextIndex --) {
            if (coins[nextIndex] <= amount) {
                amount -= coins[nextIndex];
                indexStack.push(nextIndex);
//                System.out.println(indexStack);
                if (help(coins, nextIndex, indexStack, amount)) {
                    return true;
                }
                amount += coins[indexStack.pop()];
            }
        }

        return false;
    }
    */
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (coins.length == 0 || amount < 0) return -1;
        int [] dp = new int[amount + 1];
        for (int i = 0; i <= amount; i ++)
            dp[i] = Integer.MAX_VALUE;
        for (int curAmount = 1; curAmount <= amount; curAmount ++) {
            for (int coin: coins) {
                if (curAmount >= coin) {
                    if (curAmount == coin)
                        dp[curAmount] = 1;
                    else {
                        if (dp[curAmount-coin] != Integer.MAX_VALUE)
                            dp[curAmount] = Math.min(dp[curAmount], dp[curAmount - coin] + 1);
                    }
                }
            }
        }
//        for (int d: dp)
//            System.out.println(d);
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(new No322().coinChange(new int[] {186,419,83,408}, 6249));
    }
}
