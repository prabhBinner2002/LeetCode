package dp;

public class MountainRanges {
    public static int countRanges(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int j = 2; j < n + 1; j++) {
            for (int i = 0; i < j; i++) {
                dp[j] += dp[i] * dp[j - i - 1];
            }
        }

        for (int val : dp) System.out.print(val + " ");

        System.out.println();
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(countRanges(n));
    }
}
