package LeetCode;

public class No74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        if (target < matrix[0][0] || target > matrix[matrix.length-1][matrix[0].length-1]) return false;
        for (int i = 0; i < matrix.length; i ++) {
            for (int j = 0; j < matrix[0].length; j ++) {
                if (matrix[i][j] == target)
                    return true;
            }
        }
        return false;
    }
}
