package dp;

public class fib {
    /*
    Memoization
     */
    public static int fib(int n, int[] f) {
        if (n <= 0) return n;

        if (f[n] != 0) { // Already calculated
            return f[n];
        }

        f[n] = fib(n - 1, f) + fib(n - 2, f); // Calculate the nth fib number

        return f[n];
    }

    /**
     * Fib Tabulation
     *
     * @param n nth index of fib number to find
     * @return nth fib number
     */
    public static int fibTab(int n) {
        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5;
        int[] f = new int[n + 1];

        System.out.println(fib(n, f));
    }
}
