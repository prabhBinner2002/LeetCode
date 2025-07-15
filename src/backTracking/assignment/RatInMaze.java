package backTracking.assignment;

import java.util.ArrayList;

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

    public static void paths(int[][] mat, int row, int col, String path, ArrayList<String> ans) {
        int n = mat.length;
        if (row < 0 || col < 0 || row >= n || col >= n || mat[row][col] == 0 || mat[row][col] == -1) {
            return;
        } if (row == n - 1 && col == n - 1) {
            ans.add(path);
        }

        mat[row][col] = -1;
        paths(mat, row + 1, col, path + "D", ans);
        paths(mat, row - 1, col, path + "U", ans);
        paths(mat, row, col - 1, path + "L", ans);
        paths(mat, row, col + 1, path + "R", ans);
        mat[row][col] = 1;
    }

    public static void main(String[] args) {
        int[][] board = {{1,1,1},
                         {1,0,1},
                         {1,1,1}};
        ArrayList<String> ans = new ArrayList<>();
//        getPaths(board, 0, 0, new StringBuilder());
        paths(board, 0 , 0 , "", ans);
        System.out.println(ans);
    }
}
