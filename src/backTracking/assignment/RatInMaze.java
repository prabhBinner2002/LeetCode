package backTracking.assignment;

public class RatInMaze {
    public static void getPaths(int[][] board, int row, int col, StringBuilder path) {
        if (row == board.length - 1 && col == board[0].length - 1) {
            System.out.println(path);
            return;
        } else if (row == board.length || col == board[0].length) return;

        if (isSafe(board, row + 1, col)) {
            getPaths(board, row + 1, col, path.append("D"));
            path.deleteCharAt(path.length() - 1);
        } if (isSafe(board, row, col + 1)) {
            getPaths(board, row, col + 1, path.append("R"));
            path.deleteCharAt(path.length() - 1);
        }
    }

    public static boolean isSafe(int[][] board, int row, int col) {
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] == 0)
            return false;
        return true;
    }

    public static void main(String[] args) {
        int[][] board = {{1,1,1},
                         {1,0,1},
                         {1,1,1}};
        getPaths(board, 0, 0, new StringBuilder());
    }
}
