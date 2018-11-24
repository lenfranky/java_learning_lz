package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class No119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> currentRes = new ArrayList<>();
        currentRes.add(1);
        if (rowIndex == 0) return currentRes;
        for (int i = 1; i <= rowIndex; i ++) {
            currentRes = new ArrayList<>(currentRes);
            currentRes.add(1);
            // 从倒数第二个数字开始
            for (int j = i - 1 ; j > 0; j --)
                currentRes.set(j, currentRes.get(j - 1) + currentRes.get(j));
        }
        return currentRes;
    }

    public static void main(String[] args) {
        System.out.println(new No119().getRow(5));
    }
}
