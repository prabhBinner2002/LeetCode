package dp;

import java.util.ArrayList;
import java.util.List;

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

    public static int tribonacci(int n) {
        if (n == 0) return 0;
        if (n <= 2) return 1;

        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        // int n = 5;
        // int[] f = new int[n + 1];

        // System.out.println(fib(n, f));

        // System.out.println(tribonacci(4));

        int n = 5;

        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        ans.get(0).add(1);

        ans.add(new ArrayList<>());
        ans.get(1).add(1);
        ans.get(1).add(1);

        for (int i = 2; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            row.add(1);
            for (int j = 1; j < i; j++) {
                row.add(ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j));
            }
            row.add(1);
            ans.add(row);
        }

        System.out.println(ans);
    }
}
