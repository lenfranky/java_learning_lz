package LeetCode;

public class No338 {
    /*
    // 从最基本的概念出发，得到的算法
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        int curNum, curRes, powCount;
        double curPow;
        for (int i = 0; i <= num; i ++) {
            curNum = i;
            curRes = 0;
            powCount = 1;
            while (curNum - (2 << powCount) >= 0) {
                powCount ++;
            }
            for (int j = powCount; j >= 0; j --) {
                curPow = Math.pow(2, j);
                System.out.print(i + " " + curNum + " " + curPow);
                if (curNum >= curPow) {
                    curNum -= curPow;
                    curRes += 1;
                }
                System.out.println(" " + curRes);
            }
            res[i] = curRes;
        }
        return res;
    }
    */


    // 前一种方法中存在着许多重复的计算，而对于这种重复的计算，一般首先想到的就是应用动态规划的思想来解决
    // 这段代码中采用的方法就是利用动态规划的思想，将数字区间分了多段，并记录每个段内最大的2的幂，而num-幂是已经求过的
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        res[0] = 0;
        if (num > 0)
            res[1] = 1;
        int curPower = 1;
        for (int i = 2; i <= num; i ++) {
            if (i - curPower == curPower) {
                res[i] = 1;
                curPower = i;
            }
            else {
                res[i] = res[i - curPower] + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Show.print(new No338().countBits(5));
    }
}
