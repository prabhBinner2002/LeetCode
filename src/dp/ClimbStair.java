package dp;

import java.util.Arrays;

public class ClimbStair {
    public static int countWays(int n, int[] ways) {
        if (n == 0) return 1;
        if (n < 1) return 0;

        if (ways[n] != -1) return ways[n];

        ways[n] = countWays(n - 1, ways) + countWays(n - 2, ways);

        return ways[n];
    }

    public static int countWays3(int n) {
        if (n == 0) return 1;
        if (n < 1) return 0;

        return countWays3(n - 1) + countWays3(n - 2) + countWays3(n - 3);
    }

    public static void main(String[] args) {
        int n = 5;
        int[] ways = new int[n + 1];
        Arrays.fill(ways, -1);
        System.out.println(countWays3(5));
    }
}
