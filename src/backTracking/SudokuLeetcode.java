package backTracking;

public class SudokuLeetcode {
    public static void printSudoku(char[][] sudoku) {
        System.out.print("[");
        for (int i = 0; i < sudoku.length; i++) {
            System.out.print("[");
            for (int j = 0; j < sudoku[0].length; j++) {
                if (j == sudoku[0].length - 1)
                    System.out.printf("\"%c\"", sudoku[i][j]);
                else
                    System.out.printf("\"%c\",", sudoku[i][j]);
            }
            if (i == sudoku.length - 1)
                System.out.print("]]");
            else
                System.out.print("],");
            System.out.println();
        }
    }

    public static boolean solveSoduke(char[][] sudoku, int row, int col) {
        if (row == 9) return true;

        int newRow = row, newCol = col + 1;
        if (newCol == 9) {
            newRow++;
            newCol = 0;
        }

        if (sudoku[row][col] != '.') {
            return solveSoduke(sudoku, newRow, newCol);
        }

        for (char digit = 1 + '0'; digit <= 9 + '0'; digit++) {
            if (isSafe(sudoku, row, col, digit)) {
                sudoku[row][col] = digit;
                if (solveSoduke(sudoku, newRow, newCol)) return true;
                sudoku[row][col] = '.';
            }
        }

        return false;
    }

    public static boolean isSafe(char[][] board, int row, int col, char digit) {
        for (int j = 0; j <= 8; j++)
            if (board[row][j] == digit) return false;

        for (int i = 0; i <= 8; i++)
            if (board[i][col] == digit) return false;

        int sr = (row / 3) * 3;
        int sc = (col / 3) * 3;

        for (int i = sr ; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (board[i][j] == digit) return false;
            }
        }

        return true;
    }



    public static void main(String[] args) {
        int[][] mat = {
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };

        char[][] board = new char[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = (mat[i][j] == 0) ? '.' : (char) (mat[i][j] + '0');
            }
        }

        if (solveSoduke(board, 0, 0)) {
            printSudoku(board);
        } else {
            System.out.println("nooo");
        }

    }
}
