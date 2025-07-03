package backTracking;

public class SudokuSolver {
    public static boolean solveSudoku(int[][] sudoku, int row, int col) {
        // Base Case
        if (row == 9) return true;

        // Recursion
        int nextRow = row, nextCol = col + 1;
        if (nextCol == 9) {
            nextRow = row + 1;
            nextCol = 0;
        }

        if (sudoku[row][col] != 0) {
            return solveSudoku(sudoku, nextRow, nextCol);
        }

        for (int digit = 1; digit <= 9; digit++) {
            if (isSafe(sudoku, row, col, digit)) {
                sudoku[row][col] = digit;
                if (solveSudoku(sudoku, nextRow, nextCol)) {
                    return true;
                }
                sudoku[row][col] = 0;
            }
        }

        return false;
    }

    public static boolean isSafe(int[][] sudoku, int row, int col, int digit) {
        // column
        for (int i = 0; i <= 8; i++)
            if (sudoku[i][col] == digit) return false;

        // row
        for (int j = 0 ; j <= 8; j++)
            if (sudoku[row][j] == digit) return false;

        int sr = (row / 3) * 3;
        int sc = (col / 3) * 3;

        for (int i = sr; i < sr + 3; i++)
            for (int j = sc; j < sc + 3; j++)
                if (sudoku[i][j] == digit) return false;

        return true;
    }

    public static void printSudoku(int[][] sudoku) {
        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku[0].length; j++)
                System.out.print(sudoku[i][j] + " ");
            System.out.println();
        }
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

        if (solveSudoku(mat, 0, 0)) {
            System.out.println("Solution exists.");
            printSudoku(mat);
        } else
            System.out.println("Solution does not exist.");
    }
}
