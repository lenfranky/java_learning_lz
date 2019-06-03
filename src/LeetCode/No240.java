package LeetCode;

import static Tools.IOTools.print;

public class No240 {
    /*
    采用分治的思想

     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int rowIndex = 0;
        int columnIndex = matrix[0].length - 1;
        int m = matrix.length;

        while(rowIndex < m && columnIndex >= 0) {
            if (target > matrix[rowIndex][columnIndex])
                rowIndex ++;
            else if (target < matrix[rowIndex][columnIndex])
                columnIndex --;
            else
                return true;
        }
        return false;
    }

    public boolean searchMatrixOld(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0 || matrix[0].length == 0) return false;
        int n = matrix[0].length;

        return searchSubMatrix(matrix, 0, m - 1, 0, n - 1, target);
    }

    public boolean searchSubMatrix(int[][] matrix, int rowStartIndex, int rowEndIndex, int columnStartIndex, int columnEndIndex, int target) {
        if (rowStartIndex >= matrix.length || columnStartIndex >= matrix[0].length || rowEndIndex < rowStartIndex || columnEndIndex < columnStartIndex) return false;
        if (rowStartIndex == rowEndIndex) return searchInRow(matrix, columnStartIndex, columnEndIndex, rowStartIndex, target);
        if (columnStartIndex == columnEndIndex) return searchInColumn(matrix, rowStartIndex, rowEndIndex, columnStartIndex, target);

        int range = Math.min(rowEndIndex - rowStartIndex, columnEndIndex - columnStartIndex);
        int i = 0;
        while (i <= range) {
            if (matrix[rowStartIndex + i][columnStartIndex + i] == target) return true;
            if (matrix[rowStartIndex + i][columnStartIndex + i] > target)
                break;
            i ++;
        }
        if (i > range)
            return searchSubMatrix(matrix, rowStartIndex + range, rowEndIndex, columnStartIndex, columnEndIndex, target) || searchSubMatrix(matrix, rowStartIndex, rowEndIndex, columnStartIndex + range, columnEndIndex, target);
        return searchSubMatrix(matrix, rowStartIndex, rowStartIndex + i - 1, columnStartIndex + i, columnEndIndex, target) ||
                searchSubMatrix(matrix, rowStartIndex + i, rowEndIndex, columnStartIndex, columnStartIndex + i - 1, target);
    }

    public boolean searchInColumn(int[][] matrix, int rowStartIndex, int rowEndIndex, int columnIndex, int target) {
        int midRowIndex = (rowStartIndex + rowEndIndex) / 2;
        if (rowStartIndex == rowEndIndex) return matrix[rowStartIndex][columnIndex] == target;
        if (rowEndIndex - rowStartIndex == 1) return matrix[rowStartIndex][columnIndex] == target || matrix[rowEndIndex][columnIndex] == target;
        if (target <= matrix[midRowIndex][columnIndex])
            return searchInColumn(matrix, rowStartIndex, midRowIndex, columnIndex, target);
        else
            return searchInColumn(matrix, midRowIndex + 1, matrix.length - 1, columnIndex, target);
    }

    public boolean searchInRow(int[][] matrix, int columnStartIndex, int columnEndIndex, int rowIndex, int target) {
        int midColumnIndex = (columnStartIndex + columnEndIndex) / 2;
        if (columnStartIndex == columnEndIndex) return matrix[rowIndex][columnStartIndex] == target;
        if (columnEndIndex - columnStartIndex == 1) return matrix[rowIndex][columnStartIndex] == target || matrix[rowIndex][columnEndIndex] == target;
        if (target <= matrix[rowIndex][midColumnIndex])
            return searchInRow(matrix, columnStartIndex, midColumnIndex, rowIndex, target);
        else
            return searchInRow(matrix, midColumnIndex, columnEndIndex, rowIndex, target);
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        int[][] matrix_2 = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        No240 solution = new No240();
//        print(solution.searchInColumn(matrix, 0, 4, 0, 2));
        print(solution.searchMatrix(matrix_2, 15));
    }
}
