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

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,3};
        int i = 1, j = arr.length - 1;
        int[][] dp = new int[arr.length][arr.length];
        Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));
        System.out.println(mcmMemo(arr, i, j, dp));
    }
}
