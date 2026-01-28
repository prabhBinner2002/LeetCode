package dp;

import java.util.Arrays;

public class CountBST {
    public static int countBst(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                int leftSubTree = dp[j];
                int rightSubTree = dp[i - j - 1];
                dp[i] += leftSubTree * rightSubTree;
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(countBst(4));
    }
}
