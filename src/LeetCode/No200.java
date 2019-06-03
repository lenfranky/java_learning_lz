package LeetCode;

import static LeetCode.Tools.print;

public class No200 {
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        boolean[][] visit = new boolean[grid.length][grid[0].length];
        int res = 0;
        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[0].length; j ++) {
                if (visit[i][j]) continue;
                if (grid[i][j] == '1') {
                    bfs(i, j, grid, visit);
                    res ++;
                }
            }
        }
        return res;
    }

    public void bfs(int i, int j, char[][] grid, boolean[][] visit) {
        visit[i][j] = true;
        if (i > 0 && !visit[i - 1][j] && grid[i - 1][j] == '1') bfs(i - 1, j, grid, visit);
        if (j > 0 && !visit[i][j - 1] && grid[i][j - 1] == '1') bfs(i, j - 1, grid, visit);
        if (i <grid.length - 1 && !visit[i + 1][j] && grid[i + 1][j] == '1') bfs(i + 1, j, grid, visit);
        if (j <grid[0].length - 1 && !visit[i][j + 1] && grid[i][j + 1] == '1') bfs(i, j + 1, grid, visit);
    }

    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        print(new No200().numIslands(grid));
    }
}