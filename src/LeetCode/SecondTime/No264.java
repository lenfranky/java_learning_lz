package LeetCode.SecondTime;

import static Tools.IOTools.print;

public class No264 {
    // 这样可以保证数组中的每一个都会分别乘2、3、5
    // 但是乘2、3、5的结果未必全部能放入数组，因为最后一部分只会放入其中较小的那一部分
    public int nthUglyNumber(int n) {
        if (n == 0) return 0;
        int[] uglyNumberArray = new int[n];
        uglyNumberArray[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        int e2 = 2, e3 = 3, e5 = 5;
        for (int i = 1; i < n; i ++) {
            int min = Math.min(e2, Math.min(e3, e5));
            uglyNumberArray[i] = min;
            if (e2 == min) e2 = uglyNumberArray[++ p2] * 2;
            if (e3 == min) e3 = uglyNumberArray[++ p3] * 3;
            if (e5 == min) e5 = uglyNumberArray[++ p5] * 5;
        }
//        print(uglyNumberArray);
        return uglyNumberArray[n - 1];
    }

    public static void main(String[] args) {
        print(new No264().nthUglyNumber(10));
    }
}
