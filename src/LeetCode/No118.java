package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class No118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>(numRows);
        if (numRows == 0) return res;
        List<Integer> currentRes = new ArrayList<>();
        currentRes.add(1);
        res.add(currentRes);
        for (int i = 1; i < numRows; i ++) {
            currentRes = new ArrayList<>(currentRes);
            currentRes.add(1);
//            System.out.println("capacity:" + currentRes.size());
            // 这里需要反向，向前遍历，因为若从前向后遍历，会使得后面的数调用前面的数进行计算的时候，前面的数字已经在本次迭代中被改变了
            for (int j = i -1 ; j > 0; j --)
                currentRes.set(j, currentRes.get(j - 1) + currentRes.get(j));
            res.add(currentRes);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new No118().generate(5));
    }
}
