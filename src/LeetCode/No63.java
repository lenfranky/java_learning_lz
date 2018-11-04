package LeetCode;

// badecase:{{1}}, [[1,0]]
public class No63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if (m == 0)
            return 0;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[m-1][n-1] == 1) {
            return 0;
        }
        int[][] paths = new int[m][n];
        int currentNum = 0;

        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (obstacleGrid[i][j] == 1) {
//                    System.out.println(i + " " + j);
                    paths[i][j] = -1;
                    continue;
                }
                else {
                    paths[i][j] = 0;
                }
            }
        }

//        for (int i = 0; i < m; i ++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(paths[i][j] + " ");
//            }
//            System.out.println();
//        }

        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (paths[i][j] == -1){
                    continue;
                }
                if (i ==0 && j == 0) {
                    paths[i][j] = 1;
                    continue;
                }

                currentNum = 0;
                if (i > 0) {
                    if (paths[i - 1][j] != -1)
                        currentNum += paths[i - 1][j];
                }
                if (j > 0) {
                    if (paths[i][j - 1] != -1)
                        currentNum += paths[i][j - 1];
                }
                paths[i][j] = currentNum;
            }
        }

//        for (int i = 0; i < m; i ++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(paths[i][j] + "");
//            }
//            System.out.println();
//        }

        return paths[m-1][n-1];
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = {{0,0,0}, {0,1,0}, {0,0,0}};
        int[][] obstacleGridTwo = {{1, 0}};
        System.out.println(new No63().uniquePathsWithObstacles(obstacleGrid));
    }
}
