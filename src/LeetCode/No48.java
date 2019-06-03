package LeetCode;

import static Tools.IOTools.print;

public class No48 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if (n == 0) return;
        int midIndex = n / 2;
        if (n % 2 == 0) {
            for (int i = 0; i < midIndex; i ++) {
                for (int j = 0; j < midIndex; j ++) {
                    swapElements(matrix, i, j, n - 1);
                }
            }
        }
        else {
            for (int i = 0; i <= midIndex; i ++) {
                for (int j = 0; j < midIndex; j ++) {
                    swapElements(matrix, i, j, n - 1);
                }
            }
        }
    }

    public static void swapElements(int[][] matrix, int i, int j, int n) {
//        int num1 = matrix[i][j];
        int num2 = matrix[j][n - i];
        int num3 = matrix[n - i][n - j];
        int num4 = matrix[n - j][i];

        matrix[j][n - i] = matrix[i][j];
        matrix[n - i][n - j] = num2;
        matrix[n - j][i] = num3;
        matrix[i][j] = num4;
    }

    public static void main(String[] args) {
//        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix = {{ 5, 1, 9,11}, { 2, 4, 8,10}, {13, 3, 6, 7}, {15,14,12,16}};
        new No48().rotate(matrix);
        print(matrix);
    }
}
