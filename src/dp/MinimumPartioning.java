package dp;

import java.util.Arrays;

public class MinimumPartioning {
    public static int getMinimumPartition(int[] arr) {
        int sum = Arrays.stream(arr).sum();

        int n = arr.length;
        int W = sum / 2;

        int[][] dp = new int[n + 1][W + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                if (arr[i - 1] <= j) {
                    int include = arr[i - 1] + dp[i - 1][j - arr[i - 1]];
                    int exclude = dp[i - 1][j];
                    dp[i][j] = Math.max(include, exclude);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        int sum1 = dp[n][W];
        int sum2 = sum - sum1;

        return Math.abs(sum1 - sum2);
    }

    public static void main(String[] args) {
        int[] arr = {1,6,11,5};
        System.out.println(getMinimumPartition(arr));
    }
}
