package LeetCode;

import java.util.ArrayList;
import java.util.List;

// 二进制数字的格雷码的计算方式是自身与自身右移一位后做异或
public class No89 {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < 1 << n; i ++) {
            res.add(i ^ (i >> 1));
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new No89().grayCode(2));
    }
}
