package dp;

import java.util.Arrays;

public class MarixChainMultiplication {
    public static int mcm(int[] arr, int i, int j) {
        if (i == j) return 0; // Single matrix case

        int ansCost = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int cost1 = mcm(arr, i , k); // Ai ... Ak => arr[i - 1] X arr[k]
            int cost2 = mcm(arr, k + 1, j); // Ak+1 .. Aj => arr[k] X arr[j]
            int cost3 = arr[i - 1] * arr[k] * arr[j]; // cost of result of above matrix multiplications
            int finalCost = cost1 + cost2 + cost3;
            ansCost = Math.min(ansCost, finalCost);
        }

        return ansCost;
    }

    public static int mcmMemo(int[] arr, int i, int j, int[][] dp) {
        if (i == j) return 0; // Single matrix case

        if (dp[i][j] != -1) return dp[i][j];

        int ansCost = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int cost1 = mcmMemo(arr, i , k, dp); // Ai ... Ak => arr[i - 1] X arr[k]
            int cost2 = mcmMemo(arr, k + 1, j, dp); // Ak+1 .. Aj => arr[k] X arr[j]
            int cost3 = arr[i - 1] * arr[k] * arr[j]; // cost of result of above matrix multiplications
            int finalCost = cost1 + cost2 + cost3;
            ansCost = Math.min(ansCost, finalCost);
        }

        dp[i][j] = ansCost;

        return ansCost;
    }

    public static int tab(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];

        // Initialization
        for (int i = 0; i < n; i++)
            dp[i][i] = 0;

        // bottom up
        for (int len = 2; len <= n - 1; len++) {
            for (int i = 1; i <= n - len; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j - 1; k++) {
                    int cost1 = dp[i][k];
                    int cost2 = dp[k + 1][j];
                    int cost3 = arr[i - 1] * arr[k] * arr[j];
                    dp[i][j] = Math.min(dp[i][j], cost1 + cost2 + cost3);
                }
            }
        }

        for(int row[] : dp) {
            for (int val : row) {
                System.out.printf("%2d | ", val);
            }
            System.out.println();
        }

        return dp[1][n - 1];
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,3};
        int i = 1, j = arr.length - 1;
        int[][] dp = new int[arr.length][arr.length];
        Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));
//        System.out.println(mcmMemo(arr, i, j, dp));

        System.out.println(tab(arr));
    }
}
