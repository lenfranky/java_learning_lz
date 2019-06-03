package LeetCode;

import java.util.LinkedList;

public class No85 {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0 ||matrix[0].length  == 0) return 0;
        int n = matrix[0].length;

        int res = 0;

        int[][] dp = new int[m][n];

        for (int j = 0; j < n; j ++)
            dp[0][j] = matrix[0][j] - 48;

        for(int i = 1; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                dp[i][j] = matrix[i][j] == 49 ? dp[i - 1][j] + 1 : 0;
            }
        }

        for (int i = 0; i < m; i ++) {
            res = Math.max(res, getEachMaxRectangleWithArray(dp[i]));
        }

        return res;
    }

    public static int getEachMaxRectangle(int[] heights) {
//        int[] areas = new int[heights.length];
        if (heights.length == 0) return 0;
        int res = 0;
        LinkedList<Integer> indexStack = new LinkedList<>();
        indexStack.push(0);

        for (int i = 1; i <= heights.length; i++) {
            int currentHeight = i == heights.length ? 0 : heights[i];
            if (indexStack.isEmpty() || currentHeight >= heights[indexStack.peek()])
                indexStack.push(i);
            else {
                int currHeightIndex = indexStack.pop();
                res = Math.max(res, heights[currHeightIndex] * (i - 1 - (indexStack.isEmpty() ? -1 : indexStack.peek())));
                i --;
            }
        }
        return res;
    }

    // badcase: [0]
    public static int getEachMaxRectangleWithArray(int[] heights) {
        if (heights.length == 0) return 0;
        int res = 0;
        int[] indexArray = new int[heights.length];
        int indexInArray = -1;
        indexInArray ++;
        indexArray[0] = 0;

        for (int i = 1; i <= heights.length; i++) {
            int currentHeight = i == heights.length ? -1 : heights[i];
            if (indexInArray == -1 || currentHeight >= heights[indexArray[indexInArray]])
                indexArray[++ indexInArray] = i;
            else {
                int currHeightIndex = indexArray[indexInArray --];
                res = Math.max(res, heights[currHeightIndex] * (i - 1 - (indexInArray == -1 ? -1 : indexArray[indexInArray])));
                i --;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] lengths = {1, 1, 3, 1};
//        int[] heights = {2,1,5,6,2,3};
        int[] heights = {0};
        char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
//        System.out.println(new No85().getEachMaxRectangleWithArray(heights));
        System.out.println(new No85().maximalRectangle(matrix));
    }
}
