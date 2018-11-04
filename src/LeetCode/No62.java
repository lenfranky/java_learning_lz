package LeetCode;

public class No62 {
    public int uniquePaths(int m, int n) {
        int[][] paths = new int[m][n];
        int currentNum = 0;
        for (int j = 0; j < n; j ++) {
            paths[0][j] = 1;
        }
        for (int i = 1; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                currentNum = 0;
                if (i > 0)
                    currentNum += paths[i -1][j];
                if (j > 0)
                    currentNum += paths[i][j - 1];
                paths[i][j] = currentNum;
            }
        }

        return paths[m-1][n-1];
    }

    public static void main(String[] args) {
        System.out.println(new No62().uniquePaths(3,2));
    }
}
