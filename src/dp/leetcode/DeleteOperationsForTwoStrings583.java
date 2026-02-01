package dp.leetcode;

public class DeleteOperationsForTwoStrings583 {
    public static int minDistance(String word1, String word2) {
        int lcs = lcs(word1, word2);
        int a = word1.length() - lcs;
        int b = word2.length() - lcs;
        return a + b;
    }

    private static int lcs(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int dp[][] = new int[n + 1][m + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        System.out.println(minDistance("sea", "eat"));
    }
}
