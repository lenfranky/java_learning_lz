package LeetCode;

// 11ms
public class No79 {
    public boolean existOld(char[][] board, String word) {
        if (word.length() == 0) return true;
        if (board.length == 0 || board[0].length == 0) return false;
        boolean[][] usedBoard = new boolean[board.length][board[0].length];
        int[] currentLoc = new int[2];
        char startChar = word.charAt(0);
        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[0].length; j ++) {
                if (board[i][j] == startChar) {
//                    usedBoard = new boolean[board.length][board[0].length];
                    usedBoard[i][j] = true;
                    currentLoc[0] = i;
                    currentLoc[1] = j;
                    if (isValidOld(board, usedBoard, 1, currentLoc, word))
                        return true;
                    usedBoard[i][j] = false;
                }
            }
        }

        return false;
    }

    // 使用回溯法
    public boolean isValidOld(char[][] board, boolean[][] usedBoard, int index, int[] currentLoc, String word) {
        if (index == word.length())
            return true;
        int row = currentLoc[0];
        int col = currentLoc[1];
        char targetChar = word.charAt(index);
        if (row > 0) {
            if (board[row-1][col] == targetChar && !usedBoard[row-1][col]) {
                currentLoc[0] --;
                usedBoard[row-1][col] = true;
                if (isValidOld(board, usedBoard, index+1, currentLoc, word))
                    return true;
                currentLoc[0] ++;
                usedBoard[row-1][col] = false;
            }
        }
        if (col > 0) {
            if (board[row][col-1] == targetChar && !usedBoard[row][col-1]) {
                currentLoc[1] --;
                usedBoard[row][col-1] = true;
                if (isValidOld(board, usedBoard, index+1, currentLoc, word))
                    return true;
                currentLoc[1] ++;
                usedBoard[row][col-1] = false;
            }
        }
        if (row < board.length - 1) {
            if (board[row+1][col] == targetChar && !usedBoard[row+1][col]) {
                currentLoc[0] ++;
                usedBoard[row+1][col] = true;
                if (isValidOld(board, usedBoard, index+1, currentLoc, word))
                    return true;
                currentLoc[0] --;
                usedBoard[row+1][col] = false;
            }
        }
        if (col < board[0].length - 1) {
            if (board[row][col+1] == targetChar && !usedBoard[row][col+1]) {
                currentLoc[1] ++;
                usedBoard[row][col+1] = true;
                if (isValidOld(board, usedBoard, index+1, currentLoc, word))
                    return true;
                currentLoc[1] --;
                usedBoard[row][col+1] = false;
            }
        }
        return false;
    }

    public boolean exist(char[][] board, String word) {
        if (word.length() == 0) return true;
        if (board.length == 0 || board[0].length == 0) return false;
        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[0].length; j++) {
                if(isValid(board, i, j, word, 0))
                        return true;
            }
        }
        return false;
    }

    //A-Z:65 - 90
    //a-z: 97 - 122
    public boolean isValid(char[][] board, int row, int col, String word, int index) {
        if (index == word.length()) return true;
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) return false;
        if (board[row][col] != word.charAt(index)) return false;
        board[row][col] += 26;
        boolean isValid = isValid(board, row-1, col, word, index+1)
                || isValid(board, row+1, col, word, index+1)
                || isValid(board, row, col-1, word, index+1)
                || isValid(board, row, col+1, word, index+1);
        board[row][col] -= 26;
        return isValid;
    }


    public static void main(String[] args) {
//        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A','D','E','E'}};
        char[][] board = {{'a'}};
        System.out.println(new No79().exist(board, "b"));
    }
}
