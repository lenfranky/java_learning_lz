package LeetCode;

public class No59 {
    public int[][] generateMatrix(int n) {
        int rowStart = 0, rowEnd = n - 1, colStart = 0, colEnd = n -1;
        int[][] matrix = new int[n][n];
        int currentNum = 1;
        while(rowStart <= rowEnd && colStart <= colEnd) {
            for (int i = colStart; i <= colEnd; i ++) {
                matrix[rowStart][i] = currentNum ++;
            }
            rowStart ++;
            for (int i = rowStart; i <= rowEnd; i ++)
                matrix[i][colEnd] = currentNum ++;
            colEnd --;
            if (rowStart <= rowEnd) {
                for (int i = colEnd; i >= colStart; i--)
                    matrix[rowEnd][i] = currentNum ++;
                rowEnd--;
            }
            if (colStart <= colEnd) {
                for (int i = rowEnd; i >= rowStart; i--)
                    matrix[i][colStart] = currentNum ++;
                colStart++;
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] res = new No59().generateMatrix(4);
        for (int[] nums: res) {
            for (int num: nums) {
                System.out.print(num + " ");
            }
        }
    }
}
