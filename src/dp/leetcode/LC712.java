package dp.leetcode;

public class LC712 {
    public static int minimumDeleteSum(String s1, String s2) {
        String lcs = lcs(s1, s2);
        int sum1 = getSum(s1, lcs);
        int sum2 = getSum(s2, lcs);

        return sum1 + sum2;
    }

    private static int getSum(String s, String lcs) {
        int i = 0;
        int j = 0;
        int sum = 0;

        while (i < s.length()) {
            if (j != lcs.length() && s.charAt(i) == lcs.charAt(j)) {
                i++;
                j++;
                continue;
            }
            sum += s.charAt(i);
            i++;
        }

        return sum;
    }

    private static String lcs(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int dp[][] = new int[n + 1][m + 1];

        StringBuilder lcs = new StringBuilder();

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        while (n > 0 && m > 0) {
            if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
                lcs.append(s1.charAt(n - 1));
                n--; m--;
            } else {
                if (dp[n - 1][m] > dp[n][m - 1]) n--;
                else m--;
            }
        }

        return lcs.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(minimumDeleteSum("sea", "eat"));
    }
}
