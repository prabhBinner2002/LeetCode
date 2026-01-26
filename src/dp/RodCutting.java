package dp;

public class RodCutting {
    public static int robCutt(int[] length, int[] prices, int totalRod) {
        int n = prices.length;
        int m = length.length;
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                int val = prices[i - 1];
                int wt = length[i - 1];
                if (wt <= j) {
                    int inc = val + dp[i][j - wt];
                    int exc = dp[i - 1][j];
                    dp[i][j] = Math.max(inc, exc);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        int[] length = {1,2,3,4,5,6,7,8};
        int[] prices = {1,5,8,9,10,17,17,20};
        int totalRod = 8;

        System.out.println(robCutt(length, prices, totalRod));
    }
}
