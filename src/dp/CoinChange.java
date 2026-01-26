package dp;

public class CoinChange {
    public static int coinChange(int[] coins, int sum) {
        int n = coins.length;
        int[][] dp = new int[n + 1][sum + 1];

        for (int i = 0; i < n + 1; i++)
            dp[i][0] = 1;

        for (int i = 1; i < sum + 1; i++) // important in other langs like CPP
            dp[0][i] = 0;

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (coins[i - 1] <= j) {
                    dp[i][j] = dp[i][j - coins[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        for(int[] row: dp) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }

        return dp[n][sum];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int sum = 11;
        System.out.println(coinChange(coins, sum));
    }
}
