package backTracking.assignment;

public class Kinghts {
    public static void printBoard(int[][] board) {
        System.out.println(".".repeat(10));
        int n = board.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isValidUtil(int[][] board, int r, int c, int n, int expVal) {
        if (r < 0 || c < 0 || r >= n || c >= n || board[r][c] != expVal) return false;
        if (expVal == n*n - 1) return true;

        boolean ans1 = isValidUtil(board, r - 2, c - 1, n, expVal + 1);
        boolean ans2 = isValidUtil(board, r - 1, c + 2, n, expVal + 1);
        boolean ans3 = isValidUtil(board, r + 1, c - 2, n, expVal + 1);
        boolean ans4 = isValidUtil(board, r + 2, c + 1, n, expVal + 1);
        boolean ans5 = isValidUtil(board, r + 2, c - 1, n, expVal + 1);
        boolean ans6 = isValidUtil(board, r + 1, c + 2, n, expVal + 1);
        boolean ans7 = isValidUtil(board, r - 1, c - 2, n, expVal + 1);
        boolean ans8 = isValidUtil(board, r - 2, c + 1, n, expVal + 1);

        return ans1 || ans2 || ans3 || ans4 || ans5 || ans6 || ans7 || ans8;
    }

    public static boolean isValid(int[][] board) {
        return isValidUtil(board, 0, 0, board.length, 0);
    }

    public static void main(String[] args) {
        int n = 8;
        int[][] board = {
                {  0, 59, 38, 33, 30, 17,  8, 63 },
                { 37, 34, 31, 60,  9, 62, 29, 16 },
                { 58,  1, 36, 39, 32, 27, 18,  7 },
                { 35, 48, 41, 26, 61, 10, 15, 28 },
                { 42, 57,  2, 49, 40, 23,  6, 19 },
                { 47, 50, 45, 54, 25, 20, 11, 14 },
                { 56, 43, 52,  3, 22, 13, 24,  5 },
                { 51, 46, 55, 44, 53,  4, 21, 12 }
        };
        if (isValid(board)) {
            printBoard(board);
        } else {
            System.out.println("Solution not possible.");
        }
    }
}
