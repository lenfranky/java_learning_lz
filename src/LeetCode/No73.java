package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class No73 {
    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0)
            return;
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> colSet = new HashSet<>();
        for (int i = 0; i < matrix.length; i ++) {
            for (int j = 0; j < matrix[0].length; j ++) {
                if (matrix[i][j] == 0) {
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }

        for (int i: rowSet) {
            for (int j = 0; j < matrix[0].length; j ++) {
                matrix[i][j] = 0;
            }
        }

        for (int i = 0; i < matrix.length; i ++) {
            for (int j: colSet) {
                matrix[i][j] = 0;
            }
        }
    }
}
