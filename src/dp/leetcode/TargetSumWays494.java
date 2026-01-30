package dp.leetcode;

import java.util.Arrays;

public class TargetSumWays494 {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;

        int sum = Arrays.stream(nums).sum();

        if (Math.abs(target) > sum) return 0;

        if ((sum + target) % 2 != 0) return 0;

        int sumP = (sum + target) / 2;

        int[][] dp = new int[n + 1][sumP + 1];

        dp[0][0] = 1;

        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < sumP + 1; j++) {
                if (nums[i - 1] <= j)
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] + dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        return dp[n][sumP];
    }
}
