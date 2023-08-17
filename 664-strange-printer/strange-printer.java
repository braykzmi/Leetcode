public class Solution {
    public int strangePrinter(String s) {
        int n = s.length();
        if (n == 0) return 0;

        // dp[i][j] represents the minimum number of operations to print substring s[i:j]
        int[][] dp = new int[n][n];

        // Base case: single character substring needs one operation
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        // Loop for different substring lengths
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                dp[i][j] = len; // Maximum possible value

                // Try all possible breaks to find the optimal solution
                for (int k = i; k < j; k++) {
                    int subProblem = dp[i][k] + dp[k + 1][j];

                    if (s.charAt(k) == s.charAt(j)) {
                        subProblem--; // Overlapping characters, so one less operation needed
                    }

                    dp[i][j] = Math.min(dp[i][j], subProblem);
                }
            }
        }

        return dp[0][n - 1];
    }
}
