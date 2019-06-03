package LeetCode;

import static learning_java.GrammarTest.IOTools.print;

public class No264 {
    /*
    1, 2, 3, 4, 5, 6, 8, 9, 10, 12
    每一个数都对应着3个接下来的数，如1对应着2、3、5，2对应着4、6、10，
    可以将这3个数字分别看作队列里的一个点
    因此，可以用3个指针来记录其在队列中的位置

    1  2  3  4  5  6   (主队列）
    2  4  6  8  10 18  （因子2对应的队列）
    3  6  9  12 15 18  （因子3对应的队列）
    5  10 15 20 25 30
     */
    public int nthUglyNumber(int n) {
        if (n == 0) return 0;
        int eList2 = 2, eList3 = 3, eList5 = 5;
        int index2 = 0, index3 = 0, index5 = 0;
        int[] nums = new int[n];
        nums[0] = 1;
        for (int i = 1; i < n; i ++) {
            int min = Math.min(eList2, Math.min(eList3, eList5));
            nums[i] = min;

            // 说明因子2对应的队列已有一个进入了主队列
            // 此时应该将因子2对应的队列向前移一位
            // 所对应的操作为，该队列所对应的在主队列数组中的索引加一
            if (min == eList2) {
                ++index2;
                eList2 = 2 * nums[index2];
            }

            if (min == eList3) eList3 = 3 * nums[++ index3];
            if (min == eList5) eList5 = 5 * nums[++ index5];
        }
        return nums[n - 1];
    }

    public static void main(String[] args) {
        print(new No264().nthUglyNumber(10));
    }
}
