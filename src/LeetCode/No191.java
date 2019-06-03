package LeetCode;

import java.util.concurrent.TimeUnit;

public class No191 {
    public int hammingWeight(int n) {
        return 0;
    }

    public void shiftTestTimeSleep() {
        int n = 1;
        while (n != 0) {
            n = n << 1;
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Integer.toBinaryString(n));
        }
    }

    public void shiftTest() {
        int n = 1;
        while (n != 0) {
            n = n << 1;
            System.out.println(Integer.toBinaryString(n));
            System.out.println(n);
        }
//
        n = 1;
        System.out.println(n << 33);
    }

    public static void main(String[] args) {
        No191 solution = new No191();
        solution.shiftTest();
    }
}
