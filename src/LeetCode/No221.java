package LeetCode;

import static Tools.IOTools.print;

public class No221 {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        if (m == 0 || matrix[0].length == 0) return 0;
        int n = matrix[0].length;
        int res = 0;
        int[][] heights = new int[m][n];
        for (int j = 0; j < n; j ++) {
            heights[0][j] = matrix[0][j] - '0';
        }
        for (int i = 1; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                heights[i][j] = matrix[i][j] == '0' ? 0 : heights[i - 1][j] + 1;
            }
        }
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j++) {
                int currHeight = heights[i][j];
//                for (int k = j - currHeight < 0 ? 0 : j - currHeight; k < (j + currHeight > n ? n : j + currHeight); k ++) {
//
//                }
                int width = 1;
                int leftBorder = j - currHeight < 0 ? 0 : j - currHeight;
                int rightBorder = j + currHeight > n ? n : j + currHeight;
                int currIndex = j + 1;
                while (currIndex < rightBorder) {
                    if (heights[i][currIndex] < currHeight) break;
                    width ++;
                    currIndex ++;
                }
                currIndex = j - 1;
                while(currIndex >= leftBorder) {
                    if (heights[i][currIndex] < currHeight) break;
                    width ++;
                    currIndex --;
                }
                res = Math.max(res, Math.min(width, currHeight) * Math.min(width, currHeight));
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        char[][] matrix ={{'0', '1'}, {'0', '1'}};
        print(new No221().maximalSquare(matrix));
    }
}
