package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class No54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return new ArrayList<>();
        List<Integer> res = new ArrayList<>(matrix.length * matrix[0].length);

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i ++) res.add(matrix[top][i]);
            top ++;
            for (int i = top; i <= bottom; i ++) res.add(matrix[i][right]);
            right --;
            if (bottom >= top) {
                for (int i = right; i >= left; i--) res.add(matrix[bottom][i]);
                bottom--;
            }
            if (right >= left) {
                for (int i = bottom; i >= top; i --) res.add(matrix[i][left]);
                left ++;
            }
        }
        return res;
    }

    public List<Integer> spiralOrderWithHelper(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return new ArrayList<>();
        List<Integer> res = new ArrayList<>(matrix.length * matrix[0].length);

        int rows = matrix.length;
        int columns = matrix[0].length;

        for (int i = 0; i * 2 < rows && i * 2 < columns; i ++) {
            helper(res, matrix, rows, columns, i);
        }

        return res;
    }

    public void helper(List<Integer> res, int[][] matrix, int rows, int columns, int start) {
        int endX = columns - 1 - start;
        int endY = rows - 1 - start;

        for (int i = start; i <= endX; i ++) {
            res.add(matrix[start][i]);
        }

        if (start < endY) {
            for (int i = start + 1; i <= endY; i++) {
                System.out.println(endX + " " + i);
                res.add(matrix[i][endX]);
            }
        }

        if (start < endY && start < endX) {
            for (int i = endX - 1; i >= start; i--) {
                res.add(matrix[endY][i]);
            }
        }

        if (start < endX && start < endY - 1) {
            for (int i = endY - 1; i >= start + 1; i--) {
                res.add(matrix[i][start]);
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrixTwo = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int[][] matrixThree = ArrayOperation.getIntArray("[[1],[2],[3],[4],[5],[6],[7],[8],[9],[10]]");
        System.out.println(new No54().spiralOrder(matrix));
    }
}
