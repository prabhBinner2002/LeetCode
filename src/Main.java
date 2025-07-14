import java.util.Scanner;

public class Main {

    public static void printBoard(char[][] board) {
        System.out.println(".".repeat(15));
        for(int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
    }

    public static boolean nQueens(char[][] board, int row) {
        if (row == board.length) return true;

        for (int j = 0; j < board.length; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q';
                if (nQueens(board, row + 1)) return true;
                board[row][j] = 'x';
            }
        }

        return false;
    }

    public static boolean isSafe(char[][] board, int row, int col) {
        for (int i = row - 1; i >= 0; i--)
            if (board[i][col] == 'Q') return false;

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 'Q') return false;

        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++)
            if (board[i][j] == 'Q') return false;

        return true;
    }

    public static char[][] makeBoard(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board.length; j++)
                board[i][j] = 'x';
        return board;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Size of the grid: ");
        int n = sc.nextInt();
        char[][] board = makeBoard(n);
        if (nQueens(board, 0)) {
            printBoard(board);
        } else {
            System.out.println("not possible");
        }
    }
}