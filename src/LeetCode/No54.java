package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class No54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) return res;
        int rowStart = 0, colStart = 0, rowEnd = matrix.length - 1, colEnd = matrix[0].length - 1;
        while(rowStart <= rowEnd && colStart <= colEnd) {
            for (int i = colStart; i <= colEnd; i ++)
                res.add(matrix[rowStart][i]);
            rowStart ++;
            for (int i = rowStart; i <= rowEnd; i ++)
                res.add(matrix[i][colEnd]);
            colEnd --;
            if (rowStart <= rowEnd) {
                for (int i = colEnd; i >= colStart; i--)
                    res.add(matrix[rowEnd][i]);
                rowEnd--;
            }
            if (colStart <= colEnd) {
                for (int i = rowEnd; i >= rowStart; i--)
                    res.add(matrix[i][colStart]);
                colStart++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrixTwo = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(new No54().spiralOrder(matrixTwo));
    }
}
