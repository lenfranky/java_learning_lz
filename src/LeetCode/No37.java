package LeetCode;

public class No37 {
    public void solveSudoku(char[][] board) {
        solveIter(board);
    }

    public boolean solveIter(char[][] board) {
        for (int i =0; i < 9; i ++) {
            for (int j = 0; j < 9; j ++) {
                if (board[i][j] == '.'){
                    for (char currentNum = '0'; currentNum <= '9'; currentNum ++) {
                        if (isValid(board, i, j, currentNum)) {
                            board[i][j] = currentNum;
                            if (solveIter(board))
                                return true;
                            else
                                board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isValid(char[][] board, int row, int column, int currentNum) {
        int start_row = (row / 3) * 3, start_column = (column / 3) * 3;
        for (int i = 0; i < 9; i ++) {
            if (i != column && board[row][i] == currentNum)
                return false;
            if (i != row && board[i][column] == currentNum)
                return false;
            if (start_row + i/3 != row && start_column + i%3 != column && board[start_row + i/3][start_column + i%3] == currentNum)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        No37 solution = new No37();
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        solution.solveSudoku(board);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + "  ");
            }
            System.out.print("\n");
        }
    }
}
