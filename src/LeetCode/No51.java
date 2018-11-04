package LeetCode;

import java.util.*;

public class No51 {
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

    public boolean nQueensIter(List<List<String>> res, List<String> currentRes, int n) {
        if (currentRes.size() == n) {
            res.add(new ArrayList<>(currentRes));
            return true;
        }
        List<Integer> posList = new ArrayList<>();
        Set<Integer> banedPosSet = new HashSet<>();
        int length = 0;
        for (String str: currentRes) {
            char[] currentLine = str.toCharArray();
            for (int i = 0; i <= currentLine.length; i ++) {
                if (currentLine[i] == 'Q') {
                    banedPosSet.add(i);
                    banedPosSet.add((i + currentRes.size() - length) % n);
                    banedPosSet.add((i - currentRes.size() + length + n) % n);
                    break;
                }
            }
            length ++;
        }
        if (banedPosSet.size() == n)
            return false;
        for (int i = 0; i < n; i ++) {
            if (banedPosSet.contains(i))
                continue;
            char[] currentStr = new char[n];
            for (int j = 0; j < n; j ++){
                if (i == j)
                    currentStr[j] = 'Q';
                else
                    currentStr[j] = '.';
            }
            currentRes.add(String.valueOf(currentStr));
            nQueensIter(res, currentRes, n);
            currentRes.remove(currentRes.size() - 1);
        }
        return false;
    }

    public static void main(String[] args) {
//        System.out.println(-5 % 2);
        int n = 4;
        System.out.println(new No51().solveNQueens(n));
    }
}
