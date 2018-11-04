package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class No52 {
    public int totalNQueens(int n) {
//        return solveNQueens(n).size();
        int[] res = {0};
        int[] currentRes = new int[n];
        backtracking(res, currentRes, 0, n);
        return res[0];
    }

    public void backtracking(int[] res, int[] currentRes, int currentIndex, int n) {
        if (currentIndex == n) {
//            for (int num: currentRes)
//                System.out.println(num);
            res[0] ++;
            return;
        }
        boolean flag = true;
        for (int i = 0; i < n; i ++ ) {
            flag = true;
            for (int j = 0; j < currentIndex; j++) {
                if (i == currentRes[j] || currentRes[j] + currentIndex - j == i || currentRes[j] - currentIndex + j == i)
                    flag = false;
            }
            if (flag) {
                currentRes[currentIndex] = i;
                backtracking(res, currentRes, currentIndex + 1, n);
                currentRes[currentIndex] = 0;
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
//        List<String> currentRes = new ArrayList<>();
//        nQueensIter(res, currentRes, n);
        char[][] currentRes = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                currentRes[i][j] = '.';
            }
        }
        nQueensIterArray(res, currentRes, n, 0);
        return res;
    }

    public void nQueensIterArray(List<List<String>> resList, char[][] currentRes, int n, int currentIndex) {
        if (currentIndex == n) {
            List<String> res = new ArrayList<>();
            for (char[] line: currentRes) {
                res.add(String.valueOf(line));
            }
            resList.add(res);
        }
        for (int i = 0; i < n; i ++) {
            if (isValid(currentRes, i, currentIndex, n)) {
                currentRes[currentIndex][i] = 'Q';
                nQueensIterArray(resList, currentRes, n, currentIndex + 1);
                currentRes[currentIndex][i] = '.';
            }
        }
    }

    public boolean isValid(char[][] currentRes, int colIndex, int currentIndex, int n) {
        for (int i = 0; i < currentIndex; i++) {
            for (int j = 0; j < currentRes.length; j ++) {
//                if (currentRes[i][j] == 'Q' && (j == colIndex || (j + currentIndex - i) % n == colIndex || (j - currentIndex + n + i) % n == colIndex))
                if (currentRes[i][j] == 'Q' && (j == colIndex || (j + currentIndex - i)  == colIndex || (j - currentIndex + i) == colIndex))
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new No52().totalNQueens(4));
    }
}
