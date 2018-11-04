package LeetCode;

import java.util.Map;

public class No64 {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        if (m == 0)
            return 0;
        int n = grid[0].length;
        int[][] res = new int[m][n];

        res[0][0] = grid[0][0];

        for (int j = 1; j < n; j ++) {
            res[0][j] = res[0][j-1] + grid[0][j];
        }

        for (int i = 1; i < m; i ++){
            for (int j = 0; j < n; j ++) {
                if (j == 0) {
                    res[i][j] = res[i-1][j] + grid[i][j];
                }
                else {
                    res[i][j] = Math.min(res[i-1][j] + grid[i][j], res[i][j-1] + grid[i][j]);
                }
            }
        }
        return res[m-1][n-1];
    }
}
