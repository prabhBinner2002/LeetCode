package graphs;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean[][] vis = new boolean[image.length][image[0].length];
        helper(image, sr, sc, color, vis, image[sr][sc]);
        return image;
    }

    // O (m * n)
    public void helper(int[][] image, int sr, int sc, int color, boolean[][] vis, int originalColor) {
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || vis[sr][sc] || image[sr][sc] != originalColor)  {
            return;
        }

        vis[sr][sc] = true;
        image[sr][sc] = color;

//        // left
//        helper(image, sr, sc - 1, color, vis, originalColor);
//
//        // right
//        helper(image, sr, sc + 1, color, vis, originalColor);
//
//        // up
//        helper(image, sr - 1, sc, color, vis, originalColor);
//
//        // down
//        helper(image, sr + 1, sc, color, vis, originalColor);

        int[][] moves = {{1,0}, {-1, 0}, {0, -1}, {0, 1}};

        for (int i = 0; i < 4; i++) {
            int nr = sr + moves[i][0];
            int nc = sc + moves[i][1];

            helper(image, nr, nc, color, vis, originalColor);
        }
    }

    public static void main(String[] args) {
        int[][] image = {{1,1,1},{
                          1,1,0},
                         {1,0,1}};
        int sr = 1, sc = 1, color = 2;
        FloodFill fl = new FloodFill();
        fl.floodFill(image, sr, sc, color);
        for (int[] i : image) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
