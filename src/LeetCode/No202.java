package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class No202 {
    public boolean isHappy(int n) {
        Set<Integer> numSet = new HashSet<>();
        int sum;
        while (!numSet.contains(n)) {
            numSet.add(n);
            sum = 0;
            while (n > 0) {
                sum += (n % 10) * (n % 10);
                n = n / 10;
            }
            if (sum == 1) return true;
            n = sum;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new No202().isHappy(2));
    }
}
