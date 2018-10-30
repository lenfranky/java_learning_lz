package LeetCode;

public class No36 {
    public boolean isValidSudoku(char[][] board) {
        for (int i =0; i < 9; i ++) {
            for (int j = 0; j < 9; j ++) {
                if (board[i][j] == '.')
                    continue;
                if(!isValid(board, i, j)) {
//                    System.out.println(i);
//                    System.out.println(j);
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValid(char[][] board, int row, int column) {
        int start_row = (row / 3) * 3, start_column = (column / 3) * 3;
        int currentNum = board[row][column];
        for (int i = 0; i < 9; i ++) {
            if (i != column && board[row][i] == currentNum)
                return false;
            if (i != row && board[i][column] == currentNum)
                return false;
            if (start_row + i/3 != i && start_column + i%3 != column && board[start_row + i/3][start_column + i%3] == currentNum)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        char board[][] = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        No36 solution = new No36();
        System.out.println(solution.isValidSudoku(board));
    }
}
